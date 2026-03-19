package com.lingku.xuanshang.xutils.http;

import com.lingku.xuanshang.xutils.common.Callback;
import com.lingku.xuanshang.xutils.common.task.AbsTask;
import com.lingku.xuanshang.xutils.common.task.Priority;
import com.lingku.xuanshang.xutils.common.task.PriorityExecutor;
import com.lingku.xuanshang.xutils.common.util.IOUtil;
import com.lingku.xuanshang.xutils.ex.HttpException;
import com.lingku.xuanshang.xutils.ex.HttpRedirectException;
import com.lingku.xuanshang.xutils.http.app.RedirectHandler;
import com.lingku.xuanshang.xutils.http.app.RequestInterceptListener;
import com.lingku.xuanshang.xutils.http.app.RequestTracker;
import com.lingku.xuanshang.xutils.http.request.UriRequest;
import com.lingku.xuanshang.xutils.http.request.UriRequestFactory;
import com.lingku.xuanshang.xutils.x;
import java.io.Closeable;
import java.io.File;
import java.lang.ref.WeakReference;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class HttpTask<ResultType> extends AbsTask<ResultType> implements ProgressHandler {
    public static final AtomicInteger f = new AtomicInteger(0);
    public static final HashMap<String, WeakReference<HttpTask<?>>> g = new HashMap<>(1);
    public static final PriorityExecutor h = new PriorityExecutor(5, true);
    public static final PriorityExecutor i = new PriorityExecutor(5, true);
    public static final /* synthetic */ boolean j = true;
    public RequestParams k;
    public UriRequest l;
    public Type m;
    public volatile boolean n;
    public final Callback.CommonCallback<ResultType> o;
    public Object p;
    public volatile Boolean q;
    public final Object r;
    public Callback.CacheCallback<ResultType> s;
    public Callback.PrepareCallback t;
    public Callback.ProgressCallback u;
    public RequestInterceptListener v;
    public RequestTracker w;
    public final Executor x;
    public long y;
    public long z;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            HttpTask httpTask = HttpTask.this;
            AtomicInteger atomicInteger = HttpTask.f;
            httpTask.b();
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            HttpTask httpTask = HttpTask.this;
            AtomicInteger atomicInteger = HttpTask.f;
            httpTask.b();
        }
    }

    public final class c {
        public Object a;
        public Throwable b;

        public c() {
        }

        public void a() {
            HttpException httpException;
            int code;
            RedirectHandler redirectHandler;
            try {
                boolean z = false;
                if (File.class == HttpTask.this.m) {
                    synchronized (HttpTask.f) {
                        while (true) {
                            AtomicInteger atomicInteger = HttpTask.f;
                            if (atomicInteger.get() < 10 || HttpTask.this.isCancelled()) {
                                break;
                            }
                            try {
                                atomicInteger.wait(10L);
                            } catch (InterruptedException unused) {
                                z = true;
                            } catch (Throwable unused2) {
                            }
                        }
                    }
                    HttpTask.f.incrementAndGet();
                }
                if (z || HttpTask.this.isCancelled()) {
                    throw new Callback.CancelledException("cancelled before request" + (z ? "(interrupted)" : ""));
                }
                try {
                    HttpTask httpTask = HttpTask.this;
                    httpTask.l.setRequestInterceptListener(httpTask.v);
                    this.a = HttpTask.this.l.loadResult();
                } catch (Throwable th) {
                    this.b = th;
                }
                Throwable th2 = this.b;
                if (th2 != null) {
                    throw th2;
                }
                if (File.class == HttpTask.this.m) {
                    AtomicInteger atomicInteger2 = HttpTask.f;
                    synchronized (atomicInteger2) {
                        atomicInteger2.decrementAndGet();
                        atomicInteger2.notifyAll();
                    }
                }
            } catch (Throwable th3) {
                try {
                    this.b = th3;
                    if ((th3 instanceof HttpException) && (((code = (httpException = th3).getCode()) == 301 || code == 302) && (redirectHandler = HttpTask.this.k.getRedirectHandler()) != null)) {
                        try {
                            RequestParams redirectParams = redirectHandler.getRedirectParams(HttpTask.this.l);
                            if (redirectParams != null) {
                                if (redirectParams.getMethod() == null) {
                                    redirectParams.setMethod(HttpTask.this.k.getMethod());
                                }
                                HttpTask httpTask2 = HttpTask.this;
                                httpTask2.k = redirectParams;
                                httpTask2.l = httpTask2.c();
                                this.b = new HttpRedirectException(code, httpException.getMessage(), httpException.getResult());
                            }
                        } catch (Throwable unused3) {
                            this.b = th3;
                        }
                    }
                    if (File.class == HttpTask.this.m) {
                        AtomicInteger atomicInteger3 = HttpTask.f;
                        synchronized (atomicInteger3) {
                            atomicInteger3.decrementAndGet();
                            atomicInteger3.notifyAll();
                        }
                    }
                } catch (Throwable th4) {
                    if (File.class == HttpTask.this.m) {
                        AtomicInteger atomicInteger4 = HttpTask.f;
                        synchronized (atomicInteger4) {
                            atomicInteger4.decrementAndGet();
                            atomicInteger4.notifyAll();
                        }
                    }
                    throw th4;
                }
            }
        }
    }

    public HttpTask(RequestParams requestParams, Callback.Cancelable cancelable, Callback.CommonCallback<ResultType> commonCallback) {
        super(cancelable);
        this.n = false;
        this.p = null;
        this.q = null;
        this.r = new Object();
        this.z = 300L;
        boolean z = j;
        if (!z && requestParams == null) {
            throw new AssertionError();
        }
        if (!z && commonCallback == null) {
            throw new AssertionError();
        }
        this.k = requestParams;
        this.o = commonCallback;
        if (commonCallback instanceof Callback.CacheCallback) {
            this.s = (Callback.CacheCallback) commonCallback;
        }
        if (commonCallback instanceof Callback.PrepareCallback) {
            this.t = (Callback.PrepareCallback) commonCallback;
        }
        if (commonCallback instanceof Callback.ProgressCallback) {
            this.u = (Callback.ProgressCallback) commonCallback;
        }
        if (commonCallback instanceof RequestInterceptListener) {
            this.v = (RequestInterceptListener) commonCallback;
        }
        RequestTracker requestTracker = requestParams.getRequestTracker();
        requestTracker = requestTracker == null ? commonCallback instanceof RequestTracker ? (RequestTracker) commonCallback : UriRequestFactory.getDefaultTracker() : requestTracker;
        if (requestTracker != null) {
            this.w = new lkxssdk.p0.c(requestTracker);
        }
        this.x = requestParams.getExecutor() != null ? requestParams.getExecutor() : this.s != null ? i : h;
    }

    public final void a() {
        Object obj = this.p;
        if (obj instanceof Closeable) {
            IOUtil.closeQuietly((Closeable) obj);
        }
        this.p = null;
    }

    public final void b() {
        if (File.class == this.m) {
            AtomicInteger atomicInteger = f;
            synchronized (atomicInteger) {
                atomicInteger.notifyAll();
            }
        }
        a();
        IOUtil.closeQuietly(this.l);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0070  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.lingku.xuanshang.xutils.http.request.UriRequest c() throws java.lang.IllegalAccessException, java.lang.InstantiationException {
        /*
            r4 = this;
            com.lingku.xuanshang.xutils.http.RequestParams r0 = r4.k
            java.lang.String r1 = r0.r
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto Lb
            goto L78
        Lb:
            java.lang.String r1 = r0.n
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L23
            com.lingku.xuanshang.xutils.http.annotation.HttpRequest r1 = r0.b()
            if (r1 == 0) goto L1a
            goto L23
        L1a:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "uri is empty && @HttpRequest == null"
            r0.<init>(r1)
            throw r0
        L23:
            java.lang.Class r1 = r0.getClass()
            lkxssdk.p0.a r2 = new lkxssdk.p0.a
            r2.<init>(r0)
            lkxssdk.p0.b.a(r0, r1, r2)
            java.lang.String r1 = r0.n
            r0.r = r1
            com.lingku.xuanshang.xutils.http.annotation.HttpRequest r1 = r0.b()
            if (r1 == 0) goto L5e
            java.lang.Class r2 = r1.builder()
            java.lang.Object r2 = r2.newInstance()
            com.lingku.xuanshang.xutils.http.app.ParamsBuilder r2 = (com.lingku.xuanshang.xutils.http.app.ParamsBuilder) r2
            r0.q = r2
            java.lang.String r2 = r2.buildUri(r0, r1)
            r0.r = r2
            com.lingku.xuanshang.xutils.http.app.ParamsBuilder r2 = r0.q
            r2.buildParams(r0)
            com.lingku.xuanshang.xutils.http.app.ParamsBuilder r2 = r0.q
            java.lang.String[] r1 = r1.signs()
            r2.buildSign(r0, r1)
            javax.net.ssl.SSLSocketFactory r1 = r0.t
            if (r1 != 0) goto L78
            goto L70
        L5e:
            com.lingku.xuanshang.xutils.http.app.ParamsBuilder r1 = r0.q
            if (r1 == 0) goto L78
            r1.buildParams(r0)
            com.lingku.xuanshang.xutils.http.app.ParamsBuilder r1 = r0.q
            java.lang.String[] r2 = r0.o
            r1.buildSign(r0, r2)
            javax.net.ssl.SSLSocketFactory r1 = r0.t
            if (r1 != 0) goto L78
        L70:
            com.lingku.xuanshang.xutils.http.app.ParamsBuilder r1 = r0.q
            javax.net.ssl.SSLSocketFactory r1 = r1.getSSLSocketFactory()
            r0.t = r1
        L78:
            com.lingku.xuanshang.xutils.http.RequestParams r0 = r4.k
            java.lang.reflect.Type r1 = r4.m
            com.lingku.xuanshang.xutils.http.request.UriRequest r0 = com.lingku.xuanshang.xutils.http.request.UriRequestFactory.getUriRequest(r0, r1)
            r0.setProgressHandler(r4)
            com.lingku.xuanshang.xutils.http.RequestParams r1 = r4.k
            int r1 = r1.getLoadingUpdateMaxTimeSpan()
            long r1 = (long) r1
            r4.z = r1
            r1 = 1
            java.lang.Object[] r2 = new java.lang.Object[r1]
            r3 = 0
            r2[r3] = r0
            r4.update(r1, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lingku.xuanshang.xutils.http.HttpTask.c():com.lingku.xuanshang.xutils.http.request.UriRequest");
    }

    @Override // com.lingku.xuanshang.xutils.common.task.AbsTask
    public void cancelWorks() {
        x.task().run(new b());
    }

    /* JADX WARN: Removed duplicated region for block: B:90:0x0160  */
    @Override // com.lingku.xuanshang.xutils.common.task.AbsTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ResultType doBackground() {
        /*
            Method dump skipped, instructions count: 669
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lingku.xuanshang.xutils.http.HttpTask.doBackground():java.lang.Object");
    }

    @Override // com.lingku.xuanshang.xutils.common.task.AbsTask
    public Executor getExecutor() {
        return this.x;
    }

    @Override // com.lingku.xuanshang.xutils.common.task.AbsTask
    public Priority getPriority() {
        return this.k.getPriority();
    }

    @Override // com.lingku.xuanshang.xutils.common.task.AbsTask
    public boolean isCancelFast() {
        return this.k.isCancelFast();
    }

    @Override // com.lingku.xuanshang.xutils.common.task.AbsTask
    public void onCancelled(Callback.CancelledException cancelledException) {
        RequestTracker requestTracker = this.w;
        if (requestTracker != null) {
            requestTracker.onCancelled(this.l);
        }
        this.o.onCancelled(cancelledException);
    }

    @Override // com.lingku.xuanshang.xutils.common.task.AbsTask
    public void onError(Throwable th, boolean z) {
        RequestTracker requestTracker = this.w;
        if (requestTracker != null) {
            requestTracker.onError(this.l, th, z);
        }
        this.o.onError(th, z);
    }

    @Override // com.lingku.xuanshang.xutils.common.task.AbsTask
    public void onFinished() {
        RequestTracker requestTracker = this.w;
        if (requestTracker != null) {
            requestTracker.onFinished(this.l);
        }
        x.task().run(new a());
        this.o.onFinished();
    }

    @Override // com.lingku.xuanshang.xutils.common.task.AbsTask
    public void onStarted() {
        RequestTracker requestTracker = this.w;
        if (requestTracker != null) {
            requestTracker.onStart(this.k);
        }
        Callback.ProgressCallback progressCallback = this.u;
        if (progressCallback != null) {
            progressCallback.onStarted();
        }
    }

    @Override // com.lingku.xuanshang.xutils.common.task.AbsTask
    public void onSuccess(ResultType resulttype) {
        if (this.n) {
            return;
        }
        RequestTracker requestTracker = this.w;
        if (requestTracker != null) {
            requestTracker.onSuccess(this.l, resulttype);
        }
        this.o.onSuccess(resulttype);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lingku.xuanshang.xutils.common.task.AbsTask
    public void onUpdate(int i2, Object... objArr) {
        Callback.ProgressCallback progressCallback;
        if (i2 == 1) {
            RequestTracker requestTracker = this.w;
            if (requestTracker != null) {
                requestTracker.onRequestCreated((UriRequest) objArr[0]);
                return;
            }
            return;
        }
        if (i2 != 2) {
            if (i2 == 3 && (progressCallback = this.u) != null && objArr.length == 3) {
                try {
                    progressCallback.onLoading(((Number) objArr[0]).longValue(), ((Number) objArr[1]).longValue(), ((Boolean) objArr[2]).booleanValue());
                    return;
                } catch (Throwable th) {
                    this.o.onError(th, true);
                    return;
                }
            }
            return;
        }
        synchronized (this.r) {
            try {
                Object obj = objArr[0];
                RequestTracker requestTracker2 = this.w;
                if (requestTracker2 != null) {
                    requestTracker2.onCache(this.l, obj);
                }
                this.q = Boolean.valueOf(this.s.onCache(obj));
            } finally {
                try {
                    this.r.notifyAll();
                } catch (Throwable th2) {
                }
            }
            this.r.notifyAll();
        }
    }

    @Override // com.lingku.xuanshang.xutils.common.task.AbsTask
    public void onWaiting() {
        RequestTracker requestTracker = this.w;
        if (requestTracker != null) {
            requestTracker.onWaiting(this.k);
        }
        Callback.ProgressCallback progressCallback = this.u;
        if (progressCallback != null) {
            progressCallback.onWaiting();
        }
    }

    public String toString() {
        return this.k.toString();
    }

    @Override // com.lingku.xuanshang.xutils.http.ProgressHandler
    public boolean updateProgress(long j2, long j3, boolean z) {
        if (isCancelled() || isFinished()) {
            return false;
        }
        if (this.u != null && this.l != null && j3 > 0) {
            if (j2 < 0) {
                j2 = -1;
            } else if (j2 < j3) {
                j2 = j3;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (z || jCurrentTimeMillis - this.y >= this.z) {
                this.y = jCurrentTimeMillis;
                update(3, Long.valueOf(j2), Long.valueOf(j3), Boolean.valueOf(this.l.isLoading()));
            }
        }
        return (isCancelled() || isFinished()) ? false : true;
    }
}
