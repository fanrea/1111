package com.bytedance.msdk.d.u;

import com.bytedance.msdk.gb.mq;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class b {
    private static int b = 4;
    static boolean d = true;
    private static boolean hc = false;

    public static void d(int i) {
        b = i;
    }

    public static void d() {
        hc = true;
        d(3);
    }

    public static boolean hc() {
        return mq.d || hc;
    }

    public static void d(String str) {
        if (hc()) {
            d("Logger", str);
        }
    }

    public static void d(String str, String str2) {
        hc();
    }

    public static void d(String str, String str2, Throwable th) {
        hc();
    }

    public static void hc(String str) {
        if (hc()) {
            hc("Logger", str);
        }
    }

    public static void hc(String str, String str2) {
        if (hc() && str2 != null && b <= 4) {
            com.bytedance.sdk.component.utils.mq.d(str, str2);
        }
    }

    public static void b(String str, String str2) {
        if (hc() && str2 != null && b <= 5) {
            com.bytedance.sdk.component.utils.mq.hc(str, str2);
        }
    }

    public static void b(String str) {
        if (hc()) {
            c("Logger", str);
        }
    }

    public static void c(String str, String str2) {
        if (hc() && str2 != null && b <= 6) {
            com.bytedance.sdk.component.utils.mq.c(str, str2);
        }
    }

    public static void hc(String str, String str2, Throwable th) {
        if (hc()) {
            if (!(str2 == null && th == null) && b <= 6) {
                com.bytedance.sdk.component.utils.mq.b(str, str2, th);
            }
        }
    }
}
