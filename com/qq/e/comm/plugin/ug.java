package com.qq.e.comm.plugin;

import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class ug {
    private final String a;
    private final String b;
    private final String c;
    private final JSONObject d;
    private final String e;
    private final long f;

    public String toString() {
        return "GDTJsRequest [service=" + this.a + ", action=" + this.b + ", callbackId=" + this.c + ", paraObj=" + this.d + ", multiActionPara:" + this.e + ",timeStamp:" + this.f + "]";
    }

    public ug(String str) {
        this(null, null, str, null);
    }

    public ug(String str, String str2, String str3, JSONObject jSONObject) {
        this(str, str2, str3, jSONObject, null, System.currentTimeMillis());
    }

    public String e() {
        return this.a;
    }

    public String a() {
        return this.b;
    }

    public String b() {
        return this.c;
    }

    public JSONObject d() {
        return this.d;
    }

    public String c() {
        return this.e;
    }

    public long f() {
        return this.f;
    }

    public ug(String str, String str2, String str3, JSONObject jSONObject, long j) {
        this(str, str2, str3, jSONObject, null, j);
    }

    public ug(String str, String str2, String str3, JSONObject jSONObject, String str4, long j) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = jSONObject;
        this.e = str4;
        this.f = j;
    }
}
