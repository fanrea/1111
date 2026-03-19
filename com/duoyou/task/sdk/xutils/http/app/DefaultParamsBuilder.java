package com.duoyou.task.sdk.xutils.http.app;

import com.alipay.sdk.m.s.a;
import com.duoyou.task.sdk.xutils.common.util.KeyValue;
import com.duoyou.task.sdk.xutils.common.util.LogUtil;
import com.duoyou.task.sdk.xutils.http.RequestParams;
import com.duoyou.task.sdk.xutils.http.annotation.HttpRequest;
import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class DefaultParamsBuilder implements ParamsBuilder {
    private static SSLSocketFactory trustAllSSlSocketFactory;

    @Override // com.duoyou.task.sdk.xutils.http.app.ParamsBuilder
    public void buildParams(RequestParams requestParams) {
    }

    @Override // com.duoyou.task.sdk.xutils.http.app.ParamsBuilder
    public void buildSign(RequestParams requestParams, String[] strArr) {
    }

    @Override // com.duoyou.task.sdk.xutils.http.app.ParamsBuilder
    public String buildUri(RequestParams requestParams, HttpRequest httpRequest) {
        return httpRequest.host() + "/" + httpRequest.path();
    }

    @Override // com.duoyou.task.sdk.xutils.http.app.ParamsBuilder
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
                            sb.append(str).append("=").append(valueStrOrNull).append(a.n);
                        }
                    }
                }
            }
        }
        return sb.toString();
    }

    @Override // com.duoyou.task.sdk.xutils.http.app.ParamsBuilder
    public SSLSocketFactory getSSLSocketFactory() {
        return getTrustAllSSLSocketFactory();
    }

    public static SSLSocketFactory getTrustAllSSLSocketFactory() {
        if (trustAllSSlSocketFactory == null) {
            synchronized (DefaultParamsBuilder.class) {
                if (trustAllSSlSocketFactory == null) {
                    TrustManager[] trustManagerArr = {new X509TrustManager() { // from class: com.duoyou.task.sdk.xutils.http.app.DefaultParamsBuilder.1
                        @Override // javax.net.ssl.X509TrustManager
                        public X509Certificate[] getAcceptedIssuers() {
                            return new X509Certificate[0];
                        }

                        @Override // javax.net.ssl.X509TrustManager
                        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
                            LogUtil.d("checkClientTrusted:" + str);
                        }

                        @Override // javax.net.ssl.X509TrustManager
                        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
                            LogUtil.d("checkServerTrusted:" + str);
                        }
                    }};
                    try {
                        SSLContext sSLContext = SSLContext.getInstance("TLS");
                        sSLContext.init(null, trustManagerArr, null);
                        trustAllSSlSocketFactory = sSLContext.getSocketFactory();
                    } catch (Throwable th) {
                        LogUtil.e(th.getMessage(), th);
                    }
                }
            }
        }
        return trustAllSSlSocketFactory;
    }
}
