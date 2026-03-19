package com.baidu.mobads.container.rewardvideo;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class l implements Runnable {
    final /* synthetic */ j a;

    l(j jVar) {
        this.a = jVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.a.bi.a(this);
        if (this.a.a.mNativeShakeView != null) {
            this.a.a.mNativeShakeView.setVisibility(0);
            this.a.a.o();
        }
    }
}
