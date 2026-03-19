package com.baidu.mobads.container.landingpage;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class v implements Runnable {
    final /* synthetic */ u a;

    v(u uVar) {
        this.a = uVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.b.curWebview.stopLoading();
    }
}
