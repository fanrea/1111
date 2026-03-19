package lkxssdk.r0;

import android.text.TextUtils;
import com.lingku.xuanshang.xutils.cache.DiskCacheEntity;
import com.lingku.xuanshang.xutils.common.util.IOUtil;
import com.lingku.xuanshang.xutils.http.RequestParams;
import com.lingku.xuanshang.xutils.http.loader.Loader;
import com.lingku.xuanshang.xutils.http.request.UriRequest;
import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class h extends Loader<String> {
    public String a = "UTF-8";
    public String b = null;

    @Override // com.lingku.xuanshang.xutils.http.loader.Loader
    public String load(UriRequest uriRequest) throws IOException {
        uriRequest.sendRequest();
        String str = IOUtil.readStr(uriRequest.getInputStream(), this.a);
        this.b = str;
        return str;
    }

    @Override // com.lingku.xuanshang.xutils.http.loader.Loader
    public String loadFromCache(DiskCacheEntity diskCacheEntity) {
        if (diskCacheEntity != null) {
            return diskCacheEntity.getTextContent();
        }
        return null;
    }

    @Override // com.lingku.xuanshang.xutils.http.loader.Loader
    public Loader<String> newInstance() {
        return new h();
    }

    @Override // com.lingku.xuanshang.xutils.http.loader.Loader
    public void save2Cache(UriRequest uriRequest) {
        saveStringCache(uriRequest, this.b);
    }

    @Override // com.lingku.xuanshang.xutils.http.loader.Loader
    public void setParams(RequestParams requestParams) {
        if (requestParams != null) {
            String charset = requestParams.getCharset();
            if (TextUtils.isEmpty(charset)) {
                return;
            }
            this.a = charset;
        }
    }
}
