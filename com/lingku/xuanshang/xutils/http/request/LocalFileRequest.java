package com.lingku.xuanshang.xutils.http.request;

import com.lingku.xuanshang.xutils.common.util.IOUtil;
import com.lingku.xuanshang.xutils.http.RequestParams;
import com.lingku.xuanshang.xutils.http.loader.FileLoader;
import com.lingku.xuanshang.xutils.http.loader.Loader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class LocalFileRequest extends UriRequest {
    public InputStream a;

    public LocalFileRequest(RequestParams requestParams, Type type) {
        super(requestParams, type);
    }

    public final File a() {
        return new File(this.queryUrl.startsWith("file:") ? this.queryUrl.substring(5) : this.queryUrl);
    }

    @Override // com.lingku.xuanshang.xutils.http.request.UriRequest
    public void clearCacheHeader() {
    }

    @Override // com.lingku.xuanshang.xutils.http.request.UriRequest, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        IOUtil.closeQuietly(this.a);
        this.a = null;
    }

    @Override // com.lingku.xuanshang.xutils.http.request.UriRequest
    public String getCacheKey() {
        return this.queryUrl;
    }

    @Override // com.lingku.xuanshang.xutils.http.request.UriRequest
    public long getContentLength() {
        return a().length();
    }

    @Override // com.lingku.xuanshang.xutils.http.request.UriRequest
    public String getETag() {
        return null;
    }

    @Override // com.lingku.xuanshang.xutils.http.request.UriRequest
    public long getExpiration() {
        return -1L;
    }

    @Override // com.lingku.xuanshang.xutils.http.request.UriRequest
    public long getHeaderFieldDate(String str, long j) {
        return j;
    }

    @Override // com.lingku.xuanshang.xutils.http.request.UriRequest
    public InputStream getInputStream() {
        if (this.a == null) {
            this.a = new FileInputStream(a());
        }
        return this.a;
    }

    @Override // com.lingku.xuanshang.xutils.http.request.UriRequest
    public long getLastModified() {
        return a().lastModified();
    }

    @Override // com.lingku.xuanshang.xutils.http.request.UriRequest
    public int getResponseCode() {
        return a().exists() ? 200 : 404;
    }

    @Override // com.lingku.xuanshang.xutils.http.request.UriRequest
    public String getResponseHeader(String str) {
        return null;
    }

    @Override // com.lingku.xuanshang.xutils.http.request.UriRequest
    public Map<String, List<String>> getResponseHeaders() {
        return null;
    }

    @Override // com.lingku.xuanshang.xutils.http.request.UriRequest
    public String getResponseMessage() {
        return null;
    }

    @Override // com.lingku.xuanshang.xutils.http.request.UriRequest
    public boolean isLoading() {
        return true;
    }

    @Override // com.lingku.xuanshang.xutils.http.request.UriRequest
    public Object loadResult() {
        Loader<?> loader = this.loader;
        return loader instanceof FileLoader ? a() : loader.load(this);
    }

    @Override // com.lingku.xuanshang.xutils.http.request.UriRequest
    public Object loadResultFromCache() {
        return null;
    }

    @Override // com.lingku.xuanshang.xutils.http.request.UriRequest
    public void save2Cache() {
    }

    @Override // com.lingku.xuanshang.xutils.http.request.UriRequest
    public void sendRequest() {
    }
}
