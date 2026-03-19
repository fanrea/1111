package com.pangrowth.adclog;

import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class e2 extends r1 {
    public m1 b;

    @Override // com.pangrowth.adclog.r1
    public String b() {
        return "plugin";
    }

    @Override // com.pangrowth.adclog.r1
    public boolean b(p1 p1Var) {
        JSONObject jSONObject = new JSONObject(p1Var.a);
        if (this.b == null) {
            return false;
        }
        this.b.a(jSONObject.optString("packageName"), jSONObject.optInt("versionCode"), jSONObject.optString("url"), jSONObject.optString(TKDownloadReason.KSAD_TK_MD5), jSONObject.optBoolean("wifiOnly", false));
        q1 q1VarA = this.b.a();
        if (q1VarA.a) {
            c(p1Var);
            return true;
        }
        a(q1VarA.b, q1VarA.c, p1Var);
        return true;
    }
}
