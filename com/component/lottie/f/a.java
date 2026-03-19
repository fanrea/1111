package com.component.lottie.f;

import android.graphics.PointF;
import com.component.lottie.f.a.c;
import java.util.ArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class a {
    private static final c.a a = c.a.a("k", "x", "y");

    private a() {
    }

    public static com.component.lottie.d.a.e a(com.component.lottie.f.a.c cVar, com.component.lottie.t tVar) {
        ArrayList arrayList = new ArrayList();
        if (cVar.f() == c.b.BEGIN_ARRAY) {
            cVar.a();
            while (cVar.e()) {
                arrayList.add(ab.a(cVar, tVar));
            }
            cVar.b();
            v.a(arrayList);
        } else {
            arrayList.add(new com.component.lottie.h.a(s.b(cVar, com.component.lottie.g.g.a())));
        }
        return new com.component.lottie.d.a.e(arrayList);
    }

    static com.component.lottie.d.a.m<PointF, PointF> b(com.component.lottie.f.a.c cVar, com.component.lottie.t tVar) {
        cVar.c();
        com.component.lottie.d.a.e eVarA = null;
        com.component.lottie.d.a.b bVarA = null;
        com.component.lottie.d.a.b bVarA2 = null;
        boolean z = false;
        while (cVar.f() != c.b.END_OBJECT) {
            switch (cVar.a(a)) {
                case 0:
                    eVarA = a(cVar, tVar);
                    break;
                case 1:
                    if (cVar.f() == c.b.STRING) {
                        cVar.m();
                        z = true;
                        break;
                    } else {
                        bVarA = d.a(cVar, tVar);
                        break;
                    }
                case 2:
                    if (cVar.f() == c.b.STRING) {
                        cVar.m();
                        z = true;
                        break;
                    } else {
                        bVarA2 = d.a(cVar, tVar);
                        break;
                    }
                default:
                    cVar.h();
                    cVar.m();
                    break;
            }
        }
        cVar.d();
        if (z) {
            tVar.a("Lottie doesn't support expressions.");
        }
        if (eVarA != null) {
            return eVarA;
        }
        return new com.component.lottie.d.a.i(bVarA, bVarA2);
    }
}
