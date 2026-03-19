package com.baidu.mobads.sdk.internal;

import android.webkit.WebView;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
class ai implements Runnable {
    final /* synthetic */ JSONObject a;
    final /* synthetic */ WebView b;
    final /* synthetic */ ae c;

    ai(ae aeVar, JSONObject jSONObject, WebView webView) {
        this.c = aeVar;
        this.a = jSONObject;
        this.b = webView;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.a == null || this.b == null) {
            return;
        }
        this.b.loadUrl("javascript:window.sdkCallback.userInteractCb(\"" + this.a.toString().replace("\"", "\\\"") + "\")");
    }
}
