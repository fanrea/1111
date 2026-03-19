package com.component.a.g.c;

import android.view.ViewGroup;
import com.component.a.g.c.m;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class q extends m.c {
    final /* synthetic */ m.d d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    q(m.d dVar, ViewGroup viewGroup) {
        super(viewGroup);
        this.d = dVar;
    }

    @Override // com.component.a.g.c.m.c
    public void a(boolean z) {
        if (!z) {
            if (this.c != null) {
                this.c.setAlpha(0.5f);
            }
            if (this.d.p != null) {
                this.d.p.setAlpha(0.5f);
            }
            this.d.h();
        }
    }
}
