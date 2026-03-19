package com.lingku.xuanshang.xutils.http;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.m.s.a;
import com.lingku.xuanshang.xutils.common.task.Priority;
import com.lingku.xuanshang.xutils.http.annotation.HttpRequest;
import com.lingku.xuanshang.xutils.http.app.DefaultParamsBuilder;
import com.lingku.xuanshang.xutils.http.app.DefaultRedirectHandler;
import com.lingku.xuanshang.xutils.http.app.HttpRetryHandler;
import com.lingku.xuanshang.xutils.http.app.ParamsBuilder;
import com.lingku.xuanshang.xutils.http.app.RedirectHandler;
import com.lingku.xuanshang.xutils.http.app.RequestTracker;
import com.lingku.xuanshang.xutils.x;
import java.net.Proxy;
import java.util.concurrent.Executor;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class RequestParams extends BaseParams {
    public static final int MAX_FILE_LOAD_WORKER = 10;
    public static final DefaultRedirectHandler l = new DefaultRedirectHandler();
    public long A;
    public Executor B;
    public Priority C;
    public int D;
    public int E;
    public boolean F;
    public boolean G;
    public int H;
    public String I;
    public boolean J;

    /* renamed from: K, reason: collision with root package name */
    public int f773K;
    public HttpRetryHandler L;
    public RequestTracker M;
    public RedirectHandler N;
    public boolean O;
    public HttpRequest m;
    public String n;
    public final String[] o;
    public final String[] p;
    public ParamsBuilder q;
    public String r;
    public String s;
    public SSLSocketFactory t;
    public Context u;
    public Proxy v;
    public HostnameVerifier w;
    public boolean x;
    public String y;
    public long z;

    public RequestParams() {
        this(null, null, null, null);
    }

    public RequestParams(String str) {
        this(str, null, null, null);
    }

    public RequestParams(String str, ParamsBuilder paramsBuilder, String[] strArr, String[] strArr2) {
        this.x = true;
        this.C = Priority.DEFAULT;
        this.D = 15000;
        this.E = 15000;
        this.F = true;
        this.G = false;
        this.H = 2;
        this.J = false;
        this.f773K = 300;
        this.N = l;
        this.O = false;
        if (str != null && paramsBuilder == null) {
            paramsBuilder = new DefaultParamsBuilder();
        }
        this.n = str;
        this.o = strArr;
        this.p = strArr2;
        this.q = paramsBuilder;
        this.u = x.app();
    }

    public final HttpRequest b() {
        if (this.m == null && !this.O) {
            this.O = true;
            Class<?> cls = getClass();
            if (cls != RequestParams.class) {
                this.m = (HttpRequest) cls.getAnnotation(HttpRequest.class);
            }
        }
        return this.m;
    }

    public String getCacheDirName() {
        return this.y;
    }

    public String getCacheKey() {
        if (TextUtils.isEmpty(this.s) && this.q != null) {
            HttpRequest httpRequestB = b();
            this.s = httpRequestB != null ? this.q.buildCacheKey(this, httpRequestB.cacheKeys()) : this.q.buildCacheKey(this, this.p);
        }
        return this.s;
    }

    public long getCacheMaxAge() {
        return this.A;
    }

    public long getCacheSize() {
        return this.z;
    }

    public int getConnectTimeout() {
        return this.D;
    }

    public Context getContext() {
        return this.u;
    }

    public Executor getExecutor() {
        return this.B;
    }

    public HostnameVerifier getHostnameVerifier() {
        return this.w;
    }

    public HttpRetryHandler getHttpRetryHandler() {
        return this.L;
    }

    public int getLoadingUpdateMaxTimeSpan() {
        return this.f773K;
    }

    public int getMaxRetryCount() {
        return this.H;
    }

    public Priority getPriority() {
        return this.C;
    }

    public Proxy getProxy() {
        return this.v;
    }

    public int getReadTimeout() {
        return this.E;
    }

    public RedirectHandler getRedirectHandler() {
        return this.N;
    }

    public RequestTracker getRequestTracker() {
        return this.M;
    }

    public String getSaveFilePath() {
        return this.I;
    }

    public SSLSocketFactory getSslSocketFactory() {
        return this.t;
    }

    public String getUri() {
        return TextUtils.isEmpty(this.r) ? this.n : this.r;
    }

    public boolean isAutoRename() {
        return this.G;
    }

    public boolean isAutoResume() {
        return this.F;
    }

    public boolean isCancelFast() {
        return this.J;
    }

    public boolean isUseCookie() {
        return this.x;
    }

    public void setAutoRename(boolean z) {
        this.G = z;
    }

    public void setAutoResume(boolean z) {
        this.F = z;
    }

    public void setCacheDirName(String str) {
        this.y = str;
    }

    public void setCacheMaxAge(long j) {
        this.A = j;
    }

    public void setCacheSize(long j) {
        this.z = j;
    }

    public void setCancelFast(boolean z) {
        this.J = z;
    }

    public void setConnectTimeout(int i) {
        if (i > 0) {
            this.D = i;
        }
    }

    public void setContext(Context context) {
        this.u = context;
    }

    public void setExecutor(Executor executor) {
        this.B = executor;
    }

    public void setHostnameVerifier(HostnameVerifier hostnameVerifier) {
        this.w = hostnameVerifier;
    }

    public void setHttpRetryHandler(HttpRetryHandler httpRetryHandler) {
        this.L = httpRetryHandler;
    }

    public void setLoadingUpdateMaxTimeSpan(int i) {
        this.f773K = i;
    }

    public void setMaxRetryCount(int i) {
        this.H = i;
    }

    public void setPriority(Priority priority) {
        this.C = priority;
    }

    public void setProxy(Proxy proxy) {
        this.v = proxy;
    }

    public void setReadTimeout(int i) {
        if (i > 0) {
            this.E = i;
        }
    }

    public void setRedirectHandler(RedirectHandler redirectHandler) {
        this.N = redirectHandler;
    }

    public void setRequestTracker(RequestTracker requestTracker) {
        this.M = requestTracker;
    }

    public void setSaveFilePath(String str) {
        this.I = str;
    }

    public void setSslSocketFactory(SSLSocketFactory sSLSocketFactory) {
        this.t = sSLSocketFactory;
    }

    public void setUri(String str) {
        if (TextUtils.isEmpty(this.r)) {
            this.n = str;
        } else {
            this.r = str;
        }
    }

    public void setUseCookie(boolean z) {
        this.x = z;
    }

    @Override // com.lingku.xuanshang.xutils.http.BaseParams
    public String toString() {
        String uri = getUri();
        String string = super.toString();
        if (TextUtils.isEmpty(uri)) {
            return string;
        }
        return uri + (uri.contains("?") ? a.n : "?") + string;
    }
}
