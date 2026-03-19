package com.ss.android.downloadlib.addownload.c;

import android.text.TextUtils;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.downloadlib.h.uo;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class b implements h {
    private static com.ss.android.downloadlib.addownload.d.c d;
    private static com.ss.android.downloadlib.addownload.d.b hc;

    public static com.ss.android.downloadlib.addownload.d.c d() {
        return d;
    }

    public static com.ss.android.downloadlib.addownload.d.b hc() {
        return hc;
    }

    public static void d(com.ss.android.downloadlib.addownload.d.b bVar) {
        hc = bVar;
    }

    @Override // com.ss.android.downloadlib.addownload.c.h
    public boolean d(final com.ss.android.hc.d.hc.hc hcVar, int i, final gb gbVar, final com.ss.android.downloadlib.addownload.d.b bVar) {
        com.ss.android.socialbase.downloader.h.b bVarHc;
        String str;
        if (hcVar == null || !d(hcVar)) {
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
        long jJs = bVarHc.js();
        long jMb = bVarHc.mb();
        if (jJs < 0 || jMb <= 0) {
            return false;
        }
        final int iD = com.ss.android.downloadlib.addownload.tc.d(bVarHc.h(), (int) ((100 * jJs) / jMb));
        final int i2 = (int) (jJs / 1048576);
        boolean z = iD > d(hcVar.rf());
        d = new com.ss.android.downloadlib.addownload.d.c() { // from class: com.ss.android.downloadlib.addownload.c.b.1
            @Override // com.ss.android.downloadlib.addownload.d.c
            public void d() throws JSONException {
                com.ss.android.downloadlib.addownload.d.c unused = b.d = null;
                b.this.d(iD, i2, i2, hcVar, "download_percent_cancel", "confirm");
            }

            @Override // com.ss.android.downloadlib.addownload.d.c
            public void hc() throws JSONException {
                com.ss.android.downloadlib.addownload.d.c unused = b.d = null;
                b.this.d(iD, i2, i2, hcVar, "download_percent_cancel", "cancel");
                gbVar.d(hcVar);
            }
        };
        String strD = uo.d(com.ss.android.downloadlib.addownload.tc.d(hcVar.rf(), jJs, jMb));
        if (z) {
            str = String.format("该任务已下载%s，仅需%s即可下载完成，是否继续？", strD, uo.d(jMb - jJs));
        } else {
            str = String.format("该任务已下载%s，即将下载完成，是否继续下载？", strD);
        }
        String str2 = str;
        if (bVar != null) {
            d(new com.ss.android.downloadlib.addownload.d.b() { // from class: com.ss.android.downloadlib.addownload.c.b.2
                @Override // com.ss.android.downloadlib.addownload.d.b
                public void delete() throws JSONException {
                    com.ss.android.downloadlib.addownload.d.c unused = b.d = null;
                    b.this.d(iD, i2, i2, hcVar, "download_percent_cancel", "delete");
                    bVar.delete();
                }
            });
        }
        TTDelegateActivity.hc(hcVar, str2, "继续", "暂停", "删除");
        return true;
    }

    private int d(int i) {
        return com.ss.android.socialbase.downloader.uo.d.d(i).d("cancel_pause_optimise_download_percent_value", 50);
    }

    private boolean d(com.ss.android.hc.d.hc.d dVar) {
        return com.ss.android.downloadlib.h.u.d(dVar).d("cancel_pause_optimise_download_percent_retain_switch", 0) == 1 && dVar.w();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i, int i2, int i3, com.ss.android.hc.d.hc.hc hcVar, String str, String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("pause_optimise_type", str);
            jSONObject.putOpt("pause_optimise_action", str2);
            jSONObject.putOpt("download_percent", Integer.valueOf(i));
            jSONObject.putOpt("download_current_bytes", Integer.valueOf(i2));
            jSONObject.putOpt("download_total_bytes", Integer.valueOf(i3));
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.mq.d(e);
        }
        com.ss.android.downloadlib.c.d.d().d("pause_cancel_optimise", jSONObject, hcVar);
    }
}
