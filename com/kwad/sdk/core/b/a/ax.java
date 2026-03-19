package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.track.AdTrackLog;
import com.sigmob.windad.WindAds;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class ax implements com.kwad.sdk.core.d<AdTrackLog> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdTrackLog) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdTrackLog) bVar, jSONObject);
    }

    private static void a(AdTrackLog adTrackLog, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adTrackLog.templateId = jSONObject.optString("template_id");
        if (JSONObject.NULL.toString().equals(adTrackLog.templateId)) {
            adTrackLog.templateId = "";
        }
        adTrackLog.sceneId = jSONObject.optString(WindAds.AD_SCENE_ID);
        if (JSONObject.NULL.toString().equals(adTrackLog.sceneId)) {
            adTrackLog.sceneId = "";
        }
        adTrackLog.preLandingPageSwitch = jSONObject.optInt("pre_landing_page_switch");
        adTrackLog.preLandingPageShowType = jSONObject.optInt("pre_landing_page_show_type");
        adTrackLog.adLiveSwitch = jSONObject.optInt("ad_live_switch");
        adTrackLog.adTkLiveSwitch = jSONObject.optInt("ad_tk_live_switch");
        adTrackLog.adLiveComponentReady = jSONObject.optInt("ad_live_component_ready");
        adTrackLog.serverCheckSwitch = jSONObject.optInt("server_check_switch");
        adTrackLog.rewardAdvanceSwitch = jSONObject.optInt("reward_advance_switch");
        adTrackLog.rewardSkipShowTime = jSONObject.optInt("reward_skip_show_time");
        adTrackLog.isPlugin = jSONObject.optInt("is_plugin");
        adTrackLog.apiSdkVersion = jSONObject.optString("api_sdk_version");
        if (JSONObject.NULL.toString().equals(adTrackLog.apiSdkVersion)) {
            adTrackLog.apiSdkVersion = "";
        }
        adTrackLog.rewardDetailStatusBarHeight = jSONObject.optInt("reward_detail_status_bar_height");
        adTrackLog.rewardDetailCallPositionY = jSONObject.optInt("reward_detail_call_position_y");
        adTrackLog.screenOrientation = jSONObject.optInt("screen_orientation");
    }

    private static JSONObject b(AdTrackLog adTrackLog, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (adTrackLog.templateId != null && !adTrackLog.templateId.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "template_id", adTrackLog.templateId);
        }
        if (adTrackLog.sceneId != null && !adTrackLog.sceneId.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, WindAds.AD_SCENE_ID, adTrackLog.sceneId);
        }
        if (adTrackLog.preLandingPageSwitch != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "pre_landing_page_switch", adTrackLog.preLandingPageSwitch);
        }
        if (adTrackLog.preLandingPageShowType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "pre_landing_page_show_type", adTrackLog.preLandingPageShowType);
        }
        if (adTrackLog.adLiveSwitch != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "ad_live_switch", adTrackLog.adLiveSwitch);
        }
        if (adTrackLog.adTkLiveSwitch != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "ad_tk_live_switch", adTrackLog.adTkLiveSwitch);
        }
        if (adTrackLog.adLiveComponentReady != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "ad_live_component_ready", adTrackLog.adLiveComponentReady);
        }
        if (adTrackLog.serverCheckSwitch != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "server_check_switch", adTrackLog.serverCheckSwitch);
        }
        if (adTrackLog.rewardAdvanceSwitch != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "reward_advance_switch", adTrackLog.rewardAdvanceSwitch);
        }
        if (adTrackLog.rewardSkipShowTime != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "reward_skip_show_time", adTrackLog.rewardSkipShowTime);
        }
        if (adTrackLog.isPlugin != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "is_plugin", adTrackLog.isPlugin);
        }
        if (adTrackLog.apiSdkVersion != null && !adTrackLog.apiSdkVersion.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "api_sdk_version", adTrackLog.apiSdkVersion);
        }
        if (adTrackLog.rewardDetailStatusBarHeight != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "reward_detail_status_bar_height", adTrackLog.rewardDetailStatusBarHeight);
        }
        if (adTrackLog.rewardDetailCallPositionY != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "reward_detail_call_position_y", adTrackLog.rewardDetailCallPositionY);
        }
        if (adTrackLog.screenOrientation != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "screen_orientation", adTrackLog.screenOrientation);
        }
        return jSONObject;
    }
}
