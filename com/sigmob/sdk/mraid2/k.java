package com.sigmob.sdk.mraid2;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Map;
import java.util.Set;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class k {
    private static final String a = "mraid_storage";

    public static String a(Context context, String key) {
        SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = context.getSharedPreferences(a, 0)) == null) {
            return null;
        }
        return sharedPreferences.getString(key, null);
    }

    public static Map<String, ?> a(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(a, 0);
        if (sharedPreferences == null) {
            return null;
        }
        return sharedPreferences.getAll();
    }

    public static void a(Context context, String key, Object obj) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(a, 0);
        if (sharedPreferences == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        if (obj instanceof Boolean) {
            editorEdit.putBoolean(key, ((Boolean) obj).booleanValue());
        } else if (obj instanceof Float) {
            editorEdit.putFloat(key, ((Float) obj).floatValue());
        } else if (obj instanceof Integer) {
            editorEdit.putInt(key, ((Integer) obj).intValue());
        } else if (obj instanceof Long) {
            editorEdit.putLong(key, ((Long) obj).longValue());
        } else if (obj instanceof String) {
            editorEdit.putString(key, (String) obj);
        } else if (obj instanceof Set) {
            editorEdit.remove(key);
            editorEdit.putStringSet(key, (Set) obj);
        }
        editorEdit.apply();
    }

    public static Object b(Context context, String key, Object defaultObj) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(a, 0);
        if (sharedPreferences == null) {
            return null;
        }
        if (defaultObj instanceof Boolean) {
            return Boolean.valueOf(sharedPreferences.getBoolean(key, ((Boolean) defaultObj).booleanValue()));
        }
        if (defaultObj instanceof Float) {
            return Float.valueOf(sharedPreferences.getFloat(key, ((Float) defaultObj).floatValue()));
        }
        if (defaultObj instanceof Integer) {
            return Integer.valueOf(sharedPreferences.getInt(key, ((Integer) defaultObj).intValue()));
        }
        if (defaultObj instanceof Long) {
            return Long.valueOf(sharedPreferences.getLong(key, ((Long) defaultObj).longValue()));
        }
        if (defaultObj instanceof String) {
            return sharedPreferences.getString(key, (String) defaultObj);
        }
        if (defaultObj instanceof Set) {
            return sharedPreferences.getStringSet(key, (Set) defaultObj);
        }
        return null;
    }

    public static void b(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(a, 0);
        if (sharedPreferences == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.clear();
        editorEdit.apply();
    }

    public static void b(Context context, String key) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(a, 0);
        if (sharedPreferences == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.remove(key);
        editorEdit.apply();
    }

    public static boolean c(Context context, String key) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(a, 0);
        return sharedPreferences != null && sharedPreferences.contains(key);
    }
}
