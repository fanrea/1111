package com.component.a;

import android.view.MotionEvent;
import android.view.View;
import com.component.a.d.c;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class d implements c.b {
    final /* synthetic */ com.component.a.f.e a;
    final /* synthetic */ c b;

    d(c cVar, com.component.a.f.e eVar) {
        this.b = cVar;
        this.a = eVar;
    }

    @Override // com.component.a.d.c.b
    public void a(View view, boolean z, MotionEvent motionEvent, MotionEvent motionEvent2) {
        com.component.a.f.d dVar = new com.component.a.f.d(view, com.component.a.f.d.d, this.a);
        dVar.a(view, 1, motionEvent, motionEvent2);
        this.b.c.c(dVar);
    }
}
