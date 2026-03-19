package com.duoyou.task.sdk.xutils.http.loader;

import com.duoyou.task.sdk.xutils.cache.DiskCacheEntity;
import com.duoyou.task.sdk.xutils.http.request.UriRequest;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class IntegerLoader extends Loader<Integer> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.duoyou.task.sdk.xutils.http.loader.Loader
    public Integer loadFromCache(DiskCacheEntity diskCacheEntity) {
        return null;
    }

    @Override // com.duoyou.task.sdk.xutils.http.loader.Loader
    public void save2Cache(UriRequest uriRequest) {
    }

    @Override // com.duoyou.task.sdk.xutils.http.loader.Loader
    public Loader<Integer> newInstance() {
        return new IntegerLoader();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.duoyou.task.sdk.xutils.http.loader.Loader
    public Integer load(UriRequest uriRequest) {
        uriRequest.sendRequest();
        return Integer.valueOf(uriRequest.getResponseCode());
    }
}
