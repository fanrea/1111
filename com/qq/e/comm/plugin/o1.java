package com.qq.e.comm.plugin;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class o1 {
    private static volatile int a = -1;

    public static int a() {
        if (a != -1) {
            return a;
        }
        a = xc.a("adroptc", "APP", "", 0);
        return a;
    }

    public static boolean b() {
        return a() == 1;
    }
}
