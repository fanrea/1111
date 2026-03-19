package com.kwad.sdk.core.b.a;

import com.kwad.components.ad.reward.monitor.RewardMonitorInfo;
import com.sigmob.sdk.base.mta.PointParamKey;
import com.sigmob.windad.WindAds;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class ku implements com.kwad.sdk.core.d<RewardMonitorInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((RewardMonitorInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((RewardMonitorInfo) bVar, jSONObject);
    }

    private static void a(RewardMonitorInfo rewardMonitorInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        rewardMonitorInfo.loadType = jSONObject.optInt("load_type");
        rewardMonitorInfo.loadStatus = jSONObject.optInt("load_status");
        rewardMonitorInfo.adCount = jSONObject.optInt(PointParamKey.AD_COUNT);
        rewardMonitorInfo.loadDataDuration = jSONObject.optLong("load_data_duration_ms");
        rewardMonitorInfo.downloadDuration = jSONObject.optLong("download_duration_ms");
        rewardMonitorInfo.totalDuration = jSONObject.optLong("total_duration_ms");
        rewardMonitorInfo.downloadType = jSONObject.optInt("download_type");
        rewardMonitorInfo.downloadSize = jSONObject.optLong("download_size");
        rewardMonitorInfo.creativeId = jSONObject.optLong("creative_id");
        rewardMonitorInfo.videoUrl = jSONObject.optString("video_url");
        if (JSONObject.NULL.toString().equals(rewardMonitorInfo.videoUrl)) {
            rewardMonitorInfo.videoUrl = "";
        }
        rewardMonitorInfo.videoDuration = jSONObject.optLong("video_duration_ms");
        rewardMonitorInfo.dataLoadInterval = jSONObject.optLong("data_load_interval_duration_ms");
        rewardMonitorInfo.dataDownloadInterval = jSONObject.optLong("data_download_interval_duration_ms");
        rewardMonitorInfo.adSceneType = jSONObject.optInt("ad_scene_type");
        rewardMonitorInfo.renderDuration = jSONObject.optLong("render_duration_ms");
        rewardMonitorInfo.currentDuration = jSONObject.optLong("video_duration_ms");
        rewardMonitorInfo.pageStatus = jSONObject.optInt("page_status");
        rewardMonitorInfo.subStage = jSONObject.optString("sub_stage");
        if (JSONObject.NULL.toString().equals(rewardMonitorInfo.subStage)) {
            rewardMonitorInfo.subStage = "";
        }
        rewardMonitorInfo.launchFrom = jSONObject.optString("launch_from");
        if (JSONObject.NULL.toString().equals(rewardMonitorInfo.launchFrom)) {
            rewardMonitorInfo.launchFrom = "";
        }
        rewardMonitorInfo.rewardType = jSONObject.optInt(WindAds.REWARD_TYPE);
        rewardMonitorInfo.taskType = jSONObject.optInt("task_type");
        rewardMonitorInfo.taskStep = jSONObject.optInt("task_step");
        rewardMonitorInfo.posId = jSONObject.optLong("pos_Id");
        rewardMonitorInfo.materialType = jSONObject.optInt("material_type");
        rewardMonitorInfo.materialRenderType = jSONObject.optString("material_render_type");
        if (JSONObject.NULL.toString().equals(rewardMonitorInfo.materialRenderType)) {
            rewardMonitorInfo.materialRenderType = "";
        }
        rewardMonitorInfo.operationType = jSONObject.optInt("operation_type");
        rewardMonitorInfo.tkRenderType = jSONObject.optInt("tk_render_type");
        rewardMonitorInfo.callbackType = jSONObject.optString("callback_type");
        if (JSONObject.NULL.toString().equals(rewardMonitorInfo.callbackType)) {
            rewardMonitorInfo.callbackType = "";
        }
        rewardMonitorInfo.enableRewardLayoutOptimise = jSONObject.optBoolean("enable_reward_layout_optimise");
        rewardMonitorInfo.enableFullscreenLayoutOptimise = jSONObject.optBoolean("enable_fullscreen_layout_optimise");
        rewardMonitorInfo.rewardTaskType = jSONObject.optInt("reward_task_type");
        rewardMonitorInfo.fraudVerifyType = jSONObject.optInt("fraud_verify_type");
        rewardMonitorInfo.fraudVerifyCode = jSONObject.optInt("fraud_verify_code");
        rewardMonitorInfo.interceptReason = jSONObject.optString("intercept_reason");
        if (JSONObject.NULL.toString().equals(rewardMonitorInfo.interceptReason)) {
            rewardMonitorInfo.interceptReason = "";
        }
    }

    private static JSONObject b(RewardMonitorInfo rewardMonitorInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (rewardMonitorInfo.loadType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "load_type", rewardMonitorInfo.loadType);
        }
        if (rewardMonitorInfo.loadStatus != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "load_status", rewardMonitorInfo.loadStatus);
        }
        if (rewardMonitorInfo.adCount != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, PointParamKey.AD_COUNT, rewardMonitorInfo.adCount);
        }
        if (rewardMonitorInfo.loadDataDuration != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "load_data_duration_ms", rewardMonitorInfo.loadDataDuration);
        }
        if (rewardMonitorInfo.downloadDuration != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "download_duration_ms", rewardMonitorInfo.downloadDuration);
        }
        if (rewardMonitorInfo.totalDuration != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "total_duration_ms", rewardMonitorInfo.totalDuration);
        }
        if (rewardMonitorInfo.downloadType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "download_type", rewardMonitorInfo.downloadType);
        }
        if (rewardMonitorInfo.downloadSize != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "download_size", rewardMonitorInfo.downloadSize);
        }
        if (rewardMonitorInfo.creativeId != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "creative_id", rewardMonitorInfo.creativeId);
        }
        if (rewardMonitorInfo.videoUrl != null && !rewardMonitorInfo.videoUrl.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "video_url", rewardMonitorInfo.videoUrl);
        }
        if (rewardMonitorInfo.videoDuration != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "video_duration_ms", rewardMonitorInfo.videoDuration);
        }
        if (rewardMonitorInfo.dataLoadInterval != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "data_load_interval_duration_ms", rewardMonitorInfo.dataLoadInterval);
        }
        if (rewardMonitorInfo.dataDownloadInterval != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "data_download_interval_duration_ms", rewardMonitorInfo.dataDownloadInterval);
        }
        if (rewardMonitorInfo.adSceneType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "ad_scene_type", rewardMonitorInfo.adSceneType);
        }
        if (rewardMonitorInfo.renderDuration != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "render_duration_ms", rewardMonitorInfo.renderDuration);
        }
        if (rewardMonitorInfo.currentDuration != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "video_duration_ms", rewardMonitorInfo.currentDuration);
        }
        if (rewardMonitorInfo.pageStatus != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "page_status", rewardMonitorInfo.pageStatus);
        }
        if (rewardMonitorInfo.subStage != null && !rewardMonitorInfo.subStage.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "sub_stage", rewardMonitorInfo.subStage);
        }
        if (rewardMonitorInfo.launchFrom != null && !rewardMonitorInfo.launchFrom.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "launch_from", rewardMonitorInfo.launchFrom);
        }
        if (rewardMonitorInfo.rewardType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, WindAds.REWARD_TYPE, rewardMonitorInfo.rewardType);
        }
        if (rewardMonitorInfo.taskType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "task_type", rewardMonitorInfo.taskType);
        }
        if (rewardMonitorInfo.taskStep != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "task_step", rewardMonitorInfo.taskStep);
        }
        if (rewardMonitorInfo.posId != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "pos_Id", rewardMonitorInfo.posId);
        }
        if (rewardMonitorInfo.materialType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "material_type", rewardMonitorInfo.materialType);
        }
        if (rewardMonitorInfo.materialRenderType != null && !rewardMonitorInfo.materialRenderType.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "material_render_type", rewardMonitorInfo.materialRenderType);
        }
        if (rewardMonitorInfo.operationType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "operation_type", rewardMonitorInfo.operationType);
        }
        if (rewardMonitorInfo.tkRenderType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "tk_render_type", rewardMonitorInfo.tkRenderType);
        }
        if (rewardMonitorInfo.callbackType != null && !rewardMonitorInfo.callbackType.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "callback_type", rewardMonitorInfo.callbackType);
        }
        if (rewardMonitorInfo.enableRewardLayoutOptimise) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "enable_reward_layout_optimise", rewardMonitorInfo.enableRewardLayoutOptimise);
        }
        if (rewardMonitorInfo.enableFullscreenLayoutOptimise) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "enable_fullscreen_layout_optimise", rewardMonitorInfo.enableFullscreenLayoutOptimise);
        }
        if (rewardMonitorInfo.rewardTaskType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "reward_task_type", rewardMonitorInfo.rewardTaskType);
        }
        if (rewardMonitorInfo.fraudVerifyType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "fraud_verify_type", rewardMonitorInfo.fraudVerifyType);
        }
        if (rewardMonitorInfo.fraudVerifyCode != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "fraud_verify_code", rewardMonitorInfo.fraudVerifyCode);
        }
        if (rewardMonitorInfo.interceptReason != null && !rewardMonitorInfo.interceptReason.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "intercept_reason", rewardMonitorInfo.interceptReason);
        }
        return jSONObject;
    }
}
