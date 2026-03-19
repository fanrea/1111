package com.sigmob.sdk.base.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.czhj.sdk.logger.SigmobLogger;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class p {
    private static final String a = "p";
    private static final String b = "com.wind.Settings";
    private static final int c = 4;

    private p() {
    }

    public static float a(Context ctx, String name, String key, float defValue) {
        SharedPreferences sharedPreferencesA = a(ctx, name);
        if (sharedPreferencesA != null) {
            return sharedPreferencesA.getFloat(key, defValue);
        }
        SigmobLogger.e(a, "getFloat: sp is unavailable.", new Object[0]);
        return defValue;
    }

    public static int a(Context ctx, String name, String key, int defValue) {
        SharedPreferences sharedPreferencesA = a(ctx, name);
        if (sharedPreferencesA != null) {
            return sharedPreferencesA.getInt(key, defValue);
        }
        SigmobLogger.e(a, "getInt: sp is unavailable.", new Object[0]);
        return defValue;
    }

    public static long a(Context ctx, String name, String key, long defValue) {
        SharedPreferences sharedPreferencesA = a(ctx, name);
        if (sharedPreferencesA != null) {
            return sharedPreferencesA.getLong(key, defValue);
        }
        SigmobLogger.e(a, "getLong: sp is unavailable.", new Object[0]);
        return defValue;
    }

    public static SharedPreferences a(Context ctx, String name) {
        if (ctx == null) {
            SigmobLogger.e(a, "getPrefs: ctx is unavailable.", new Object[0]);
            return null;
        }
        if (m.a((CharSequence) name)) {
            name = b;
        }
        return ctx.getSharedPreferences(name, 4);
    }

    public static String a(Context ctx, String name, String key, String defValue) {
        SharedPreferences sharedPreferencesA = a(ctx, name);
        if (sharedPreferencesA != null) {
            return sharedPreferencesA.getString(key, defValue);
        }
        SigmobLogger.e(a, "getString: sp is unavailable.", new Object[0]);
        return defValue;
    }

    public static void a(Context ctx, String name, Map<String, Object> map) {
        SharedPreferences sharedPreferencesA = a(ctx, name);
        if (sharedPreferencesA == null || map == null || map.isEmpty()) {
            SigmobLogger.e(a, "apply: sp or map is unavailable.", new Object[0]);
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesA.edit();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof String) {
                editorEdit.putString(key, (String) value);
            } else if (value instanceof Boolean) {
                editorEdit.putBoolean(key, ((Boolean) value).booleanValue());
            } else if (value instanceof Integer) {
                editorEdit.putInt(key, ((Integer) value).intValue());
            } else if (value instanceof Long) {
                editorEdit.putLong(key, ((Long) value).longValue());
            } else if (value instanceof Float) {
                editorEdit.putFloat(key, ((Float) value).floatValue());
            }
        }
        editorEdit.apply();
    }

    public static void a(Context ctx, String name, Object[] pairs) {
        SharedPreferences sharedPreferencesA = a(ctx, name);
        if (sharedPreferencesA == null || pairs == null) {
            SigmobLogger.e(a, "apply: sp or pairs is unavailable.", new Object[0]);
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesA.edit();
        for (int i = 0; i < pairs.length; i += 2) {
            String str = (String) pairs[i];
            Object obj = pairs[i + 1];
            if (obj instanceof String) {
                editorEdit.putString(str, (String) obj);
            } else if (obj instanceof Boolean) {
                editorEdit.putBoolean(str, ((Boolean) obj).booleanValue());
            } else if (obj instanceof Integer) {
                editorEdit.putInt(str, ((Integer) obj).intValue());
            } else if (obj instanceof Long) {
                editorEdit.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof Float) {
                editorEdit.putFloat(str, ((Float) obj).floatValue());
            }
        }
        editorEdit.apply();
    }

    public static boolean a(Context ctx, String name, String key, boolean defValue) {
        SharedPreferences sharedPreferencesA = a(ctx, name);
        if (sharedPreferencesA != null) {
            return sharedPreferencesA.getBoolean(key, defValue);
        }
        SigmobLogger.e(a, "getBoolean: sp is unavailable.", new Object[0]);
        return defValue;
    }

    public static void b(Context ctx, String name, String key, float value) {
        SharedPreferences sharedPreferencesA = a(ctx, name);
        if (sharedPreferencesA == null) {
            SigmobLogger.e(a, "saveFloat: sp is unavailable.", new Object[0]);
        } else {
            sharedPreferencesA.edit().putFloat(key, value).apply();
        }
    }

    public static void b(Context ctx, String name, String key, int value) {
        SharedPreferences sharedPreferencesA = a(ctx, name);
        if (sharedPreferencesA == null) {
            SigmobLogger.e(a, "saveInt: sp is unavailable.", new Object[0]);
        } else {
            sharedPreferencesA.edit().putInt(key, value).apply();
        }
    }

    public static void b(Context ctx, String name, String key, long value) {
        SharedPreferences sharedPreferencesA = a(ctx, name);
        if (sharedPreferencesA == null) {
            SigmobLogger.e(a, "saveLong: sp is unavailable.", new Object[0]);
        } else {
            sharedPreferencesA.edit().putLong(key, value).apply();
        }
    }

    public static void b(Context ctx, String name, String key, String value) {
        SharedPreferences sharedPreferencesA = a(ctx, name);
        if (sharedPreferencesA == null) {
            SigmobLogger.e(a, "saveString: sp is unavailable.", new Object[0]);
        } else {
            sharedPreferencesA.edit().putString(key, value).apply();
        }
    }

    public static void b(Context ctx, String name, String key, boolean value) {
        SharedPreferences sharedPreferencesA = a(ctx, name);
        if (sharedPreferencesA == null) {
            SigmobLogger.e(a, "saveBoolean: sp is unavailable.", new Object[0]);
        } else {
            sharedPreferencesA.edit().putBoolean(key, value).apply();
        }
    }
}
