package com.component.lottie.f;

import android.text.TextUtils;
import com.component.lottie.f.a.c;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class k {
    private static final c.a a = c.a.a("ef");
    private static final c.a b = c.a.a("nm", "v");
    private com.component.lottie.d.a.a c;
    private com.component.lottie.d.a.b d;
    private com.component.lottie.d.a.b e;
    private com.component.lottie.d.a.b f;
    private com.component.lottie.d.a.b g;

    j a(com.component.lottie.f.a.c cVar, com.component.lottie.t tVar) {
        while (cVar.e()) {
            switch (cVar.a(a)) {
                case 0:
                    cVar.a();
                    while (cVar.e()) {
                        b(cVar, tVar);
                    }
                    cVar.b();
                    break;
                default:
                    cVar.h();
                    cVar.m();
                    break;
            }
        }
        if (this.c != null && this.d != null && this.e != null && this.f != null && this.g != null) {
            return new j(this.c, this.d, this.e, this.f, this.g);
        }
        return null;
    }

    private void b(com.component.lottie.f.a.c cVar, com.component.lottie.t tVar) {
        cVar.c();
        String strI = "";
        while (cVar.e()) {
            switch (cVar.a(b)) {
                case 0:
                    strI = cVar.i();
                    break;
                case 1:
                    if (TextUtils.equals("Shadow Color", strI)) {
                        this.c = d.g(cVar, tVar);
                        break;
                    } else if (TextUtils.equals("Opacity", strI)) {
                        this.d = d.a(cVar, tVar, false);
                        break;
                    } else if (TextUtils.equals("Direction", strI)) {
                        this.e = d.a(cVar, tVar, false);
                        break;
                    } else if (TextUtils.equals("Distance", strI)) {
                        this.f = d.a(cVar, tVar);
                        break;
                    } else if (TextUtils.equals("Softness", strI)) {
                        this.g = d.a(cVar, tVar);
                        break;
                    } else {
                        cVar.m();
                        break;
                    }
                default:
                    cVar.h();
                    cVar.m();
                    break;
            }
        }
        cVar.d();
    }
}
