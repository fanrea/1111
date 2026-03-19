package com.bytedance.msdk.core.hc;

import android.text.TextUtils;
import com.bytedance.msdk.gb.sy;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc {
    private int d;
    private final Map<String, Float> hc = new ConcurrentHashMap();
    private final Map<String, c> b = new ConcurrentHashMap();

    public hc(JSONObject jSONObject) {
        JSONArray jSONArrayOptJSONArray;
        if (jSONObject != null) {
            this.d = jSONObject.optInt("lt_days");
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("estimate");
            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.length() > 0) {
                Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    this.hc.put(next, Float.valueOf((float) jSONObjectOptJSONObject.optDouble(next)));
                }
            }
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("rule_excs");
            if (jSONObjectOptJSONObject2 == null || jSONObjectOptJSONObject2.length() == 0) {
                return;
            }
            Iterator<String> itKeys2 = jSONObjectOptJSONObject2.keys();
            while (itKeys2.hasNext()) {
                String next2 = itKeys2.next();
                JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject(next2);
                if (jSONObjectOptJSONObject3 != null && (jSONArrayOptJSONArray = jSONObjectOptJSONObject3.optJSONArray("prime_rits")) != null && jSONArrayOptJSONArray.length() > 0) {
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        String strOptString = jSONArrayOptJSONArray.optString(i);
                        this.b.put(strOptString, new c(next2, strOptString, jSONObjectOptJSONObject3));
                    }
                }
            }
        }
    }

    public JSONObject d(String str, sy syVar) throws JSONException {
        u uVar;
        if (!com.bytedance.msdk.core.hc.hc().r() || str == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        if (TextUtils.isEmpty(str)) {
            return jSONObject;
        }
        float fD = d(str);
        c cVar = this.b.get(str);
        if (cVar != null) {
            Map<String, u> mapU = cVar.u();
            String[] strArrB = cVar.b();
            if (mapU != null && !mapU.isEmpty() && strArrB != null && strArrB.length > 0) {
                for (String str2 : strArrB) {
                    if (!TextUtils.isEmpty(str2) && (uVar = mapU.get(str2)) != null) {
                        try {
                            jSONObject.putOpt(str2, Integer.valueOf(uVar.d(fD)));
                        } catch (Exception e) {
                            com.bytedance.msdk.d.u.b.c("", "calculateRangeByScore计算异常：(tableName：" + str2 + ",primeRit:" + str + "），" + e.getMessage());
                        }
                    }
                }
            }
        }
        syVar.put("gm_policy", jSONObject);
        syVar.put("adl_scr", Float.valueOf(fD));
        com.bytedance.msdk.core.d.mk().d(str, fD);
        return jSONObject;
    }

    public float d(String str) {
        c cVar = this.b.get(str);
        float fD = -1.0f;
        if (cVar != null) {
            Map<String, Float> mapHc = cVar.hc();
            String strC = cVar.c();
            if (mapHc != null) {
                if (mapHc.containsKey("lt_x_times")) {
                    Float f = mapHc.get("lt_x_times");
                    int iHc = d.hc();
                    if (f != null) {
                        fD = d(strC, f.floatValue() * iHc, -1.0f);
                    }
                }
                if (mapHc.containsKey("active_duration")) {
                    Float f2 = mapHc.get("active_duration");
                    long jAn = d.an();
                    if (f2 != null) {
                        fD = d(strC, f2.floatValue() * jAn, fD);
                    }
                }
                if (mapHc.containsKey("active_count")) {
                    Float f3 = mapHc.get("active_count");
                    int iC = d.c();
                    if (f3 != null) {
                        fD = d(strC, f3.floatValue() * iC, fD);
                    }
                }
                if (mapHc.containsKey("show_period")) {
                    Float f4 = mapHc.get("show_period");
                    long jGb = d.gb(str);
                    if (f4 != null) {
                        fD = d(strC, f4.floatValue() * jGb, fD);
                    }
                }
                if (mapHc.containsKey("show_count")) {
                    Float f5 = mapHc.get("show_count");
                    int iC2 = d.c(str);
                    if (f5 != null) {
                        fD = d(strC, f5.floatValue() * iC2, fD);
                    }
                }
                if (mapHc.containsKey("dislike_count")) {
                    Float f6 = mapHc.get("dislike_count");
                    int iHc2 = d.hc(str);
                    if (f6 != null) {
                        fD = d(strC, f6.floatValue() * iHc2, fD);
                    }
                }
                if (mapHc.containsKey("click_count")) {
                    Float f7 = mapHc.get("click_count");
                    int iAn = d.an(str);
                    if (f7 != null) {
                        fD = d(strC, f7.floatValue() * iAn, fD);
                    }
                }
                if (mapHc.containsKey("install_days")) {
                    Float f8 = mapHc.get("install_days");
                    int iU = d.u();
                    if (f8 != null) {
                        fD = d(strC, f8.floatValue() * iU, fD);
                    }
                }
                if (!this.hc.isEmpty()) {
                    for (Map.Entry<String, Float> entry : this.hc.entrySet()) {
                        if (entry != null) {
                            String key = entry.getKey();
                            float fFloatValue = entry.getValue().floatValue();
                            Float f9 = mapHc.get(key);
                            if (f9 != null) {
                                fD = d(strC, f9.floatValue() * fFloatValue, fD);
                            }
                        }
                    }
                }
            }
        }
        return fD;
    }

    private float d(String str, float f, float f2) {
        if (f2 == -1.0f) {
            return f;
        }
        str.hashCode();
        switch (str) {
            case "*":
                return f2 * f;
            case "+":
                return f2 + f;
            case "max":
                return Math.max(f, f2);
            case "min":
                return Math.min(f, f2);
            default:
                return f2;
        }
    }

    public int d() {
        return this.d;
    }

    public c hc(String str) {
        return this.b.get(str);
    }

    public String b(String str) {
        c cVarHc;
        if (str == null || (cVarHc = hc(str)) == null) {
            return null;
        }
        return cVarHc.d();
    }
}
