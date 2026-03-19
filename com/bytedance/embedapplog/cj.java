package com.bytedance.embedapplog;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
final class cj {
    private final SharedPreferences d;

    cj(Context context) {
        this.d = com.bytedance.sdk.openadsdk.api.plugin.hc.hc(context, "device_register_oaid_refine", 0);
    }

    void d(jm jmVar) {
        if (jmVar == null) {
            return;
        }
        this.d.edit().putString("oaid", jmVar.hc().toString()).apply();
    }

    jm d() {
        return jm.d(this.d.getString("oaid", ""));
    }
}
