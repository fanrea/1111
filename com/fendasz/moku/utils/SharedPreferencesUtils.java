package com.fendasz.moku.utils;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Map;
import java.util.Set;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class SharedPreferencesUtils {
    public static final int STATUS_ALWAYS_FALSE = 4;
    public static final int STATUS_ALWAYS_TRUE = 3;
    public static final int STATUS_FALSE = 2;
    public static final int STATUS_TRUE = 1;
    public static final int STATUS_UNKNOWN = 0;
    private static SharedPreferences sharedPreferences;
    private static SharedPreferencesUtils sharedPreferencesUtils;

    private SharedPreferencesUtils(Context context) {
        sharedPreferences = context.getSharedPreferences(context.getPackageName(), 0);
    }

    public static SharedPreferencesUtils getInstance(Context context) {
        if (sharedPreferencesUtils == null) {
            sharedPreferencesUtils = new SharedPreferencesUtils(context);
        }
        return sharedPreferencesUtils;
    }

    public SharedPreferences getSharedPreferences() {
        return sharedPreferences;
    }

    public boolean contains(String str) {
        return sharedPreferences.contains(str);
    }

    public boolean getBoolean(String str, boolean z) {
        return sharedPreferences.getBoolean(str, z);
    }

    public float getFloat(String str, float f) {
        return sharedPreferences.getFloat(str, f);
    }

    public int getInt(String str, int i) {
        return sharedPreferences.getInt(str, i);
    }

    public long getLong(String str, long j) {
        return sharedPreferences.getLong(str, j);
    }

    public String getString(String str, String str2) {
        return sharedPreferences.getString(str, str2);
    }

    public Set<String> getStringSet(String str, Set<String> set) {
        return sharedPreferences.getStringSet(str, set);
    }

    public Map<String, ?> getAll() {
        return sharedPreferences.getAll();
    }

    public void putBoolean(String str, boolean z) {
        sharedPreferences.edit().putBoolean(str, z).apply();
    }

    public void putFloat(String str, float f) {
        sharedPreferences.edit().putFloat(str, f).apply();
    }

    public void putInt(String str, int i) {
        sharedPreferences.edit().putInt(str, i).apply();
    }

    public void putLong(String str, long j) {
        sharedPreferences.edit().putLong(str, j).apply();
    }

    public void putString(String str, String str2) {
        sharedPreferences.edit().putString(str, str2).apply();
    }

    public void putStringSet(String str, Set<String> set) {
        sharedPreferences.edit().putStringSet(str, set).apply();
    }

    public void remove(String str) {
        sharedPreferences.edit().remove(str).apply();
    }

    public void clear() {
        sharedPreferences.edit().clear().apply();
    }
}
