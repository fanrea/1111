package com.kwad.sdk.utils;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import com.kwad.sdk.service.ServiceProvider;
import java.util.Map;
import java.util.Set;

@Deprecated
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class bp {
    static final String TAG = "bp";

    public static SharedPreferences iH(String str) {
        try {
            return ServiceProvider.anu().getSharedPreferences(str, 0);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            return null;
        }
    }

    static void b(String str, String str2, int i) {
        SharedPreferences sharedPreferencesIH = iH(str);
        if (sharedPreferencesIH == null) {
            return;
        }
        sharedPreferencesIH.edit().putInt(str2, i).apply();
    }

    static int c(String str, String str2, int i) {
        SharedPreferences sharedPreferencesIH = iH(str);
        return sharedPreferencesIH == null ? i : sharedPreferencesIH.getInt(str2, i);
    }

    static void a(String str, String str2, long j) {
        SharedPreferences sharedPreferencesIH = iH(str);
        if (sharedPreferencesIH == null) {
            return;
        }
        sharedPreferencesIH.edit().putLong(str2, j).apply();
    }

    static long b(String str, String str2, long j) {
        SharedPreferences sharedPreferencesIH = iH(str);
        return sharedPreferencesIH == null ? j : sharedPreferencesIH.getLong(str2, j);
    }

    static void n(String str, String str2, boolean z) {
        SharedPreferences sharedPreferencesIH = iH(str);
        if (sharedPreferencesIH == null) {
            return;
        }
        sharedPreferencesIH.edit().putBoolean(str2, z).apply();
    }

    static boolean o(String str, String str2, boolean z) {
        SharedPreferences sharedPreferencesIH = iH(str);
        return sharedPreferencesIH == null ? z : sharedPreferencesIH.getBoolean(str2, z);
    }

    static void aE(String str, String str2) {
        SharedPreferences sharedPreferencesIH = iH(str);
        if (sharedPreferencesIH == null) {
            return;
        }
        sharedPreferencesIH.edit().remove(str2).apply();
    }

    static void g(String str, String str2, String str3) {
        a(str, str2, str3, false);
    }

    static void a(String str, String str2, String str3, boolean z) {
        try {
            SharedPreferences sharedPreferencesIH = iH(str);
            if (sharedPreferencesIH == null) {
                return;
            }
            if (z && !com.kwad.sdk.core.a.c.isEncodeKsSdk(str3)) {
                sharedPreferencesIH.edit().putString(str2, com.kwad.sdk.core.a.c.encodeKsSdk(str3)).apply();
            } else {
                sharedPreferencesIH.edit().putString(str2, str3).apply();
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    static String h(String str, String str2, String str3) {
        String string;
        try {
            SharedPreferences sharedPreferencesIH = iH(str);
            if (sharedPreferencesIH != null && (string = sharedPreferencesIH.getString(str2, str3)) != null && !TextUtils.isEmpty(string)) {
                return (TextUtils.equals(string, str3) || !com.kwad.sdk.core.a.c.isEncodeKsSdk(string)) ? string : com.kwad.sdk.core.a.c.decodeKsSdk(string);
            }
            return str3;
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
            return "";
        }
    }

    static void i(String str, String str2, String str3) {
        if (com.kwad.sdk.core.a.c.isEncodeKsSdk(str)) {
            return;
        }
        g(str2, str3, com.kwad.sdk.core.a.c.encodeKsSdk(str));
    }

    static <T> void a(String str, Map<String, T> map) {
        SharedPreferences sharedPreferencesIH = iH(str);
        if (sharedPreferencesIH == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesIH.edit();
        for (Map.Entry<String, T> entry : map.entrySet()) {
            try {
                a(editorEdit, entry.getKey(), entry.getValue());
            } catch (Throwable th) {
                com.kwad.sdk.core.d.c.e(TAG, Log.getStackTraceString(th));
            }
        }
        editorEdit.apply();
    }

    private static void a(SharedPreferences.Editor editor, String str, Object obj) {
        if (str != null) {
            if (obj instanceof Integer) {
                editor.putInt(str, ((Integer) obj).intValue());
                return;
            }
            if (obj instanceof Long) {
                editor.putLong(str, ((Long) obj).longValue());
                return;
            }
            if (obj instanceof Boolean) {
                editor.putBoolean(str, ((Boolean) obj).booleanValue());
                return;
            }
            if (obj instanceof Float) {
                editor.putFloat(str, ((Float) obj).floatValue());
            } else if (obj instanceof Set) {
                editor.putStringSet(str, (Set) obj);
            } else if (obj instanceof String) {
                editor.putString(str, String.valueOf(obj));
            }
        }
    }
}
