package com.component.lottie.f;

import android.graphics.Color;
import android.graphics.PointF;
import com.component.lottie.f.a.c;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class s {
    private static final c.a a = c.a.a("x", "y");

    private s() {
    }

    static int a(com.component.lottie.f.a.c cVar) {
        cVar.a();
        int iK = (int) (cVar.k() * 255.0d);
        int iK2 = (int) (cVar.k() * 255.0d);
        int iK3 = (int) (cVar.k() * 255.0d);
        while (cVar.e()) {
            cVar.m();
        }
        cVar.b();
        return Color.argb(255, iK, iK2, iK3);
    }

    static List<PointF> a(com.component.lottie.f.a.c cVar, float f) {
        ArrayList arrayList = new ArrayList();
        cVar.a();
        while (cVar.f() == c.b.BEGIN_ARRAY) {
            cVar.a();
            arrayList.add(b(cVar, f));
            cVar.b();
        }
        cVar.b();
        return arrayList;
    }

    static PointF b(com.component.lottie.f.a.c cVar, float f) {
        switch (cVar.f()) {
            case NUMBER:
                return c(cVar, f);
            case BEGIN_ARRAY:
                return d(cVar, f);
            case BEGIN_OBJECT:
                return e(cVar, f);
            default:
                throw new IllegalArgumentException("Unknown point starts with " + cVar.f());
        }
    }

    private static PointF c(com.component.lottie.f.a.c cVar, float f) {
        float fK = (float) cVar.k();
        float fK2 = (float) cVar.k();
        while (cVar.e()) {
            cVar.m();
        }
        return new PointF(fK * f, fK2 * f);
    }

    private static PointF d(com.component.lottie.f.a.c cVar, float f) {
        cVar.a();
        float fK = (float) cVar.k();
        float fK2 = (float) cVar.k();
        while (cVar.f() != c.b.END_ARRAY) {
            cVar.m();
        }
        cVar.b();
        return new PointF(fK * f, fK2 * f);
    }

    private static PointF e(com.component.lottie.f.a.c cVar, float f) {
        cVar.c();
        float fB = 0.0f;
        float fB2 = 0.0f;
        while (cVar.e()) {
            switch (cVar.a(a)) {
                case 0:
                    fB = b(cVar);
                    break;
                case 1:
                    fB2 = b(cVar);
                    break;
                default:
                    cVar.h();
                    cVar.m();
                    break;
            }
        }
        cVar.d();
        return new PointF(fB * f, fB2 * f);
    }

    static float b(com.component.lottie.f.a.c cVar) {
        c.b bVarF = cVar.f();
        switch (bVarF) {
            case NUMBER:
                return (float) cVar.k();
            case BEGIN_ARRAY:
                cVar.a();
                float fK = (float) cVar.k();
                while (cVar.e()) {
                    cVar.m();
                }
                cVar.b();
                return fK;
            default:
                throw new IllegalArgumentException("Unknown value for token of type " + bVarF);
        }
    }
}
