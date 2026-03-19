package com.component.a.g.c;

import android.text.TextUtils;
import com.component.a.a.f;
import com.component.a.f.e;
import com.component.a.g.c.v;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class z extends f.a {
    final /* synthetic */ v.a.C0318a a;

    z(v.a.C0318a c0318a) {
        this.a = c0318a;
    }

    @Override // com.component.a.a.f.a
    public void a(e.h hVar, boolean z) {
        String strC = hVar.c("");
        com.component.a.f.b bVarB = com.component.a.f.b.b(hVar.d(""));
        if (TextUtils.equals("guide", strC) && bVarB == com.component.a.f.b.LONG_CLICK && !z) {
            if (v.a.this.c == null) {
                v.a.this.b();
            } else {
                v.a.this.b.a(4, true);
                v.a.this.c.setVisibility(0);
                v.a.this.c.a(this);
                v.a.this.c.E();
            }
            com.baidu.mobads.container.util.g.c.a(v.a.this.b, 5);
            return;
        }
        if (TextUtils.equals("atmosphere", strC) && bVarB == com.component.a.f.b.NORMAL && v.a.this.c != null && !z) {
            v.a.this.c.b(this);
            v.a.this.b.setVisibility(0);
            v.a.this.c.setVisibility(4);
            v.a.this.b();
        }
    }
}
