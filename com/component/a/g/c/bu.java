package com.component.a.g.c;

import android.view.View;
import com.baidu.mobads.container.util.cf;
import com.component.a.i.f;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class bu extends f.a {
    final /* synthetic */ com.component.a.i.f a;
    final /* synthetic */ bt b;

    bu(bt btVar, com.component.a.i.f fVar) {
        this.b = btVar;
        this.a = fVar;
    }

    @Override // com.component.a.i.f.a
    public void a(View view, int i) {
        if (!this.b.a.g && i == 0) {
            cf.a(this.b.a.c, new bv(this));
        } else if (this.b.a.g) {
            this.a.b((f.a) this);
        }
    }
}
