package com.baidu.mobads.container.e;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class az implements Runnable {
    final /* synthetic */ l a;

    az(l lVar) {
        this.a = lVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.a.N == null || !this.a.N.hasWindowFocus()) {
            if (this.a.ae < 1000) {
                this.a.ae += 300;
                this.a.ad.postDelayed(this.a.l, 300L);
                return;
            }
            return;
        }
        this.a.z();
    }
}
