package com.component.lottie.f;

import android.graphics.PointF;
import com.baidu.mobstat.forbes.Config;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.component.lottie.d.b.j;
import com.component.lottie.f.a.c;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class ae {
    private static final c.a a = c.a.a("nm", "sy", Config.PLATFORM_TYPE, "p", com.kuaishou.weapon.p0.t.k, "or", "os", "ir", "is", LiveConfigKey.HIGH, "d");

    private ae() {
    }

    static com.component.lottie.d.b.j a(com.component.lottie.f.a.c cVar, com.component.lottie.t tVar, int i) {
        boolean z = i == 3;
        String strI = null;
        j.a aVarA = null;
        com.component.lottie.d.a.b bVarA = null;
        com.component.lottie.d.a.m<PointF, PointF> mVarB = null;
        com.component.lottie.d.a.b bVarA2 = null;
        com.component.lottie.d.a.b bVarA3 = null;
        com.component.lottie.d.a.b bVarA4 = null;
        com.component.lottie.d.a.b bVarA5 = null;
        com.component.lottie.d.a.b bVarA6 = null;
        boolean zJ = false;
        while (cVar.e()) {
            switch (cVar.a(a)) {
                case 0:
                    strI = cVar.i();
                    break;
                case 1:
                    aVarA = j.a.a(cVar.l());
                    break;
                case 2:
                    bVarA = d.a(cVar, tVar, false);
                    break;
                case 3:
                    mVarB = a.b(cVar, tVar);
                    break;
                case 4:
                    bVarA2 = d.a(cVar, tVar, false);
                    break;
                case 5:
                    bVarA4 = d.a(cVar, tVar);
                    break;
                case 6:
                    bVarA6 = d.a(cVar, tVar, false);
                    break;
                case 7:
                    bVarA3 = d.a(cVar, tVar);
                    break;
                case 8:
                    bVarA5 = d.a(cVar, tVar, false);
                    break;
                case 9:
                    zJ = cVar.j();
                    break;
                case 10:
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
        return new com.component.lottie.d.b.j(strI, aVarA, bVarA, mVarB, bVarA2, bVarA3, bVarA4, bVarA5, bVarA6, zJ, z);
    }
}
