package com.apm.insight.n;

import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class p {
    private final int a;
    private String b;
    private JSONObject c;
    private byte[] d;

    public p(int i) {
        this.a = i;
    }

    public p(int i, Throwable th) {
        this.a = i;
        if (th != null) {
            this.b = th.getMessage();
        }
    }

    public p(int i, JSONObject jSONObject) {
        this.a = i;
        this.c = jSONObject;
    }

    public p(int i, byte[] bArr) {
        this.a = i;
        this.d = bArr;
    }

    public boolean a() {
        return this.a != 207;
    }

    public byte[] b() {
        return this.d;
    }
}
