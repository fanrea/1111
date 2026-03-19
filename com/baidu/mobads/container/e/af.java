package com.baidu.mobads.container.e;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class af implements Runnable {
    final /* synthetic */ l a;

    af(l lVar) {
        this.a = lVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.a.aU == 1) {
            this.a.aS = this.a.a(this.a.aR, this.a.aU, this.a.aV, this.a.aW);
        } else {
            this.a.aT = this.a.b(this.a.aR, this.a.aU, this.a.aV, this.a.aW);
        }
    }
}
