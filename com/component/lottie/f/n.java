package com.component.lottie.f;

import com.component.lottie.f.a.c;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class n {
    private static final c.a a = c.a.a("fFamily", "fName", "fStyle", "ascent");

    private n() {
    }

    static com.component.lottie.d.c a(com.component.lottie.f.a.c cVar) {
        cVar.c();
        String strI = null;
        String strI2 = null;
        String strI3 = null;
        float fK = 0.0f;
        while (cVar.e()) {
            switch (cVar.a(a)) {
                case 0:
                    strI = cVar.i();
                    break;
                case 1:
                    strI2 = cVar.i();
                    break;
                case 2:
                    strI3 = cVar.i();
                    break;
                case 3:
                    fK = (float) cVar.k();
                    break;
                default:
                    cVar.h();
                    cVar.m();
                    break;
            }
        }
        cVar.d();
        return new com.component.lottie.d.c(strI, strI2, strI3, fK);
    }
}
