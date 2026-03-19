package com.component.lottie.f;

import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.component.lottie.d.b.i;
import com.component.lottie.f.a.c;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class aa {
    private static final c.a a = c.a.a("nm", "mm", LiveConfigKey.HIGH);

    private aa() {
    }

    static com.component.lottie.d.b.i a(com.component.lottie.f.a.c cVar) {
        String strI = null;
        i.a aVarA = null;
        boolean zJ = false;
        while (cVar.e()) {
            switch (cVar.a(a)) {
                case 0:
                    strI = cVar.i();
                    break;
                case 1:
                    aVarA = i.a.a(cVar.l());
                    break;
                case 2:
                    zJ = cVar.j();
                    break;
                default:
                    cVar.h();
                    cVar.m();
                    break;
            }
        }
        return new com.component.lottie.d.b.i(strI, aVarA, zJ);
    }
}
