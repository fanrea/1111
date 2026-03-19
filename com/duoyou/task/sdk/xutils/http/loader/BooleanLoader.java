package com.duoyou.task.sdk.xutils.http.loader;

import com.duoyou.task.sdk.xutils.cache.DiskCacheEntity;
import com.duoyou.task.sdk.xutils.http.request.UriRequest;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class BooleanLoader extends Loader<Boolean> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.duoyou.task.sdk.xutils.http.loader.Loader
    public Boolean loadFromCache(DiskCacheEntity diskCacheEntity) {
        return null;
    }

    @Override // com.duoyou.task.sdk.xutils.http.loader.Loader
    public void save2Cache(UriRequest uriRequest) {
    }

    @Override // com.duoyou.task.sdk.xutils.http.loader.Loader
    public Loader<Boolean> newInstance() {
        return new BooleanLoader();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.duoyou.task.sdk.xutils.http.loader.Loader
    public Boolean load(UriRequest uriRequest) {
        uriRequest.sendRequest();
        return Boolean.valueOf(uriRequest.getResponseCode() < 300);
    }
}
