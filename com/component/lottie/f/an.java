package com.component.lottie.f;

import android.text.TextUtils;
import com.baidu.mobstat.forbes.Config;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.component.lottie.d.b.r;
import com.component.lottie.f.a.c;
import java.util.ArrayList;
import java.util.Collections;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class an {
    private static final c.a a = c.a.a("nm", "c", "w", Config.OS, "lc", "lj", "ml", LiveConfigKey.HIGH, "d");
    private static final c.a b = c.a.a("n", "v");

    private an() {
    }

    static com.component.lottie.d.b.r a(com.component.lottie.f.a.c cVar, com.component.lottie.t tVar) {
        ArrayList arrayList = new ArrayList();
        String strI = null;
        com.component.lottie.d.a.b bVar = null;
        com.component.lottie.d.a.a aVarG = null;
        com.component.lottie.d.a.b bVarA = null;
        r.a aVar = null;
        r.b bVar2 = null;
        float fK = 0.0f;
        boolean zJ = false;
        com.component.lottie.d.a.d dVar = null;
        while (cVar.e()) {
            switch (cVar.a(a)) {
                case 0:
                    strI = cVar.i();
                    break;
                case 1:
                    aVarG = d.g(cVar, tVar);
                    break;
                case 2:
                    bVarA = d.a(cVar, tVar);
                    break;
                case 3:
                    dVar = d.b(cVar, tVar);
                    break;
                case 4:
                    aVar = r.a.values()[cVar.l() - 1];
                    break;
                case 5:
                    bVar2 = r.b.values()[cVar.l() - 1];
                    break;
                case 6:
                    fK = (float) cVar.k();
                    break;
                case 7:
                    zJ = cVar.j();
                    break;
                case 8:
                    cVar.a();
                    while (cVar.e()) {
                        cVar.c();
                        String strI2 = null;
                        com.component.lottie.d.a.b bVarA2 = null;
                        while (cVar.e()) {
                            switch (cVar.a(b)) {
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
                            bVar = bVarA2;
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
                    break;
                default:
                    cVar.m();
                    break;
            }
        }
        if (dVar == null) {
            dVar = new com.component.lottie.d.a.d(Collections.singletonList(new com.component.lottie.h.a(100)));
        }
        return new com.component.lottie.d.b.r(strI, bVar, arrayList, aVarG, dVar, bVarA, aVar, bVar2, fK, zJ);
    }
}
