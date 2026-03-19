package com.component.lottie.f;

import android.graphics.PointF;
import com.baidu.mobstat.forbes.Config;
import com.component.lottie.f.a.c;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class c {
    private static final c.a a = c.a.a("a", "p", "s", "rz", com.kuaishou.weapon.p0.t.k, Config.OS, "so", "eo", "sk", "sa");
    private static final c.a b = c.a.a("k");

    private c() {
    }

    public static com.component.lottie.d.a.l a(com.component.lottie.f.a.c cVar, com.component.lottie.t tVar) {
        com.component.lottie.d.a.e eVar;
        com.component.lottie.d.a.m<PointF, PointF> mVar;
        com.component.lottie.d.a.b bVar;
        com.component.lottie.d.a.b bVar2;
        com.component.lottie.d.a.b bVar3;
        boolean z = false;
        boolean z2 = cVar.f() == c.b.BEGIN_OBJECT;
        if (z2) {
            cVar.c();
        }
        com.component.lottie.d.a.b bVar4 = null;
        com.component.lottie.d.a.e eVarA = null;
        com.component.lottie.d.a.m<PointF, PointF> mVarB = null;
        com.component.lottie.d.a.g gVarD = null;
        com.component.lottie.d.a.b bVarA = null;
        com.component.lottie.d.a.b bVarA2 = null;
        com.component.lottie.d.a.d dVarB = null;
        com.component.lottie.d.a.b bVarA3 = null;
        com.component.lottie.d.a.b bVarA4 = null;
        while (cVar.e()) {
            switch (cVar.a(a)) {
                case 0:
                    cVar.c();
                    while (cVar.e()) {
                        switch (cVar.a(b)) {
                            case 0:
                                eVarA = a.a(cVar, tVar);
                                break;
                            default:
                                cVar.h();
                                cVar.m();
                                break;
                        }
                    }
                    cVar.d();
                    z = false;
                    continue;
                case 1:
                    mVarB = a.b(cVar, tVar);
                    z = false;
                    continue;
                case 2:
                    gVarD = d.d(cVar, tVar);
                    z = false;
                    continue;
                case 3:
                    tVar.a("Lottie doesn't support 3D layers.");
                    break;
                case 4:
                    break;
                case 5:
                    dVarB = d.b(cVar, tVar);
                    continue;
                case 6:
                    bVarA3 = d.a(cVar, tVar, z);
                    continue;
                case 7:
                    bVarA4 = d.a(cVar, tVar, z);
                    continue;
                case 8:
                    bVarA = d.a(cVar, tVar, z);
                    continue;
                case 9:
                    bVarA2 = d.a(cVar, tVar, z);
                    continue;
                default:
                    cVar.h();
                    cVar.m();
                    z = false;
                    continue;
            }
            com.component.lottie.d.a.b bVarA5 = d.a(cVar, tVar, z);
            if (bVarA5.c().isEmpty()) {
                bVarA5.c().add(new com.component.lottie.h.a(tVar, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(tVar.h())));
            } else if (((com.component.lottie.h.a) bVarA5.c().get(0)).a == 0) {
                bVarA5.c().set(0, new com.component.lottie.h.a(tVar, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(tVar.h())));
            }
            bVar4 = bVarA5;
            z = false;
        }
        if (z2) {
            cVar.d();
        }
        if (!a(eVarA)) {
            eVar = eVarA;
        } else {
            eVar = null;
        }
        if (!a(mVarB)) {
            mVar = mVarB;
        } else {
            mVar = null;
        }
        if (!a(bVar4)) {
            bVar = bVar4;
        } else {
            bVar = null;
        }
        if (a(gVarD)) {
            gVarD = null;
        }
        if (!b(bVarA)) {
            bVar2 = bVarA;
        } else {
            bVar2 = null;
        }
        if (!c(bVarA2)) {
            bVar3 = bVarA2;
        } else {
            bVar3 = null;
        }
        return new com.component.lottie.d.a.l(eVar, mVar, gVarD, bVar, dVarB, bVarA3, bVarA4, bVar2, bVar3);
    }

    private static boolean a(com.component.lottie.d.a.e eVar) {
        return eVar == null || (eVar.b() && eVar.c().get(0).a.equals(0.0f, 0.0f));
    }

    private static boolean a(com.component.lottie.d.a.m<PointF, PointF> mVar) {
        return mVar == null || (!(mVar instanceof com.component.lottie.d.a.i) && mVar.b() && mVar.c().get(0).a.equals(0.0f, 0.0f));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean a(com.component.lottie.d.a.b bVar) {
        return bVar == null || (bVar.b() && ((Float) ((com.component.lottie.h.a) bVar.c().get(0)).a).floatValue() == 0.0f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean a(com.component.lottie.d.a.g gVar) {
        return gVar == null || (gVar.b() && ((com.component.lottie.h.k) ((com.component.lottie.h.a) gVar.c().get(0)).a).b(1.0f, 1.0f));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean b(com.component.lottie.d.a.b bVar) {
        return bVar == null || (bVar.b() && ((Float) ((com.component.lottie.h.a) bVar.c().get(0)).a).floatValue() == 0.0f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean c(com.component.lottie.d.a.b bVar) {
        return bVar == null || (bVar.b() && ((Float) ((com.component.lottie.h.a) bVar.c().get(0)).a).floatValue() == 0.0f);
    }
}
