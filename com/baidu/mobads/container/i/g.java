package com.baidu.mobads.container.i;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class g implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ e b;

    g(e eVar, int i) {
        this.b = eVar;
        this.a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.a.processAdError(com.baidu.mobads.container.c.a.NETWORK_UNCONNECT, "html_onReceivedError-" + this.a);
    }
}
