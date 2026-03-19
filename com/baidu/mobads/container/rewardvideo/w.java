package com.baidu.mobads.container.rewardvideo;

import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import android.webkit.WebView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class w extends com.baidu.mobads.container.ay {
    final /* synthetic */ NativeRewardActivity a;

    w(NativeRewardActivity nativeRewardActivity) {
        this.a = nativeRewardActivity;
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
        if (this.a.M.e()) {
            this.a.M.h("javascript:" + this.a.e());
        }
        this.a.M.f();
        if (this.a.M != null && !this.a.isLastPage()) {
            this.a.M.h(com.baidu.mobads.container.bridge.w.o);
        }
        if (webView.getParent() != null) {
            ((View) webView.getParent()).setBackgroundResource(0);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        this.a.processAdError(com.baidu.mobads.container.c.a.NETWORK_UNCONNECT, "onReceivedError-" + i);
    }

    @Override // com.baidu.mobads.container.ay, android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        try {
            this.a.j();
            Uri uri = Uri.parse(str);
            if (com.baidu.mobads.container.bridge.w.d.equals(uri.getScheme())) {
                this.a.ah = 1;
                return this.a.M.a(uri);
            }
        } catch (Exception e) {
            this.a.L.d("shouldOverrideUrlLoading", str, e);
        }
        if (!com.baidu.mobads.container.util.ab.c(str)) {
            this.a.a(str, webView);
            return true;
        }
        return false;
    }
}
