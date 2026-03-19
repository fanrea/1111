package com.qq.e.comm.plugin;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class rd {
    public static long a(long j, int i) {
        return i <= 0 ? j : Math.min(j, i * 1000);
    }

    public static long a(long j, sd sdVar) {
        return a(j, sdVar.c());
    }

    public static boolean a(long j, long j2, sd sdVar) {
        return sdVar.c() > 0 && j >= j2;
    }
}
