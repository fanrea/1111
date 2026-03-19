package com.pangrowth.adclog;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class t1 extends r1 {
    public g1 b;

    @Override // com.pangrowth.adclog.r1
    public String b() {
        return "abtest";
    }

    @Override // com.pangrowth.adclog.r1
    public boolean b(p1 p1Var) throws JSONException {
        JSONObject jSONObject = new JSONObject(p1Var.a);
        if (this.b == null) {
            return false;
        }
        if (a(jSONObject, p1Var)) {
            return true;
        }
        String strOptString = jSONObject.optString("field");
        if (TextUtils.isEmpty(strOptString)) {
            return false;
        }
        Object obj = jSONObject.get(com.alipay.sdk.m.p0.b.d);
        this.b.b(strOptString, obj);
        if (this.b.c()) {
            this.b.a(jSONObject.optString("spKey"), obj);
        }
        q1 q1VarA = this.b.a();
        if (q1VarA.a) {
            c(p1Var);
        } else {
            a(q1VarA.b, q1VarA.c, p1Var);
        }
        return true;
    }
}
