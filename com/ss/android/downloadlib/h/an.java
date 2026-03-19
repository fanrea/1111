package com.ss.android.downloadlib.h;

import com.baidu.mobstat.forbes.Config;
import com.kwai.player.qos.KwaiQosInfo;
import com.ss.android.socialbase.appdownloader.h;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class an {
    public static void d(com.ss.android.socialbase.downloader.h.b bVar, JSONObject jSONObject) {
        try {
            b(bVar, jSONObject);
            com.ss.android.hc.d.hc.hc hcVarD = com.ss.android.downloadlib.addownload.hc.an.d().d(bVar);
            if (hcVarD == null) {
                return;
            }
            jSONObject.put("is_update_download", hcVarD.fu() ? 1 : 2);
            d(hcVarD, jSONObject);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.mq.d(th);
        }
    }

    public static void hc(com.ss.android.socialbase.downloader.h.b bVar, JSONObject jSONObject) {
        com.ss.android.hc.d.hc.hc hcVarD;
        if (jSONObject == null || (hcVarD = com.ss.android.downloadlib.addownload.hc.an.d().d(bVar)) == null) {
            return;
        }
        try {
            b(bVar, jSONObject);
            jSONObject.putOpt("time_after_click", Long.valueOf(System.currentTimeMillis() - hcVarD.yn()));
            jSONObject.putOpt("click_download_size", Long.valueOf(hcVarD.l()));
            jSONObject.putOpt("download_length", Long.valueOf(bVar.js()));
            jSONObject.putOpt("download_apk_size", Long.valueOf(bVar.mb()));
            hcVarD.vv();
            com.ss.android.downloadlib.addownload.hc.tt.d().d(hcVarD);
            jSONObject.put("click_pause_times", hcVarD.he());
            long jMb = bVar.mb();
            long jJs = bVar.js();
            jSONObject.put("download_percent", (jJs < 0 || jMb <= 0) ? 0.0d : jJs / jMb);
            jSONObject.put("download_status", bVar.v());
            long jCurrentTimeMillis = System.currentTimeMillis();
            long jBa = hcVarD.ba();
            if (jBa > 0) {
                jSONObject.put("time_from_start_download", jCurrentTimeMillis - jBa);
            }
            long jZw = hcVarD.zw();
            if (jZw > 0) {
                jSONObject.put("time_from_download_resume", jCurrentTimeMillis - jZw);
            }
            jSONObject.putOpt("fail_status", Integer.valueOf(hcVarD.us()));
            jSONObject.putOpt("fail_msg", hcVarD.z());
            jSONObject.put("download_failed_times", hcVarD.np());
            jSONObject.put("can_show_notification", com.ss.android.socialbase.appdownloader.u.c.d() ? 1 : 2);
            jSONObject.put("first_speed_time", bVar.yi());
            jSONObject.put("all_connect_time", bVar.zw());
            jSONObject.put("download_prepare_time", bVar.j());
            jSONObject.put("download_time", bVar.cw() + bVar.zw() + bVar.j());
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.mq.d(th);
        }
    }

    public static void b(com.ss.android.socialbase.downloader.h.b bVar, JSONObject jSONObject) {
        if (bVar != null) {
            try {
                jSONObject.putOpt(KwaiQosInfo.TOTAL_BYTES, Long.valueOf(bVar.mb()));
                jSONObject.putOpt("cur_bytes", Long.valueOf(bVar.js()));
                jSONObject.putOpt("chunk_count", Integer.valueOf(bVar.fj()));
                jSONObject.putOpt("app_name", bVar.tt());
                jSONObject.putOpt("network_quality", bVar.f());
                jSONObject.putOpt("save_path", bVar.mk());
                jSONObject.putOpt("file_name", bVar.gb());
                jSONObject.putOpt("download_status", Integer.valueOf(bVar.v()));
                com.ss.android.hc.d.hc.hc hcVarD = com.ss.android.downloadlib.addownload.hc.an.d().d(bVar.h());
                if (hcVarD != null) {
                    jSONObject.putOpt("click_download_time", Long.valueOf(hcVarD.yn()));
                    jSONObject.putOpt("click_download_size", Long.valueOf(hcVarD.l()));
                }
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.mq.d(e);
                return;
            }
        }
        int i = 1;
        jSONObject.putOpt("permission_notification", Integer.valueOf(com.ss.android.socialbase.appdownloader.u.c.d() ? 1 : 2));
        jSONObject.putOpt("network_available", Integer.valueOf(com.ss.android.socialbase.downloader.e.an.b(com.ss.android.downloadlib.addownload.mq.getContext()) ? 1 : 2));
        if (!com.ss.android.socialbase.downloader.e.an.hc(com.ss.android.downloadlib.addownload.mq.getContext())) {
            i = 2;
        }
        jSONObject.putOpt("network_is_wifi", Integer.valueOf(i));
    }

    public static void d(com.ss.android.hc.d.hc.hc hcVar, JSONObject jSONObject) {
        if (jSONObject == null || hcVar == null) {
            return;
        }
        try {
            jSONObject.put("is_patch_apply_handled", hcVar.to() ? 1 : 0);
            jSONObject.put("origin_mime_type", hcVar.xp());
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.mq.d(th);
        }
    }

    public static void d(JSONObject jSONObject, int i) {
        if (jSONObject == null) {
            return;
        }
        JSONArray jSONArrayU = com.ss.android.socialbase.downloader.uo.d.d(i).u("ah_report_config");
        if (jSONArrayU != null) {
            for (int i2 = 0; i2 < jSONArrayU.length(); i2++) {
                try {
                    String string = jSONArrayU.getString(i2);
                    h.d dVarD = com.ss.android.socialbase.appdownloader.an.d.d(string);
                    if (dVarD != null) {
                        jSONObject.put(string.replaceAll("\\.", Config.replace), dVarD.an() + Config.replace + dVarD.h());
                    }
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.mq.d(th);
                }
            }
        }
        try {
            jSONObject.put("is_unknown_source_enabled", com.ss.android.socialbase.appdownloader.hc.d(com.ss.android.socialbase.downloader.downloader.b.tr()) ? 1 : 2);
        } catch (Throwable unused) {
        }
    }

    public static JSONObject d(JSONObject jSONObject, com.ss.android.hc.d.hc.d dVar) throws JSONException {
        uo.d(jSONObject, "open_url", uo.d(dVar.an(), "open_url_not_exist"));
        return jSONObject;
    }

    public static JSONObject hc(JSONObject jSONObject, com.ss.android.hc.d.hc.d dVar) {
        uo.d(jSONObject, com.ss.android.socialbase.appdownloader.an.u.tc().replaceAll("\\.", Config.replace) + " versionCode", Integer.valueOf(uo.hc(com.ss.android.downloadlib.addownload.mq.getContext(), com.ss.android.socialbase.appdownloader.an.u.tc())));
        uo.d(jSONObject, com.ss.android.socialbase.appdownloader.an.u.tc().replaceAll("\\.", Config.replace) + " versionName", uo.b(com.ss.android.downloadlib.addownload.mq.getContext(), com.ss.android.socialbase.appdownloader.an.u.tc()));
        return jSONObject;
    }

    public static void d(JSONObject jSONObject) {
        try {
            jSONObject.putOpt("harmony_api_version", com.ss.android.socialbase.appdownloader.an.c.d());
            jSONObject.putOpt("harmony_release_type", com.ss.android.socialbase.appdownloader.an.c.b());
            jSONObject.putOpt("harmony_build_version", com.ss.android.socialbase.appdownloader.an.c.c());
            int i = 1;
            jSONObject.putOpt("pure_mode", Integer.valueOf(com.ss.android.socialbase.appdownloader.an.c.d(com.ss.android.downloadlib.addownload.mq.getContext()) ? 1 : 2));
            jSONObject.putOpt("pure_mode_enable", Integer.valueOf(com.ss.android.socialbase.appdownloader.an.c.u() ? 1 : 2));
            jSONObject.putOpt("harmony_version", com.ss.android.socialbase.appdownloader.an.c.hc());
            jSONObject.putOpt("pure_enhanced_mode", Integer.valueOf(com.ss.android.socialbase.appdownloader.an.c.hc(com.ss.android.downloadlib.addownload.mq.getContext()) ? 1 : 2));
            if (!com.ss.android.socialbase.appdownloader.an.c.an()) {
                i = 2;
            }
            jSONObject.putOpt("pure_enhanced_mode_enable", Integer.valueOf(i));
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.mq.d(e);
        }
    }
}
