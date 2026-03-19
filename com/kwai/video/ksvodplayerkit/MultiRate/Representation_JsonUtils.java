package com.kwai.video.ksvodplayerkit.MultiRate;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class Representation_JsonUtils {
    public static Representation fromJson(String str) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(str);
        } catch (Exception unused) {
            jSONObject = null;
        }
        if (jSONObject == null) {
            return null;
        }
        Representation representation = new Representation();
        representation.mAvgBitrate = jSONObject.optInt("avgBitrate", representation.mAvgBitrate);
        representation.mHost = jSONObject.optString("host", representation.mHost);
        representation.mKey = jSONObject.optString("key", representation.mKey);
        representation.mMaxBitrate = jSONObject.optInt("maxBitrate", representation.mMaxBitrate);
        representation.mHeight = jSONObject.optInt("height", representation.mHeight);
        representation.mWidth = jSONObject.optInt("width", representation.mWidth);
        representation.mUrl = jSONObject.optString("url", representation.mUrl);
        representation.mQuality = (float) jSONObject.optDouble("quality", representation.mQuality);
        return representation;
    }

    public static Representation fromJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Representation representation = new Representation();
        representation.mAvgBitrate = jSONObject.optInt("avgBitrate", representation.mAvgBitrate);
        representation.mHost = jSONObject.optString("host", representation.mHost);
        representation.mKey = jSONObject.optString("key", representation.mKey);
        representation.mMaxBitrate = jSONObject.optInt("maxBitrate", representation.mMaxBitrate);
        representation.mHeight = jSONObject.optInt("height", representation.mHeight);
        representation.mWidth = jSONObject.optInt("width", representation.mWidth);
        representation.mUrl = jSONObject.optString("url", representation.mUrl);
        representation.mQuality = (float) jSONObject.optDouble("quality", representation.mQuality);
        return representation;
    }

    public static String toJson(Representation representation) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("avgBitrate", representation.mAvgBitrate);
        } catch (Exception unused) {
        }
        try {
            jSONObject.put("host", representation.mHost);
        } catch (Exception unused2) {
        }
        try {
            jSONObject.put("key", representation.mKey);
        } catch (Exception unused3) {
        }
        try {
            jSONObject.put("maxBitrate", representation.mMaxBitrate);
        } catch (Exception unused4) {
        }
        try {
            jSONObject.put("height", representation.mHeight);
        } catch (Exception unused5) {
        }
        try {
            jSONObject.put("width", representation.mWidth);
        } catch (Exception unused6) {
        }
        try {
            jSONObject.put("url", representation.mUrl);
        } catch (Exception unused7) {
        }
        try {
            jSONObject.put("quality", representation.mQuality);
        } catch (Exception unused8) {
        }
        return jSONObject.toString();
    }
}
