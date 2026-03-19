package com.duoyou.task.sdk.xutils.http.request;

import android.content.res.Resources;
import android.text.TextUtils;
import androidx.core.location.LocationRequestCompat;
import com.duoyou.task.sdk.xutils.cache.DiskCacheEntity;
import com.duoyou.task.sdk.xutils.cache.LruDiskCache;
import com.duoyou.task.sdk.xutils.common.util.IOUtil;
import com.duoyou.task.sdk.xutils.common.util.LogUtil;
import com.duoyou.task.sdk.xutils.http.RequestParams;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class ResRequest extends UriRequest {
    private static long lastModifiedTime;
    public long contentLength;
    public InputStream inputStream;

    @Override // com.duoyou.task.sdk.xutils.http.request.UriRequest
    public void clearCacheHeader() {
    }

    @Override // com.duoyou.task.sdk.xutils.http.request.UriRequest
    public String getETag() {
        return null;
    }

    @Override // com.duoyou.task.sdk.xutils.http.request.UriRequest
    public long getExpiration() {
        return LocationRequestCompat.PASSIVE_INTERVAL;
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
    public void sendRequest() {
    }

    public ResRequest(RequestParams requestParams, Type type) {
        super(requestParams, type);
        this.contentLength = 0L;
    }

    @Override // com.duoyou.task.sdk.xutils.http.request.UriRequest
    public String getCacheKey() {
        return this.queryUrl;
    }

    @Override // com.duoyou.task.sdk.xutils.http.request.UriRequest
    public Object loadResult() {
        return this.loader.load(this);
    }

    @Override // com.duoyou.task.sdk.xutils.http.request.UriRequest
    public Object loadResultFromCache() {
        Date lastModify;
        DiskCacheEntity diskCacheEntity = LruDiskCache.getDiskCache(this.params.getCacheDirName()).setMaxSize(this.params.getCacheSize()).get(getCacheKey());
        if (diskCacheEntity == null || (lastModify = diskCacheEntity.getLastModify()) == null || lastModify.getTime() < getLastModified()) {
            return null;
        }
        return this.loader.loadFromCache(diskCacheEntity);
    }

    private int getResId() {
        String strReplace = this.queryUrl.substring(4).replace("/", "");
        int i = TextUtils.isDigitsOnly(strReplace) ? Integer.parseInt(strReplace) : 0;
        if (i > 0) {
            return i;
        }
        throw new IllegalArgumentException("resId not found in url:" + this.queryUrl);
    }

    @Override // com.duoyou.task.sdk.xutils.http.request.UriRequest
    public InputStream getInputStream() throws Resources.NotFoundException {
        if (this.inputStream == null) {
            this.inputStream = this.params.getContext().getResources().openRawResource(getResId());
            this.contentLength = r0.available();
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
        try {
            getInputStream();
            return this.contentLength;
        } catch (Throwable th) {
            LogUtil.e(th.getMessage(), th);
            return -1L;
        }
    }

    @Override // com.duoyou.task.sdk.xutils.http.request.UriRequest
    public int getResponseCode() {
        return getInputStream() != null ? 200 : 404;
    }

    @Override // com.duoyou.task.sdk.xutils.http.request.UriRequest
    public long getLastModified() {
        if (lastModifiedTime == 0) {
            try {
                File file = new File(this.params.getContext().getApplicationInfo().sourceDir);
                if (file.exists()) {
                    lastModifiedTime = file.lastModified();
                }
            } finally {
                try {
                    lastModifiedTime = System.currentTimeMillis();
                } catch (Throwable th) {
                }
            }
            if (lastModifiedTime == 0) {
                lastModifiedTime = System.currentTimeMillis();
            }
        }
        return lastModifiedTime;
    }
}
