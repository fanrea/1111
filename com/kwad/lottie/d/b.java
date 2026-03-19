package com.kwad.lottie.d;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b {
    private static float F(float f) {
        return f <= 0.0031308f ? f * 12.92f : (float) ((Math.pow(f, 0.4166666567325592d) * 1.0549999475479126d) - 0.054999999701976776d);
    }

    private static float G(float f) {
        return f <= 0.04045f ? f / 12.92f : (float) Math.pow((f + 0.055f) / 1.055f, 2.4000000953674316d);
    }

    public static int a(float f, int i, int i2) {
        float f2 = ((i >> 24) & 255) / 255.0f;
        float fG = G(((i >> 16) & 255) / 255.0f);
        float fG2 = G(((i >> 8) & 255) / 255.0f);
        float fG3 = G((i & 255) / 255.0f);
        float fG4 = G(((i2 >> 16) & 255) / 255.0f);
        float f3 = f2 + (((((i2 >> 24) & 255) / 255.0f) - f2) * f);
        float fG5 = fG2 + ((G(((i2 >> 8) & 255) / 255.0f) - fG2) * f);
        float fG6 = fG3 + (f * (G((i2 & 255) / 255.0f) - fG3));
        return (Math.round(F(fG + ((fG4 - fG) * f)) * 255.0f) << 16) | (Math.round(f3 * 255.0f) << 24) | (Math.round(F(fG5) * 255.0f) << 8) | Math.round(F(fG6) * 255.0f);
    }
}
