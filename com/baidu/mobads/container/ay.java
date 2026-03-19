package com.baidu.mobads.container;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.baidu.mobads.container.util.by;
import java.io.ByteArrayInputStream;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class ay extends WebViewClient {
    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (!TextUtils.isEmpty(str) && str.contains("/127.0.0.1:55555")) {
            if (webView != null) {
                a(webView.getContext(), str);
            }
            return true;
        }
        a(webView, str);
        return true;
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        try {
            String string = webResourceRequest.getUrl().toString();
            if (!TextUtils.isEmpty(string) && string.contains("/127.0.0.1:55555")) {
                if (webView != null) {
                    a(webView.getContext(), string);
                }
                return new WebResourceResponse("text/html", "utf-8", new ByteArrayInputStream("快应用调起，已被拦截".getBytes()));
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private void a(WebView webView, String str) {
        if (webView != null) {
            try {
                webView.loadUrl(str);
            } catch (Exception e) {
            }
        }
    }

    public void a(Context context, String str) {
        try {
            by.a.a(context).a(431).a("appear_scene", "template").a("url", str).g();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
