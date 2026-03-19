package com.baidu.mobads.container.s;

import android.view.View;
import com.baidu.mobads.container.util.cf;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class i extends cf.a {
    final /* synthetic */ View a;
    final /* synthetic */ int b;
    final /* synthetic */ int c;
    final /* synthetic */ int d;
    final /* synthetic */ int e;
    final /* synthetic */ g f;

    i(g gVar, View view, int i, int i2, int i3, int i4) {
        this.f = gVar;
        this.a = view;
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = i4;
    }

    @Override // com.baidu.mobads.container.util.cf.a
    public void safeRun() {
        al.a(this.f, this.a, new j(this), true, this.b, true, false, -1, this.f.g.getWidth(), this.f.g.getHeight() + this.c, this.d, this.e);
    }
}
