package com.qq.e.comm.plugin;

import com.qq.e.comm.plugin.fs.FSCallback;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class ke {
    private static volatile String a;
    private static volatile int b;
    private static volatile int c;
    private static volatile int d;

    public static void h(h4 h4Var) {
        if (h4Var.s0().equals(a)) {
            return;
        }
        a = h4Var.s0();
        i(h4Var);
        d = 0;
    }

    public static void i(h4 h4Var) {
        int iA;
        int iA2;
        if (h4Var.k().k()) {
            if (h4Var.p0() != null && h4Var.p0().F()) {
                iA = f(h4Var);
                iA2 = e(h4Var);
            } else if (h4Var.C1()) {
                iA = b(h4Var, false);
                iA2 = g(h4Var);
            } else {
                iA = d(h4Var);
                iA2 = c(h4Var);
            }
        } else {
            iA = h4Var.w1() ? a(h4Var, false) : -1;
            if (h4Var.C1()) {
                iA2 = b(h4Var) / 1000;
            } else {
                iA2 = a(h4Var);
            }
        }
        c = iA;
        b = iA2;
    }

    public static int g(h4 h4Var) {
        return Math.min(h4Var.W0() - 1, xc.a("rewardVideoCloseShowTime", h4Var.y0(), 0, h4Var.x0()));
    }

    public static int c(h4 h4Var) {
        return xc.a("fsricst", h4Var.y0(), 0, h4Var.x0());
    }

    public static int d(h4 h4Var) {
        int iS;
        yq yqVarP0 = h4Var.p0();
        if (yqVarP0 != null && (iS = yqVarP0.s()) != 1 && !yqVarP0.D()) {
            return a(h4Var, iS);
        }
        return xc.a("fsirt", h4Var.y0(), 15, h4Var.x0());
    }

    public static int b(h4 h4Var) {
        return Math.min((h4Var.W0() - 1) * 1000, xc.a("ifsvmpt", h4Var.y0(), 5000, h4Var.x0()));
    }

    private static int a(h4 h4Var, boolean z, String str, int i, String str2, int i2) {
        int iA;
        int iW0 = h4Var.W0() - 1;
        if (!z && (iA = xc.a(str, h4Var.y0(), i, h4Var.x0())) > 0) {
            iW0 = Math.min(iW0, iA);
        }
        return Math.min(iW0, xc.a(str2, h4Var.y0(), i2, h4Var.x0()));
    }

    public static int e(h4 h4Var) {
        return xc.a("rewardPageCloseTime", h4Var.y0(), 0, h4Var.x0());
    }

    public static int f(h4 h4Var) {
        return xc.a("rewardPageEffectiveTime", h4Var.y0(), 15, h4Var.x0());
    }

    public static int b(h4 h4Var, boolean z) {
        int iS;
        yq yqVarP0 = h4Var.p0();
        if (yqVarP0 != null && (iS = yqVarP0.s()) != 1 && !yqVarP0.D()) {
            return a(h4Var, iS);
        }
        return a(h4Var, z, "restpl", 0, "rewardVideoEffectiveTime", 30);
    }

    public static int b() {
        return (c - d) * 1000;
    }

    public static int a(h4 h4Var) {
        return xc.a("ifscst", h4Var.y0(), 0, h4Var.x0());
    }

    public static int a(h4 h4Var, boolean z) {
        return a(h4Var, z, "instpl", 0, "itsvet", 30);
    }

    private static int a(h4 h4Var, int i) {
        return Math.min(h4Var.C1() ? h4Var.W0() - 1 : Integer.MAX_VALUE, xc.a("skcrd_" + i, h4Var.y0(), 5, h4Var.x0()));
    }

    public static void a(int i) {
        d = i;
        ((FSCallback) x5.b(a, FSCallback.class)).H().a();
    }

    public static int a() {
        return (b - d) * 1000;
    }
}
