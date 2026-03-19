package com.ss.android.downloadlib;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Pair;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.kwai.player.qos.KwaiQosInfo;
import com.sigmob.sdk.base.common.a;
import com.ss.android.downloadlib.addownload.hc.c;
import com.ss.android.downloadlib.addownload.mk;
import com.ss.android.downloadlib.addownload.mq;
import com.ss.android.downloadlib.addownload.uo;
import com.ss.android.socialbase.appdownloader.hc;
import com.ss.android.socialbase.downloader.c.mt;
import com.ss.android.socialbase.downloader.d.d;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class d implements com.ss.android.hc.d.d, hc.b, mt, d.InterfaceC0785d {
    private static volatile d c = null;
    private static String d = "d";
    private hc b;
    private long hc;

    private d() {
        com.ss.android.socialbase.appdownloader.hc.d(this);
        com.ss.android.socialbase.downloader.d.d.d().d(this);
    }

    public static d d() {
        if (c == null) {
            synchronized (d.class) {
                if (c == null) {
                    c = new d();
                }
            }
        }
        return c;
    }

    public static synchronized void d(com.ss.android.socialbase.downloader.h.b bVar, com.ss.android.hc.d.hc.hc hcVar) {
        if (bVar == null) {
            com.ss.android.downloadlib.u.b.d().d("onDownloadFinish info null");
            return;
        }
        if (hcVar == null) {
            com.ss.android.downloadlib.u.b.d().d("onDownloadFinish nativeModel null");
            return;
        }
        if (hcVar.fs() != 1) {
            return;
        }
        com.ss.android.downloadlib.b.gb.d().c(hcVar);
        String strB = b(bVar, hcVar);
        com.ss.android.downloadlib.addownload.hc.an.d().hc(bVar.tc(), strB);
        Map<Long, com.ss.android.hc.d.hc.hc> mapD = com.ss.android.downloadlib.addownload.hc.an.d().d(bVar.tc(), strB);
        hcVar.an(System.currentTimeMillis());
        hcVar.u(2);
        hcVar.hc(strB);
        mapD.put(Long.valueOf(hcVar.hc()), hcVar);
        com.ss.android.downloadlib.addownload.hc.tt.d().d(mapD.values());
        d(hcVar);
        mk.d().hc(hcVar.sy(), bVar);
        hcVar.mq(System.currentTimeMillis());
        gb.d().d(bVar, strB);
        if ("application/vnd.android.package-archive".equals(bVar.hg())) {
            if (com.ss.android.downloadlib.h.u.d((com.ss.android.hc.d.hc.d) hcVar).d("enable_app_install_receiver", 1) != 1 && mq.tt().optInt("enable_app_install_receiver", 1) != 1) {
                uo.d().d(hcVar);
            }
            d().hc(bVar, hcVar);
            if (hcVar.bc()) {
                com.ss.android.downloadlib.addownload.d.d.d().d(bVar.h(), hcVar.hc(), hcVar.mq(), strB, bVar.tt(), hcVar.c(), bVar.k());
            }
        }
    }

    public synchronized void d(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (com.ss.android.downloadlib.h.uo.hc()) {
            throw new RuntimeException("handleAppInstalled in main thread.");
        }
        final com.ss.android.hc.d.hc.hc hcVarD = com.ss.android.downloadlib.addownload.hc.an.d().d(str);
        if (hcVarD == null) {
            com.ss.android.downloadlib.addownload.hc.c.d().d(str);
            return;
        }
        com.ss.android.downloadlib.addownload.u uVarD = gb.d().d(hcVarD.d());
        if (uVarD != null) {
            uVarD.an();
        }
        if (hcVarD.b.get()) {
            return;
        }
        if (com.ss.android.socialbase.downloader.uo.d.d(hcVarD.rf()).hc("notification_opt_2") == 1) {
            com.ss.android.socialbase.downloader.notification.hc.d().an(hcVarD.rf());
        }
        new com.ss.android.downloadlib.hc.hc().d(hcVarD, new com.ss.android.downloadlib.hc.h() { // from class: com.ss.android.downloadlib.d.1
            @Override // com.ss.android.downloadlib.hc.h
            public void d(boolean z) {
                com.ss.android.socialbase.downloader.an.d.hc(d.d, "appBackForeground->".concat(String.valueOf(z)));
                if (z) {
                    if (!(com.ss.android.downloadlib.hc.an.b(hcVarD) ? com.ss.android.downloadlib.hc.d.d(str, hcVarD) : false) && com.ss.android.downloadlib.hc.an.c(hcVarD) && hcVarD.hv() == 4) {
                        com.ss.android.downloadlib.addownload.d.d.d().d(hcVarD);
                        return;
                    }
                    return;
                }
                if (com.ss.android.downloadlib.hc.d.d(str, hcVarD) || hcVarD.hv() != 4) {
                    return;
                }
                com.ss.android.downloadlib.addownload.d.d.d().d(hcVarD);
            }
        }, com.ss.android.downloadlib.h.u.d((com.ss.android.hc.d.hc.d) hcVarD).d("try_applink_delay_after_installed", 0));
        com.ss.android.downloadlib.b.gb.d().an(hcVarD);
        d(str, hcVarD);
        com.ss.android.downloadlib.addownload.d.d.d().hc(str);
        com.ss.android.socialbase.downloader.h.b bVarD = d((List<com.ss.android.socialbase.downloader.h.b>) com.ss.android.socialbase.downloader.downloader.h.hc(mq.getContext()).hc("application/vnd.android.package-archive"), str);
        if (bVarD != null) {
            if (com.ss.android.socialbase.downloader.uo.d.d(bVarD.h()).hc("no_hide_notification") != 1) {
                com.ss.android.socialbase.downloader.notification.hc.d().d(bVarD.h());
            }
            gb.d().hc(bVarD, str);
            com.ss.android.downloadlib.addownload.b.c.d(bVarD);
            return;
        }
        gb.d().hc(null, str);
    }

    void d(com.ss.android.socialbase.downloader.h.b bVar, com.ss.android.hc.d.hc.hc hcVar, int i) {
        long jMax;
        if (bVar == null || hcVar == null) {
            return;
        }
        c();
        long jCurrentTimeMillis = System.currentTimeMillis();
        hcVar.hc(jCurrentTimeMillis);
        hcVar.h(com.ss.android.downloadlib.h.uo.d(Environment.getDataDirectory(), -1L));
        if (i != 2000) {
            jMax = 2000;
        } else {
            long jD = com.ss.android.socialbase.downloader.uo.d.d(bVar.h()).d("check_install_failed_delay_time", 120000L);
            if (jD < 0) {
                return;
            } else {
                jMax = Math.max(jD, 30000L);
            }
        }
        long j = jMax;
        hc hcVar2 = new hc(hcVar.hc(), bVar.h(), jCurrentTimeMillis, i);
        u.d().d(hcVar2, j);
        this.b = hcVar2;
        com.ss.android.downloadlib.addownload.hc.tt.d().d(hcVar);
    }

    private static class hc implements Runnable {
        private long b;
        private int c;
        private long d;
        private int hc;
        private long u;

        private hc(long j, int i, long j2, int i2) {
            this.d = j;
            this.hc = i;
            this.b = j2;
            this.c = i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void hc() {
            this.u = System.currentTimeMillis();
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (d()) {
                    d.d().d(this.d, this.hc);
                }
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.mq.d(th);
            }
        }

        /* JADX WARN: Can't wrap try/catch for region: R(21:12|(1:19)(20:16|(0)|21|52|22|23|54|24|(1:26)|27|(1:29)(1:30)|31|(1:34)|35|(1:37)(1:38)|39|(1:41)|42|49|50)|20|21|52|22|23|54|24|(0)|27|(0)(0)|31|(1:34)|35|(0)(0)|39|(0)|42|49|50) */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x00f3, code lost:
        
            r0 = e;
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x00f5, code lost:
        
            r0 = e;
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x00f6, code lost:
        
            r3 = r6;
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x00f8, code lost:
        
            com.bytedance.sdk.component.utils.mq.d(r0);
         */
        /* JADX WARN: Removed duplicated region for block: B:26:0x00ae A[Catch: Exception -> 0x00f3, TryCatch #1 {Exception -> 0x00f3, blocks: (B:24:0x008c, B:26:0x00ae, B:31:0x00c2, B:34:0x00cf, B:39:0x00de, B:42:0x00ef), top: B:54:0x008c }] */
        /* JADX WARN: Removed duplicated region for block: B:29:0x00be  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00c1  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x00da  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x00dd  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x00ed  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        boolean d() throws org.json.JSONException {
            /*
                Method dump skipped, instructions count: 262
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ss.android.downloadlib.d.hc.d():boolean");
        }

        private int d(boolean z, com.ss.android.hc.d.hc.hc hcVar, com.ss.android.socialbase.downloader.h.b bVar, boolean z2, JSONObject jSONObject) {
            com.ss.android.socialbase.downloader.uo.d dVarD = com.ss.android.socialbase.downloader.uo.d.d(bVar.h());
            int i = 1;
            if (dVarD.d("install_failed_check_ttmd5", 1) == 1) {
                int iQo = bVar.qo();
                try {
                    jSONObject.put("ttmd5_status", iQo);
                } catch (Throwable unused) {
                }
                if (!com.ss.android.socialbase.downloader.e.an.d(iQo)) {
                    return 2005;
                }
            }
            int i2 = this.c;
            if (i2 != 2000) {
                return i2;
            }
            if (dVarD.d("install_failed_check_signature", 1) == 1 && com.ss.android.downloadlib.h.uo.u(mq.getContext(), hcVar.u())) {
                if (!com.ss.android.downloadlib.h.uo.d(com.ss.android.downloadlib.h.uo.tt(mq.getContext(), bVar.k()), com.ss.android.downloadlib.h.uo.gb(mq.getContext(), hcVar.u()))) {
                    return 2006;
                }
            }
            if (!z) {
                return 2002;
            }
            long j = this.u;
            long j2 = this.b;
            if (j <= j2) {
                return 2000;
            }
            try {
                jSONObject.put("install_time", j - j2);
                if (hcVar.j() <= this.b) {
                    i = 0;
                }
                jSONObject.put("install_again", i);
            } catch (Throwable unused2) {
            }
            return !z2 ? 2003 : 2004;
        }
    }

    public void d(final long j, int i) {
        long jD = com.ss.android.socialbase.downloader.uo.d.d(i).d("check_install_finish_hijack_delay_time", 900000L);
        if (jD < 0) {
            return;
        }
        u.d().d(new Runnable() { // from class: com.ss.android.downloadlib.d.2
            @Override // java.lang.Runnable
            public void run() throws JSONException {
                d.d().d(j);
            }
        }, Math.max(jD, 300000L));
    }

    public void d(long j) throws JSONException {
        c.d dVarD;
        int iIntValue;
        try {
            com.ss.android.hc.d.hc.hc hcVarC = com.ss.android.downloadlib.addownload.hc.an.d().c(j);
            if (hcVarC != null && !com.ss.android.downloadlib.h.uo.hc(hcVarC) && !hcVarC.b.get()) {
                Pair<c.d, Integer> pairHc = com.ss.android.downloadlib.addownload.hc.c.d().hc(hcVarC);
                if (pairHc != null) {
                    dVarD = (c.d) pairHc.first;
                    iIntValue = ((Integer) pairHc.second).intValue();
                } else {
                    dVarD = com.ss.android.downloadlib.addownload.hc.c.d().d(hcVarC);
                    iIntValue = -1;
                }
                if (dVarD == null) {
                    return;
                }
                com.ss.android.downloadlib.addownload.hc.c.d().hc(dVarD.d);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("installed_app_name", dVarD.c);
                jSONObject.put("installed_pkg_name", dVarD.d);
                if (iIntValue != -1) {
                    jSONObject.put("error_code", iIntValue);
                    com.ss.android.downloadlib.h.an.d(jSONObject, hcVarC.rf());
                    com.ss.android.downloadlib.c.d.d().hc("install_finish_hijack", jSONObject, hcVarC);
                    return;
                }
                com.ss.android.downloadlib.c.d.d().hc("install_finish_may_hijack", jSONObject, hcVarC);
            }
        } catch (Throwable th) {
            com.ss.android.downloadlib.u.b.d().d(th, "trySendInstallFinishHijack");
        }
    }

    public void d(String str, com.ss.android.hc.d.hc.hc hcVar) throws JSONException {
        if (hcVar != null && com.ss.android.downloadlib.h.uo.hc(hcVar) && hcVar.b.compareAndSet(false, true)) {
            int i = 4;
            if (hcVar.hv() == 4) {
                com.ss.android.d.d.hc.mk mkVarDe = mq.de();
                if (mkVarDe != null) {
                    mkVarDe.d(hcVar.sy());
                }
            } else {
                i = 3;
            }
            com.ss.android.downloadlib.c.d.d().d(hcVar.tc(), a.J, d(hcVar, str, i), hcVar);
            com.ss.android.downloadlib.addownload.hc.tt.d().d(hcVar);
        }
    }

    private static com.ss.android.socialbase.downloader.h.b d(List<com.ss.android.socialbase.downloader.h.b> list, String str) {
        if (list != null && !list.isEmpty() && !TextUtils.isEmpty(str)) {
            for (com.ss.android.socialbase.downloader.h.b bVar : list) {
                if (bVar != null) {
                    if (str.equals(bVar.us())) {
                        return bVar;
                    }
                    if (com.ss.android.downloadlib.h.uo.d(mq.getContext(), bVar.k(), str)) {
                        return bVar;
                    }
                }
            }
        }
        return null;
    }

    public static JSONObject d(JSONObject jSONObject, com.ss.android.socialbase.downloader.h.b bVar) {
        if (jSONObject != null && bVar != null) {
            int i = 1;
            if (com.ss.android.socialbase.downloader.uo.d.d(bVar.h()).d("download_event_opt", 1) == 0) {
                return jSONObject;
            }
            try {
                jSONObject.put("download_id", bVar.h());
                jSONObject.put("name", bVar.gb());
                jSONObject.put("cur_bytes", bVar.js());
                jSONObject.put(KwaiQosInfo.TOTAL_BYTES, bVar.mb());
                jSONObject.put("network_quality", bVar.f());
                jSONObject.put("current_network_quality", com.ss.android.socialbase.downloader.tt.mq.d().hc().name());
                jSONObject.put("only_wifi", bVar.np() ? 1 : 0);
                jSONObject.put("need_https_degrade", bVar.gu() ? 1 : 0);
                jSONObject.put("https_degrade_retry_used", bVar.jh() ? 1 : 0);
                jSONObject.put("chunk_count", bVar.fj());
                jSONObject.put("retry_count", bVar.hv());
                jSONObject.put("cur_retry_time", bVar.ec());
                jSONObject.put("need_retry_delay", bVar.ho() ? 1 : 0);
                jSONObject.put("backup_url_used", bVar.wl() ? 1 : 0);
                jSONObject.put("head_connection_error_msg", bVar.b() != null ? bVar.b() : "");
                jSONObject.put("need_independent_process", bVar.nf() ? 1 : 0);
                jSONObject.put("total_retry_count", bVar.dc());
                jSONObject.put("cur_retry_time_in_total", bVar.tr());
                jSONObject.put("real_download_time", bVar.cw());
                jSONObject.put("first_speed_time", bVar.yi());
                jSONObject.put("all_connect_time", bVar.zw());
                jSONObject.put("download_prepare_time", bVar.j());
                jSONObject.put("download_time", bVar.cw() + bVar.zw() + bVar.j());
                jSONObject.put("chunk_downgrade_retry_used", bVar.om() ? 1 : 0);
                jSONObject.put("need_chunk_downgrade_retry", bVar.nk() ? 1 : 0);
                jSONObject.put("failed_resume_count", bVar.hu());
                jSONObject.put("preconnect_level", bVar.ss());
                jSONObject.put(TKDownloadReason.KSAD_TK_MD5, bVar.fs());
                jSONObject.put("expect_file_length", bVar.ba());
                jSONObject.put("retry_schedule_count", bVar.yn());
                jSONObject.put("rw_concurrent", bVar.i() ? 1 : 0);
                double dJs = bVar.js() / 1048576.0d;
                double dCw = bVar.cw() / 1000.0d;
                if (dJs > 0.0d && dCw > 0.0d) {
                    double d2 = dJs / dCw;
                    try {
                        jSONObject.put("download_speed", d2);
                    } catch (Exception unused) {
                    }
                    com.ss.android.socialbase.downloader.an.d.hc(d, "download speed : " + d2 + "MB/s");
                }
                try {
                    jSONObject.put("is_download_service_foreground", com.ss.android.socialbase.downloader.downloader.h.hc(mq.getContext()).uo(bVar.h()) ? 1 : 0);
                } catch (Exception e) {
                    com.bytedance.sdk.component.utils.mq.d(e);
                }
                if (bVar.uq() != null) {
                    jSONObject.put("backup_url_count", bVar.uq().size());
                    jSONObject.put("cur_backup_url_index", bVar.rf());
                }
                jSONObject.put("clear_space_restart_times", com.ss.android.downloadlib.addownload.b.c.d().hc(bVar.tc()));
                jSONObject.put("mime_type", bVar.hg());
                if (!com.ss.android.socialbase.downloader.e.an.b(mq.getContext())) {
                    i = 2;
                }
                jSONObject.put("network_available", i);
                jSONObject.put("status_code", bVar.rs());
                hc(jSONObject, bVar);
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.mq.d(th);
            }
        }
        return jSONObject;
    }

    public static JSONObject hc(JSONObject jSONObject, com.ss.android.socialbase.downloader.h.b bVar) {
        if (jSONObject == null || bVar == null || com.ss.android.socialbase.downloader.uo.d.d(bVar.h()).d("download_event_opt", 1) == 0) {
            return jSONObject;
        }
        try {
            long jHc = com.ss.android.downloadlib.h.uo.hc(0L);
            double d2 = jHc;
            jSONObject.put("available_space", d2 / 1048576.0d);
            long jMb = bVar.mb();
            double d3 = jMb;
            jSONObject.put("apk_size", d3 / 1048576.0d);
            if (jHc > 0 && jMb > 0) {
                jSONObject.put("available_space_ratio", d2 / d3);
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.mq.d(th);
        }
        return jSONObject;
    }

    public void hc(com.ss.android.socialbase.downloader.h.b bVar, final com.ss.android.hc.d.hc.hc hcVar) {
        if (bVar == null || hcVar == null || com.ss.android.socialbase.downloader.uo.d.d(bVar.h()).d("install_finish_check_ttmd5", 1) == 0) {
            return;
        }
        final String strK = bVar.k();
        if (TextUtils.isEmpty(strK)) {
            return;
        }
        u.d().hc(new Runnable() { // from class: com.ss.android.downloadlib.d.3
            @Override // java.lang.Runnable
            public void run() {
                String strD = com.ss.android.downloadlib.h.d.d(strK);
                if (TextUtils.isEmpty(strD)) {
                    return;
                }
                com.bytedance.sdk.openadsdk.ats.b.d(mq.getContext(), "sp_ttdownloader_md5", 0).edit().putString(String.valueOf(hcVar.hc()), strD).apply();
            }
        });
    }

    private static void d(com.ss.android.hc.d.hc.hc hcVar) throws JSONException {
        if (hcVar == null) {
            return;
        }
        String strY = TextUtils.isEmpty(hcVar.y()) ? "" : hcVar.y();
        com.ss.android.socialbase.downloader.h.b bVarGb = com.ss.android.socialbase.downloader.downloader.h.hc(mq.getContext()).gb(hcVar.rf());
        hcVar.mq("");
        com.ss.android.downloadlib.addownload.hc.tt.d().d(hcVar);
        JSONObject jSONObjectD = d(new JSONObject(), bVarGb);
        int i = 1;
        try {
            jSONObjectD.putOpt("finish_reason", strY);
            jSONObjectD.putOpt("finish_from_reserve_wifi", Integer.valueOf(bVarGb.l() ? 1 : 0));
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.mq.d(e);
        }
        com.ss.android.hc.d.hc.hc hcVarD = com.ss.android.downloadlib.addownload.hc.an.d().d(bVarGb);
        com.ss.android.downloadlib.h.an.d(jSONObjectD, bVarGb.h());
        try {
            jSONObjectD.put("download_failed_times", hcVarD.np());
            jSONObjectD.put("can_show_notification", com.ss.android.socialbase.appdownloader.u.c.d() ? 1 : 2);
            if (bVarGb.ba() > 0 && bVarGb.mb() > 0) {
                jSONObjectD.put("file_length_gap", bVarGb.ba() - bVarGb.mb());
            }
            jSONObjectD.put("ttmd5_status", bVarGb.vv());
            jSONObjectD.put("has_send_download_failed_finally", hcVarD.c.get() ? 1 : 2);
            if (!hcVarD.fu()) {
                i = 2;
            }
            jSONObjectD.put("is_update_download", i);
            com.ss.android.downloadlib.h.an.d(hcVarD, jSONObjectD);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.mq.d(th);
        }
        com.ss.android.downloadlib.c.d.d().hc(a.H, jSONObjectD, hcVar);
    }

    private int d(com.ss.android.hc.d.hc.hc hcVar, com.ss.android.socialbase.downloader.h.b bVar, String str, JSONObject jSONObject) throws PackageManager.NameNotFoundException {
        int iHc = com.ss.android.socialbase.appdownloader.b.hc(mq.getContext(), bVar);
        int iHc2 = com.ss.android.downloadlib.h.uo.hc(mq.getContext(), str);
        if (iHc > 0 && iHc2 > 0 && iHc != iHc2) {
            return iHc2 > iHc ? 3011 : 3010;
        }
        if (com.ss.android.socialbase.downloader.uo.d.d(hcVar.rf()).d("install_finish_check_ttmd5", 1) != 1) {
            return 3001;
        }
        String string = com.bytedance.sdk.openadsdk.ats.b.d(mq.getContext(), "sp_ttdownloader_md5", 0).getString(String.valueOf(hcVar.hc()), null);
        if (TextUtils.isEmpty(string) && bVar != null) {
            string = com.ss.android.downloadlib.h.d.d(bVar.k());
        }
        int iD = com.ss.android.downloadlib.h.d.d(string, com.ss.android.downloadlib.h.d.hc(str));
        try {
            jSONObject.put("ttmd5_status", iD);
        } catch (Throwable unused) {
        }
        if (iD == 0) {
            return 3000;
        }
        return iD == 1 ? 3002 : 3001;
    }

    public static String b(com.ss.android.socialbase.downloader.h.b bVar, com.ss.android.hc.d.hc.hc hcVar) throws JSONException {
        File file = new File(bVar.mk(), bVar.gb());
        String str = null;
        if (file.exists()) {
            try {
                PackageInfo packageArchiveInfo = mq.getContext().getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), com.ss.android.socialbase.appdownloader.b.d());
                if (packageArchiveInfo != null) {
                    str = packageArchiveInfo.packageName;
                }
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.mq.d(e);
            }
        }
        if (!TextUtils.isEmpty(str) && !str.equals(bVar.us())) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("real_package_name", str);
                jSONObject.put("input_package_name", bVar.us());
            } catch (JSONException e2) {
                com.bytedance.sdk.component.utils.mq.d(e2);
            }
            com.ss.android.downloadlib.c.d.d().d("embeded_ad", "package_name_error", jSONObject, hcVar);
            return str;
        }
        return bVar.us();
    }

    @Override // com.ss.android.socialbase.downloader.d.d.InterfaceC0785d
    public void hc() {
        com.ss.android.socialbase.downloader.an.d.hc(d, "onAppForeground()");
        c();
        d(5);
    }

    @Override // com.ss.android.socialbase.downloader.d.d.InterfaceC0785d
    public void b() {
        com.ss.android.socialbase.downloader.an.d.hc(d, "onAppBackground()");
        d(6);
    }

    synchronized void c() {
        hc hcVar = this.b;
        if (hcVar != null) {
            hcVar.hc();
            this.b = null;
        }
    }

    @Override // com.ss.android.hc.d.d
    public void d(int i) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.hc < 120000) {
            return;
        }
        u.d().d(new RunnableC0754d(i), this.hc > 0 ? 2000L : 8000L);
        this.hc = jCurrentTimeMillis;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ConcurrentHashMap<Long, com.ss.android.hc.d.hc.hc> concurrentHashMap, int i) throws JSONException {
        ArrayList arrayList = new ArrayList();
        long jCurrentTimeMillis = System.currentTimeMillis();
        for (com.ss.android.hc.d.hc.hc hcVar : concurrentHashMap.values()) {
            if (hcVar.b.get()) {
                if (jCurrentTimeMillis - hcVar.ba() >= com.ss.android.socialbase.downloader.uo.d.d(hcVar.rf()).d("start_event_expire_hours", 168) * 60 * 60 * 1000) {
                    arrayList.add(Long.valueOf(hcVar.hc()));
                }
            } else if (hcVar.fs() == 1) {
                if (hc(hcVar) <= 0 && jCurrentTimeMillis - hcVar.ba() >= com.ss.android.socialbase.downloader.uo.d.d(hcVar.rf()).d("start_event_expire_hours", 168) * 60 * 60 * 1000) {
                    arrayList.add(Long.valueOf(hcVar.hc()));
                }
            } else if (hcVar.fs() == 2) {
                if (!hcVar.ra()) {
                    if (com.ss.android.downloadlib.h.uo.hc(hcVar)) {
                        if (hcVar.hv() == 4) {
                            i = hcVar.hv();
                            com.ss.android.d.d.hc.mk mkVarDe = mq.de();
                            if (mkVarDe != null) {
                                mkVarDe.d(hcVar.sy());
                            }
                        }
                        hcVar.tc(false);
                        com.ss.android.downloadlib.c.d.d().d(d(hcVar, hcVar.u(), i), hcVar);
                        arrayList.add(Long.valueOf(hcVar.hc()));
                        com.ss.android.downloadlib.addownload.b.c.d(hcVar);
                    } else if (hcVar.ra() && hcVar.hv() == 4 && i == 1 && !com.ss.android.downloadlib.h.uo.hc(hcVar)) {
                        com.ss.android.downloadlib.h.mq.d().d(d, "trySendAndRefreshAdEvent", "命中兜底逻辑,尝试对广播监听执行冷启兜底逻辑");
                        tt.d().d(hcVar);
                    } else if (jCurrentTimeMillis - hcVar.ba() >= com.ss.android.socialbase.downloader.uo.d.d(hcVar.rf()).d("finish_event_expire_hours", 168) * 60 * 60 * 1000) {
                        arrayList.add(Long.valueOf(hcVar.hc()));
                    } else if (TextUtils.isEmpty(hcVar.u())) {
                        arrayList.add(Long.valueOf(hcVar.hc()));
                    }
                }
            } else {
                arrayList.add(Long.valueOf(hcVar.hc()));
            }
        }
        com.ss.android.downloadlib.addownload.hc.an.d().d(arrayList);
    }

    @Override // com.ss.android.socialbase.appdownloader.hc.b
    public void d(com.ss.android.socialbase.downloader.h.b bVar, com.ss.android.socialbase.appdownloader.d dVar) {
        JSONObject jSONObjectHc;
        if (bVar == null || dVar == null) {
            return;
        }
        JSONArray jSONArrayU = com.ss.android.socialbase.downloader.uo.d.d(bVar.h()).u("ah_report_config");
        if (dVar.hc != 0) {
            bVar.a().remove("intent");
        }
        if (jSONArrayU == null || (jSONObjectHc = hc(bVar, dVar)) == null) {
            return;
        }
        bVar.a().put("ah_ext_json", jSONObjectHc);
    }

    @Override // com.ss.android.socialbase.downloader.c.mt
    public void d(final com.ss.android.socialbase.downloader.h.b bVar, String str) throws JSONException {
        if (bVar == null) {
            com.ss.android.downloadlib.u.b.d().d("info is null");
        } else if ((com.ss.android.socialbase.downloader.uo.d.d(bVar).hc("check_applink_mode") & 2) != 0) {
            final JSONObject jSONObject = (JSONObject) bVar.a().get("ah_ext_json");
            com.ss.android.downloadlib.hc.u.d().hc(new com.ss.android.downloadlib.hc.c() { // from class: com.ss.android.downloadlib.d.4
                @Override // com.ss.android.downloadlib.hc.c
                public void d(boolean z) throws JSONException {
                    if (!z) {
                        Intent intent = (Intent) bVar.a().get("intent");
                        if (intent != null) {
                            bVar.a().remove("intent");
                            com.ss.android.socialbase.appdownloader.b.d(mq.getContext(), intent);
                            com.ss.android.downloadlib.h.uo.d(jSONObject, LiveConfigKey.BACKUP, (Object) 1);
                        } else {
                            com.ss.android.downloadlib.h.uo.d(jSONObject, LiveConfigKey.BACKUP, (Object) 2);
                        }
                    }
                    com.ss.android.hc.d.hc.hc hcVarD = com.ss.android.downloadlib.addownload.hc.an.d().d(bVar);
                    if (hcVarD != null) {
                        com.ss.android.downloadlib.c.d.d().d(z ? "installer_delay_success" : "installer_delay_failed", jSONObject, hcVarD);
                    } else {
                        com.ss.android.downloadlib.u.b.d().hc("ah nativeModel=null");
                    }
                    if (z) {
                        mq.sy();
                        mq.getContext();
                    }
                }
            });
        }
    }

    private int hc(com.ss.android.hc.d.hc.hc hcVar) {
        int iV;
        double d2 = com.ss.android.socialbase.downloader.uo.d.d(hcVar.rf()).d("download_failed_finally_hours", 48.0d);
        if (d2 <= 0.0d) {
            return -1;
        }
        if (System.currentTimeMillis() - hcVar.ba() < d2 * 60.0d * 60.0d * 1000.0d) {
            return 1;
        }
        if (hcVar.c.get()) {
            return 0;
        }
        com.ss.android.socialbase.downloader.h.b bVarGb = com.ss.android.socialbase.downloader.downloader.h.hc(mq.getContext()).gb(hcVar.rf());
        if (bVarGb == null || (iV = bVarGb.v()) == -3 || iV == -4) {
            return -1;
        }
        if (!com.ss.android.socialbase.downloader.hc.an.hc(iV) && hcVar.c.compareAndSet(false, true)) {
            try {
                JSONObject jSONObject = new JSONObject();
                d(jSONObject, bVarGb);
                jSONObject.putOpt("download_status", Integer.valueOf(iV));
                jSONObject.putOpt("fail_status", Integer.valueOf(hcVar.us()));
                jSONObject.putOpt("fail_msg", hcVar.z());
                jSONObject.put("download_failed_times", hcVar.np());
                if (bVarGb.mb() > 0) {
                    jSONObject.put("download_percent", bVarGb.js() / bVarGb.mb());
                }
                jSONObject.put("is_update_download", hcVar.fu() ? 1 : 2);
                com.ss.android.downloadlib.c.d.d().d(hcVar.tc(), "download_failed_finally", jSONObject, hcVar);
                com.ss.android.downloadlib.addownload.hc.tt.d().d(hcVar);
                return 0;
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.mq.d(th);
            }
        }
        return 1;
    }

    private JSONObject hc(com.ss.android.socialbase.downloader.h.b bVar, com.ss.android.socialbase.appdownloader.d dVar) throws JSONException {
        com.ss.android.hc.d.hc.hc hcVarD = com.ss.android.downloadlib.addownload.hc.an.d().d(bVar);
        if (hcVarD == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        dVar.d(jSONObject);
        try {
            jSONObject.put("download_id", bVar.h());
            jSONObject.put("name", bVar.gb());
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.mq.d(th);
        }
        com.ss.android.downloadlib.h.an.d(jSONObject, bVar.h());
        com.ss.android.downloadlib.c.d.d().d("embeded_ad", "ah_result", jSONObject, hcVarD);
        return jSONObject;
    }

    /* renamed from: com.ss.android.downloadlib.d$d, reason: collision with other inner class name */
    private class RunnableC0754d implements Runnable {
        private final int hc;

        public RunnableC0754d(int i) {
            this.hc = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.ss.android.downloadlib.addownload.hc.an.d().hc();
                ConcurrentHashMap<Long, com.ss.android.hc.d.hc.hc> concurrentHashMapB = com.ss.android.downloadlib.addownload.hc.an.d().b();
                if (concurrentHashMapB == null || concurrentHashMapB.isEmpty()) {
                    return;
                }
                d.this.d(concurrentHashMapB, this.hc);
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.mq.d(e);
            }
        }
    }

    private JSONObject d(com.ss.android.hc.d.hc.hc hcVar, String str, int i) {
        com.ss.android.socialbase.appdownloader.d dVarD;
        JSONObject jSONObject = new JSONObject();
        try {
            com.ss.android.socialbase.downloader.h.b bVarGb = com.ss.android.socialbase.downloader.downloader.h.hc(mq.getContext()).gb(hcVar.rf());
            jSONObject.putOpt("scene", Integer.valueOf(i));
            com.ss.android.downloadlib.h.an.d(jSONObject, hcVar.rf());
            com.ss.android.downloadlib.h.an.d(hcVar, jSONObject);
            jSONObject.put("is_update_download", hcVar.fu() ? 1 : 2);
            jSONObject.put("install_after_back_app", hcVar.nw() ? 1 : 2);
            jSONObject.putOpt("clean_space_install_params", hcVar.q() ? "1" : "2");
            if (bVarGb != null) {
                d(jSONObject, bVarGb);
                try {
                    jSONObject.put("uninstall_resume_count", bVarGb.tb());
                    if (hcVar.j() > 0) {
                        long jCurrentTimeMillis = System.currentTimeMillis() - hcVar.j();
                        jSONObject.put("install_time", jCurrentTimeMillis);
                        if (jCurrentTimeMillis > com.ss.android.socialbase.downloader.uo.d.d(bVarGb.h()).d("check_install_finish_expired_duration", 86400000L)) {
                            jSONObject.put("install_expired", 1);
                        } else {
                            jSONObject.put("install_expired", 0);
                        }
                    }
                } catch (Throwable unused) {
                }
                String strD = com.ss.android.socialbase.downloader.e.an.d(bVarGb.a().get("ah_attempt"), (String) null);
                if (!TextUtils.isEmpty(strD) && (dVarD = com.ss.android.socialbase.appdownloader.d.d(strD)) != null) {
                    dVarD.d(jSONObject);
                }
            }
            int iD = d(hcVar, bVarGb, str, jSONObject);
            jSONObject.put("fail_status", iD);
            if (iD == 3000) {
                jSONObject.put("hijack", 2);
            } else if (iD == 3001) {
                jSONObject.put("hijack", 0);
            } else {
                jSONObject.put("hijack", 1);
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.mq.d(th);
        }
        return jSONObject;
    }

    public void d(com.ss.android.socialbase.downloader.h.b bVar, long j, long j2, long j3, long j4, long j5, boolean z) throws JSONException {
        com.ss.android.hc.d.hc.hc hcVarD = com.ss.android.downloadlib.addownload.hc.an.d().d(bVar);
        if (hcVarD == null) {
            com.ss.android.downloadlib.u.b.d().d("trySendClearSpaceEvent nativeModel null");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("space_before", Double.valueOf(j / 1048576.0d));
            jSONObject.putOpt("space_cleaned", Double.valueOf((j2 - j) / 1048576.0d));
            jSONObject.putOpt("clean_up_time_cost", Long.valueOf(j4));
            jSONObject.putOpt("is_download_restarted", Integer.valueOf(z ? 1 : 0));
            jSONObject.putOpt("byte_required", Long.valueOf(j3));
            jSONObject.putOpt("byte_required_after", Double.valueOf((j3 - j2) / 1048576.0d));
            jSONObject.putOpt("clear_sleep_time", Long.valueOf(j5));
            com.ss.android.downloadlib.h.an.b(bVar, jSONObject);
            com.ss.android.downloadlib.c.d.d().d("cleanup", jSONObject, hcVarD);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.mq.d(e);
        }
    }
}
