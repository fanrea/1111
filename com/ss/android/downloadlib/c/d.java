package com.ss.android.downloadlib.c;

import android.os.Build;
import com.sigmob.sdk.base.common.a;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.n;
import com.ss.android.d.d.u.c;
import com.ss.android.downloadlib.addownload.hc.an;
import com.ss.android.downloadlib.addownload.hc.tt;
import com.ss.android.downloadlib.addownload.hc.u;
import com.ss.android.downloadlib.addownload.mq;
import com.ss.android.downloadlib.h.uo;
import com.ss.android.socialbase.appdownloader.u.c;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class d {

    /* renamed from: com.ss.android.downloadlib.c.d$d, reason: collision with other inner class name */
    private static class C0753d {
        private static d d = new d();
    }

    public static d d() {
        return C0753d.d;
    }

    private d() {
    }

    public void d(long j, int i) {
        u uVarU = an.d().u(j);
        if (uVarU.np()) {
            com.ss.android.downloadlib.u.b.d().d("sendClickEvent ModelBox notValid");
            return;
        }
        if (uVarU.b.mq()) {
            int i2 = 1;
            com.ss.android.d.d.b.hc hcVar = uVarU.b;
            String strB = i == 1 ? hcVar.b() : hcVar.hc();
            String strD = uo.d(uVarU.b.c(), "click");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("download_click_type", Integer.valueOf(i));
                jSONObject.putOpt("permission_notification", Integer.valueOf(c.d() ? 1 : 2));
                if (!com.ss.android.socialbase.downloader.e.an.b(mq.getContext())) {
                    i2 = 2;
                }
                jSONObject.putOpt("network_available", Integer.valueOf(i2));
            } catch (JSONException e) {
                com.bytedance.sdk.component.utils.mq.d(e);
            }
            d(strB, strD, jSONObject, uVarU);
            if (!"click".equals(strD) || uVarU.hc == null) {
                return;
            }
            b.d().d(j, uVarU.hc.yi());
        }
    }

    public void d(long j, int i, com.ss.android.socialbase.downloader.h.b bVar) throws JSONException {
        u uVarU = an.d().u(j);
        if (uVarU.np()) {
            com.ss.android.downloadlib.u.b.d().d("sendEvent ModelBox notValid");
            return;
        }
        String strD = null;
        JSONObject jSONObject = new JSONObject();
        uo.d(jSONObject, "download_scene", Integer.valueOf(uVarU.jh()));
        if (i == 1) {
            strD = uo.d(uVarU.b.tt(), "storage_deny");
        } else if (i == 2) {
            strD = uo.d(uVarU.b.u(), "click_start");
            com.ss.android.downloadlib.h.an.d(bVar, jSONObject);
        } else if (i == 3) {
            strD = uo.d(uVarU.b.an(), "click_pause");
            com.ss.android.downloadlib.h.an.hc(bVar, jSONObject);
        } else if (i == 4) {
            strD = uo.d(uVarU.b.h(), "click_continue");
            com.ss.android.downloadlib.h.an.b(bVar, jSONObject);
        } else if (i == 5) {
            if (bVar != null) {
                try {
                    com.ss.android.downloadlib.h.an.d(jSONObject, bVar.h());
                    com.ss.android.downloadlib.d.hc(jSONObject, bVar);
                } catch (Throwable unused) {
                }
            }
            strD = uo.d(uVarU.b.gb(), "click_install");
        }
        d(null, strD, jSONObject, 0L, 1, uVarU);
    }

    public void hc(long j, int i) throws JSONException {
        d(j, i, (com.ss.android.socialbase.downloader.h.b) null);
    }

    public void d(String str, int i, u uVar) throws JSONException {
        d(null, str, null, i, 0, uVar);
    }

    public void d(long j, boolean z, int i) {
        u uVarU = an.d().u(j);
        if (uVarU.np()) {
            com.ss.android.downloadlib.u.b.d().d("sendQuickAppEvent ModelBox notValid");
            return;
        }
        if (uVarU.hc.z() == null) {
            return;
        }
        if (uVarU.hc instanceof com.ss.android.hc.d.d.b) {
            ((com.ss.android.hc.d.d.b) uVarU.hc).b(3);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("download_click_type", Integer.valueOf(i));
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.mq.d(e);
        }
        hc(z ? "deeplink_quickapp_success" : "deeplink_quickapp_failed", jSONObject, uVarU);
    }

    public void d(long j, com.ss.android.socialbase.downloader.u.d dVar) {
        u uVarU = an.d().u(j);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("download_time", 0);
            if (dVar != null) {
                jSONObject.putOpt("fail_status", Integer.valueOf(dVar.d()));
                jSONObject.putOpt("fail_msg", dVar.hc());
            }
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.mq.d(e);
        }
        hc(PointCategory.DOWNLOAD_FAILED, jSONObject, uVarU);
    }

    public void d(com.ss.android.socialbase.downloader.h.b bVar) {
        com.ss.android.hc.d.hc.hc hcVarD = an.d().d(bVar);
        if (hcVarD == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            com.ss.android.downloadlib.h.an.b(bVar, jSONObject);
            hcVarD.d(System.currentTimeMillis());
            d(hcVarD.tc(), "download_resume", jSONObject, hcVarD);
            tt.d().d(hcVarD);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.mq.d(th);
        }
    }

    public void d(JSONObject jSONObject, com.ss.android.hc.d.hc.hc hcVar) throws JSONException {
        d(hcVar.tc(), a.J, jSONObject, hcVar);
    }

    public void d(com.ss.android.socialbase.downloader.h.b bVar, com.ss.android.socialbase.downloader.u.d dVar) throws JSONException {
        com.ss.android.hc.d.hc.hc hcVarD;
        if (bVar == null || (hcVarD = an.d().d(bVar)) == null || hcVarD.b.get()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            com.ss.android.downloadlib.d.d(jSONObject, bVar);
            jSONObject.putOpt("fail_status", Integer.valueOf(hcVarD.us()));
            jSONObject.putOpt("fail_msg", hcVarD.z());
            jSONObject.put("download_failed_times", hcVarD.np());
            if (bVar.mb() > 0) {
                jSONObject.put("download_percent", bVar.js() / bVar.mb());
            }
            jSONObject.put("download_status", bVar.v());
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (hcVarD.ba() > 0) {
                jSONObject.put("time_from_start_download", jCurrentTimeMillis - hcVarD.ba());
            }
            if (hcVarD.zw() > 0) {
                jSONObject.put("time_from_download_resume", jCurrentTimeMillis - hcVarD.zw());
            }
            int i = 1;
            jSONObject.put("is_update_download", hcVarD.fu() ? 1 : 2);
            jSONObject.put("can_show_notification", c.d() ? 1 : 2);
            if (!hcVarD.c.get()) {
                i = 2;
            }
            jSONObject.put("has_send_download_failed_finally", i);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.mq.d(e);
        }
        d(hcVarD.tc(), "download_cancel", jSONObject, hcVarD);
    }

    public void hc(com.ss.android.socialbase.downloader.h.b bVar, com.ss.android.socialbase.downloader.u.d dVar) throws JSONException {
        if (bVar == null) {
            return;
        }
        com.ss.android.hc.d.hc.hc hcVarD = an.d().d(bVar);
        if (hcVarD == null) {
            com.ss.android.downloadlib.u.b.d().d("sendDownloadFailedEvent nativeModel null");
            return;
        }
        if (hcVarD.b.get()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            com.ss.android.downloadlib.h.an.b(bVar, jSONObject);
            com.ss.android.downloadlib.d.d(jSONObject, bVar);
            if (dVar != null) {
                jSONObject.putOpt("fail_status", Integer.valueOf(dVar.d()));
                jSONObject.putOpt("fail_msg", dVar.hc());
                hcVarD.c(dVar.d());
                hcVarD.d(dVar.hc());
            }
            hcVarD.yi();
            jSONObject.put("download_failed_times", hcVarD.np());
            if (bVar.mb() > 0) {
                jSONObject.put("download_percent", bVar.js() / bVar.mb());
            }
            int i = 1;
            jSONObject.put("has_send_download_failed_finally", hcVarD.c.get() ? 1 : 2);
            com.ss.android.downloadlib.h.an.d(hcVarD, jSONObject);
            if (!hcVarD.fu()) {
                i = 2;
            }
            jSONObject.put("is_update_download", i);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.mq.d(e);
        }
        d(hcVarD.tc(), PointCategory.DOWNLOAD_FAILED, jSONObject, hcVarD);
        tt.d().d(hcVarD);
    }

    public void d(String str, long j) throws JSONException {
        d(str, (JSONObject) null, j);
    }

    public void d(String str, com.ss.android.hc.d.hc.d dVar) {
        d(str, (JSONObject) null, dVar);
    }

    public void d(String str, JSONObject jSONObject, long j) throws JSONException {
        com.ss.android.hc.d.hc.d dVarC = an.d().c(j);
        if (dVarC != null) {
            d(str, jSONObject, dVarC);
            return;
        }
        u uVarU = an.d().u(j);
        if (uVarU.np()) {
            com.ss.android.downloadlib.u.b.d().d("sendUnityEvent ModelBox notValid");
        } else {
            d(str, jSONObject, uVarU);
        }
    }

    public void d(String str, JSONObject jSONObject, com.ss.android.hc.d.hc.d dVar) {
        JSONObject jSONObject2 = new JSONObject();
        uo.d(jSONObject2, "unity_label", str);
        d("embeded_ad", "ttdownloader_unity", uo.d(jSONObject, jSONObject2), dVar);
    }

    public void d(String str, com.ss.android.d.d.b.b bVar, com.ss.android.d.d.b.hc hcVar, com.ss.android.d.d.b.d dVar) {
        hc(str, new u(bVar.c(), bVar, hcVar, dVar));
    }

    public void hc(String str, long j) {
        com.ss.android.hc.d.hc.hc hcVarC = an.d().c(j);
        if (hcVarC != null) {
            hc(str, hcVarC);
        } else {
            hc(str, an.d().u(j));
        }
    }

    public void hc(String str, com.ss.android.hc.d.hc.d dVar) {
        d((String) null, str, dVar);
    }

    public void hc(String str, JSONObject jSONObject, com.ss.android.hc.d.hc.d dVar) {
        d((String) null, str, jSONObject, dVar);
    }

    public void d(String str, String str2, com.ss.android.hc.d.hc.d dVar) throws JSONException {
        d(str, str2, (JSONObject) null, dVar);
    }

    public void d(String str, String str2, JSONObject jSONObject, com.ss.android.hc.d.hc.d dVar) throws JSONException {
        d(str, str2, jSONObject, 0L, 0, dVar);
    }

    private void d(String str, String str2, JSONObject jSONObject, long j, int i, com.ss.android.hc.d.hc.d dVar) throws JSONException {
        if (dVar == null) {
            com.ss.android.downloadlib.u.b.d().d("onEvent data null");
            return;
        }
        if ((dVar instanceof u) && ((u) dVar).np()) {
            com.ss.android.downloadlib.u.b.d().d("onEvent ModelBox notValid");
            return;
        }
        try {
            c.d dVarB = new c.d().d(uo.d(str, dVar.tc(), "embeded_ad")).hc(str2).hc(dVar.b()).d(dVar.hc()).b(dVar.c());
            if (j <= 0) {
                j = dVar.mq();
            }
            c.d dVarD = dVarB.hc(j).c(dVar.tt()).d(dVar.k()).d(uo.d(d(dVar), jSONObject)).hc(dVar.mk()).d(dVar.e());
            if (i <= 0) {
                i = 2;
            }
            d(dVarD.d(i).d(dVar.uo()).d());
        } catch (Exception e) {
            com.ss.android.downloadlib.u.b.d().d(e, "onEvent");
        }
    }

    private JSONObject d(com.ss.android.hc.d.hc.d dVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            uo.d(dVar.h(), jSONObject);
            uo.d(dVar.cb(), jSONObject);
            jSONObject.putOpt("download_url", dVar.d());
            jSONObject.putOpt(n.p, dVar.u());
            jSONObject.putOpt("android_int", Integer.valueOf(Build.VERSION.SDK_INT));
            jSONObject.putOpt("rom_name", com.ss.android.socialbase.appdownloader.an.u.gb());
            jSONObject.putOpt("rom_version", com.ss.android.socialbase.appdownloader.an.u.tt());
            jSONObject.putOpt("ttdownloader", 1);
            jSONObject.putOpt("funnel_type", Integer.valueOf(dVar.gb()));
            if (dVar.gb() == 2) {
                com.ss.android.downloadlib.h.an.hc(jSONObject, dVar);
            }
            if (com.ss.android.socialbase.appdownloader.an.u.cb()) {
                com.ss.android.downloadlib.h.an.d(jSONObject);
            }
        } catch (Exception e) {
            mq.jh().d(e, "getBaseJson");
        }
        return jSONObject;
    }

    private void d(com.ss.android.d.d.u.c cVar) {
        if (mq.d() == null) {
            return;
        }
        if (cVar.uo()) {
            mq.d().d(cVar);
        } else {
            mq.d().hc(cVar);
        }
    }
}
