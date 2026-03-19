package com.component.lottie.f;

import android.graphics.Path;
import com.baidu.mobstat.forbes.Config;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.component.lottie.f.a.c;
import java.util.Collections;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class p {
    private static final c.a a = c.a.a("nm", "g", Config.OS, "t", "s", "e", com.kuaishou.weapon.p0.t.k, LiveConfigKey.HIGH);
    private static final c.a b = c.a.a("p", "k");

    private p() {
    }

    static com.component.lottie.d.b.e a(com.component.lottie.f.a.c cVar, com.component.lottie.t tVar) {
        com.component.lottie.d.a.d dVarB = null;
        Path.FillType fillType = Path.FillType.WINDING;
        String strI = null;
        com.component.lottie.d.b.g gVar = null;
        com.component.lottie.d.a.c cVarA = null;
        com.component.lottie.d.a.f fVarC = null;
        com.component.lottie.d.a.f fVarC2 = null;
        boolean zJ = false;
        while (cVar.e()) {
            switch (cVar.a(a)) {
                case 0:
                    strI = cVar.i();
                    break;
                case 1:
                    cVar.c();
                    int iL = -1;
                    while (cVar.e()) {
                        switch (cVar.a(b)) {
                            case 0:
                                iL = cVar.l();
                                break;
                            case 1:
                                cVarA = d.a(cVar, tVar, iL);
                                break;
                            default:
                                cVar.h();
                                cVar.m();
                                break;
                        }
                    }
                    cVar.d();
                    break;
                case 2:
                    dVarB = d.b(cVar, tVar);
                    break;
                case 3:
                    gVar = cVar.l() == 1 ? com.component.lottie.d.b.g.LINEAR : com.component.lottie.d.b.g.RADIAL;
                    break;
                case 4:
                    fVarC = d.c(cVar, tVar);
                    break;
                case 5:
                    fVarC2 = d.c(cVar, tVar);
                    break;
                case 6:
                    fillType = cVar.l() == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD;
                    break;
                case 7:
                    zJ = cVar.j();
                    break;
                default:
                    cVar.h();
                    cVar.m();
                    break;
            }
        }
        return new com.component.lottie.d.b.e(strI, gVar, fillType, cVarA, dVarB == null ? new com.component.lottie.d.a.d(Collections.singletonList(new com.component.lottie.h.a(100))) : dVarB, fVarC, fVarC2, null, null, zJ);
    }
}
