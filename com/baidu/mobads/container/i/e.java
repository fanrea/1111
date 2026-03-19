package com.baidu.mobads.container.i;

import android.net.Uri;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.baidu.mobads.container.bridge.w;
import com.baidu.mobads.container.util.o;
import com.baidu.mobads.container.util.x;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class e extends WebViewClient {
    final /* synthetic */ b a;

    e(b bVar) {
        this.a = bVar;
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView webView, String str) {
        super.onLoadResource(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        this.a.c = System.currentTimeMillis();
        super.onPageFinished(webView, str);
        this.a.mBridgeHandler.f();
        if (this.a.mBridgeHandler.e()) {
            this.a.mBridgeHandler.j();
        }
        this.a.mAdLogger.a("AdContainer onPageFinished");
        this.a.g = false;
        if (!b.e) {
            boolean unused = b.e = true;
            if (x.a(null).a() >= 19) {
                this.a.mWebView.evaluateJavascript(w.a, new f(this));
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        try {
            Uri uri = Uri.parse(str);
            if (w.d.equals(uri.getScheme())) {
                return this.a.mBridgeHandler.a(uri);
            }
        } catch (Exception e) {
            this.a.mAdLogger.d("shouldOverrideUrlLoading", str, e);
        }
        return this.a.processShouldOverrideUrlLoading(str, webView);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        this.a.mAdLogger.a("AdContainer onReceivedError", Integer.valueOf(i), str, str2);
        if ("banner".equals(this.a.mAdContainerCxt.k()) && str2.startsWith(o.e(b.a))) {
            if (!this.a.g && !this.a.h) {
                this.a.mAdContainerCxt.v().post(new g(this, i));
            }
            this.a.e();
        }
        super.onReceivedError(webView, i, str, str2);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
        this.a.mAdLogger.a("AdContainer error & proceed!");
    }
}
