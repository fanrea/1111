package com.pangrowth.adclog;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Unexpected interfaces in signature: [java.lang.Object<org.json.JSONObject>] */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class j2 {
    public JSONObject a() throws Throwable {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("used_memory", ((Runtime.getRuntime().totalMemory() / 1024) / 1024) + "MB");
            jSONObject.put("total_memory", ((Runtime.getRuntime().maxMemory() / 1024) / 1024) + "MB");
            jSONObject.put("sd_all_size", u2.b()[0] + "MB");
            jSONObject.put("sd_avail_size", u2.b()[1] + "MB");
            String str = "";
            for (String str2 : u2.a()) {
                str = str + str2 + "  ";
            }
            jSONObject.put("cpu_info", str);
            jSONObject.put("kernel_version", u2.c()[0]);
            jSONObject.put("firmware_version", u2.c()[1]);
            jSONObject.put("model", u2.c()[2]);
            jSONObject.put("system_version", u2.c()[3]);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
