package com.qq.e.comm.plugin;

import com.qq.e.comm.plugin.vg;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class ou extends c30 {
    private final String a;
    private final int b;
    private final f5 c;

    @Override // com.qq.e.comm.plugin.c30
    public String a() {
        return "preloadMiniProgram";
    }

    ou(String str, int i, f5 f5Var) {
        this.a = str;
        this.b = i;
        this.c = f5Var;
    }

    /* compiled from: A */
    class a implements Runnable {
        final /* synthetic */ ug a;
        final /* synthetic */ jm b;

        a(ug ugVar, jm jmVar) {
            this.a = ugVar;
            this.b = jmVar;
        }

        @Override // java.lang.Runnable
        public void run() throws JSONException {
            ou.this.a(this.a, this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ug ugVar, jm jmVar) throws JSONException {
        b10.a(1142000, this.c, Integer.valueOf(this.b));
        JSONObject jSONObjectD = ugVar.d();
        if (jSONObjectD == null) {
            return;
        }
        boolean z = true;
        int iA = i50.a(a(jSONObjectD), jSONObjectD.optInt("preload_type", 1));
        if (iA != 18 && iA != 19) {
            z = false;
        }
        b10.a(1142001, this.c, Integer.valueOf(this.b), Integer.valueOf(z ? 0 : iA), null);
        JSONObject jSONObject = new JSONObject();
        if (z) {
            iA = 0;
        }
        try {
            jSONObject.putOpt("code", Integer.valueOf(iA));
        } catch (JSONException e) {
            e.getMessage();
        }
        jmVar.b().a(new vg(ugVar, vg.a.OK, jSONObject));
    }

    @Override // com.qq.e.comm.plugin.c30
    public void a(jm jmVar, ug ugVar) {
        qg.b.submit(new a(ugVar, jmVar));
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
