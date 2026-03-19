package com.ss.android.downloadlib.addownload;

import android.os.Looper;
import android.os.Message;
import com.ss.android.downloadlib.h.k;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class d implements k.d {
    private static final String d = "d";
    private static d hc;
    private com.ss.android.downloadlib.h.k b = new com.ss.android.downloadlib.h.k(Looper.getMainLooper(), this);
    private long c;

    public static d d() {
        if (hc == null) {
            synchronized (d.class) {
                if (hc == null) {
                    hc = new d();
                }
            }
        }
        return hc;
    }

    private d() {
    }

    public void d(com.ss.android.socialbase.downloader.h.b bVar, long j, long j2, String str, String str2, String str3, String str4) {
        com.ss.android.downloadlib.addownload.hc.d dVar = new com.ss.android.downloadlib.addownload.hc.d(bVar.h(), j, j2, str, str2, str3, str4);
        if (com.ss.android.socialbase.downloader.uo.d.d(bVar.h()).d("back_miui_silent_install", 1) == 0 && ((com.ss.android.socialbase.appdownloader.an.u.uo() || com.ss.android.socialbase.appdownloader.an.u.k()) && com.ss.android.socialbase.downloader.e.tc.d(mq.getContext(), "com.miui.securitycore", "com.miui.enterprise.service.EntInstallService"))) {
            if (com.ss.android.socialbase.downloader.e.an.d(bVar.a().get("extra_silent_install_succeed"), false)) {
                Message messageObtainMessage = this.b.obtainMessage(200, dVar);
                messageObtainMessage.arg1 = 2;
                this.b.sendMessageDelayed(messageObtainMessage, r1.d("check_silent_install_interval", 60000));
                return;
            }
            com.ss.android.hc.d.hc.hc hcVarC = com.ss.android.downloadlib.addownload.hc.an.d().c(dVar.hc);
            JSONObject jSONObject = new JSONObject();
            int i = -1;
            try {
                jSONObject.put("ttdownloader_type", "miui_silent_install");
                jSONObject.put("ttdownloader_message", "miui_silent_install_failed: has not started service");
                i = 5;
            } catch (Exception unused) {
            }
            mq.an().d(null, new com.ss.android.socialbase.downloader.u.d(i, jSONObject.toString()), i);
            com.ss.android.downloadlib.c.d.d().d("embeded_ad", "ah_result", jSONObject, hcVarC);
        }
        if (com.ss.android.downloadlib.h.u.b()) {
            long jCurrentTimeMillis = System.currentTimeMillis() - this.c;
            long jC = com.ss.android.downloadlib.h.u.c();
            if (jCurrentTimeMillis < com.ss.android.downloadlib.h.u.u()) {
                long jU = com.ss.android.downloadlib.h.u.u() - jCurrentTimeMillis;
                jC += jU;
                this.c = System.currentTimeMillis() + jU;
            } else {
                this.c = System.currentTimeMillis();
            }
            com.ss.android.downloadlib.h.k kVar = this.b;
            kVar.sendMessageDelayed(kVar.obtainMessage(200, dVar), jC);
        }
    }

    private void d(com.ss.android.downloadlib.addownload.hc.d dVar, int i) throws JSONException {
        if (mq.mq() == null || mq.mq().d() || dVar == null) {
            return;
        }
        if (2 == i) {
            com.ss.android.hc.d.hc.hc hcVarC = com.ss.android.downloadlib.addownload.hc.an.d().c(dVar.hc);
            JSONObject jSONObject = new JSONObject();
            int i2 = -1;
            try {
                jSONObject.put("ttdownloader_type", "miui_silent_install");
                if (com.ss.android.downloadlib.h.uo.u(mq.getContext(), dVar.c)) {
                    jSONObject.put("ttdownloader_message", "miui_silent_install_succeed");
                    i2 = 4;
                } else {
                    jSONObject.put("ttdownloader_message", "miui_silent_install_failed: has started service");
                    i2 = 5;
                }
            } catch (Exception unused) {
            }
            mq.an().d(null, new com.ss.android.socialbase.downloader.u.d(i2, jSONObject.toString()), i2);
            com.ss.android.downloadlib.c.d.d().d("embeded_ad", "ah_result", jSONObject, hcVarC);
        }
        if (com.ss.android.downloadlib.h.uo.u(mq.getContext(), dVar.c)) {
            com.ss.android.downloadlib.c.d.d().hc("delayinstall_installed", dVar.hc);
            return;
        }
        if (!com.ss.android.downloadlib.h.uo.d(dVar.h)) {
            com.ss.android.downloadlib.c.d.d().hc("delayinstall_file_lost", dVar.hc);
        } else if (com.ss.android.downloadlib.addownload.d.d.d().d(dVar.c)) {
            com.ss.android.downloadlib.c.d.d().hc("delayinstall_conflict_with_back_dialog", dVar.hc);
        } else {
            com.ss.android.downloadlib.c.d.d().hc("delayinstall_install_start", dVar.hc);
            com.ss.android.socialbase.appdownloader.c.d(mq.getContext(), (int) dVar.d);
        }
    }

    @Override // com.ss.android.downloadlib.h.k.d
    public void d(Message message) throws JSONException {
        if (message.what != 200) {
            return;
        }
        d((com.ss.android.downloadlib.addownload.hc.d) message.obj, message.arg1);
    }
}
