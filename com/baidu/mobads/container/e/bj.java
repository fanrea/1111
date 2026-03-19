package com.baidu.mobads.container.e;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class bj implements Runnable {
    final /* synthetic */ bh a;

    bj(bh bhVar) {
        this.a = bhVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.a.a.ay != null) {
            this.a.a.ay.setVisibility(8);
        }
        if (this.a.a.C != null) {
            this.a.a.C.setVisibility(0);
        }
        if (this.a.a.bc != null) {
            this.a.a.bc.setVisibility(0);
        }
        if (this.a.a.E != null) {
            this.a.a.E.setVisibility(0);
        }
    }
}
