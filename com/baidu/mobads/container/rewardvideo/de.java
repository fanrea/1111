package com.baidu.mobads.container.rewardvideo;

import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import android.webkit.WebView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class de extends com.baidu.mobads.container.ay {
    final /* synthetic */ cw a;

    de(cw cwVar) {
        this.a = cwVar;
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView webView, String str) {
        super.onLoadResource(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        try {
            if (this.a.v.e()) {
                this.a.v.h("javascript:" + this.a.w());
            }
            this.a.v.f();
            if (webView.getParent() != null) {
                ((View) webView.getParent()).setBackgroundResource(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        this.a.a(com.baidu.mobads.container.c.a.NETWORK_UNCONNECT, "onReceivedError-" + i);
    }

    @Override // com.baidu.mobads.container.ay, android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        try {
            Uri uri = Uri.parse(str);
            if (com.baidu.mobads.container.bridge.w.d.equals(uri.getScheme())) {
                return this.a.v.a(uri);
            }
        } catch (Exception e) {
            this.a.u.d("shouldOverrideUrlLoading", str, e);
        }
        try {
            if (this.a.ae != null && this.a.ae.c(str)) {
                this.a.ae.a(str);
                return true;
            }
        } catch (Throwable th) {
            this.a.u.a("RemoteRewardBrowseAty", th.getMessage());
        }
        try {
            this.a.a(str, webView);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return false;
    }
}
