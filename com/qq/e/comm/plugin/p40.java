package com.qq.e.comm.plugin;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class p40 {
    public static int a(q40 q40Var) {
        return q40Var.b();
    }

    private static q40 a(int i) {
        return (i == 2 && a()) ? q40.ONLINE_PLAYER : q40.REFACTOR_PLAYER;
    }

    public static q40 a(e2 e2Var) {
        int iA = -1;
        if (e2Var != null) {
            iA = r1.d().f().a(vx.a("plty", e2Var), -1);
        }
        if (iA < 0) {
            iA = r1.d().f().a("plty", 1);
        }
        if (iA > 10000) {
            if (e2Var != null) {
                iA = b.c().a(e2Var.d(), String.valueOf(iA), 1);
            } else {
                iA = b.c().a(String.valueOf(iA), 1);
            }
        }
        q40 q40VarA = a(iA);
        qm$h$$ExternalSyntheticBackport0.m(q40VarA);
        return q40VarA;
    }

    private static boolean a() {
        return vs.l().o();
    }

    public static boolean a(e2 e2Var, String str) {
        return r1.d().f().a(vx.a("sav1", e2Var), str, 0) == 1 && a(e2Var) == q40.ONLINE_PLAYER;
    }
}
