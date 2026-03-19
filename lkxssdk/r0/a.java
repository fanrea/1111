package lkxssdk.r0;

import com.lingku.xuanshang.xutils.cache.DiskCacheEntity;
import com.lingku.xuanshang.xutils.http.loader.Loader;
import com.lingku.xuanshang.xutils.http.request.UriRequest;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class a extends Loader<Boolean> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.lingku.xuanshang.xutils.http.loader.Loader
    public Boolean load(UriRequest uriRequest) {
        uriRequest.sendRequest();
        return Boolean.valueOf(uriRequest.getResponseCode() < 300);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.lingku.xuanshang.xutils.http.loader.Loader
    public Boolean loadFromCache(DiskCacheEntity diskCacheEntity) {
        return null;
    }

    @Override // com.lingku.xuanshang.xutils.http.loader.Loader
    public Loader<Boolean> newInstance() {
        return new a();
    }

    @Override // com.lingku.xuanshang.xutils.http.loader.Loader
    public void save2Cache(UriRequest uriRequest) {
    }
}
