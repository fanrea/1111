package com.ss.android.socialbase.downloader.gb;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.mq;
import com.bytedance.sdk.djx.core.log.ILogConst;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.kwai.player.qos.KwaiQosInfo;
import com.ss.android.socialbase.downloader.c.e;
import com.ss.android.socialbase.downloader.c.zw;
import com.ss.android.socialbase.downloader.downloader.yo;
import com.ss.android.socialbase.downloader.h.c;
import com.ss.android.socialbase.downloader.hc.an;
import com.ss.android.socialbase.downloader.tt.tt;
import com.ss.android.socialbase.downloader.tt.u;
import com.ss.android.socialbase.downloader.u.gb;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class d {
    public static void d(c cVar, com.ss.android.socialbase.downloader.u.d dVar, int i) {
        if (cVar == null) {
            return;
        }
        try {
            com.ss.android.socialbase.downloader.h.b bVarD = cVar.d();
            if (bVarD == null) {
                return;
            }
            zw zwVarU = cVar.u();
            boolean zB = an.b(i);
            if (!zB && !(zB = d(bVarD.ar(), i)) && zwVarU != null && (zwVarU instanceof com.ss.android.socialbase.downloader.c.c)) {
                zB = d(((com.ss.android.socialbase.downloader.c.c) zwVarU).d(), i);
            }
            if (zB) {
                try {
                    e eVarC = cVar.c();
                    if (eVarC != null) {
                        eVarC.d(bVarD, dVar, i);
                    }
                } catch (Throwable th) {
                    mq.d(th);
                }
                d(zwVarU, bVarD, dVar, i);
                d(com.ss.android.socialbase.downloader.downloader.b.an(), bVarD, dVar, i);
            }
        } catch (Throwable th2) {
            mq.d(th2);
        }
    }

    private static boolean d(int[] iArr, int i) {
        if (iArr != null && iArr.length > 0) {
            for (int i2 : iArr) {
                if (i == i2) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void d(zw zwVar, com.ss.android.socialbase.downloader.h.b bVar, com.ss.android.socialbase.downloader.u.d dVar, int i) {
        if (zwVar == null) {
            return;
        }
        try {
            String strHc = zwVar.hc();
            if (TextUtils.isEmpty(strHc)) {
                strHc = ILogConst.PLAY_SOURCE_DEFAULT;
            }
            JSONObject jSONObjectD = d(strHc, bVar, dVar, i);
            if (jSONObjectD == null) {
                jSONObjectD = new JSONObject();
            }
            zwVar.d(jSONObjectD);
        } catch (Throwable unused) {
        }
    }

    public static void d(hc hcVar, com.ss.android.socialbase.downloader.h.b bVar, com.ss.android.socialbase.downloader.u.d dVar, int i) {
        if (hcVar == null || !bVar.ey() || TextUtils.isEmpty(bVar.qr())) {
            return;
        }
        try {
            JSONObject jSONObjectD = d(bVar.qr(), bVar, dVar, i);
            if (jSONObjectD == null) {
                jSONObjectD = new JSONObject();
            }
            if (i == -1) {
                jSONObjectD.put("status", dVar.d());
            } else {
                d(i, jSONObjectD, bVar);
            }
        } catch (Throwable th) {
            mq.d(th);
        }
    }

    private static void d(int i, JSONObject jSONObject, com.ss.android.socialbase.downloader.h.b bVar) throws JSONException {
        String str;
        if (i == -5) {
            str = "download_uncomplete";
        } else if (i == -4) {
            str = "download_cancel";
        } else if (i != -3) {
            str = i != -2 ? i != 0 ? i != 2 ? i != 6 ? "" : "download_first_start" : "download_start" : "download_create" : "download_pause";
        } else {
            double dTl = bVar.tl();
            if (dTl >= 0.0d) {
                jSONObject.put("download_speed", dTl);
            }
            str = "download_success";
        }
        jSONObject.put("status", str);
    }

    public static String d(String str) {
        try {
            return TextUtils.isDigitsOnly(str) ? String.valueOf(Long.valueOf(str).longValue() % 100) : "";
        } catch (Exception e) {
            mq.d(e);
            return "";
        }
    }

    private static JSONObject d(String str, com.ss.android.socialbase.downloader.h.b bVar, com.ss.android.socialbase.downloader.u.d dVar, int i) throws JSONException {
        JSONObject jSONObject;
        String strHc;
        String strD;
        String strD2;
        int iB;
        String lastPathSegment;
        String host;
        String path;
        JSONObject jSONObject2 = null;
        try {
            jSONObject = new JSONObject();
        } catch (JSONException e) {
            e = e;
        }
        try {
            yo yoVarTc = com.ss.android.socialbase.downloader.downloader.b.tc();
            if (yoVarTc != null) {
                strHc = yoVarTc.hc();
                strD = d(strHc);
                strD2 = yoVarTc.d();
                iB = yoVarTc.b();
            } else {
                strHc = "";
                strD = strHc;
                strD2 = strD;
                iB = 0;
            }
            String strC = (dVar == null || !(dVar instanceof gb)) ? "" : ((gb) dVar).c();
            jSONObject.put("event_page", str);
            jSONObject.put(com.alipay.sdk.m.k.b.D0, strD2);
            jSONObject.put(com.baidu.mobads.upgrade.remote.gray.c.l, strHc);
            jSONObject.put("device_id_postfix", strD);
            jSONObject.put("update_version", iB);
            jSONObject.put("download_status", i);
            if (bVar != null) {
                jSONObject.put("setting_tag", com.ss.android.socialbase.downloader.uo.d.d(bVar.h()).b("setting_tag"));
                jSONObject.put("download_id", bVar.h());
                jSONObject.put("name", bVar.gb());
                jSONObject.put("url", bVar.tc());
                jSONObject.put("save_path", bVar.mk());
                jSONObject.put("download_time", bVar.pa());
                jSONObject.put("cur_bytes", bVar.js());
                jSONObject.put(KwaiQosInfo.TOTAL_BYTES, bVar.mb());
                jSONObject.put("network_quality", bVar.f());
                int i2 = 1;
                jSONObject.put("only_wifi", bVar.np() ? 1 : 0);
                jSONObject.put("need_https_degrade", bVar.gu() ? 1 : 0);
                jSONObject.put("https_degrade_retry_used", bVar.jh() ? 1 : 0);
                jSONObject.put(TKDownloadReason.KSAD_TK_MD5, bVar.fs() == null ? "" : bVar.fs());
                jSONObject.put("chunk_count", bVar.fj());
                jSONObject.put("is_force", bVar.fv() ? 1 : 0);
                jSONObject.put("retry_count", bVar.hv());
                jSONObject.put("cur_retry_time", bVar.ec());
                jSONObject.put("need_retry_delay", bVar.ho() ? 1 : 0);
                jSONObject.put("need_reuse_first_connection", bVar.qy() ? 1 : 0);
                jSONObject.put("default_http_service_backup", bVar.e() ? 1 : 0);
                jSONObject.put("retry_delay_status", bVar.eu().ordinal());
                jSONObject.put("backup_url_used", bVar.wl() ? 1 : 0);
                jSONObject.put("download_byte_error_retry_status", bVar.wb().ordinal());
                jSONObject.put("forbidden_handler_status", bVar.qv().ordinal());
                jSONObject.put("need_independent_process", bVar.nf() ? 1 : 0);
                jSONObject.put("head_connection_error_msg", bVar.b() != null ? bVar.b() : "");
                jSONObject.put("extra", bVar.s() != null ? bVar.s() : "");
                if (!bVar.um()) {
                    i2 = 0;
                }
                jSONObject.put("add_listener_to_same_task", i2);
                jSONObject.put("backup_url_count", bVar.uq() != null ? bVar.uq().size() : 0);
                jSONObject.put("cur_backup_url_index", bVar.uq() != null ? bVar.rf() : -1);
                jSONObject.put("forbidden_urls", bVar.nv() != null ? bVar.nv().toString() : "");
                jSONObject.put("task_id", TextUtils.isEmpty(bVar.zk()) ? "" : bVar.zk());
                try {
                    String strTc = bVar.tc();
                    if (TextUtils.isEmpty(strTc)) {
                        lastPathSegment = "";
                        host = lastPathSegment;
                        path = host;
                    } else {
                        Uri uri = Uri.parse(strTc);
                        host = uri.getHost();
                        path = uri.getPath();
                        lastPathSegment = uri.getLastPathSegment();
                        if (!TextUtils.isEmpty(path) && !TextUtils.isEmpty(lastPathSegment)) {
                            try {
                                path = path.substring(0, path.length() - lastPathSegment.length());
                            } catch (Throwable th) {
                                mq.d(th);
                            }
                        }
                    }
                    jSONObject.put("url_host", host);
                    jSONObject.put("url_path", path);
                    jSONObject.put("url_last_path_segment", lastPathSegment);
                } catch (Throwable th2) {
                    mq.d(th2);
                }
            }
            jSONObject.put("error_code", dVar != null ? dVar.d() : 0);
            jSONObject.put("error_msg", dVar != null ? dVar.hc() : "");
            jSONObject.put("request_log", strC);
            return jSONObject;
        } catch (JSONException e2) {
            e = e2;
            jSONObject2 = jSONObject;
            mq.d(e);
            return jSONObject2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x003d A[PHI: r7
  0x003d: PHI (r7v8 int) = (r7v0 int), (r7v2 int) binds: [B:12:0x0024, B:19:0x0032] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void d(com.ss.android.socialbase.downloader.tt.h r13, java.lang.String r14, java.lang.String r15, long r16, java.lang.String r18, int r19, java.io.IOException r20, com.ss.android.socialbase.downloader.h.b r21) {
        /*
            Method dump skipped, instructions count: 316
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.gb.d.d(com.ss.android.socialbase.downloader.tt.h, java.lang.String, java.lang.String, long, java.lang.String, int, java.io.IOException, com.ss.android.socialbase.downloader.h.b):void");
    }

    public static void d(com.ss.android.socialbase.downloader.uo.d dVar, com.ss.android.socialbase.downloader.h.b bVar, String str, tt ttVar, boolean z, boolean z2, com.ss.android.socialbase.downloader.u.d dVar2, long j, long j2, boolean z3, long j3, long j4, long j5, JSONObject jSONObject) {
        d("download_io", dVar.hc("monitor_download_io"), dVar, bVar, str, null, null, ttVar, z, z2, dVar2, j, j2, z3, j3, j4, j5, null);
    }

    public static void d(com.ss.android.socialbase.downloader.uo.d dVar, com.ss.android.socialbase.downloader.h.b bVar, String str, String str2, String str3, boolean z, tt ttVar, com.ss.android.socialbase.downloader.u.d dVar2, long j, long j2) {
        d("segment_io", dVar.hc("monitor_segment_io"), dVar, bVar, str, str2, str3, ttVar, z, false, dVar2, j, j2, false, -1L, -1L, -1L, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v2 */
    /* JADX WARN: Type inference failed for: r16v4 */
    private static void d(String str, int i, com.ss.android.socialbase.downloader.uo.d dVar, com.ss.android.socialbase.downloader.h.b bVar, String str2, String str3, String str4, tt ttVar, boolean z, boolean z2, com.ss.android.socialbase.downloader.u.d dVar2, long j, long j2, boolean z3, long j3, long j4, long j5, JSONObject jSONObject) {
        String strHc;
        int iD;
        String strAn;
        long j6;
        int i2;
        int i3;
        if (i <= 0 || j2 <= 0) {
            return;
        }
        try {
            Uri uri = Uri.parse(str2);
            String host = uri.getHost();
            String path = uri.getPath();
            String lastPathSegment = uri.getLastPathSegment();
            if (!TextUtils.isEmpty(path) && !TextUtils.isEmpty(lastPathSegment)) {
                try {
                    path = path.substring(0, path.length() - lastPathSegment.length());
                } catch (Throwable unused) {
                }
            }
            if (z) {
                strHc = null;
                iD = 1;
            } else if (z2) {
                strHc = null;
                iD = 2;
            } else if (dVar2 != null) {
                iD = !com.ss.android.socialbase.downloader.e.an.b(com.ss.android.socialbase.downloader.downloader.b.tr()) ? 1049 : dVar2.d();
                strHc = dVar2.hc();
            } else {
                strHc = null;
                iD = 0;
            }
            JSONObject jSONObject2 = new JSONObject();
            strAn = "";
            if (ttVar != null) {
                i3 = ttVar instanceof u ? 0 : 1;
                String strD = ttVar.d("X-Cache");
                ?? Contains = TextUtils.isEmpty(strD) ? -1 : strD.toLowerCase().contains("hit");
                dVar.d("monitor_sla", 1);
                strAn = ttVar instanceof com.ss.android.socialbase.downloader.tt.d ? ((com.ss.android.socialbase.downloader.tt.d) ttVar).an() : "";
                j6 = j;
                i2 = Contains;
            } else {
                j6 = j;
                i2 = -1;
                i3 = -1;
            }
            double d = j6 / 1048576.0d;
            double d2 = j2;
            double nanos = d2 / TimeUnit.SECONDS.toNanos(1L);
            jSONObject2.put("setting_tag", dVar.b("setting_tag"));
            jSONObject2.put("url_host", host);
            jSONObject2.putOpt("host_ip", str3);
            jSONObject2.putOpt("host_real_ip", str4);
            jSONObject2.put("url_path", path);
            jSONObject2.put("url_last_path_segment", lastPathSegment);
            jSONObject2.put("net_lib", i3);
            jSONObject2.put("hit_cdn_cache", i2);
            jSONObject2.put("status_code", iD);
            jSONObject2.put("request_log", strAn);
            if (strHc != null) {
                jSONObject2.put("error_msg", com.ss.android.socialbase.downloader.e.an.d(strHc, dVar.d("exception_msg_length", 500)));
            }
            jSONObject2.put("download_sec", nanos);
            jSONObject2.put("download_mb", d);
            if (nanos > 0.0d) {
                jSONObject2.put("download_speed", d / nanos);
            }
            if (z3) {
                jSONObject2.put("rw_read_time", j3 / d2);
                jSONObject2.put("rw_write_time", j4 / d2);
                jSONObject2.put("rw_sync_time", j5 / d2);
            }
            jSONObject2.put(ILogConst.Keys.KEY_PKG_NAME, bVar.us());
            jSONObject2.put("name", bVar.tt());
            if (i == 1 || i == 3) {
                com.ss.android.socialbase.downloader.downloader.b.an();
            }
            if (i == 2 || i == 3) {
                com.ss.android.socialbase.downloader.downloader.b.y().d(bVar.h(), str, jSONObject2);
            }
        } catch (Throwable th) {
            mq.d(th);
        }
    }

    public static void d(com.ss.android.socialbase.downloader.h.b bVar, List<com.ss.android.socialbase.downloader.mk.tt> list) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("segments", com.ss.android.socialbase.downloader.mk.tt.d(list));
            jSONObject.put("cur_bytes", bVar.js());
            jSONObject.put(KwaiQosInfo.TOTAL_BYTES, bVar.mb());
            b bVarY = com.ss.android.socialbase.downloader.downloader.b.y();
            if (bVarY != null) {
                bVarY.d(bVar.h(), "segments_error", jSONObject);
            }
        } catch (Throwable th) {
            mq.d(th);
        }
    }
}
