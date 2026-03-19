package com.baidu.mobads.container.components.g;

import com.baidu.mobads.container.util.o;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class g implements a {
    final /* synthetic */ f a;

    g(f fVar) {
        this.a = fVar;
    }

    @Override // com.baidu.mobads.container.components.g.a
    public void a(String str, int i) {
        if (this.a.j != null) {
            this.a.j.a(str, i);
        }
        if (this.a.k != null) {
            this.a.k.a(str, i);
        }
    }

    @Override // com.baidu.mobads.container.components.g.a
    public void a(d dVar, k kVar) {
        String strI = o.i(this.a.l);
        if (this.a.j != null) {
            this.a.j.a(kVar.b());
            this.a.j.a(kVar.e(), strI);
        }
        if (this.a.k != null) {
            this.a.k.a(strI, kVar);
        }
    }
}
