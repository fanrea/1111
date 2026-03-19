package com.baidu.mobads.container.e;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class bs implements Runnable {
    final /* synthetic */ l a;

    bs(l lVar) {
        this.a = lVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.a.aZ != null) {
            this.a.aZ.setVisibility(4);
        }
        if (this.a.b != null && this.a.v()) {
            this.a.b.n();
        }
    }
}
