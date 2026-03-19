package com.duoyou.task.sdk.xutils.http;

import android.text.TextUtils;
import com.duoyou.task.sdk.xutils.common.Callback;
import com.duoyou.task.sdk.xutils.common.task.AbsTask;
import com.duoyou.task.sdk.xutils.common.task.Priority;
import com.duoyou.task.sdk.xutils.common.task.PriorityExecutor;
import com.duoyou.task.sdk.xutils.common.util.IOUtil;
import com.duoyou.task.sdk.xutils.common.util.ParameterizedTypeUtil;
import com.duoyou.task.sdk.xutils.ex.HttpException;
import com.duoyou.task.sdk.xutils.ex.HttpRedirectException;
import com.duoyou.task.sdk.xutils.http.app.RedirectHandler;
import com.duoyou.task.sdk.xutils.http.app.RequestInterceptListener;
import com.duoyou.task.sdk.xutils.http.app.RequestTracker;
import com.duoyou.task.sdk.xutils.http.request.UriRequest;
import com.duoyou.task.sdk.xutils.http.request.UriRequestFactory;
import com.duoyou.task.sdk.xutils.x;
import java.io.Closeable;
import java.io.File;
import java.lang.ref.WeakReference;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class HttpTask<ResultType> extends AbsTask<ResultType> implements ProgressHandler {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int FLAG_CACHE = 2;
    private static final int FLAG_PROGRESS = 3;
    private static final int FLAG_REQUEST_CREATED = 1;
    private Callback.CacheCallback<ResultType> cacheCallback;
    private final Object cacheLock;
    private final Callback.CommonCallback<ResultType> callback;
    private final Executor executor;
    private volatile boolean hasException;
    private long lastUpdateTime;
    private Type loadType;
    private long loadingUpdateMaxTimeSpan;
    private RequestParams params;
    private Callback.PrepareCallback prepareCallback;
    private Callback.ProgressCallback progressCallback;
    private Object rawResult;
    private UriRequest request;
    private RequestInterceptListener requestInterceptListener;
    private RequestTracker tracker;
    private volatile Boolean trustCache;
    private static final AtomicInteger sCurrFileLoadCount = new AtomicInteger(0);
    private static final HashMap<String, WeakReference<HttpTask<?>>> DOWNLOAD_TASK = new HashMap<>(1);
    private static final PriorityExecutor HTTP_EXECUTOR = new PriorityExecutor(5, true);
    private static final PriorityExecutor CACHE_EXECUTOR = new PriorityExecutor(5, true);

    public HttpTask(RequestParams requestParams, Callback.Cancelable cancelable, Callback.CommonCallback<ResultType> commonCallback) {
        super(cancelable);
        this.hasException = false;
        this.rawResult = null;
        this.trustCache = null;
        this.cacheLock = new Object();
        this.loadingUpdateMaxTimeSpan = 300L;
        this.params = requestParams;
        this.callback = commonCallback;
        if (commonCallback instanceof Callback.CacheCallback) {
            this.cacheCallback = (Callback.CacheCallback) commonCallback;
        }
        if (commonCallback instanceof Callback.PrepareCallback) {
            this.prepareCallback = (Callback.PrepareCallback) commonCallback;
        }
        if (commonCallback instanceof Callback.ProgressCallback) {
            this.progressCallback = (Callback.ProgressCallback) commonCallback;
        }
        if (commonCallback instanceof RequestInterceptListener) {
            this.requestInterceptListener = (RequestInterceptListener) commonCallback;
        }
        RequestTracker requestTracker = requestParams.getRequestTracker();
        if (requestTracker == null) {
            if (commonCallback instanceof RequestTracker) {
                requestTracker = (RequestTracker) commonCallback;
            } else {
                requestTracker = UriRequestFactory.getDefaultTracker();
            }
        }
        if (requestTracker != null) {
            this.tracker = new RequestTrackerWrapper(requestTracker);
        }
        if (requestParams.getExecutor() != null) {
            this.executor = requestParams.getExecutor();
        } else if (this.cacheCallback != null) {
            this.executor = CACHE_EXECUTOR;
        } else {
            this.executor = HTTP_EXECUTOR;
        }
    }

    private void resolveLoadType() {
        Class<?> cls = this.callback.getClass();
        Callback.CommonCallback<ResultType> commonCallback = this.callback;
        if (commonCallback instanceof Callback.TypedCallback) {
            this.loadType = ((Callback.TypedCallback) commonCallback).getLoadType();
        } else if (commonCallback instanceof Callback.PrepareCallback) {
            this.loadType = ParameterizedTypeUtil.getParameterizedType(cls, Callback.PrepareCallback.class, 0);
        } else {
            this.loadType = ParameterizedTypeUtil.getParameterizedType(cls, Callback.CommonCallback.class, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public UriRequest createNewRequest() throws IllegalAccessException, InstantiationException {
        this.params.init();
        UriRequest uriRequest = UriRequestFactory.getUriRequest(this.params, this.loadType);
        uriRequest.setProgressHandler(this);
        this.loadingUpdateMaxTimeSpan = this.params.getLoadingUpdateMaxTimeSpan();
        update(1, uriRequest);
        return uriRequest;
    }

    private void checkDownloadTask() {
        if (File.class == this.loadType) {
            HashMap<String, WeakReference<HttpTask<?>>> map = DOWNLOAD_TASK;
            synchronized (map) {
                String saveFilePath = this.params.getSaveFilePath();
                if (!TextUtils.isEmpty(saveFilePath)) {
                    WeakReference<HttpTask<?>> weakReference = map.get(saveFilePath);
                    if (weakReference != null) {
                        HttpTask<?> httpTask = weakReference.get();
                        if (httpTask != null) {
                            httpTask.cancel();
                            httpTask.closeRequestSync();
                        }
                        map.remove(saveFilePath);
                    }
                    map.put(saveFilePath, new WeakReference<>(this));
                }
                if (map.size() > 10) {
                    Iterator<Map.Entry<String, WeakReference<HttpTask<?>>>> it = map.entrySet().iterator();
                    while (it.hasNext()) {
                        WeakReference<HttpTask<?>> value = it.next().getValue();
                        if (value == null || value.get() == null) {
                            it.remove();
                        }
                    }
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x00da  */
    @Override // com.duoyou.task.sdk.xutils.common.task.AbsTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ResultType doBackground() {
        /*
            Method dump skipped, instructions count: 536
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duoyou.task.sdk.xutils.http.HttpTask.doBackground():java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.duoyou.task.sdk.xutils.common.task.AbsTask
    public void onUpdate(int i, Object... objArr) {
        Callback.ProgressCallback progressCallback;
        if (i == 1) {
            RequestTracker requestTracker = this.tracker;
            if (requestTracker != null) {
                requestTracker.onRequestCreated((UriRequest) objArr[0]);
                return;
            }
            return;
        }
        if (i != 2) {
            if (i == 3 && (progressCallback = this.progressCallback) != null && objArr.length == 3) {
                try {
                    progressCallback.onLoading(((Number) objArr[0]).longValue(), ((Number) objArr[1]).longValue(), ((Boolean) objArr[2]).booleanValue());
                    return;
                } catch (Throwable th) {
                    this.callback.onError(th, true);
                    return;
                }
            }
            return;
        }
        synchronized (this.cacheLock) {
            try {
                Object obj = objArr[0];
                RequestTracker requestTracker2 = this.tracker;
                if (requestTracker2 != null) {
                    requestTracker2.onCache(this.request, obj);
                }
                this.trustCache = Boolean.valueOf(this.cacheCallback.onCache(obj));
            } finally {
                try {
                    this.cacheLock.notifyAll();
                } catch (Throwable th2) {
                }
            }
            this.cacheLock.notifyAll();
        }
    }

    @Override // com.duoyou.task.sdk.xutils.common.task.AbsTask
    public void onWaiting() {
        RequestTracker requestTracker = this.tracker;
        if (requestTracker != null) {
            requestTracker.onWaiting(this.params);
        }
        Callback.ProgressCallback progressCallback = this.progressCallback;
        if (progressCallback != null) {
            progressCallback.onWaiting();
        }
    }

    @Override // com.duoyou.task.sdk.xutils.common.task.AbsTask
    public void onStarted() {
        RequestTracker requestTracker = this.tracker;
        if (requestTracker != null) {
            requestTracker.onStart(this.params);
        }
        Callback.ProgressCallback progressCallback = this.progressCallback;
        if (progressCallback != null) {
            progressCallback.onStarted();
        }
    }

    @Override // com.duoyou.task.sdk.xutils.common.task.AbsTask
    public void onSuccess(ResultType resulttype) {
        if (this.hasException) {
            return;
        }
        RequestTracker requestTracker = this.tracker;
        if (requestTracker != null) {
            requestTracker.onSuccess(this.request, resulttype);
        }
        this.callback.onSuccess(resulttype);
    }

    @Override // com.duoyou.task.sdk.xutils.common.task.AbsTask
    public void onError(Throwable th, boolean z) {
        RequestTracker requestTracker = this.tracker;
        if (requestTracker != null) {
            requestTracker.onError(this.request, th, z);
        }
        this.callback.onError(th, z);
    }

    @Override // com.duoyou.task.sdk.xutils.common.task.AbsTask
    public void onCancelled(Callback.CancelledException cancelledException) {
        RequestTracker requestTracker = this.tracker;
        if (requestTracker != null) {
            requestTracker.onCancelled(this.request);
        }
        this.callback.onCancelled(cancelledException);
    }

    @Override // com.duoyou.task.sdk.xutils.common.task.AbsTask
    public void onFinished() {
        RequestTracker requestTracker = this.tracker;
        if (requestTracker != null) {
            requestTracker.onFinished(this.request);
        }
        x.task().run(new Runnable() { // from class: com.duoyou.task.sdk.xutils.http.HttpTask.1
            @Override // java.lang.Runnable
            public void run() {
                HttpTask.this.closeRequestSync();
            }
        });
        this.callback.onFinished();
    }

    private void clearRawResult() {
        Object obj = this.rawResult;
        if (obj instanceof Closeable) {
            IOUtil.closeQuietly((Closeable) obj);
        }
        this.rawResult = null;
    }

    @Override // com.duoyou.task.sdk.xutils.common.task.AbsTask
    public void cancelWorks() {
        x.task().run(new Runnable() { // from class: com.duoyou.task.sdk.xutils.http.HttpTask.2
            @Override // java.lang.Runnable
            public void run() {
                HttpTask.this.closeRequestSync();
            }
        });
    }

    @Override // com.duoyou.task.sdk.xutils.common.task.AbsTask
    public boolean isCancelFast() {
        return this.params.isCancelFast();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeRequestSync() {
        if (File.class == this.loadType) {
            AtomicInteger atomicInteger = sCurrFileLoadCount;
            synchronized (atomicInteger) {
                atomicInteger.notifyAll();
            }
        }
        clearRawResult();
        IOUtil.closeQuietly(this.request);
    }

    @Override // com.duoyou.task.sdk.xutils.common.task.AbsTask
    public Executor getExecutor() {
        return this.executor;
    }

    @Override // com.duoyou.task.sdk.xutils.common.task.AbsTask
    public Priority getPriority() {
        return this.params.getPriority();
    }

    @Override // com.duoyou.task.sdk.xutils.http.ProgressHandler
    public boolean updateProgress(long j, long j2, boolean z) {
        if (isCancelled() || isFinished()) {
            return false;
        }
        if (this.progressCallback != null && this.request != null && j2 > 0) {
            if (j < 0) {
                j = -1;
            } else if (j < j2) {
                j = j2;
            }
            if (z) {
                this.lastUpdateTime = System.currentTimeMillis();
                update(3, Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(this.request.isLoading()));
            } else {
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (jCurrentTimeMillis - this.lastUpdateTime >= this.loadingUpdateMaxTimeSpan) {
                    this.lastUpdateTime = jCurrentTimeMillis;
                    update(3, Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(this.request.isLoading()));
                }
            }
        }
        return (isCancelled() || isFinished()) ? false : true;
    }

    public String toString() {
        return this.params.toString();
    }

    public final class RequestWorker {
        public Throwable ex;
        public Object result;

        private RequestWorker() {
        }

        public void request() {
            HttpException httpException;
            int code;
            RedirectHandler redirectHandler;
            try {
                boolean z = false;
                if (File.class == HttpTask.this.loadType) {
                    synchronized (HttpTask.sCurrFileLoadCount) {
                        while (HttpTask.sCurrFileLoadCount.get() >= 10 && !HttpTask.this.isCancelled()) {
                            try {
                                HttpTask.sCurrFileLoadCount.wait(10L);
                            } catch (InterruptedException unused) {
                                z = true;
                            } catch (Throwable unused2) {
                            }
                        }
                    }
                    HttpTask.sCurrFileLoadCount.incrementAndGet();
                }
                if (!z && !HttpTask.this.isCancelled()) {
                    try {
                        HttpTask.this.request.setRequestInterceptListener(HttpTask.this.requestInterceptListener);
                        this.result = HttpTask.this.request.loadResult();
                    } catch (Throwable th) {
                        this.ex = th;
                    }
                    Throwable th2 = this.ex;
                    if (th2 == null) {
                        if (File.class == HttpTask.this.loadType) {
                            synchronized (HttpTask.sCurrFileLoadCount) {
                                HttpTask.sCurrFileLoadCount.decrementAndGet();
                                HttpTask.sCurrFileLoadCount.notifyAll();
                            }
                            return;
                        }
                        return;
                    }
                    throw th2;
                }
                throw new Callback.CancelledException("cancelled before request" + (z ? "(interrupted)" : ""));
            } catch (Throwable th3) {
                try {
                    this.ex = th3;
                    if ((th3 instanceof HttpException) && (((code = (httpException = th3).getCode()) == 301 || code == 302) && (redirectHandler = HttpTask.this.params.getRedirectHandler()) != null)) {
                        try {
                            RequestParams redirectParams = redirectHandler.getRedirectParams(HttpTask.this.request);
                            if (redirectParams != null) {
                                if (redirectParams.getMethod() == null) {
                                    redirectParams.setMethod(HttpTask.this.params.getMethod());
                                }
                                HttpTask.this.params = redirectParams;
                                HttpTask httpTask = HttpTask.this;
                                httpTask.request = httpTask.createNewRequest();
                                this.ex = new HttpRedirectException(code, httpException.getMessage(), httpException.getResult());
                            }
                        } catch (Throwable unused3) {
                            this.ex = th3;
                        }
                    }
                    if (File.class == HttpTask.this.loadType) {
                        synchronized (HttpTask.sCurrFileLoadCount) {
                            HttpTask.sCurrFileLoadCount.decrementAndGet();
                            HttpTask.sCurrFileLoadCount.notifyAll();
                        }
                    }
                } catch (Throwable th4) {
                    if (File.class == HttpTask.this.loadType) {
                        synchronized (HttpTask.sCurrFileLoadCount) {
                            HttpTask.sCurrFileLoadCount.decrementAndGet();
                            HttpTask.sCurrFileLoadCount.notifyAll();
                        }
                    }
                    throw th4;
                }
            }
        }
    }
}
