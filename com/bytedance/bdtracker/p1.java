package com.bytedance.bdtracker;

import android.content.Context;
import android.text.TextUtils;
import io.reactivex.annotations.SchedulerSupport;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class p1 extends l1 {
    public final d e;
    public final q1 f;

    public p1(d dVar, Context context, q1 q1Var) {
        super(false, false);
        this.e = dVar;
        this.f = q1Var;
    }

    @Override // com.bytedance.bdtracker.l1
    public String a() {
        return "Config";
    }

    @Override // com.bytedance.bdtracker.l1
    public boolean a(JSONObject jSONObject) throws JSONException {
        jSONObject.put("sdk_version", 6150590);
        jSONObject.put("sdk_version_code", 16150189);
        jSONObject.put("sdk_version_name", "6.15.5");
        jSONObject.put("channel", this.f.b());
        jSONObject.put("not_request_sender", this.f.c.getNotReuqestSender() ? 1 : 0);
        s1.a(jSONObject, "aid", this.f.c.getAid());
        s1.a(jSONObject, "release_build", this.f.c.getReleaseBuild());
        s1.a(jSONObject, com.alipay.sdk.m.l.b.b, this.f.f.getString(com.alipay.sdk.m.l.b.b, null));
        s1.a(jSONObject, "ab_sdk_version", this.f.d.getString("ab_sdk_version", ""));
        String language = this.f.c.getLanguage();
        if (TextUtils.isEmpty(language)) {
            language = this.f.f.getString("app_language", null);
        }
        s1.a(jSONObject, "app_language", language);
        String region = this.f.c.getRegion();
        if (TextUtils.isEmpty(region)) {
            region = this.f.f.getString("app_region", null);
        }
        s1.a(jSONObject, "app_region", region);
        String string = this.f.d.getString("app_track", null);
        if (!TextUtils.isEmpty(string)) {
            try {
                jSONObject.put("app_track", new JSONObject(string));
            } catch (Throwable th) {
                this.e.D.error("JSON handle appTrack failed", th, new Object[0]);
            }
        }
        String string2 = this.f.d.getString("header_custom_info", null);
        if (string2 != null && string2.length() > 0) {
            try {
                JSONObject jSONObject2 = new JSONObject(string2);
                jSONObject2.remove("_debug_flag");
                jSONObject.put(SchedulerSupport.CUSTOM, jSONObject2);
            } catch (Throwable th2) {
                this.e.D.error("JSON handle failed", th2, new Object[0]);
            }
        }
        String strF = this.f.f();
        if (TextUtils.isEmpty(strF)) {
            return true;
        }
        s1.a(jSONObject, "user_unique_id", strF);
        return true;
    }
}
