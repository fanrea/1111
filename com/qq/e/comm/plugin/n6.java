package com.qq.e.comm.plugin;

import com.baidu.mobstat.forbes.Config;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class n6 {
    private static int a;
    private static int b;
    private static Set<String> c;

    public static boolean b(h4 h4Var) {
        return h4Var.k().f() || xc.a("cta_dcwai", h4Var.y0(), 0) == 1;
    }

    public static boolean c(h4 h4Var) {
        int iA = a(h4Var, "skdaista", 0);
        if (iA == 0) {
            iA = a(h4Var, "skjaista", 0);
        }
        return iA == 1;
    }

    public static boolean d(h4 h4Var) {
        return a(h4Var, "skjaista", 0) == 1;
    }

    public static boolean c(h4 h4Var, int i) {
        return h4Var.k1() && b(h4Var, i);
    }

    public static int a(h4 h4Var) {
        if (h4Var == null) {
            return 0;
        }
        return xc.a("dpcllt", h4Var.y0(), 0, h4Var.x0());
    }

    private static boolean b(h4 h4Var, int i) {
        if (!h10.d(i)) {
            return true;
        }
        int iA = r1.d().f().a("icwai", h4Var == null ? null : h4Var.y0(), 0);
        return (h4Var == null || iA < 10000) ? iA == 1 : b.c().a(h4Var.x0(), String.valueOf(iA), 0) == 1;
    }

    public static int b() {
        if (b <= 0) {
            b = r1.d().f().a("rrto", 4);
        }
        return b;
    }

    public static boolean a(h4 h4Var, int i) {
        return xc.a("lp_dcwai", h4Var.y0(), 0) == 1 && b(h4Var, i);
    }

    public static boolean a(h4 h4Var, boolean z, int i) {
        return z ? h4Var.k1() && b(h4Var) && b(h4Var, i) : h4Var.k1() && b(h4Var, i);
    }

    public static int a() {
        if (a <= 0) {
            int iA = r1.d().f().a("crto", 8);
            a = iA;
            if (iA > 10000) {
                a = b.c().a(String.valueOf(a), 8);
            }
        }
        return a;
    }

    public static boolean a(int i) {
        if (c == null) {
            c = new HashSet(Arrays.asList(r1.d().f().b("cta_cidsw", "1008,2008").split(",")));
        }
        return c.contains(String.valueOf(i));
    }

    private static int a(h4 h4Var, String str, int i) {
        int iA = r1.d().f().a(str + Config.replace + h4Var.k().c, h4Var.y0(), i);
        return iA > i ? iA : r1.d().f().a(str, h4Var.y0(), i);
    }
}
