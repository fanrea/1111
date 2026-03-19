package com.ss.android.downloadlib.addownload.hc;

import com.bytedance.sdk.component.utils.mq;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class gb {
    private static volatile gb d;

    private gb() {
    }

    public static gb d() {
        if (d == null) {
            synchronized (c.class) {
                if (d == null) {
                    d = new gb();
                }
            }
        }
        return d;
    }

    public void d(int i, int i2, com.ss.android.hc.d.hc.hc hcVar) {
        if (hcVar == null) {
            return;
        }
        com.ss.android.socialbase.downloader.uo.d dVarD = com.ss.android.socialbase.downloader.uo.d.d(hcVar.rf());
        if (dVarD.d("report_api_hijack", 0) == 0) {
            return;
        }
        int i3 = i2 - i;
        if (i <= 0 || i3 <= dVarD.d("check_api_hijack_version_code_diff", 500)) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("version_code_diff", i3);
            jSONObject.put("installed_version_code", i2);
            jSONObject.put("hijack_type", 1);
        } catch (JSONException e) {
            mq.d(e);
        }
        com.ss.android.downloadlib.c.d.d().hc("api_hijack", jSONObject, hcVar);
    }
}
