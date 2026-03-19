package com.tachikoma.lottie.d;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import com.tachikoma.lottie.a.a.s;
import java.io.Closeable;
import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class f {
    private static final PathMeasure JV = new PathMeasure();
    private static final Path JY = new Path();
    private static final Path ND = new Path();
    private static final float[] points = new float[4];
    private static final float NE = (float) Math.sqrt(2.0d);
    private static float NF = -1.0f;

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

    public static int e(float f, float f2, float f3, float f4) {
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

    public static void a(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }

    public static float b(Matrix matrix) {
        float[] fArr = points;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        float f = NE;
        fArr[2] = f;
        fArr[3] = f;
        matrix.mapPoints(fArr);
        float[] fArr2 = points;
        return ((float) Math.hypot(fArr2[2] - fArr2[0], fArr2[3] - fArr2[1])) / 2.0f;
    }

    public static boolean c(Matrix matrix) {
        float[] fArr = points;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        fArr[2] = 37394.73f;
        fArr[3] = 39575.234f;
        matrix.mapPoints(fArr);
        float[] fArr2 = points;
        return fArr2[0] == fArr2[2] || fArr2[1] == fArr2[3];
    }

    public static void a(Path path, s sVar) {
        if (sVar == null || sVar.isHidden()) {
            return;
        }
        a(path, ((com.tachikoma.lottie.a.b.c) sVar.jY()).kh() / 100.0f, ((com.tachikoma.lottie.a.b.c) sVar.jZ()).kh() / 100.0f, ((com.tachikoma.lottie.a.b.c) sVar.ka()).kh() / 360.0f);
    }

    public static void a(Path path, float f, float f2, float f3) {
        com.tachikoma.lottie.c.beginSection("applyTrimPathIfNeeded");
        JV.setPath(path, false);
        float length = JV.getLength();
        if (f == 1.0f && f2 == 0.0f) {
            com.tachikoma.lottie.c.S("applyTrimPathIfNeeded");
            return;
        }
        if (length < 1.0f || Math.abs((f2 - f) - 1.0f) < 0.01d) {
            com.tachikoma.lottie.c.S("applyTrimPathIfNeeded");
            return;
        }
        float f4 = f * length;
        float f5 = f2 * length;
        float f6 = f3 * length;
        float fMin = Math.min(f4, f5) + f6;
        float fMax = Math.max(f4, f5) + f6;
        if (fMin >= length && fMax >= length) {
            fMin = e.p(fMin, length);
            fMax = e.p(fMax, length);
        }
        if (fMin < 0.0f) {
            fMin = e.p(fMin, length);
        }
        if (fMax < 0.0f) {
            fMax = e.p(fMax, length);
        }
        if (fMin == fMax) {
            path.reset();
            com.tachikoma.lottie.c.S("applyTrimPathIfNeeded");
            return;
        }
        if (fMin >= fMax) {
            fMin -= length;
        }
        JY.reset();
        JV.getSegment(fMin, fMax, JY, true);
        if (fMax > length) {
            ND.reset();
            JV.getSegment(0.0f, fMax % length, ND, true);
            JY.addPath(ND);
        } else if (fMin < 0.0f) {
            ND.reset();
            JV.getSegment(fMin + length, length, ND, true);
            JY.addPath(ND);
        }
        path.set(JY);
        com.tachikoma.lottie.c.S("applyTrimPathIfNeeded");
    }

    public static float mf() {
        if (NF == -1.0f) {
            NF = Resources.getSystem().getDisplayMetrics().density;
        }
        return NF;
    }

    public static Bitmap a(Bitmap bitmap, int i, int i2) {
        if (bitmap.getWidth() == i && bitmap.getHeight() == i2) {
            return bitmap;
        }
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, i, i2, true);
        bitmap.recycle();
        return bitmapCreateScaledBitmap;
    }
}
