package com.sigmob.sdk.base;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.URLUtil;
import android.webkit.WebResourceResponse;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class f extends e {
    private OkHttpClient.Builder c;
    private OkHttpClient d;

    public f() {
        try {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            this.c = builder;
            builder.connectionPool(new ConnectionPool());
            this.c.connectTimeout(5000L, TimeUnit.MILLISECONDS);
            this.c.readTimeout(5000L, TimeUnit.MILLISECONDS);
            this.c.writeTimeout(5000L, TimeUnit.MILLISECONDS);
            this.d = this.c.build();
        } catch (Throwable unused) {
        }
    }

    @Override // com.sigmob.sdk.base.e
    public WebResourceResponse a(String url, String method, Map<String, String> map) {
        if ((!URLUtil.isHttpUrl(url) && !URLUtil.isHttpsUrl(url)) || method.equals("POST")) {
            return null;
        }
        try {
            String host = Uri.parse(url).getHost();
            if (host != null && !host.equals("127.0.0.1") && !host.equals("localhost")) {
                Request.Builder builderUrl = new Request.Builder().url(url);
                if (map != null && map.size() > 0) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        builderUrl.addHeader(entry.getKey(), entry.getValue());
                    }
                }
                String cookie = CookieManager.getInstance().getCookie(url);
                if (!TextUtils.isEmpty(cookie)) {
                    for (String str : cookie.split(com.alipay.sdk.m.u.i.b)) {
                        builderUrl.addHeader(e.b.toLowerCase(), str.replace(" ", ""));
                    }
                }
                Response responseExecute = this.d.newCall(builderUrl.build()).execute();
                return new WebResourceResponse(responseExecute.body().get$contentType().type() + "/" + responseExecute.body().get$contentType().subtype(), responseExecute.header("content-encoding", "utf-8"), responseExecute.body().byteStream());
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return super.a(url, method, map);
        }
    }
}
