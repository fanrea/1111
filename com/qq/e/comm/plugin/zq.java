package com.qq.e.comm.plugin;

import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
final class zq {
    static void a(yq yqVar, JSONObject jSONObject) {
        JSONObject jSONObject2;
        yqVar.a = jSONObject.optInt("ver");
        yqVar.b = jSONObject.optString("id");
        yqVar.c = jSONObject.optString("data");
        yqVar.d = jSONObject.optInt("orientation", 0);
        String strOptString = jSONObject.optString("dsl_pro");
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
            yqVar.e = new v9(jSONObject2);
        }
    }
}
