package com.ss.android.downloadlib.b;

import android.content.Context;
import com.ss.android.downloadlib.addownload.mq;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class an implements com.ss.android.socialbase.appdownloader.b.u {
    private Context d;

    public an(Context context) {
        this.d = context.getApplicationContext();
    }

    @Override // com.ss.android.socialbase.appdownloader.b.u
    public void d(Context context, String str) {
        com.ss.android.downloadlib.d.d().d(str);
    }

    @Override // com.ss.android.socialbase.appdownloader.b.u
    public void d(int i, int i2, String str, int i3, long j) throws JSONException {
        com.ss.android.socialbase.downloader.h.b bVarGb;
        com.ss.android.hc.d.hc.hc hcVarD;
        Context context = this.d;
        if (context == null || (bVarGb = com.ss.android.socialbase.downloader.downloader.h.hc(context).gb(i)) == null || bVarGb.w() == 0 || (hcVarD = com.ss.android.downloadlib.addownload.hc.an.d().d(bVarGb)) == null) {
            return;
        }
        if (i2 == 1) {
            com.ss.android.downloadlib.d.d(bVarGb, hcVarD);
            if ("application/vnd.android.package-archive".equals(bVarGb.hg())) {
                com.ss.android.downloadlib.addownload.d.d().d(bVarGb, hcVarD.hc(), hcVarD.mq(), hcVarD.u(), bVarGb.tt(), hcVarD.c(), bVarGb.k());
                return;
            }
            return;
        }
        if (i2 == 3) {
            com.ss.android.downloadlib.c.d.d().d("download_notification", "download_notification_install", com.ss.android.downloadlib.d.hc(new JSONObject(), bVarGb), hcVarD);
            return;
        }
        if (i2 == 5) {
            com.ss.android.downloadlib.c.d.d().d("download_notification", "download_notification_pause", hcVarD);
        } else if (i2 == 6) {
            com.ss.android.downloadlib.c.d.d().d("download_notification", "download_notification_continue", hcVarD);
        } else {
            if (i2 != 7) {
                return;
            }
            com.ss.android.downloadlib.c.d.d().d("download_notification", "download_notification_click", hcVarD);
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.b.u
    public boolean d(int i, boolean z) {
        if (mq.e() != null) {
            return mq.e().d(z);
        }
        return false;
    }

    @Override // com.ss.android.socialbase.appdownloader.b.u
    public void d(com.ss.android.socialbase.downloader.h.b bVar) throws JSONException {
        if (bVar == null) {
            return;
        }
        com.ss.android.downloadlib.gb.d().d(bVar);
        if (com.ss.android.socialbase.downloader.uo.d.d(bVar.h()).d("report_download_cancel", 1) == 1) {
            com.ss.android.downloadlib.c.d.d().d(bVar, new com.ss.android.socialbase.downloader.u.d(1012, ""));
        } else {
            com.ss.android.downloadlib.c.d.d().hc(bVar, new com.ss.android.socialbase.downloader.u.d(1012, ""));
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.b.u
    public void d(int i, int i2, String str, String str2, String str3) {
        com.ss.android.socialbase.downloader.h.b bVarGb;
        Context context = this.d;
        if (context == null || (bVarGb = com.ss.android.socialbase.downloader.downloader.h.hc(context).gb(i)) == null || bVarGb.w() != -3) {
            return;
        }
        bVarGb.h(str2);
        com.ss.android.downloadlib.addownload.hc.d().d(this.d, bVarGb);
    }

    @Override // com.ss.android.socialbase.appdownloader.b.u
    public boolean d() {
        return com.ss.android.downloadlib.addownload.hc.d().hc();
    }
}
