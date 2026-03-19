package com.qq.e.comm.plugin;

import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
final class gr {
    static void a(fr frVar, JSONObject jSONObject) {
        frVar.I1 = jSONObject.optInt("pattern_type");
        frVar.J1 = nt.b(jSONObject.optJSONArray("img_list"));
        frVar.K1 = jSONObject.optString("endcard");
    }
}
