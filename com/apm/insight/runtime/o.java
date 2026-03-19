package com.apm.insight.runtime;

import android.text.TextUtils;
import com.baidu.mobstat.forbes.Config;
import java.io.File;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class o {
    protected static JSONObject a = new JSONObject();

    public static void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            String strA = a.a(jSONObject);
            File file = new File(com.apm.insight.o.p.j(com.apm.insight.g.f()), "apminsight/configCrash/configNative");
            if (strA != null) {
                JSONObject jSONObject2 = new JSONObject(strA);
                a = jSONObject2;
                com.apm.insight.o.j.a(file, b(jSONObject2), false);
            } else {
                a = new JSONObject();
            }
        } catch (JSONException unused) {
        } catch (Throwable th) {
            com.apm.insight.b.a().a("NPTH_CATCH", th);
        }
    }

    public static boolean a(String str, f fVar) {
        if (a == null) {
            return false;
        }
        if (fVar == null) {
            fVar = new f();
        }
        JSONObject jSONObjectOptJSONObject = a.optJSONObject(str);
        if (jSONObjectOptJSONObject == null || a(jSONObjectOptJSONObject.optJSONArray("disable"), fVar)) {
            return false;
        }
        return a(jSONObjectOptJSONObject.optJSONArray("enable"), fVar);
    }

    private static boolean a(JSONArray jSONArray, f fVar) {
        if (com.apm.insight.o.m.a(jSONArray)) {
            return false;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject == null) {
                com.apm.insight.b.a().a("NPTH_CATCH", new IllegalArgumentException("err config: " + jSONArray));
            } else if (a(jSONObjectOptJSONObject, fVar)) {
                return true;
            }
        }
        return false;
    }

    private static boolean a(JSONObject jSONObject, f fVar) {
        StringBuilder sb;
        Iterator<String> itKeys = jSONObject.keys();
        boolean z = false;
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (!TextUtils.isEmpty(next)) {
                z = true;
                if (next.startsWith("header_")) {
                    if (!a(jSONObject.optJSONObject(next), fVar.b(next.substring(7)))) {
                        sb = new StringBuilder();
                        com.apm.insight.o.q.a((Object) sb.append("not match ").append(next).toString());
                        return false;
                    }
                } else if (!next.startsWith("java_")) {
                    com.apm.insight.o.q.a((Object) ("no rules match " + next));
                } else if (!a(jSONObject.optJSONObject(next), fVar.a(next.substring(5)))) {
                    sb = new StringBuilder();
                    com.apm.insight.o.q.a((Object) sb.append("not match ").append(next).toString());
                    return false;
                }
            }
        }
        return z;
    }

    private static boolean a(JSONObject jSONObject, Object obj) {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("values");
        if (jSONArrayOptJSONArray.length() == 0) {
            return false;
        }
        String strOptString = jSONObject.optString(Config.OPERATOR);
        String strValueOf = String.valueOf(obj);
        if (strOptString.equals("=")) {
            return strValueOf.equals(String.valueOf(jSONArrayOptJSONArray.opt(0)));
        }
        if (strOptString.equals("in")) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                if (String.valueOf(jSONArrayOptJSONArray.opt(i)).equals(strValueOf)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static JSONArray b(JSONArray jSONArray, f fVar) {
        JSONArray jSONArray2 = new JSONArray();
        if (com.apm.insight.o.m.a(jSONArray)) {
            return jSONArray2;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject == null) {
                com.apm.insight.b.a().a("NPTH_CATCH", new IllegalArgumentException("err config: " + jSONArray));
            } else if (a(jSONObjectOptJSONObject, fVar)) {
                jSONArray2.put(jSONObjectOptJSONObject);
            }
        }
        return jSONArray2;
    }

    public static JSONObject b(JSONObject jSONObject) throws JSONException {
        StringBuilder sb;
        String str;
        Iterator<String> itKeys = jSONObject.keys();
        f fVar = new f();
        JSONObject jSONObject2 = new JSONObject();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (!"configType".equals(next)) {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(next);
                if (jSONObjectOptJSONObject == null) {
                    com.apm.insight.b.a().a("NPTH_CATCH", new IllegalArgumentException("err config with key: " + next));
                } else {
                    if (a(jSONObjectOptJSONObject.optJSONArray("disable"), fVar)) {
                        sb = new StringBuilder();
                        str = "match diable ";
                    } else {
                        JSONArray jSONArrayB = b(jSONObjectOptJSONObject.optJSONArray("enable"), fVar);
                        if (com.apm.insight.o.m.a(jSONArrayB)) {
                            sb = new StringBuilder();
                            str = "not match ";
                        } else {
                            try {
                                jSONObject2.put(next, new JSONObject().put("enable", jSONArrayB));
                            } catch (JSONException unused) {
                            }
                        }
                    }
                    com.apm.insight.o.q.a((Object) sb.append(str).append(next).toString());
                }
            }
        }
        return jSONObject2;
    }
}
