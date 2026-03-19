package com.kwad.lottie;

import android.util.Log;
import androidx.core.os.TraceCompat;
import java.util.HashSet;
import java.util.Set;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c {
    public static boolean bjq = false;
    private static String[] bjt;
    private static long[] bju;
    private static final Set<String> bjr = new HashSet();
    private static boolean bjs = false;
    private static int bjv = 0;
    private static int bjw = 0;

    public static void de(String str) {
        if (bjq) {
            Log.d(com.component.lottie.c.b, str);
        }
    }

    public static void df(String str) {
        Set<String> set = bjr;
        if (set.contains(str)) {
            return;
        }
        Log.w(com.component.lottie.c.b, str);
        set.add(str);
    }

    public static void beginSection(String str) {
        if (bjs) {
            int i = bjv;
            if (i == 20) {
                bjw++;
                return;
            }
            bjt[i] = str;
            bju[i] = System.nanoTime();
            TraceCompat.beginSection(str);
            bjv++;
        }
    }

    public static float dg(String str) {
        int i = bjw;
        if (i > 0) {
            bjw = i - 1;
            return 0.0f;
        }
        if (!bjs) {
            return 0.0f;
        }
        int i2 = bjv - 1;
        bjv = i2;
        if (i2 == -1) {
            throw new IllegalStateException("Can't end trace section. There are none.");
        }
        if (!str.equals(bjt[i2])) {
            throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + bjt[bjv] + ".");
        }
        TraceCompat.endSection();
        return (System.nanoTime() - bju[bjv]) / 1000000.0f;
    }
}
