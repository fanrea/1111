package com.kwad.sdk.core.webview.a;

import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.kwad.sdk.core.config.e;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class a extends WebViewClient {
    private boolean bLH = true;
    protected String mUniqueId = "";

    public final void setNeedHybridLoad(boolean z) {
        this.bLH = z;
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        if (!this.bLH || !e.Ys()) {
            return super.shouldInterceptRequest(webView, str);
        }
        com.kwad.sdk.core.d.c.d("HybridWebViewClient", "shouldInterceptRequest: " + str);
        WebResourceResponse webResourceResponseAh = com.kwad.sdk.core.webview.b.a.adH().ah(str, this.mUniqueId);
        return webResourceResponseAh == null ? super.shouldInterceptRequest(webView, str) : webResourceResponseAh;
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        if (!this.bLH || !e.Ys()) {
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }
        String string = webResourceRequest.getUrl().toString();
        com.kwad.sdk.core.d.c.d("HybridWebViewClient", "shouldInterceptRequestAPI 21: " + string);
        WebResourceResponse webResourceResponseAh = com.kwad.sdk.core.webview.b.a.adH().ah(string, this.mUniqueId);
        return webResourceResponseAh == null ? super.shouldInterceptRequest(webView, webResourceRequest) : webResourceResponseAh;
    }
}
