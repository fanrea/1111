package com.kwai.video.ksvodplayerkit.prefetcher;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class KSPrefetcherConfig_JsonUtils {
    public static KSPrefetcherConfig fromJson(String str) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(str);
        } catch (Exception unused) {
            jSONObject = null;
        }
        if (jSONObject == null) {
            return null;
        }
        KSPrefetcherConfig kSPrefetcherConfig = new KSPrefetcherConfig();
        kSPrefetcherConfig.maxConcurrentCount = jSONObject.optInt("maxConcurrentCount", kSPrefetcherConfig.maxConcurrentCount);
        kSPrefetcherConfig.playerLoadThreshold = jSONObject.optLong("playerLoadThreshold", kSPrefetcherConfig.playerLoadThreshold);
        kSPrefetcherConfig.speedKbpsThreshold = jSONObject.optInt("speedKbpsThreshold", kSPrefetcherConfig.speedKbpsThreshold);
        kSPrefetcherConfig.preloadBytesWifi = jSONObject.optLong("preloadBytesWifi", kSPrefetcherConfig.preloadBytesWifi);
        kSPrefetcherConfig.secondPreloadBytesWifi = jSONObject.optLong("secondPreloadBytesWifi", kSPrefetcherConfig.secondPreloadBytesWifi);
        kSPrefetcherConfig.preloadBytes4G = jSONObject.optLong("preloadBytes4G", kSPrefetcherConfig.preloadBytes4G);
        kSPrefetcherConfig.secondPreloadBytes4G = jSONObject.optLong("secondPreloadBytes4G", kSPrefetcherConfig.secondPreloadBytes4G);
        kSPrefetcherConfig.preloadMsWifi = jSONObject.optInt("preloadMsWifi", kSPrefetcherConfig.preloadMsWifi);
        kSPrefetcherConfig.secondPreloadMsWifi = jSONObject.optInt("secondPreloadMsWifi", kSPrefetcherConfig.secondPreloadMsWifi);
        kSPrefetcherConfig.preloadMs4G = jSONObject.optInt("preloadMs4G", kSPrefetcherConfig.preloadMs4G);
        kSPrefetcherConfig.secondPreloadMs4G = jSONObject.optInt("secondPreloadMs4G", kSPrefetcherConfig.secondPreloadMs4G);
        kSPrefetcherConfig.vodBufferLowRatio = jSONObject.optDouble("vodBufferLowRatio", kSPrefetcherConfig.vodBufferLowRatio);
        kSPrefetcherConfig.vodPausePreloadMaxCount = jSONObject.optInt("vodPausePreloadMaxCount", kSPrefetcherConfig.vodPausePreloadMaxCount);
        kSPrefetcherConfig.maxSpeedKbps = jSONObject.optInt("maxSpeedKbps", kSPrefetcherConfig.maxSpeedKbps);
        kSPrefetcherConfig.vodCacheKbThresholdKb = jSONObject.optInt("vodCacheKbThresholdKb", kSPrefetcherConfig.vodCacheKbThresholdKb);
        kSPrefetcherConfig.taskLimit = jSONObject.optInt("taskLimit", kSPrefetcherConfig.taskLimit);
        kSPrefetcherConfig.queueLimit = jSONObject.optInt("queueLimit", kSPrefetcherConfig.queueLimit);
        return kSPrefetcherConfig;
    }

    public static KSPrefetcherConfig fromJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        KSPrefetcherConfig kSPrefetcherConfig = new KSPrefetcherConfig();
        kSPrefetcherConfig.maxConcurrentCount = jSONObject.optInt("maxConcurrentCount", kSPrefetcherConfig.maxConcurrentCount);
        kSPrefetcherConfig.playerLoadThreshold = jSONObject.optLong("playerLoadThreshold", kSPrefetcherConfig.playerLoadThreshold);
        kSPrefetcherConfig.speedKbpsThreshold = jSONObject.optInt("speedKbpsThreshold", kSPrefetcherConfig.speedKbpsThreshold);
        kSPrefetcherConfig.preloadBytesWifi = jSONObject.optLong("preloadBytesWifi", kSPrefetcherConfig.preloadBytesWifi);
        kSPrefetcherConfig.secondPreloadBytesWifi = jSONObject.optLong("secondPreloadBytesWifi", kSPrefetcherConfig.secondPreloadBytesWifi);
        kSPrefetcherConfig.preloadBytes4G = jSONObject.optLong("preloadBytes4G", kSPrefetcherConfig.preloadBytes4G);
        kSPrefetcherConfig.secondPreloadBytes4G = jSONObject.optLong("secondPreloadBytes4G", kSPrefetcherConfig.secondPreloadBytes4G);
        kSPrefetcherConfig.preloadMsWifi = jSONObject.optInt("preloadMsWifi", kSPrefetcherConfig.preloadMsWifi);
        kSPrefetcherConfig.secondPreloadMsWifi = jSONObject.optInt("secondPreloadMsWifi", kSPrefetcherConfig.secondPreloadMsWifi);
        kSPrefetcherConfig.preloadMs4G = jSONObject.optInt("preloadMs4G", kSPrefetcherConfig.preloadMs4G);
        kSPrefetcherConfig.secondPreloadMs4G = jSONObject.optInt("secondPreloadMs4G", kSPrefetcherConfig.secondPreloadMs4G);
        kSPrefetcherConfig.vodBufferLowRatio = jSONObject.optDouble("vodBufferLowRatio", kSPrefetcherConfig.vodBufferLowRatio);
        kSPrefetcherConfig.vodPausePreloadMaxCount = jSONObject.optInt("vodPausePreloadMaxCount", kSPrefetcherConfig.vodPausePreloadMaxCount);
        kSPrefetcherConfig.maxSpeedKbps = jSONObject.optInt("maxSpeedKbps", kSPrefetcherConfig.maxSpeedKbps);
        kSPrefetcherConfig.vodCacheKbThresholdKb = jSONObject.optInt("vodCacheKbThresholdKb", kSPrefetcherConfig.vodCacheKbThresholdKb);
        kSPrefetcherConfig.taskLimit = jSONObject.optInt("taskLimit", kSPrefetcherConfig.taskLimit);
        kSPrefetcherConfig.queueLimit = jSONObject.optInt("queueLimit", kSPrefetcherConfig.queueLimit);
        return kSPrefetcherConfig;
    }

    public static String toJson(KSPrefetcherConfig kSPrefetcherConfig) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("maxConcurrentCount", kSPrefetcherConfig.maxConcurrentCount);
        } catch (Exception unused) {
        }
        try {
            jSONObject.put("playerLoadThreshold", kSPrefetcherConfig.playerLoadThreshold);
        } catch (Exception unused2) {
        }
        try {
            jSONObject.put("speedKbpsThreshold", kSPrefetcherConfig.speedKbpsThreshold);
        } catch (Exception unused3) {
        }
        try {
            jSONObject.put("preloadBytesWifi", kSPrefetcherConfig.preloadBytesWifi);
        } catch (Exception unused4) {
        }
        try {
            jSONObject.put("secondPreloadBytesWifi", kSPrefetcherConfig.secondPreloadBytesWifi);
        } catch (Exception unused5) {
        }
        try {
            jSONObject.put("preloadBytes4G", kSPrefetcherConfig.preloadBytes4G);
        } catch (Exception unused6) {
        }
        try {
            jSONObject.put("secondPreloadBytes4G", kSPrefetcherConfig.secondPreloadBytes4G);
        } catch (Exception unused7) {
        }
        try {
            jSONObject.put("preloadMsWifi", kSPrefetcherConfig.preloadMsWifi);
        } catch (Exception unused8) {
        }
        try {
            jSONObject.put("secondPreloadMsWifi", kSPrefetcherConfig.secondPreloadMsWifi);
        } catch (Exception unused9) {
        }
        try {
            jSONObject.put("preloadMs4G", kSPrefetcherConfig.preloadMs4G);
        } catch (Exception unused10) {
        }
        try {
            jSONObject.put("secondPreloadMs4G", kSPrefetcherConfig.secondPreloadMs4G);
        } catch (Exception unused11) {
        }
        try {
            jSONObject.put("vodBufferLowRatio", kSPrefetcherConfig.vodBufferLowRatio);
        } catch (Exception unused12) {
        }
        try {
            jSONObject.put("vodPausePreloadMaxCount", kSPrefetcherConfig.vodPausePreloadMaxCount);
        } catch (Exception unused13) {
        }
        try {
            jSONObject.put("maxSpeedKbps", kSPrefetcherConfig.maxSpeedKbps);
        } catch (Exception unused14) {
        }
        try {
            jSONObject.put("vodCacheKbThresholdKb", kSPrefetcherConfig.vodCacheKbThresholdKb);
        } catch (Exception unused15) {
        }
        try {
            jSONObject.put("taskLimit", kSPrefetcherConfig.taskLimit);
        } catch (Exception unused16) {
        }
        try {
            jSONObject.put("queueLimit", kSPrefetcherConfig.queueLimit);
        } catch (Exception unused17) {
        }
        return jSONObject.toString();
    }
}
