package aegon.chrome.net.impl;

import aegon.chrome.base.Log;
import aegon.chrome.base.annotations.JNINamespace;
import aegon.chrome.base.annotations.NativeClassQualifiedName;
import aegon.chrome.net.UploadDataProvider;
import aegon.chrome.net.UploadDataSink;
import aegon.chrome.net.impl.VersionSafeCallbacks;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
@JNINamespace("cronet")
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final class CronetUploadDataStream extends UploadDataSink {
    private static final String TAG = "CronetUploadDataStream";
    private ByteBuffer mByteBuffer;
    private long mByteBufferLimit;
    private final VersionSafeCallbacks.UploadDataProviderWrapper mDataProvider;
    private boolean mDestroyAdapterPostponed;
    private final Executor mExecutor;
    private long mLength;
    private Runnable mOnDestroyedCallbackForTesting;
    private long mRemainingLength;
    private final CronetUrlRequest mRequest;
    private long mUploadDataStreamAdapter;
    private final Runnable mReadTask = new Runnable() { // from class: aegon.chrome.net.impl.CronetUploadDataStream.1
        static final /* synthetic */ boolean $assertionsDisabled = false;

        @Override // java.lang.Runnable
        public void run() {
            synchronized (CronetUploadDataStream.this.mLock) {
                if (CronetUploadDataStream.this.mUploadDataStreamAdapter == 0) {
                    return;
                }
                CronetUploadDataStream.this.checkState(3);
                if (CronetUploadDataStream.this.mByteBuffer != null) {
                    CronetUploadDataStream.this.mInWhichUserCallback = 0;
                    try {
                        CronetUploadDataStream.this.checkCallingThread();
                        VersionSafeCallbacks.UploadDataProviderWrapper uploadDataProviderWrapper = CronetUploadDataStream.this.mDataProvider;
                        CronetUploadDataStream cronetUploadDataStream = CronetUploadDataStream.this;
                        uploadDataProviderWrapper.read(cronetUploadDataStream, cronetUploadDataStream.mByteBuffer);
                        return;
                    } catch (Exception e) {
                        CronetUploadDataStream.this.onError(e);
                        return;
                    }
                }
                throw new IllegalStateException("Unexpected readData call. Buffer is null");
            }
        }
    };
    private final Object mLock = new Object();
    private int mInWhichUserCallback = 3;

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    @Retention(RetentionPolicy.SOURCE)
    @interface UserCallback {
        public static final int GET_LENGTH = 2;
        public static final int NOT_IN_CALLBACK = 3;
        public static final int READ = 0;
        public static final int REWIND = 1;
    }

    private native long nativeAttachUploadDataToRequest(long j, long j2);

    private native long nativeCreateAdapterForTesting();

    private native long nativeCreateUploadDataStreamForTesting(long j, long j2);

    @NativeClassQualifiedName("CronetUploadDataStreamAdapter")
    private static native void nativeDestroy(long j);

    @NativeClassQualifiedName("CronetUploadDataStreamAdapter")
    private native void nativeOnReadSucceeded(long j, int i, boolean z);

    @NativeClassQualifiedName("CronetUploadDataStreamAdapter")
    private native void nativeOnRewindSucceeded(long j);

    public CronetUploadDataStream(UploadDataProvider uploadDataProvider, Executor executor, CronetUrlRequest cronetUrlRequest) {
        this.mExecutor = executor;
        this.mDataProvider = new VersionSafeCallbacks.UploadDataProviderWrapper(uploadDataProvider);
        this.mRequest = cronetUrlRequest;
    }

    final void readData(ByteBuffer byteBuffer) {
        this.mByteBuffer = byteBuffer;
        this.mByteBufferLimit = byteBuffer.limit();
        postTaskToExecutor(this.mReadTask);
    }

    final void rewind() {
        postTaskToExecutor(new Runnable() { // from class: aegon.chrome.net.impl.CronetUploadDataStream.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetUploadDataStream.this.mLock) {
                    if (CronetUploadDataStream.this.mUploadDataStreamAdapter == 0) {
                        return;
                    }
                    CronetUploadDataStream.this.checkState(3);
                    CronetUploadDataStream.this.mInWhichUserCallback = 1;
                    try {
                        CronetUploadDataStream.this.checkCallingThread();
                        CronetUploadDataStream.this.mDataProvider.rewind(CronetUploadDataStream.this);
                    } catch (Exception e) {
                        CronetUploadDataStream.this.onError(e);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkCallingThread() {
        this.mRequest.checkCallingThread();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkState(int i) {
        if (this.mInWhichUserCallback != i) {
            throw new IllegalStateException("Expected " + i + ", but was " + this.mInWhichUserCallback);
        }
    }

    final void onUploadDataStreamDestroyed() {
        destroyAdapter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(Throwable th) {
        boolean z;
        synchronized (this.mLock) {
            int i = this.mInWhichUserCallback;
            if (i == 3) {
                throw new IllegalStateException("There is no read or rewind or length check in progress.");
            }
            z = i == 2;
            this.mInWhichUserCallback = 3;
            this.mByteBuffer = null;
            destroyAdapterIfPostponed();
        }
        if (z) {
            try {
                this.mDataProvider.close();
            } catch (Exception e) {
                Log.e(TAG, "Failure closing data provider", e);
            }
        }
        this.mRequest.onUploadException(th);
    }

    @Override // aegon.chrome.net.UploadDataSink
    public final void onReadSucceeded(boolean z) {
        synchronized (this.mLock) {
            checkState(0);
            if (this.mByteBufferLimit != this.mByteBuffer.limit()) {
                throw new IllegalStateException("ByteBuffer limit changed");
            }
            if (z && this.mLength >= 0) {
                throw new IllegalArgumentException("Non-chunked upload can't have last chunk");
            }
            int iPosition = this.mByteBuffer.position();
            long j = this.mRemainingLength - iPosition;
            this.mRemainingLength = j;
            if (j < 0 && this.mLength >= 0) {
                throw new IllegalArgumentException(String.format("Read upload data length %d exceeds expected length %d", Long.valueOf(this.mLength - this.mRemainingLength), Long.valueOf(this.mLength)));
            }
            this.mByteBuffer.position(0);
            this.mByteBuffer = null;
            this.mInWhichUserCallback = 3;
            destroyAdapterIfPostponed();
            long j2 = this.mUploadDataStreamAdapter;
            if (j2 == 0) {
                return;
            }
            nativeOnReadSucceeded(j2, iPosition, z);
        }
    }

    @Override // aegon.chrome.net.UploadDataSink
    public final void onReadError(Exception exc) {
        synchronized (this.mLock) {
            checkState(0);
            onError(exc);
        }
    }

    @Override // aegon.chrome.net.UploadDataSink
    public final void onRewindSucceeded() {
        synchronized (this.mLock) {
            checkState(1);
            this.mInWhichUserCallback = 3;
            this.mRemainingLength = this.mLength;
            long j = this.mUploadDataStreamAdapter;
            if (j == 0) {
                return;
            }
            nativeOnRewindSucceeded(j);
        }
    }

    @Override // aegon.chrome.net.UploadDataSink
    public final void onRewindError(Exception exc) {
        synchronized (this.mLock) {
            checkState(1);
            onError(exc);
        }
    }

    final void postTaskToExecutor(Runnable runnable) {
        try {
            this.mExecutor.execute(runnable);
        } catch (Throwable th) {
            this.mRequest.onUploadException(th);
        }
    }

    private void destroyAdapter() {
        synchronized (this.mLock) {
            if (this.mInWhichUserCallback == 0) {
                this.mDestroyAdapterPostponed = true;
                return;
            }
            long j = this.mUploadDataStreamAdapter;
            if (j == 0) {
                return;
            }
            nativeDestroy(j);
            this.mUploadDataStreamAdapter = 0L;
            Runnable runnable = this.mOnDestroyedCallbackForTesting;
            if (runnable != null) {
                runnable.run();
            }
            postTaskToExecutor(new Runnable() { // from class: aegon.chrome.net.impl.CronetUploadDataStream.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        CronetUploadDataStream.this.checkCallingThread();
                        CronetUploadDataStream.this.mDataProvider.close();
                    } catch (Exception e) {
                        Log.e(CronetUploadDataStream.TAG, "Exception thrown when closing", e);
                    }
                }
            });
        }
    }

    private void destroyAdapterIfPostponed() {
        synchronized (this.mLock) {
            if (this.mInWhichUserCallback == 0) {
                throw new IllegalStateException("Method should not be called when read has not completed.");
            }
            if (this.mDestroyAdapterPostponed) {
                destroyAdapter();
            }
        }
    }

    final void initializeWithRequest() {
        synchronized (this.mLock) {
            this.mInWhichUserCallback = 2;
        }
        try {
            this.mRequest.checkCallingThread();
            long length = this.mDataProvider.getLength();
            this.mLength = length;
            this.mRemainingLength = length;
        } catch (Throwable th) {
            onError(th);
        }
        synchronized (this.mLock) {
            this.mInWhichUserCallback = 3;
        }
    }

    final void attachNativeAdapterToRequest(long j) {
        synchronized (this.mLock) {
            this.mUploadDataStreamAdapter = nativeAttachUploadDataToRequest(j, this.mLength);
        }
    }

    public final long createUploadDataStreamForTesting() {
        long jNativeCreateUploadDataStreamForTesting;
        synchronized (this.mLock) {
            this.mUploadDataStreamAdapter = nativeCreateAdapterForTesting();
            long length = this.mDataProvider.getLength();
            this.mLength = length;
            this.mRemainingLength = length;
            jNativeCreateUploadDataStreamForTesting = nativeCreateUploadDataStreamForTesting(length, this.mUploadDataStreamAdapter);
        }
        return jNativeCreateUploadDataStreamForTesting;
    }

    final void setOnDestroyedCallbackForTesting(Runnable runnable) {
        this.mOnDestroyedCallbackForTesting = runnable;
    }
}
