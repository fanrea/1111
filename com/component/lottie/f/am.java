package com.component.lottie.f;

import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.component.lottie.f.a.c;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class am {
    static c.a a = c.a.a("nm", "ind", "ks", LiveConfigKey.HIGH);

    private am() {
    }

    static com.component.lottie.d.b.q a(com.component.lottie.f.a.c cVar, com.component.lottie.t tVar) {
        String strI = null;
        com.component.lottie.d.a.h hVarE = null;
        int iL = 0;
        boolean zJ = false;
        while (cVar.e()) {
            switch (cVar.a(a)) {
                case 0:
                    strI = cVar.i();
                    break;
                case 1:
                    iL = cVar.l();
                    break;
                case 2:
                    hVarE = d.e(cVar, tVar);
                    break;
                case 3:
                    zJ = cVar.j();
                    break;
                default:
                    cVar.m();
                    break;
            }
        }
        return new com.component.lottie.d.b.q(strI, iL, hVarE, zJ);
    }
}
