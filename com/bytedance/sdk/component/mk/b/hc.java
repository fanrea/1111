package com.bytedance.sdk.component.mk.b;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public enum hc {
    INSTANCE;

    private Map<String, b> hc = new HashMap();

    hc() {
    }

    public b d(String str) {
        return this.hc.get(str);
    }

    public void d(JSONObject jSONObject) throws JSONException {
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                String next = itKeys.next();
                jSONObject2.putOpt(next, jSONObject.opt(next));
                b bVar = new b(jSONObject2);
                this.hc.put(bVar.hc(), bVar);
            } catch (JSONException unused) {
            }
        }
    }
}
