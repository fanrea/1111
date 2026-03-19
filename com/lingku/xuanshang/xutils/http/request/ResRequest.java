package com.lingku.xuanshang.xutils.http.request;

import android.content.res.Resources;
import android.text.TextUtils;
import androidx.core.location.LocationRequestCompat;
import com.lingku.xuanshang.xutils.cache.DiskCacheEntity;
import com.lingku.xuanshang.xutils.cache.LruDiskCache;
import com.lingku.xuanshang.xutils.common.util.IOUtil;
import com.lingku.xuanshang.xutils.common.util.LogUtil;
import com.lingku.xuanshang.xutils.http.RequestParams;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class ResRequest extends UriRequest {
    public static long a;
    public long contentLength;
    public InputStream inputStream;

    public ResRequest(RequestParams requestParams, Type type) {
        super(requestParams, type);
        this.contentLength = 0L;
    }

    @Override // com.lingku.xuanshang.xutils.http.request.UriRequest
    public void clearCacheHeader() {
    }

    @Override // com.lingku.xuanshang.xutils.http.request.UriRequest, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        IOUtil.closeQuietly(this.inputStream);
        this.inputStream = null;
    }

    @Override // com.lingku.xuanshang.xutils.http.request.UriRequest
    public String getCacheKey() {
        return this.queryUrl;
    }

    @Override // com.lingku.xuanshang.xutils.http.request.UriRequest
    public long getContentLength() {
        try {
            getInputStream();
            return this.contentLength;
        } catch (Throwable th) {
            LogUtil.e(th.getMessage(), th);
            return -1L;
        }
    }

    @Override // com.lingku.xuanshang.xutils.http.request.UriRequest
    public String getETag() {
        return null;
    }

    @Override // com.lingku.xuanshang.xutils.http.request.UriRequest
    public long getExpiration() {
        return LocationRequestCompat.PASSIVE_INTERVAL;
    }

    @Override // com.lingku.xuanshang.xutils.http.request.UriRequest
    public long getHeaderFieldDate(String str, long j) {
        return j;
    }

    @Override // com.lingku.xuanshang.xutils.http.request.UriRequest
    public InputStream getInputStream() throws Resources.NotFoundException {
        if (this.inputStream == null) {
            Resources resources = this.params.getContext().getResources();
            String strReplace = this.queryUrl.substring(4).replace("/", "");
            int i = TextUtils.isDigitsOnly(strReplace) ? Integer.parseInt(strReplace) : 0;
            if (i <= 0) {
                throw new IllegalArgumentException("resId not found in url:" + this.queryUrl);
            }
            this.inputStream = resources.openRawResource(i);
            this.contentLength = r0.available();
        }
        return this.inputStream;
    }

    @Override // com.lingku.xuanshang.xutils.http.request.UriRequest
    public long getLastModified() {
        if (a == 0) {
            try {
                File file = new File(this.params.getContext().getApplicationInfo().sourceDir);
                if (file.exists()) {
                    a = file.lastModified();
                }
            } finally {
                try {
                    a = System.currentTimeMillis();
                } catch (Throwable th) {
                }
            }
            if (a == 0) {
                a = System.currentTimeMillis();
            }
        }
        return a;
    }

    @Override // com.lingku.xuanshang.xutils.http.request.UriRequest
    public int getResponseCode() {
        return getInputStream() != null ? 200 : 404;
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
        return this.loader.load(this);
    }

    @Override // com.lingku.xuanshang.xutils.http.request.UriRequest
    public Object loadResultFromCache() {
        Date lastModify;
        DiskCacheEntity diskCacheEntity = LruDiskCache.getDiskCache(this.params.getCacheDirName()).setMaxSize(this.params.getCacheSize()).get(getCacheKey());
        if (diskCacheEntity == null || (lastModify = diskCacheEntity.getLastModify()) == null || lastModify.getTime() < getLastModified()) {
            return null;
        }
        return this.loader.loadFromCache(diskCacheEntity);
    }

    @Override // com.lingku.xuanshang.xutils.http.request.UriRequest
    public void sendRequest() {
    }
}
