package com.bytedance.msdk.core.b;

import android.text.TextUtils;
import com.bytedance.msdk.core.tc.tc;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class b {
    private static boolean d(int i) {
        return i == 0 || i == 1 || i == 2;
    }

    private static boolean hc(int i) {
        return i == 3 || i == 4 || i == 5 || i == 6 || i == 7 || i == 8 || i == 9;
    }

    public static void d(String str, String str2, String str3) {
        if (com.bytedance.msdk.core.hc.hc().dc() != null) {
            com.bytedance.msdk.gb.d.b.d().insert(str, str2, str3, "show");
        }
    }

    public static void hc(String str, String str2, String str3) {
        if (com.bytedance.msdk.core.hc.hc().dc() != null) {
            com.bytedance.msdk.gb.d.b.d().insert(str, str2, str3, "send");
        }
    }

    public static void b(String str, String str2, String str3) {
        if (com.bytedance.msdk.core.hc.hc().dc() != null) {
            com.bytedance.msdk.gb.d.b.d().insert(str, str2, str3, "fill");
        }
    }

    public static void d(String str, int i) {
        if (com.bytedance.msdk.core.hc.hc().dc() == null || TextUtils.isEmpty(str)) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - (i * 3600000);
        com.bytedance.msdk.d.u.b.hc("TMe", "---预缓存优化删除存储的过期数据 primeRit = " + str + " startTime = " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(jCurrentTimeMillis)));
        com.bytedance.msdk.gb.d.b.d().d(str, jCurrentTimeMillis);
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x01cf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.bytedance.msdk.core.tc.hc d(com.bytedance.msdk.api.d.hc r30, com.bytedance.msdk.core.tc.hc r31) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 695
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.core.b.b.d(com.bytedance.msdk.api.d.hc, com.bytedance.msdk.core.tc.hc):com.bytedance.msdk.core.tc.hc");
    }

    private static int d(com.bytedance.msdk.core.tc.hc hcVar, hc hcVar2, int i) {
        if (!com.bytedance.msdk.core.hc.hc().hv()) {
            return 0;
        }
        if (hcVar2 == null || hcVar2.u() == null) {
            return 1;
        }
        if (!hcVar2.d(i)) {
            return 2;
        }
        if (hcVar2.hc() == 0) {
            return 3;
        }
        if (hcVar2.d() == 0) {
            return 4;
        }
        if (!hcVar2.h()) {
            return 5;
        }
        if (hcVar == null || !hcVar2.d(hcVar.fs())) {
            return 6;
        }
        if (hcVar.yn() == 0) {
            return 7;
        }
        if (d(hcVar, hcVar2)) {
            return d(hcVar) ? 9 : 200;
        }
        return 8;
    }

    private static boolean d(com.bytedance.msdk.core.tc.hc hcVar, hc hcVar2) {
        if (hcVar == null || hcVar.y() == null || hcVar2 == null) {
            return false;
        }
        for (tc tcVar : hcVar.y()) {
            double d = hcVar2.d(tcVar.w(), hcVar.fs());
            double dHc = hcVar2.hc(tcVar.w(), hcVar.fs());
            if (d != 0.0d || dHc != 0.0d) {
                return true;
            }
        }
        return false;
    }

    private static boolean d(com.bytedance.msdk.core.tc.hc hcVar) {
        if (hcVar == null) {
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        List<com.bytedance.msdk.gb.d.hc> listQuery = com.bytedance.msdk.gb.d.b.d().query("", hcVar.fs(), jCurrentTimeMillis - (hcVar.yn() * 3600000), jCurrentTimeMillis);
        return listQuery == null || listQuery.isEmpty();
    }

    private static void d(com.bytedance.msdk.api.d.hc hcVar, com.bytedance.msdk.core.tc.hc hcVar2, hc hcVar3, int i, Set<String> set, Map<String, d> map) throws JSONException {
        if (hcVar.tc() != null) {
            com.bytedance.msdk.d.u.b.hc("TMe", "预缓存优化存在埋点数据 无需重新存储");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("result", i);
            if (d(i)) {
                hcVar.d(jSONObject);
                return;
            }
            jSONObject.put("perform", d(i, hcVar3, map));
            if (hc(i)) {
                hcVar.d(jSONObject);
                return;
            }
            jSONObject.put("behavior_state", d(hcVar3));
            jSONObject.put("condition", hcVar3.hc());
            if (hcVar2 != null) {
                try {
                    jSONObject.put("behavior_ttl", hcVar2.yn());
                } catch (JSONException unused) {
                }
            }
            if (set != null && set.size() != 0) {
                JSONArray jSONArray = new JSONArray();
                Iterator<String> it = set.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next());
                }
                jSONObject.put("filtered_adn", jSONArray);
            }
            hcVar.d(jSONObject);
        } catch (JSONException unused2) {
        }
    }

    private static JSONArray d(hc hcVar) {
        JSONArray jSONArray = new JSONArray();
        if (hcVar != null && hcVar.d != null) {
            Iterator<Integer> it = hcVar.d.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next());
            }
        }
        return jSONArray;
    }

    private static JSONObject d(int i, hc hcVar, Map<String, d> map) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("rule_id", hcVar.b());
        jSONObject.put("rule_timestamp", hcVar.c());
        if (hc(i)) {
            return jSONObject;
        }
        jSONObject.put("condition", hcVar.d());
        jSONObject.put("rule_inuse", (i == 10 || i == 11) ? 1 : 0);
        if (map != null) {
            try {
                DecimalFormat decimalFormat = new DecimalFormat("#0.000");
                JSONObject jSONObject2 = new JSONObject();
                JSONObject jSONObject3 = new JSONObject();
                JSONObject jSONObject4 = new JSONObject();
                for (Map.Entry<String, d> entry : map.entrySet()) {
                    d value = entry.getValue();
                    if (value != null) {
                        jSONObject3.put(entry.getKey(), decimalFormat.format(value.hc()));
                        jSONObject4.put(entry.getKey(), decimalFormat.format(value.b()));
                    }
                }
                jSONObject2.put("ssr", jSONObject3);
                jSONObject2.put("srr", jSONObject4);
                jSONObject.put("res", jSONObject2);
            } catch (JSONException unused) {
            }
        }
        return jSONObject;
    }
}
