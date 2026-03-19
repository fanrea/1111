package com.style.widget;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class q implements Runnable {
    final /* synthetic */ j a;

    q(j jVar) {
        this.a = jVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.a.by != null) {
            this.a.by.cancel();
            this.a.by = null;
        }
    }
}
