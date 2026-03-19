package com.duoyou.task.sdk.xutils.http.loader;

import com.duoyou.task.sdk.xutils.cache.DiskCacheEntity;
import com.duoyou.task.sdk.xutils.common.util.IOUtil;
import com.duoyou.task.sdk.xutils.http.request.UriRequest;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class ByteArrayLoader extends Loader<byte[]> {
    private byte[] resultData;

    @Override // com.duoyou.task.sdk.xutils.http.loader.Loader
    public Loader<byte[]> newInstance() {
        return new ByteArrayLoader();
    }

    @Override // com.duoyou.task.sdk.xutils.http.loader.Loader
    public byte[] load(UriRequest uriRequest) throws Throwable {
        uriRequest.sendRequest();
        byte[] bytes = IOUtil.readBytes(uriRequest.getInputStream());
        this.resultData = bytes;
        return bytes;
    }

    @Override // com.duoyou.task.sdk.xutils.http.loader.Loader
    public byte[] loadFromCache(DiskCacheEntity diskCacheEntity) {
        byte[] bytesContent;
        if (diskCacheEntity == null || (bytesContent = diskCacheEntity.getBytesContent()) == null || bytesContent.length <= 0) {
            return null;
        }
        return bytesContent;
    }

    @Override // com.duoyou.task.sdk.xutils.http.loader.Loader
    public void save2Cache(UriRequest uriRequest) {
        saveByteArrayCache(uriRequest, this.resultData);
    }
}
