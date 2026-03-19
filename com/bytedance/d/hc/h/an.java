package com.bytedance.d.hc.h;

import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class an {
    private JSONObject b;
    private final int d;
    private String hc;

    public an(int i) {
        this.d = i;
    }

    public an(int i, Throwable th) {
        this.d = i;
        if (th != null) {
            this.hc = th.getMessage();
        }
    }

    public an(int i, String str) {
        this.d = i;
        this.hc = str;
    }

    public an(int i, JSONObject jSONObject) {
        this.d = i;
        this.b = jSONObject;
    }

    public boolean d() {
        return this.d == 0;
    }
}
