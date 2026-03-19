package com.qq.e.comm.plugin;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class jb {
    public static boolean a(h4 h4Var) {
        return (h4Var == null || h4Var.L() == null || TextUtils.isEmpty(h4Var.L().b) || TextUtils.isEmpty(h4Var.L().a)) ? false : true;
    }

    public static ib a(JSONObject jSONObject) {
        ib ibVar = new ib();
        ibVar.b = jSONObject.optString("float_card_title");
        ibVar.a = jSONObject.optString("float_card_img");
        if (TextUtils.isEmpty(ibVar.b) || TextUtils.isEmpty(ibVar.a)) {
            return null;
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("float_card_tags");
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
            ibVar.c = new String[jSONArrayOptJSONArray.length()];
            int length = jSONArrayOptJSONArray.length();
            for (int i = 0; i < length; i++) {
                ibVar.c[i] = jSONArrayOptJSONArray.optString(i);
            }
        }
        ibVar.d = jSONObject.optString("float_card_discount");
        ibVar.e = jSONObject.optString("float_card_price");
        String strOptString = jSONObject.optString("float_card_button_txt");
        ibVar.f = strOptString;
        if (TextUtils.isEmpty(strOptString)) {
            if (y.d(jSONObject)) {
                ibVar.f = "立即下载";
            } else {
                ibVar.f = "查看详情";
            }
        }
        ibVar.toString();
        return ibVar;
    }
}
