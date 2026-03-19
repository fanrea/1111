package com.duoyou.task.sdk.xutils.http;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.m.s.a;
import com.duoyou.task.sdk.xutils.common.task.Priority;
import com.duoyou.task.sdk.xutils.http.RequestParamsHelper;
import com.duoyou.task.sdk.xutils.http.annotation.HttpRequest;
import com.duoyou.task.sdk.xutils.http.app.DefaultParamsBuilder;
import com.duoyou.task.sdk.xutils.http.app.DefaultRedirectHandler;
import com.duoyou.task.sdk.xutils.http.app.HttpRetryHandler;
import com.duoyou.task.sdk.xutils.http.app.ParamsBuilder;
import com.duoyou.task.sdk.xutils.http.app.RedirectHandler;
import com.duoyou.task.sdk.xutils.http.app.RequestTracker;
import com.duoyou.task.sdk.xutils.x;
import java.net.Proxy;
import java.util.concurrent.Executor;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class RequestParams extends BaseParams {
    private static final DefaultRedirectHandler DEFAULT_REDIRECT_HANDLER = new DefaultRedirectHandler();
    public static final int MAX_FILE_LOAD_WORKER = 10;
    private boolean autoRename;
    private boolean autoResume;
    private String buildCacheKey;
    private String buildUri;
    private ParamsBuilder builder;
    private String cacheDirName;
    private final String[] cacheKeys;
    private long cacheMaxAge;
    private long cacheSize;
    private boolean cancelFast;
    private int connectTimeout;
    private Context context;
    private Executor executor;
    private HostnameVerifier hostnameVerifier;
    private HttpRequest httpRequest;
    private HttpRetryHandler httpRetryHandler;
    private boolean invokedGetHttpRequest;
    private int loadingUpdateMaxTimeSpan;
    private int maxRetryCount;
    private Priority priority;
    private Proxy proxy;
    private int readTimeout;
    private RedirectHandler redirectHandler;
    private RequestTracker requestTracker;
    private String saveFilePath;
    private final String[] signs;
    private SSLSocketFactory sslSocketFactory;
    private String uri;
    private boolean useCookie;

    public RequestParams() {
        this(null, null, null, null);
    }

    public RequestParams(String str) {
        this(str, null, null, null);
    }

    public RequestParams(String str, ParamsBuilder paramsBuilder, String[] strArr, String[] strArr2) {
        this.useCookie = true;
        this.priority = Priority.DEFAULT;
        this.connectTimeout = 15000;
        this.readTimeout = 15000;
        this.autoResume = true;
        this.autoRename = false;
        this.maxRetryCount = 2;
        this.cancelFast = false;
        this.loadingUpdateMaxTimeSpan = 300;
        this.redirectHandler = DEFAULT_REDIRECT_HANDLER;
        this.invokedGetHttpRequest = false;
        if (str != null && paramsBuilder == null) {
            paramsBuilder = new DefaultParamsBuilder();
        }
        this.uri = str;
        this.signs = strArr;
        this.cacheKeys = strArr2;
        this.builder = paramsBuilder;
        this.context = x.app();
    }

    public void init() throws IllegalAccessException, InstantiationException {
        if (TextUtils.isEmpty(this.buildUri)) {
            if (TextUtils.isEmpty(this.uri) && getHttpRequest() == null) {
                throw new IllegalStateException("uri is empty && @HttpRequest == null");
            }
            initEntityParams();
            this.buildUri = this.uri;
            HttpRequest httpRequest = getHttpRequest();
            if (httpRequest != null) {
                ParamsBuilder paramsBuilderNewInstance = httpRequest.builder().newInstance();
                this.builder = paramsBuilderNewInstance;
                this.buildUri = paramsBuilderNewInstance.buildUri(this, httpRequest);
                this.builder.buildParams(this);
                this.builder.buildSign(this, httpRequest.signs());
                if (this.sslSocketFactory == null) {
                    this.sslSocketFactory = this.builder.getSSLSocketFactory();
                    return;
                }
                return;
            }
            ParamsBuilder paramsBuilder = this.builder;
            if (paramsBuilder != null) {
                paramsBuilder.buildParams(this);
                this.builder.buildSign(this, this.signs);
                if (this.sslSocketFactory == null) {
                    this.sslSocketFactory = this.builder.getSSLSocketFactory();
                }
            }
        }
    }

    public String getUri() {
        return TextUtils.isEmpty(this.buildUri) ? this.uri : this.buildUri;
    }

    public void setUri(String str) {
        if (TextUtils.isEmpty(this.buildUri)) {
            this.uri = str;
        } else {
            this.buildUri = str;
        }
    }

    public String getCacheKey() {
        if (TextUtils.isEmpty(this.buildCacheKey) && this.builder != null) {
            HttpRequest httpRequest = getHttpRequest();
            if (httpRequest != null) {
                this.buildCacheKey = this.builder.buildCacheKey(this, httpRequest.cacheKeys());
            } else {
                this.buildCacheKey = this.builder.buildCacheKey(this, this.cacheKeys);
            }
        }
        return this.buildCacheKey;
    }

    public void setSslSocketFactory(SSLSocketFactory sSLSocketFactory) {
        this.sslSocketFactory = sSLSocketFactory;
    }

    public SSLSocketFactory getSslSocketFactory() {
        return this.sslSocketFactory;
    }

    public HostnameVerifier getHostnameVerifier() {
        return this.hostnameVerifier;
    }

    public void setHostnameVerifier(HostnameVerifier hostnameVerifier) {
        this.hostnameVerifier = hostnameVerifier;
    }

    public boolean isUseCookie() {
        return this.useCookie;
    }

    public void setUseCookie(boolean z) {
        this.useCookie = z;
    }

    public Context getContext() {
        return this.context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void setProxy(Proxy proxy) {
        this.proxy = proxy;
    }

    public Priority getPriority() {
        return this.priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public int getConnectTimeout() {
        return this.connectTimeout;
    }

    public void setConnectTimeout(int i) {
        if (i > 0) {
            this.connectTimeout = i;
        }
    }

    public int getReadTimeout() {
        return this.readTimeout;
    }

    public void setReadTimeout(int i) {
        if (i > 0) {
            this.readTimeout = i;
        }
    }

    public String getCacheDirName() {
        return this.cacheDirName;
    }

    public void setCacheDirName(String str) {
        this.cacheDirName = str;
    }

    public long getCacheSize() {
        return this.cacheSize;
    }

    public void setCacheSize(long j) {
        this.cacheSize = j;
    }

    public long getCacheMaxAge() {
        return this.cacheMaxAge;
    }

    public void setCacheMaxAge(long j) {
        this.cacheMaxAge = j;
    }

    public Executor getExecutor() {
        return this.executor;
    }

    public void setExecutor(Executor executor) {
        this.executor = executor;
    }

    public boolean isAutoResume() {
        return this.autoResume;
    }

    public void setAutoResume(boolean z) {
        this.autoResume = z;
    }

    public boolean isAutoRename() {
        return this.autoRename;
    }

    public void setAutoRename(boolean z) {
        this.autoRename = z;
    }

    public String getSaveFilePath() {
        return this.saveFilePath;
    }

    public void setSaveFilePath(String str) {
        this.saveFilePath = str;
    }

    public int getMaxRetryCount() {
        return this.maxRetryCount;
    }

    public void setMaxRetryCount(int i) {
        this.maxRetryCount = i;
    }

    public boolean isCancelFast() {
        return this.cancelFast;
    }

    public void setCancelFast(boolean z) {
        this.cancelFast = z;
    }

    public int getLoadingUpdateMaxTimeSpan() {
        return this.loadingUpdateMaxTimeSpan;
    }

    public void setLoadingUpdateMaxTimeSpan(int i) {
        this.loadingUpdateMaxTimeSpan = i;
    }

    public HttpRetryHandler getHttpRetryHandler() {
        return this.httpRetryHandler;
    }

    public void setHttpRetryHandler(HttpRetryHandler httpRetryHandler) {
        this.httpRetryHandler = httpRetryHandler;
    }

    public RedirectHandler getRedirectHandler() {
        return this.redirectHandler;
    }

    public void setRedirectHandler(RedirectHandler redirectHandler) {
        this.redirectHandler = redirectHandler;
    }

    public RequestTracker getRequestTracker() {
        return this.requestTracker;
    }

    public void setRequestTracker(RequestTracker requestTracker) {
        this.requestTracker = requestTracker;
    }

    private void initEntityParams() {
        RequestParamsHelper.parseKV(this, getClass(), new RequestParamsHelper.ParseKVListener() { // from class: com.duoyou.task.sdk.xutils.http.RequestParams.1
            @Override // com.duoyou.task.sdk.xutils.http.RequestParamsHelper.ParseKVListener
            public void onParseKV(String str, Object obj) {
                RequestParams.this.addParameter(str, obj);
            }
        });
    }

    private HttpRequest getHttpRequest() {
        if (this.httpRequest == null && !this.invokedGetHttpRequest) {
            this.invokedGetHttpRequest = true;
            Class<?> cls = getClass();
            if (cls != RequestParams.class) {
                this.httpRequest = (HttpRequest) cls.getAnnotation(HttpRequest.class);
            }
        }
        return this.httpRequest;
    }

    @Override // com.duoyou.task.sdk.xutils.http.BaseParams
    public String toString() {
        String uri = getUri();
        String string = super.toString();
        if (TextUtils.isEmpty(uri)) {
            return string;
        }
        return uri + (uri.contains("?") ? a.n : "?") + string;
    }
}
