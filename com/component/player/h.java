package com.component.player;

import com.baidu.mobads.container.util.cm;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class h implements Runnable {
    final /* synthetic */ cm a;
    final /* synthetic */ f b;

    h(f fVar, cm cmVar) {
        this.b = fVar;
        this.a = cmVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        u uVar = (u) this.b.t.get();
        if (uVar != null) {
            uVar.a(this.a);
        }
    }
}
