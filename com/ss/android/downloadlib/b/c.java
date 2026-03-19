package com.ss.android.downloadlib.b;

import com.kwai.player.qos.KwaiQosInfo;
import com.ss.android.downloadlib.addownload.hc.tt;
import com.ss.android.downloadlib.h.uo;
import com.ss.android.socialbase.downloader.c.mq;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class c implements com.ss.android.socialbase.appdownloader.b.gb, mq {
    @Override // com.ss.android.socialbase.appdownloader.b.gb
    public void d(com.ss.android.socialbase.downloader.h.b bVar, boolean z) {
        if (bVar == null) {
            return;
        }
        d(bVar, bVar.v(), z);
    }

    public void d(com.ss.android.socialbase.downloader.h.b bVar, int i, boolean z) {
        com.ss.android.downloadlib.addownload.hc.an.d().hc();
        com.ss.android.hc.d.hc.hc hcVarD = com.ss.android.downloadlib.addownload.hc.an.d().d(bVar);
        if (hcVarD == null) {
            return;
        }
        try {
            if (z) {
                hcVarD.b(bVar.hu());
            } else if (hcVarD.s() == -1) {
                return;
            } else {
                hcVarD.b(-1);
            }
            tt.d().d(hcVarD);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("download_id", bVar.h());
            jSONObject.put("name", bVar.gb());
            jSONObject.put("url", bVar.tc());
            jSONObject.put("download_time", bVar.pa());
            jSONObject.put("download_status", i);
            jSONObject.put("cur_bytes", bVar.js());
            jSONObject.put(KwaiQosInfo.TOTAL_BYTES, bVar.mb());
            int i2 = 1;
            jSONObject.put("only_wifi", bVar.np() ? 1 : 0);
            jSONObject.put("chunk_count", bVar.fj());
            if (!z) {
                i2 = 2;
            }
            jSONObject.put("launch_resumed", i2);
            jSONObject.put("failed_resume_count", bVar.hu());
            com.ss.android.downloadlib.c.d.d().d("embeded_ad", "download_uncompleted", jSONObject, hcVarD);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.mq.d(th);
        }
    }

    @Override // com.ss.android.socialbase.downloader.c.mq
    public void d() {
        com.ss.android.downloadlib.u.d().d(new Runnable() { // from class: com.ss.android.downloadlib.b.c.1
            @Override // java.lang.Runnable
            public void run() throws JSONException {
                com.ss.android.socialbase.downloader.h.b bVarGb;
                int iUo;
                com.ss.android.downloadlib.addownload.hc.an.d().hc();
                for (com.ss.android.hc.d.hc.hc hcVar : com.ss.android.downloadlib.addownload.hc.an.d().b().values()) {
                    int iRf = hcVar.rf();
                    if (iRf != 0) {
                        com.ss.android.socialbase.downloader.uo.d dVarD = com.ss.android.socialbase.downloader.uo.d.d(iRf);
                        if (dVarD.hc("notification_opt_2") == 1 && (bVarGb = com.ss.android.socialbase.downloader.downloader.h.hc(com.ss.android.downloadlib.addownload.mq.getContext()).gb(iRf)) != null) {
                            if (uo.hc(hcVar) && !uo.b(hcVar.u())) {
                                int iUo2 = bVarGb.uo("restart_notify_open_app_count");
                                if (iUo2 < dVarD.d("noti_open_restart_times", 1)) {
                                    gb.d().u(hcVar);
                                    bVarGb.d("restart_notify_open_app_count", String.valueOf(iUo2 + 1));
                                }
                            } else if (bVarGb.v() == -2) {
                                int iUo3 = bVarGb.uo("restart_notify_continue_count");
                                if (iUo3 < dVarD.d("noti_continue_restart_times", 1)) {
                                    gb.d().d(hcVar);
                                    bVarGb.d("restart_notify_continue_count", String.valueOf(iUo3 + 1));
                                }
                            } else if (bVarGb.v() == -3 && com.ss.android.socialbase.downloader.e.an.b(bVarGb) && !uo.hc(hcVar) && (iUo = bVarGb.uo("restart_notify_install_count")) < dVarD.d("noti_install_restart_times", 1)) {
                                gb.d().b(hcVar);
                                bVarGb.d("restart_notify_install_count", String.valueOf(iUo + 1));
                            }
                        }
                    }
                }
            }
        }, 5000L);
    }
}
