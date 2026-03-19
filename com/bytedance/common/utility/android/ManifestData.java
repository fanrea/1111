package com.bytedance.common.utility.android;

import android.content.Context;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class ManifestData {
    private static Object readKey(Context context, String str) {
        if (context == null) {
            return null;
        }
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.get(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String getString(Context context, String str) {
        Object key = readKey(context, str);
        if (key == null) {
            return null;
        }
        return (String) key;
    }

    public static int getInt(Context context, String str) {
        Object key = readKey(context, str);
        if (key == null) {
            return -1;
        }
        return ((Integer) key).intValue();
    }

    public static Boolean getBoolean(Context context, String str) {
        Object key = readKey(context, str);
        if (key == null) {
            return null;
        }
        return (Boolean) key;
    }

    public static Object get(Context context, String str) {
        return readKey(context, str);
    }
}
