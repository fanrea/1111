package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class aq implements com.kwad.sdk.core.d<AdInfo.AdSplashInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdInfo.AdSplashInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdInfo.AdSplashInfo) bVar, jSONObject);
    }

    private static void a(AdInfo.AdSplashInfo adSplashInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adSplashInfo.logoPosition = jSONObject.optInt("logoPosition", new Integer("1").intValue());
        adSplashInfo.mute = jSONObject.optInt(com.sigmob.sdk.base.common.a.D, new Integer("1").intValue());
        adSplashInfo.skipType = jSONObject.optInt("skipType");
        adSplashInfo.skipTips = jSONObject.optString("skipTips");
        if (JSONObject.NULL.toString().equals(adSplashInfo.skipTips)) {
            adSplashInfo.skipTips = "";
        }
        adSplashInfo.speakerMuteIconUrl = jSONObject.optString("speakerMuteIconUrl");
        if (JSONObject.NULL.toString().equals(adSplashInfo.speakerMuteIconUrl)) {
            adSplashInfo.speakerMuteIconUrl = "";
        }
        adSplashInfo.speakerIconUrl = jSONObject.optString("speakerIconUrl");
        if (JSONObject.NULL.toString().equals(adSplashInfo.speakerIconUrl)) {
            adSplashInfo.speakerIconUrl = "";
        }
        adSplashInfo.imageDisplaySecond = jSONObject.optInt("imageDisplaySecond", new Integer("5").intValue());
        adSplashInfo.videoDisplaySecond = jSONObject.optInt("videoDisplaySecond", new Integer("5").intValue());
        adSplashInfo.countdownShow = jSONObject.optInt("countdownShow");
        adSplashInfo.fullScreenClickSwitch = jSONObject.optInt("fullScreenClickSwitch");
        adSplashInfo.skipButtonPosition = jSONObject.optInt("skipButtonPosition");
        adSplashInfo.splashShowClickButtonSwitch = jSONObject.optInt("splashShowClickButtonSwitch", new Integer("1").intValue());
        adSplashInfo.skipSecond = jSONObject.optInt("skipSecond");
        adSplashInfo.impressionStatisticalChangeSwitch = jSONObject.optBoolean("impressionStatisticalChangeSwitch");
        adSplashInfo.impressionLimitSize = jSONObject.optDouble("impressionLimitSize");
        adSplashInfo.cutRuleInfo = new AdInfo.CutRuleInfo();
        adSplashInfo.cutRuleInfo.parseJson(jSONObject.optJSONObject("cutRuleInfo"));
    }

    private static JSONObject b(AdInfo.AdSplashInfo adSplashInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "logoPosition", adSplashInfo.logoPosition);
        com.kwad.sdk.utils.aa.putValue(jSONObject, com.sigmob.sdk.base.common.a.D, adSplashInfo.mute);
        if (adSplashInfo.skipType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "skipType", adSplashInfo.skipType);
        }
        if (adSplashInfo.skipTips != null && !adSplashInfo.skipTips.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "skipTips", adSplashInfo.skipTips);
        }
        if (adSplashInfo.speakerMuteIconUrl != null && !adSplashInfo.speakerMuteIconUrl.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "speakerMuteIconUrl", adSplashInfo.speakerMuteIconUrl);
        }
        if (adSplashInfo.speakerIconUrl != null && !adSplashInfo.speakerIconUrl.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "speakerIconUrl", adSplashInfo.speakerIconUrl);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "imageDisplaySecond", adSplashInfo.imageDisplaySecond);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "videoDisplaySecond", adSplashInfo.videoDisplaySecond);
        if (adSplashInfo.countdownShow != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "countdownShow", adSplashInfo.countdownShow);
        }
        if (adSplashInfo.fullScreenClickSwitch != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "fullScreenClickSwitch", adSplashInfo.fullScreenClickSwitch);
        }
        if (adSplashInfo.skipButtonPosition != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "skipButtonPosition", adSplashInfo.skipButtonPosition);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "splashShowClickButtonSwitch", adSplashInfo.splashShowClickButtonSwitch);
        if (adSplashInfo.skipSecond != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "skipSecond", adSplashInfo.skipSecond);
        }
        if (adSplashInfo.impressionStatisticalChangeSwitch) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "impressionStatisticalChangeSwitch", adSplashInfo.impressionStatisticalChangeSwitch);
        }
        if (adSplashInfo.impressionLimitSize != 0.0d) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "impressionLimitSize", adSplashInfo.impressionLimitSize);
        }
        com.kwad.sdk.utils.aa.a(jSONObject, "cutRuleInfo", adSplashInfo.cutRuleInfo);
        return jSONObject;
    }
}
