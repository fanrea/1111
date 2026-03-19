package com.component.lottie.f;

import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.component.lottie.f.a.c;
import java.util.ArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class al {
    private static final c.a a = c.a.a("nm", LiveConfigKey.HIGH, "it");

    private al() {
    }

    static com.component.lottie.d.b.p a(com.component.lottie.f.a.c cVar, com.component.lottie.t tVar) {
        ArrayList arrayList = new ArrayList();
        String strI = null;
        boolean zJ = false;
        while (cVar.e()) {
            switch (cVar.a(a)) {
                case 0:
                    strI = cVar.i();
                    break;
                case 1:
                    zJ = cVar.j();
                    break;
                case 2:
                    cVar.a();
                    while (cVar.e()) {
                        com.component.lottie.d.b.c cVarA = h.a(cVar, tVar);
                        if (cVarA != null) {
                            arrayList.add(cVarA);
                        }
                    }
                    cVar.b();
                    break;
                default:
                    cVar.m();
                    break;
            }
        }
        return new com.component.lottie.d.b.p(strI, arrayList, zJ);
    }
}
