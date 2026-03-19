package com.bytedance.embedapplog;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class sy extends jh {
    @Override // com.bytedance.embedapplog.jh
    String c() {
        return "c";
    }

    sy(de deVar) {
        super(deVar);
    }

    @Override // com.bytedance.embedapplog.jh
    long d() {
        return this.d.c().h() + 21600000;
    }

    @Override // com.bytedance.embedapplog.jh
    long[] hc() {
        return v.b;
    }

    @Override // com.bytedance.embedapplog.jh
    public boolean b() throws JSONException {
        JSONObject jSONObjectD = this.d.u().d();
        if (this.d.u().mk() == 0 || jSONObjectD == null || this.d.c().h() + 21600000 > System.currentTimeMillis()) {
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("magic_tag", "ss_app_log");
        jSONObject.put("header", jSONObjectD);
        jSONObject.put("_gen_time", System.currentTimeMillis());
        JSONObject jSONObjectHc = fu.hc(fu.d(xp.d(this.d.hc(), this.d.u().d(), this.d.gb().b(), true, d.c()), fu.b), jSONObject);
        d.mk().d(!fv.d(jSONObjectHc, this.d.c().an()), jSONObjectHc);
        if (jSONObjectHc == null) {
            return false;
        }
        this.d.c().d(jSONObjectHc);
        return true;
    }
}
