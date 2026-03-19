package com.bytedance.sdk.component.gb.hc.an;

import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class c {
    private int an;
    private boolean b;
    private int c;
    private String d;
    private String hc;
    private JSONObject u;

    c(String str, String str2, boolean z, int i, JSONObject jSONObject, int i2) {
        this.d = str;
        this.hc = str2;
        this.b = z;
        this.c = i;
        this.u = jSONObject;
        this.an = i2;
    }

    public JSONObject d() {
        if (this.u == null) {
            this.u = new JSONObject();
        }
        return this.u;
    }

    public String hc() {
        return this.d;
    }

    public String b() {
        return this.hc;
    }

    public boolean c() {
        return this.b;
    }

    public int u() {
        return this.c;
    }

    public void d(int i) {
        this.c = i;
    }
}
