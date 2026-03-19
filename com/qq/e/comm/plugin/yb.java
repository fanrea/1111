package com.qq.e.comm.plugin;

import android.content.SharedPreferences;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class yb {
    public static String a(String str, String str2) {
        return c().getString(str, str2);
    }

    public static void b(String str, String str2) {
        b().putString(str, str2).apply();
    }

    private static SharedPreferences c() {
        return r1.d().a().getSharedPreferences("com.qq.e.eaconfig", 0);
    }

    public static long a(String str, long j) {
        return c().getLong(str, j);
    }

    public static void b(String str, long j) {
        b().putLong(str, j).apply();
    }

    public static boolean a(String str, boolean z) {
        return c().getBoolean(str, z);
    }

    public static void b(String str, boolean z) {
        b().putBoolean(str, z).apply();
    }

    public static void a() {
        b().clear().apply();
    }

    private static SharedPreferences.Editor b() {
        return c().edit();
    }

    public static void a(String str) {
        if (c().contains(str)) {
            b().remove(str).apply();
        }
    }
}
