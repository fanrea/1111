package com.qq.e.comm.plugin;

import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
final class u9 {
    static void a(t9 t9Var, JSONObject jSONObject) {
        t9Var.a = jSONObject.optInt("end_card_countdown", 0);
        t9Var.b = jSONObject.optInt("end_card_type", 0);
        t9Var.c = jSONObject.optInt("image_slide_time", -1);
        t9Var.d = jSONObject.optInt("miit_dismiss_time", -1);
        t9Var.e = jSONObject.optInt("end_card_showtime", -1);
        t9Var.f = jSONObject.optInt("tpl_invalid", 0) == 1;
        t9Var.g = jSONObject.optDouble("dim_amount", -1.0d);
        t9Var.h = jSONObject.optInt("eac", 0);
        t9Var.i = jSONObject.optInt("novel_reading", 0) == 1;
        t9Var.j = jSONObject.optInt("clp", 0) == 1;
        t9Var.k = jSONObject.optInt("et", 0);
        t9Var.l = jSONObject.optInt("multi_reward", 0) == 1;
        t9Var.m = jSONObject.optInt("dlcte", -1);
        t9Var.n = jSONObject.optJSONArray("as");
        t9Var.o = jSONObject.optString("tc");
        t9Var.p = jSONObject.optString("fb");
        t9Var.r = jSONObject.optInt(com.baidu.mobads.container.adrequest.g.ac, 1);
        t9Var.s = jSONObject.optInt("we") == 1;
        t9Var.t = jSONObject.optInt(com.baidu.mobads.container.util.x.m) == 1;
        t9Var.u = jSONObject.optInt("iiaf", 0) == 1;
    }
}
