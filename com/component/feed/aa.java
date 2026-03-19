package com.component.feed;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class aa implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ z b;

    aa(z zVar, int i) {
        this.b = zVar;
        this.a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.a == this.b.a.O()) {
            this.b.a.aw.sendEmptyMessage(this.a);
        }
    }
}
