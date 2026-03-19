package com.bytedance.embedapplog;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class rf extends jh {
    private long hc;

    @Override // com.bytedance.embedapplog.jh
    String c() {
        return "ab";
    }

    rf(de deVar) {
        super(deVar);
    }

    @Override // com.bytedance.embedapplog.jh
    long d() {
        long jYo = this.d.c().yo();
        if (jYo < 600000) {
            jYo = 600000;
        }
        return this.hc + jYo;
    }

    @Override // com.bytedance.embedapplog.jh
    long[] hc() {
        return v.b;
    }

    @Override // com.bytedance.embedapplog.jh
    boolean b() throws JSONException {
        JSONObject jSONObjectD = this.d.u().d();
        if (this.d.u().mk() == 0 || jSONObjectD == null) {
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("header", this.d.u().d());
        jSONObject.put("magic_tag", "ss_app_log");
        jSONObject.put("_gen_time", jCurrentTimeMillis);
        JSONObject jSONObjectB = fu.b(fu.d(xp.d(this.d.hc(), this.d.u().d(), this.d.gb().c(), true, d.c()), fu.b), jSONObject);
        if (jSONObjectB == null) {
            return false;
        }
        d.mk().hc(!fv.d(d.an(), jSONObjectB), jSONObjectB);
        if (um.hc) {
            um.d("getAbConfig ".concat(String.valueOf(jSONObjectB)), null);
        }
        this.d.u().d(jSONObjectB);
        this.hc = jCurrentTimeMillis;
        return true;
    }
}
