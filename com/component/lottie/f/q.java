package com.component.lottie.f;

import android.text.TextUtils;
import com.baidu.mobstat.forbes.Config;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.component.lottie.d.b.r;
import com.component.lottie.f.a.c;
import java.util.ArrayList;
import java.util.Collections;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class q {
    private static final c.a a = c.a.a("nm", "g", Config.OS, "t", "s", "e", "w", "lc", "lj", "ml", LiveConfigKey.HIGH, "d");
    private static final c.a b = c.a.a("p", "k");
    private static final c.a c = c.a.a("n", "v");

    private q() {
    }

    static com.component.lottie.d.b.f a(com.component.lottie.f.a.c cVar, com.component.lottie.t tVar) {
        ArrayList arrayList = new ArrayList();
        String strI = null;
        com.component.lottie.d.b.g gVar = null;
        com.component.lottie.d.a.c cVarA = null;
        com.component.lottie.d.a.f fVarC = null;
        com.component.lottie.d.a.f fVarC2 = null;
        com.component.lottie.d.a.b bVarA = null;
        r.a aVar = null;
        r.b bVar = null;
        float fK = 0.0f;
        com.component.lottie.d.a.b bVar2 = null;
        boolean zJ = false;
        com.component.lottie.d.a.d dVar = null;
        while (cVar.e()) {
            switch (cVar.a(a)) {
                case 0:
                    strI = cVar.i();
                    break;
                case 1:
                    String str = strI;
                    cVar.c();
                    int iL = -1;
                    while (cVar.e()) {
                        switch (cVar.a(b)) {
                            case 0:
                                iL = cVar.l();
                                break;
                            case 1:
                                cVarA = d.a(cVar, tVar, iL);
                                break;
                            default:
                                cVar.h();
                                cVar.m();
                                break;
                        }
                    }
                    cVar.d();
                    strI = str;
                    break;
                case 2:
                    dVar = d.b(cVar, tVar);
                    break;
                case 3:
                    String str2 = strI;
                    gVar = cVar.l() == 1 ? com.component.lottie.d.b.g.LINEAR : com.component.lottie.d.b.g.RADIAL;
                    strI = str2;
                    break;
                case 4:
                    fVarC = d.c(cVar, tVar);
                    break;
                case 5:
                    fVarC2 = d.c(cVar, tVar);
                    break;
                case 6:
                    bVarA = d.a(cVar, tVar);
                    break;
                case 7:
                    aVar = r.a.values()[cVar.l() - 1];
                    strI = strI;
                    break;
                case 8:
                    bVar = r.b.values()[cVar.l() - 1];
                    strI = strI;
                    break;
                case 9:
                    fK = (float) cVar.k();
                    strI = strI;
                    break;
                case 10:
                    zJ = cVar.j();
                    break;
                case 11:
                    cVar.a();
                    while (cVar.e()) {
                        cVar.c();
                        String strI2 = null;
                        com.component.lottie.d.a.b bVarA2 = null;
                        while (cVar.e()) {
                            switch (cVar.a(c)) {
                                case 0:
                                    strI2 = cVar.i();
                                    break;
                                case 1:
                                    bVarA2 = d.a(cVar, tVar);
                                    break;
                                default:
                                    cVar.h();
                                    cVar.m();
                                    break;
                            }
                        }
                        cVar.d();
                        if (TextUtils.equals(strI2, Config.OS)) {
                            bVar2 = bVarA2;
                        } else if (TextUtils.equals(strI2, "d") || TextUtils.equals(strI2, "g")) {
                            tVar.a(true);
                            arrayList.add(bVarA2);
                        }
                    }
                    cVar.b();
                    if (arrayList.size() != 1) {
                        break;
                    } else {
                        arrayList.add((com.component.lottie.d.a.b) arrayList.get(0));
                        break;
                    }
                default:
                    cVar.h();
                    cVar.m();
                    break;
            }
        }
        String str3 = strI;
        if (dVar == null) {
            dVar = new com.component.lottie.d.a.d(Collections.singletonList(new com.component.lottie.h.a(100)));
        }
        return new com.component.lottie.d.b.f(str3, gVar, cVarA, dVar, fVarC, fVarC2, bVarA, aVar, bVar, fK, arrayList, bVar2, zJ);
    }
}
