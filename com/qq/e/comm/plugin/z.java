package com.qq.e.comm.plugin;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class z extends x4 {
    z() {
    }

    Object a(String str) {
        return this.a.opt(str);
    }

    z(String str) {
        super(str);
    }

    Object a(String str, String str2) {
        JSONObject jSONObjectOptJSONObject = this.a.optJSONObject("ps");
        JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optJSONObject(str2) : null;
        if (jSONObjectOptJSONObject2 != null) {
            return jSONObjectOptJSONObject2.opt(str);
        }
        return null;
    }

    void a(String str, Object obj) throws JSONException {
        try {
            this.a.putOpt(str, obj);
        } catch (JSONException unused) {
        }
    }

    void a(String str, Object obj, String str2) throws JSONException {
        try {
            JSONObject jSONObjectOptJSONObject = this.a.optJSONObject("ps");
            if (jSONObjectOptJSONObject == null) {
                jSONObjectOptJSONObject = new JSONObject();
                this.a.putOpt("ps", jSONObjectOptJSONObject);
            }
            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(str2);
            if (jSONObjectOptJSONObject2 == null) {
                jSONObjectOptJSONObject2 = new JSONObject();
                jSONObjectOptJSONObject.putOpt(str2, jSONObjectOptJSONObject2);
            }
            if (obj == null) {
                jSONObjectOptJSONObject2.remove(str);
            } else {
                jSONObjectOptJSONObject2.putOpt(str, obj);
            }
        } catch (JSONException unused) {
        }
    }
}
