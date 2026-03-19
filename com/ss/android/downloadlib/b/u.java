package com.ss.android.downloadlib.b;

import com.ss.android.downloadlib.addownload.mq;
import com.ss.android.downloadlib.h.uo;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class u implements com.ss.android.socialbase.downloader.gb.b {
    @Override // com.ss.android.socialbase.downloader.gb.b
    public void d(int i, String str, JSONObject jSONObject) throws JSONException {
        com.ss.android.hc.d.hc.hc hcVarD;
        com.ss.android.socialbase.downloader.h.b bVarGb = com.ss.android.socialbase.downloader.downloader.h.hc(mq.getContext()).gb(i);
        if (bVarGb == null || (hcVarD = com.ss.android.downloadlib.addownload.hc.an.d().d(bVarGb)) == null) {
            return;
        }
        if ("install_view_result".equals(str)) {
            jSONObject = uo.d(jSONObject);
            com.ss.android.downloadlib.d.d(jSONObject, bVarGb);
            uo.d(jSONObject, "model_id", Long.valueOf(hcVarD.hc()));
        }
        com.ss.android.downloadlib.c.d.d().hc(str, jSONObject, hcVarD);
    }

    @Override // com.ss.android.socialbase.downloader.gb.b
    public void hc(int i, String str, JSONObject jSONObject) {
        com.ss.android.hc.d.hc.hc hcVarD;
        com.ss.android.socialbase.downloader.h.b bVarGb = com.ss.android.socialbase.downloader.downloader.h.hc(mq.getContext()).gb(i);
        if (bVarGb == null || (hcVarD = com.ss.android.downloadlib.addownload.hc.an.d().d(bVarGb)) == null) {
            return;
        }
        com.ss.android.downloadlib.c.d.d().d(str, jSONObject, hcVarD);
    }
}
