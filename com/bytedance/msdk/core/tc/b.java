package com.bytedance.msdk.core.tc;

import android.text.TextUtils;
import com.alipay.sdk.m.t.a;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class b {
    private double an;
    private String b;
    private int c;
    private String d;
    private double h;
    private String hc;
    private String u;

    public b(String str, String str2, String str3, int i, String str4, double d, double d2) {
        this.d = str;
        this.hc = str2;
        this.b = str3;
        this.c = i;
        this.u = str4;
        this.an = d;
        this.h = d2;
    }

    public String d() {
        return this.hc;
    }

    public String hc() {
        return this.b;
    }

    public int b() {
        return this.c;
    }

    public String c() {
        return this.u;
    }

    public double u() {
        return this.an;
    }

    public double an() {
        return this.h;
    }

    public static b d(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str) || jSONObject == null) {
            return null;
        }
        return new b(str, jSONObject.optString("label_name"), jSONObject.optString(a.k), jSONObject.optInt("label_id"), jSONObject.optString("label_version"), jSONObject.optDouble("upper_bound"), jSONObject.optDouble("lower_bound"));
    }
}
