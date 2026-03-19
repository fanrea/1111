package lkxssdk.r0;

import android.text.TextUtils;
import com.lingku.xuanshang.xutils.cache.DiskCacheEntity;
import com.lingku.xuanshang.xutils.common.util.IOUtil;
import com.lingku.xuanshang.xutils.http.RequestParams;
import com.lingku.xuanshang.xutils.http.loader.Loader;
import com.lingku.xuanshang.xutils.http.request.UriRequest;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class f extends Loader<JSONObject> {
    public String a = "UTF-8";
    public String b = null;

    @Override // com.lingku.xuanshang.xutils.http.loader.Loader
    public JSONObject load(UriRequest uriRequest) {
        uriRequest.sendRequest();
        this.b = IOUtil.readStr(uriRequest.getInputStream(), this.a);
        return new JSONObject(this.b);
    }

    @Override // com.lingku.xuanshang.xutils.http.loader.Loader
    public JSONObject loadFromCache(DiskCacheEntity diskCacheEntity) {
        if (diskCacheEntity == null) {
            return null;
        }
        String textContent = diskCacheEntity.getTextContent();
        if (TextUtils.isEmpty(textContent)) {
            return null;
        }
        return new JSONObject(textContent);
    }

    @Override // com.lingku.xuanshang.xutils.http.loader.Loader
    public Loader<JSONObject> newInstance() {
        return new f();
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
