package com.qq.e.comm.plugin;

import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
final class w9 {
    static void a(v9 v9Var, JSONObject jSONObject) {
        JSONObject jSONObject2;
        v9Var.a = jSONObject.optInt("landing_page") == 2;
        v9Var.b = jSONObject.optInt("has_endcard") == 1;
        v9Var.c = jSONObject.optString("freq_key");
        v9Var.d = jSONObject.optInt("freq_count");
        String strOptString = jSONObject.optString("ext");
        if (strOptString == null || strOptString.length() < 2) {
            jSONObject2 = null;
        } else {
            try {
                jSONObject2 = new JSONObject(strOptString);
            } catch (Exception unused) {
            }
        }
        if (jSONObject2 == null) {
            try {
                jSONObject2 = new JSONObject("{}");
            } catch (Exception unused2) {
            }
        }
        if (jSONObject2 != null) {
            v9Var.e = new t9(jSONObject2);
        }
    }
}
