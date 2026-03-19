package com.blankj.utilcode.util;

import java.util.Map;
import java.util.Set;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class SPStaticUtils {
    private static SPUtils sDefaultSPUtils;

    public static void setDefaultSPUtils(SPUtils sPUtils) {
        sDefaultSPUtils = sPUtils;
    }

    public static void put(String str, String str2) {
        put(str, str2, getDefaultSPUtils());
    }

    public static void put(String str, String str2, boolean z) {
        put(str, str2, z, getDefaultSPUtils());
    }

    public static String getString(String str) {
        return getString(str, getDefaultSPUtils());
    }

    public static String getString(String str, String str2) {
        return getString(str, str2, getDefaultSPUtils());
    }

    public static void put(String str, int i) {
        put(str, i, getDefaultSPUtils());
    }

    public static void put(String str, int i, boolean z) {
        put(str, i, z, getDefaultSPUtils());
    }

    public static int getInt(String str) {
        return getInt(str, getDefaultSPUtils());
    }

    public static int getInt(String str, int i) {
        return getInt(str, i, getDefaultSPUtils());
    }

    public static void put(String str, long j) {
        put(str, j, getDefaultSPUtils());
    }

    public static void put(String str, long j, boolean z) {
        put(str, j, z, getDefaultSPUtils());
    }

    public static long getLong(String str) {
        return getLong(str, getDefaultSPUtils());
    }

    public static long getLong(String str, long j) {
        return getLong(str, j, getDefaultSPUtils());
    }

    public static void put(String str, float f) {
        put(str, f, getDefaultSPUtils());
    }

    public static void put(String str, float f, boolean z) {
        put(str, f, z, getDefaultSPUtils());
    }

    public static float getFloat(String str) {
        return getFloat(str, getDefaultSPUtils());
    }

    public static float getFloat(String str, float f) {
        return getFloat(str, f, getDefaultSPUtils());
    }

    public static void put(String str, boolean z) {
        put(str, z, getDefaultSPUtils());
    }

    public static void put(String str, boolean z, boolean z2) {
        put(str, z, z2, getDefaultSPUtils());
    }

    public static boolean getBoolean(String str) {
        return getBoolean(str, getDefaultSPUtils());
    }

    public static boolean getBoolean(String str, boolean z) {
        return getBoolean(str, z, getDefaultSPUtils());
    }

    public static void put(String str, Set<String> set) {
        put(str, set, getDefaultSPUtils());
    }

    public static void put(String str, Set<String> set, boolean z) {
        put(str, set, z, getDefaultSPUtils());
    }

    public static Set<String> getStringSet(String str) {
        return getStringSet(str, getDefaultSPUtils());
    }

    public static Set<String> getStringSet(String str, Set<String> set) {
        return getStringSet(str, set, getDefaultSPUtils());
    }

    public static Map<String, ?> getAll() {
        return getAll(getDefaultSPUtils());
    }

    public static boolean contains(String str) {
        return contains(str, getDefaultSPUtils());
    }

    public static void remove(String str) {
        remove(str, getDefaultSPUtils());
    }

    public static void remove(String str, boolean z) {
        remove(str, z, getDefaultSPUtils());
    }

    public static void clear() {
        clear(getDefaultSPUtils());
    }

    public static void clear(boolean z) {
        clear(z, getDefaultSPUtils());
    }

    public static void put(String str, String str2, SPUtils sPUtils) {
        sPUtils.put(str, str2);
    }

    public static void put(String str, String str2, boolean z, SPUtils sPUtils) {
        sPUtils.put(str, str2, z);
    }

    public static String getString(String str, SPUtils sPUtils) {
        return sPUtils.getString(str);
    }

    public static String getString(String str, String str2, SPUtils sPUtils) {
        return sPUtils.getString(str, str2);
    }

    public static void put(String str, int i, SPUtils sPUtils) {
        sPUtils.put(str, i);
    }

    public static void put(String str, int i, boolean z, SPUtils sPUtils) {
        sPUtils.put(str, i, z);
    }

    public static int getInt(String str, SPUtils sPUtils) {
        return sPUtils.getInt(str);
    }

    public static int getInt(String str, int i, SPUtils sPUtils) {
        return sPUtils.getInt(str, i);
    }

    public static void put(String str, long j, SPUtils sPUtils) {
        sPUtils.put(str, j);
    }

    public static void put(String str, long j, boolean z, SPUtils sPUtils) {
        sPUtils.put(str, j, z);
    }

    public static long getLong(String str, SPUtils sPUtils) {
        return sPUtils.getLong(str);
    }

    public static long getLong(String str, long j, SPUtils sPUtils) {
        return sPUtils.getLong(str, j);
    }

    public static void put(String str, float f, SPUtils sPUtils) {
        sPUtils.put(str, f);
    }

    public static void put(String str, float f, boolean z, SPUtils sPUtils) {
        sPUtils.put(str, f, z);
    }

    public static float getFloat(String str, SPUtils sPUtils) {
        return sPUtils.getFloat(str);
    }

    public static float getFloat(String str, float f, SPUtils sPUtils) {
        return sPUtils.getFloat(str, f);
    }

    public static void put(String str, boolean z, SPUtils sPUtils) {
        sPUtils.put(str, z);
    }

    public static void put(String str, boolean z, boolean z2, SPUtils sPUtils) {
        sPUtils.put(str, z, z2);
    }

    public static boolean getBoolean(String str, SPUtils sPUtils) {
        return sPUtils.getBoolean(str);
    }

    public static boolean getBoolean(String str, boolean z, SPUtils sPUtils) {
        return sPUtils.getBoolean(str, z);
    }

    public static void put(String str, Set<String> set, SPUtils sPUtils) {
        sPUtils.put(str, set);
    }

    public static void put(String str, Set<String> set, boolean z, SPUtils sPUtils) {
        sPUtils.put(str, set, z);
    }

    public static Set<String> getStringSet(String str, SPUtils sPUtils) {
        return sPUtils.getStringSet(str);
    }

    public static Set<String> getStringSet(String str, Set<String> set, SPUtils sPUtils) {
        return sPUtils.getStringSet(str, set);
    }

    public static Map<String, ?> getAll(SPUtils sPUtils) {
        return sPUtils.getAll();
    }

    public static boolean contains(String str, SPUtils sPUtils) {
        return sPUtils.contains(str);
    }

    public static void remove(String str, SPUtils sPUtils) {
        sPUtils.remove(str);
    }

    public static void remove(String str, boolean z, SPUtils sPUtils) {
        sPUtils.remove(str, z);
    }

    public static void clear(SPUtils sPUtils) {
        sPUtils.clear();
    }

    public static void clear(boolean z, SPUtils sPUtils) {
        sPUtils.clear(z);
    }

    private static SPUtils getDefaultSPUtils() {
        SPUtils sPUtils = sDefaultSPUtils;
        return sPUtils != null ? sPUtils : SPUtils.getInstance();
    }
}
