package com.duoyou.task.sdk.xutils.http.loader;

import com.duoyou.task.sdk.xutils.cache.DiskCacheEntity;
import com.duoyou.task.sdk.xutils.http.request.UriRequest;
import java.io.InputStream;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class InputStreamLoader extends Loader<InputStream> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.duoyou.task.sdk.xutils.http.loader.Loader
    public InputStream loadFromCache(DiskCacheEntity diskCacheEntity) {
        return null;
    }

    @Override // com.duoyou.task.sdk.xutils.http.loader.Loader
    public void save2Cache(UriRequest uriRequest) {
    }

    @Override // com.duoyou.task.sdk.xutils.http.loader.Loader
    public Loader<InputStream> newInstance() {
        return new InputStreamLoader();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.duoyou.task.sdk.xutils.http.loader.Loader
    public InputStream load(UriRequest uriRequest) {
        uriRequest.sendRequest();
        return uriRequest.getInputStream();
    }
}
