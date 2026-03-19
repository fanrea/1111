package com.tachikoma.lottie.d;

import android.graphics.Path;
import android.graphics.PointF;
import com.tachikoma.lottie.a.a.k;
import com.tachikoma.lottie.model.content.h;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class e {
    private static PointF NC = new PointF();

    public static double a(double d, double d2, double d3) {
        return d + (d3 * (d2 - d));
    }

    public static int a(int i, int i2, float f) {
        return (int) (i + (f * (i2 - i)));
    }

    public static float c(float f, float f2, float f3) {
        return f + (f3 * (f2 - f));
    }

    public static boolean e(float f, float f2, float f3) {
        return f >= f2 && f <= f3;
    }

    public static PointF a(PointF pointF, PointF pointF2) {
        return new PointF(pointF.x + pointF2.x, pointF.y + pointF2.y);
    }

    public static void a(h hVar, Path path) {
        path.reset();
        PointF pointFLq = hVar.lq();
        path.moveTo(pointFLq.x, pointFLq.y);
        NC.set(pointFLq.x, pointFLq.y);
        for (int i = 0; i < hVar.lr().size(); i++) {
            com.tachikoma.lottie.model.a aVar = hVar.lr().get(i);
            PointF pointFKs = aVar.ks();
            PointF pointFKt = aVar.kt();
            PointF pointFKu = aVar.ku();
            if (pointFKs.equals(NC) && pointFKt.equals(pointFKu)) {
                path.lineTo(pointFKu.x, pointFKu.y);
            } else {
                path.cubicTo(pointFKs.x, pointFKs.y, pointFKt.x, pointFKt.y, pointFKu.x, pointFKu.y);
            }
            NC.set(pointFKu.x, pointFKu.y);
        }
        if (hVar.isClosed()) {
            path.close();
        }
    }

    static int p(float f, float f2) {
        return floorMod((int) f, (int) f2);
    }

    private static int floorMod(int i, int i2) {
        return i - (i2 * floorDiv(i, i2));
    }

    private static int floorDiv(int i, int i2) {
        int i3 = i / i2;
        return (((i ^ i2) >= 0) || i % i2 == 0) ? i3 : i3 - 1;
    }

    public static int c(int i, int i2, int i3) {
        return Math.max(0, Math.min(255, i));
    }

    public static float d(float f, float f2, float f3) {
        return Math.max(f2, Math.min(f3, f));
    }

    public static void a(com.tachikoma.lottie.model.d dVar, int i, List<com.tachikoma.lottie.model.d> list, com.tachikoma.lottie.model.d dVar2, k kVar) {
        if (dVar.l(kVar.getName(), i)) {
            list.add(dVar2.ad(kVar.getName()).a(kVar));
        }
    }
}
