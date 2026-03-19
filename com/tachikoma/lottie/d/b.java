package com.tachikoma.lottie.d;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class b {
    private static float j(float f) {
        return f <= 0.0031308f ? f * 12.92f : (float) ((Math.pow(f, 0.4166666567325592d) * 1.0549999475479126d) - 0.054999999701976776d);
    }

    private static float k(float f) {
        return f <= 0.04045f ? f / 12.92f : (float) Math.pow((f + 0.055f) / 1.055f, 2.4000000953674316d);
    }

    public static int a(float f, int i, int i2) {
        float f2 = ((i >> 24) & 255) / 255.0f;
        float fK = k(((i >> 16) & 255) / 255.0f);
        float fK2 = k(((i >> 8) & 255) / 255.0f);
        float fK3 = k((i & 255) / 255.0f);
        float fK4 = k(((i2 >> 16) & 255) / 255.0f);
        float f3 = f2 + (((((i2 >> 24) & 255) / 255.0f) - f2) * f);
        float fK5 = fK2 + ((k(((i2 >> 8) & 255) / 255.0f) - fK2) * f);
        float fK6 = fK3 + (f * (k((i2 & 255) / 255.0f) - fK3));
        return (Math.round(j(fK + ((fK4 - fK) * f)) * 255.0f) << 16) | (Math.round(f3 * 255.0f) << 24) | (Math.round(j(fK5) * 255.0f) << 8) | Math.round(j(fK6) * 255.0f);
    }
}
