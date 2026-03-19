package com.qq.e.comm.plugin;

import android.content.Context;
import android.text.TextUtils;
import com.qq.e.comm.managers.setting.GlobalSetting;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class l2 extends p0 {
    private JSONObject c;
    private JSONObject d;

    protected String c(Context context) {
        JSONObject jSONObjectB = b();
        if (jSONObjectB != null) {
            return jSONObjectB.toString();
        }
        return null;
    }

    public synchronized void c() {
        if (r1.d().f().a("udon", 0) == 1) {
            JSONObject jSONObject = this.c;
            if (jSONObject == null) {
                String strC = r1.d().f().c("ud_salt");
                if (TextUtils.isEmpty(strC)) {
                    strC = "[{\"v\":1,\"s\":\"CB6;8PHJtpsNJwTW\"}]";
                }
                try {
                    this.c = s30.a(strC);
                } catch (Exception unused) {
                }
                qm$h$$ExternalSyntheticBackport0.m(this.c);
            } else {
                qm$h$$ExternalSyntheticBackport0.m(jSONObject);
            }
        } else {
            this.c = null;
        }
    }

    @Override // com.qq.e.comm.plugin.la
    public String b(Context context) {
        return a(context);
    }

    public JSONObject b() {
        if (!GlobalSetting.isAgreePrivacyStrategy()) {
            return null;
        }
        JSONObject jSONObject = this.c;
        c();
        if (this.d == null || jSONObject != this.c) {
            this.d = a();
        }
        return this.d;
    }

    private JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = this.c;
            if (jSONObject2 != null && jSONObject2.length() > 0) {
                jSONObject.put("uuid", this.c);
            }
        } catch (JSONException e) {
            e.getMessage();
        }
        if (jSONObject.length() <= 0) {
            return null;
        }
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject3.put("attri_info", jSONObject);
            return jSONObject3;
        } catch (JSONException e2) {
            e2.getMessage();
            return jSONObject3;
        }
    }

    @Override // com.qq.e.comm.plugin.la
    public String a(Context context) {
        if (!GlobalSetting.isAgreePrivacyStrategy()) {
            return null;
        }
        if (TextUtils.isEmpty(this.b)) {
            this.b = c(context);
        }
        return this.b;
    }
}
