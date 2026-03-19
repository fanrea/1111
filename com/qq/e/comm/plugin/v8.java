package com.qq.e.comm.plugin;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class v8 {

    /* compiled from: A */
    public static class a {
        public long a = -1;
        public long b = -1;
        public int c;
    }

    public static void b(int i, a aVar, f5 f5Var) {
        aVar.b = System.currentTimeMillis();
        a(i, aVar, f5Var);
    }

    public static a b() {
        a aVarA = a();
        aVarA.a = System.currentTimeMillis();
        return aVarA;
    }

    public static void a(int i, long j, int i2, f5 f5Var) {
        if (j < 0) {
            return;
        }
        wt wtVar = new wt(i);
        wtVar.b(j);
        wtVar.b(i2);
        wtVar.a(f5Var);
        b10.a(wtVar);
    }

    public static void a(int i, a aVar, f5 f5Var) {
        long j = aVar.a;
        if (j >= 0) {
            long j2 = aVar.b;
            if (j2 < 0) {
                return;
            }
            a(i, j2 - j, aVar.c, f5Var);
        }
    }

    public static a a() {
        return new a();
    }
}
