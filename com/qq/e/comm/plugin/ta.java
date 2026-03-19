package com.qq.e.comm.plugin;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class ta extends x4 {
    private Map<String, JSONObject> b = new ConcurrentHashMap();

    ta() {
    }

    Object a(String str, String str2) {
        JSONObject jSONObject = this.b.get(str2);
        if (jSONObject != null) {
            return jSONObject.opt(str);
        }
        return null;
    }

    Object a(String str) {
        return this.b.get(str);
    }

    void a(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            this.b.remove(str);
        } else {
            this.b.put(str, jSONObject);
        }
    }
}
