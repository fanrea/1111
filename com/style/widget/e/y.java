package com.style.widget.e;

import android.view.View;
import com.component.a.a.f;
import com.component.a.f.e;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class y extends f.a {
    final /* synthetic */ View a;
    final /* synthetic */ w b;

    y(w wVar, View view) {
        this.b = wVar;
        this.a = view;
    }

    @Override // com.component.a.a.f.a
    public void c(e.h hVar) {
        if (this.b.ag.incrementAndGet() > this.b.af) {
            ((com.component.a.a.f) this.a).s();
            this.b.a(4, 2);
        }
    }
}
