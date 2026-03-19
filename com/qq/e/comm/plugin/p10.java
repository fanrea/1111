package com.qq.e.comm.plugin;

import java.util.HashSet;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class p10 {
    private static volatile HashSet<Integer> a;
    private static Integer b;

    private static void a(int i) {
    }

    private static boolean c() {
        return true;
    }

    private static boolean d(String str) {
        if (!lv.a()) {
            return false;
        }
        if (b == null) {
            b = Integer.valueOf(r1.d().f().a("smdpa", str, 1));
        }
        return b.intValue() == 1;
    }

    private static boolean e(String str) {
        return r1.d().f().a("skswxcsad", str, 0) == 1;
    }

    private static boolean d() {
        return p40.a(e2.NATIVEUNIFIEDAD) == q40.ONLINE_PLAYER && r1.d().f().a("s2sav1", 0) == 1;
    }

    private static int a(String str) {
        int i = i50.a(true) ? 54956 : 22188;
        if (et.a(r1.d().a())) {
            i |= 65536;
        }
        int i2 = 2752512 | i;
        if (d(str)) {
            i2 = 6946816 | i;
        }
        if (c()) {
            i2 |= 8388608;
        }
        int i3 = 16777216 | i2;
        if (c(str)) {
            i3 = 50331648 | i2;
        }
        if (!b(str) || !yh.e() || !kh.b().d()) {
            i3 |= 67108864;
        }
        return e(str) ? i3 | 805306368 : 268435456 | i3;
    }

    private static boolean c(String str) {
        return xc.a("spprd", 0, tc.a(str)) == 1;
    }

    public static int a() {
        int iA = a((String) null);
        if (r1.d().c().C()) {
            iA |= 1;
        }
        int i = iA | 64;
        if (b()) {
            i = iA | 2112;
        }
        if (d()) {
            i |= 134217728;
        }
        a(i);
        return i;
    }

    private static boolean b(w1 w1Var) {
        return p40.a(w1Var.b(), w1Var.w());
    }

    private static boolean b(int i) {
        if (a == null) {
            synchronized (p10.class) {
                if (a == null) {
                    a = new HashSet<>();
                    try {
                        for (String str : r1.d().f().b("swcat", "9,23,12,22,26,11,24").split(",")) {
                            a.add(Integer.valueOf(Integer.parseInt(str)));
                        }
                    } catch (Exception e) {
                        e.getMessage();
                    }
                }
            }
        }
        if (a.isEmpty()) {
            return i == e2.NATIVEEXPRESSAD.e() || i == e2.NATIVEUNIFIEDAD.e() || i == e2.UNIFIED_INTERSTITIAL_FULLSCREEN.e() || i == e2.REWARDVIDEOAD.e();
        }
        return a.contains(Integer.valueOf(i));
    }

    private static boolean b() {
        return !"0".equals(yh.a());
    }

    private static boolean b(String str) {
        return r1.d().f().a("auss", str, 0) == 0;
    }

    public static int a(w1 w1Var) {
        int iA = a(w1Var.w());
        boolean z = r1.d().f().a("rewardEndCardLandingPageLandscape", 0) == 1;
        if (r1.d().f().a("rewardEndCardLandingPage", 1) == 1 && (z || r1.d().c().C())) {
            iA |= 1;
        }
        if (b(w1Var.x())) {
            iA |= 64;
        }
        if (zz.a(w1Var) && b()) {
            iA |= 2048;
        }
        if (b(w1Var)) {
            iA |= 134217728;
        }
        a(iA);
        return iA;
    }
}
