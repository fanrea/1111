package com.baidu.mobads.container.e;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class ax implements Runnable {
    final /* synthetic */ l a;

    ax(l lVar) {
        this.a = lVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.a.bc != null) {
            this.a.bc.setVisibility(8);
            this.a.bc = null;
        }
        if (this.a.bi != null) {
            this.a.bi.setVisibility(8);
            this.a.bi = null;
        }
    }
}
