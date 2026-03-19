package com.ss.android.socialbase.downloader.mk;

import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class e {
    public static long d(List<tt> list) {
        int size = list.size();
        long jU = 0;
        for (int i = 0; i < size; i++) {
            tt ttVar = list.get(i);
            if (ttVar.b() > jU) {
                break;
            }
            if (ttVar.u() > jU) {
                jU = ttVar.u();
            }
        }
        return jU;
    }

    public static long hc(List<tt> list) {
        long jB;
        long jC;
        long j = 0;
        loop0: while (true) {
            jB = -1;
            jC = -1;
            for (tt ttVar : list) {
                if (jB == -1) {
                    if (ttVar.d() > 0) {
                        jB = ttVar.b();
                        jC = ttVar.c();
                    }
                } else if (ttVar.b() > jC) {
                    j += jC - jB;
                    if (ttVar.d() > 0) {
                        jB = ttVar.b();
                        jC = ttVar.c();
                    }
                } else if (ttVar.c() > jC) {
                    jC = ttVar.c();
                }
            }
        }
        return (jB < 0 || jC <= jB) ? j : j + (jC - jB);
    }
}
