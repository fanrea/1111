package com.component.lottie.f;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.baidu.mobstat.forbes.Config;
import com.component.lottie.f.a.c;
import java.lang.ref.WeakReference;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class u {
    private static final float c = 100.0f;
    private static com.component.lottie.b.e<WeakReference<Interpolator>> e;
    private static final Interpolator d = new LinearInterpolator();
    static c.a a = c.a.a("t", "s", "e", Config.OS, "i", "h", TypedValues.TransitionType.S_TO, Config.FEED_LIST_PART);
    static c.a b = c.a.a("x", "y");

    u() {
    }

    private static com.component.lottie.b.e<WeakReference<Interpolator>> a() {
        if (e == null) {
            e = new com.component.lottie.b.e<>();
        }
        return e;
    }

    private static WeakReference<Interpolator> a(int i) {
        WeakReference<Interpolator> weakReferenceA;
        synchronized (u.class) {
            weakReferenceA = a().a(i);
        }
        return weakReferenceA;
    }

    private static void a(int i, WeakReference<Interpolator> weakReference) {
        synchronized (u.class) {
            e.d(i, weakReference);
        }
    }

    static <T> com.component.lottie.h.a<T> a(com.component.lottie.f.a.c cVar, com.component.lottie.t tVar, float f, ap<T> apVar, boolean z, boolean z2) {
        if (z && z2) {
            return b(tVar, cVar, f, apVar);
        }
        if (z) {
            return a(tVar, cVar, f, apVar);
        }
        return a(cVar, f, apVar);
    }

    private static <T> com.component.lottie.h.a<T> a(com.component.lottie.t tVar, com.component.lottie.f.a.c cVar, float f, ap<T> apVar) {
        Interpolator interpolatorA;
        T t;
        cVar.c();
        PointF pointFB = null;
        PointF pointFB2 = null;
        T tB = null;
        T tB2 = null;
        PointF pointFB3 = null;
        PointF pointFB4 = null;
        boolean z = false;
        float fK = 0.0f;
        while (cVar.e()) {
            switch (cVar.a(a)) {
                case 0:
                    fK = (float) cVar.k();
                    break;
                case 1:
                    tB2 = apVar.b(cVar, f);
                    break;
                case 2:
                    tB = apVar.b(cVar, f);
                    break;
                case 3:
                    pointFB = s.b(cVar, 1.0f);
                    break;
                case 4:
                    pointFB2 = s.b(cVar, 1.0f);
                    break;
                case 5:
                    if (cVar.l() != 1) {
                        z = false;
                        break;
                    } else {
                        z = true;
                        break;
                    }
                case 6:
                    pointFB3 = s.b(cVar, f);
                    break;
                case 7:
                    pointFB4 = s.b(cVar, f);
                    break;
                default:
                    cVar.m();
                    break;
            }
        }
        cVar.d();
        if (z) {
            interpolatorA = d;
            t = tB2;
        } else if (pointFB != null && pointFB2 != null) {
            interpolatorA = a(pointFB, pointFB2);
            t = tB;
        } else {
            interpolatorA = d;
            t = tB;
        }
        com.component.lottie.h.a<T> aVar = new com.component.lottie.h.a<>(tVar, tB2, t, interpolatorA, fK, null);
        aVar.h = pointFB3;
        aVar.i = pointFB4;
        return aVar;
    }

    private static <T> com.component.lottie.h.a<T> b(com.component.lottie.t tVar, com.component.lottie.f.a.c cVar, float f, ap<T> apVar) {
        Interpolator interpolatorA;
        T t;
        Interpolator interpolatorA2;
        Interpolator interpolatorA3;
        PointF pointF;
        com.component.lottie.h.a<T> aVar;
        float f2;
        float fK;
        cVar.c();
        PointF pointFB = null;
        boolean z = false;
        PointF pointFB2 = null;
        PointF pointFB3 = null;
        PointF pointF2 = null;
        T tB = null;
        PointF pointF3 = null;
        PointF pointF4 = null;
        PointF pointF5 = null;
        float fK2 = 0.0f;
        PointF pointFB4 = null;
        T tB2 = null;
        while (cVar.e()) {
            switch (cVar.a(a)) {
                case 0:
                    fK2 = (float) cVar.k();
                    pointFB = pointFB;
                    break;
                case 1:
                    tB = apVar.b(cVar, f);
                    break;
                case 2:
                    tB2 = apVar.b(cVar, f);
                    break;
                case 3:
                    PointF pointF6 = pointFB;
                    PointF pointF7 = pointFB4;
                    float f3 = fK2;
                    if (cVar.f() == c.b.BEGIN_OBJECT) {
                        cVar.c();
                        float fK3 = 0.0f;
                        float fK4 = 0.0f;
                        float fK5 = 0.0f;
                        float fK6 = 0.0f;
                        while (cVar.e()) {
                            switch (cVar.a(b)) {
                                case 0:
                                    float f4 = f3;
                                    if (cVar.f() == c.b.NUMBER) {
                                        fK5 = (float) cVar.k();
                                        fK3 = fK5;
                                        f3 = f4;
                                        break;
                                    } else {
                                        cVar.a();
                                        fK3 = (float) cVar.k();
                                        if (cVar.f() == c.b.NUMBER) {
                                            fK5 = (float) cVar.k();
                                        } else {
                                            fK5 = fK3;
                                        }
                                        cVar.b();
                                        f3 = f4;
                                        break;
                                    }
                                case 1:
                                    if (cVar.f() == c.b.NUMBER) {
                                        fK6 = (float) cVar.k();
                                        fK4 = fK6;
                                        f3 = f3;
                                        break;
                                    } else {
                                        float f5 = f3;
                                        cVar.a();
                                        fK4 = (float) cVar.k();
                                        if (cVar.f() == c.b.NUMBER) {
                                            fK6 = (float) cVar.k();
                                        } else {
                                            fK6 = fK4;
                                        }
                                        cVar.b();
                                        f3 = f5;
                                        break;
                                    }
                                default:
                                    cVar.m();
                                    break;
                            }
                        }
                        float f6 = f3;
                        PointF pointF8 = new PointF(fK3, fK4);
                        PointF pointF9 = new PointF(fK5, fK6);
                        cVar.d();
                        pointF2 = pointF8;
                        pointFB4 = pointF7;
                        fK2 = f6;
                        pointF3 = pointF9;
                        pointFB = pointF6;
                        break;
                    } else {
                        pointFB2 = s.b(cVar, f);
                        pointFB4 = pointF7;
                        pointFB = pointF6;
                        fK2 = f3;
                        break;
                    }
                case 4:
                    if (cVar.f() == c.b.BEGIN_OBJECT) {
                        cVar.c();
                        float f7 = 0.0f;
                        float fK7 = 0.0f;
                        float fK8 = 0.0f;
                        float fK9 = 0.0f;
                        while (cVar.e()) {
                            PointF pointF10 = pointFB4;
                            switch (cVar.a(b)) {
                                case 0:
                                    float f8 = fK2;
                                    if (cVar.f() == c.b.NUMBER) {
                                        fK8 = (float) cVar.k();
                                        f7 = fK8;
                                        fK2 = f8;
                                        pointFB4 = pointF10;
                                        pointFB = pointFB;
                                        break;
                                    } else {
                                        PointF pointF11 = pointFB;
                                        cVar.a();
                                        float fK10 = (float) cVar.k();
                                        if (cVar.f() == c.b.NUMBER) {
                                            f2 = fK10;
                                            fK = (float) cVar.k();
                                        } else {
                                            f2 = fK10;
                                            fK = f2;
                                        }
                                        cVar.b();
                                        f7 = f2;
                                        fK2 = f8;
                                        pointFB4 = pointF10;
                                        fK8 = fK;
                                        pointFB = pointF11;
                                        break;
                                    }
                                case 1:
                                    if (cVar.f() == c.b.NUMBER) {
                                        fK9 = (float) cVar.k();
                                        fK7 = fK9;
                                        fK2 = fK2;
                                        pointFB4 = pointF10;
                                        break;
                                    } else {
                                        float f9 = fK2;
                                        cVar.a();
                                        fK7 = (float) cVar.k();
                                        if (cVar.f() == c.b.NUMBER) {
                                            fK9 = (float) cVar.k();
                                        } else {
                                            fK9 = fK7;
                                        }
                                        cVar.b();
                                        fK2 = f9;
                                        pointFB4 = pointF10;
                                        break;
                                    }
                                default:
                                    cVar.m();
                                    pointFB4 = pointF10;
                                    break;
                            }
                        }
                        PointF pointF12 = pointFB;
                        PointF pointF13 = new PointF(f7, fK7);
                        PointF pointF14 = new PointF(fK8, fK9);
                        cVar.d();
                        pointF4 = pointF13;
                        pointF5 = pointF14;
                        pointFB4 = pointFB4;
                        pointFB = pointF12;
                        break;
                    } else {
                        pointFB3 = s.b(cVar, f);
                        pointFB4 = pointFB4;
                        break;
                    }
                case 5:
                    z = true;
                    if (cVar.l() != 1) {
                        z = false;
                        break;
                    } else {
                        break;
                    }
                case 6:
                    pointFB4 = s.b(cVar, f);
                    break;
                case 7:
                    pointFB = s.b(cVar, f);
                    break;
                default:
                    cVar.m();
                    break;
            }
        }
        PointF pointF15 = pointFB;
        float f10 = fK2;
        PointF pointF16 = pointFB4;
        cVar.d();
        if (z) {
            interpolatorA = d;
            t = tB;
            interpolatorA2 = null;
            interpolatorA3 = null;
        } else if (pointFB2 != null && pointFB3 != null) {
            interpolatorA = a(pointFB2, pointFB3);
            t = tB2;
            interpolatorA2 = null;
            interpolatorA3 = null;
        } else if (pointF2 != null && pointF3 != null && pointF4 != null && pointF5 != null) {
            interpolatorA2 = a(pointF2, pointF4);
            interpolatorA3 = a(pointF3, pointF5);
            t = tB2;
            interpolatorA = null;
        } else {
            interpolatorA = d;
            t = tB2;
            interpolatorA2 = null;
            interpolatorA3 = null;
        }
        if (interpolatorA2 == null || interpolatorA3 == null) {
            pointF = pointF16;
            aVar = new com.component.lottie.h.a<>(tVar, tB, t, interpolatorA, f10, null);
        } else {
            pointF = pointF16;
            aVar = new com.component.lottie.h.a<>(tVar, tB, t, interpolatorA2, interpolatorA3, f10, null);
        }
        aVar.h = pointF;
        aVar.i = pointF15;
        return aVar;
    }

    private static Interpolator a(PointF pointF, PointF pointF2) {
        Interpolator linearInterpolator;
        pointF.x = com.component.lottie.g.f.b(pointF.x, -1.0f, 1.0f);
        pointF.y = com.component.lottie.g.f.b(pointF.y, -100.0f, c);
        pointF2.x = com.component.lottie.g.f.b(pointF2.x, -1.0f, 1.0f);
        pointF2.y = com.component.lottie.g.f.b(pointF2.y, -100.0f, c);
        int iA = com.component.lottie.g.g.a(pointF.x, pointF.y, pointF2.x, pointF2.y);
        WeakReference<Interpolator> weakReferenceA = a(iA);
        if (weakReferenceA == null) {
            linearInterpolator = null;
        } else {
            linearInterpolator = weakReferenceA.get();
        }
        if (weakReferenceA == null || linearInterpolator == null) {
            try {
                linearInterpolator = com.component.lottie.b.d.a(pointF.x, pointF.y, pointF2.x, pointF2.y);
            } catch (IllegalArgumentException e2) {
                if ("The Path cannot loop back on itself.".equals(e2.getMessage())) {
                    linearInterpolator = com.component.lottie.b.d.a(Math.min(pointF.x, 1.0f), pointF.y, Math.max(pointF2.x, 0.0f), pointF2.y);
                } else {
                    linearInterpolator = new LinearInterpolator();
                }
            }
            try {
                a(iA, (WeakReference<Interpolator>) new WeakReference(linearInterpolator));
            } catch (RuntimeException e3) {
            }
        }
        return linearInterpolator;
    }

    private static <T> com.component.lottie.h.a<T> a(com.component.lottie.f.a.c cVar, float f, ap<T> apVar) {
        return new com.component.lottie.h.a<>(apVar.b(cVar, f));
    }
}
