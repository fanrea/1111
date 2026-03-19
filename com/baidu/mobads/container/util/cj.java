package com.baidu.mobads.container.util;

import com.baidu.mobads.container.util.ci;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class cj implements Runnable {
    final /* synthetic */ ci.c a;
    final /* synthetic */ boolean b;
    final /* synthetic */ ci c;

    cj(ci ciVar, ci.c cVar, boolean z) {
        this.c = ciVar;
        this.a = cVar;
        this.b = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        ci.b bVarB = this.a.b();
        if (bVarB != null) {
            bVarB.a(this.a.a(), this.b);
        }
    }
}
