package com.component.feed;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class aq implements Runnable {
    final /* synthetic */ an a;

    aq(an anVar) {
        this.a = anVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.a.i != null) {
            this.a.i.cancel();
            this.a.i = null;
        }
    }
}
