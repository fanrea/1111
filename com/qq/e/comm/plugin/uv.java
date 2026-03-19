package com.qq.e.comm.plugin;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class uv {
    final int a;
    final String b;
    final String c;
    final int d;
    final String e;
    int f;
    final int g;
    final String h;

    JSONObject b() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", this.a);
            jSONObject.put("url", this.b);
            jSONObject.put("headers", this.c);
            jSONObject.put("error_code", this.d);
            jSONObject.put("date", this.e);
            jSONObject.put("retry_times", this.f);
            jSONObject.put("adType", this.g);
            jSONObject.put("post_data", this.h);
        } catch (JSONException e) {
            e.getMessage();
        }
        return jSONObject;
    }

    uv(int i, String str, String str2, String str3, int i2, int i3) {
        this.a = i;
        this.b = str;
        this.c = str3;
        this.d = i2;
        this.e = m10.a();
        this.f = 0;
        this.g = i3;
        this.h = str2;
    }

    boolean a() {
        return !TextUtils.isEmpty(this.b) && this.f < 3 && this.e.equals(m10.a());
    }

    uv(JSONObject jSONObject) {
        this.a = jSONObject.optInt("type");
        this.b = jSONObject.optString("url");
        this.c = jSONObject.optString("headers");
        this.d = jSONObject.optInt("error_code");
        this.e = jSONObject.optString("date");
        this.f = jSONObject.optInt("retry_times");
        this.g = jSONObject.optInt("adType");
        this.h = jSONObject.optString("post_data");
    }
}
