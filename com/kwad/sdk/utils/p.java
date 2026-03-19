package com.kwad.sdk.utils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class p {
    public static long clC;
    public static long sLaunchTime;

    public static String a(StackTraceElement stackTraceElement) {
        StringBuilder sb = new StringBuilder();
        sb.append(stackTraceElement.getClassName()).append(".").append(stackTraceElement.getMethodName());
        return sb.toString();
    }

    public static void setLaunchTime(long j) {
        sLaunchTime = j;
    }

    public static void setInitStartTime(long j) {
        clC = j;
    }
}
