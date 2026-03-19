package com.component.a.g.c;

import com.baidu.mobads.container.util.cf;
import com.component.a.g.c.br;
import com.component.a.i.f;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class bt extends cf.a {
    final /* synthetic */ br.c a;

    bt(br.c cVar) {
        this.a = cVar;
    }

    @Override // com.baidu.mobads.container.util.cf.a
    public void safeRun() {
        com.component.a.i.f lifeCycle;
        if (!this.a.b() && (this.a.c instanceof com.component.a.c.c) && (lifeCycle = ((com.component.a.c.c) this.a.c).getLifeCycle()) != null) {
            lifeCycle.a((f.a) new bu(this, lifeCycle));
        }
    }
}
