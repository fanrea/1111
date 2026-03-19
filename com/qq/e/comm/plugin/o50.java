package com.qq.e.comm.plugin;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class o50 {
    private static volatile Integer a;

    public static int a() {
        if (a == null) {
            a = Integer.valueOf(r1.d().f().a("drwuc", 1));
        }
        return a.intValue();
    }

    public static boolean b() {
        int iA = a();
        return iA == 2 || iA == 3;
    }

    public static boolean c() {
        int iA = a();
        return iA == 2 || iA == 1;
    }
}
