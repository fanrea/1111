package com.bytedance.bdtracker;

import android.content.SharedPreferences;

/* compiled from: outline */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class a {
    public static StringBuilder a(String str) {
        return new StringBuilder().append(str);
    }

    public static void a(SharedPreferences sharedPreferences, String str, String str2) {
        sharedPreferences.edit().putString(str, str2).apply();
    }
}
