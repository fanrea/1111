package com.qq.e.comm.plugin;

import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
final class nu {
    static void a(mu muVar, JSONObject jSONObject) {
        muVar.I1 = jSONObject.optInt(com.baidu.mobads.container.adrequest.g.s);
        muVar.J1 = jSONObject.optInt("need_empty_report") == 1;
        muVar.K1 = jSONObject.optInt("is_empty") == 1;
        muVar.L1 = jSONObject.optString("uoid");
        muVar.M1 = jSONObject.optInt("rot_index", -1);
        muVar.N1 = jSONObject.optInt("timelife");
        muVar.P1 = jSONObject.optString("video_md5");
        muVar.Q1 = jSONObject.optString("joint_uoid");
        muVar.R1 = jSONObject.optString("joint_loc");
    }
}
