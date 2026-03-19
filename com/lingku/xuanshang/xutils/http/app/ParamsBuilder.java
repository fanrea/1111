package com.lingku.xuanshang.xutils.http.app;

import com.lingku.xuanshang.xutils.http.RequestParams;
import com.lingku.xuanshang.xutils.http.annotation.HttpRequest;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public interface ParamsBuilder {
    String buildCacheKey(RequestParams requestParams, String[] strArr);

    void buildParams(RequestParams requestParams);

    void buildSign(RequestParams requestParams, String[] strArr);

    String buildUri(RequestParams requestParams, HttpRequest httpRequest);

    SSLSocketFactory getSSLSocketFactory();
}
