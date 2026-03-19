package com.pangrowth.adclog;

import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class f2 extends r1 {
    public n1 b = null;

    @Override // com.pangrowth.adclog.r1
    public String b() {
        return "route";
    }

    @Override // com.pangrowth.adclog.r1
    public boolean b(p1 p1Var) {
        String strOptString = new JSONObject(p1Var.a).optString("schema");
        if (TextUtils.isEmpty(strOptString)) {
            a("路由scheme为空", p1Var);
            return true;
        }
        n1 n1Var = this.b;
        if (n1Var == null) {
            return false;
        }
        n1Var.a(strOptString);
        q1 q1VarA = this.b.a();
        if (q1VarA.a) {
            c(p1Var);
        } else {
            a(q1VarA.b, q1VarA.c, p1Var);
        }
        return true;
    }
}
