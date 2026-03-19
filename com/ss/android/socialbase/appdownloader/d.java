package com.ss.android.socialbase.appdownloader;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.mq;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class d {
    public String b;
    public String c;
    public String d;
    public int hc = -1;
    public String u;

    public String d() {
        return hc().toString();
    }

    public JSONObject hc() {
        JSONObject jSONObject = new JSONObject();
        d(jSONObject);
        return jSONObject;
    }

    public void d(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("ah_plan_type", this.d);
            jSONObject.put("error_code", String.valueOf(this.hc));
            jSONObject.put("error_msg", this.b);
            jSONObject.put("real_device_plan", this.c);
            jSONObject.put("device_plans", this.u);
        } catch (Throwable unused) {
        }
    }

    public static d d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        d dVar = new d();
        try {
            JSONObject jSONObject = new JSONObject(str);
            dVar.u = jSONObject.optString("device_plans", null);
            dVar.c = jSONObject.optString("real_device_plan", null);
            dVar.b = jSONObject.optString("error_msg", null);
            dVar.d = jSONObject.optString("ah_plan_type", null);
            String strOptString = jSONObject.optString("error_code");
            if (TextUtils.isEmpty(strOptString)) {
                dVar.hc = -1;
            } else {
                dVar.hc = Integer.parseInt(strOptString);
            }
        } catch (Throwable th) {
            mq.d(th);
        }
        return dVar;
    }
}
