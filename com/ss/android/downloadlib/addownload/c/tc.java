package com.ss.android.downloadlib.addownload.c;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class tc implements tt {
    @Override // com.ss.android.downloadlib.addownload.c.tt
    public boolean d(com.ss.android.hc.d.hc.hc hcVar, int i, gb gbVar) throws JSONException {
        if (hcVar == null || !hc(hcVar.rf())) {
            return false;
        }
        if (System.currentTimeMillis() - hcVar.yn() > d(hcVar.rf())) {
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("pause_optimise_type", "mistake_click");
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.mq.d(e);
        }
        com.ss.android.downloadlib.c.d.d().d("pause_optimise", jSONObject, hcVar);
        return true;
    }

    private long d(int i) {
        return com.ss.android.socialbase.downloader.uo.d.d(i).d("pause_optimise_mistake_click_interval", 300);
    }

    private boolean hc(int i) {
        return com.ss.android.socialbase.downloader.uo.d.d(i).d("pause_optimise_mistake_click_interval_switch", 0) == 1;
    }
}
