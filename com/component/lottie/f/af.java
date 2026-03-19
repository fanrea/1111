package com.component.lottie.f;

import android.graphics.PointF;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.component.lottie.f.a.c;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class af {
    private static final c.a a = c.a.a("nm", "p", "s", com.kuaishou.weapon.p0.t.k, LiveConfigKey.HIGH);

    private af() {
    }

    static com.component.lottie.d.b.k a(com.component.lottie.f.a.c cVar, com.component.lottie.t tVar) {
        String strI = null;
        com.component.lottie.d.a.m<PointF, PointF> mVarB = null;
        com.component.lottie.d.a.f fVarC = null;
        com.component.lottie.d.a.b bVarA = null;
        boolean zJ = false;
        while (cVar.e()) {
            switch (cVar.a(a)) {
                case 0:
                    strI = cVar.i();
                    break;
                case 1:
                    mVarB = a.b(cVar, tVar);
                    break;
                case 2:
                    fVarC = d.c(cVar, tVar);
                    break;
                case 3:
                    bVarA = d.a(cVar, tVar);
                    break;
                case 4:
                    zJ = cVar.j();
                    break;
                default:
                    cVar.m();
                    break;
            }
        }
        return new com.component.lottie.d.b.k(strI, mVarB, fVarC, bVarA, zJ);
    }
}
