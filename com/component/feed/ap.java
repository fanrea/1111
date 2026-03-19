package com.component.feed;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class ap implements Runnable {
    final /* synthetic */ an a;

    ap(an anVar) {
        this.a = anVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.a.i != null) {
            this.a.i.start();
        }
    }
}
