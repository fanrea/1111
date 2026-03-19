package com.baidu.mobads.container.v;

import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import android.webkit.WebView;
import com.baidu.mobads.container.ay;
import com.baidu.mobads.container.bridge.w;
import com.baidu.mobads.container.util.bk;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class e extends ay {
    final /* synthetic */ d a;

    e(d dVar) {
        this.a = dVar;
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        if ("rsplash".equals(this.a.mAdContainerCxt.k())) {
            bk.a(this.a.mAppContext, this.a.mAdContainerCxt, bk.M, 8);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView webView, String str) {
        super.onLoadResource(webView, str);
        if (!this.a.e && "rsplash".equals(this.a.mAdContainerCxt.k())) {
            this.a.e = true;
            bk.a(this.a.mAppContext, this.a.mAdContainerCxt, bk.M, 9);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        this.a.b = true;
        if ("rsplash".equals(this.a.mAdContainerCxt.k())) {
            bk.a(this.a.mAppContext, this.a.mAdContainerCxt, bk.M, 3);
        }
        super.onPageFinished(webView, str);
        if (this.a.mBridgeHandler.e()) {
            this.a.mBridgeHandler.h("javascript:" + this.a.c());
        }
        this.a.mBridgeHandler.f();
        if (webView.getParent() != null) {
            ((View) webView.getParent()).setBackgroundResource(0);
        }
        this.a.mWebView.setVisibility(0);
        this.a.start();
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        if ("rsplash".equals(this.a.mAdContainerCxt.k())) {
            bk.a(this.a.mAppContext, this.a.mAdContainerCxt, bk.M, 5);
        }
        this.a.mAdState = 2;
        this.a.processAdError(com.baidu.mobads.container.c.a.NETWORK_UNCONNECT, "模板广告onReceivedError-" + i);
    }

    @Override // com.baidu.mobads.container.ay, android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        Uri uri;
        if (this.a.a(str).booleanValue()) {
            webView.loadUrl(str);
            return true;
        }
        try {
            uri = Uri.parse(str);
        } catch (Exception e) {
            this.a.mAdLogger.d("shouldOverrideUrlLoading", str, e);
        }
        if (!"nfs".equals(uri.getScheme()) && !"cactus".equals(uri.getScheme()) && !str.startsWith(com.baidu.mobads.container.bridge.b.j)) {
            try {
                Uri uri2 = Uri.parse(str);
                if (w.d.equals(uri2.getScheme())) {
                    return this.a.mBridgeHandler.a(uri2);
                }
            } catch (Exception e2) {
                this.a.mAdLogger.d("shouldOverrideUrlLoading", str, e2);
            }
            try {
                if (this.a.c != null && this.a.c.c(str)) {
                    this.a.c.a(str);
                    return true;
                }
            } catch (Throwable th) {
                this.a.mAdLogger.a(d.a, th.getMessage());
            }
            this.a.processShouldOverrideUrlLoading(str, webView);
            return true;
        }
        this.a.a(uri);
        return true;
    }
}
