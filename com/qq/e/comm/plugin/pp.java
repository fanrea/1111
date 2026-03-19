package com.qq.e.comm.plugin;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class pp {
    private static int a(int i) {
        return i + 2303000;
    }

    public static void a(int i, String str) {
        b10.b(1232001, new f5().c(str), Integer.valueOf(i));
    }

    public static void a(int i, long j, f5 f5Var) {
        wt wtVar = new wt(a(i));
        wtVar.a(f5Var);
        wtVar.b(System.currentTimeMillis() - j);
        b10.a(wtVar);
    }

    public static void a(long j, f5 f5Var) {
        wt wtVar = new wt(a(999));
        wtVar.a(f5Var);
        wtVar.b(System.currentTimeMillis() - j);
        b10.a(wtVar);
    }
}
