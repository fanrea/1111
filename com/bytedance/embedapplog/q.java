package com.bytedance.embedapplog;

import android.content.SharedPreferences;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class q extends zw {
    private final fs u;

    q(fs fsVar) {
        super(true, false, false);
        this.u = fsVar;
    }

    @Override // com.bytedance.embedapplog.zw
    protected boolean d(JSONObject jSONObject) throws JSONException {
        SharedPreferences sharedPreferencesC = this.u.c();
        String string = sharedPreferencesC.getString("install_id", null);
        String string2 = sharedPreferencesC.getString(com.baidu.mobads.upgrade.remote.gray.c.l, null);
        String string3 = sharedPreferencesC.getString("ssid", null);
        ba.d(jSONObject, "install_id", string);
        ba.d(jSONObject, com.baidu.mobads.upgrade.remote.gray.c.l, string2);
        ba.d(jSONObject, "ssid", string3);
        long j = 0;
        long j2 = sharedPreferencesC.getLong("register_time", 0L);
        if ((ba.hc(string) && ba.hc(string2)) || j2 == 0) {
            j = j2;
        } else {
            sharedPreferencesC.edit().putLong("register_time", 0L).apply();
        }
        jSONObject.put("register_time", j);
        return true;
    }
}
