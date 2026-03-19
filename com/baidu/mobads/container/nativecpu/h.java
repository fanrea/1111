package com.baidu.mobads.container.nativecpu;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class h implements Runnable {
    final /* synthetic */ g a;

    h(g gVar) {
        this.a = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.a.c = true;
            this.a.a(com.baidu.mobads.container.c.a.REQUEST_TIMEOUT.b(), com.baidu.mobads.container.c.a.REQUEST_TIMEOUT.c());
        } catch (Exception e) {
        }
    }
}
