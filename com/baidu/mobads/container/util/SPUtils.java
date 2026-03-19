package com.baidu.mobads.container.util;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Set;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class SPUtils {
    private static final String a = "bd_sp_file";
    private SharedPreferences b;
    private SharedPreferences.Editor c;

    public SPUtils(Context context) {
        this.b = context.getApplicationContext().getSharedPreferences(a, 0);
        this.c = this.b.edit();
    }

    public SPUtils(Context context, String str) {
        if (context == null) {
            com.baidu.mobads.container.l.g.f("context can not be null");
        } else {
            this.b = context.getApplicationContext().getSharedPreferences(str, 0);
            this.c = this.b.edit();
        }
    }

    public void a(String str, int i) {
        this.c.putInt(str, i);
        b();
    }

    public void a(String str, long j) {
        this.c.putLong(str, Long.valueOf(j).longValue());
        b();
    }

    public void a(String str, float f) {
        this.c.putFloat(str, Float.valueOf(f).floatValue());
        b();
    }

    public void putString(String str, String str2) {
        this.c.putString(str, str2);
        b();
    }

    public void a(String str, boolean z) {
        this.c.putBoolean(str, z);
        b();
    }

    public void a(String str, Set<String> set) {
        this.c.putStringSet(str, set);
        b();
    }

    public Set<String> b(String str, Set<String> set) {
        return this.b.getStringSet(str, set);
    }

    public int b(String str, int i) {
        return this.b.getInt(str, i);
    }

    public long b(String str, long j) {
        return this.b.getLong(str, j);
    }

    public float b(String str, float f) {
        return this.b.getFloat(str, f);
    }

    public String getString(String str, String str2) {
        return this.b.getString(str, str2);
    }

    public boolean b(String str, boolean z) {
        return this.b.getBoolean(str, z);
    }

    public boolean a(String str) {
        return this.b.contains(str);
    }

    public void b(String str) {
        if (this.c != null) {
            this.c.remove(str);
        }
    }

    public void a() {
    }

    private void b() {
        this.c.apply();
    }
}
