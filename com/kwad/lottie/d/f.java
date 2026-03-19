package com.kwad.lottie.d;

import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import com.kwad.lottie.a.a.r;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class f {
    private static final PathMeasure bmw = new PathMeasure();
    private static final Path bmy = new Path();
    private static final Path bpK = new Path();
    private static final float[] points = new float[4];
    private static final float bpL = (float) Math.sqrt(2.0d);
    private static float bpM = -1.0f;

    public static boolean a(int i, int i2, int i3, int i4, int i5, int i6) {
        if (i < 4) {
            return false;
        }
        if (i > 4) {
            return true;
        }
        if (i2 < 4) {
            return false;
        }
        return i2 > 4 || i3 >= 0;
    }

    public static int b(float f, float f2, float f3, float f4) {
        int i = f != 0.0f ? (int) (f * 527.0f) : 17;
        if (f2 != 0.0f) {
            i = (int) (i * 31 * f2);
        }
        if (f3 != 0.0f) {
            i = (int) (i * 31 * f3);
        }
        return f4 != 0.0f ? (int) (i * 31 * f4) : i;
    }

    public static Path a(PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
        Path path = new Path();
        path.moveTo(pointF.x, pointF.y);
        if (pointF3 != null && pointF4 != null && (pointF3.length() != 0.0f || pointF4.length() != 0.0f)) {
            path.cubicTo(pointF3.x + pointF.x, pointF.y + pointF3.y, pointF2.x + pointF4.x, pointF2.y + pointF4.y, pointF2.x, pointF2.y);
        } else {
            path.lineTo(pointF2.x, pointF2.y);
        }
        return path;
    }

    public static float b(Matrix matrix) {
        float[] fArr = points;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        float f = bpL;
        fArr[2] = f;
        fArr[3] = f;
        matrix.mapPoints(fArr);
        return ((float) Math.hypot(fArr[2] - fArr[0], fArr[3] - fArr[1])) / 2.0f;
    }

    public static void a(Path path, r rVar) {
        if (rVar == null) {
            return;
        }
        a(path, rVar.QJ().getValue().floatValue() / 100.0f, rVar.QK().getValue().floatValue() / 100.0f, rVar.QL().getValue().floatValue() / 360.0f);
    }

    public static void a(Path path, float f, float f2, float f3) {
        com.kwad.lottie.c.beginSection("applyTrimPathIfNeeded");
        PathMeasure pathMeasure = bmw;
        pathMeasure.setPath(path, false);
        float length = pathMeasure.getLength();
        if (f == 1.0f && f2 == 0.0f) {
            com.kwad.lottie.c.dg("applyTrimPathIfNeeded");
            return;
        }
        if (length < 1.0f || Math.abs((f2 - f) - 1.0f) < 0.01d) {
            com.kwad.lottie.c.dg("applyTrimPathIfNeeded");
            return;
        }
        float f4 = f * length;
        float f5 = f2 * length;
        float f6 = f3 * length;
        float fMin = Math.min(f4, f5) + f6;
        float fMax = Math.max(f4, f5) + f6;
        if (fMin >= length && fMax >= length) {
            fMin = e.m(fMin, length);
            fMax = e.m(fMax, length);
        }
        if (fMin < 0.0f) {
            fMin = e.m(fMin, length);
        }
        if (fMax < 0.0f) {
            fMax = e.m(fMax, length);
        }
        if (fMin == fMax) {
            path.reset();
            com.kwad.lottie.c.dg("applyTrimPathIfNeeded");
            return;
        }
        if (fMin >= fMax) {
            fMin -= length;
        }
        Path path2 = bmy;
        path2.reset();
        pathMeasure.getSegment(fMin, fMax, path2, true);
        if (fMax > length) {
            Path path3 = bpK;
            path3.reset();
            pathMeasure.getSegment(0.0f, fMax % length, path3, true);
            path2.addPath(path3);
        } else if (fMin < 0.0f) {
            Path path4 = bpK;
            path4.reset();
            pathMeasure.getSegment(fMin + length, length, path4, true);
            path2.addPath(path4);
        }
        path.set(path2);
        com.kwad.lottie.c.dg("applyTrimPathIfNeeded");
    }

    public static float SI() {
        if (bpM == -1.0f) {
            bpM = Resources.getSystem().getDisplayMetrics().density;
        }
        return bpM;
    }
}
