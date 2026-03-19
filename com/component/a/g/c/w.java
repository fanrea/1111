package com.component.a.g.c;

import android.view.MotionEvent;
import android.view.View;
import com.component.a.g.c.v;
import com.component.a.i.t;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class w extends t.b {
    final /* synthetic */ String a;
    final /* synthetic */ v b;

    w(v vVar, String str) {
        this.b = vVar;
        this.a = str;
    }

    @Override // com.component.a.i.t.b
    public void a(View view, MotionEvent motionEvent) {
        v.a aVar = (v.a) this.b.a.get(this.a);
        if (aVar != null && aVar.b != null) {
            aVar.d = MotionEvent.obtainNoHistory(motionEvent);
            aVar.b.E();
        }
    }

    @Override // com.component.a.i.t.b
    public void b(View view, MotionEvent motionEvent) {
        v.a aVar = (v.a) this.b.a.get(this.a);
        if (aVar != null && aVar.b != null) {
            aVar.d = MotionEvent.obtainNoHistory(motionEvent);
            aVar.b.a(com.component.a.f.b.LONG_CLICK);
        }
    }

    @Override // com.component.a.i.t.b
    public void c(View view, MotionEvent motionEvent) {
        v.a aVar = (v.a) this.b.a.get(this.a);
        if (aVar != null) {
            aVar.d = MotionEvent.obtainNoHistory(motionEvent);
            aVar.b();
        }
    }
}
