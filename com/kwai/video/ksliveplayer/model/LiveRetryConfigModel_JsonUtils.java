package com.kwai.video.ksliveplayer.model;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveRetryConfigModel_JsonUtils {
    public static LiveRetryConfigModel fromJson(String str) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(str);
        } catch (Exception unused) {
            jSONObject = null;
        }
        if (jSONObject == null) {
            return null;
        }
        LiveRetryConfigModel liveRetryConfigModel = new LiveRetryConfigModel();
        liveRetryConfigModel.emptyReadSizeDuration = jSONObject.optInt("emptyReadSizeDuration", liveRetryConfigModel.emptyReadSizeDuration);
        liveRetryConfigModel.stalledDurationInOneMinute = jSONObject.optInt("stalledDurationInOneMinute", liveRetryConfigModel.stalledDurationInOneMinute);
        liveRetryConfigModel.autoSwitchCDNEnabled = jSONObject.optBoolean("autoSwitchCDNEnabled", liveRetryConfigModel.autoSwitchCDNEnabled);
        return liveRetryConfigModel;
    }

    public static LiveRetryConfigModel fromJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        LiveRetryConfigModel liveRetryConfigModel = new LiveRetryConfigModel();
        liveRetryConfigModel.emptyReadSizeDuration = jSONObject.optInt("emptyReadSizeDuration", liveRetryConfigModel.emptyReadSizeDuration);
        liveRetryConfigModel.stalledDurationInOneMinute = jSONObject.optInt("stalledDurationInOneMinute", liveRetryConfigModel.stalledDurationInOneMinute);
        liveRetryConfigModel.autoSwitchCDNEnabled = jSONObject.optBoolean("autoSwitchCDNEnabled", liveRetryConfigModel.autoSwitchCDNEnabled);
        return liveRetryConfigModel;
    }

    public static String toJson(LiveRetryConfigModel liveRetryConfigModel) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("emptyReadSizeDuration", liveRetryConfigModel.emptyReadSizeDuration);
        } catch (Exception unused) {
        }
        try {
            jSONObject.put("stalledDurationInOneMinute", liveRetryConfigModel.stalledDurationInOneMinute);
        } catch (Exception unused2) {
        }
        try {
            jSONObject.put("autoSwitchCDNEnabled", liveRetryConfigModel.autoSwitchCDNEnabled);
        } catch (Exception unused3) {
        }
        return jSONObject.toString();
    }
}
