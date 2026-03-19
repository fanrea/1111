package com.baidu.mobads.container.nativecpu;

import com.component.a.g.c.bm;
import com.style.widget.e.f;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class ba implements f.a {
    final /* synthetic */ a a;
    final /* synthetic */ boolean b;
    final /* synthetic */ t c;

    ba(t tVar, a aVar, boolean z) {
        this.c = tVar;
        this.a = aVar;
        this.b = z;
    }

    @Override // com.style.widget.e.f.a
    public boolean a(com.component.a.f.d dVar) {
        return false;
    }

    @Override // com.style.widget.e.f.a
    public void a(String str, com.component.a.f.d dVar) {
        if (bm.h.equals(str)) {
            this.a.handleClick(dVar.e(), this.b);
        }
    }
}
