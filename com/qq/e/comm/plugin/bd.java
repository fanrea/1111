package com.qq.e.comm.plugin;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class bd {
    private static final boolean a;

    static {
        a = r1.d().f().a("raepe", 0) == 0;
    }

    public static void a() {
        if (a) {
            return;
        }
        b10.a(new qc(1101015), true);
    }

    public static void a(f5 f5Var) {
        if (a) {
            return;
        }
        qc qcVar = new qc(1101014);
        qcVar.a(f5Var);
        b10.a(qcVar, true);
    }

    public static void a(int i) {
        if (a) {
            return;
        }
        qc qcVar = new qc(1101013);
        qcVar.d(i < 3 ? 2 : 3);
        b10.a(qcVar, true);
    }
}
