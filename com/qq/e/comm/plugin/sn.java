package com.qq.e.comm.plugin;

import android.text.TextUtils;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class sn {
    public static h4 a(h4 h4Var, JSONObject jSONObject) {
        if (h4Var == null) {
            h4Var = new h4(r1.d().b().a(), null, null, e2.NATIVEUNIFIEDAD, null, mb.DEFAULT);
        }
        if (jSONObject == null) {
            return h4Var;
        }
        String strOptString = jSONObject.optString("adId");
        if (!TextUtils.isEmpty(strOptString)) {
            h4Var.b = strOptString;
        }
        String strOptString2 = jSONObject.optString("productId");
        if (!TextUtils.isEmpty(strOptString2)) {
            h4Var.j0 = strOptString2;
        }
        return h4Var;
    }
}
