package com.component.lottie.f;

import android.text.TextUtils;
import com.baidu.mobstat.forbes.Config;
import com.component.lottie.f.a.c;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class h {
    private static final c.a a = c.a.a("ty", "d");

    private h() {
    }

    static com.component.lottie.d.b.c a(com.component.lottie.f.a.c cVar, com.component.lottie.t tVar) {
        com.component.lottie.d.b.c cVarA;
        String strI;
        cVar.c();
        int iL = 2;
        while (true) {
            cVarA = null;
            if (!cVar.e()) {
                strI = null;
            } else {
                switch (cVar.a(a)) {
                    case 0:
                        strI = cVar.i();
                        break;
                    case 1:
                        iL = cVar.l();
                        break;
                    default:
                        cVar.h();
                        cVar.m();
                        break;
                }
            }
        }
        if (strI == null) {
            return null;
        }
        if (TextUtils.equals("gr", strI)) {
            cVarA = al.a(cVar, tVar);
        } else if (TextUtils.equals(Config.STAT_SDK_TYPE, strI)) {
            cVarA = an.a(cVar, tVar);
        } else if (TextUtils.equals("gs", strI)) {
            cVarA = q.a(cVar, tVar);
        } else if (TextUtils.equals("fl", strI)) {
            cVarA = ak.a(cVar, tVar);
        } else if (TextUtils.equals("gf", strI)) {
            cVarA = p.a(cVar, tVar);
        } else if (TextUtils.equals("tr", strI)) {
            cVarA = c.a(cVar, tVar);
        } else if (TextUtils.equals("sh", strI)) {
            cVarA = am.a(cVar, tVar);
        } else if (TextUtils.equals(com.kuaishou.weapon.p0.t.n, strI)) {
            cVarA = f.a(cVar, tVar, iL);
        } else if (TextUtils.equals("rc", strI)) {
            cVarA = af.a(cVar, tVar);
        } else if (TextUtils.equals("tm", strI)) {
            cVarA = ao.a(cVar, tVar);
        } else if (TextUtils.equals("sr", strI)) {
            cVarA = ae.a(cVar, tVar, iL);
        } else if (TextUtils.equals("mm", strI)) {
            cVarA = aa.a(cVar);
            tVar.a("Animation contains merge paths. Merge paths are only supported on KitKat+ and must be manually enabled by calling enableMergePathsForKitKatAndAbove().");
        } else if (TextUtils.equals("rp", strI)) {
            cVarA = ag.a(cVar, tVar);
        } else if (TextUtils.equals("rd", strI)) {
            cVarA = ah.a(cVar, tVar);
        } else {
            com.component.lottie.g.c.b("Unknown shape type " + strI);
        }
        while (cVar.e()) {
            cVar.m();
        }
        cVar.d();
        return cVarA;
    }
}
