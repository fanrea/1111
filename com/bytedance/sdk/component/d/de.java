package com.bytedance.sdk.component.d;

import android.text.TextUtils;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class de {
    private final mk b;
    private final Set<d> c;
    private final Collection<String> d;
    private final Map<String, sy> hc;

    interface d {
    }

    sy d(String str) {
        if (!this.d.contains(str) && !TextUtils.equals(str, "host")) {
            throw new IllegalArgumentException("Namespace: " + str + " not registered.");
        }
        return d(str, null);
    }

    void d(d dVar) {
        this.c.add(dVar);
    }

    void hc(d dVar) {
        this.c.remove(dVar);
    }

    private sy d(String str, JSONObject jSONObject) throws JSONException {
        sy syVar = this.hc.get(str);
        if (syVar == null) {
            sy syVar2 = new sy(str, this.b.b(), this.b.d(), this.b.hc(), jSONObject);
            this.hc.put(str, syVar2);
            return syVar2;
        }
        if (jSONObject == null) {
            return syVar;
        }
        syVar.update(jSONObject);
        return syVar;
    }
}
