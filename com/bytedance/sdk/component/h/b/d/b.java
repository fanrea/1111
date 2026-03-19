package com.bytedance.sdk.component.h.b.d;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.sdk.openadsdk.ats.AutoService;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class b {
    private static SoftReference<ConcurrentHashMap<String, Map<String, Object>>> d;

    private static SharedPreferences b(String str) {
        return ((com.bytedance.sdk.component.c.c) AutoService.d(com.bytedance.sdk.component.c.c.class)).d(c(str));
    }

    private static String c(String str) {
        return TextUtils.isEmpty(str) ? "sphelper_ttopenadsdk" : str;
    }

    private static Object b(String str, String str2) {
        ConcurrentHashMap<String, Map<String, Object>> concurrentHashMap;
        Map<String, Object> map;
        SoftReference<ConcurrentHashMap<String, Map<String, Object>>> softReference = d;
        if (softReference == null || (concurrentHashMap = softReference.get()) == null || (map = concurrentHashMap.get(c(str))) == null) {
            return null;
        }
        return map.get(str2);
    }

    private static void hc(String str, String str2, Object obj) {
        SoftReference<ConcurrentHashMap<String, Map<String, Object>>> softReference = d;
        if (softReference == null || softReference.get() == null) {
            d = new SoftReference<>(new ConcurrentHashMap());
        }
        String strC = c(str);
        ConcurrentHashMap<String, Map<String, Object>> concurrentHashMap = d.get();
        if (concurrentHashMap.get(strC) == null) {
            concurrentHashMap.put(strC, new HashMap());
        }
        concurrentHashMap.get(strC).put(str2, obj);
    }

    private static void u(String str) {
        Map<String, Object> map;
        SoftReference<ConcurrentHashMap<String, Map<String, Object>>> softReference = d;
        if (softReference == null || softReference.get() == null || (map = d.get().get(c(str))) == null) {
            return;
        }
        map.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    static synchronized <T> void d(String str, String str2, T t) {
        SharedPreferences sharedPreferencesB = b(str);
        if (sharedPreferencesB == null) {
            return;
        }
        if (t.equals(b(str, str2))) {
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesB.edit();
        if (t instanceof Boolean) {
            editorEdit.putBoolean(str2, ((Boolean) t).booleanValue());
        }
        if (t instanceof String) {
            editorEdit.putString(str2, (String) t);
        }
        if (t instanceof Integer) {
            editorEdit.putInt(str2, ((Integer) t).intValue());
        }
        if (t instanceof Long) {
            editorEdit.putLong(str2, ((Long) t).longValue());
        }
        if (t instanceof Float) {
            editorEdit.putFloat(str2, ((Float) t).floatValue());
        }
        editorEdit.apply();
        hc(str, str2, t);
    }

    static String d(String str, String str2, String str3) {
        Object objB = b(str, str2);
        if (objB != null) {
            return String.valueOf(objB);
        }
        Object objHc = hc(str, str2, str3);
        hc(str, str2, objHc);
        return String.valueOf(objHc);
    }

    private static Object hc(String str, String str2, String str3) {
        String strC = c(str);
        if (!d(strC, str2)) {
            return null;
        }
        if (str3.equalsIgnoreCase(TypedValues.Custom.S_STRING)) {
            return b(strC, str2, null);
        }
        if (str3.equalsIgnoreCase(TypedValues.Custom.S_BOOLEAN)) {
            return Boolean.valueOf(d(strC, str2, false));
        }
        if (str3.equalsIgnoreCase("int")) {
            return Integer.valueOf(d(strC, str2, 0));
        }
        if (str3.equalsIgnoreCase("long")) {
            return Long.valueOf(d(strC, str2, 0L));
        }
        if (str3.equalsIgnoreCase(TypedValues.Custom.S_FLOAT)) {
            return Float.valueOf(d(strC, str2, 0.0f));
        }
        if (str3.equalsIgnoreCase("string_set")) {
            return b(strC, str2, null);
        }
        return null;
    }

    private static String b(String str, String str2, String str3) {
        SharedPreferences sharedPreferencesB = b(str);
        return sharedPreferencesB == null ? str3 : sharedPreferencesB.getString(str2, str3);
    }

    private static int d(String str, String str2, int i) {
        SharedPreferences sharedPreferencesB = b(str);
        return sharedPreferencesB == null ? i : sharedPreferencesB.getInt(str2, i);
    }

    private static float d(String str, String str2, float f) {
        SharedPreferences sharedPreferencesB = b(str);
        return sharedPreferencesB == null ? f : sharedPreferencesB.getFloat(str2, f);
    }

    private static boolean d(String str, String str2, boolean z) {
        SharedPreferences sharedPreferencesB = b(str);
        return sharedPreferencesB == null ? z : sharedPreferencesB.getBoolean(str2, z);
    }

    private static long d(String str, String str2, long j) {
        SharedPreferences sharedPreferencesB = b(str);
        return sharedPreferencesB == null ? j : sharedPreferencesB.getLong(str2, j);
    }

    static boolean d(String str, String str2) {
        SharedPreferences sharedPreferencesB = b(str);
        return sharedPreferencesB != null && sharedPreferencesB.contains(str2);
    }

    static void hc(String str, String str2) {
        Map<String, Object> map;
        try {
            SharedPreferences sharedPreferencesB = b(str);
            if (sharedPreferencesB == null) {
                return;
            }
            SharedPreferences.Editor editorEdit = sharedPreferencesB.edit();
            editorEdit.remove(str2);
            editorEdit.apply();
            SoftReference<ConcurrentHashMap<String, Map<String, Object>>> softReference = d;
            if (softReference == null || softReference.get() == null) {
                return;
            }
            String strC = c(str);
            if (!TextUtils.isEmpty(strC) && (map = d.get().get(strC)) != null && map.size() != 0) {
                map.remove(str2);
                SoftReference<ConcurrentHashMap<String, Map<String, Object>>> softReference2 = d;
                if (softReference2 == null || softReference2.get() == null) {
                    return;
                }
                d.get().put(strC, map);
            }
        } catch (Throwable unused) {
        }
    }

    static void d(String str) {
        SharedPreferences.Editor editorEdit = b(str).edit();
        editorEdit.clear();
        editorEdit.apply();
        u(str);
    }

    static Map<String, ?> hc(String str) {
        return b(str).getAll();
    }
}
