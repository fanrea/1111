package com.qq.e.comm.plugin;

import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class ku {
    private final JSONObject a;
    private final JSONObject b;
    public JSONArray c;

    public ku(JSONObject jSONObject) {
        this.a = jSONObject;
        JSONObject jSONObjectOptJSONObject = jSONObject == null ? null : jSONObject.optJSONObject("playcfg");
        this.b = jSONObjectOptJSONObject;
        this.c = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optJSONArray("pct") : null;
    }

    public String toString() {
        JSONObject jSONObject = this.a;
        return jSONObject == null ? "{}" : jSONObject.toString();
    }

    public JSONObject b() {
        return this.b;
    }

    public JSONObject a() {
        return this.a;
    }

    public boolean c() {
        JSONArray jSONArray = this.c;
        if (jSONArray == null || jSONArray.length() == 0) {
            return false;
        }
        for (int i = 0; i < this.c.length(); i++) {
            if (this.c.optInt(i) != 0) {
                return false;
            }
        }
        return true;
    }
}
