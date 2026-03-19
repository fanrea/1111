package com.bytedance.msdk.core.tc;

import com.bytedance.sdk.component.utils.mq;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class c {
    private String an;
    private int b;
    private String c;
    private double d;
    private JSONObject h;
    private double hc;
    private int u;

    private c(double d, double d2, int i, String str, int i2, String str2, JSONObject jSONObject) {
        this.d = d;
        this.hc = d2;
        this.b = i;
        this.c = str;
        this.u = i2;
        this.an = str2;
        this.h = jSONObject;
    }

    public static void d(JSONObject jSONObject, Map<String, c> map) {
        JSONArray jSONArrayOptJSONArray;
        if (jSONObject == null || (jSONArrayOptJSONArray = jSONObject.optJSONArray("prime_rits")) == null) {
            return;
        }
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            try {
                String strOptString = jSONArrayOptJSONArray.optString(i);
                try {
                    map.put(strOptString, new c(jSONObject.optDouble("upper", 0.0d), jSONObject.optDouble("lower", 0.0d), jSONObject.optInt("type"), strOptString, jSONObject.optInt("js_mode"), jSONObject.optString("rule_id"), jSONObject.optJSONObject("refresh_time")));
                } catch (Exception e) {
                    e = e;
                    mq.d(e);
                }
            } catch (Exception e2) {
                e = e2;
            }
        }
    }

    public double d() {
        return this.d;
    }

    public double hc() {
        return this.hc;
    }

    public int getType() {
        return this.b;
    }

    public int b() {
        return this.u;
    }

    public String c() {
        return this.an;
    }

    public int d(String str) {
        JSONObject jSONObject = this.h;
        if (jSONObject != null) {
            return jSONObject.optInt(str);
        }
        return 0;
    }

    public boolean u() {
        return this.d <= 0.0d && this.hc <= 0.0d;
    }
}
