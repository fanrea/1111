package com.alipay.sdk.m.p;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.alipay.sdk.m.o.a;
import com.alipay.sdk.m.u.m;
import com.alipay.sdk.m.u.n;
import com.bytedance.sdk.djx.net.req.MediaTypeUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public abstract class e {
    public static final String c = "msp-gzip";
    public static final String d = "Msp-Param";
    public static final String e = "Operation-Type";
    public static final String f = "content-type";
    public static final String g = "Version";
    public static final String h = "AppId";
    public static final String i = "des-mode";
    public static final String j = "namespace";
    public static final String k = "api_name";
    public static final String l = "api_version";
    public static final String m = "data";
    public static final String n = "params";
    public static final String o = "public_key";
    public static final String p = "device";
    public static final String q = "action";
    public static final String r = "type";
    public static final String s = "method";
    public boolean a = true;
    public boolean b = true;

    public Map<String, String> a(boolean z, String str) {
        HashMap map = new HashMap();
        map.put(c, String.valueOf(z));
        map.put(e, "alipay.msp.cashier.dispatch.bytes");
        map.put(f, MediaTypeUtils.APPLICATION_OCTET_STREAM);
        map.put(g, "2.0");
        map.put(h, "TAOBAO");
        map.put(d, a.a(str));
        map.put(i, "CBC");
        return map;
    }

    public abstract JSONObject a() throws JSONException;

    public String b() {
        return "4.9.0";
    }

    public abstract boolean c();

    public String a(com.alipay.sdk.m.s.a aVar) throws JSONException {
        HashMap<String, String> map = new HashMap<>();
        map.put("device", Build.MODEL);
        map.put("namespace", "com.alipay.mobilecashier");
        map.put(k, "com.alipay.mcpay");
        map.put(l, b());
        return a(aVar, map, new HashMap<>());
    }

    public static JSONObject a(String str, String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("type", str);
        jSONObject2.put(s, str2);
        jSONObject.put("action", jSONObject2);
        return jSONObject;
    }

    public String a(com.alipay.sdk.m.s.a aVar, String str, JSONObject jSONObject) throws JSONException {
        com.alipay.sdk.m.s.b bVarD = com.alipay.sdk.m.s.b.d();
        com.alipay.sdk.m.t.a aVarA = com.alipay.sdk.m.t.a.a(bVarD.b());
        JSONObject jSONObjectA = com.alipay.sdk.m.u.d.a(new JSONObject(), jSONObject);
        try {
            jSONObjectA.put(com.alipay.sdk.m.l.b.d, str);
            jSONObjectA.put("tid", aVarA.d());
            jSONObjectA.put(com.alipay.sdk.m.l.b.b, bVarD.a().a(aVar, aVarA, c()));
            jSONObjectA.put(com.alipay.sdk.m.l.b.e, n.a(aVar, bVarD.b(), com.alipay.sdk.m.j.a.d, false));
            jSONObjectA.put(com.alipay.sdk.m.l.b.f, n.h(bVarD.b()));
            jSONObjectA.put(com.alipay.sdk.m.l.b.h, com.alipay.sdk.m.l.a.g);
            jSONObjectA.put(com.alipay.sdk.m.l.b.g, bVarD.c());
            jSONObjectA.put(com.alipay.sdk.m.l.b.j, aVarA.c());
            jSONObjectA.put(com.alipay.sdk.m.l.b.k, com.alipay.sdk.m.m.b.b(bVarD.b()));
        } catch (Throwable th) {
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, "BodyErr", th);
            com.alipay.sdk.m.u.e.a(th);
        }
        return jSONObjectA.toString();
    }

    public static boolean a(a.b bVar) {
        return Boolean.valueOf(a(bVar, c)).booleanValue();
    }

    public static String a(a.b bVar, String str) {
        Map<String, List<String>> map;
        List<String> list;
        if (bVar == null || str == null || (map = bVar.a) == null || (list = map.get(str)) == null) {
            return null;
        }
        return TextUtils.join(",", list);
    }

    public String a(com.alipay.sdk.m.s.a aVar, HashMap<String, String> map, HashMap<String, String> map2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                jSONObject2.put(entry.getKey(), entry.getValue());
            }
        }
        if (map2 != null) {
            JSONObject jSONObject3 = new JSONObject();
            for (Map.Entry<String, String> entry2 : map2.entrySet()) {
                jSONObject3.put(entry2.getKey(), entry2.getValue());
            }
            jSONObject2.put("params", jSONObject3);
        }
        jSONObject.put("data", jSONObject2);
        return jSONObject.toString();
    }

    public static boolean a(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject("data");
            if (!jSONObject.has("params")) {
                return false;
            }
            String strOptString = jSONObject.getJSONObject("params").optString(o, null);
            if (TextUtils.isEmpty(strOptString)) {
                return false;
            }
            com.alipay.sdk.m.m.b.a(strOptString);
            return true;
        } catch (JSONException e2) {
            com.alipay.sdk.m.u.e.a(e2);
            return false;
        }
    }

    public b a(com.alipay.sdk.m.s.a aVar, Context context) throws Throwable {
        return a(aVar, context, "");
    }

    public b a(com.alipay.sdk.m.s.a aVar, Context context, String str) throws Throwable {
        return a(aVar, context, str, m.b(context));
    }

    public b a(com.alipay.sdk.m.s.a aVar, Context context, String str, String str2) throws Throwable {
        return a(aVar, context, str, str2, true);
    }

    public b a(com.alipay.sdk.m.s.a aVar, Context context, String str, String str2, boolean z) throws Throwable {
        com.alipay.sdk.m.u.e.b(com.alipay.sdk.m.l.a.A, "Packet: " + str2);
        c cVar = new c(this.b);
        b bVar = new b(a(aVar), a(aVar, str, a()));
        Map<String, String> mapA = a(false, str);
        d dVarA = cVar.a(bVar, this.a, mapA.get("iSr"));
        a.b bVarA = com.alipay.sdk.m.o.a.a(context, new a.C0055a(str2, a(dVarA.b(), str), dVarA.a()));
        if (bVarA != null) {
            b bVarA2 = cVar.a(new d(a(bVarA), bVarA.c), mapA.get("iSr"));
            return (bVarA2 != null && a(bVarA2.b()) && z) ? a(aVar, context, str, str2, false) : bVarA2;
        }
        throw new RuntimeException("Response is null.");
    }
}
