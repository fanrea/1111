package com.qq.e.comm.plugin;

import android.content.SharedPreferences;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class yy {
    private static SharedPreferences a;

    public static int a(String str, int i) {
        return b().getInt(str, i);
    }

    public static void b(String str, int i) {
        a().putInt(str, i).apply();
    }

    public static String a(String str, String str2) {
        return b().getString(str, str2);
    }

    public static void b(String str, String str2) {
        a().putString(str, str2).apply();
    }

    public static long a(String str, long j) {
        return b().getLong(str, j);
    }

    public static void b(String str, long j) {
        a().putLong(str, j).apply();
    }

    public static boolean a(String str, boolean z) {
        return b().getBoolean(str, z);
    }

    public static void b(String str, boolean z) {
        a().putBoolean(str, z).apply();
    }

    public static void a(String str) {
        a().remove(str).apply();
    }

    private static SharedPreferences b() {
        if (a == null) {
            a = r1.d().a().getSharedPreferences("com.qq.e.sdkconfig", 0);
        }
        return a;
    }

    public static SharedPreferences.Editor a() {
        return b().edit();
    }
}
