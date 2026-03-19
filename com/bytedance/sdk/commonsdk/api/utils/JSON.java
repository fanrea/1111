package com.bytedance.sdk.commonsdk.api.utils;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class JSON {
    private static final String TAG = "JSON";

    private JSON() {
    }

    public static JSONObject build() {
        return new JSONObject();
    }

    public static JSONObject build(String str) {
        try {
            return new JSONObject(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static JSONObject build(Map<String, String> map) {
        try {
            return new JSONObject(map);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static JSONArray buildArr() {
        return new JSONArray();
    }

    public static JSONArray buildArr(String str) {
        try {
            return new JSONArray(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void putInt(JSONObject jSONObject, String str, int i) {
        if (jSONObject != null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                jSONObject.put(str, i);
            } catch (Throwable th) {
                CommonSdkLogger.d(TAG, "put int error: ", th);
            }
        }
    }

    public static void putLong(JSONObject jSONObject, String str, long j) {
        if (jSONObject != null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                jSONObject.put(str, j);
            } catch (Throwable th) {
                CommonSdkLogger.d(TAG, "put long error: ", th);
            }
        }
    }

    public static void putDouble(JSONObject jSONObject, String str, double d) {
        if (jSONObject != null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                jSONObject.put(str, d);
            } catch (Throwable th) {
                CommonSdkLogger.d(TAG, "put double error: ", th);
            }
        }
    }

    public static void putBoolean(JSONObject jSONObject, String str, boolean z) {
        if (jSONObject != null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                jSONObject.put(str, z);
            } catch (Throwable th) {
                CommonSdkLogger.d(TAG, "put double error: ", th);
            }
        }
    }

    public static void putObject(JSONObject jSONObject, String str, Object obj) {
        if (jSONObject != null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                jSONObject.put(str, obj);
            } catch (Throwable th) {
                CommonSdkLogger.d(TAG, "put double error: ", th);
            }
        }
    }

    public static int getInt(JSONObject jSONObject, String str) {
        return getInt(jSONObject, str, 0);
    }

    public static int getInt(JSONObject jSONObject, String str, int i) {
        if (jSONObject != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    return jSONObject.optInt(str, i);
                }
            } catch (Throwable th) {
                CommonSdkLogger.d(TAG, "get int error: ", th);
            }
        }
        return i;
    }

    public static long getLong(JSONObject jSONObject, String str) {
        return getLong(jSONObject, str, 0L);
    }

    public static long getLong(JSONObject jSONObject, String str, long j) {
        if (jSONObject != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    return jSONObject.optLong(str, j);
                }
            } catch (Throwable th) {
                CommonSdkLogger.d(TAG, "get long error: ", th);
            }
        }
        return j;
    }

    public static double getDouble(JSONObject jSONObject, String str) {
        return getDouble(jSONObject, str, 0.0d);
    }

    public static double getDouble(JSONObject jSONObject, String str, double d) {
        if (jSONObject != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    return jSONObject.optDouble(str, d);
                }
            } catch (Throwable th) {
                CommonSdkLogger.d(TAG, "get double error: ", th);
            }
        }
        return d;
    }

    public static String getString(JSONObject jSONObject, String str) {
        return getString(jSONObject, str, "");
    }

    public static String getString(JSONObject jSONObject, String str, String str2) {
        if (jSONObject != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    return jSONObject.optString(str, str2);
                }
            } catch (Throwable th) {
                CommonSdkLogger.d(TAG, "get string error: ", th);
            }
        }
        return str2;
    }

    public static boolean getBoolean(JSONObject jSONObject, String str) {
        return getBoolean(jSONObject, str, false);
    }

    public static boolean getBoolean(JSONObject jSONObject, String str, boolean z) {
        if (jSONObject != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    return jSONObject.optBoolean(str, z);
                }
            } catch (Throwable th) {
                CommonSdkLogger.d(TAG, "get boolean error: ", th);
            }
        }
        return z;
    }

    public static Object getObject(JSONObject jSONObject, String str) {
        return getObject(jSONObject, str, null);
    }

    public static Object getObject(JSONObject jSONObject, String str, Object obj) {
        if (jSONObject != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    return jSONObject.opt(str);
                }
            } catch (Throwable th) {
                CommonSdkLogger.d(TAG, "get object error: ", th);
            }
        }
        return obj;
    }

    public static JSONObject getJsonObject(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return null;
        }
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return jSONObject.optJSONObject(str);
        } catch (Throwable th) {
            CommonSdkLogger.d(TAG, "get json object error: ", th);
            return null;
        }
    }

    public static JSONArray getJsonArray(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return null;
        }
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return jSONObject.optJSONArray(str);
        } catch (Throwable th) {
            CommonSdkLogger.d(TAG, "get json array error: ", th);
            return null;
        }
    }

    public static Iterator<String> getKeys(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            return jSONObject.keys();
        } catch (Throwable th) {
            CommonSdkLogger.d(TAG, "get json object keys error: ", th);
            return null;
        }
    }

    public static JSONArray remove(JSONArray jSONArray, int i) {
        JSONArray jSONArray2 = new JSONArray();
        if (i < 0 || i >= jSONArray.length()) {
            return jSONArray;
        }
        for (int i2 = 0; i2 < i; i2++) {
            try {
                jSONArray2.put(jSONArray.getJSONObject(i2));
            } catch (JSONException unused) {
            }
        }
        while (true) {
            i++;
            if (i >= jSONArray.length()) {
                return jSONArray2;
            }
            try {
                jSONArray2.put(jSONArray.getJSONObject(i));
            } catch (JSONException unused2) {
            }
        }
    }

    public static JSONObject getJSONObject(JSONArray jSONArray, int i) {
        try {
            return jSONArray.getJSONObject(i);
        } catch (JSONException unused) {
            return null;
        }
    }
}
