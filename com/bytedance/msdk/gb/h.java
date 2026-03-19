package com.bytedance.msdk.gb;

import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class h {
    public static JSONObject d() throws JSONException {
        Map<String, com.bytedance.msdk.d.d.c> mapHc = com.bytedance.msdk.an.hc.hc.d().hc();
        if (mapHc == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, com.bytedance.msdk.d.d.c> entry : mapHc.entrySet()) {
            if (entry.getKey() != null) {
                String[] strArrSplit = entry.getKey().split("\\.");
                if (strArrSplit.length >= 5) {
                    try {
                        jSONObject.put(strArrSplit[4] + "Adapter", entry.getValue().d());
                    } catch (JSONException e) {
                        com.bytedance.sdk.component.utils.mq.d(e);
                    }
                }
            }
        }
        return jSONObject;
    }
}
