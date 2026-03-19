package android.support.v4.e.b;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.view.animation.Interpolator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
final class a implements Interpolator {
    private final float[] dp;
    private final float[] dq;

    private a(Path path) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int i = ((int) (length / 0.002f)) + 1;
        this.dp = new float[i];
        this.dq = new float[i];
        float[] fArr = new float[2];
        for (int i2 = 0; i2 < i; i2++) {
            pathMeasure.getPosTan((i2 * length) / (i - 1), fArr, null);
            this.dp[i2] = fArr[0];
            this.dq[i2] = fArr[1];
        }
    }

    a(float f, float f2, float f3, float f4) {
        this(a(f, f2, f3, f4));
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float f) {
        if (f <= 0.0f) {
            return 0.0f;
        }
        if (f >= 1.0f) {
            return 1.0f;
        }
        int i = 0;
        int length = this.dp.length - 1;
        while (length - i > 1) {
            int i2 = (i + length) / 2;
            if (f < this.dp[i2]) {
                length = i2;
            } else {
                i = i2;
            }
        }
        float[] fArr = this.dp;
        float f2 = fArr[length] - fArr[i];
        if (f2 == 0.0f) {
            return this.dq[i];
        }
        float f3 = (f - fArr[i]) / f2;
        float[] fArr2 = this.dq;
        float f4 = fArr2[i];
        return f4 + (f3 * (fArr2[length] - f4));
    }

    private static Path a(float f, float f2, float f3, float f4) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.cubicTo(f, f2, f3, f4, 1.0f, 1.0f);
        return path;
    }
}
