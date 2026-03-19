package com.kwai.video.ksliveplayer.model;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class KSLivePlayerConfigModel_JsonUtils {
    public static KSLivePlayerConfigModel fromJson(String str) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(str);
        } catch (Exception unused) {
            jSONObject = null;
        }
        if (jSONObject == null) {
            return null;
        }
        KSLivePlayerConfigModel kSLivePlayerConfigModel = new KSLivePlayerConfigModel();
        kSLivePlayerConfigModel.normalEnableCache = jSONObject.optBoolean("normalEnableCache", kSLivePlayerConfigModel.normalEnableCache);
        kSLivePlayerConfigModel.adaptiveEnableCache = jSONObject.optBoolean("adaptiveEnableCache", kSLivePlayerConfigModel.adaptiveEnableCache);
        kSLivePlayerConfigModel.cacheReadTimeOutMs = jSONObject.optInt("cacheReadTimeOutMs", kSLivePlayerConfigModel.cacheReadTimeOutMs);
        kSLivePlayerConfigModel.cacheConnectTimeOutMs = jSONObject.optInt("cacheConnectTimeOutMs", kSLivePlayerConfigModel.cacheConnectTimeOutMs);
        kSLivePlayerConfigModel.bufferTimeMaxSec = (float) jSONObject.optDouble("bufferTimeMaxSec", kSLivePlayerConfigModel.bufferTimeMaxSec);
        kSLivePlayerConfigModel.configJson = jSONObject.optString("configJson", kSLivePlayerConfigModel.configJson);
        kSLivePlayerConfigModel.enableAsyncStreamOpen = jSONObject.optInt("enableAsyncStreamOpen", kSLivePlayerConfigModel.enableAsyncStreamOpen);
        kSLivePlayerConfigModel.enableAlignedPts = jSONObject.optBoolean("enableAlignedPts", kSLivePlayerConfigModel.enableAlignedPts);
        kSLivePlayerConfigModel.liveRetryConfig = LiveRetryConfigModel_JsonUtils.fromJson(jSONObject.optJSONObject("retryConfig"));
        return kSLivePlayerConfigModel;
    }

    public static KSLivePlayerConfigModel fromJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        KSLivePlayerConfigModel kSLivePlayerConfigModel = new KSLivePlayerConfigModel();
        kSLivePlayerConfigModel.normalEnableCache = jSONObject.optBoolean("normalEnableCache", kSLivePlayerConfigModel.normalEnableCache);
        kSLivePlayerConfigModel.adaptiveEnableCache = jSONObject.optBoolean("adaptiveEnableCache", kSLivePlayerConfigModel.adaptiveEnableCache);
        kSLivePlayerConfigModel.cacheReadTimeOutMs = jSONObject.optInt("cacheReadTimeOutMs", kSLivePlayerConfigModel.cacheReadTimeOutMs);
        kSLivePlayerConfigModel.cacheConnectTimeOutMs = jSONObject.optInt("cacheConnectTimeOutMs", kSLivePlayerConfigModel.cacheConnectTimeOutMs);
        kSLivePlayerConfigModel.bufferTimeMaxSec = (float) jSONObject.optDouble("bufferTimeMaxSec", kSLivePlayerConfigModel.bufferTimeMaxSec);
        kSLivePlayerConfigModel.configJson = jSONObject.optString("configJson", kSLivePlayerConfigModel.configJson);
        kSLivePlayerConfigModel.enableAsyncStreamOpen = jSONObject.optInt("enableAsyncStreamOpen", kSLivePlayerConfigModel.enableAsyncStreamOpen);
        kSLivePlayerConfigModel.enableAlignedPts = jSONObject.optBoolean("enableAlignedPts", kSLivePlayerConfigModel.enableAlignedPts);
        kSLivePlayerConfigModel.liveRetryConfig = LiveRetryConfigModel_JsonUtils.fromJson(jSONObject.optJSONObject("retryConfig"));
        return kSLivePlayerConfigModel;
    }

    public static String toJson(KSLivePlayerConfigModel kSLivePlayerConfigModel) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("normalEnableCache", kSLivePlayerConfigModel.normalEnableCache);
        } catch (Exception unused) {
        }
        try {
            jSONObject.put("adaptiveEnableCache", kSLivePlayerConfigModel.adaptiveEnableCache);
        } catch (Exception unused2) {
        }
        try {
            jSONObject.put("cacheReadTimeOutMs", kSLivePlayerConfigModel.cacheReadTimeOutMs);
        } catch (Exception unused3) {
        }
        try {
            jSONObject.put("cacheConnectTimeOutMs", kSLivePlayerConfigModel.cacheConnectTimeOutMs);
        } catch (Exception unused4) {
        }
        try {
            jSONObject.put("bufferTimeMaxSec", kSLivePlayerConfigModel.bufferTimeMaxSec);
        } catch (Exception unused5) {
        }
        try {
            jSONObject.put("configJson", kSLivePlayerConfigModel.configJson);
        } catch (Exception unused6) {
        }
        try {
            jSONObject.put("enableAsyncStreamOpen", kSLivePlayerConfigModel.enableAsyncStreamOpen);
        } catch (Exception unused7) {
        }
        try {
            jSONObject.put("enableAlignedPts", kSLivePlayerConfigModel.enableAlignedPts);
        } catch (Exception unused8) {
        }
        try {
            jSONObject.put("retryConfig", LiveRetryConfigModel_JsonUtils.toJson(kSLivePlayerConfigModel.liveRetryConfig));
        } catch (Exception unused9) {
        }
        return jSONObject.toString();
    }
}
