package com.baidu.mobstat.forbes;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class j {
    private String a;
    private long b;
    private long c;
    private boolean d;
    private long e;

    public j(String str, long j, long j2, long j3, boolean z) {
        this.a = str;
        this.b = j;
        this.c = j2;
        this.e = j3;
        this.d = z;
    }

    public void a(long j) {
        this.c = j;
    }

    public String a() {
        return this.a;
    }

    public long b() {
        return this.b;
    }

    public long c() {
        return this.c;
    }

    public boolean d() {
        return this.d;
    }

    public long e() {
        return this.e;
    }

    public void b(long j) {
        this.e = j;
    }

    public JSONObject a(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", str);
            jSONObject.put("s", this.b);
            jSONObject.put("e", this.c);
            jSONObject.put("user", this.d ? 1 : 0);
            return jSONObject;
        } catch (Exception e) {
            return null;
        }
    }
}
