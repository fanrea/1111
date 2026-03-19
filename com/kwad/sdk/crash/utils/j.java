package com.kwad.sdk.crash.utils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class j {
    public static String bo(long j) {
        long j2 = j / 60000;
        long j3 = (j - (60000 * j2)) / 1000;
        return (j2 < 10 ? "0" + j2 : String.valueOf(j2)) + ":" + (j3 < 10 ? "0" + j3 : String.valueOf(j3));
    }
}
