package com.qq.e.comm.plugin;

import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
final class r3 {
    static void a(q3 q3Var, JSONObject jSONObject) {
        q3Var.b = jSONObject.optString("dl_progress");
        q3Var.c = jSONObject.optString("dl_paused");
        q3Var.d = jSONObject.optString("dl_finish");
        q3Var.e = jSONObject.optString("installed");
    }
}
