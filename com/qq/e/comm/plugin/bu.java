package com.qq.e.comm.plugin;

import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class bu extends x4 {
    bu() {
    }

    Object a(String str, String str2) {
        JSONObject jSONObjectOptJSONObject = this.a.optJSONObject(str2);
        if (jSONObjectOptJSONObject != null) {
            return jSONObjectOptJSONObject.opt(str);
        }
        return null;
    }

    bu(String str) {
        super(str);
    }
}
