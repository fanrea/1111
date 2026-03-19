package com.baidu.mobads.container.e;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class h implements Runnable {
    final /* synthetic */ f a;

    h(f fVar) {
        this.a = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.a.x != null) {
            this.a.U = this.a.x.a();
            com.baidu.mobads.container.util.h.a(new i(this));
        }
    }
}
