package com.component.feed;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class r implements Runnable {
    final /* synthetic */ q a;

    r(q qVar) {
        this.a = qVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.a.a.x != null && this.a.a.x.f()) {
            this.a.a.ag.setVisibility(8);
        }
    }
}
