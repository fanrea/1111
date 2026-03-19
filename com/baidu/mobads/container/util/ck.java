package com.baidu.mobads.container.util;

import com.baidu.mobads.container.util.ci;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class ck implements Runnable {
    final /* synthetic */ ci.c a;
    final /* synthetic */ ci b;

    ck(ci ciVar, ci.c cVar) {
        this.b = ciVar;
        this.a = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ci.b bVarB = this.a.b();
        if (bVarB instanceof ci.a) {
            ((ci.a) bVarB).a(this.a.a());
        }
    }
}
