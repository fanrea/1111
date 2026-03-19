package com.duoyou.task.openapi;

import android.webkit.WebView;
import com.duoyou.task.pro.g.n;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public abstract class WebViewObject {
    private WebView webView;

    public void setWebView(WebView webView) {
        this.webView = webView;
    }

    public WebView getWebView() {
        return this.webView;
    }

    public void evaluateJavascript(String str) {
        WebView webView = this.webView;
        if (webView == null) {
            return;
        }
        n.a(webView, str);
    }
}
