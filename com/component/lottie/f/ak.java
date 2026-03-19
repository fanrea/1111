package com.component.lottie.f;

import android.graphics.Path;
import com.baidu.mobstat.forbes.Config;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.component.lottie.f.a.c;
import java.util.Collections;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class ak {
    private static final c.a a = c.a.a("nm", "c", Config.OS, "fillEnabled", com.kuaishou.weapon.p0.t.k, LiveConfigKey.HIGH);

    private ak() {
    }

    static com.component.lottie.d.b.o a(com.component.lottie.f.a.c cVar, com.component.lottie.t tVar) {
        com.component.lottie.d.a.d dVarB = null;
        String strI = null;
        com.component.lottie.d.a.a aVarG = null;
        int iL = 1;
        boolean zJ = false;
        boolean zJ2 = false;
        while (cVar.e()) {
            switch (cVar.a(a)) {
                case 0:
                    strI = cVar.i();
                    break;
                case 1:
                    aVarG = d.g(cVar, tVar);
                    break;
                case 2:
                    dVarB = d.b(cVar, tVar);
                    break;
                case 3:
                    zJ = cVar.j();
                    break;
                case 4:
                    iL = cVar.l();
                    break;
                case 5:
                    zJ2 = cVar.j();
                    break;
                default:
                    cVar.h();
                    cVar.m();
                    break;
            }
        }
        return new com.component.lottie.d.b.o(strI, zJ, iL == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD, aVarG, dVarB == null ? new com.component.lottie.d.a.d(Collections.singletonList(new com.component.lottie.h.a(100))) : dVarB, zJ2);
    }
}
