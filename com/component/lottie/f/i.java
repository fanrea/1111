package com.component.lottie.f;

import com.baidu.mobstat.forbes.Config;
import com.component.lottie.d.b;
import com.component.lottie.f.a.c;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class i implements ap<com.component.lottie.d.b> {
    public static final i a = new i();
    private static final c.a b = c.a.a("t", "f", "s", "j", "tr", "lh", "ls", "fc", Config.STAT_SDK_CHANNEL, com.baidu.mobads.container.adrequest.g.f719K, "of");

    private i() {
    }

    @Override // com.component.lottie.f.ap
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public com.component.lottie.d.b b(com.component.lottie.f.a.c cVar, float f) {
        b.a aVar = b.a.CENTER;
        cVar.c();
        b.a aVar2 = aVar;
        String strI = null;
        String strI2 = null;
        float fK = 0.0f;
        int iL = 0;
        float fK2 = 0.0f;
        float fK3 = 0.0f;
        int iA = 0;
        int iA2 = 0;
        float fK4 = 0.0f;
        boolean zJ = true;
        while (cVar.e()) {
            switch (cVar.a(b)) {
                case 0:
                    strI = cVar.i();
                    break;
                case 1:
                    strI2 = cVar.i();
                    break;
                case 2:
                    fK = (float) cVar.k();
                    break;
                case 3:
                    int iL2 = cVar.l();
                    if (iL2 > b.a.CENTER.ordinal() || iL2 < 0) {
                        aVar2 = b.a.CENTER;
                        break;
                    } else {
                        aVar2 = b.a.values()[iL2];
                        break;
                    }
                    break;
                case 4:
                    iL = cVar.l();
                    break;
                case 5:
                    fK2 = (float) cVar.k();
                    break;
                case 6:
                    fK3 = (float) cVar.k();
                    break;
                case 7:
                    iA = s.a(cVar);
                    break;
                case 8:
                    iA2 = s.a(cVar);
                    break;
                case 9:
                    fK4 = (float) cVar.k();
                    break;
                case 10:
                    zJ = cVar.j();
                    break;
                default:
                    cVar.h();
                    cVar.m();
                    break;
            }
        }
        cVar.d();
        return new com.component.lottie.d.b(strI, strI2, fK, aVar2, iL, fK2, fK3, iA, iA2, fK4, zJ);
    }
}
