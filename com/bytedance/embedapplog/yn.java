package com.bytedance.embedapplog;

import android.content.Context;
import android.telephony.TelephonyManager;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class yn extends zw {
    private final Context u;

    yn(Context context) {
        super(true, false);
        this.u = context;
    }

    @Override // com.bytedance.embedapplog.zw
    protected boolean d(JSONObject jSONObject) throws JSONException {
        ba.d(jSONObject, "sim_region", ((TelephonyManager) this.u.getSystemService("phone")).getSimCountryIso());
        return true;
    }
}
