package com.component.a.g.c;

import com.component.a.a.f;
import com.component.a.f.e;
import com.component.a.g.c.m;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class p extends f.a {
    final /* synthetic */ boolean a;
    final /* synthetic */ m.c b;

    p(m.c cVar, boolean z) {
        this.b = cVar;
        this.a = z;
    }

    @Override // com.component.a.a.f.a
    public void a(e.h hVar, boolean z) {
        if (!z) {
            this.b.c.b(this);
            if (this.a) {
                this.b.c.setVisibility(4);
                this.b.b.setVisibility(0);
            }
            this.b.a(this.a);
        }
    }
}
