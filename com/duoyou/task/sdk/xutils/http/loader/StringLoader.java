package com.duoyou.task.sdk.xutils.http.loader;

import android.text.TextUtils;
import com.duoyou.task.sdk.xutils.cache.DiskCacheEntity;
import com.duoyou.task.sdk.xutils.common.util.IOUtil;
import com.duoyou.task.sdk.xutils.http.RequestParams;
import com.duoyou.task.sdk.xutils.http.request.UriRequest;
import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class StringLoader extends Loader<String> {
    private String charset = "UTF-8";
    private String resultStr = null;

    @Override // com.duoyou.task.sdk.xutils.http.loader.Loader
    public Loader<String> newInstance() {
        return new StringLoader();
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
    public String load(UriRequest uriRequest) throws IOException {
        uriRequest.sendRequest();
        String str = IOUtil.readStr(uriRequest.getInputStream(), this.charset);
        this.resultStr = str;
        return str;
    }

    @Override // com.duoyou.task.sdk.xutils.http.loader.Loader
    public String loadFromCache(DiskCacheEntity diskCacheEntity) {
        if (diskCacheEntity != null) {
            return diskCacheEntity.getTextContent();
        }
        return null;
    }

    @Override // com.duoyou.task.sdk.xutils.http.loader.Loader
    public void save2Cache(UriRequest uriRequest) {
        saveStringCache(uriRequest, this.resultStr);
    }
}
