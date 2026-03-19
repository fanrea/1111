package com.yxcorp.kuaishou.addfp.android.b;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
class c {
    boolean a;
    int b;
    boolean c;
    String d;

    c(String str) {
        this.a = true;
        if (TextUtils.isEmpty(str)) {
            this.a = false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.b = jSONObject.optInt("errorCode", 2);
            this.c = jSONObject.optBoolean("userSet", true);
            this.d = jSONObject.optString(com.alipay.sdk.m.p0.b.d, "KWE_OTHER");
        } catch (JSONException e) {
            this.a = false;
            e.printStackTrace();
        }
    }

    public String a(boolean z) {
        if (!this.a) {
            return "KWE_OTHER";
        }
        if (z != this.c) {
            return "KWE_NPN";
        }
        int i = this.b;
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? "KWE_OTHER" : "KWE_NS" : "KWE_N" : "KWE_PE" : "KWE_PN" : !TextUtils.isEmpty(this.d) ? this.d : "KWE_N";
    }
}
