package com.baidu.mobads.container.e;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class bk implements Runnable {
    final /* synthetic */ l a;

    bk(l lVar) {
        this.a = lVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.a.aK) {
            this.a.b(this.a.aO);
            this.a.aO += this.a.aJ;
        }
        if (this.a.E()) {
            this.a.aH.postDelayed(this.a.o, this.a.aJ);
        } else {
            this.a.F();
            this.a.aI = false;
        }
    }
}
