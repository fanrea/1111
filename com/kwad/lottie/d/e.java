package com.kwad.lottie.d;

import android.graphics.Path;
import android.graphics.PointF;
import com.kwad.lottie.a.a.j;
import com.kwad.lottie.model.content.h;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class e {
    public static double b(double d, double d2, double d3) {
        return d + (d3 * (d2 - d));
    }

    public static boolean c(float f, float f2, float f3) {
        return f >= f2 && f <= f3;
    }

    public static float lerp(float f, float f2, float f3) {
        return f + (f3 * (f2 - f));
    }

    public static int lerp(int i, int i2, float f) {
        return (int) (i + (f * (i2 - i)));
    }

    public static PointF a(PointF pointF, PointF pointF2) {
        return new PointF(pointF.x + pointF2.x, pointF.y + pointF2.y);
    }

    public static void a(h hVar, Path path) {
        path.reset();
        PointF pointFRT = hVar.RT();
        path.moveTo(pointFRT.x, pointFRT.y);
        PointF pointF = new PointF(pointFRT.x, pointFRT.y);
        for (int i = 0; i < hVar.RU().size(); i++) {
            com.kwad.lottie.model.a aVar = hVar.RU().get(i);
            PointF pointFRa = aVar.Ra();
            PointF pointFRb = aVar.Rb();
            PointF pointFRc = aVar.Rc();
            if (pointFRa.equals(pointF) && pointFRb.equals(pointFRc)) {
                path.lineTo(pointFRc.x, pointFRc.y);
            } else {
                path.cubicTo(pointFRa.x, pointFRa.y, pointFRb.x, pointFRb.y, pointFRc.x, pointFRc.y);
            }
            pointF.set(pointFRc.x, pointFRc.y);
        }
        if (hVar.isClosed()) {
            path.close();
        }
    }

    static int m(float f, float f2) {
        return floorMod((int) f, (int) f2);
    }

    private static int floorMod(int i, int i2) {
        return i - (i2 * floorDiv(i, i2));
    }

    private static int floorDiv(int i, int i2) {
        int i3 = i / i2;
        return (((i ^ i2) >= 0) || i % i2 == 0) ? i3 : i3 - 1;
    }

    public static int clamp(int i, int i2, int i3) {
        return Math.max(0, Math.min(255, i));
    }

    public static float clamp(float f, float f2, float f3) {
        return Math.max(f2, Math.min(f3, f));
    }

    public static void a(com.kwad.lottie.model.e eVar, int i, List<com.kwad.lottie.model.e> list, com.kwad.lottie.model.e eVar2, j jVar) {
        if (eVar.s(jVar.getName(), i)) {
            list.add(eVar2.dp(jVar.getName()).a(jVar));
        }
    }
}
