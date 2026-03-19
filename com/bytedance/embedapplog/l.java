package com.bytedance.embedapplog;

import android.content.Context;
import android.telephony.TelephonyManager;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class l extends zw {
    private final fs an;
    private final Context u;

    l(Context context, fs fsVar) {
        super(true, false);
        this.u = context;
        this.an = fsVar;
    }

    @Override // com.bytedance.embedapplog.zw
    protected boolean d(JSONObject jSONObject) {
        TelephonyManager telephonyManager = (TelephonyManager) this.u.getSystemService("phone");
        if (telephonyManager != null) {
            try {
                ba.d(jSONObject, "carrier", telephonyManager.getNetworkOperatorName());
                ba.d(jSONObject, "mcc_mnc", telephonyManager.getNetworkOperator());
                ba.d(jSONObject, "udid", this.an.tr() ? nf.d(telephonyManager) : this.an.bc());
                return true;
            } catch (Exception e) {
                um.hc(e);
            }
        }
        return false;
    }
}
