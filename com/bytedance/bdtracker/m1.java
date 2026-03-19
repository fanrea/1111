package com.bytedance.bdtracker;

import android.os.Build;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class m1 extends l1 {
    public final q1 e;
    public final d f;

    public m1(d dVar, q1 q1Var) {
        super(true, false);
        this.f = dVar;
        this.e = q1Var;
    }

    @Override // com.bytedance.bdtracker.l1
    public String a() {
        return "Build";
    }

    @Override // com.bytedance.bdtracker.l1
    public boolean a(JSONObject jSONObject) throws JSONException {
        jSONObject.put("platform", "Android");
        jSONObject.put("sdk_lib", "Android");
        jSONObject.put("device_model", Build.MODEL);
        jSONObject.put("device_brand", Build.BRAND);
        jSONObject.put("device_manufacturer", Build.MANUFACTURER);
        jSONObject.put("cpu_abi", Build.CPU_ABI);
        jSONObject.put("sdk_target_version", 29);
        jSONObject.put("git_hash", "6b876f5");
        if (!y4.c.b(new Object[0]).booleanValue() || !this.e.c.isHarmonyEnabled()) {
            jSONObject.put("os", "Android");
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            jSONObject.put("os_version", Build.VERSION.RELEASE);
            return true;
        }
        jSONObject.put("os", "Harmony");
        try {
            jSONObject.put("os_api", a5.a("hw_sc.build.os.apiversion"));
            jSONObject.put("os_version", a5.a(com.alipay.sdk.m.c.a.b));
            return true;
        } catch (Throwable th) {
            this.f.D.error("loadHarmonyInfo failed", th, new Object[0]);
            return true;
        }
    }
}
