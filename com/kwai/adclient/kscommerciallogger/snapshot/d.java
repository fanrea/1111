package com.kwai.adclient.kscommerciallogger.snapshot;

import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class d {
    private final String crP;
    private final LinkedHashMap<String, String> crQ = new LinkedHashMap<>();
    private final long time = System.nanoTime();

    d(String str) {
        this.crP = str;
    }

    synchronized JSONObject arB() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, String> entry : this.crQ.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            jSONObject.put("time", this.time);
            jSONObject.put("span_name", this.crP);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
