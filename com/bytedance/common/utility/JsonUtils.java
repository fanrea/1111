package com.bytedance.common.utility;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class JsonUtils {
    private JsonUtils() {
    }

    public static void optPut(JSONObject jSONObject, String str, Object obj) throws JSONException {
        if (jSONObject == null || StringUtils.isEmpty(str)) {
            return;
        }
        try {
            jSONObject.put(str, obj);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static int queryInt(JSONObject jSONObject, String str, int i) {
        return (jSONObject == null || StringUtils.isEmpty(str) || !jSONObject.has(str)) ? i : jSONObject.optInt(str, i);
    }

    public static String queryString(JSONObject jSONObject, String str, String str2) {
        return (jSONObject == null || StringUtils.isEmpty(str) || !jSONObject.has(str)) ? str2 : jSONObject.optString(str, str2);
    }

    public static long queryLong(JSONObject jSONObject, String str, long j) {
        return (jSONObject == null || StringUtils.isEmpty(str) || !jSONObject.has(str)) ? j : jSONObject.optLong(str, j);
    }

    public static boolean queryBoolean(JSONObject jSONObject, String str, boolean z) {
        return (jSONObject == null || StringUtils.isEmpty(str) || !jSONObject.has(str)) ? z : jSONObject.optBoolean(str, z);
    }
}
