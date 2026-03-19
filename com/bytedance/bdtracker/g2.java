package com.bytedance.bdtracker;

import android.content.Context;
import android.telephony.TelephonyManager;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class g2 extends l1 {
    public final Context e;

    public g2(Context context) {
        super(true, false);
        this.e = context;
    }

    @Override // com.bytedance.bdtracker.l1
    public String a() {
        return "SimCountry";
    }

    @Override // com.bytedance.bdtracker.l1
    public boolean a(JSONObject jSONObject) {
        TelephonyManager telephonyManager = (TelephonyManager) this.e.getSystemService("phone");
        if (telephonyManager == null) {
            return true;
        }
        s1.a(jSONObject, "sim_region", telephonyManager.getSimCountryIso());
        return true;
    }
}
