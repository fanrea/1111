package aegon.chrome.net.impl;

import aegon.chrome.net.CronetException;
import aegon.chrome.net.InlineExecutionProhibitedException;
import aegon.chrome.net.ThreadStatsUid;
import aegon.chrome.net.UploadDataProvider;
import aegon.chrome.net.UploadDataSink;
import aegon.chrome.net.UrlRequest;
import aegon.chrome.net.UrlResponseInfo;
import aegon.chrome.net.impl.VersionSafeCallbacks;
import android.net.TrafficStats;
import android.os.Build;
import android.util.Log;
import com.bytedance.applog.log.LogUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationTargetException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URI;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.AbstractMap;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
final class JavaUrlRequest extends UrlRequestBase {
    private static final int DEFAULT_CHUNK_LENGTH = 8192;
    private static final int DEFAULT_UPLOAD_BUFFER_SIZE = 8192;
    private static final String TAG = "JavaUrlRequest";
    private static final String USER_AGENT = "User-Agent";
    private static final String X_ANDROID = "X-Android";
    private static final String X_ANDROID_SELECTED_TRANSPORT = "X-Android-Selected-Transport";
    private final boolean mAllowDirectExecutor;
    private final AsyncUrlRequestCallback mCallbackAsync;
    private String mCurrentUrl;
    private HttpURLConnection mCurrentUrlConnection;
    private final Executor mExecutor;
    private String mInitialMethod;
    private OutputStreamDataSink mOutputStreamDataSink;
    private String mPendingRedirectUrl;
    private ReadableByteChannel mResponseChannel;
    private VersionSafeCallbacks.UploadDataProviderWrapper mUploadDataProvider;
    private Executor mUploadExecutor;
    private UrlResponseInfoImpl mUrlResponseInfo;
    private final String mUserAgent;
    private final Map<String, String> mRequestHeaders = new TreeMap(String.CASE_INSENSITIVE_ORDER);
    private final List<String> mUrlChain = new ArrayList();
    private final AtomicReference<Integer> mState = new AtomicReference<>(0);
    private final AtomicBoolean mUploadProviderClosed = new AtomicBoolean(false);
    private volatile int mAdditionalStatusDetails = -1;

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    interface CheckedRunnable {
        void run();
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    @Retention(RetentionPolicy.SOURCE)
    @interface SinkState {
        public static final int AWAITING_READ_RESULT = 0;
        public static final int AWAITING_REWIND_RESULT = 1;
        public static final int NOT_STARTED = 3;
        public static final int UPLOADING = 2;
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    @Retention(RetentionPolicy.SOURCE)
    @interface State {
        public static final int AWAITING_FOLLOW_REDIRECT = 3;
        public static final int AWAITING_READ = 4;
        public static final int CANCELLED = 8;
        public static final int COMPLETE = 7;
        public static final int ERROR = 6;
        public static final int NOT_STARTED = 0;
        public static final int READING = 5;
        public static final int REDIRECT_RECEIVED = 2;
        public static final int STARTED = 1;
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    static final class SerializingExecutor implements Executor {
        private boolean mRunning;
        private final Executor mUnderlyingExecutor;
        private final Runnable mRunTasks = new Runnable() { // from class: aegon.chrome.net.impl.JavaUrlRequest.SerializingExecutor.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (SerializingExecutor.this.mTaskQueue) {
                    if (SerializingExecutor.this.mRunning) {
                        return;
                    }
                    Runnable runnable = (Runnable) SerializingExecutor.this.mTaskQueue.pollFirst();
                    SerializingExecutor.this.mRunning = runnable != null;
                    while (runnable != null) {
                        try {
                            runnable.run();
                            synchronized (SerializingExecutor.this.mTaskQueue) {
                                runnable = (Runnable) SerializingExecutor.this.mTaskQueue.pollFirst();
                                SerializingExecutor.this.mRunning = runnable != null;
                            }
                        } catch (Throwable th) {
                            synchronized (SerializingExecutor.this.mTaskQueue) {
                                SerializingExecutor.this.mRunning = false;
                                try {
                                    SerializingExecutor.this.mUnderlyingExecutor.execute(SerializingExecutor.this.mRunTasks);
                                } catch (RejectedExecutionException unused) {
                                }
                                throw th;
                            }
                        }
                    }
                }
            }
        };
        private final ArrayDeque<Runnable> mTaskQueue = new ArrayDeque<>();

        SerializingExecutor(Executor executor) {
            this.mUnderlyingExecutor = executor;
        }

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            synchronized (this.mTaskQueue) {
                this.mTaskQueue.addLast(runnable);
                try {
                    this.mUnderlyingExecutor.execute(this.mRunTasks);
                } catch (RejectedExecutionException unused) {
                    this.mTaskQueue.removeLast();
                }
            }
        }
    }

