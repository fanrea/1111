package com.bytedance.embedapplog;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class v extends jh {
    private boolean u;
    static final long[] hc = {920000};
    static final long[] b = {920000};
    private static final long[] c = {ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, 20000, 20000, 60000, 6000, 180000, 180000, 540000, 540000};

    @Override // com.bytedance.embedapplog.jh
    String c() {
        return com.kuaishou.weapon.p0.t.k;
    }

    v(de deVar) {
        super(deVar);
        this.u = true;
    }

    @Override // com.bytedance.embedapplog.jh
    long d() {
        return this.d.u().mq() + (this.d.h().b() ? 21600000 : 43200000);
    }

    @Override // com.bytedance.embedapplog.jh
    long[] hc() {
        int iMk = this.d.u().mk();
        if (iMk == 0) {
            return c;
        }
        if (iMk == 1) {
            return b;
        }
        if (iMk == 2) {
            return hc;
        }
        um.hc((Throwable) null);
        return b;
    }

    @Override // com.bytedance.embedapplog.jh
    boolean b() throws JSONException {
        JSONObject jSONObjectD;
        JSONObject jSONObject = new JSONObject();
        ba baVarU = this.d.u();
        JSONObject jSONObjectD2 = baVarU.d();
        if (jSONObjectD2 != null) {
            jSONObject.put("magic_tag", "ss_app_log");
            synchronized (baVarU) {
                jSONObjectD = fv.d(jSONObjectD2);
            }
            jSONObject.put("header", jSONObjectD);
            jSONObject.put("_gen_time", System.currentTimeMillis());
            if (!TextUtils.isEmpty(jSONObjectD.optString(com.baidu.mobads.upgrade.remote.gray.c.l)) && fv.c() && this.u) {
                this.u = false;
                return false;
            }
            JSONObject jSONObjectD3 = fu.d(xp.d(this.d.hc(), this.d.u().d(), this.d.gb().d(), true, d.c()), jSONObject);
            if (jSONObjectD3 != null) {
                return this.d.u().d(jSONObjectD3, jSONObjectD3.optString(com.baidu.mobads.upgrade.remote.gray.c.l, ""), jSONObjectD3.optString("install_id", ""), jSONObjectD3.optString("ssid", ""));
            }
        } else {
            um.hc((Throwable) null);
        }
        return false;
    }
}
