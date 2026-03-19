package com.baidu.mobads.container.e;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class bh implements Runnable {
    final /* synthetic */ l a;

    bh(l lVar) {
        this.a = lVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.mobads.container.util.h.a(new bi(this));
        this.a.au += this.a.av;
        if (this.a.au <= this.a.aw) {
            this.a.ax.postDelayed(this.a.n, this.a.av);
        } else {
            com.baidu.mobads.container.util.h.a(new bj(this));
        }
    }
}
