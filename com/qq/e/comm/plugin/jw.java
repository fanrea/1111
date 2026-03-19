package com.qq.e.comm.plugin;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class jw {
    private JSONObject a;
    private int b;

    public JSONObject b() {
        return this.a;
    }

    public int a() {
        return this.b;
    }

    public void a(int i) {
        this.b = i;
    }

    public void a(JSONObject jSONObject) {
        this.a = jSONObject;
    }

    public void a(long j) throws JSONException {
        JSONObject jSONObject = this.a;
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("adReturnTime", j);
        } catch (JSONException unused) {
        }
    }
}
