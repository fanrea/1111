package com.component.lottie.f;

import com.baidu.mobstat.forbes.Config;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.component.lottie.d.b.t;
import com.component.lottie.f.a.c;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class ao {
    private static final c.a a = c.a.a("s", "e", Config.OS, "nm", "m", LiveConfigKey.HIGH);

    private ao() {
    }

    static com.component.lottie.d.b.t a(com.component.lottie.f.a.c cVar, com.component.lottie.t tVar) {
        String strI = null;
        t.a aVarA = null;
        com.component.lottie.d.a.b bVarA = null;
        com.component.lottie.d.a.b bVarA2 = null;
        com.component.lottie.d.a.b bVarA3 = null;
        boolean zJ = false;
        while (cVar.e()) {
            switch (cVar.a(a)) {
                case 0:
                    bVarA = d.a(cVar, tVar, false);
                    break;
                case 1:
                    bVarA2 = d.a(cVar, tVar, false);
                    break;
                case 2:
                    bVarA3 = d.a(cVar, tVar, false);
                    break;
                case 3:
                    strI = cVar.i();
                    break;
                case 4:
                    aVarA = t.a.a(cVar.l());
                    break;
                case 5:
                    zJ = cVar.j();
                    break;
                default:
                    cVar.m();
                    break;
            }
        }
        return new com.component.lottie.d.b.t(strI, aVarA, bVarA, bVarA2, bVarA3, zJ);
    }
}
