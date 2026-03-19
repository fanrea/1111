package com.qq.e.comm.plugin;

import android.text.TextUtils;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class hl {
    public static void a(w1 w1Var, JSONObject jSONObject) {
        if (w1Var == null || jSONObject == null || w1Var.z() == 1) {
            return;
        }
        a(jSONObject.optString("ip_ping_url"));
    }

    public static void a(h4 h4Var) {
        if (h4Var == null || !h4Var.s1()) {
            return;
        }
        a(h4Var.b0());
    }

    private static void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        zt.a(str, true);
    }
}
