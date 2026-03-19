package com.qq.e.comm.plugin;

import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class sa extends x4 {
    private static final JSONObject b = new JSONObject();

    sa() {
    }

    Object a(String str) {
        return this.a.opt(str);
    }

    void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.a = jSONObject;
        } else {
            this.a = b;
        }
    }
}
