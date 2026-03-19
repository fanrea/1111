package com.style.widget.e;

import com.baidu.mobads.container.util.cf;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class g extends cf.a {
    final /* synthetic */ f a;

    g(f fVar) {
        this.a = fVar;
    }

    @Override // com.baidu.mobads.container.util.cf.a
    public void safeRun() {
        this.a.a(com.component.a.g.b.b.e, new com.component.a.b.o().b("timer", Long.valueOf(this.a.H)));
        f.a(this.a, 200L);
        if (this.a.H <= 300000) {
            this.a.F.postDelayed(this, 200L);
        }
    }
}
