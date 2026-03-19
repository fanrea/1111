package com.component.feed;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class at implements Runnable {
    final /* synthetic */ ar a;

    at(ar arVar) {
        this.a = arVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.a.o != null) {
            this.a.o.cancel();
            this.a.o = null;
        }
    }
}
