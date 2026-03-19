package com.qq.e.comm.plugin;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class ja {
    private JSONObject a;

    public ja() {
        this(new JSONObject());
    }

    public ja a(String str, Object obj) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return this;
        }
        try {
            this.a.putOpt(str, obj);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this;
    }

    public ja(JSONObject jSONObject) {
        this.a = jSONObject;
    }

    public String toString() {
        return this.a.toString();
    }

    public JSONObject a() {
        JSONObject jSONObject = this.a;
        if (jSONObject == null || jSONObject.length() <= 0) {
            return null;
        }
        return this.a;
    }
}
