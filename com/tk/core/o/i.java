package com.tk.core.o;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class i {
    public static String j(Map<String, Object> map) {
        try {
            return new JSONObject(map).toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static Map<String, Object> cV(String str) {
        try {
            return b(new JSONObject(str));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static Map<String, Object> b(JSONObject jSONObject) throws JSONException {
        HashMap map = new HashMap();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            Object objB = jSONObject.get(next);
            if (objB instanceof JSONObject) {
                objB = b((JSONObject) objB);
            }
            map.put(next, objB);
        }
        return map;
    }
}
