package com.baidu.mobads.container.nativecpu;

import android.widget.RelativeLayout;
import com.baidu.mobads.container.util.cf;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class bb extends cf.a {
    final /* synthetic */ RelativeLayout a;
    final /* synthetic */ t b;

    bb(t tVar, RelativeLayout relativeLayout) {
        this.b = tVar;
        this.a = relativeLayout;
    }

    @Override // com.baidu.mobads.container.util.cf.a
    public void safeRun() {
        this.b.a(this.b.c, this.a);
        this.b.b(this.b.c, this.a);
    }
}
