package com.bytedance.bdtracker;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.bdtracker.l0;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class e2 extends l1 {
    public final q1 e;

    public e2(Context context, q1 q1Var, s1 s1Var) {
        super(true, false, false);
        this.e = q1Var;
    }

    @Override // com.bytedance.bdtracker.l1
    public String a() {
        return "ServerId";
    }

    @Override // com.bytedance.bdtracker.l1
    public boolean a(JSONObject jSONObject) throws JSONException {
        SharedPreferences sharedPreferences = this.e.f;
        String string = sharedPreferences.getString(com.baidu.mobads.upgrade.remote.gray.c.l, null);
        s1.a(jSONObject, com.baidu.mobads.upgrade.remote.gray.c.l, string);
        String string2 = sharedPreferences.getString("bd_did", null);
        s1.a(jSONObject, "bd_did", string2);
        String string3 = sharedPreferences.getString("install_id", null);
        String string4 = sharedPreferences.getString(this.e.e(), null);
        s1.a(jSONObject, "install_id", string3);
        s1.a(jSONObject, "ssid", string4);
        long j = 0;
        long j2 = sharedPreferences.getLong("register_time", 0L);
        if ((l0.b.a(string3) && ((l0.b.a(string) || l0.b.a(string2)) && l0.b.a(string4))) || j2 == 0) {
            j = j2;
        } else {
            this.e.f.edit().putLong("register_time", 0L).apply();
        }
        jSONObject.put("register_time", j);
        return true;
    }
}
