package com.kwai.video.ksvodplayerkit.prefetcher;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class PrefetchReportInfo_JsonUtils {
    public static PrefetchReportInfo fromJson(String str) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(str);
        } catch (Exception unused) {
            jSONObject = null;
        }
        if (jSONObject == null) {
            return null;
        }
        PrefetchReportInfo prefetchReportInfo = new PrefetchReportInfo();
        prefetchReportInfo.fillPreload = jSONObject.optBoolean("fill_preload", prefetchReportInfo.fillPreload);
        prefetchReportInfo.preloadUrl = jSONObject.optString("preload_url", prefetchReportInfo.preloadUrl);
        prefetchReportInfo.downloadBytes = jSONObject.optLong("download_bytes", prefetchReportInfo.downloadBytes);
        prefetchReportInfo.preloadBytes = jSONObject.optLong("preload_bytes", prefetchReportInfo.preloadBytes);
        return prefetchReportInfo;
    }

    public static PrefetchReportInfo fromJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        PrefetchReportInfo prefetchReportInfo = new PrefetchReportInfo();
        prefetchReportInfo.fillPreload = jSONObject.optBoolean("fill_preload", prefetchReportInfo.fillPreload);
        prefetchReportInfo.preloadUrl = jSONObject.optString("preload_url", prefetchReportInfo.preloadUrl);
        prefetchReportInfo.downloadBytes = jSONObject.optLong("download_bytes", prefetchReportInfo.downloadBytes);
        prefetchReportInfo.preloadBytes = jSONObject.optLong("preload_bytes", prefetchReportInfo.preloadBytes);
        return prefetchReportInfo;
    }

    public static String toJson(PrefetchReportInfo prefetchReportInfo) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("fill_preload", prefetchReportInfo.fillPreload);
        } catch (Exception unused) {
        }
        try {
            jSONObject.put("preload_url", prefetchReportInfo.preloadUrl);
        } catch (Exception unused2) {
        }
        try {
            jSONObject.put("download_bytes", prefetchReportInfo.downloadBytes);
        } catch (Exception unused3) {
        }
        try {
            jSONObject.put("preload_bytes", prefetchReportInfo.preloadBytes);
        } catch (Exception unused4) {
        }
        return jSONObject.toString();
    }
}
