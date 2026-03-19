package com.bytedance.embedapplog;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.applog.util.SensitiveUtils;
import io.reactivex.annotations.SchedulerSupport;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class z extends zw {
    private final fs an;
    private final Context u;

    z(Context context, fs fsVar) {
        super(false, false);
        this.u = context;
        this.an = fsVar;
    }

    @Override // com.bytedance.embedapplog.zw
    protected boolean d(JSONObject jSONObject) throws JSONException {
        jSONObject.put("sdk_version", 336);
        jSONObject.put("sdk_version_name", "3.9.1.baseChina-rc.42");
        jSONObject.put("channel", this.an.tc());
        ba.d(jSONObject, "aid", this.an.tt());
        ba.d(jSONObject, "release_build", this.an.he());
        ba.d(jSONObject, "app_region", this.an.uo());
        ba.d(jSONObject, "app_language", this.an.mq());
        ba.d(jSONObject, com.alipay.sdk.m.l.b.b, this.an.vv());
        ba.d(jSONObject, "ab_sdk_version", this.an.e());
        ba.d(jSONObject, "ab_version", this.an.rf());
        ba.d(jSONObject, SensitiveUtils.KEY_ALIYUN_UUID, this.an.d());
        String strMk = this.an.mk();
        if (TextUtils.isEmpty(strMk)) {
            strMk = ph.d(this.u, this.an);
        }
        if (!TextUtils.isEmpty(strMk)) {
            ba.d(jSONObject, "google_aid", strMk);
        }
        String strYi = this.an.yi();
        if (!TextUtils.isEmpty(strYi)) {
            try {
                jSONObject.put("app_track", new JSONObject(strYi));
            } catch (Throwable th) {
                um.hc(th);
            }
        }
        String strK = this.an.k();
        if (strK != null && strK.length() > 0) {
            jSONObject.put(SchedulerSupport.CUSTOM, new JSONObject(strK));
        }
        ba.d(jSONObject, "user_unique_id", this.an.cb());
        return true;
    }
}
