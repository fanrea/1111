package com.kwad.sdk.core.b.a;

import com.kwad.components.ad.interstitial.report.InterstitialReportInfo;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class hk implements com.kwad.sdk.core.d<InterstitialReportInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((InterstitialReportInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((InterstitialReportInfo) bVar, jSONObject);
    }

    private static void a(InterstitialReportInfo interstitialReportInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        interstitialReportInfo.status = jSONObject.optInt("status");
        interstitialReportInfo.type = jSONObject.optInt("type");
        interstitialReportInfo.loadDataTime = jSONObject.optLong("load_data_duration_ms");
        interstitialReportInfo.renderDuration = jSONObject.optLong("render_duration_ms");
        interstitialReportInfo.renderType = jSONObject.optInt("render_type");
        interstitialReportInfo.expectedRenderType = jSONObject.optInt("expected_render_type");
        interstitialReportInfo.materialType = jSONObject.optInt("material_type");
        interstitialReportInfo.downloadDuration = jSONObject.optLong("download_duration_ms");
        interstitialReportInfo.downloadType = jSONObject.optInt("download_type");
        interstitialReportInfo.downloadSize = jSONObject.optLong("download_size");
        interstitialReportInfo.creativeId = jSONObject.optLong("creative_id");
        interstitialReportInfo.videoUrl = jSONObject.optString("video_url");
        if (JSONObject.NULL.toString().equals(interstitialReportInfo.videoUrl)) {
            interstitialReportInfo.videoUrl = "";
        }
        interstitialReportInfo.videoDuration = jSONObject.optLong("video_duration_ms");
        interstitialReportInfo.playStartedDuration = jSONObject.optLong("play_started_duration_ms");
        interstitialReportInfo.abParams = jSONObject.optString("ab_params");
        if (JSONObject.NULL.toString().equals(interstitialReportInfo.abParams)) {
            interstitialReportInfo.abParams = "";
        }
        interstitialReportInfo.actionType = jSONObject.optLong("action_type");
        interstitialReportInfo.callbackType = jSONObject.optLong("callback_type");
        interstitialReportInfo.clickSceneType = jSONObject.optLong("click_scene_type");
        interstitialReportInfo.itemClickType = jSONObject.optLong("item_click_type");
        interstitialReportInfo.visiblePercent = jSONObject.optDouble("visible_percent");
    }

    private static JSONObject b(InterstitialReportInfo interstitialReportInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (interstitialReportInfo.status != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "status", interstitialReportInfo.status);
        }
        if (interstitialReportInfo.type != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "type", interstitialReportInfo.type);
        }
        if (interstitialReportInfo.loadDataTime != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "load_data_duration_ms", interstitialReportInfo.loadDataTime);
        }
        if (interstitialReportInfo.renderDuration != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "render_duration_ms", interstitialReportInfo.renderDuration);
        }
        if (interstitialReportInfo.renderType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "render_type", interstitialReportInfo.renderType);
        }
        if (interstitialReportInfo.expectedRenderType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "expected_render_type", interstitialReportInfo.expectedRenderType);
        }
        if (interstitialReportInfo.materialType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "material_type", interstitialReportInfo.materialType);
        }
        if (interstitialReportInfo.downloadDuration != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "download_duration_ms", interstitialReportInfo.downloadDuration);
        }
        if (interstitialReportInfo.downloadType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "download_type", interstitialReportInfo.downloadType);
        }
        if (interstitialReportInfo.downloadSize != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "download_size", interstitialReportInfo.downloadSize);
        }
        if (interstitialReportInfo.creativeId != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "creative_id", interstitialReportInfo.creativeId);
        }
        if (interstitialReportInfo.videoUrl != null && !interstitialReportInfo.videoUrl.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "video_url", interstitialReportInfo.videoUrl);
        }
        if (interstitialReportInfo.videoDuration != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "video_duration_ms", interstitialReportInfo.videoDuration);
        }
        if (interstitialReportInfo.playStartedDuration != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "play_started_duration_ms", interstitialReportInfo.playStartedDuration);
        }
        if (interstitialReportInfo.abParams != null && !interstitialReportInfo.abParams.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "ab_params", interstitialReportInfo.abParams);
        }
        if (interstitialReportInfo.actionType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "action_type", interstitialReportInfo.actionType);
        }
        if (interstitialReportInfo.callbackType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "callback_type", interstitialReportInfo.callbackType);
        }
        if (interstitialReportInfo.clickSceneType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "click_scene_type", interstitialReportInfo.clickSceneType);
        }
        if (interstitialReportInfo.itemClickType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "item_click_type", interstitialReportInfo.itemClickType);
        }
        if (interstitialReportInfo.visiblePercent != 0.0d) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "visible_percent", interstitialReportInfo.visiblePercent);
        }
        return jSONObject;
    }
}
