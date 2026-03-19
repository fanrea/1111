package com.baidu.mobads.container.e;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class x implements Runnable {
    final /* synthetic */ l a;

    x(l lVar) {
        this.a = lVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.a.aA != null) {
            this.a.aA.setVisibility(8);
        }
    }
}
