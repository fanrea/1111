package com.netease.htprotect.necrash.nis.p003O8oO888;

import android.util.Log;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class o8o0 {

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static String f133O8oO888 = "BASE_SDK_LOG";

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    private static boolean f134Ooo = false;

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static String m575O8oO888() {
        Thread threadCurrentThread = Thread.currentThread();
        for (StackTraceElement stackTraceElement : threadCurrentThread.getStackTrace()) {
            if (!stackTraceElement.getClassName().equals(Thread.class.getName()) && !stackTraceElement.getClassName().equals(o8o0.class.getName())) {
                return "[Thread:" + threadCurrentThread.getName() + ", Class:" + stackTraceElement.getClassName() + ", Function:" + stackTraceElement.getMethodName() + "]";
            }
        }
        return null;
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public static void m576O8oO888(String str) {
        m577O8oO888(f133O8oO888, str);
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public static void m577O8oO888(String str, String str2) {
        if (f134Ooo) {
            String str3 = f133O8oO888;
            if (!str3.equals(str)) {
                str3 = f133O8oO888 + "." + str;
            }
            Log.i(str3, Oo0(str2));
        }
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static void m578O8oO888(boolean z) {
        f134Ooo = z;
    }

    private static String Oo0(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str).append("---->").append(m575O8oO888());
        return sb.toString();
    }

    /* renamed from: 〇O8, reason: contains not printable characters */
    public static void m579O8(String str) {
        m582Ooo(f133O8oO888, str);
    }

    /* renamed from: 〇O8, reason: contains not printable characters */
    private static void m580O8(String str, String str2) {
        if (f134Ooo) {
            String str3 = f133O8oO888;
            if (!str3.equals(str)) {
                str3 = f133O8oO888 + "." + str;
            }
            Log.w(str3, str2);
        }
    }

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    public static void m581Ooo(String str) {
        String str2 = f133O8oO888;
        if (f134Ooo) {
            boolean zEquals = str2.equals(str2);
            String str3 = str2;
            if (!zEquals) {
                str3 = f133O8oO888 + "." + str2;
            }
            Log.d(str3, str);
        }
    }

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    public static void m582Ooo(String str, String str2) {
        if (f134Ooo) {
            String str3 = f133O8oO888;
            if (!str3.equals(str)) {
                str3 = f133O8oO888 + "." + str;
            }
            Log.e(str3, str2);
        }
    }

    /* renamed from: 〇o0〇o0, reason: contains not printable characters */
    private static void m583o0o0(String str) {
        f133O8oO888 = str;
    }

    /* renamed from: 〇o0〇o0, reason: contains not printable characters */
    private static void m584o0o0(String str, String str2) {
        if (f134Ooo) {
            String str3 = f133O8oO888;
            if (!str3.equals(str)) {
                str3 = f133O8oO888 + "." + str;
            }
            Log.d(str3, str2);
        }
    }

    /* renamed from: 〇oO, reason: contains not printable characters */
    private static void m585oO(String str) {
        String str2 = f133O8oO888;
        if (f134Ooo) {
            boolean zEquals = str2.equals(str2);
            String str3 = str2;
            if (!zEquals) {
                str3 = f133O8oO888 + "." + str2;
            }
            Log.w(str3, str);
        }
    }
}
