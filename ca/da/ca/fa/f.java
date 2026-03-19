package ca.da.ca.fa;

import android.content.Context;
import android.text.TextUtils;
import com.apm.applog.AppLog;
import io.reactivex.annotations.SchedulerSupport;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ConfigLoader.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class f extends c {
    public final Context e;
    public final g f;

    public f(Context context, g gVar) {
        super(false, false);
        this.e = context;
        this.f = gVar;
    }

    @Override // ca.da.ca.fa.c
    public boolean a(JSONObject jSONObject) throws JSONException {
        jSONObject.put("sdk_version", 10890);
        jSONObject.put("sdk_version_code", ca.da.ca.ja.r.c);
        jSONObject.put("sdk_version_name", "0.1.8");
        jSONObject.put("channel", this.f.d());
        jSONObject.put("not_request_sender", this.f.b.getNotReuqestSender() ? 1 : 0);
        h.a(jSONObject, "aid", this.f.c());
        h.a(jSONObject, "release_build", this.f.b.getReleaseBuild());
        h.a(jSONObject, com.alipay.sdk.m.l.b.b, this.f.e.getString(com.alipay.sdk.m.l.b.b, null));
        h.a(jSONObject, "ab_sdk_version", this.f.c.getString("ab_sdk_version", ""));
        String googleAid = this.f.b.getGoogleAid();
        if (AppLog.isGAIdEnabled() && TextUtils.isEmpty(googleAid)) {
            googleAid = ca.da.ca.ja.j.a(this.e, this.f);
        }
        h.a(jSONObject, "google_aid", googleAid);
        String language = this.f.b.getLanguage();
        if (TextUtils.isEmpty(language)) {
            language = this.f.e.getString("app_language", null);
        }
        h.a(jSONObject, "app_language", language);
        String region = this.f.b.getRegion();
        if (TextUtils.isEmpty(region)) {
            region = this.f.e.getString("app_region", null);
        }
        h.a(jSONObject, "app_region", region);
        String string = this.f.c.getString("app_track", null);
        if (!TextUtils.isEmpty(string)) {
            try {
                jSONObject.put("app_track", new JSONObject(string));
            } catch (Throwable th) {
                ca.da.ca.ja.r.a(th);
            }
        }
        String string2 = this.f.c.getString("header_custom_info", null);
        if (string2 != null && string2.length() > 0) {
            try {
                JSONObject jSONObject2 = new JSONObject(string2);
                jSONObject2.remove("_debug_flag");
                jSONObject.put(SchedulerSupport.CUSTOM, jSONObject2);
            } catch (Throwable th2) {
                ca.da.ca.ja.r.a(th2);
            }
        }
        String string3 = this.f.c.getString("user_unique_id", null);
        if (TextUtils.isEmpty(string3)) {
            return true;
        }
        h.a(jSONObject, "user_unique_id", string3);
        return true;
    }
}
