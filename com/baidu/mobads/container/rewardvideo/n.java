package com.baidu.mobads.container.rewardvideo;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class n implements Runnable {
    final /* synthetic */ j a;

    n(j jVar) {
        this.a = jVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.a.bi.a(this);
        this.a.a.controlSkipViewLevel();
        this.a.a.aB.setVisibility(0);
        this.a.a.aB.f();
    }
}
