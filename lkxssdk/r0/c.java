package lkxssdk.r0;

import com.lingku.xuanshang.xutils.cache.DiskCacheEntity;
import com.lingku.xuanshang.xutils.http.loader.Loader;
import com.lingku.xuanshang.xutils.http.request.UriRequest;
import java.io.InputStream;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class c extends Loader<InputStream> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.lingku.xuanshang.xutils.http.loader.Loader
    public InputStream load(UriRequest uriRequest) {
        uriRequest.sendRequest();
        return uriRequest.getInputStream();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.lingku.xuanshang.xutils.http.loader.Loader
    public InputStream loadFromCache(DiskCacheEntity diskCacheEntity) {
        return null;
    }

    @Override // com.lingku.xuanshang.xutils.http.loader.Loader
    public Loader<InputStream> newInstance() {
        return new c();
    }

    @Override // com.lingku.xuanshang.xutils.http.loader.Loader
    public void save2Cache(UriRequest uriRequest) {
    }
}
