package com.baidu.mobads.container.adrequest;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class q implements Runnable {
    final /* synthetic */ o a;

    q(o oVar) {
        this.a = oVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.a.J = true;
            this.a.t = System.currentTimeMillis();
            this.a.p.a(this.a.f720K, com.baidu.mobads.container.components.h.a.AD_EVENT_REQUEST_TIMEOUT);
            this.a.q.a(this.a.F, 408, this.a.t - this.a.w);
            this.a.a(com.baidu.mobads.container.c.a.REQUEST_TIMEOUT.b(), com.baidu.mobads.container.c.a.REQUEST_TIMEOUT.c());
        } catch (Exception e) {
            this.a.y.a(e);
        }
    }
}
