package com.qq.e.comm.plugin;

import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
final class fd {
    static void a(ed edVar, JSONObject jSONObject) {
        edVar.L1 = jSONObject.optString("endcard");
        edVar.M1 = nt.b(jSONObject.optJSONArray("img_list"));
        edVar.N1 = jSONObject.optInt("pattern_type");
    }
}
