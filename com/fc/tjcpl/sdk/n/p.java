package com.fc.tjcpl.sdk.n;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import com.fc.tjcpl.sdk.view.CustomViewContent;
import com.fc.tjcpl.sdk.view.ViewWebLoading;
import com.github.lzyzsd.jsbridge.BridgeWebView;
import com.github.lzyzsd.jsbridge.BridgeWebViewClient;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class p extends BridgeWebViewClient {
    public final /* synthetic */ CustomViewContent a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(CustomViewContent customViewContent, BridgeWebView bridgeWebView) {
        super(bridgeWebView);
        this.a = customViewContent;
    }

    @Override // com.github.lzyzsd.jsbridge.BridgeWebViewClient, android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) throws Throwable {
        com.fc.tjcpl.sdk.i.c.b("tag", "onPageFinished url-->" + str);
        super.onPageFinished(webView, str);
        CustomViewContent customViewContent = this.a;
        if (!customViewContent.d) {
            if (customViewContent.c.getVisibility() == 0) {
                this.a.c.setVisibility(8);
                return;
            }
            return;
        }
        customViewContent.d = false;
        ViewWebLoading viewWebLoading = this.a.c;
        viewWebLoading.setVisibility(0);
        viewWebLoading.b.setBackgroundColor(Color.rgb(238, 238, 238));
        viewWebLoading.d.setVisibility(8);
        viewWebLoading.c.setVisibility(8);
        viewWebLoading.e.setVisibility(0);
    }

    @Override // com.github.lzyzsd.jsbridge.BridgeWebViewClient, android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        com.fc.tjcpl.sdk.i.c.b("tag", "onPageStarted url-->" + str);
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // com.github.lzyzsd.jsbridge.BridgeWebViewClient, android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        com.fc.tjcpl.sdk.i.c.b("tag", "onReceivedError111 description-->" + str);
        super.onReceivedError(webView, i, str, str2);
        this.a.d = true;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        return super.shouldOverrideUrlLoading(webView, webResourceRequest);
    }

    @Override // com.github.lzyzsd.jsbridge.BridgeWebViewClient, android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        com.fc.tjcpl.sdk.i.c.b("tag", "shouldOverrideUrlLoading url-->" + str);
        return super.shouldOverrideUrlLoading(webView, str);
    }
}
