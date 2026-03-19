package com.duoyou.task.sdk.xutils.http.request;

import com.duoyou.task.sdk.xutils.common.util.IOUtil;
import com.duoyou.task.sdk.xutils.http.RequestParams;
import com.duoyou.task.sdk.xutils.http.loader.FileLoader;
import com.duoyou.task.sdk.xutils.http.loader.Loader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class LocalFileRequest extends UriRequest {
    private InputStream inputStream;

    @Override // com.duoyou.task.sdk.xutils.http.request.UriRequest
    public void clearCacheHeader() {
    }

    @Override // com.duoyou.task.sdk.xutils.http.request.UriRequest
    public String getETag() {
        return null;
    }

    @Override // com.duoyou.task.sdk.xutils.http.request.UriRequest
    public long getExpiration() {
        return -1L;
    }

    @Override // com.duoyou.task.sdk.xutils.http.request.UriRequest
    public long getHeaderFieldDate(String str, long j) {
        return j;
    }

    @Override // com.duoyou.task.sdk.xutils.http.request.UriRequest
    public String getResponseHeader(String str) {
        return null;
    }

    @Override // com.duoyou.task.sdk.xutils.http.request.UriRequest
    public Map<String, List<String>> getResponseHeaders() {
        return null;
    }

    @Override // com.duoyou.task.sdk.xutils.http.request.UriRequest
    public String getResponseMessage() {
        return null;
    }

    @Override // com.duoyou.task.sdk.xutils.http.request.UriRequest
    public boolean isLoading() {
        return true;
    }

    @Override // com.duoyou.task.sdk.xutils.http.request.UriRequest
    public Object loadResultFromCache() {
        return null;
    }

    @Override // com.duoyou.task.sdk.xutils.http.request.UriRequest
    public void save2Cache() {
    }

    @Override // com.duoyou.task.sdk.xutils.http.request.UriRequest
    public void sendRequest() {
    }

    public LocalFileRequest(RequestParams requestParams, Type type) {
        super(requestParams, type);
    }

    @Override // com.duoyou.task.sdk.xutils.http.request.UriRequest
    public String getCacheKey() {
        return this.queryUrl;
    }

    @Override // com.duoyou.task.sdk.xutils.http.request.UriRequest
    public Object loadResult() {
        Loader<?> loader = this.loader;
        if (loader instanceof FileLoader) {
            return getFile();
        }
        return loader.load(this);
    }

    private File getFile() {
        String strSubstring;
        if (this.queryUrl.startsWith("file:")) {
            strSubstring = this.queryUrl.substring(5);
        } else {
            strSubstring = this.queryUrl;
        }
        return new File(strSubstring);
    }

    @Override // com.duoyou.task.sdk.xutils.http.request.UriRequest
    public InputStream getInputStream() {
        if (this.inputStream == null) {
            this.inputStream = new FileInputStream(getFile());
        }
        return this.inputStream;
    }

    @Override // com.duoyou.task.sdk.xutils.http.request.UriRequest, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        IOUtil.closeQuietly(this.inputStream);
        this.inputStream = null;
    }

    @Override // com.duoyou.task.sdk.xutils.http.request.UriRequest
    public long getContentLength() {
        return getFile().length();
    }

    @Override // com.duoyou.task.sdk.xutils.http.request.UriRequest
    public int getResponseCode() {
        return getFile().exists() ? 200 : 404;
    }

    @Override // com.duoyou.task.sdk.xutils.http.request.UriRequest
    public long getLastModified() {
        return getFile().lastModified();
    }
}
