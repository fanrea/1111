package android.support.v4.graphics;

import android.graphics.Color;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class a {
    private static final ThreadLocal<double[]> af = new ThreadLocal<>();

    public static int a(int i, int i2) {
        int iAlpha = Color.alpha(i2);
        int iAlpha2 = Color.alpha(i);
        int iB = b(iAlpha2, iAlpha);
        return Color.argb(iB, a(Color.red(i), iAlpha2, Color.red(i2), iAlpha, iB), a(Color.green(i), iAlpha2, Color.green(i2), iAlpha, iB), a(Color.blue(i), iAlpha2, Color.blue(i2), iAlpha, iB));
    }

    private static int b(int i, int i2) {
        return 255 - (((255 - i2) * (255 - i)) / 255);
    }

    private static int a(int i, int i2, int i3, int i4, int i5) {
        if (i5 == 0) {
            return 0;
        }
        return (((i * 255) * i2) + ((i3 * i4) * (255 - i2))) / (i5 * 255);
    }

    public static int c(int i, int i2) {
        if (i2 < 0 || i2 > 255) {
            throw new IllegalArgumentException("alpha must be between 0 and 255.");
        }
        return (i & 16777215) | (i2 << 24);
    }
}
