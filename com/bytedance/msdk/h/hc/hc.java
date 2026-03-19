package com.bytedance.msdk.h.hc;

import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc {
    private static volatile hc d;

    private hc() {
    }

    public static hc d() {
        if (d == null) {
            synchronized (hc.class) {
                if (d == null) {
                    d = new hc();
                }
            }
        }
        return d;
    }

    public void d(JSONArray jSONArray) {
        if (jSONArray == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.api.plugin.hc.hc(com.bytedance.msdk.core.hc.getContext(), "tt_sdk_test_tool_data_" + com.bytedance.msdk.core.d.mk().mq(), 0).edit().putString("rit_conf", jSONArray.toString()).apply();
    }

    public void d(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.api.plugin.hc.hc(com.bytedance.msdk.core.hc.getContext(), "tt_sdk_test_tool_data_" + com.bytedance.msdk.core.d.mk().mq(), 0).edit().putString("adn_init_conf", jSONObject.toString()).apply();
    }
}
