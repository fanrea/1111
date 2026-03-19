package com.qq.e.comm.plugin;

import java.util.HashMap;
import java.util.Map;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class e3 {
    private static Map<Integer, String> a = null;
    private static int b = Integer.MIN_VALUE;
    private static String c;

    public static int a() {
        int iA = r1.d().f().a("riadc", 0);
        return iA <= 10 ? iA : b.c().a(String.valueOf(iA), 0);
    }

    public static final int b() {
        int iA = r1.d().f().a("jusmc", 0);
        return iA <= 10 ? iA : b.c().a(String.valueOf(iA), 0);
    }

    private static int c() {
        int iA = r1.d().f().a("rtiac", 0);
        return iA <= 3 ? iA : b.c().a(String.valueOf(iA), 0);
    }

    private static int d() {
        int iA = r1.d().f().a("rdec", 2);
        return iA <= 3 ? iA : b.c().a(String.valueOf(iA), 2);
    }

    public static String e() {
        return c;
    }

    public static final boolean f() {
        int iC = c();
        return iC == 1 || iC == 3;
    }

    public static final boolean g() {
        int iC = c();
        return iC == 2 || iC == 3;
    }

    public static boolean h() {
        return d() != 1;
    }

    public static boolean i() {
        return d() == 2;
    }

    public static int a(h4 h4Var) {
        return Math.max(1, r1.d().f().a("adact", h4Var.y0(), 3));
    }

    public static int b(h4 h4Var) {
        int i = b;
        if (i >= 1) {
            return i;
        }
        int iA = r1.d().f().a("adcdt", h4Var.y0(), 4);
        if (iA > 10000) {
            iA = b.c().a(h4Var.x0(), String.valueOf(iA), 4);
            if (a == null) {
                HashMap map = new HashMap();
                a = map;
                map.put(1, "AA");
                a.put(2, "AB");
                a.put(3, "AC");
                a.put(4, "AD");
            }
            c = a.get(Integer.valueOf(iA));
        }
        b = iA;
        return iA;
    }
}
