package com.component.lottie.f;

import com.component.lottie.f.a.c;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class e {
    private static final c.a a = c.a.a("ef");
    private static final c.a b = c.a.a("ty", "v");

    e() {
    }

    static com.component.lottie.d.b.a a(com.component.lottie.f.a.c cVar, com.component.lottie.t tVar) {
        com.component.lottie.d.b.a aVar = null;
        while (cVar.e()) {
            switch (cVar.a(a)) {
                case 0:
                    cVar.a();
                    while (cVar.e()) {
                        com.component.lottie.d.b.a aVarB = b(cVar, tVar);
                        if (aVarB != null) {
                            aVar = aVarB;
                        }
                    }
                    cVar.b();
                    break;
                default:
                    cVar.h();
                    cVar.m();
                    break;
            }
        }
        return aVar;
    }

    private static com.component.lottie.d.b.a b(com.component.lottie.f.a.c cVar, com.component.lottie.t tVar) {
        cVar.c();
        com.component.lottie.d.b.a aVar = null;
        boolean z = false;
        while (cVar.e()) {
            switch (cVar.a(b)) {
                case 0:
                    if (cVar.l() != 0) {
                        z = false;
                        break;
                    } else {
                        z = true;
                        break;
                    }
                case 1:
                    if (z) {
                        aVar = new com.component.lottie.d.b.a(d.a(cVar, tVar));
                        break;
                    } else {
                        cVar.m();
                        break;
                    }
                default:
                    cVar.h();
                    cVar.m();
                    break;
            }
        }
        cVar.d();
        return aVar;
    }
}
