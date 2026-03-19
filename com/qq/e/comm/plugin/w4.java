package com.qq.e.comm.plugin;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class w4 {
    protected void b(String str, JSONObject jSONObject) {
        r1.d().f().a(str, jSONObject.optJSONObject("ctrl_config"));
    }

    protected void a(String str, JSONObject jSONObject) throws JSONException {
        try {
            jSONObject.putOpt("ctrl_config", r1.d().f().b(str));
        } catch (JSONException e) {
            e.getMessage();
        }
    }
}
