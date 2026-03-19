package com.qq.e.comm.plugin;

import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
final class e7 {
    static void a(d7 d7Var, JSONObject jSONObject) {
        d7Var.a = jSONObject.optInt("type");
        d7Var.b = jSONObject.optString("cta_txt");
        d7Var.c = jSONObject.optString("form_url");
        d7Var.d = jSONObject.optString("consult_url");
        d7Var.e = jSONObject.optString("tel");
    }
}
