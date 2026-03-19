package com.baidu.mobads.container.s;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class e implements Runnable {
    final /* synthetic */ d a;

    e(d dVar) {
        this.a = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.a.c != null) {
            this.a.c.start();
        }
        if (this.a.e != null) {
            this.a.e.start();
        }
        if (this.a.g != null) {
            this.a.g.start();
        }
    }
}
