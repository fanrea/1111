package com.component.a.i;

import android.view.View;
import com.baidu.mobads.container.util.cf;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class g extends cf.a {
    final /* synthetic */ View a;
    final /* synthetic */ f b;

    g(f fVar, View view) {
        this.b = fVar;
        this.a = view;
    }

    @Override // com.baidu.mobads.container.util.cf.a
    public void safeRun() {
        this.b.a(com.baidu.mobads.container.util.r.d(this.a) == 0 && this.a.getWindowVisibility() == 0);
    }
}
