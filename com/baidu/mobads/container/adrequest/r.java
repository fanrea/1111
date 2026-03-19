package com.baidu.mobads.container.adrequest;

import com.baidu.mobads.container.util.cm;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class r implements Runnable {
    final /* synthetic */ o a;

    r(o oVar) {
        this.a = oVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        cm cmVar;
        this.a.o();
        this.a.y();
        if (this.a.h == null) {
            this.a.b(com.baidu.mobads.container.c.a.AD_CONTAINER_NULL.b(), com.baidu.mobads.container.c.a.AD_CONTAINER_NULL.c());
            this.a.p.a(this.a.f720K, com.baidu.mobads.container.components.h.a.AD_EVENT_RESPONSE_CALLBACK_FAILED);
            return;
        }
        if (this.a.f != null) {
            cmVar = new cm(com.baidu.mobads.container.components.k.b.s, this.a.f.p());
        } else {
            cmVar = new cm(com.baidu.mobads.container.components.k.b.s);
        }
        this.a.dispatchEvent(cmVar);
        if (!this.a.I) {
            this.a.y.a(o.a, "handleAllReady");
            this.a.p();
        }
    }
}
