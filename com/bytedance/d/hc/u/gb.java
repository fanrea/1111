package com.bytedance.d.hc.u;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class gb {
    private SharedPreferences d;

    public gb(Context context) {
        this.d = com.bytedance.sdk.openadsdk.api.plugin.hc.hc(context, "npth", 0);
    }

    public void d(String str) {
        this.d.edit().putString(com.baidu.mobads.upgrade.remote.gray.c.l, str).apply();
    }

    public String d() {
        String strU = com.bytedance.d.hc.gb.d().u();
        return (TextUtils.isEmpty(strU) || "0".equals(strU)) ? this.d.getString(com.baidu.mobads.upgrade.remote.gray.c.l, "0") : strU;
    }
}
