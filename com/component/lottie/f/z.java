package com.component.lottie.f;

import android.text.TextUtils;
import com.baidu.mobstat.forbes.Config;
import com.bytedance.sdk.djx.core.log.ILogConst;
import com.component.lottie.d.b.h;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class z {
    private z() {
    }

    static com.component.lottie.d.b.h a(com.component.lottie.f.a.c cVar, com.component.lottie.t tVar) {
        cVar.c();
        h.a aVar = null;
        com.component.lottie.d.a.h hVarE = null;
        com.component.lottie.d.a.d dVarB = null;
        boolean zJ = false;
        while (cVar.e()) {
            String strG = cVar.g();
            if (TextUtils.equals(ILogConst.Keys.KEY_MODE, strG)) {
                String strI = cVar.i();
                if (TextUtils.equals("a", strI)) {
                    aVar = h.a.MASK_MODE_ADD;
                } else if (TextUtils.equals("s", strI)) {
                    aVar = h.a.MASK_MODE_SUBTRACT;
                } else if (TextUtils.equals("n", strI)) {
                    aVar = h.a.MASK_MODE_NONE;
                } else if (TextUtils.equals("i", strI)) {
                    tVar.a("Animation contains intersect masks. They are not supported but will be treated like add masks.");
                    aVar = h.a.MASK_MODE_INTERSECT;
                } else {
                    com.component.lottie.g.c.b("Unknown mask mode " + strG + ". Defaulting to Add.");
                    aVar = h.a.MASK_MODE_ADD;
                }
            } else if (TextUtils.equals(Config.PLATFORM_TYPE, strG)) {
                hVarE = d.e(cVar, tVar);
            } else if (TextUtils.equals(Config.OS, strG)) {
                dVarB = d.b(cVar, tVar);
            } else if (TextUtils.equals("inv", strG)) {
                zJ = cVar.j();
            } else {
                cVar.m();
            }
        }
        cVar.d();
        return new com.component.lottie.d.b.h(aVar, hVarE, dVarB, zJ);
    }
}
