package com.ss.android.downloadlib;

import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import com.sigmob.sdk.base.mta.PointCategory;
import com.ss.android.downloadlib.addownload.mq;
import com.ss.android.downloadlib.h.mk;
import com.ss.android.downloadlib.h.uo;
import com.ss.android.socialbase.downloader.d.d;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class b implements com.ss.android.socialbase.appdownloader.b.tt {
    private static String d = "b";
    private Handler hc = new Handler(Looper.getMainLooper());

    @Override // com.ss.android.socialbase.appdownloader.b.tt
    public void d(com.ss.android.socialbase.downloader.h.b bVar, com.ss.android.socialbase.downloader.u.d dVar, int i) {
        final com.ss.android.d.d.b.b bVarD;
        if (bVar == null) {
            return;
        }
        if (i == -1 && dVar != null) {
            JSONObject jSONObject = new JSONObject();
            com.ss.android.downloadlib.h.an.b(bVar, jSONObject);
            d.d(jSONObject, bVar);
            mk.d(PointCategory.DOWNLOAD_FAILED, jSONObject.toString());
        }
        com.ss.android.hc.d.hc.hc hcVarD = com.ss.android.downloadlib.addownload.hc.an.d().d(bVar);
        if (hcVarD == null) {
            return;
        }
        try {
            if (i != -1) {
                if (i == -3) {
                    d.d(bVar, hcVarD);
                    return;
                }
                if (i == 2001) {
                    d.d().d(bVar, hcVarD, 2001);
                    return;
                } else {
                    if (i == 11) {
                        d.d().d(bVar, hcVarD, 2000);
                        if (hcVarD.ru()) {
                            return;
                        }
                        d(bVar, hcVarD);
                        return;
                    }
                    return;
                }
            }
            com.ss.android.socialbase.downloader.u.d dVar2 = null;
            if (dVar != null) {
                if (com.ss.android.socialbase.downloader.uo.d.d(bVar.h()).d("toast_without_network", 0) == 1 && dVar.d() == 1049) {
                    this.hc.post(new Runnable() { // from class: com.ss.android.downloadlib.b.1
                        @Override // java.lang.Runnable
                        public void run() {
                            mq.b().d(5, mq.getContext(), null, "无网络，请检查网络设置", null, 0);
                        }
                    });
                }
                if (com.ss.android.socialbase.downloader.e.an.gb(dVar)) {
                    if (mq.uo() != null) {
                        mq.uo();
                    }
                    com.ss.android.downloadlib.c.d.d().d("download_failed_for_space", hcVarD);
                    if (!hcVarD.wl()) {
                        com.ss.android.downloadlib.c.d.d().d("download_can_restart", hcVarD);
                        d(bVar);
                    }
                    if ((mq.uo() == null || !mq.uo().b()) && (bVarD = com.ss.android.downloadlib.addownload.hc.an.d().d(hcVarD.hc())) != null && bVarD.mk()) {
                        final com.ss.android.socialbase.downloader.uo.d dVarD = com.ss.android.socialbase.downloader.uo.d.d(bVar.h());
                        if (dVarD.d("show_no_enough_space_toast", 0) == 1) {
                            this.hc.post(new Runnable() { // from class: com.ss.android.downloadlib.b.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    mq.b().d(2, mq.getContext(), bVarD, dVarD.d("no_enough_space_toast_text", "您的存储空间不足，请清理后再试"), null, 0);
                                }
                            });
                        }
                    }
                }
                dVar2 = new com.ss.android.socialbase.downloader.u.d(dVar.d(), uo.d(dVar.getMessage(), mq.tt().optInt("exception_msg_length", 500)));
            }
            com.ss.android.downloadlib.c.d.d().hc(bVar, dVar2);
            gb.d().d(bVar, dVar, "");
        } catch (Exception e) {
            mq.jh().d(e, "onAppDownloadMonitorSend");
        }
    }

    private void d(final com.ss.android.socialbase.downloader.h.b bVar, final com.ss.android.hc.d.hc.hc hcVar) {
        final long jD = uo.d(Environment.getDataDirectory(), -1L);
        long jMin = Math.min(524288000L, uo.d(Environment.getDataDirectory()) / 10);
        final long jMb = bVar.mb();
        final double d2 = (jMb * 2.5d) + jMin;
        if (jD > -1 && jMb > -1) {
            double d3 = jD;
            if (d3 < d2 && d2 - d3 > com.ss.android.downloadlib.addownload.c.hc()) {
                com.ss.android.downloadlib.addownload.c.d(bVar.h());
            }
        }
        com.ss.android.socialbase.downloader.d.d.d().d(new d.InterfaceC0785d() { // from class: com.ss.android.downloadlib.b.3
            @Override // com.ss.android.socialbase.downloader.d.d.InterfaceC0785d
            public void b() {
            }

            @Override // com.ss.android.socialbase.downloader.d.d.InterfaceC0785d
            public void hc() {
                if (!uo.hc(hcVar)) {
                    long j = jD;
                    if (j <= -1 || jMb <= -1 || j >= d2) {
                        return;
                    }
                    com.ss.android.downloadlib.c.d.d().d("clean_space_install", com.ss.android.downloadlib.addownload.c.d("install_no_enough_space"), hcVar);
                    if (com.ss.android.downloadlib.addownload.c.d(bVar, ((long) d2) - jD)) {
                        com.ss.android.socialbase.downloader.d.d.d().hc(this);
                        hcVar.h(true);
                        return;
                    }
                    return;
                }
                com.ss.android.socialbase.downloader.d.d.d().hc(this);
            }
        });
    }

    private void d(com.ss.android.socialbase.downloader.h.b bVar) {
        if (com.ss.android.downloadlib.h.u.an(bVar.h())) {
            u.d().hc(new com.ss.android.downloadlib.addownload.b.hc(bVar));
        }
    }
}
