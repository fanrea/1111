package com.kwad.tachikoma.t;

import com.tkruntime.v8.V8Array;
import com.tkruntime.v8.V8Object;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class c {
    public static JSONObject d(Map<String, Object> map) throws JSONException {
        Object objT;
        JSONObject jSONObject = new JSONObject();
        if (map != null && !map.isEmpty()) {
            try {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    String key = entry.getKey();
                    if ((key instanceof String) && (objT = t(entry.getValue())) != null) {
                        jSONObject.put(key, objT);
                    }
                }
            } catch (Exception unused) {
            }
        }
        return jSONObject;
    }

    private static JSONArray f(List<Object> list) {
        JSONArray jSONArray = new JSONArray();
        if (list.size() == 0) {
            return jSONArray;
        }
        Iterator<Object> it = list.iterator();
        while (it.hasNext()) {
            Object objT = t(it.next());
            if (objT != null) {
                jSONArray.put(objT);
            }
        }
        return jSONArray;
    }

    private static JSONArray c(V8Array v8Array) {
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < v8Array.length(); i++) {
            Object objT = t(v8Array.get(i));
            if (objT != null) {
                jSONArray.put(objT);
            }
        }
        return jSONArray;
    }

    private static Object t(Object obj) {
        if ((obj instanceof String) || (obj instanceof Integer) || (obj instanceof Double) || (obj instanceof Long) || (obj instanceof Float) || (obj instanceof Boolean)) {
            return obj;
        }
        if (obj instanceof Map) {
            return d((Map) obj);
        }
        if (obj instanceof List) {
            return f((List) obj);
        }
        if (obj instanceof V8Array) {
            return c((V8Array) obj);
        }
        if (obj instanceof V8Object) {
            return d(((V8Object) obj).getAll());
        }
        return null;
    }
}
