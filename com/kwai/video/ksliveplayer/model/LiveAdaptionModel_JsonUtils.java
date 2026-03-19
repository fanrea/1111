package com.kwai.video.ksliveplayer.model;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveAdaptionModel_JsonUtils {
    public static LiveAdaptionModel fromJson(String str) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(str);
        } catch (Exception unused) {
            jSONObject = null;
        }
        if (jSONObject == null) {
            return null;
        }
        LiveAdaptionModel liveAdaptionModel = new LiveAdaptionModel();
        liveAdaptionModel.mUrl = jSONObject.optString("url", liveAdaptionModel.mUrl);
        liveAdaptionModel.mId = jSONObject.optInt("id", liveAdaptionModel.mId);
        liveAdaptionModel.mBitrate = jSONObject.optInt("bitrate", liveAdaptionModel.mBitrate);
        liveAdaptionModel.mQualityType = jSONObject.optString("qualityType", liveAdaptionModel.mQualityType);
        liveAdaptionModel.mMediaType = jSONObject.optString("mediaType", liveAdaptionModel.mMediaType);
        liveAdaptionModel.mName = jSONObject.optString("name", liveAdaptionModel.mName);
        liveAdaptionModel.mLevel = jSONObject.optInt("level", liveAdaptionModel.mLevel);
        liveAdaptionModel.mIsDefaultSelect = jSONObject.optBoolean("defaultSelect", liveAdaptionModel.mIsDefaultSelect);
        return liveAdaptionModel;
    }

    public static LiveAdaptionModel fromJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        LiveAdaptionModel liveAdaptionModel = new LiveAdaptionModel();
        liveAdaptionModel.mUrl = jSONObject.optString("url", liveAdaptionModel.mUrl);
        liveAdaptionModel.mId = jSONObject.optInt("id", liveAdaptionModel.mId);
        liveAdaptionModel.mBitrate = jSONObject.optInt("bitrate", liveAdaptionModel.mBitrate);
        liveAdaptionModel.mQualityType = jSONObject.optString("qualityType", liveAdaptionModel.mQualityType);
        liveAdaptionModel.mMediaType = jSONObject.optString("mediaType", liveAdaptionModel.mMediaType);
        liveAdaptionModel.mName = jSONObject.optString("name", liveAdaptionModel.mName);
        liveAdaptionModel.mLevel = jSONObject.optInt("level", liveAdaptionModel.mLevel);
        liveAdaptionModel.mIsDefaultSelect = jSONObject.optBoolean("defaultSelect", liveAdaptionModel.mIsDefaultSelect);
        return liveAdaptionModel;
    }

    public static String toJson(LiveAdaptionModel liveAdaptionModel) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", liveAdaptionModel.mUrl);
        } catch (Exception unused) {
        }
        try {
            jSONObject.put("id", liveAdaptionModel.mId);
        } catch (Exception unused2) {
        }
        try {
            jSONObject.put("bitrate", liveAdaptionModel.mBitrate);
        } catch (Exception unused3) {
        }
        try {
            jSONObject.put("qualityType", liveAdaptionModel.mQualityType);
        } catch (Exception unused4) {
        }
        try {
            jSONObject.put("mediaType", liveAdaptionModel.mMediaType);
        } catch (Exception unused5) {
        }
        try {
            jSONObject.put("name", liveAdaptionModel.mName);
        } catch (Exception unused6) {
        }
        try {
            jSONObject.put("level", liveAdaptionModel.mLevel);
        } catch (Exception unused7) {
        }
        try {
            jSONObject.put("defaultSelect", liveAdaptionModel.mIsDefaultSelect);
        } catch (Exception unused8) {
        }
        return jSONObject.toString();
    }
}
