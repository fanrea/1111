package com.baidu.mobads.container.e;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class bx implements Runnable {
    final /* synthetic */ l a;

    bx(l lVar) {
        this.a = lVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.a.h != null) {
            this.a.h.cancel();
        }
        if (this.a.aS != null) {
            this.a.aS.cancel();
        }
        if (this.a.aT != null) {
            this.a.aT.cancel();
        }
    }
}
