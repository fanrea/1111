package com.ss.android.downloadlib.addownload.b;

import com.ss.android.downloadlib.addownload.hc.an;
import com.ss.android.downloadlib.addownload.hc.tt;
import com.ss.android.downloadlib.addownload.mq;
import com.ss.android.downloadlib.h.uo;
import com.ss.android.socialbase.downloader.downloader.h;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class hc implements Runnable {
    private com.ss.android.socialbase.downloader.h.b d;

    public hc(com.ss.android.socialbase.downloader.h.b bVar) {
        this.d = bVar;
    }

    @Override // java.lang.Runnable
    public void run() throws Throwable {
        final com.ss.android.hc.d.hc.hc hcVarD;
        if (this.d == null || (hcVarD = an.d().d(this.d)) == null) {
            return;
        }
        com.ss.android.downloadlib.c.d.d().d("cleanspace_task", hcVarD);
        long jLongValue = Double.valueOf((com.ss.android.downloadlib.h.u.d(this.d.h()) + 1.0d) * this.d.mb()).longValue() - this.d.js();
        long jHc = uo.hc(0L);
        if (mq.uo() != null) {
            mq.uo();
        }
        b.d();
        b.hc();
        if (com.ss.android.downloadlib.h.u.h(hcVarD.rf())) {
            b.d(mq.getContext());
        }
        long jHc2 = uo.hc(0L);
        if (jHc2 >= jLongValue) {
            hcVarD.mq("1");
            tt.d().d(hcVarD);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("quite_clean_size", Long.valueOf(jHc2 - jHc));
            } catch (JSONException e) {
                com.bytedance.sdk.component.utils.mq.d(e);
            }
            com.ss.android.downloadlib.c.d.d().d("cleanspace_download_after_quite_clean", jSONObject, hcVarD);
            h.hc(mq.getContext()).u(this.d.h());
            return;
        }
        if (mq.uo() != null) {
            hcVarD.c(false);
            c.d().d(hcVarD.d(), new u() { // from class: com.ss.android.downloadlib.addownload.b.hc.1
            });
            if (mq.uo().d(this.d.h(), this.d.tc(), true, jLongValue)) {
                hcVarD.u(true);
                return;
            }
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt("show_dialog_result", 3);
        } catch (JSONException e2) {
            com.bytedance.sdk.component.utils.mq.d(e2);
        }
        com.ss.android.downloadlib.c.d.d().d("cleanspace_window_show", jSONObject2, hcVarD);
    }
}
