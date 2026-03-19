package com.bykv.vk.component.ttvideo.player;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class MediaFormat {
    public static final String KEY_AUDIO = "audio";
    public static final String KEY_BIT_RATE = "bitrate";
    public static final String KEY_CHANNEL_COUNT = "channel-count";
    public static final String KEY_HEIGHT = "height";
    public static final String KEY_LANGUAGE = "language";
    public static final String KEY_SAMPLE_RATE = "sample-rate";
    public static final String KEY_SUBTITLE = "subtitle";
    public static final String KEY_TRACK_ID = "track-id";
    public static final String KEY_VIDEO = "video";
    public static final String KEY_WIDTH = "width";
    private Map<String, Object> mMap;

    public MediaFormat() {
        this.mMap = new HashMap();
    }

    public MediaFormat(Map<String, Object> map) {
        this.mMap = map;
    }

    public Map<String, Object> getValues() {
        return this.mMap;
    }

    public final int getInteger(String str) {
        return ((Integer) this.mMap.get(str)).intValue();
    }

    public final long getLong(String str) {
        return ((Long) this.mMap.get(str)).longValue();
    }

    public final float getFloat(String str) {
        return ((Float) this.mMap.get(str)).floatValue();
    }

    public final String getString(String str) {
        return (String) this.mMap.get(str);
    }

    public final void setInteger(String str, int i) {
        this.mMap.put(str, Integer.valueOf(i));
    }

    public final void setLong(String str, long j) {
        this.mMap.put(str, Long.valueOf(j));
    }

    public final void setFloat(String str, float f) {
        this.mMap.put(str, Float.valueOf(f));
    }

    public final void setString(String str, String str2) {
        this.mMap.put(str, str2);
    }

    public static final MediaFormat createAudioFormat(int i, int i2, int i3) {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setInteger("track-id", i);
        mediaFormat.setInteger("sample-rate", i2);
        mediaFormat.setInteger("channel-count", i3);
        return mediaFormat;
    }

    public static final MediaFormat createSubtitleFormat(int i, String str) {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setInteger("track-id", i);
        mediaFormat.setString("language", str);
        return mediaFormat;
    }

    public static final MediaFormat createVideoFormat(int i, int i2, int i3, int i4) {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setInteger("track-id", i);
        mediaFormat.setInteger("width", i2);
        mediaFormat.setInteger("height", i3);
        mediaFormat.setInteger("bitrate", i4);
        return mediaFormat;
    }

    public static final MediaFormat createAudioFormat(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return createAudioFormat(jSONObject.optInt("track-id"), jSONObject.optInt("sample-rate"), jSONObject.optInt("channel-count"));
    }

    public static final MediaFormat createSubtitleFormat(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return createSubtitleFormat(jSONObject.optInt("track-id"), jSONObject.optString("language"));
    }

    public static final MediaFormat createVideoFormat(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return createVideoFormat(jSONObject.optInt("track-id"), jSONObject.optInt("width"), jSONObject.optInt("height"), jSONObject.optInt("bitrate"));
    }

    public static final MediaFormat createAudioFormat(android.media.MediaFormat mediaFormat) {
        if (mediaFormat == null) {
            return null;
        }
        return createAudioFormat(mediaFormat.getInteger("track-id"), mediaFormat.getInteger("sample-rate"), mediaFormat.getInteger("channel-count"));
    }

    public static final MediaFormat createSubtitleFormat(android.media.MediaFormat mediaFormat) {
        if (mediaFormat == null) {
            return null;
        }
        return createSubtitleFormat(mediaFormat.getInteger("track-id"), mediaFormat.getString("language"));
    }

    public static final MediaFormat createVideoFormat(android.media.MediaFormat mediaFormat) {
        if (mediaFormat == null) {
            return null;
        }
        return createVideoFormat(mediaFormat.getInteger("track-id"), mediaFormat.getInteger("width"), mediaFormat.getInteger("height"), mediaFormat.getInteger("bitrate"));
    }

    public String toString() {
        return this.mMap.toString();
    }
}
