package com.component.lottie.g;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class b {
    private static float a(float f) {
        return f <= 0.0031308f ? f * 12.92f : (float) ((Math.pow(f, 0.4166666567325592d) * 1.0549999475479126d) - 0.054999999701976776d);
    }

    private static float b(float f) {
        return f <= 0.04045f ? f / 12.92f : (float) Math.pow((f + 0.055f) / 1.055f, 2.4000000953674316d);
    }

    public static int a(float f, int i, int i2) {
        if (i == i2) {
            return i;
        }
        float f2 = ((i >> 24) & 255) / 255.0f;
        float fB = b(((i >> 16) & 255) / 255.0f);
        float fB2 = b(((i >> 8) & 255) / 255.0f);
        float fB3 = b((i & 255) / 255.0f);
        float fB4 = b(((i2 >> 16) & 255) / 255.0f);
        float f3 = f2 + (((((i2 >> 24) & 255) / 255.0f) - f2) * f);
        float fB5 = fB2 + ((b(((i2 >> 8) & 255) / 255.0f) - fB2) * f);
        float fB6 = fB3 + (f * (b((i2 & 255) / 255.0f) - fB3));
        return (Math.round(a(fB + ((fB4 - fB) * f)) * 255.0f) << 16) | (Math.round(f3 * 255.0f) << 24) | (Math.round(a(fB5) * 255.0f) << 8) | Math.round(a(fB6) * 255.0f);
    }
}
