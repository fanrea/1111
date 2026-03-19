package com.baidu.mobads.container.e;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class ae implements Runnable {
    final /* synthetic */ ad a;

    ae(ad adVar) {
        this.a = adVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.a.a.a.ay != null) {
            this.a.a.a.ay.setVisibility(8);
        }
        if (this.a.a.a.y != null) {
            this.a.a.a.y.setVisibility(8);
        }
        this.a.a.a.p();
    }
}
