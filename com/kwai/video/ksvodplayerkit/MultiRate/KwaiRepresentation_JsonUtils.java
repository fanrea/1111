package com.kwai.video.ksvodplayerkit.MultiRate;

import java.util.ArrayList;
import java.util.Collection;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class KwaiRepresentation_JsonUtils {
    public static KwaiRepresentation fromJson(String str) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(str);
        } catch (Exception unused) {
            jSONObject = null;
        }
        if (jSONObject == null) {
            return null;
        }
        KwaiRepresentation kwaiRepresentation = new KwaiRepresentation();
        kwaiRepresentation.id = jSONObject.optInt("id", kwaiRepresentation.id);
        kwaiRepresentation.url = jSONObject.optString("url", kwaiRepresentation.url);
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("backupUrl");
        if (jSONArrayOptJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                arrayList.add((String) jSONArrayOptJSONArray.opt(i));
            }
            kwaiRepresentation.backupUrl = arrayList;
        }
        kwaiRepresentation.host = jSONObject.optString("host", kwaiRepresentation.host);
        kwaiRepresentation.m3u8Slice = jSONObject.optString("m3u8Slice", kwaiRepresentation.m3u8Slice);
        kwaiRepresentation.maxBitrate = jSONObject.optInt("maxBitrate", kwaiRepresentation.maxBitrate);
        kwaiRepresentation.avgBitrate = jSONObject.optInt("avgBitrate", kwaiRepresentation.avgBitrate);
        kwaiRepresentation.codecs = jSONObject.optString("codecs", kwaiRepresentation.codecs);
        kwaiRepresentation.height = jSONObject.optInt("height", kwaiRepresentation.height);
        kwaiRepresentation.width = jSONObject.optInt("width", kwaiRepresentation.width);
        kwaiRepresentation.frameRate = (float) jSONObject.optDouble("frameRate", kwaiRepresentation.frameRate);
        kwaiRepresentation.quality = (float) jSONObject.optDouble("quality", kwaiRepresentation.quality);
        kwaiRepresentation.qualityType = jSONObject.optString("qualityType", kwaiRepresentation.qualityType);
        kwaiRepresentation.qualityLabel = jSONObject.optString("qualityLabel", kwaiRepresentation.qualityLabel);
        kwaiRepresentation.featureP2sp = jSONObject.optBoolean("featureP2sp", kwaiRepresentation.featureP2sp);
        kwaiRepresentation.hidden = jSONObject.optBoolean("hidden", kwaiRepresentation.hidden);
        kwaiRepresentation.disableAdaptive = jSONObject.optBoolean("disableAdaptive", kwaiRepresentation.disableAdaptive);
        kwaiRepresentation.defaultSelect = jSONObject.optBoolean("defaultSelect", kwaiRepresentation.defaultSelect);
        kwaiRepresentation.comment = jSONObject.optString("comment", kwaiRepresentation.comment);
        kwaiRepresentation.hdrType = jSONObject.optInt("hdrType", kwaiRepresentation.hdrType);
        kwaiRepresentation.cacheKey = jSONObject.optString("key", kwaiRepresentation.cacheKey);
        return kwaiRepresentation;
    }

    public static KwaiRepresentation fromJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        KwaiRepresentation kwaiRepresentation = new KwaiRepresentation();
        kwaiRepresentation.id = jSONObject.optInt("id", kwaiRepresentation.id);
        kwaiRepresentation.url = jSONObject.optString("url", kwaiRepresentation.url);
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("backupUrl");
        if (jSONArrayOptJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                arrayList.add((String) jSONArrayOptJSONArray.opt(i));
            }
            kwaiRepresentation.backupUrl = arrayList;
        }
        kwaiRepresentation.host = jSONObject.optString("host", kwaiRepresentation.host);
        kwaiRepresentation.m3u8Slice = jSONObject.optString("m3u8Slice", kwaiRepresentation.m3u8Slice);
        kwaiRepresentation.maxBitrate = jSONObject.optInt("maxBitrate", kwaiRepresentation.maxBitrate);
        kwaiRepresentation.avgBitrate = jSONObject.optInt("avgBitrate", kwaiRepresentation.avgBitrate);
        kwaiRepresentation.codecs = jSONObject.optString("codecs", kwaiRepresentation.codecs);
        kwaiRepresentation.height = jSONObject.optInt("height", kwaiRepresentation.height);
        kwaiRepresentation.width = jSONObject.optInt("width", kwaiRepresentation.width);
        kwaiRepresentation.frameRate = (float) jSONObject.optDouble("frameRate", kwaiRepresentation.frameRate);
        kwaiRepresentation.quality = (float) jSONObject.optDouble("quality", kwaiRepresentation.quality);
        kwaiRepresentation.qualityType = jSONObject.optString("qualityType", kwaiRepresentation.qualityType);
        kwaiRepresentation.qualityLabel = jSONObject.optString("qualityLabel", kwaiRepresentation.qualityLabel);
        kwaiRepresentation.featureP2sp = jSONObject.optBoolean("featureP2sp", kwaiRepresentation.featureP2sp);
        kwaiRepresentation.hidden = jSONObject.optBoolean("hidden", kwaiRepresentation.hidden);
        kwaiRepresentation.disableAdaptive = jSONObject.optBoolean("disableAdaptive", kwaiRepresentation.disableAdaptive);
        kwaiRepresentation.defaultSelect = jSONObject.optBoolean("defaultSelect", kwaiRepresentation.defaultSelect);
        kwaiRepresentation.comment = jSONObject.optString("comment", kwaiRepresentation.comment);
        kwaiRepresentation.hdrType = jSONObject.optInt("hdrType", kwaiRepresentation.hdrType);
        kwaiRepresentation.cacheKey = jSONObject.optString("key", kwaiRepresentation.cacheKey);
        return kwaiRepresentation;
    }

    public static String toJson(KwaiRepresentation kwaiRepresentation) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", kwaiRepresentation.id);
        } catch (Exception unused) {
        }
        try {
            jSONObject.put("url", kwaiRepresentation.url);
        } catch (Exception unused2) {
        }
        try {
            jSONObject.put("backupUrl", new JSONArray((Collection) kwaiRepresentation.backupUrl));
        } catch (Exception unused3) {
        }
        try {
            jSONObject.put("host", kwaiRepresentation.host);
        } catch (Exception unused4) {
        }
        try {
            jSONObject.put("m3u8Slice", kwaiRepresentation.m3u8Slice);
        } catch (Exception unused5) {
        }
        try {
            jSONObject.put("maxBitrate", kwaiRepresentation.maxBitrate);
        } catch (Exception unused6) {
        }
        try {
            jSONObject.put("avgBitrate", kwaiRepresentation.avgBitrate);
        } catch (Exception unused7) {
        }
        try {
            jSONObject.put("codecs", kwaiRepresentation.codecs);
        } catch (Exception unused8) {
        }
        try {
            jSONObject.put("height", kwaiRepresentation.height);
        } catch (Exception unused9) {
        }
        try {
            jSONObject.put("width", kwaiRepresentation.width);
        } catch (Exception unused10) {
        }
        try {
            jSONObject.put("frameRate", kwaiRepresentation.frameRate);
        } catch (Exception unused11) {
        }
        try {
            jSONObject.put("quality", kwaiRepresentation.quality);
        } catch (Exception unused12) {
        }
        try {
            jSONObject.put("qualityType", kwaiRepresentation.qualityType);
        } catch (Exception unused13) {
        }
        try {
            jSONObject.put("qualityLabel", kwaiRepresentation.qualityLabel);
        } catch (Exception unused14) {
        }
        try {
            jSONObject.put("featureP2sp", kwaiRepresentation.featureP2sp);
        } catch (Exception unused15) {
        }
        try {
            jSONObject.put("hidden", kwaiRepresentation.hidden);
        } catch (Exception unused16) {
        }
        try {
            jSONObject.put("disableAdaptive", kwaiRepresentation.disableAdaptive);
        } catch (Exception unused17) {
        }
        try {
            jSONObject.put("defaultSelect", kwaiRepresentation.defaultSelect);
        } catch (Exception unused18) {
        }
        try {
            jSONObject.put("comment", kwaiRepresentation.comment);
        } catch (Exception unused19) {
        }
        try {
            jSONObject.put("hdrType", kwaiRepresentation.hdrType);
        } catch (Exception unused20) {
        }
        try {
            jSONObject.put("key", kwaiRepresentation.cacheKey);
        } catch (Exception unused21) {
        }
        return jSONObject.toString();
    }
}
