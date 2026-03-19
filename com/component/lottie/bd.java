package com.component.lottie;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class bd implements Runnable {
    final /* synthetic */ bc a;

    bd(bc bcVar) {
        this.a = bcVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        bb bbVar = this.a.d;
        if (bbVar == null) {
            return;
        }
        if (bbVar.a() != null) {
            this.a.a((bc) bbVar.a());
        } else {
            this.a.a(bbVar.b());
        }
    }
}
