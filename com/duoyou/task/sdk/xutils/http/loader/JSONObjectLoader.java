package com.duoyou.task.sdk.xutils.http.loader;

import android.text.TextUtils;
import com.duoyou.task.sdk.xutils.cache.DiskCacheEntity;
import com.duoyou.task.sdk.xutils.common.util.IOUtil;
import com.duoyou.task.sdk.xutils.http.RequestParams;
import com.duoyou.task.sdk.xutils.http.request.UriRequest;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class JSONObjectLoader extends Loader<JSONObject> {
    private String charset = "UTF-8";
    private String resultStr = null;

    @Override // com.duoyou.task.sdk.xutils.http.loader.Loader
    public Loader<JSONObject> newInstance() {
        return new JSONObjectLoader();
    }

    @Override // com.duoyou.task.sdk.xutils.http.loader.Loader
    public void setParams(RequestParams requestParams) {
        if (requestParams != null) {
            String charset = requestParams.getCharset();
            if (TextUtils.isEmpty(charset)) {
                return;
            }
            this.charset = charset;
        }
    }

    @Override // com.duoyou.task.sdk.xutils.http.loader.Loader
    public JSONObject load(UriRequest uriRequest) {
        uriRequest.sendRequest();
        this.resultStr = IOUtil.readStr(uriRequest.getInputStream(), this.charset);
        return new JSONObject(this.resultStr);
    }

    @Override // com.duoyou.task.sdk.xutils.http.loader.Loader
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

    @Override // com.duoyou.task.sdk.xutils.http.loader.Loader
    public void save2Cache(UriRequest uriRequest) {
        saveStringCache(uriRequest, this.resultStr);
    }
}
