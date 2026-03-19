package com.qq.e.comm.plugin;

import android.text.TextUtils;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class n4 {
    private static final Queue<JSONObject> a = new ConcurrentLinkedQueue();
    private static final Map<String, Integer> b = new ConcurrentHashMap();
    private static final Map<String, Integer> c = new ConcurrentHashMap();
    private static final Map<String, Integer> d = new ConcurrentHashMap();

    public static Object a(String str, String str2) {
        Integer num;
        if (!ub.c().e() || (num = b.get(str)) == null) {
            return null;
        }
        if (num.intValue() == 3) {
            if (TextUtils.isEmpty(str2)) {
                return null;
            }
            str = vb.a(str, str2);
        }
        JSONObject jSONObjectA = ub.c().a(str);
        if (jSONObjectA == null) {
            return null;
        }
        return jSONObjectA.opt("sm");
    }

    public static void c() {
        a.clear();
        b.clear();
        c.clear();
        d.clear();
    }

    public static JSONObject a(String str, e2 e2Var) throws JSONException {
        String strA;
        if (ub.c().e()) {
            Map<String, Integer> map = c;
            if (!map.isEmpty()) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    for (Map.Entry<String, Integer> entry : map.entrySet()) {
                        String key = entry.getKey();
                        int iIntValue = entry.getValue().intValue();
                        if (iIntValue == 1) {
                            strA = key;
                        } else if (iIntValue == 2) {
                            strA = vb.a(key, Integer.valueOf(e2Var.d()));
                        } else if (iIntValue == 3) {
                            strA = vb.a(key, str);
                        }
                        JSONObject jSONObjectA = ub.c().a(strA);
                        Object objOpt = jSONObjectA != null ? jSONObjectA.opt("adreq") : null;
                        if (objOpt != null) {
                            jSONObject.put(key, objOpt);
                        }
                    }
                    if (jSONObject.length() > 0) {
                        return jSONObject;
                    }
                } catch (Exception e) {
                    e.getMessage();
                }
            }
        }
        return null;
    }

    public static void b(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !str.startsWith("eacfg_")) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str2);
            JSONArray jSONArrayE = vb.e(jSONObject);
            if (jSONArrayE != null && jSONArrayE.length() > 0) {
                a.add(jSONObject);
                int iB = vb.b(jSONObject);
                if (iB > 0) {
                    d.put(str.substring(6), Integer.valueOf(iB));
                }
                int iD = vb.d(jSONObject);
                int iC = vb.c(jSONObject);
                for (int i = 0; i < jSONArrayE.length(); i++) {
                    String strOptString = jSONArrayE.optString(i);
                    if (!TextUtils.isEmpty(strOptString)) {
                        if (iC == 1) {
                            b.put(strOptString, Integer.valueOf(iD));
                        } else if (iC == 2) {
                            c.put(strOptString, Integer.valueOf(iD));
                        }
                    }
                }
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public static String a(String str) {
        return str + "_eaexp";
    }

    static Queue<JSONObject> a() {
        return a;
    }

    public static Map<String, Integer> b() {
        return d;
    }
}
