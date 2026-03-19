package com.qq.e.comm.plugin;

import android.os.Build;
import android.util.DisplayMetrics;
import com.qq.e.comm.plugin.edgeanalytics.IEAB;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class pg implements IEAB {
    private final sb a;

    @Override // com.qq.e.comm.plugin.edgeanalytics.IEAB
    public String ge() throws JSONException {
        jn jnVarA = new jn().a("m", r1.d().c().j).a("sv", su.c()).a("ov", Build.VERSION.SDK_INT).a("os", 2).a("apd", r1.d().b().a()).a("pc", Runtime.getRuntime().availableProcessors()).a("nt", r1.d().c().p().b());
        DisplayMetrics displayMetricsL = r1.d().c().l();
        if (displayMetricsL != null) {
            jnVarA = jnVarA.a("dw", displayMetricsL.widthPixels).a("dh", displayMetricsL.heightPixels).a("ds", displayMetricsL.density);
        }
        return jnVarA.toString();
    }

    @Override // com.qq.e.comm.plugin.edgeanalytics.IEAB
    public String gexp(String str, String str2, String str3) {
        JSONObject jSONObjectA = new jn(str3).a();
        boolean z = jSONObjectA.optInt("preq") == 1;
        int iOptInt = jSONObjectA.optInt(com.baidu.mobads.container.landingpage.aq.b, -1);
        String strValueOf = iOptInt > 0 ? String.valueOf(iOptInt) : "APP";
        if (z) {
            return xc.a(str, strValueOf, "", str2);
        }
        return xc.a(str, "", str2, iOptInt > 0 ? b.c().a(iOptInt) : b.c().d());
    }

    @Override // com.qq.e.comm.plugin.edgeanalytics.IEAB
    public String gsm(String str, String str2) {
        return r1.d().f().a(str, "", str2);
    }

    @Override // com.qq.e.comm.plugin.edgeanalytics.IEAB
    public String gsmp(String str, String str2, String str3) {
        return r1.d().f().a(str, str2, str3);
    }

    @Override // com.qq.e.comm.plugin.edgeanalytics.IEAB
    public void log(String str) {
    }

    @Override // com.qq.e.comm.plugin.edgeanalytics.IEAB
    public void te(String str) {
        b10.a(new qc(str));
    }

    @Override // com.qq.e.comm.plugin.edgeanalytics.IEAB
    public void tp(String str) {
        b10.a(new wt(str));
    }

    pg(rb rbVar) {
        this.a = new sb(rbVar);
    }

    @Override // com.qq.e.comm.plugin.edgeanalytics.IEAB
    public String q(String str) {
        return this.a.c(str).toString();
    }

    @Override // com.qq.e.comm.plugin.edgeanalytics.IEAB
    public String it(String str, String str2) {
        return String.valueOf(this.a.b(str, str2));
    }

    @Override // com.qq.e.comm.plugin.edgeanalytics.IEAB
    public String del(String str, String str2) {
        return String.valueOf(this.a.a(str, str2));
    }

    @Override // com.qq.e.comm.plugin.edgeanalytics.IEAB
    public String sql(String str) {
        return String.valueOf(this.a.a(str));
    }

    @Override // com.qq.e.comm.plugin.edgeanalytics.IEAB
    public String oc(String str, String str2, String str3) {
        return this.a.a(str, str2, new jn(str3).a());
    }

    @Override // com.qq.e.comm.plugin.edgeanalytics.IEAB
    public String gr(String str, String str2, String str3) {
        JSONObject jSONObjectB = this.a.b(str);
        return jSONObjectB == null ? str2 : jSONObjectB.toString();
    }
}
