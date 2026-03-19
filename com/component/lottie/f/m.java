package com.component.lottie.f;

import com.component.lottie.f.a.c;
import java.util.ArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class m {
    private static final c.a a = c.a.a("ch", "size", "w", "style", "fFamily", "data");
    private static final c.a b = c.a.a("shapes");

    private m() {
    }

    static com.component.lottie.d.d a(com.component.lottie.f.a.c cVar, com.component.lottie.t tVar) {
        ArrayList arrayList = new ArrayList();
        cVar.c();
        double dK = 0.0d;
        String strI = null;
        String strI2 = null;
        double dK2 = 0.0d;
        char cCharAt = 0;
        while (cVar.e()) {
            switch (cVar.a(a)) {
                case 0:
                    cCharAt = cVar.i().charAt(0);
                    break;
                case 1:
                    dK2 = cVar.k();
                    break;
                case 2:
                    dK = cVar.k();
                    break;
                case 3:
                    strI = cVar.i();
                    break;
                case 4:
                    strI2 = cVar.i();
                    break;
                case 5:
                    cVar.c();
                    while (cVar.e()) {
                        switch (cVar.a(b)) {
                            case 0:
                                cVar.a();
                                while (cVar.e()) {
                                    arrayList.add((com.component.lottie.d.b.p) h.a(cVar, tVar));
                                }
                                cVar.b();
                                break;
                            default:
                                cVar.h();
                                cVar.m();
                                break;
                        }
                    }
                    cVar.d();
                    break;
                default:
                    cVar.h();
                    cVar.m();
                    break;
            }
        }
        cVar.d();
        return new com.component.lottie.d.d(arrayList, cCharAt, dK2, dK, strI, strI2);
    }
}
