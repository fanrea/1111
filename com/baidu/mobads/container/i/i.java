package com.baidu.mobads.container.i;

import com.baidu.mobads.container.util.o;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class i implements Runnable {
    final /* synthetic */ h a;

    i(h hVar) {
        this.a = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.a.a.mWebView != null) {
            this.a.a.mWebView.loadUrl(o.e(b.a));
        }
    }
}
