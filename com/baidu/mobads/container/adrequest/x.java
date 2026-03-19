package com.baidu.mobads.container.adrequest;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import com.baidu.mobads.container.hybrid.XHybridAdRenderer;
import org.json.JSONException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class x extends o {
    public x(Context context, ProdAdRequestInfo prodAdRequestInfo) {
        super(context, prodAdRequestInfo);
    }

    @Override // com.baidu.mobads.container.adrequest.o
    public void a() {
        try {
            a(new v("{'ad':[{'id':99999999,'url':'http://127.0.0.1', type='html'}],'n':1}"));
            if (this.f != null && this.f.o().size() > 0) {
                this.g = this.f.b();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        b();
        g();
    }

    public void a(WebView webView) {
        if (this.h != null && (this.h instanceof XHybridAdRenderer)) {
            ((XHybridAdRenderer) this.h).setCustomerWebView(webView);
        }
    }

    public String H() {
        if (this.h != null && (this.h instanceof XHybridAdRenderer)) {
            return ((XHybridAdRenderer) this.h).getJavaScriptBridge();
        }
        return null;
    }

    public void a(WebView webView, String str, Bitmap bitmap) {
        if (this.h != null && (this.h instanceof XHybridAdRenderer)) {
            ((XHybridAdRenderer) this.h).onPageStarted(webView, str, bitmap);
        }
    }

    public void a(WebView webView, String str) {
        if (this.h != null && (this.h instanceof XHybridAdRenderer)) {
            ((XHybridAdRenderer) this.h).onPageFinished(webView, str);
        }
    }

    public void a(WebView webView, int i, String str, String str2) {
        if (this.h != null && (this.h instanceof XHybridAdRenderer)) {
            ((XHybridAdRenderer) this.h).onReceivedError(webView, i, str, str2);
        }
    }

    public boolean b(WebView webView, String str) {
        if (this.h != null && (this.h instanceof XHybridAdRenderer)) {
            return ((XHybridAdRenderer) this.h).shouldOverrideUrlLoading(webView, str);
        }
        return false;
    }

    public void a(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (this.h != null && (this.h instanceof XHybridAdRenderer)) {
            ((XHybridAdRenderer) this.h).onReceivedSslError(webView, sslErrorHandler, sslError);
        }
    }
}
