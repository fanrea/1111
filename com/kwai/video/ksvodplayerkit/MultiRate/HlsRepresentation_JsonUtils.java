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
public final class HlsRepresentation_JsonUtils {
    public static HlsRepresentation fromJson(String str) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(str);
        } catch (Exception unused) {
            jSONObject = null;
        }
        if (jSONObject == null) {
            return null;
        }
        HlsRepresentation hlsRepresentation = new HlsRepresentation();
        hlsRepresentation.url = jSONObject.optString("url", hlsRepresentation.url);
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("backupUrl");
        if (jSONArrayOptJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                arrayList.add((String) jSONArrayOptJSONArray.opt(i));
            }
            hlsRepresentation.backupUrl = arrayList;
        }
        hlsRepresentation.m3u8 = jSONObject.optString("m3u8", hlsRepresentation.m3u8);
        hlsRepresentation.baseUrl = jSONObject.optString("baseUrl", hlsRepresentation.baseUrl);
        hlsRepresentation.duration = jSONObject.optDouble("duration", hlsRepresentation.duration);
        hlsRepresentation.m3u8Slice = jSONObject.optString("m3u8Slice", hlsRepresentation.m3u8Slice);
        hlsRepresentation.averageBandwidth = jSONObject.optInt("bandwidth", hlsRepresentation.averageBandwidth);
        hlsRepresentation.codecs = jSONObject.optString("codecs", hlsRepresentation.codecs);
        hlsRepresentation.width = jSONObject.optInt("width", hlsRepresentation.width);
        hlsRepresentation.height = jSONObject.optInt("height", hlsRepresentation.height);
        hlsRepresentation.frameRate = jSONObject.optDouble("frameRate", hlsRepresentation.frameRate);
        hlsRepresentation.cacheKey = jSONObject.optString("cacheKey", hlsRepresentation.cacheKey);
        return hlsRepresentation;
    }

    public static HlsRepresentation fromJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        HlsRepresentation hlsRepresentation = new HlsRepresentation();
        hlsRepresentation.url = jSONObject.optString("url", hlsRepresentation.url);
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("backupUrl");
        if (jSONArrayOptJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                arrayList.add((String) jSONArrayOptJSONArray.opt(i));
            }
            hlsRepresentation.backupUrl = arrayList;
        }
        hlsRepresentation.m3u8 = jSONObject.optString("m3u8", hlsRepresentation.m3u8);
        hlsRepresentation.baseUrl = jSONObject.optString("baseUrl", hlsRepresentation.baseUrl);
        hlsRepresentation.duration = jSONObject.optDouble("duration", hlsRepresentation.duration);
        hlsRepresentation.m3u8Slice = jSONObject.optString("m3u8Slice", hlsRepresentation.m3u8Slice);
        hlsRepresentation.averageBandwidth = jSONObject.optInt("bandwidth", hlsRepresentation.averageBandwidth);
        hlsRepresentation.codecs = jSONObject.optString("codecs", hlsRepresentation.codecs);
        hlsRepresentation.width = jSONObject.optInt("width", hlsRepresentation.width);
        hlsRepresentation.height = jSONObject.optInt("height", hlsRepresentation.height);
        hlsRepresentation.frameRate = jSONObject.optDouble("frameRate", hlsRepresentation.frameRate);
        hlsRepresentation.cacheKey = jSONObject.optString("cacheKey", hlsRepresentation.cacheKey);
        return hlsRepresentation;
    }

    public static String toJson(HlsRepresentation hlsRepresentation) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", hlsRepresentation.url);
        } catch (Exception unused) {
        }
        try {
            jSONObject.put("backupUrl", new JSONArray((Collection) hlsRepresentation.backupUrl));
        } catch (Exception unused2) {
        }
        try {
            jSONObject.put("m3u8", hlsRepresentation.m3u8);
        } catch (Exception unused3) {
        }
        try {
            jSONObject.put("baseUrl", hlsRepresentation.baseUrl);
        } catch (Exception unused4) {
        }
        try {
            jSONObject.put("duration", hlsRepresentation.duration);
        } catch (Exception unused5) {
        }
        try {
            jSONObject.put("m3u8Slice", hlsRepresentation.m3u8Slice);
        } catch (Exception unused6) {
        }
        try {
            jSONObject.put("bandwidth", hlsRepresentation.averageBandwidth);
        } catch (Exception unused7) {
        }
        try {
            jSONObject.put("codecs", hlsRepresentation.codecs);
        } catch (Exception unused8) {
        }
        try {
            jSONObject.put("width", hlsRepresentation.width);
        } catch (Exception unused9) {
        }
        try {
            jSONObject.put("height", hlsRepresentation.height);
        } catch (Exception unused10) {
        }
        try {
            jSONObject.put("frameRate", hlsRepresentation.frameRate);
        } catch (Exception unused11) {
        }
        try {
            jSONObject.put("cacheKey", hlsRepresentation.cacheKey);
        } catch (Exception unused12) {
        }
        return jSONObject.toString();
    }
}
