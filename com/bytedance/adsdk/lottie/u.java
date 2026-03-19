package com.bytedance.adsdk.lottie;

import android.content.Context;
import android.os.Trace;
import java.io.File;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class u {
    private static long[] an = null;
    private static boolean b = true;
    private static boolean c = true;
    public static boolean d = false;
    private static int gb = 0;
    private static int h = 0;
    private static boolean hc = false;
    private static volatile com.bytedance.adsdk.lottie.b.gb mk;
    private static volatile com.bytedance.adsdk.lottie.b.h mq;
    private static com.bytedance.adsdk.lottie.b.u tc;
    private static com.bytedance.adsdk.lottie.b.an tt;
    private static String[] u;

    public static void d(String str) {
        if (hc) {
            int i = h;
            if (i == 20) {
                gb++;
                return;
            }
            u[i] = str;
            an[i] = System.nanoTime();
            Trace.beginSection(str);
            h++;
        }
    }

    public static float hc(String str) {
        int i = gb;
        if (i > 0) {
            gb = i - 1;
            return 0.0f;
        }
        if (!hc) {
            return 0.0f;
        }
        int i2 = h - 1;
        h = i2;
        if (i2 == -1) {
            throw new IllegalStateException("Can't end trace section. There are none.");
        }
        if (!str.equals(u[i2])) {
            throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + u[h] + ".");
        }
        Trace.endSection();
        return (System.nanoTime() - an[h]) / 1000000.0f;
    }

    public static com.bytedance.adsdk.lottie.b.gb d(Context context) {
        com.bytedance.adsdk.lottie.b.gb gbVar = mk;
        if (gbVar == null) {
            synchronized (com.bytedance.adsdk.lottie.b.gb.class) {
                gbVar = mk;
                if (gbVar == null) {
                    com.bytedance.adsdk.lottie.b.h hVarHc = hc(context);
                    com.bytedance.adsdk.lottie.b.an hcVar = tt;
                    if (hcVar == null) {
                        hcVar = new com.bytedance.adsdk.lottie.b.hc();
                    }
                    gbVar = new com.bytedance.adsdk.lottie.b.gb(hVarHc, hcVar);
                    mk = gbVar;
                }
            }
        }
        return gbVar;
    }

    public static com.bytedance.adsdk.lottie.b.h hc(Context context) {
        if (!b) {
            return null;
        }
        final Context applicationContext = context.getApplicationContext();
        com.bytedance.adsdk.lottie.b.h hVar = mq;
        if (hVar == null) {
            synchronized (com.bytedance.adsdk.lottie.b.h.class) {
                hVar = mq;
                if (hVar == null) {
                    com.bytedance.adsdk.lottie.b.u uVar = tc;
                    if (uVar == null) {
                        uVar = new com.bytedance.adsdk.lottie.b.u() { // from class: com.bytedance.adsdk.lottie.u.1
                            @Override // com.bytedance.adsdk.lottie.b.u
                            public File d() {
                                return new File(com.bytedance.sdk.openadsdk.api.plugin.hc.hc(applicationContext), "lottie_network_cache");
                            }
                        };
                    }
                    hVar = new com.bytedance.adsdk.lottie.b.h(uVar);
                    mq = hVar;
                }
            }
        }
        return hVar;
    }

    public static boolean d() {
        return c;
    }
}
