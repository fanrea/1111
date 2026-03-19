package com.baidu.mobads.container.y;

import android.webkit.WebView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class f implements Runnable {
    final /* synthetic */ WebView a;
    final /* synthetic */ c b;

    f(c cVar, WebView webView) {
        this.b = cVar;
        this.a = webView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.stopLoading();
    }
}
