package com.component.lottie.g;

import android.graphics.Path;
import android.graphics.PointF;
import com.component.lottie.a.a.l;
import com.component.lottie.d.b.n;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class f {
    private static final PointF a = new PointF();

    public static PointF a(PointF pointF, PointF pointF2) {
        return new PointF(pointF.x + pointF2.x, pointF.y + pointF2.y);
    }

    public static void a(n nVar, Path path) {
        path.reset();
        PointF pointFA = nVar.a();
        path.moveTo(pointFA.x, pointFA.y);
        a.set(pointFA.x, pointFA.y);
        for (int i = 0; i < nVar.c().size(); i++) {
            com.component.lottie.d.a aVar = nVar.c().get(i);
            PointF pointFA2 = aVar.a();
            PointF pointFB = aVar.b();
            PointF pointFC = aVar.c();
            if (pointFA2.equals(a) && pointFB.equals(pointFC)) {
                path.lineTo(pointFC.x, pointFC.y);
            } else {
                path.cubicTo(pointFA2.x, pointFA2.y, pointFB.x, pointFB.y, pointFC.x, pointFC.y);
            }
            a.set(pointFC.x, pointFC.y);
        }
        if (nVar.b()) {
            path.close();
        }
    }

    public static float a(float f, float f2, float f3) {
        return f + (f3 * (f2 - f));
    }

    public static double a(double d, double d2, double d3) {
        return d + (d3 * (d2 - d));
    }

    public static int a(int i, int i2, float f) {
        return (int) (i + (f * (i2 - i)));
    }

    static int a(float f, float f2) {
        return a((int) f, (int) f2);
    }

    private static int a(int i, int i2) {
        return i - (i2 * b(i, i2));
    }

    private static int b(int i, int i2) {
        int i3 = i / i2;
        boolean z = (i ^ i2) >= 0;
        int i4 = i % i2;
        if (!z && i4 != 0) {
            return i3 - 1;
        }
        return i3;
    }

    public static int a(int i, int i2, int i3) {
        return Math.max(i2, Math.min(i3, i));
    }

    public static float b(float f, float f2, float f3) {
        return Math.max(f2, Math.min(f3, f));
    }

    public static double b(double d, double d2, double d3) {
        return Math.max(d2, Math.min(d3, d));
    }

    public static boolean c(float f, float f2, float f3) {
        return f >= f2 && f <= f3;
    }

    public static void a(com.component.lottie.d.e eVar, int i, List<com.component.lottie.d.e> list, com.component.lottie.d.e eVar2, l lVar) {
        if (eVar.c(lVar.b(), i)) {
            list.add(eVar2.a(lVar.b()).a(lVar));
        }
    }
}
