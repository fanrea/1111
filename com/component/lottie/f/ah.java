package com.component.lottie.f;

import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.component.lottie.f.a.c;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class ah {
    private static final c.a a = c.a.a("nm", com.kuaishou.weapon.p0.t.k, LiveConfigKey.HIGH);

    private ah() {
    }

    static com.component.lottie.d.b.m a(com.component.lottie.f.a.c cVar, com.component.lottie.t tVar) {
        boolean zJ = false;
        String strI = null;
        com.component.lottie.d.a.b bVarA = null;
        while (cVar.e()) {
            switch (cVar.a(a)) {
                case 0:
                    strI = cVar.i();
                    break;
                case 1:
                    bVarA = d.a(cVar, tVar, true);
                    break;
                case 2:
                    zJ = cVar.j();
                    break;
                default:
                    cVar.m();
                    break;
            }
        }
        if (zJ) {
            return null;
        }
        return new com.component.lottie.d.b.m(strI, bVarA);
    }
}
