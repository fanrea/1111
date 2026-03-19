package com.baidu.mobads.container.e;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class bu implements Runnable {
    final /* synthetic */ l a;

    bu(l lVar) {
        this.a = lVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.a(com.component.a.g.b.b.e, new com.component.a.b.o().b("timer", Long.valueOf(this.a.bl)));
        l.a(this.a, this.a.aJ);
        this.a.L();
        this.a.bk.postDelayed(this.a.p, this.a.aJ);
    }
}
