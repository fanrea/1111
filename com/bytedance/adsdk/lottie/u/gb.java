package com.bytedance.adsdk.lottie.u;

import android.graphics.Path;
import android.graphics.PointF;
import com.bytedance.adsdk.lottie.model.hc.k;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class gb {
    private static final PointF d = new PointF();

    public static boolean b(float f, float f2, float f3) {
        return f >= f2 && f <= f3;
    }

    public static float d(float f, float f2, float f3) {
        return f + (f3 * (f2 - f));
    }

    public static int d(int i, int i2, float f) {
        return (int) (i + (f * (i2 - i)));
    }

    public static PointF d(PointF pointF, PointF pointF2) {
        return new PointF(pointF.x + pointF2.x, pointF.y + pointF2.y);
    }

    public static void d(k kVar, Path path) {
        path.reset();
        PointF pointFD = kVar.d();
        path.moveTo(pointFD.x, pointFD.y);
        d.set(pointFD.x, pointFD.y);
        for (int i = 0; i < kVar.b().size(); i++) {
            com.bytedance.adsdk.lottie.model.d dVar = kVar.b().get(i);
            PointF pointFD2 = dVar.d();
            PointF pointFHc = dVar.hc();
            PointF pointFB = dVar.b();
            PointF pointF = d;
            if (pointFD2.equals(pointF) && pointFHc.equals(pointFB)) {
                path.lineTo(pointFB.x, pointFB.y);
            } else {
                path.cubicTo(pointFD2.x, pointFD2.y, pointFHc.x, pointFHc.y, pointFB.x, pointFB.y);
            }
            pointF.set(pointFB.x, pointFB.y);
        }
        if (kVar.hc()) {
            path.close();
        }
    }

    static int d(float f, float f2) {
        return d((int) f, (int) f2);
    }

    private static int d(int i, int i2) {
        return i - (i2 * hc(i, i2));
    }

    private static int hc(int i, int i2) {
        int i3 = i / i2;
        return (((i ^ i2) >= 0) || i % i2 == 0) ? i3 : i3 - 1;
    }

    public static int d(int i, int i2, int i3) {
        return Math.max(i2, Math.min(i3, i));
    }

    public static float hc(float f, float f2, float f3) {
        return Math.max(f2, Math.min(f3, f));
    }
}
