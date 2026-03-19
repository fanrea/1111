package com.component.lottie.f;

import com.baidu.mobstat.forbes.Config;
import com.component.lottie.f.a.c;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class b {
    private static final c.a a = c.a.a("a");
    private static final c.a b = c.a.a("fc", Config.STAT_SDK_CHANNEL, com.baidu.mobads.container.adrequest.g.f719K, "t");

    private b() {
    }

    public static com.component.lottie.d.a.k a(com.component.lottie.f.a.c cVar, com.component.lottie.t tVar) {
        cVar.c();
        com.component.lottie.d.a.k kVarB = null;
        while (cVar.e()) {
            switch (cVar.a(a)) {
                case 0:
                    kVarB = b(cVar, tVar);
                    break;
                default:
                    cVar.h();
                    cVar.m();
                    break;
            }
        }
        cVar.d();
        if (kVarB == null) {
            return new com.component.lottie.d.a.k(null, null, null, null);
        }
        return kVarB;
    }

    private static com.component.lottie.d.a.k b(com.component.lottie.f.a.c cVar, com.component.lottie.t tVar) {
        cVar.c();
        com.component.lottie.d.a.a aVarG = null;
        com.component.lottie.d.a.a aVarG2 = null;
        com.component.lottie.d.a.b bVarA = null;
        com.component.lottie.d.a.b bVarA2 = null;
        while (cVar.e()) {
            switch (cVar.a(b)) {
                case 0:
                    aVarG = d.g(cVar, tVar);
                    break;
                case 1:
                    aVarG2 = d.g(cVar, tVar);
                    break;
                case 2:
                    bVarA = d.a(cVar, tVar);
                    break;
                case 3:
                    bVarA2 = d.a(cVar, tVar);
                    break;
                default:
                    cVar.h();
                    cVar.m();
                    break;
            }
        }
        cVar.d();
        return new com.component.lottie.d.a.k(aVarG, aVarG2, bVarA, bVarA2);
    }
}
