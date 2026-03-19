package com.baidu.mobads.container.activity;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class x extends WebViewClient {
    final /* synthetic */ PermissionDialogActivity a;

    x(PermissionDialogActivity permissionDialogActivity) {
        this.a = permissionDialogActivity;
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        if (this.a.mProgressBar != null) {
            this.a.mProgressBar.setVisibility(4);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (!com.baidu.mobads.container.r.c.a(sslErrorHandler)) {
            sslErrorHandler.cancel();
        }
    }
}
