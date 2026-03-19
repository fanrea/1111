package com.apm.insight.entity;

import com.apm.insight.o.m;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class d {
    private static String a;
    private static JSONObject b;

    private static void a() {
    }

    public static void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            c(jSONObject);
        } catch (Throwable unused) {
        }
    }

    public static void b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            d(jSONObject);
        } catch (Throwable unused) {
        }
    }

    private static void c(JSONObject jSONObject) throws JSONException {
        Object objOpt;
        a();
        JSONObject jSONObject2 = b;
        if (jSONObject2 == null) {
            return;
        }
        Iterator<String> itKeys = jSONObject2.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (!"slardar_filter".equals(next) && (objOpt = b.opt(next)) != null) {
                try {
                    jSONObject.put(next, objOpt);
                } catch (JSONException unused) {
                }
            }
        }
    }

    private static void d(JSONObject jSONObject) throws JSONException {
        a();
        JSONObject jSONObject2 = b;
        if (jSONObject2 == null) {
            return;
        }
        JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject("slardar_filter");
        if (m.a(jSONObjectOptJSONObject)) {
            return;
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("filters");
        if (jSONObjectOptJSONObject2 == null) {
            jSONObjectOptJSONObject2 = new JSONObject();
            try {
                jSONObject.put("filters", jSONObjectOptJSONObject2);
            } catch (JSONException unused) {
            }
        }
        a.b(jSONObjectOptJSONObject2, jSONObjectOptJSONObject);
    }
}
