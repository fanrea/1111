package com.component.a.i;

import com.baidu.mobads.container.util.cf;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class h extends cf.a {
    final /* synthetic */ f a;

    h(f fVar) {
        this.a = fVar;
    }

    @Override // com.baidu.mobads.container.util.cf.a
    public void safeRun() {
        f.a(this.a, 100L);
        this.a.a(com.component.a.g.b.c.g, new com.component.a.b.o().b("timer", Long.valueOf(this.a.l)));
        if (this.a.k != null) {
            this.a.k.postDelayed(this, 100L);
        }
    }
}
