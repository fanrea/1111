package com.baidu.mobads.container.util.animation;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class an implements Runnable {
    final /* synthetic */ am a;

    an(am amVar) {
        this.a = amVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.a.d.i != null) {
            this.a.d.i.b();
        }
        if (this.a.d.h != null) {
            this.a.d.h.b();
        }
        this.a.d.a(this.a.b, this.a.c);
    }
}
