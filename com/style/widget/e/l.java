package com.style.widget.e;

import android.text.TextUtils;
import com.component.a.b.e;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class l implements e.a {
    final /* synthetic */ f a;

    l(f fVar) {
        this.a = fVar;
    }

    @Override // com.component.a.b.e.a
    public void a(com.component.a.b.e eVar, com.component.a.b.j jVar, com.component.a.b.o oVar) {
        if (TextUtils.equals("pause_video", jVar.a())) {
            if (this.a.k != null) {
                this.a.k.m();
            }
        } else if (TextUtils.equals("resume_video", jVar.a()) && this.a.k != null) {
            this.a.k.n();
        }
    }
}
