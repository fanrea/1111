package com.lingku.xuanshang.xutils.http.app;

import com.lingku.xuanshang.xutils.common.util.KeyValue;
import com.lingku.xuanshang.xutils.common.util.LogUtil;
import com.lingku.xuanshang.xutils.http.RequestParams;
import com.lingku.xuanshang.xutils.http.annotation.HttpRequest;
import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class DefaultParamsBuilder implements ParamsBuilder {
    public static SSLSocketFactory a;

    public class a implements X509TrustManager {
        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
            LogUtil.d("checkClientTrusted:" + str);
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
            LogUtil.d("checkServerTrusted:" + str);
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }

    public static SSLSocketFactory getTrustAllSSLSocketFactory() {
        if (a == null) {
            synchronized (DefaultParamsBuilder.class) {
                if (a == null) {
                    TrustManager[] trustManagerArr = {new a()};
                    try {
                        SSLContext sSLContext = SSLContext.getInstance("TLS");
                        sSLContext.init(null, trustManagerArr, null);
                        a = sSLContext.getSocketFactory();
                    } catch (Throwable th) {
                        LogUtil.e(th.getMessage(), th);
                    }
                }
            }
        }
        return a;
    }

    @Override // com.lingku.xuanshang.xutils.http.app.ParamsBuilder
    public String buildCacheKey(RequestParams requestParams, String[] strArr) {
        StringBuilder sb = new StringBuilder();
        if (strArr != null && strArr.length > 0) {
            sb.append(requestParams.getUri()).append("?");
            for (String str : strArr) {
                List<KeyValue> params = requestParams.getParams(str);
                if (params != null && !params.isEmpty()) {
                    Iterator<KeyValue> it = params.iterator();
                    while (it.hasNext()) {
                        String valueStrOrNull = it.next().getValueStrOrNull();
                        if (valueStrOrNull != null) {
                            sb.append(str).append("=").append(valueStrOrNull).append(com.alipay.sdk.m.s.a.n);
                        }
                    }
                }
            }
        }
        return sb.toString();
    }

    @Override // com.lingku.xuanshang.xutils.http.app.ParamsBuilder
    public void buildParams(RequestParams requestParams) {
    }

    @Override // com.lingku.xuanshang.xutils.http.app.ParamsBuilder
    public void buildSign(RequestParams requestParams, String[] strArr) {
    }

    @Override // com.lingku.xuanshang.xutils.http.app.ParamsBuilder
    public String buildUri(RequestParams requestParams, HttpRequest httpRequest) {
        return httpRequest.host() + "/" + httpRequest.path();
    }

    @Override // com.lingku.xuanshang.xutils.http.app.ParamsBuilder
    public SSLSocketFactory getSSLSocketFactory() {
        return getTrustAllSSLSocketFactory();
    }
}
