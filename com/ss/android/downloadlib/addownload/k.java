package com.ss.android.downloadlib.addownload;

import com.ss.android.socialbase.downloader.downloader.rf;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class k implements rf {
    @Override // com.ss.android.socialbase.downloader.downloader.rf
    public void d(com.ss.android.socialbase.downloader.h.b bVar, int i, int i2) throws JSONException {
        com.ss.android.hc.d.hc.hc hcVarD = com.ss.android.downloadlib.addownload.hc.an.d().d(bVar);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("reserve_wifi_source", Integer.valueOf(i2));
            jSONObject.putOpt("reserve_wifi_status", Integer.valueOf(i));
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.mq.d(e);
        }
        com.ss.android.downloadlib.c.d.d().d("pause_reserve_wifi", jSONObject, hcVarD);
    }
}
