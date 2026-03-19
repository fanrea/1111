package com.qq.e.comm.plugin;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class x6 {
    public static void b(f5 f5Var, long j) {
        a(2300002, f5Var, j);
    }

    public static void c(f5 f5Var, long j) {
        a(2300003, f5Var, j);
    }

    public static void a(f5 f5Var, long j) {
        a(2300004, f5Var, j);
    }

    public static void a(f5 f5Var, long j, boolean z, int i) {
        a(2300001, f5Var, j, z, i);
    }

    public static void d(f5 f5Var, long j) {
        a(2300006, f5Var, j);
    }

    public static void a(f5 f5Var, long j, long j2) {
        h4 h4VarA;
        wt wtVar = new wt(2300005);
        if (f5Var != null && (h4VarA = f5Var.a()) != null) {
            ja jaVar = new ja();
            jaVar.a("adClickNumber", Integer.valueOf(h4VarA.T0()));
            wtVar.a(jaVar);
        }
        wtVar.a(f5Var);
        wtVar.b((int) j);
        wtVar.b(j2);
        b10.a(wtVar);
    }

    private static void a(int i, f5 f5Var, long j) {
        wt wtVar = new wt(i);
        wtVar.a(f5Var);
        wtVar.b(j);
        b10.a(wtVar);
    }

    private static void a(int i, f5 f5Var, long j, boolean z, int i2) {
        wt wtVar = new wt(i);
        wtVar.a(f5Var);
        wtVar.b(j);
        wtVar.b((i2 * 10) + (z ? 1 : 0));
        b10.a(wtVar);
    }
}
