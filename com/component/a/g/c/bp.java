package com.component.a.g.c;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class bp implements Runnable {
    final /* synthetic */ bo a;

    bp(bo boVar) {
        this.a = boVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.a.n < this.a.l) {
            this.a.f.a((this.a.l - this.a.n) * 1000);
            bo.a(this.a, 1);
            this.a.e.postDelayed(this.a.c, 1000L);
            return;
        }
        if (this.a.k != null) {
            this.a.k.a();
        }
        this.a.e.removeCallbacksAndMessages(null);
    }
}
