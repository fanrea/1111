package com.component.a.g.c;

import com.baidu.mobads.container.util.cf;
import com.component.a.g.c.aa;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class ar extends cf.a {
    final /* synthetic */ aa.f a;

    ar(aa.f fVar) {
        this.a = fVar;
    }

    @Override // com.baidu.mobads.container.util.cf.a
    public void safeRun() {
        if (this.a.g != null) {
            this.a.n();
            cf.a(this.a.e, 4);
            cf.a(this.a.b, 4);
            cf.a(this.a.d, 4);
            cf.a(this.a.j, 4);
            this.a.g.a(new as(this));
            this.a.g.setVisibility(0);
            this.a.g.f();
        }
    }
}
