package com.style.widget.e;

import android.view.View;
import com.baidu.mobads.container.util.cf;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class n extends cf.a {
    final /* synthetic */ View a;
    final /* synthetic */ String b;
    final /* synthetic */ f c;

    n(f fVar, View view, String str) {
        this.c = fVar;
        this.a = view;
        this.b = str;
    }

    @Override // com.baidu.mobads.container.util.cf.a
    public void safeRun() {
        this.c.y = this.c.f.getBaseAdContainer().createPxCloseView(this.a, this.c.A, this.c.B, new o(this));
    }
}
