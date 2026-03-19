package com.ss.android.downloadlib.addownload;

import android.os.Handler;
import com.ss.android.downloadlib.addownload.u;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class c {
    private AtomicBoolean b = new AtomicBoolean(false);
    private AtomicBoolean c = new AtomicBoolean(false);
    private Handler d;
    private com.ss.android.downloadlib.addownload.hc.u hc;

    c(Handler handler) {
        this.d = handler;
    }

    public void d(com.ss.android.downloadlib.addownload.hc.u uVar) {
        this.hc = uVar;
    }

    public boolean d() {
        return this.c.get();
    }

    public void d(boolean z) {
        this.c.set(z);
    }

    void d(final int i, final long j, long j2, final u.d dVar) {
        this.c.set(false);
        if (dVar == null) {
            return;
        }
        if (!com.ss.android.downloadlib.h.u.an(i) || !com.ss.android.downloadlib.h.u.u(i)) {
            dVar.d();
            return;
        }
        long jB = com.ss.android.downloadlib.h.u.b(i);
        this.b.set(false);
        final String strD = this.hc.hc.d();
        com.ss.android.hc.d.hc.hc hcVarHc = com.ss.android.downloadlib.addownload.hc.an.d().hc(strD);
        if (hcVarHc == null) {
            hcVarHc = new com.ss.android.hc.d.hc.hc(this.hc.hc, this.hc.b, this.hc.c, 0);
            com.ss.android.downloadlib.addownload.hc.an.d().d(hcVarHc);
        }
        final com.ss.android.hc.d.hc.hc hcVar = hcVarHc;
        hcVar.u(false);
        if (mq.uo() != null) {
            mq.uo();
        }
        com.ss.android.downloadlib.addownload.b.c.d().d(hcVar.d());
        boolean zC = com.ss.android.downloadlib.h.u.c(i);
        if (j2 > 0) {
            d(i, strD, j2, hcVar, j, dVar);
        } else if (zC) {
            d(strD, hcVar, new u.hc() { // from class: com.ss.android.downloadlib.addownload.c.1
                @Override // com.ss.android.downloadlib.addownload.u.hc
                public void d(long j3) throws Throwable {
                    c.this.d(i, strD, j3, hcVar, j, dVar);
                }
            });
        } else {
            jB = 0;
        }
        this.d.postDelayed(new Runnable() { // from class: com.ss.android.downloadlib.addownload.c.2
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.b.get()) {
                    return;
                }
                c.this.b.set(true);
                dVar.d();
            }
        }, jB);
    }

    private void d(String str, com.ss.android.hc.d.hc.hc hcVar, final u.hc hcVar2) {
        if (hcVar2 == null) {
            return;
        }
        com.ss.android.socialbase.downloader.tt.d.hc.d(str, new com.ss.android.socialbase.downloader.tt.mk() { // from class: com.ss.android.downloadlib.addownload.c.3
            @Override // com.ss.android.socialbase.downloader.tt.mk
            public void d(Map<String, String> map) throws JSONException {
                if (c.this.b.get()) {
                    return;
                }
                c.this.b.set(true);
                long jD = c.this.d(map);
                if (jD > 0) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.putOpt("apk_size", Long.valueOf(jD));
                        jSONObject.putOpt("available_space", Long.valueOf(c.c()));
                    } catch (JSONException e) {
                        com.bytedance.sdk.component.utils.mq.d(e);
                    }
                }
                hcVar2.d(jD);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long d(Map<String, String> map) {
        if (map != null && map.size() != 0) {
            try {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if ("content-length".equalsIgnoreCase(key)) {
                        return Long.parseLong(value);
                    }
                }
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.mq.d(e);
            }
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i, String str, long j, final com.ss.android.hc.d.hc.hc hcVar, long j2, final u.d dVar) throws Throwable {
        this.b.set(true);
        boolean zD = false;
        if (j > 0) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("apk_size", Long.valueOf(j));
            } catch (JSONException e) {
                com.bytedance.sdk.component.utils.mq.d(e);
            }
            long jLongValue = (Double.valueOf((com.ss.android.downloadlib.h.u.d(i) + 1.0d) * j).longValue() + com.ss.android.downloadlib.h.u.hc(i)) - j2;
            long jC = c();
            if (jC < jLongValue) {
                d(hcVar, jSONObject, jLongValue, jC);
                d(hcVar);
                long jC2 = c();
                if (jC2 < jLongValue) {
                    hcVar.c(true);
                    final String strD = hcVar.d();
                    com.ss.android.downloadlib.addownload.b.c.d().d(strD, new com.ss.android.downloadlib.addownload.b.u() { // from class: com.ss.android.downloadlib.addownload.c.4
                    });
                    zD = d(i, hcVar, str, jLongValue);
                    if (zD) {
                        hcVar.u(true);
                    }
                } else {
                    hc(hcVar, jSONObject, jC, jC2);
                }
            }
        }
        if (zD) {
            return;
        }
        this.d.post(new Runnable() { // from class: com.ss.android.downloadlib.addownload.c.5
            @Override // java.lang.Runnable
            public void run() {
                dVar.d();
            }
        });
    }

    private boolean d(int i, com.ss.android.hc.d.hc.hc hcVar, String str, long j) throws JSONException {
        if (!com.ss.android.downloadlib.h.u.an(i)) {
            return false;
        }
        if (mq.uo() != null) {
            return mq.uo().d(i, str, true, j);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("show_dialog_result", 3);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.mq.d(e);
        }
        com.ss.android.downloadlib.c.d.d().d("cleanspace_window_show", jSONObject, hcVar);
        return false;
    }

    public static boolean d(final com.ss.android.socialbase.downloader.h.b bVar, long j) {
        int iH = bVar.h();
        boolean zD = false;
        if (!com.ss.android.downloadlib.h.u.an(iH)) {
            return false;
        }
        if (mq.uo() != null && (zD = mq.uo().d(iH, bVar.tc(), false, j))) {
            com.ss.android.downloadlib.addownload.b.c.d().d(bVar.tc(), new com.ss.android.downloadlib.addownload.b.u() { // from class: com.ss.android.downloadlib.addownload.c.6
            });
        }
        return zD;
    }

    public static JSONObject d(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("clean_space_install_params", str);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.mq.d(e);
        }
        return jSONObject;
    }

    public static void d(int i) {
        if (com.ss.android.downloadlib.h.u.an(i) && mq.uo() != null && mq.uo().hc()) {
            mq.uo();
        }
    }

    public static long hc() {
        if (mq.uo() != null) {
            return mq.uo().d();
        }
        return 0L;
    }

    private static void d(com.ss.android.hc.d.hc.hc hcVar) throws Throwable {
        long jC = c();
        if (mq.uo() != null) {
            mq.uo();
        }
        com.ss.android.downloadlib.addownload.b.b.d();
        com.ss.android.downloadlib.addownload.b.b.hc();
        if (com.ss.android.downloadlib.h.u.h(hcVar.rf())) {
            com.ss.android.downloadlib.addownload.b.b.d(mq.getContext());
        }
        long jC2 = c();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("quite_clean_size", Long.valueOf(jC2 - jC));
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.mq.d(e);
        }
        com.ss.android.downloadlib.c.d.d().d("clean_quite_finish", jSONObject, hcVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long c() {
        return com.ss.android.downloadlib.h.uo.hc(0L);
    }

    private void d(com.ss.android.hc.d.hc.hc hcVar, JSONObject jSONObject, long j, long j2) throws JSONException {
        try {
            jSONObject.putOpt("available_space", Long.valueOf(j2));
            jSONObject.putOpt("apk_download_need_size", Long.valueOf(j));
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.mq.d(e);
        }
        com.ss.android.downloadlib.c.d.d().d("clean_space_no_enough_for_download", jSONObject, hcVar);
    }

    private void hc(com.ss.android.hc.d.hc.hc hcVar, JSONObject jSONObject, long j, long j2) throws JSONException {
        hcVar.mq("1");
        com.ss.android.downloadlib.addownload.hc.tt.d().d(hcVar);
        try {
            jSONObject.putOpt("quite_clean_size", Long.valueOf(j2 - j));
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.mq.d(e);
        }
        com.ss.android.downloadlib.c.d.d().d("cleanspace_download_after_quite_clean", jSONObject, hcVar);
    }
}
