package com.component.lottie.f;

import android.graphics.PointF;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.component.lottie.f.a.c;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class f {
    private static final c.a a = c.a.a("nm", "p", "s", LiveConfigKey.HIGH, "d");

    private f() {
    }

    static com.component.lottie.d.b.b a(com.component.lottie.f.a.c cVar, com.component.lottie.t tVar, int i) {
        boolean z = i == 3;
        String strI = null;
        com.component.lottie.d.a.m<PointF, PointF> mVarB = null;
        com.component.lottie.d.a.f fVarC = null;
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
                    zJ = cVar.j();
                    break;
                case 4:
                    if (cVar.l() != 3) {
                        z = false;
                        break;
                    } else {
                        z = true;
                        break;
                    }
                default:
                    cVar.h();
                    cVar.m();
                    break;
            }
        }
        return new com.component.lottie.d.b.b(strI, mVarB, fVarC, z, zJ);
    }
}
