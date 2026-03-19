package com.qq.e.comm.plugin;

import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class e {
    private final g a;
    private final JSONObject b;

    public String toString() {
        return "event<" + this.a + "," + this.b + ">";
    }

    public e(g gVar, JSONObject jSONObject) {
        this.a = gVar;
        this.b = jSONObject;
    }

    public static e a(String str, JSONObject jSONObject) {
        g gVarA = g.a(str);
        if (gVarA == null) {
            return null;
        }
        return new e(gVarA, jSONObject);
    }

    public g a() {
        return this.a;
    }
}
