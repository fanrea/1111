package com.bytedance.adsdk.lottie.u;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class b {
    private static float d(float f) {
        return f <= 0.0031308f ? f * 12.92f : (float) ((Math.pow(f, 0.4166666567325592d) * 1.0549999475479126d) - 0.054999999701976776d);
    }

    private static float hc(float f) {
        return f <= 0.04045f ? f / 12.92f : (float) Math.pow((f + 0.055f) / 1.055f, 2.4000000953674316d);
    }

    public static int d(float f, int i, int i2) {
        if (i == i2) {
            return i;
        }
        float f2 = ((i >> 24) & 255) / 255.0f;
        float fHc = hc(((i >> 16) & 255) / 255.0f);
        float fHc2 = hc(((i >> 8) & 255) / 255.0f);
        float fHc3 = hc((i & 255) / 255.0f);
        float fHc4 = hc(((i2 >> 16) & 255) / 255.0f);
        float f3 = f2 + (((((i2 >> 24) & 255) / 255.0f) - f2) * f);
        float fHc5 = fHc2 + ((hc(((i2 >> 8) & 255) / 255.0f) - fHc2) * f);
        float fHc6 = fHc3 + (f * (hc((i2 & 255) / 255.0f) - fHc3));
        return (Math.round(d(fHc + ((fHc4 - fHc) * f)) * 255.0f) << 16) | (Math.round(f3 * 255.0f) << 24) | (Math.round(d(fHc5) * 255.0f) << 8) | Math.round(d(fHc6) * 255.0f);
    }
}
