package com.bytedance.embedapplog;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class um {
    public static boolean d = false;
    public static boolean hc = false;

    public static void d(String str) {
    }

    public static void d(String str, Throwable th) {
    }

    public static void hc(String str) {
        hc(str, null);
    }

    public static void hc(String str, Throwable th) {
        com.bytedance.sdk.component.utils.mq.hc("TeaLog", str, th);
    }

    public static void b(String str, Throwable th) {
        com.bytedance.sdk.component.utils.mq.b("TeaLog", str, th);
    }

    public static void d(Throwable th) {
        com.bytedance.sdk.component.utils.mq.b("TeaLog", "", th);
    }

    public static void c(String str, Throwable th) {
        com.bytedance.sdk.component.utils.mq.d("TeaLog", str, th);
    }

    public static void hc(Throwable th) {
        if (th != null) {
            com.bytedance.sdk.component.utils.mq.d("TeaLog", th.getMessage());
        }
    }
}
