package com.component.a.g.c;

import android.view.View;
import com.component.a.g.c.aa;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class ak implements View.OnClickListener {
    final /* synthetic */ List a;
    final /* synthetic */ com.component.a.a.f b;
    final /* synthetic */ aa.c c;

    ak(aa.c cVar, List list, com.component.a.a.f fVar) {
        this.c = cVar;
        this.a = list;
        this.b = fVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.c.a((List<com.component.a.a.f>) this.a, this.b);
    }
}
