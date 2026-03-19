package com.bytedance.d.hc;

import android.content.Context;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class gb {
    private static String b = "default";
    private static boolean c = false;
    private static Context d;
    private static volatile ConcurrentHashMap<Integer, String> gb;
    private static long hc;
    private static volatile String mk;
    private static volatile int tc;
    private static com.bytedance.d.hc.u.d u;
    private static com.bytedance.d.hc.u.hc an = new com.bytedance.d.hc.u.hc();
    private static hc h = new hc();
    private static com.bytedance.d.hc.u.gb tt = null;

    public static com.bytedance.d.hc.u.d d() {
        return u;
    }

    public static hc hc() {
        return h;
    }

    public static com.bytedance.d.hc.u.gb b() {
        if (tt == null) {
            synchronized (gb.class) {
                tt = new com.bytedance.d.hc.u.gb(d);
            }
        }
        return tt;
    }

    static void d(Context context, u uVar) {
        hc = System.currentTimeMillis();
        d = context;
        u = new com.bytedance.d.hc.u.d(d, uVar);
    }

    public static Context c() {
        return d;
    }

    public static com.bytedance.d.hc.u.hc u() {
        return an;
    }

    public static long an() {
        return hc;
    }

    public static String h() {
        return b;
    }

    public static boolean gb() {
        return c;
    }

    public static ConcurrentHashMap<Integer, String> tt() {
        return gb;
    }

    public static int tc() {
        return tc;
    }

    public static String mk() {
        return mk;
    }
}
