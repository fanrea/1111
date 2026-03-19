package lkxssdk.r0;

import com.lingku.xuanshang.xutils.cache.DiskCacheEntity;
import com.lingku.xuanshang.xutils.http.loader.Loader;
import com.lingku.xuanshang.xutils.http.request.UriRequest;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class d extends Loader<Integer> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.lingku.xuanshang.xutils.http.loader.Loader
    public Integer load(UriRequest uriRequest) {
        uriRequest.sendRequest();
        return Integer.valueOf(uriRequest.getResponseCode());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.lingku.xuanshang.xutils.http.loader.Loader
    public Integer loadFromCache(DiskCacheEntity diskCacheEntity) {
        return null;
    }

    @Override // com.lingku.xuanshang.xutils.http.loader.Loader
    public Loader<Integer> newInstance() {
        return new d();
    }

    @Override // com.lingku.xuanshang.xutils.http.loader.Loader
    public void save2Cache(UriRequest uriRequest) {
    }
}
