package com.component.lottie.f;

import com.baidu.mobstat.forbes.Config;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.component.lottie.f.a.c;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class ag {
    private static final c.a a = c.a.a("nm", "c", Config.OS, "tr", LiveConfigKey.HIGH);

    private ag() {
    }

    static com.component.lottie.d.b.l a(com.component.lottie.f.a.c cVar, com.component.lottie.t tVar) {
        String strI = null;
        com.component.lottie.d.a.b bVarA = null;
        com.component.lottie.d.a.b bVarA2 = null;
        com.component.lottie.d.a.l lVarA = null;
        boolean zJ = false;
        while (cVar.e()) {
            switch (cVar.a(a)) {
                case 0:
                    strI = cVar.i();
                    break;
                case 1:
                    bVarA = d.a(cVar, tVar, false);
                    break;
                case 2:
                    bVarA2 = d.a(cVar, tVar, false);
                    break;
                case 3:
                    lVarA = c.a(cVar, tVar);
                    break;
                case 4:
                    zJ = cVar.j();
                    break;
                default:
                    cVar.m();
                    break;
            }
        }
        return new com.component.lottie.d.b.l(strI, bVarA, bVarA2, lVarA, zJ);
    }
}
