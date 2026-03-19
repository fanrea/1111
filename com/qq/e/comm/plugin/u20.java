package com.qq.e.comm.plugin;

import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class u20 {
    public static h4 a(String str, String str2, int i, String str3, JSONObject jSONObject) {
        h4 h4Var = new h4(r1.d().b().a(), str2, null, e2.a(i), jSONObject, mb.DEFAULT);
        h4Var.b = str;
        h4Var.r = str3;
        if (jSONObject != null) {
            h4Var.n = jSONObject.optInt("producttype");
            h4Var.j0 = jSONObject.optString("productid");
            h4Var.V = jSONObject.optInt("video_duration");
            h4Var.L0 = jSONObject.optString("ext3");
        }
        return h4Var;
    }

    public static JSONObject a(h4 h4Var) {
        return new jn().a("producttype", h4Var.B0()).a("productid", h4Var.A0()).a("video_duration", h4Var.W0()).a("ext3", h4Var.T()).a();
    }
}
