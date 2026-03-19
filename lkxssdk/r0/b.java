package lkxssdk.r0;

import com.lingku.xuanshang.xutils.cache.DiskCacheEntity;
import com.lingku.xuanshang.xutils.common.util.IOUtil;
import com.lingku.xuanshang.xutils.http.loader.Loader;
import com.lingku.xuanshang.xutils.http.request.UriRequest;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class b extends Loader<byte[]> {
    public byte[] a;

    @Override // com.lingku.xuanshang.xutils.http.loader.Loader
    public byte[] load(UriRequest uriRequest) throws Throwable {
        uriRequest.sendRequest();
        byte[] bytes = IOUtil.readBytes(uriRequest.getInputStream());
        this.a = bytes;
        return bytes;
    }

    @Override // com.lingku.xuanshang.xutils.http.loader.Loader
    public byte[] loadFromCache(DiskCacheEntity diskCacheEntity) {
        byte[] bytesContent;
        if (diskCacheEntity == null || (bytesContent = diskCacheEntity.getBytesContent()) == null || bytesContent.length <= 0) {
            return null;
        }
        return bytesContent;
    }

    @Override // com.lingku.xuanshang.xutils.http.loader.Loader
    public Loader<byte[]> newInstance() {
        return new b();
    }

    @Override // com.lingku.xuanshang.xutils.http.loader.Loader
    public void save2Cache(UriRequest uriRequest) {
        saveByteArrayCache(uriRequest, this.a);
    }
}
