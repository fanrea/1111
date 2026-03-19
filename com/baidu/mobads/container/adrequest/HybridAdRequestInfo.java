package com.baidu.mobads.container.adrequest;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import com.baidu.mobads.sdk.api.IXHybridAdRenderer;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class HybridAdRequestInfo extends ProdAdRequestInfo implements IXHybridAdRenderer {
    public HybridAdRequestInfo(Context context) {
        super(context);
    }

    @Override // com.baidu.mobads.sdk.api.IXHybridAdRenderer
    public void setCustomerWebView(WebView webView) {
        if (this.adProdTemplate != null && (this.adProdTemplate instanceof x)) {
            ((x) this.adProdTemplate).a(webView);
        }
    }

    @Override // com.baidu.mobads.sdk.api.IXHybridAdRenderer
    public String getJavaScriptBridge() {
        if (this.adProdTemplate != null && (this.adProdTemplate instanceof x)) {
            return ((x) this.adProdTemplate).H();
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.IXHybridAdRenderer
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        if (this.adProdTemplate != null && (this.adProdTemplate instanceof x)) {
            ((x) this.adProdTemplate).a(webView, str, bitmap);
        }
    }

    @Override // com.baidu.mobads.sdk.api.IXHybridAdRenderer
    public void onPageFinished(WebView webView, String str) {
        if (this.adProdTemplate != null && (this.adProdTemplate instanceof x)) {
            ((x) this.adProdTemplate).a(webView, str);
        }
    }

    @Override // com.baidu.mobads.sdk.api.IXHybridAdRenderer
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        if (this.adProdTemplate != null && (this.adProdTemplate instanceof x)) {
            ((x) this.adProdTemplate).a(webView, i, str, str2);
        }
    }

    @Override // com.baidu.mobads.sdk.api.IXHybridAdRenderer
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (this.adProdTemplate != null && (this.adProdTemplate instanceof x)) {
            return ((x) this.adProdTemplate).b(webView, str);
        }
        return false;
    }

    @Override // com.baidu.mobads.sdk.api.IXHybridAdRenderer
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (this.adProdTemplate != null && (this.adProdTemplate instanceof x)) {
            ((x) this.adProdTemplate).a(webView, sslErrorHandler, sslError);
        }
    }
}
