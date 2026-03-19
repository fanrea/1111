package com.baidu.mobads.container.e;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class av implements Runnable {
    final /* synthetic */ au a;

    av(au auVar) {
        this.a = auVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.a.C.setVisibility(0);
        if (this.a.a.bc != null) {
            this.a.a.bc.setVisibility(0);
        }
    }
}
