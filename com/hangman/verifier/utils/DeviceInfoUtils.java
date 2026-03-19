package com.hangman.verifier.utils;

import java.io.File;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class DeviceInfoUtils {
    public static int a = -1;
    public static int b = -1;
    public static final String c = System.getProperty("java.vm.version", "");

    public static synchronized String a(String str) {
        Class<?> cls;
        cls = Class.forName("android.os.SystemProperties");
        return (String) cls.getDeclaredMethod("get", String.class).invoke(cls, str);
    }

    public static boolean a() {
        try {
            String str = c;
            if (str == null || str.length() < 1) {
                return true;
            }
            return Integer.parseInt(String.valueOf(str.charAt(0))) >= 2;
        } catch (Exception unused) {
            return true;
        }
    }

    public static synchronized boolean b() {
        int i = b;
        if (i != -1) {
            return i > 0;
        }
        try {
            if (a("ro.kernel.qemu").equals("1")) {
                b = 1;
            } else {
                b = 0;
            }
        } catch (Throwable unused) {
            b = 0;
        }
        return b > 0;
    }

    public static synchronized boolean c() {
        int i = a;
        if (i != -1) {
            return i > 0;
        }
        if (new File("/system/lib/arm/nb/libc.so").exists()) {
            a = 1;
        } else {
            a = 0;
        }
        return a > 0;
    }
}
