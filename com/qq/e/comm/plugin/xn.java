package com.qq.e.comm.plugin;

import com.qq.e.comm.plugin.i50;
import com.qq.e.comm.plugin.vg;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class xn extends c30 {
    private final String a;
    private final int b;
    private final f5 c;

    @Override // com.qq.e.comm.plugin.c30
    public String a() {
        return "launchMiniProgram";
    }

    xn(String str, int i, f5 f5Var) {
        this.a = str;
        this.b = i;
        this.c = f5Var;
    }

    @Override // com.qq.e.comm.plugin.c30
    public void a(jm jmVar, ug ugVar) {
        b10.a(1142010, this.c, Integer.valueOf(this.b));
        JSONObject jSONObjectD = ugVar.d();
        if (jSONObjectD == null) {
            return;
        }
        Integer num = (Integer) i50.a(a(jSONObjectD), (i50.a) null).first;
        num.intValue();
        b10.a(1142011, this.c, Integer.valueOf(this.b), num, null);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("code", num);
        } catch (JSONException e) {
            e.getMessage();
        }
        jmVar.b().a(new vg(ugVar, vg.a.OK, jSONObject));
    }

    private JSONObject a(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt("ad_trace_data", jSONObject.optString("ad_trace_data"));
            jSONObject2.putOpt("wx_appid", this.a);
            jSONObject2.putOpt("username", jSONObject.optString("username"));
            jSONObject2.putOpt("path", jSONObject.optString("path"));
        } catch (JSONException unused) {
        }
        return jSONObject2;
    }
}
