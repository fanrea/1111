package com.bytedance.embedapplog;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class he extends zw {
    private final fs an;
    private final Context u;

    he(Context context, fs fsVar) {
        super(true, false);
        this.u = context;
        this.an = fsVar;
    }

    @Override // com.bytedance.embedapplog.zw
    protected boolean d(JSONObject jSONObject) throws JSONException {
        if (!TextUtils.isEmpty(this.an.ba())) {
            jSONObject.put("ab_client", this.an.ba());
        }
        if (!TextUtils.isEmpty(this.an.rf())) {
            if (um.hc) {
                um.d("init config has abversion:" + this.an.rf(), null);
            }
            jSONObject.put("ab_version", this.an.rf());
        }
        if (!TextUtils.isEmpty(this.an.mt())) {
            jSONObject.put("ab_group", this.an.mt());
        }
        if (TextUtils.isEmpty(this.an.r())) {
            return true;
        }
        jSONObject.put("ab_feature", this.an.r());
        return true;
    }
}
