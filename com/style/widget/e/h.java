package com.style.widget.e;

import com.style.widget.e.f;
import java.util.Iterator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class h implements com.component.player.o {
    final /* synthetic */ f a;

    h(f fVar) {
        this.a = fVar;
    }

    @Override // com.component.player.o
    public void a(int i, float f) {
        if (this.a.t != null && this.a.t.i()) {
            this.a.t.b(i);
        }
        if (this.a.u != null && this.a.u.i()) {
            this.a.u.b(i);
        }
        Iterator it = this.a.D.iterator();
        while (it.hasNext()) {
            ((f.b) it.next()).a(i);
        }
    }
}
