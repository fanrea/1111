package com.baidu.mobstat.forbes;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public abstract class ai {
    public abstract SharedPreferences a(Context context);

    public boolean a(Context context, String str, boolean z) {
        SharedPreferences sharedPreferencesA = a(context);
        if (sharedPreferencesA != null) {
            return sharedPreferencesA.getBoolean(str, z);
        }
        return false;
    }

    public void b(Context context, String str, boolean z) {
        a(context).edit().putBoolean(str, z).commit();
    }

    public int a(Context context, String str, int i) {
        return a(context).getInt(str, i);
    }

    public void b(Context context, String str, int i) {
        a(context).edit().putInt(str, i).commit();
    }

    public long a(Context context, String str, long j) {
        return a(context).getLong(str, j);
    }

    public void b(Context context, String str, long j) {
        a(context).edit().putLong(str, j).commit();
    }

    public String a(Context context, String str, String str2) {
        return a(context).getString(str, str2);
    }

    public void b(Context context, String str, String str2) {
        a(context).edit().putString(str, str2).commit();
    }
}
