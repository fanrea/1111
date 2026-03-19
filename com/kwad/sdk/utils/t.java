package com.kwad.sdk.utils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class t {
    public static int a(long j, long j2, boolean z, int i) {
        com.kwad.sdk.core.d.c.d("DownloadProgressTransformUtil", "soFarBytes:" + j + " totalBytes:" + j2 + " isShowOptimizedProgress: " + z + " optimizeMethod: " + i);
        double dW = j2 > 0 ? (j * 100.0d) / j2 : 0.0d;
        if (!z) {
            return (int) dW;
        }
        if (i == 1) {
            dW = v(dW);
        } else if (i == 2) {
            dW = w(dW);
        }
        return (int) dW;
    }

    private static double v(double d) {
        if (d <= 6.0d) {
            return d * 5.0d;
        }
        if (d <= 15.0d) {
            return ((d - 6.0d) * 2.0d) + 30.0d;
        }
        if (d <= 30.0d) {
            return d + 33.0d;
        }
        if (d < 100.0d) {
            return Math.min((((d - 30.0d) * 0.37d) / 0.7d) + 63.0d, 99.0d);
        }
        return 100.0d;
    }

    private static double w(double d) {
        return Math.sqrt(d) * 10.0d;
    }
}
