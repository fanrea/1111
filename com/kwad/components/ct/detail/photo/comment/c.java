package com.kwad.components.ct.detail.photo.comment;

import java.util.HashSet;
import java.util.Set;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c {
    private static Set<String> arO = new HashSet();

    public static void h(long j, long j2) {
        arO.add(k(j, j2));
    }

    public static void i(long j, long j2) {
        arO.remove(k(j, j2));
    }

    public static boolean j(long j, long j2) {
        return arO.contains(k(j, j2));
    }

    private static String k(long j, long j2) {
        StringBuilder sb = new StringBuilder();
        sb.append(j).append(j2);
        return sb.toString();
    }
}
