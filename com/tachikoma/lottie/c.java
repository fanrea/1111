package com.tachikoma.lottie;

import android.util.Log;
import java.util.HashSet;
import java.util.Set;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class c {
    public static boolean Gi = false;
    private static String[] Gl;
    private static long[] Gm;
    private static final Set<String> Gj = new HashSet();
    private static boolean Gk = false;
    private static int Gn = 0;
    private static int Go = 0;

    public static void Q(String str) {
        if (Gi) {
            Log.d(com.component.lottie.c.b, str);
        }
    }

    public static void R(String str) {
        if (Gj.contains(str)) {
            return;
        }
        Log.w(com.component.lottie.c.b, str);
        Gj.add(str);
    }

    public static void beginSection(String str) {
        if (Gk) {
            int i = Gn;
            if (i == 20) {
                Go++;
                return;
            }
            Gl[i] = str;
            Gm[i] = System.nanoTime();
            android.support.v4.os.a.beginSection(str);
            Gn++;
        }
    }

    public static float S(String str) {
        int i = Go;
        if (i > 0) {
            Go = i - 1;
            return 0.0f;
        }
        if (!Gk) {
            return 0.0f;
        }
        int i2 = Gn - 1;
        Gn = i2;
        if (i2 == -1) {
            throw new IllegalStateException("Can't end trace section. There are none.");
        }
        if (!str.equals(Gl[Gn])) {
            throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + Gl[Gn] + ".");
        }
        android.support.v4.os.a.endSection();
        return (System.nanoTime() - Gm[Gn]) / 1000000.0f;
    }
}
