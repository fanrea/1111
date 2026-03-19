package com.kwad.components.ct.horizontal.b;

import java.util.HashSet;
import java.util.Set;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b {
    private static Set<Long> aOB = new HashSet();

    public static void W(long j) {
        aOB.add(Long.valueOf(j));
    }

    public static void X(long j) {
        aOB.remove(Long.valueOf(j));
    }

    public static boolean Y(long j) {
        return aOB.contains(Long.valueOf(j));
    }
}
