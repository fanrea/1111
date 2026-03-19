package com.ss.android.downloadlib.b;

import com.ss.android.downloadlib.addownload.mq;
import com.ss.android.downloadlib.h.uo;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class gb {

    private static class d {
        private static gb d = new gb();
    }

    public static gb d() {
        return d.d;
    }

    private gb() {
    }

    public void d(com.ss.android.hc.d.hc.hc hcVar) {
        hc(hcVar, 5L);
    }

    public void hc(com.ss.android.hc.d.hc.hc hcVar) {
        if (hcVar == null) {
            return;
        }
        hc(hcVar, com.ss.android.socialbase.downloader.uo.d.d(hcVar.rf()).d("noti_continue_delay_secs", 5));
    }

    private void hc(final com.ss.android.hc.d.hc.hc hcVar, long j) {
        final int iRf = hcVar.rf();
        if (com.ss.android.socialbase.downloader.uo.d.d(iRf).hc("notification_opt_2") != 1) {
            return;
        }
        d(iRf);
        com.ss.android.downloadlib.u.d().d(new Runnable() { // from class: com.ss.android.downloadlib.b.gb.1
            @Override // java.lang.Runnable
            public void run() throws JSONException {
                com.ss.android.socialbase.downloader.h.b bVarGb = com.ss.android.socialbase.downloader.downloader.h.hc(mq.getContext()).gb(iRf);
                JSONObject jSONObject = new JSONObject();
                uo.d(jSONObject, "ttdownloader_type", (Object) 1);
                com.ss.android.downloadlib.h.an.b(bVarGb, jSONObject);
                if (bVarGb != null && -2 == bVarGb.v() && !bVarGb.xp()) {
                    gb.this.d(iRf, hcVar, jSONObject);
                } else {
                    uo.d(jSONObject, "error_code", (Object) 1001);
                }
                com.ss.android.downloadlib.c.d.d().hc("download_notification_try_show", jSONObject, hcVar);
            }
        }, j * 1000);
    }

    public void b(com.ss.android.hc.d.hc.hc hcVar) {
        b(hcVar, 5L);
    }

    public void c(com.ss.android.hc.d.hc.hc hcVar) {
        b(hcVar, com.ss.android.socialbase.downloader.uo.d.d(hcVar.rf()).d("noti_install_delay_secs", 5));
    }

    private void b(final com.ss.android.hc.d.hc.hc hcVar, long j) {
        final int iRf = hcVar.rf();
        if (com.ss.android.socialbase.downloader.uo.d.d(iRf).hc("notification_opt_2") != 1) {
            return;
        }
        d(iRf);
        com.ss.android.downloadlib.u.d().d(new Runnable() { // from class: com.ss.android.downloadlib.b.gb.2
            @Override // java.lang.Runnable
            public void run() throws JSONException {
                com.ss.android.socialbase.downloader.h.b bVarGb = com.ss.android.socialbase.downloader.downloader.h.hc(mq.getContext()).gb(iRf);
                JSONObject jSONObject = new JSONObject();
                uo.d(jSONObject, "ttdownloader_type", (Object) 2);
                com.ss.android.downloadlib.h.an.b(bVarGb, jSONObject);
                if (!uo.hc(hcVar)) {
                    gb.this.d(iRf, hcVar, jSONObject);
                } else {
                    uo.d(jSONObject, "error_code", (Object) 1002);
                }
                com.ss.android.downloadlib.c.d.d().hc("download_notification_try_show", jSONObject, hcVar);
            }
        }, j * 1000);
    }

    public void u(com.ss.android.hc.d.hc.hc hcVar) {
        d(hcVar, 5L);
    }

    public void an(com.ss.android.hc.d.hc.hc hcVar) {
        d(hcVar, com.ss.android.socialbase.downloader.uo.d.d(hcVar.rf()).d("noti_open_delay_secs", 5));
    }

    public void d(final com.ss.android.hc.d.hc.hc hcVar, long j) {
        final int iRf = hcVar.rf();
        if (com.ss.android.socialbase.downloader.uo.d.d(iRf).hc("notification_opt_2") != 1) {
            return;
        }
        d(iRf);
        com.ss.android.downloadlib.u.d().d(new Runnable() { // from class: com.ss.android.downloadlib.b.gb.3
            @Override // java.lang.Runnable
            public void run() throws JSONException {
                com.ss.android.socialbase.downloader.h.b bVarGb = com.ss.android.socialbase.downloader.downloader.h.hc(mq.getContext()).gb(iRf);
                JSONObject jSONObject = new JSONObject();
                uo.d(jSONObject, "ttdownloader_type", (Object) 3);
                com.ss.android.downloadlib.h.an.b(bVarGb, jSONObject);
                if (!uo.b(hcVar.u())) {
                    gb.this.d(iRf, hcVar, jSONObject);
                } else {
                    uo.d(jSONObject, "error_code", (Object) 1003);
                }
                com.ss.android.downloadlib.c.d.d().hc("download_notification_try_show", jSONObject, hcVar);
            }
        }, j * 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i, com.ss.android.hc.d.hc.hc hcVar, JSONObject jSONObject) throws JSONException {
        if (!com.ss.android.socialbase.appdownloader.u.c.d()) {
            uo.d(jSONObject, "error_code", (Object) 1004);
            return;
        }
        com.ss.android.socialbase.downloader.h.b bVarGb = com.ss.android.socialbase.downloader.downloader.h.hc(mq.getContext()).gb(i);
        if (bVarGb == null) {
            uo.d(jSONObject, "error_code", (Object) 1005);
            return;
        }
        if (com.ss.android.socialbase.downloader.notification.hc.d().u(i) != null) {
            com.ss.android.socialbase.downloader.notification.hc.d().an(i);
        }
        com.ss.android.socialbase.appdownloader.u.d dVar = new com.ss.android.socialbase.appdownloader.u.d(mq.getContext(), i, bVarGb.tt(), bVarGb.mk(), bVarGb.gb(), bVarGb.s());
        dVar.d(bVarGb.js());
        dVar.hc(bVarGb.mb());
        dVar.d(bVarGb.w(), null, false, false);
        com.ss.android.socialbase.downloader.notification.hc.d().d(dVar);
        dVar.d((com.ss.android.socialbase.downloader.u.d) null, false);
        com.ss.android.downloadlib.c.d.d().hc("download_notification_show", jSONObject, hcVar);
    }

    public void d(int i) {
        com.ss.android.socialbase.downloader.h.b bVarGb;
        if (com.ss.android.socialbase.appdownloader.u.b.d().d(i) != null || (bVarGb = com.ss.android.socialbase.downloader.downloader.h.hc(mq.getContext()).gb(i)) == null) {
            return;
        }
        com.ss.android.socialbase.appdownloader.u.b.d().d(i, bVarGb.lv());
    }
}
