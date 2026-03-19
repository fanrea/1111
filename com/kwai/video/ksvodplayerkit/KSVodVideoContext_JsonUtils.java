package com.kwai.video.ksvodplayerkit;

import com.baidu.mobads.container.adrequest.n;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class KSVodVideoContext_JsonUtils {
    public static KSVodVideoContext fromJson(String str) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(str);
        } catch (Exception unused) {
            jSONObject = null;
        }
        if (jSONObject == null) {
            return null;
        }
        KSVodVideoContext kSVodVideoContext = new KSVodVideoContext();
        kSVodVideoContext.mVideoProfile = jSONObject.optString("video_profile", kSVodVideoContext.mVideoProfile);
        kSVodVideoContext.mEnterAction = jSONObject.optString("enter_action", kSVodVideoContext.mEnterAction);
        kSVodVideoContext.mVideoId = jSONObject.optString("video_id", kSVodVideoContext.mVideoId);
        kSVodVideoContext.mClickTime = jSONObject.optLong(n.I, kSVodVideoContext.mClickTime);
        kSVodVideoContext.mExtra = jSONObject.optString("stats_extra", kSVodVideoContext.mExtra);
        return kSVodVideoContext;
    }

    public static KSVodVideoContext fromJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        KSVodVideoContext kSVodVideoContext = new KSVodVideoContext();
        kSVodVideoContext.mVideoProfile = jSONObject.optString("video_profile", kSVodVideoContext.mVideoProfile);
        kSVodVideoContext.mEnterAction = jSONObject.optString("enter_action", kSVodVideoContext.mEnterAction);
        kSVodVideoContext.mVideoId = jSONObject.optString("video_id", kSVodVideoContext.mVideoId);
        kSVodVideoContext.mClickTime = jSONObject.optLong(n.I, kSVodVideoContext.mClickTime);
        kSVodVideoContext.mExtra = jSONObject.optString("stats_extra", kSVodVideoContext.mExtra);
        return kSVodVideoContext;
    }

    public static String toJson(KSVodVideoContext kSVodVideoContext) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("video_profile", kSVodVideoContext.mVideoProfile);
        } catch (Exception unused) {
        }
        try {
            jSONObject.put("enter_action", kSVodVideoContext.mEnterAction);
        } catch (Exception unused2) {
        }
        try {
            jSONObject.put("video_id", kSVodVideoContext.mVideoId);
        } catch (Exception unused3) {
        }
        try {
            jSONObject.put(n.I, kSVodVideoContext.mClickTime);
        } catch (Exception unused4) {
        }
        try {
            jSONObject.put("stats_extra", kSVodVideoContext.mExtra);
        } catch (Exception unused5) {
        }
        return jSONObject.toString();
    }
}
