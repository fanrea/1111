package com.kwai.middleware.azeroth.utils;

import com.kwai.middleware.azeroth.interfaces.JsonAdapter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class JsonUtils {
    private JsonUtils() {
    }

    public static <T extends JsonAdapter> T fromJson(String str, Class<T> cls) {
        return (T) ((JsonAdapter) JavaCalls.newEmptyInstance(cls)).fromJson(str);
    }

    public static <T extends JsonAdapter> T fromJson(JSONObject jSONObject, String str, Class<T> cls) {
        return (T) ((JsonAdapter) JavaCalls.newEmptyInstance(cls)).fromJson(optString(jSONObject, str));
    }

    public static Map<String, String> fromJsonToMap(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            HashMap map = new HashMap();
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                map.put(next, jSONObject.optString(next));
            }
            return map;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static JSONObject toJson(JsonAdapter jsonAdapter) {
        if (jsonAdapter == null) {
            return new JSONObject();
        }
        return jsonAdapter.toJson();
    }

    public static JSONObject toJson(Map map) {
        return map == null ? new JSONObject() : new JSONObject(map);
    }

    public static boolean hasValue(JSONObject jSONObject, String str) {
        return jSONObject.has(str) && jSONObject.isNull(str);
    }

    public static String optString(JSONObject jSONObject, String str) {
        Object objOpt;
        return (jSONObject == null || TextUtils.isEmpty(str) || (objOpt = jSONObject.opt(str)) == null) ? "" : String.valueOf(objOpt);
    }
}
