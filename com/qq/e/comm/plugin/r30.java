package com.qq.e.comm.plugin;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class r30 {
    private static String a = "User-Agent";
    private static String b = "GDTMobSDK" + su.c();
    private static String c = "-[" + System.getProperty("http.agent") + "]";

    public static String a() {
        return b + c;
    }

    public static String b() {
        return a;
    }

    public static String a(String str) {
        return b + str + c;
    }
}