    JavaUrlRequest(UrlRequest.Callback callback, final Executor executor, Executor executor2, String str, String str2, boolean z, boolean z2, int i, final boolean z3, final int i2) {
        if (str == null) {
            throw new NullPointerException("URL is required");
        }
        if (callback == null) {
            throw new NullPointerException("Listener is required");
        }
        if (executor == null) {
            throw new NullPointerException("Executor is required");
        }
        if (executor2 == null) {
            throw new NullPointerException("userExecutor is required");
        }
        this.mAllowDirectExecutor = z;
        this.mCallbackAsync = new AsyncUrlRequestCallback(callback, executor2);
        final int threadStatsTag = z2 ? i : TrafficStats.getThreadStatsTag();
        this.mExecutor = new SerializingExecutor(new Executor() { // from class: aegon.chrome.net.impl.JavaUrlRequest.1
            @Override // java.util.concurrent.Executor
            public void execute(final Runnable runnable) {
                executor.execute(new Runnable() { // from class: aegon.chrome.net.impl.JavaUrlRequest.1.1
                    @Override // java.lang.Runnable
                    public void run() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                        int threadStatsTag2 = TrafficStats.getThreadStatsTag();
                        TrafficStats.setThreadStatsTag(threadStatsTag);
                        if (z3) {
                            ThreadStatsUid.set(i2);
                        }
                        try {
                            runnable.run();
                        } finally {
                            if (z3) {
                                ThreadStatsUid.clear();
                            }
                            TrafficStats.setThreadStatsTag(threadStatsTag2);
                        }
                    }
                });
            }
        });
        this.mCurrentUrl = str;
        this.mUserAgent = str2;
    }

    @Override // aegon.chrome.net.impl.UrlRequestBase
    public final void setHttpMethod(String str) {
        checkNotStarted();
        if (str == null) {
            throw new NullPointerException("Method is required.");
        }
        if ("OPTIONS".equalsIgnoreCase(str) || "GET".equalsIgnoreCase(str) || "HEAD".equalsIgnoreCase(str) || "POST".equalsIgnoreCase(str) || "PUT".equalsIgnoreCase(str) || "DELETE".equalsIgnoreCase(str) || LogUtils.EVENT_TYPE_TRACE.equalsIgnoreCase(str) || "PATCH".equalsIgnoreCase(str)) {
            this.mInitialMethod = str;
            return;
        }
        throw new IllegalArgumentException("Invalid http method " + str);
    }

    private void checkNotStarted() {
        int iIntValue = this.mState.get().intValue();
        if (iIntValue != 0) {
            throw new IllegalStateException("Request is already started. State is: " + iIntValue);
        }
    }

    @Override // aegon.chrome.net.impl.UrlRequestBase
    public final void addHeader(String str, String str2) {
        checkNotStarted();
        if (!isValidHeaderName(str) || str2.contains("\r\n")) {
            throw new IllegalArgumentException("Invalid header " + str + "=" + str2);
        }
        if (this.mRequestHeaders.containsKey(str)) {
            this.mRequestHeaders.remove(str);
        }
        this.mRequestHeaders.put(str, str2);
    }

    private boolean isValidHeaderName(String str) {
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt != ',' && cCharAt != '/' && cCharAt != '{' && cCharAt != '}') {
                switch (cCharAt) {
                    case '\'':
                    case '(':
                    case ')':
                        break;
                    default:
                        switch (cCharAt) {
                            case ':':
                            case ';':
                            case '<':
                            case '=':
                            case '>':
                            case '?':
                            case '@':
                                break;
                            default:
                                switch (cCharAt) {
                                    case '[':
                                    case '\\':
                                    case ']':
                                        break;
                                    default:
                                        if (Character.isISOControl(cCharAt) || Character.isWhitespace(cCharAt)) {
                                            break;
                                        }
                                        break;
                                }
                        }
                }
            }
            return false;
        }
        return true;
    }

    @Override // aegon.chrome.net.impl.UrlRequestBase
    public final void setUploadDataProvider(UploadDataProvider uploadDataProvider, Executor executor) {
        if (uploadDataProvider == null) {
            throw new NullPointerException("Invalid UploadDataProvider.");
        }
        if (!this.mRequestHeaders.containsKey("Content-Type")) {
            throw new IllegalArgumentException("Requests with upload data must have a Content-Type.");
        }
        checkNotStarted();
        if (this.mInitialMethod == null) {
            this.mInitialMethod = "POST";
        }
        this.mUploadDataProvider = new VersionSafeCallbacks.UploadDataProviderWrapper(uploadDataProvider);
        if (this.mAllowDirectExecutor) {
            this.mUploadExecutor = executor;
        } else {
            this.mUploadExecutor = new DirectPreventingExecutor(executor);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    final class OutputStreamDataSink extends UploadDataSink {
        ByteBuffer mBuffer;
        final Executor mExecutor;
        WritableByteChannel mOutputChannel;
        long mTotalBytes;
        final VersionSafeCallbacks.UploadDataProviderWrapper mUploadProvider;
        final HttpURLConnection mUrlConnection;
        OutputStream mUrlConnectionOutputStream;
        final Executor mUserUploadExecutor;
        long mWrittenBytes;
        final AtomicReference<Integer> mSinkState = new AtomicReference<>(3);
        final AtomicBoolean mOutputChannelClosed = new AtomicBoolean(false);

        OutputStreamDataSink(final Executor executor, Executor executor2, HttpURLConnection httpURLConnection, VersionSafeCallbacks.UploadDataProviderWrapper uploadDataProviderWrapper) {
            this.mUserUploadExecutor = new Executor() { // from class: aegon.chrome.net.impl.JavaUrlRequest.OutputStreamDataSink.1
                @Override // java.util.concurrent.Executor
                public void execute(Runnable runnable) {
                    try {
                        executor.execute(runnable);
                    } catch (RejectedExecutionException e) {
                        JavaUrlRequest.this.enterUploadErrorState(e);
                    }
                }
            };
            this.mExecutor = executor2;
            this.mUrlConnection = httpURLConnection;
            this.mUploadProvider = uploadDataProviderWrapper;
        }

        @Override // aegon.chrome.net.UploadDataSink
        public final void onReadSucceeded(final boolean z) {
            if (JavaUrlRequest$$ExternalSyntheticBackportWithForwarding0.m(this.mSinkState, 0, 2)) {
                this.mExecutor.execute(JavaUrlRequest.this.errorSetting(new CheckedRunnable() { // from class: aegon.chrome.net.impl.JavaUrlRequest.OutputStreamDataSink.2
                    @Override // aegon.chrome.net.impl.JavaUrlRequest.CheckedRunnable
                    public void run() throws IOException {
                        OutputStreamDataSink.this.mBuffer.flip();
                        if (OutputStreamDataSink.this.mTotalBytes != -1 && OutputStreamDataSink.this.mTotalBytes - OutputStreamDataSink.this.mWrittenBytes < OutputStreamDataSink.this.mBuffer.remaining()) {
                            JavaUrlRequest.this.enterUploadErrorState(new IllegalArgumentException(String.format("Read upload data length %d exceeds expected length %d", Long.valueOf(OutputStreamDataSink.this.mWrittenBytes + OutputStreamDataSink.this.mBuffer.remaining()), Long.valueOf(OutputStreamDataSink.this.mTotalBytes))));
                            return;
                        }
                        while (OutputStreamDataSink.this.mBuffer.hasRemaining()) {
                            OutputStreamDataSink.this.mWrittenBytes += OutputStreamDataSink.this.mOutputChannel.write(OutputStreamDataSink.this.mBuffer);
                        }
                        OutputStreamDataSink.this.mUrlConnectionOutputStream.flush();
                        if (OutputStreamDataSink.this.mWrittenBytes < OutputStreamDataSink.this.mTotalBytes || (OutputStreamDataSink.this.mTotalBytes == -1 && !z)) {
                            OutputStreamDataSink.this.mBuffer.clear();
                            OutputStreamDataSink.this.mSinkState.set(0);
                            OutputStreamDataSink.this.executeOnUploadExecutor(new CheckedRunnable() { // from class: aegon.chrome.net.impl.JavaUrlRequest.OutputStreamDataSink.2.1
                                @Override // aegon.chrome.net.impl.JavaUrlRequest.CheckedRunnable
                                public void run() {
                                    OutputStreamDataSink.this.mUploadProvider.read(OutputStreamDataSink.this, OutputStreamDataSink.this.mBuffer);
                                }
                            });
                        } else if (OutputStreamDataSink.this.mTotalBytes == -1) {
                            OutputStreamDataSink.this.finish();
                        } else if (OutputStreamDataSink.this.mTotalBytes != OutputStreamDataSink.this.mWrittenBytes) {
                            JavaUrlRequest.this.enterUploadErrorState(new IllegalArgumentException(String.format("Read upload data length %d exceeds expected length %d", Long.valueOf(OutputStreamDataSink.this.mWrittenBytes), Long.valueOf(OutputStreamDataSink.this.mTotalBytes))));
                        } else {
                            OutputStreamDataSink.this.finish();
                        }
                    }
                }));
                return;
            }
            throw new IllegalStateException("Not expecting a read result, expecting: " + this.mSinkState.get());
        }

        @Override // aegon.chrome.net.UploadDataSink
        public final void onRewindSucceeded() {
            if (!JavaUrlRequest$$ExternalSyntheticBackportWithForwarding0.m(this.mSinkState, 1, 2)) {
                throw new IllegalStateException("Not expecting a read result");
            }
            startRead();
        }

        @Override // aegon.chrome.net.UploadDataSink
        public final void onReadError(Exception exc) {
            JavaUrlRequest.this.enterUploadErrorState(exc);
        }

        @Override // aegon.chrome.net.UploadDataSink
        public final void onRewindError(Exception exc) {
            JavaUrlRequest.this.enterUploadErrorState(exc);
        }

        final void startRead() {
            this.mExecutor.execute(JavaUrlRequest.this.errorSetting(new CheckedRunnable() { // from class: aegon.chrome.net.impl.JavaUrlRequest.OutputStreamDataSink.3
                @Override // aegon.chrome.net.impl.JavaUrlRequest.CheckedRunnable
                public void run() {
                    if (OutputStreamDataSink.this.mOutputChannel == null) {
                        JavaUrlRequest.this.mAdditionalStatusDetails = 10;
                        OutputStreamDataSink.this.mUrlConnection.setDoOutput(true);
                        OutputStreamDataSink.this.mUrlConnection.connect();
                        JavaUrlRequest.this.mAdditionalStatusDetails = 12;
                        OutputStreamDataSink outputStreamDataSink = OutputStreamDataSink.this;
                        outputStreamDataSink.mUrlConnectionOutputStream = outputStreamDataSink.mUrlConnection.getOutputStream();
                        OutputStreamDataSink outputStreamDataSink2 = OutputStreamDataSink.this;
                        outputStreamDataSink2.mOutputChannel = Channels.newChannel(outputStreamDataSink2.mUrlConnectionOutputStream);
                    }
                    OutputStreamDataSink.this.mSinkState.set(0);
                    OutputStreamDataSink.this.executeOnUploadExecutor(new CheckedRunnable() { // from class: aegon.chrome.net.impl.JavaUrlRequest.OutputStreamDataSink.3.1
                        @Override // aegon.chrome.net.impl.JavaUrlRequest.CheckedRunnable
                        public void run() {
                            OutputStreamDataSink.this.mUploadProvider.read(OutputStreamDataSink.this, OutputStreamDataSink.this.mBuffer);
                        }
                    });
                }
            }));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void executeOnUploadExecutor(CheckedRunnable checkedRunnable) {
            try {
                this.mUserUploadExecutor.execute(JavaUrlRequest.this.uploadErrorSetting(checkedRunnable));
            } catch (RejectedExecutionException e) {
                JavaUrlRequest.this.enterUploadErrorState(e);
            }
        }

        final void closeOutputChannel() {
            if (this.mOutputChannel == null || !this.mOutputChannelClosed.compareAndSet(false, true)) {
                return;
            }
            this.mOutputChannel.close();
        }

        final void finish() {
            closeOutputChannel();
            JavaUrlRequest.this.fireGetHeaders();
        }

        final void start(final boolean z) {
            executeOnUploadExecutor(new CheckedRunnable() { // from class: aegon.chrome.net.impl.JavaUrlRequest.OutputStreamDataSink.4
                @Override // aegon.chrome.net.impl.JavaUrlRequest.CheckedRunnable
                public void run() {
                    OutputStreamDataSink outputStreamDataSink = OutputStreamDataSink.this;
                    outputStreamDataSink.mTotalBytes = outputStreamDataSink.mUploadProvider.getLength();
                    if (OutputStreamDataSink.this.mTotalBytes == 0) {
                        OutputStreamDataSink.this.finish();
                        return;
                    }
                    if (OutputStreamDataSink.this.mTotalBytes > 0 && OutputStreamDataSink.this.mTotalBytes < 8192) {
                        OutputStreamDataSink outputStreamDataSink2 = OutputStreamDataSink.this;
                        outputStreamDataSink2.mBuffer = ByteBuffer.allocateDirect(((int) outputStreamDataSink2.mTotalBytes) + 1);
                    } else {
                        OutputStreamDataSink.this.mBuffer = ByteBuffer.allocateDirect(8192);
                    }
                    if (OutputStreamDataSink.this.mTotalBytes > 0 && OutputStreamDataSink.this.mTotalBytes <= 2147483647L) {
                        OutputStreamDataSink.this.mUrlConnection.setFixedLengthStreamingMode((int) OutputStreamDataSink.this.mTotalBytes);
                    } else if (OutputStreamDataSink.this.mTotalBytes > 2147483647L && Build.VERSION.SDK_INT >= 19) {
                        OutputStreamDataSink.this.mUrlConnection.setFixedLengthStreamingMode(OutputStreamDataSink.this.mTotalBytes);
                    } else {
                        OutputStreamDataSink.this.mUrlConnection.setChunkedStreamingMode(8192);
                    }
                    if (z) {
                        OutputStreamDataSink.this.startRead();
                    } else {
                        OutputStreamDataSink.this.mSinkState.set(1);
                        OutputStreamDataSink.this.mUploadProvider.rewind(OutputStreamDataSink.this);
                    }
                }
            });
        }
    }

    @Override // aegon.chrome.net.UrlRequest
    public final void start() {
        this.mAdditionalStatusDetails = 10;
        transitionStates(0, 1, new Runnable() { // from class: aegon.chrome.net.impl.JavaUrlRequest.2
            @Override // java.lang.Runnable
            public void run() {
                JavaUrlRequest.this.mUrlChain.add(JavaUrlRequest.this.mCurrentUrl);
                JavaUrlRequest.this.fireOpenConnection();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enterErrorState(CronetException cronetException) {
        if (setTerminalState(6)) {
            fireDisconnect();
            fireCloseUploadDataProvider();
            this.mCallbackAsync.onFailed(this.mUrlResponseInfo, cronetException);
        }
    }

    private boolean setTerminalState(int i) {
        int iIntValue;
        do {
            iIntValue = this.mState.get().intValue();
            if (iIntValue == 0) {
                throw new IllegalStateException("Can't enter error state before start");
            }
            if (iIntValue == 6 || iIntValue == 7 || iIntValue == 8) {
                return false;
            }
        } while (!JavaUrlRequest$$ExternalSyntheticBackportWithForwarding0.m(this.mState, Integer.valueOf(iIntValue), Integer.valueOf(i)));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enterUserErrorState(Throwable th) {
        enterErrorState(new CallbackExceptionImpl("Exception received from UrlRequest.Callback", th));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enterUploadErrorState(Throwable th) {
        enterErrorState(new CallbackExceptionImpl("Exception received from UploadDataProvider", th));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enterCronetErrorState(Throwable th) {
        enterErrorState(new CronetExceptionImpl("System error", th));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void transitionStates(int i, int i2, Runnable runnable) {
        if (!JavaUrlRequest$$ExternalSyntheticBackportWithForwarding0.m(this.mState, Integer.valueOf(i), Integer.valueOf(i2))) {
            int iIntValue = this.mState.get().intValue();
            if (iIntValue != 8 && iIntValue != 6) {
                throw new IllegalStateException("Invalid state transition - expected " + i + " but was " + iIntValue);
            }
            return;
        }
        runnable.run();
    }

    @Override // aegon.chrome.net.UrlRequest
    public final void followRedirect() {
        transitionStates(3, 1, new Runnable() { // from class: aegon.chrome.net.impl.JavaUrlRequest.3
            @Override // java.lang.Runnable
            public void run() {
                JavaUrlRequest javaUrlRequest = JavaUrlRequest.this;
                javaUrlRequest.mCurrentUrl = javaUrlRequest.mPendingRedirectUrl;
                JavaUrlRequest.this.mPendingRedirectUrl = null;
                JavaUrlRequest.this.fireOpenConnection();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fireGetHeaders() {
        this.mAdditionalStatusDetails = 13;
        this.mExecutor.execute(errorSetting(new CheckedRunnable() { // from class: aegon.chrome.net.impl.JavaUrlRequest.4
            @Override // aegon.chrome.net.impl.JavaUrlRequest.CheckedRunnable
            public void run() throws IOException {
                if (JavaUrlRequest.this.mCurrentUrlConnection == null) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                int i = 0;
                String headerField = "http/1.1";
                while (true) {
                    String headerFieldKey = JavaUrlRequest.this.mCurrentUrlConnection.getHeaderFieldKey(i);
                    if (headerFieldKey == null) {
                        break;
                    }
                    if (JavaUrlRequest.X_ANDROID_SELECTED_TRANSPORT.equalsIgnoreCase(headerFieldKey)) {
                        headerField = JavaUrlRequest.this.mCurrentUrlConnection.getHeaderField(i);
                    }
                    if (!headerFieldKey.startsWith(JavaUrlRequest.X_ANDROID)) {
                        arrayList.add(new AbstractMap.SimpleEntry(headerFieldKey, JavaUrlRequest.this.mCurrentUrlConnection.getHeaderField(i)));
                    }
                    i++;
                }
                int responseCode = JavaUrlRequest.this.mCurrentUrlConnection.getResponseCode();
                JavaUrlRequest.this.mUrlResponseInfo = new UrlResponseInfoImpl(new ArrayList(JavaUrlRequest.this.mUrlChain), responseCode, JavaUrlRequest.this.mCurrentUrlConnection.getResponseMessage(), Collections.unmodifiableList(arrayList), false, headerField, "", 0L);
                if (responseCode < 300 || responseCode >= 400) {
                    JavaUrlRequest.this.fireCloseUploadDataProvider();
                    if (responseCode >= 400) {
                        InputStream errorStream = JavaUrlRequest.this.mCurrentUrlConnection.getErrorStream();
                        JavaUrlRequest.this.mResponseChannel = errorStream == null ? null : InputStreamChannel.wrap(errorStream);
                        JavaUrlRequest.this.mCallbackAsync.onResponseStarted(JavaUrlRequest.this.mUrlResponseInfo);
                        return;
                    }
                    JavaUrlRequest javaUrlRequest = JavaUrlRequest.this;
                    javaUrlRequest.mResponseChannel = InputStreamChannel.wrap(javaUrlRequest.mCurrentUrlConnection.getInputStream());
                    JavaUrlRequest.this.mCallbackAsync.onResponseStarted(JavaUrlRequest.this.mUrlResponseInfo);
                    return;
                }
                JavaUrlRequest javaUrlRequest2 = JavaUrlRequest.this;
                javaUrlRequest2.fireRedirectReceived(javaUrlRequest2.mUrlResponseInfo.getAllHeaders());
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fireCloseUploadDataProvider() {
        if (this.mUploadDataProvider == null || !this.mUploadProviderClosed.compareAndSet(false, true)) {
            return;
        }
        try {
            this.mUploadExecutor.execute(uploadErrorSetting(new CheckedRunnable() { // from class: aegon.chrome.net.impl.JavaUrlRequest.5
                @Override // aegon.chrome.net.impl.JavaUrlRequest.CheckedRunnable
                public void run() {
                    JavaUrlRequest.this.mUploadDataProvider.close();
                }
            }));
        } catch (RejectedExecutionException e) {
            Log.e(TAG, "Exception when closing uploadDataProvider", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fireRedirectReceived(final Map<String, List<String>> map) {
        transitionStates(1, 2, new Runnable() { // from class: aegon.chrome.net.impl.JavaUrlRequest.6
            @Override // java.lang.Runnable
            public void run() {
                JavaUrlRequest javaUrlRequest = JavaUrlRequest.this;
                javaUrlRequest.mPendingRedirectUrl = URI.create(javaUrlRequest.mCurrentUrl).resolve((String) ((List) map.get("location")).get(0)).toString();
                JavaUrlRequest.this.mUrlChain.add(JavaUrlRequest.this.mPendingRedirectUrl);
                JavaUrlRequest.this.transitionStates(2, 3, new Runnable() { // from class: aegon.chrome.net.impl.JavaUrlRequest.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        JavaUrlRequest.this.mCallbackAsync.onRedirectReceived(JavaUrlRequest.this.mUrlResponseInfo, JavaUrlRequest.this.mPendingRedirectUrl);
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fireOpenConnection() {
        this.mExecutor.execute(errorSetting(new CheckedRunnable() { // from class: aegon.chrome.net.impl.JavaUrlRequest.7
            @Override // aegon.chrome.net.impl.JavaUrlRequest.CheckedRunnable
            public void run() throws ProtocolException {
                if (((Integer) JavaUrlRequest.this.mState.get()).intValue() == 8) {
                    return;
                }
                URL url = new URL(JavaUrlRequest.this.mCurrentUrl);
                if (JavaUrlRequest.this.mCurrentUrlConnection != null) {
                    JavaUrlRequest.this.mCurrentUrlConnection.disconnect();
                    JavaUrlRequest.this.mCurrentUrlConnection = null;
                }
                JavaUrlRequest.this.mCurrentUrlConnection = (HttpURLConnection) url.openConnection();
                JavaUrlRequest.this.mCurrentUrlConnection.setInstanceFollowRedirects(false);
                if (!JavaUrlRequest.this.mRequestHeaders.containsKey("User-Agent")) {
                    JavaUrlRequest.this.mRequestHeaders.put("User-Agent", JavaUrlRequest.this.mUserAgent);
                }
                for (Map.Entry entry : JavaUrlRequest.this.mRequestHeaders.entrySet()) {
                    JavaUrlRequest.this.mCurrentUrlConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                }
                if (JavaUrlRequest.this.mInitialMethod == null) {
                    JavaUrlRequest.this.mInitialMethod = "GET";
                }
                JavaUrlRequest.this.mCurrentUrlConnection.setRequestMethod(JavaUrlRequest.this.mInitialMethod);
                if (JavaUrlRequest.this.mUploadDataProvider == null) {
                    JavaUrlRequest.this.mAdditionalStatusDetails = 10;
                    JavaUrlRequest.this.mCurrentUrlConnection.connect();
                    JavaUrlRequest.this.fireGetHeaders();
                } else {
                    JavaUrlRequest javaUrlRequest = JavaUrlRequest.this;
                    JavaUrlRequest javaUrlRequest2 = JavaUrlRequest.this;
                    javaUrlRequest.mOutputStreamDataSink = javaUrlRequest2.new OutputStreamDataSink(javaUrlRequest2.mUploadExecutor, JavaUrlRequest.this.mExecutor, JavaUrlRequest.this.mCurrentUrlConnection, JavaUrlRequest.this.mUploadDataProvider);
                    JavaUrlRequest.this.mOutputStreamDataSink.start(JavaUrlRequest.this.mUrlChain.size() == 1);
                }
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Runnable errorSetting(final CheckedRunnable checkedRunnable) {
        return new Runnable() { // from class: aegon.chrome.net.impl.JavaUrlRequest.8
            @Override // java.lang.Runnable
            public void run() {
                try {
                    checkedRunnable.run();
                } catch (Throwable th) {
                    JavaUrlRequest.this.enterCronetErrorState(th);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Runnable userErrorSetting(final CheckedRunnable checkedRunnable) {
        return new Runnable() { // from class: aegon.chrome.net.impl.JavaUrlRequest.9
            @Override // java.lang.Runnable
            public void run() {
                try {
                    checkedRunnable.run();
                } catch (Throwable th) {
                    JavaUrlRequest.this.enterUserErrorState(th);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Runnable uploadErrorSetting(final CheckedRunnable checkedRunnable) {
        return new Runnable() { // from class: aegon.chrome.net.impl.JavaUrlRequest.10
            @Override // java.lang.Runnable
            public void run() {
                try {
                    checkedRunnable.run();
                } catch (Throwable th) {
                    JavaUrlRequest.this.enterUploadErrorState(th);
                }
            }
        };
    }

    @Override // aegon.chrome.net.UrlRequest
    public final void read(final ByteBuffer byteBuffer) {
        Preconditions.checkDirect(byteBuffer);
        Preconditions.checkHasRemaining(byteBuffer);
        transitionStates(4, 5, new Runnable() { // from class: aegon.chrome.net.impl.JavaUrlRequest.11
            @Override // java.lang.Runnable
            public void run() {
                JavaUrlRequest.this.mExecutor.execute(JavaUrlRequest.this.errorSetting(new CheckedRunnable() { // from class: aegon.chrome.net.impl.JavaUrlRequest.11.1
                    @Override // aegon.chrome.net.impl.JavaUrlRequest.CheckedRunnable
                    public void run() {
                        JavaUrlRequest.this.processReadResult(JavaUrlRequest.this.mResponseChannel == null ? -1 : JavaUrlRequest.this.mResponseChannel.read(byteBuffer), byteBuffer);
                    }
                }));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processReadResult(int i, ByteBuffer byteBuffer) {
        if (i != -1) {
            this.mCallbackAsync.onReadCompleted(this.mUrlResponseInfo, byteBuffer);
            return;
        }
        ReadableByteChannel readableByteChannel = this.mResponseChannel;
        if (readableByteChannel != null) {
            readableByteChannel.close();
        }
        if (JavaUrlRequest$$ExternalSyntheticBackportWithForwarding0.m(this.mState, 5, 7)) {
            fireDisconnect();
            this.mCallbackAsync.onSucceeded(this.mUrlResponseInfo);
        }
    }

    private void fireDisconnect() {
        this.mExecutor.execute(new Runnable() { // from class: aegon.chrome.net.impl.JavaUrlRequest.12
            @Override // java.lang.Runnable
            public void run() {
                if (JavaUrlRequest.this.mOutputStreamDataSink != null) {
                    try {
                        JavaUrlRequest.this.mOutputStreamDataSink.closeOutputChannel();
                    } catch (IOException e) {
                        Log.e(JavaUrlRequest.TAG, "Exception when closing OutputChannel", e);
                    }
                }
                if (JavaUrlRequest.this.mCurrentUrlConnection != null) {
                    JavaUrlRequest.this.mCurrentUrlConnection.disconnect();
                    JavaUrlRequest.this.mCurrentUrlConnection = null;
                }
            }
        });
    }

    @Override // aegon.chrome.net.UrlRequest
    public final void cancel() {
        int iIntValue = this.mState.getAndSet(8).intValue();
        if (iIntValue == 1 || iIntValue == 2 || iIntValue == 3 || iIntValue == 4 || iIntValue == 5) {
            fireDisconnect();
            fireCloseUploadDataProvider();
            this.mCallbackAsync.onCanceled(this.mUrlResponseInfo);
        }
    }

    @Override // aegon.chrome.net.UrlRequest
    public final boolean isDone() {
        int iIntValue = this.mState.get().intValue();
        return iIntValue == 7 || iIntValue == 6 || iIntValue == 8;
    }

    @Override // aegon.chrome.net.UrlRequest
    public final void getStatus(UrlRequest.StatusListener statusListener) {
        int iIntValue = this.mState.get().intValue();
        int i = this.mAdditionalStatusDetails;
        switch (iIntValue) {
            case 0:
            case 6:
            case 7:
            case 8:
                i = -1;
                break;
            case 1:
                break;
            case 2:
            case 3:
            case 4:
                i = 0;
                break;
            case 5:
                i = 14;
                break;
            default:
                throw new IllegalStateException("Switch is exhaustive: " + iIntValue);
        }
        this.mCallbackAsync.sendStatus(new VersionSafeCallbacks.UrlRequestStatusListener(statusListener), i);
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    final class AsyncUrlRequestCallback {
        final VersionSafeCallbacks.UrlRequestCallback mCallback;
        final Executor mFallbackExecutor;
        final Executor mUserExecutor;

        AsyncUrlRequestCallback(UrlRequest.Callback callback, Executor executor) {
            this.mCallback = new VersionSafeCallbacks.UrlRequestCallback(callback);
            if (JavaUrlRequest.this.mAllowDirectExecutor) {
                this.mUserExecutor = executor;
                this.mFallbackExecutor = null;
            } else {
                this.mUserExecutor = new DirectPreventingExecutor(executor);
                this.mFallbackExecutor = executor;
            }
        }

        final void sendStatus(final VersionSafeCallbacks.UrlRequestStatusListener urlRequestStatusListener, final int i) {
            this.mUserExecutor.execute(new Runnable() { // from class: aegon.chrome.net.impl.JavaUrlRequest.AsyncUrlRequestCallback.1
                @Override // java.lang.Runnable
                public void run() {
                    urlRequestStatusListener.onStatus(i);
                }
            });
        }

        final void execute(CheckedRunnable checkedRunnable) {
            try {
                this.mUserExecutor.execute(JavaUrlRequest.this.userErrorSetting(checkedRunnable));
            } catch (RejectedExecutionException e) {
                JavaUrlRequest.this.enterErrorState(new CronetExceptionImpl("Exception posting task to executor", e));
            }
        }

        final void onRedirectReceived(final UrlResponseInfo urlResponseInfo, final String str) {
            execute(new CheckedRunnable() { // from class: aegon.chrome.net.impl.JavaUrlRequest.AsyncUrlRequestCallback.2
                @Override // aegon.chrome.net.impl.JavaUrlRequest.CheckedRunnable
                public void run() {
                    AsyncUrlRequestCallback.this.mCallback.onRedirectReceived(JavaUrlRequest.this, urlResponseInfo, str);
                }
            });
        }

        final void onResponseStarted(UrlResponseInfo urlResponseInfo) {
            execute(new CheckedRunnable() { // from class: aegon.chrome.net.impl.JavaUrlRequest.AsyncUrlRequestCallback.3
                @Override // aegon.chrome.net.impl.JavaUrlRequest.CheckedRunnable
                public void run() {
                    if (JavaUrlRequest$$ExternalSyntheticBackportWithForwarding0.m(JavaUrlRequest.this.mState, 1, 4)) {
                        AsyncUrlRequestCallback.this.mCallback.onResponseStarted(JavaUrlRequest.this, JavaUrlRequest.this.mUrlResponseInfo);
                    }
                }
            });
        }

        final void onReadCompleted(final UrlResponseInfo urlResponseInfo, final ByteBuffer byteBuffer) {
            execute(new CheckedRunnable() { // from class: aegon.chrome.net.impl.JavaUrlRequest.AsyncUrlRequestCallback.4
                @Override // aegon.chrome.net.impl.JavaUrlRequest.CheckedRunnable
                public void run() {
                    if (JavaUrlRequest$$ExternalSyntheticBackportWithForwarding0.m(JavaUrlRequest.this.mState, 5, 4)) {
                        AsyncUrlRequestCallback.this.mCallback.onReadCompleted(JavaUrlRequest.this, urlResponseInfo, byteBuffer);
                    }
                }
            });
        }

        final void onCanceled(final UrlResponseInfo urlResponseInfo) {
            JavaUrlRequest.this.closeResponseChannel();
            this.mUserExecutor.execute(new Runnable() { // from class: aegon.chrome.net.impl.JavaUrlRequest.AsyncUrlRequestCallback.5
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        AsyncUrlRequestCallback.this.mCallback.onCanceled(JavaUrlRequest.this, urlResponseInfo);
                    } catch (Exception e) {
                        Log.e(JavaUrlRequest.TAG, "Exception in onCanceled method", e);
                    }
                }
            });
        }

        final void onSucceeded(final UrlResponseInfo urlResponseInfo) {
            this.mUserExecutor.execute(new Runnable() { // from class: aegon.chrome.net.impl.JavaUrlRequest.AsyncUrlRequestCallback.6
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        AsyncUrlRequestCallback.this.mCallback.onSucceeded(JavaUrlRequest.this, urlResponseInfo);
                    } catch (Exception e) {
                        Log.e(JavaUrlRequest.TAG, "Exception in onSucceeded method", e);
                    }
                }
            });
        }

        final void onFailed(final UrlResponseInfo urlResponseInfo, final CronetException cronetException) {
            JavaUrlRequest.this.closeResponseChannel();
            Runnable runnable = new Runnable() { // from class: aegon.chrome.net.impl.JavaUrlRequest.AsyncUrlRequestCallback.7
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        AsyncUrlRequestCallback.this.mCallback.onFailed(JavaUrlRequest.this, urlResponseInfo, cronetException);
                    } catch (Exception e) {
                        Log.e(JavaUrlRequest.TAG, "Exception in onFailed method", e);
                    }
                }
            };
            try {
                this.mUserExecutor.execute(runnable);
            } catch (InlineExecutionProhibitedException unused) {
                Executor executor = this.mFallbackExecutor;
                if (executor != null) {
                    executor.execute(runnable);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeResponseChannel() {
        this.mExecutor.execute(new Runnable() { // from class: aegon.chrome.net.impl.JavaUrlRequest.13
            @Override // java.lang.Runnable
            public void run() {
                if (JavaUrlRequest.this.mResponseChannel != null) {
                    try {
                        JavaUrlRequest.this.mResponseChannel.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    JavaUrlRequest.this.mResponseChannel = null;
                }
            }
        });
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    static final class DirectPreventingExecutor implements Executor {
        private final Executor mDelegate;

        DirectPreventingExecutor(Executor executor) {
            this.mDelegate = executor;
        }

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            InlineCheckingRunnable inlineCheckingRunnable = new InlineCheckingRunnable(runnable, Thread.currentThread());
            this.mDelegate.execute(inlineCheckingRunnable);
            if (inlineCheckingRunnable.mExecutedInline == null) {
                inlineCheckingRunnable.mCallingThread = null;
                return;
            }
            throw inlineCheckingRunnable.mExecutedInline;
        }

        /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
        static final class InlineCheckingRunnable implements Runnable {
            private Thread mCallingThread;
            private final Runnable mCommand;
            private InlineExecutionProhibitedException mExecutedInline;

            private InlineCheckingRunnable(Runnable runnable, Thread thread) {
                this.mCommand = runnable;
                this.mCallingThread = thread;
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (Thread.currentThread() == this.mCallingThread) {
                    this.mExecutedInline = new InlineExecutionProhibitedException();
                } else {
                    this.mCommand.run();
                }
            }
        }
    }
}
