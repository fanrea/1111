package com.component.lottie.b;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.view.animation.Interpolator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class c implements Interpolator {
    private static final float a = 0.002f;
    private final float[] b;
    private final float[] c;

    c(Path path) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int i = ((int) (length / 0.002f)) + 1;
        this.b = new float[i];
        this.c = new float[i];
        float[] fArr = new float[2];
        for (int i2 = 0; i2 < i; i2++) {
            pathMeasure.getPosTan((i2 * length) / (i - 1), fArr, null);
            this.b[i2] = fArr[0];
            this.c[i2] = fArr[1];
        }
    }

    c(float f, float f2) {
        this(a(f, f2));
    }

    c(float f, float f2, float f3, float f4) {
        this(a(f, f2, f3, f4));
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        if (f <= 0.0f) {
            return 0.0f;
        }
        if (f >= 1.0f) {
            return 1.0f;
        }
        int length = this.b.length - 1;
        int i = 0;
        while (length - i > 1) {
            int i2 = (i + length) / 2;
            if (f < this.b[i2]) {
                length = i2;
            } else {
                i = i2;
            }
        }
        float f2 = this.b[length] - this.b[i];
        if (f2 == 0.0f) {
            return this.c[i];
        }
        float f3 = (f - this.b[i]) / f2;
        float f4 = this.c[i];
        return f4 + (f3 * (this.c[length] - f4));
    }

    private static Path a(float f, float f2) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.quadTo(f, f2, 1.0f, 1.0f);
        return path;
    }

    private static Path a(float f, float f2, float f3, float f4) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.cubicTo(f, f2, f3, f4, 1.0f, 1.0f);
        return path;
    }
}
