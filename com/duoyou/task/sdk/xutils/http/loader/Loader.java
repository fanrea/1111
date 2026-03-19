package com.duoyou.task.sdk.xutils.http.loader;

import android.text.TextUtils;
import com.duoyou.task.sdk.xutils.cache.DiskCacheEntity;
import com.duoyou.task.sdk.xutils.cache.LruDiskCache;
import com.duoyou.task.sdk.xutils.http.ProgressHandler;
import com.duoyou.task.sdk.xutils.http.RequestParams;
import com.duoyou.task.sdk.xutils.http.request.UriRequest;
import java.util.Date;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public abstract class Loader<T> {
    public ProgressHandler progressHandler;

    public abstract T load(UriRequest uriRequest);

    public abstract T loadFromCache(DiskCacheEntity diskCacheEntity);

    public abstract Loader<T> newInstance();

    public abstract void save2Cache(UriRequest uriRequest);

    public void setParams(RequestParams requestParams) {
    }

    public void setProgressHandler(ProgressHandler progressHandler) {
        this.progressHandler = progressHandler;
    }

    public void saveStringCache(UriRequest uriRequest, String str) {
        saveCacheInternal(uriRequest, str, null);
    }

    public void saveByteArrayCache(UriRequest uriRequest, byte[] bArr) {
        saveCacheInternal(uriRequest, null, bArr);
    }

    private void saveCacheInternal(UriRequest uriRequest, String str, byte[] bArr) {
        if (!TextUtils.isEmpty(str) || (bArr != null && bArr.length > 0)) {
            DiskCacheEntity diskCacheEntity = new DiskCacheEntity();
            diskCacheEntity.setKey(uriRequest.getCacheKey());
            diskCacheEntity.setLastAccess(System.currentTimeMillis());
            diskCacheEntity.setEtag(uriRequest.getETag());
            diskCacheEntity.setExpires(uriRequest.getExpiration());
            diskCacheEntity.setLastModify(new Date(uriRequest.getLastModified()));
            diskCacheEntity.setTextContent(str);
            diskCacheEntity.setBytesContent(bArr);
            LruDiskCache.getDiskCache(uriRequest.getParams().getCacheDirName()).put(diskCacheEntity);
        }
    }
}
