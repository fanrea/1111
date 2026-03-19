package com.bytedance.msdk.core.tc;

import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d {
    private com.bytedance.msdk.api.c.d.hc.b.hc b;
    private String d;
    private String hc;

    public d(String str, String str2) {
        this.d = str;
        this.hc = str2;
        this.b = new com.bytedance.msdk.api.c.d.hc.b.hc();
    }

    public d(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12) {
        this.d = str2;
        this.hc = str3;
        this.b = new com.bytedance.msdk.api.c.d.hc.b.hc(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12);
    }

    public String d() {
        return this.d;
    }

    public String hc() {
        return this.hc;
    }

    public com.bytedance.msdk.api.c.d.hc.b.hc b() {
        return this.b;
    }

    public boolean c() {
        com.bytedance.msdk.api.c.d.hc.b.hc hcVar = this.b;
        return hcVar != null && hcVar.c();
    }

    public String u() {
        com.bytedance.msdk.api.c.d.hc.b.hc hcVar = this.b;
        if (hcVar != null) {
            return hcVar.hc();
        }
        return null;
    }

    public static d d(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String strOptString = jSONObject.optString(com.alipay.sdk.m.k.b.D0);
        String strOptString2 = jSONObject.optString(com.alipay.sdk.m.l.b.h);
        String strOptString3 = jSONObject.optString("custom_type");
        if (!TextUtils.equals(strOptString3, "1")) {
            return new d(strOptString, strOptString2);
        }
        return new d(str, strOptString, strOptString2, jSONObject.optString("init_class_name"), jSONObject.optString("banner_class_name"), jSONObject.optString("interstitial_class_name"), jSONObject.optString("reward_class_name"), jSONObject.optString("full_video_class_name"), jSONObject.optString("splash_class_name"), jSONObject.optString("feed_class_name"), jSONObject.optString("draw_class_name"), strOptString3);
    }

    public String toString() {
        return "AdNetworkConfValue{mAppId='" + this.d + "', mAppKey='" + this.hc + "', mGMCustomConfig=" + this.b + '}';
    }
}
