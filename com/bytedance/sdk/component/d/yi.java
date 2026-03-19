package com.bytedance.sdk.component.d;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class yi extends d {
    static final /* synthetic */ boolean tc = true;
    protected String gb;
    protected com.bytedance.sdk.component.uo.b tt;

    @Override // com.bytedance.sdk.component.d.d
    protected Context getContext(tc tcVar) {
        if (tcVar.u != null) {
            return tcVar.u;
        }
        if (tcVar.d != null) {
            View view = tcVar.d.getView();
            if (view != null) {
                return view.getContext();
            }
            WebView webView = tcVar.d.getWebView();
            if (webView != null) {
                return webView.getContext();
            }
        }
        throw new IllegalStateException("WebView cannot be null!");
    }

    @Override // com.bytedance.sdk.component.d.d
    protected String d() {
        return this.tt.getUrl();
    }

    @Override // com.bytedance.sdk.component.d.d
    protected void d(tc tcVar) {
        this.tt = tcVar.d;
        this.gb = tcVar.b;
        if (Build.VERSION.SDK_INT < 17 || tcVar.k) {
            return;
        }
        b();
    }

    private void d(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            this.c.post(runnable);
        }
    }

    protected void b() {
        if (!tc && this.tt == null) {
            throw new AssertionError();
        }
        com.bytedance.sdk.component.uo.b bVar = this.tt;
        if (bVar != null) {
            bVar.addJavascriptInterface(this, this.gb);
        }
    }

    @Override // com.bytedance.sdk.component.d.d
    @JavascriptInterface
    public void invokeMethod(String str) {
        super.invokeMethod(str);
    }

    @Override // com.bytedance.sdk.component.d.d
    protected void hc() {
        super.hc();
        c();
    }

    protected void c() {
        com.bytedance.sdk.component.uo.b bVar = this.tt;
        if (bVar != null) {
            bVar.removeJavascriptInterface(this.gb);
        }
    }

    @Override // com.bytedance.sdk.component.d.d
    protected void d(String str, cb cbVar) {
        if (cbVar != null && !TextUtils.isEmpty(cbVar.gb)) {
            String str2 = cbVar.gb;
            d(str, String.format("javascript:(function(){   const iframe = document.querySelector(atob('%s'));   if (iframe && iframe.contentWindow) {        iframe.contentWindow.postMessage(%s, atob('%s'));   }})()", Base64.encodeToString(String.format("iframe[src=\"%s\"", str2).getBytes(), 2), str, Base64.encodeToString(str2.getBytes(), 2)));
            return;
        }
        super.d(str, cbVar);
    }

    @Override // com.bytedance.sdk.component.d.d
    protected void d(String str) {
        d(str, "javascript:" + this.gb + "._handleMessageFromToutiao(" + str + ")");
    }

    private void d(String str, final String str2) {
        if (this.an || TextUtils.isEmpty(str2)) {
            return;
        }
        d(new Runnable() { // from class: com.bytedance.sdk.component.d.yi.1
            @Override // java.lang.Runnable
            public void run() {
                if (yi.this.an) {
                    return;
                }
                try {
                    if (Build.VERSION.SDK_INT >= 19) {
                        tt.d("Invoking Jsb using evaluateJavascript: " + str2);
                        yi.this.tt.evaluateJavascript(str2, null);
                    } else {
                        tt.d("Invoking Jsb using loadUrl: " + str2);
                        yi.this.tt.loadUrl(str2);
                    }
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.mq.d(th);
                }
            }
        });
    }
}
