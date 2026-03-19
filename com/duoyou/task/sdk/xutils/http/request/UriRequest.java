package com.duoyou.task.sdk.xutils.http.request;

import com.duoyou.task.sdk.xutils.common.util.LogUtil;
import com.duoyou.task.sdk.xutils.http.ProgressHandler;
import com.duoyou.task.sdk.xutils.http.RequestParams;
import com.duoyou.task.sdk.xutils.http.app.RequestInterceptListener;
import com.duoyou.task.sdk.xutils.http.app.ResponseParser;
import com.duoyou.task.sdk.xutils.http.loader.Loader;
import com.duoyou.task.sdk.xutils.http.loader.LoaderFactory;
import com.duoyou.task.sdk.xutils.x;
import java.io.Closeable;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public abstract class UriRequest implements Closeable {
    public final Loader<?> loader;
    public final RequestParams params;
    public final String queryUrl;
    public ProgressHandler progressHandler = null;
    public ResponseParser responseParser = null;
    public RequestInterceptListener requestInterceptListener = null;

    public abstract void clearCacheHeader();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public abstract void close();

    public abstract String getCacheKey();

    public abstract long getContentLength();

    public abstract String getETag();

    public abstract long getExpiration();

    public abstract long getHeaderFieldDate(String str, long j);

    public abstract InputStream getInputStream();

    public abstract long getLastModified();

    public abstract int getResponseCode();

    public abstract String getResponseHeader(String str);

    public abstract Map<String, List<String>> getResponseHeaders();

    public abstract String getResponseMessage();

    public abstract boolean isLoading();

    public abstract Object loadResultFromCache();

    public abstract void sendRequest();

    public UriRequest(RequestParams requestParams, Type type) {
        this.params = requestParams;
        this.queryUrl = buildQueryUrl(requestParams);
        Loader<?> loader = LoaderFactory.getLoader(type);
        this.loader = loader;
        loader.setParams(requestParams);
    }

    public String buildQueryUrl(RequestParams requestParams) {
        return requestParams.getUri();
    }

    public void setProgressHandler(ProgressHandler progressHandler) {
        this.progressHandler = progressHandler;
        this.loader.setProgressHandler(progressHandler);
    }

    public void setResponseParser(ResponseParser responseParser) {
        this.responseParser = responseParser;
    }

    public void setRequestInterceptListener(RequestInterceptListener requestInterceptListener) {
        this.requestInterceptListener = requestInterceptListener;
    }

    public RequestParams getParams() {
        return this.params;
    }

    public String getRequestUri() {
        return this.queryUrl;
    }

    public Object loadResult() {
        return this.loader.load(this);
    }

    public void save2Cache() {
        x.task().run(new Runnable() { // from class: com.duoyou.task.sdk.xutils.http.request.UriRequest.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    UriRequest uriRequest = UriRequest.this;
                    uriRequest.loader.save2Cache(uriRequest);
                } catch (Throwable th) {
                    LogUtil.e(th.getMessage(), th);
                }
            }
        });
    }

    public String toString() {
        return getRequestUri();
    }
}
