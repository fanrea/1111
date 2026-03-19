package com.kwai.video.ksliveplayer.model;

import com.baidu.mobstat.forbes.Config;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveAdaptiveManifestModel_JsonUtils {
    public static LiveAdaptiveManifestModel fromJson(String str) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(str);
        } catch (Exception unused) {
            jSONObject = null;
        }
        if (jSONObject == null) {
            return null;
        }
        LiveAdaptiveManifestModel liveAdaptiveManifestModel = new LiveAdaptiveManifestModel();
        liveAdaptiveManifestModel.mVersion = jSONObject.optString(Config.INPUT_DEF_VERSION, liveAdaptiveManifestModel.mVersion);
        liveAdaptiveManifestModel.mType = jSONObject.optString("type", liveAdaptiveManifestModel.mType);
        liveAdaptiveManifestModel.mIsFreeTrafficCdn = jSONObject.optBoolean("freeTrafficCdn", liveAdaptiveManifestModel.mIsFreeTrafficCdn);
        liveAdaptiveManifestModel.mAdaptationSet = AdaptationSetModel_JsonUtils.fromJson(jSONObject.optJSONObject("adaptationSet"));
        liveAdaptiveManifestModel.mHost = jSONObject.optString("host", liveAdaptiveManifestModel.mHost);
        liveAdaptiveManifestModel.mHideAuto = jSONObject.optBoolean("hideAuto", liveAdaptiveManifestModel.mHideAuto);
        return liveAdaptiveManifestModel;
    }

    public static LiveAdaptiveManifestModel fromJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        LiveAdaptiveManifestModel liveAdaptiveManifestModel = new LiveAdaptiveManifestModel();
        liveAdaptiveManifestModel.mVersion = jSONObject.optString(Config.INPUT_DEF_VERSION, liveAdaptiveManifestModel.mVersion);
        liveAdaptiveManifestModel.mType = jSONObject.optString("type", liveAdaptiveManifestModel.mType);
        liveAdaptiveManifestModel.mIsFreeTrafficCdn = jSONObject.optBoolean("freeTrafficCdn", liveAdaptiveManifestModel.mIsFreeTrafficCdn);
        liveAdaptiveManifestModel.mAdaptationSet = AdaptationSetModel_JsonUtils.fromJson(jSONObject.optJSONObject("adaptationSet"));
        liveAdaptiveManifestModel.mHost = jSONObject.optString("host", liveAdaptiveManifestModel.mHost);
        liveAdaptiveManifestModel.mHideAuto = jSONObject.optBoolean("hideAuto", liveAdaptiveManifestModel.mHideAuto);
        return liveAdaptiveManifestModel;
    }

    public static String toJson(LiveAdaptiveManifestModel liveAdaptiveManifestModel) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Config.INPUT_DEF_VERSION, liveAdaptiveManifestModel.mVersion);
        } catch (Exception unused) {
        }
        try {
            jSONObject.put("type", liveAdaptiveManifestModel.mType);
        } catch (Exception unused2) {
        }
        try {
            jSONObject.put("freeTrafficCdn", liveAdaptiveManifestModel.mIsFreeTrafficCdn);
        } catch (Exception unused3) {
        }
        try {
            jSONObject.put("adaptationSet", AdaptationSetModel_JsonUtils.toJson(liveAdaptiveManifestModel.mAdaptationSet));
        } catch (Exception unused4) {
        }
        try {
            jSONObject.put("host", liveAdaptiveManifestModel.mHost);
        } catch (Exception unused5) {
        }
        try {
            jSONObject.put("hideAuto", liveAdaptiveManifestModel.mHideAuto);
        } catch (Exception unused6) {
        }
        return jSONObject.toString();
    }
}
