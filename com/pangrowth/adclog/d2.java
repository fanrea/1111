package com.pangrowth.adclog;

import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class d2 extends r1 {
    public l1 b;

    @Override // com.pangrowth.adclog.r1
    public String b() {
        return "patch";
    }

    @Override // com.pangrowth.adclog.r1
    public boolean b(p1 p1Var) {
        JSONObject jSONObject = new JSONObject(p1Var.a);
        if (this.b == null) {
            return false;
        }
        if (a(jSONObject, p1Var)) {
            return true;
        }
        this.b.a(jSONObject.optString("url"), jSONObject.optString(TKDownloadReason.KSAD_TK_MD5));
        q1 q1VarA = this.b.a();
        if (q1VarA.a) {
            c(p1Var);
        } else {
            a(q1VarA.b, q1VarA.c, p1Var);
        }
        return true;
    }
}
