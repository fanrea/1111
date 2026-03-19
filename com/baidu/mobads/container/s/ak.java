package com.baidu.mobads.container.s;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class ak implements Runnable {
    final /* synthetic */ ab a;

    ak(ab abVar) {
        this.a = abVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!this.a.q.F) {
            if (this.a.e != null) {
                this.a.e.cancel();
            }
        } else if (this.a.q.G == 1) {
            if (this.a.l != null) {
                this.a.l.b();
            }
        } else if (this.a.k != null) {
            this.a.k.b();
        }
        if (this.a.o != null) {
            this.a.o.s();
        }
    }
}
