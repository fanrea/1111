package com.bytedance.sdk.component.d;

import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class e {
    private final Map<String, Object> d = new ConcurrentHashMap();

    public static e d() {
        return new e();
    }

    private e() {
    }

    public e d(String str, Object obj) {
        if (!TextUtils.isEmpty(str) && obj != null) {
            this.d.put(str, obj);
        }
        return this;
    }

    public String hc() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, Object> entry : this.d.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            return jSONObject.toString();
        } catch (JSONException unused) {
            return "";
        }
    }
}
