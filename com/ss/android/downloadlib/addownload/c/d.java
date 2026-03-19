package com.ss.android.downloadlib.addownload.c;

import android.text.TextUtils;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.downloadlib.h.uo;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class d implements tt {
    private static com.ss.android.downloadlib.addownload.d.c d;

    public static com.ss.android.downloadlib.addownload.d.c d() {
        return d;
    }

    @Override // com.ss.android.downloadlib.addownload.c.tt
    public boolean d(final com.ss.android.hc.d.hc.hc hcVar, int i, final gb gbVar) {
        com.ss.android.socialbase.downloader.h.b bVarHc;
        if (hcVar == null || hcVar.dz() || !d(hcVar)) {
            return false;
        }
        if (!TextUtils.isEmpty(hcVar.ey())) {
            bVarHc = com.ss.android.downloadlib.tc.d(com.ss.android.downloadlib.addownload.mq.getContext()).d(hcVar.ey(), null, true);
        } else {
            bVarHc = com.ss.android.downloadlib.tc.d(com.ss.android.downloadlib.addownload.mq.getContext()).hc(hcVar.d());
        }
        if (bVarHc == null) {
            return false;
        }
        long jD = com.ss.android.downloadlib.addownload.tc.d(bVarHc.h(), bVarHc.js(), bVarHc.mb());
        long jMb = bVarHc.mb();
        if (jD <= 0 || jMb <= 0 || jMb > d(hcVar.rf())) {
            return false;
        }
        d = new com.ss.android.downloadlib.addownload.d.c() { // from class: com.ss.android.downloadlib.addownload.c.d.1
            @Override // com.ss.android.downloadlib.addownload.d.c
            public void d() throws JSONException {
                com.ss.android.downloadlib.addownload.d.c unused = d.d = null;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("pause_optimise_type", "apk_size");
                    jSONObject.putOpt("pause_optimise_action", "confirm");
                } catch (JSONException e) {
                    com.bytedance.sdk.component.utils.mq.d(e);
                }
                com.ss.android.downloadlib.c.d.d().d("pause_optimise", jSONObject, hcVar);
            }

            @Override // com.ss.android.downloadlib.addownload.d.c
            public void hc() throws JSONException {
                com.ss.android.downloadlib.addownload.d.c unused = d.d = null;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("pause_optimise_type", "apk_size");
                    jSONObject.putOpt("pause_optimise_action", "cancel");
                } catch (JSONException e) {
                    com.bytedance.sdk.component.utils.mq.d(e);
                }
                com.ss.android.downloadlib.c.d.d().d("pause_optimise", jSONObject, hcVar);
                gbVar.d(hcVar);
            }
        };
        TTDelegateActivity.d(hcVar, String.format("该下载任务仅需%s，即将下载完成，是否继续下载？", uo.d(jMb - jD)), "继续", "暂停");
        hcVar.k(true);
        return true;
    }

    private int d(int i) {
        return com.ss.android.socialbase.downloader.uo.d.d(i).d("pause_optimise_apk_size", 100) * 1024 * 1024;
    }

    private boolean d(com.ss.android.hc.d.hc.d dVar) {
        return com.ss.android.downloadlib.h.u.d(dVar).d("pause_optimise_apk_size_switch", 0) == 1 && dVar.w();
    }
}
