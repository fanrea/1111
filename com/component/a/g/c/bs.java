package com.component.a.g.c;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.mobads.container.s.al;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class bs implements al.a {
    final /* synthetic */ View a;
    final /* synthetic */ com.component.a.f.e b;
    final /* synthetic */ String c;
    final /* synthetic */ br d;

    bs(br brVar, View view, com.component.a.f.e eVar, String str) {
        this.d = brVar;
        this.a = view;
        this.b = eVar;
        this.c = str;
    }

    @Override // com.baidu.mobads.container.s.al.a
    public void a(View view, boolean z, MotionEvent motionEvent, MotionEvent motionEvent2) {
        if (this.d.mFlyweight != null) {
            com.component.a.f.d dVar = new com.component.a.f.d(this.a, com.component.a.f.d.d, this.b);
            dVar.a(view, 1, motionEvent, motionEvent2);
            dVar.a(this.b.l(""), this.c);
            this.d.mFlyweight.a(dVar);
        }
    }
}
