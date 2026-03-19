package com.component.a.g.c;

import android.view.View;
import com.component.a.f.e;
import com.component.a.g.c.v;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class x implements View.OnClickListener {
    final /* synthetic */ e.h a;
    final /* synthetic */ v.a.C0318a b;

    x(v.a.C0318a c0318a, e.h hVar) {
        this.b = c0318a;
        this.a = hVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.component.a.f.d dVarA = v.a.this.a(v.a.this.a, this.a);
        if (dVarA != null) {
            dVarA.a(v.a.this.a, 0, v.a.this.d, v.a.this.d);
            v.a.this.g.a(dVarA);
        }
    }
}
