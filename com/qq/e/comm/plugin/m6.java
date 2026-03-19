package com.qq.e.comm.plugin;

import android.text.TextUtils;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class m6 {
    public final int a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final Integer h;

    public boolean a() {
        return (this.h == null && TextUtils.isEmpty(this.g)) ? false : true;
    }

    public m6(int i) {
        this(i, null, null);
    }

    public m6(int i, String str, String str2) {
        this(i, str, str2, str2, str2, null, null);
    }

    public m6(int i, String str, String str2, String str3, String str4, String str5, Integer num) {
        this.a = i;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = str4;
        this.f = null;
        this.g = str5;
        this.h = num;
    }

    public m6(int i, JSONObject jSONObject) {
        jSONObject = jSONObject == null ? new JSONObject() : jSONObject;
        this.a = i;
        this.b = jSONObject.optString("clickid");
        String strOptString = jSONObject.optString("dstlink");
        this.c = strOptString;
        this.d = strOptString;
        this.e = strOptString;
        this.f = jSONObject.optString("fmcphone");
        this.g = jSONObject.optString("wx_scheme_dstlink");
        if (jSONObject.has("wx_scheme_error")) {
            this.h = Integer.valueOf(jSONObject.optInt("wx_scheme_error"));
        } else {
            this.h = null;
        }
    }
}
