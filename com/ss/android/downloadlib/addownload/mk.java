package com.ss.android.downloadlib.addownload;

import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.Calendar;
import org.json.JSONException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class mk {
    private volatile boolean an;
    private volatile com.ss.android.socialbase.downloader.h.b b;
    private volatile com.ss.android.socialbase.downloader.h.b c;
    private volatile com.ss.android.socialbase.downloader.h.b d;
    private volatile boolean h;
    private volatile com.ss.android.socialbase.downloader.h.b hc;
    private volatile boolean u;

    private static class d {
        private static mk d = new mk();
    }

    public static mk d() {
        return d.d;
    }

    private mk() {
        this.d = null;
        this.hc = null;
        this.b = null;
        this.c = null;
        this.u = false;
        this.an = false;
        this.h = false;
        com.ss.android.downloadlib.u.d().hc(new Runnable() { // from class: com.ss.android.downloadlib.addownload.mk.1
            @Override // java.lang.Runnable
            public void run() throws JSONException {
                try {
                    mk.this.b();
                } catch (Exception e) {
                    com.ss.android.downloadlib.u.b.d().d(false, e, "读取sp出错");
                }
            }
        });
    }

    public void d(com.ss.android.d.d.b.b bVar, com.ss.android.socialbase.downloader.h.b bVar2) {
        if (d(bVar2) && mq.de() != null && mq.de().d(bVar, bVar2)) {
            com.ss.android.downloadlib.c.d.d().d("download_unfinished_push_retain", bVar.c());
        }
    }

    public void hc(com.ss.android.d.d.b.b bVar, com.ss.android.socialbase.downloader.h.b bVar2) throws JSONException {
        if (d(bVar2, bVar) && mq.de() != null && mq.de().hc(bVar, bVar2)) {
            com.ss.android.downloadlib.c.d.d().d("download_uninstalled_push_retain", bVar.c());
        }
    }

    public long hc() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.u) {
            return;
        }
        String strValueOf = String.valueOf(hc());
        if (TextUtils.isEmpty(strValueOf)) {
            return;
        }
        SharedPreferences sharedPreferencesD = com.bytedance.sdk.openadsdk.ats.b.d(mq.getContext(), "sp_download_retain", 0);
        if (strValueOf.equals(sharedPreferencesD.getString("unfinished_pushed_update_time", "0"))) {
            String string = sharedPreferencesD.getString("unfinished_pushed_id", "0");
            if (string == null) {
                string = "0";
            }
            this.d = com.ss.android.socialbase.downloader.downloader.h.hc(mq.getContext()).gb(Integer.parseInt(string));
        }
        if (strValueOf.equals(sharedPreferencesD.getString("uninstalled_pushed_update_time", "0"))) {
            String string2 = sharedPreferencesD.getString("uninstalled_pushed_id", "0");
            if (string2 == null) {
                string2 = "0";
            }
            this.hc = com.ss.android.socialbase.downloader.downloader.h.hc(mq.getContext()).gb(Integer.parseInt(string2));
        }
        if (strValueOf.equals(sharedPreferencesD.getString("unfinished_pop_up_update_time", "0"))) {
            String string3 = sharedPreferencesD.getString("unfinished_pop_up_id", "0");
            if (string3 == null) {
                string3 = "0";
            }
            this.b = com.ss.android.socialbase.downloader.downloader.h.hc(mq.getContext()).gb(Integer.parseInt(string3));
        }
        if (strValueOf.equals(sharedPreferencesD.getString("uninstalled_pop_up_update_time", "0"))) {
            String string4 = sharedPreferencesD.getString("uninstalled_pop_up_id", "0");
            this.c = com.ss.android.socialbase.downloader.downloader.h.hc(mq.getContext()).gb(Integer.parseInt(string4 != null ? string4 : "0"));
        }
        this.u = true;
    }

    private boolean d(com.ss.android.socialbase.downloader.h.b bVar) {
        return bVar != null && bVar.w() == -2;
    }

    private boolean d(com.ss.android.socialbase.downloader.h.b bVar, com.ss.android.d.d.b.b bVar2) {
        return (bVar == null || bVar2 == null || com.ss.android.downloadlib.h.uo.d(bVar2)) ? false : true;
    }
}
