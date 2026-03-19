package com.kwai.video.ksvodplayerkit;

import com.kwai.video.ksvodplayerkit.KSVodPlayer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class VideoContext_JsonUtils {
    public static KSVodPlayer.VideoContext fromJson(String str) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(str);
        } catch (Exception unused) {
            jSONObject = null;
        }
        if (jSONObject == null) {
            return null;
        }
        KSVodPlayer.VideoContext videoContext = new KSVodPlayer.VideoContext();
        videoContext.mVideoProfile = jSONObject.optString("video_profile", videoContext.mVideoProfile);
        videoContext.mEnterAction = jSONObject.optString("enter_action", videoContext.mEnterAction);
        videoContext.mVideoId = jSONObject.optString("video_id", videoContext.mVideoId);
        videoContext.mClickToFirstFrame = jSONObject.optLong("click_to_first_frame", videoContext.mClickToFirstFrame);
        videoContext.mExtra = jSONObject.optString("stats_extra", videoContext.mExtra);
        videoContext.mPrepareTimestamp = jSONObject.optLong("call_prepare_timestamp", videoContext.mPrepareTimestamp);
        videoContext.mStartTimestamp = jSONObject.optLong("call_start_timestamp", videoContext.mStartTimestamp);
        videoContext.mClickTimeStamp = jSONObject.optLong("click_time_timestamp", videoContext.mClickTimeStamp);
        return videoContext;
    }

    public static KSVodPlayer.VideoContext fromJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        KSVodPlayer.VideoContext videoContext = new KSVodPlayer.VideoContext();
        videoContext.mVideoProfile = jSONObject.optString("video_profile", videoContext.mVideoProfile);
        videoContext.mEnterAction = jSONObject.optString("enter_action", videoContext.mEnterAction);
        videoContext.mVideoId = jSONObject.optString("video_id", videoContext.mVideoId);
        videoContext.mClickToFirstFrame = jSONObject.optLong("click_to_first_frame", videoContext.mClickToFirstFrame);
        videoContext.mExtra = jSONObject.optString("stats_extra", videoContext.mExtra);
        videoContext.mPrepareTimestamp = jSONObject.optLong("call_prepare_timestamp", videoContext.mPrepareTimestamp);
        videoContext.mStartTimestamp = jSONObject.optLong("call_start_timestamp", videoContext.mStartTimestamp);
        videoContext.mClickTimeStamp = jSONObject.optLong("click_time_timestamp", videoContext.mClickTimeStamp);
        return videoContext;
    }

    public static String toJson(KSVodPlayer.VideoContext videoContext) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("video_profile", videoContext.mVideoProfile);
        } catch (Exception unused) {
        }
        try {
            jSONObject.put("enter_action", videoContext.mEnterAction);
        } catch (Exception unused2) {
        }
        try {
            jSONObject.put("video_id", videoContext.mVideoId);
        } catch (Exception unused3) {
        }
        try {
            jSONObject.put("click_to_first_frame", videoContext.mClickToFirstFrame);
        } catch (Exception unused4) {
        }
        try {
            jSONObject.put("stats_extra", videoContext.mExtra);
        } catch (Exception unused5) {
        }
        try {
            jSONObject.put("call_prepare_timestamp", videoContext.mPrepareTimestamp);
        } catch (Exception unused6) {
        }
        try {
            jSONObject.put("call_start_timestamp", videoContext.mStartTimestamp);
        } catch (Exception unused7) {
        }
        try {
            jSONObject.put("click_time_timestamp", videoContext.mClickTimeStamp);
        } catch (Exception unused8) {
        }
        return jSONObject.toString();
    }
}
