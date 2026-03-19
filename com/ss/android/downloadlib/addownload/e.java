package com.ss.android.downloadlib.addownload;

import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.socialbase.downloader.impls.yo;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class e {
    private static com.ss.android.downloadlib.addownload.d.c d;
    private static com.ss.android.downloadlib.addownload.d.b hc;

    public static boolean d(int i) {
        return i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 7 || i == 8;
    }

    public static com.ss.android.downloadlib.addownload.d.c d() {
        return d;
    }

    public static void d(com.ss.android.downloadlib.addownload.d.c cVar) {
        d = cVar;
    }

    public static com.ss.android.downloadlib.addownload.d.b hc() {
        return hc;
    }

    public static void d(com.ss.android.downloadlib.addownload.d.b bVar) {
        hc = bVar;
    }

    public static boolean d(final com.ss.android.hc.d.hc.hc hcVar, com.ss.android.socialbase.downloader.h.b bVar, int i, final com.ss.android.downloadlib.addownload.c.gb gbVar, final boolean z, final com.ss.android.downloadlib.addownload.d.b bVar2) throws JSONException {
        boolean zHc;
        if (hcVar == null) {
            com.ss.android.downloadlib.u.b.d().d("tryReverseWifi nativeModel null");
            return false;
        }
        if (bVar == null) {
            com.ss.android.downloadlib.u.b.d().d("tryReverseWifi info null");
            return false;
        }
        final int iH = bVar.h();
        if (z) {
            zHc = com.ss.android.downloadlib.h.u.b((com.ss.android.hc.d.hc.d) hcVar);
        } else {
            zHc = com.ss.android.downloadlib.h.u.hc((com.ss.android.hc.d.hc.d) hcVar);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("switch_status", Integer.valueOf(zHc ? 1 : 0));
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.mq.d(e);
        }
        if (z) {
            com.ss.android.downloadlib.c.d.d().d("cancel_pause_reserve_wifi_switch_status", jSONObject, hcVar);
        } else {
            com.ss.android.downloadlib.c.d.d().d("pause_reserve_wifi_switch_status", jSONObject, hcVar);
        }
        if (!zHc || !d(i) || com.ss.android.socialbase.downloader.e.an.hc(mq.getContext())) {
            return false;
        }
        if (!z && bVar.to()) {
            return false;
        }
        d(new com.ss.android.downloadlib.addownload.d.c() { // from class: com.ss.android.downloadlib.addownload.e.1
            @Override // com.ss.android.downloadlib.addownload.d.c
            public void d() throws JSONException {
                e.d((com.ss.android.downloadlib.addownload.d.c) null);
                com.ss.android.socialbase.downloader.h.b bVarGb = com.ss.android.socialbase.downloader.downloader.h.hc(mq.getContext()).gb(iH);
                if (bVarGb != null) {
                    bVarGb.rw();
                    yo.d().d(bVarGb);
                    if (z) {
                        com.ss.android.downloadlib.c.d.d().d("cancel_pause_reserve_wifi_confirm", hcVar);
                    } else {
                        com.ss.android.downloadlib.c.d.d().hc("pause_reserve_wifi_confirm", hcVar);
                    }
                }
                gbVar.d(hcVar);
            }

            @Override // com.ss.android.downloadlib.addownload.d.c
            public void hc() throws JSONException {
                e.d((com.ss.android.downloadlib.addownload.d.c) null);
                com.ss.android.socialbase.downloader.h.b bVarGb = com.ss.android.socialbase.downloader.downloader.h.hc(mq.getContext()).gb(iH);
                if (bVarGb != null) {
                    bVarGb.ia();
                }
                if (z) {
                    com.ss.android.downloadlib.c.d.d().d("cancel_pause_reserve_wifi_cancel", hcVar);
                } else {
                    com.ss.android.downloadlib.c.d.d().hc("pause_reserve_wifi_cancel", hcVar);
                }
                gbVar.d(hcVar);
            }
        });
        if (z && bVar2 != null) {
            d(new com.ss.android.downloadlib.addownload.d.b() { // from class: com.ss.android.downloadlib.addownload.e.2
                @Override // com.ss.android.downloadlib.addownload.d.b
                public void delete() {
                    com.ss.android.downloadlib.c.d.d().d("cancel_pause_reserve_wifi_delete", hcVar);
                    bVar2.delete();
                }
            });
        }
        if (z) {
            TTDelegateActivity.d(hcVar, "删除");
        } else {
            TTDelegateActivity.hc(hcVar);
        }
        return true;
    }
}
