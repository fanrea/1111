package com.component.lottie;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class c {
    public static final String b = "LOTTIE";
    private static final int c = 20;
    private static String[] e;
    private static long[] f;
    public static boolean a = false;
    private static boolean d = false;
    private static int g = 0;
    private static int h = 0;

    private c() {
    }

    public static void a(boolean z) {
        if (d == z) {
            return;
        }
        d = z;
        if (d) {
            e = new String[20];
            f = new long[20];
        }
    }

    public static void a(String str) {
        if (!d) {
            return;
        }
        if (g == 20) {
            h++;
            return;
        }
        e[g] = str;
        f[g] = System.nanoTime();
        com.component.lottie.b.f.a(str);
        g++;
    }

    public static float b(String str) {
        if (h > 0) {
            h--;
            return 0.0f;
        }
        if (!d) {
            return 0.0f;
        }
        g--;
        if (g == -1) {
            throw new IllegalStateException("Can't end trace section. There are none.");
        }
        if (!str.equals(e[g])) {
            throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + e[g] + ".");
        }
        com.component.lottie.b.f.b();
        return (System.nanoTime() - f[g]) / 1000000.0f;
    }
}
