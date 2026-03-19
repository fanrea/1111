package lkxssdk.r0;

import android.text.TextUtils;
import com.lingku.xuanshang.xutils.cache.DiskCacheEntity;
import com.lingku.xuanshang.xutils.common.util.IOUtil;
import com.lingku.xuanshang.xutils.http.RequestParams;
import com.lingku.xuanshang.xutils.http.loader.Loader;
import com.lingku.xuanshang.xutils.http.request.UriRequest;
import org.json.JSONArray;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class e extends Loader<JSONArray> {
    public String a = "UTF-8";
    public String b = null;

    @Override // com.lingku.xuanshang.xutils.http.loader.Loader
    public JSONArray load(UriRequest uriRequest) {
        uriRequest.sendRequest();
        this.b = IOUtil.readStr(uriRequest.getInputStream(), this.a);
        return new JSONArray(this.b);
    }

    @Override // com.lingku.xuanshang.xutils.http.loader.Loader
    public JSONArray loadFromCache(DiskCacheEntity diskCacheEntity) {
        if (diskCacheEntity == null) {
            return null;
        }
        String textContent = diskCacheEntity.getTextContent();
        if (TextUtils.isEmpty(textContent)) {
            return null;
        }
        return new JSONArray(textContent);
    }

    @Override // com.lingku.xuanshang.xutils.http.loader.Loader
    public Loader<JSONArray> newInstance() {
        return new e();
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
