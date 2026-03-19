package com.kwad.sdk.core.b.a;

import com.baidu.mobads.sdk.api.SplashAd;
import com.kwad.sdk.core.response.model.ABParams;
import com.kwad.sdk.core.response.model.AdInfo;
import com.qq.e.comm.constants.Constants;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class j implements com.kwad.sdk.core.d<AdInfo.AdBaseInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdInfo.AdBaseInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdInfo.AdBaseInfo) bVar, jSONObject);
    }

    private static void a(AdInfo.AdBaseInfo adBaseInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adBaseInfo.creativeId = jSONObject.optLong("creativeId");
        adBaseInfo.adSourceType = jSONObject.optInt("adSourceType");
        adBaseInfo.liveStreamId = jSONObject.optString("liveStreamId");
        if (JSONObject.NULL.toString().equals(adBaseInfo.liveStreamId)) {
            adBaseInfo.liveStreamId = "";
        }
        adBaseInfo.roiType = jSONObject.optInt("roiType");
        adBaseInfo.liveDisplayWatchingCount = jSONObject.optLong("liveDisplayWatchingCount");
        adBaseInfo.universeLiveType = jSONObject.optInt("universeLiveType");
        adBaseInfo.viewCount = jSONObject.optLong("viewCount");
        adBaseInfo.sdkExtraData = jSONObject.optString("sdkExtraData");
        if (JSONObject.NULL.toString().equals(adBaseInfo.sdkExtraData)) {
            adBaseInfo.sdkExtraData = "";
        }
        adBaseInfo.adDescription = jSONObject.optString("adDescription");
        if (JSONObject.NULL.toString().equals(adBaseInfo.adDescription)) {
            adBaseInfo.adDescription = "";
        }
        adBaseInfo.installAppLabel = jSONObject.optString("installAppLabel");
        if (JSONObject.NULL.toString().equals(adBaseInfo.installAppLabel)) {
            adBaseInfo.installAppLabel = "";
        }
        adBaseInfo.openAppLabel = jSONObject.optString("openAppLabel");
        if (JSONObject.NULL.toString().equals(adBaseInfo.openAppLabel)) {
            adBaseInfo.openAppLabel = "";
        }
        adBaseInfo.adMarkIcon = jSONObject.optString("adMarkIcon");
        if (JSONObject.NULL.toString().equals(adBaseInfo.adMarkIcon)) {
            adBaseInfo.adMarkIcon = "";
        }
        adBaseInfo.adGrayMarkIcon = jSONObject.optString("adGrayMarkIcon");
        if (JSONObject.NULL.toString().equals(adBaseInfo.adGrayMarkIcon)) {
            adBaseInfo.adGrayMarkIcon = "";
        }
        adBaseInfo.adSourceDescription = jSONObject.optString("adSourceDescription");
        if (JSONObject.NULL.toString().equals(adBaseInfo.adSourceDescription)) {
            adBaseInfo.adSourceDescription = "";
        }
        adBaseInfo.adOperationType = jSONObject.optInt("adOperationType");
        adBaseInfo.adActionDescription = jSONObject.optString("adActionDescription");
        if (JSONObject.NULL.toString().equals(adBaseInfo.adActionDescription)) {
            adBaseInfo.adActionDescription = "";
        }
        adBaseInfo.adActionBarColor = jSONObject.optString("adActionBarColor");
        if (JSONObject.NULL.toString().equals(adBaseInfo.adActionBarColor)) {
            adBaseInfo.adActionBarColor = "";
        }
        adBaseInfo.adShowDuration = jSONObject.optInt("adShowDuration");
        adBaseInfo.appName = jSONObject.optString("appName");
        if (JSONObject.NULL.toString().equals(adBaseInfo.appName)) {
            adBaseInfo.appName = "";
        }
        adBaseInfo.realAppName = jSONObject.optString("realAppName");
        if (JSONObject.NULL.toString().equals(adBaseInfo.realAppName)) {
            adBaseInfo.realAppName = "";
        }
        adBaseInfo.appIconUrl = jSONObject.optString("appIconUrl");
        if (JSONObject.NULL.toString().equals(adBaseInfo.appIconUrl)) {
            adBaseInfo.appIconUrl = "";
        }
        adBaseInfo.appPackageName = jSONObject.optString("appPackageName");
        if (JSONObject.NULL.toString().equals(adBaseInfo.appPackageName)) {
            adBaseInfo.appPackageName = "";
        }
        adBaseInfo.appScore = jSONObject.optInt("appScore");
        adBaseInfo.appDownloadCountDesc = jSONObject.optString("appDownloadCountDesc");
        if (JSONObject.NULL.toString().equals(adBaseInfo.appDownloadCountDesc)) {
            adBaseInfo.appDownloadCountDesc = "";
        }
        adBaseInfo.appCategory = jSONObject.optString("appCategory");
        if (JSONObject.NULL.toString().equals(adBaseInfo.appCategory)) {
            adBaseInfo.appCategory = "";
        }
        adBaseInfo.appVersion = jSONObject.optString("appVersion");
        if (JSONObject.NULL.toString().equals(adBaseInfo.appVersion)) {
            adBaseInfo.appVersion = "";
        }
        adBaseInfo.corporationName = jSONObject.optString("corporationName");
        if (JSONObject.NULL.toString().equals(adBaseInfo.corporationName)) {
            adBaseInfo.corporationName = "";
        }
        adBaseInfo.packageSize = jSONObject.optLong("packageSize");
        adBaseInfo.appImageUrl = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("appImageUrl");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                adBaseInfo.appImageUrl.add((String) jSONArrayOptJSONArray.opt(i));
            }
        }
        adBaseInfo.appImageSize = new AdInfo.MaterialSize();
        adBaseInfo.appImageSize.parseJson(jSONObject.optJSONObject("appImageSize"));
        adBaseInfo.appDescription = jSONObject.optString("appDescription");
        if (JSONObject.NULL.toString().equals(adBaseInfo.appDescription)) {
            adBaseInfo.appDescription = "";
        }
        adBaseInfo.enableSkipAd = jSONObject.optInt("enableSkipAd");
        adBaseInfo.adCacheSwitch = jSONObject.optInt("adCacheSwitch", new Integer("0").intValue());
        adBaseInfo.adCacheSecond = jSONObject.optLong("adCacheSecond", new Long("1800").longValue());
        adBaseInfo.adCacheStrategy = jSONObject.optInt("adCacheStrategy", new Integer("1").intValue());
        adBaseInfo.adCacheSize = jSONObject.optInt("adCacheSize", new Integer("1").intValue());
        adBaseInfo.adRolloutSize = jSONObject.optInt("adRolloutSize");
        adBaseInfo.skipSecond = jSONObject.optInt("skipSecond");
        adBaseInfo.ecpm = jSONObject.optInt(SplashAd.KEY_BIDFAIL_ECPM);
        adBaseInfo.videoPlayedNS = jSONObject.optString("videoPlayedNS");
        if (JSONObject.NULL.toString().equals(adBaseInfo.videoPlayedNS)) {
            adBaseInfo.videoPlayedNS = "";
        }
        adBaseInfo.videoPlayedNSConfig = jSONObject.optString("videoPlayedNSConfig");
        if (JSONObject.NULL.toString().equals(adBaseInfo.videoPlayedNSConfig)) {
            adBaseInfo.videoPlayedNSConfig = "";
        }
        adBaseInfo.productName = jSONObject.optString("productName");
        if (JSONObject.NULL.toString().equals(adBaseInfo.productName)) {
            adBaseInfo.productName = "";
        }
        adBaseInfo.mABParams = new ABParams();
        try {
            adBaseInfo.mABParams.parseJson(new JSONObject(jSONObject.optString("expParam")));
        } catch (Exception unused) {
        }
        adBaseInfo.showUrl = jSONObject.optString("showUrl");
        if (JSONObject.NULL.toString().equals(adBaseInfo.showUrl)) {
            adBaseInfo.showUrl = "";
        }
        adBaseInfo.clickUrl = jSONObject.optString(Constants.KEYS.EXPOSED_CLICK_URL_KEY);
        if (JSONObject.NULL.toString().equals(adBaseInfo.clickUrl)) {
            adBaseInfo.clickUrl = "";
        }
        adBaseInfo.convUrl = jSONObject.optString("convUrl");
        if (JSONObject.NULL.toString().equals(adBaseInfo.convUrl)) {
            adBaseInfo.convUrl = "";
        }
        adBaseInfo.adAttributeType = jSONObject.optInt("adAttributeType");
        adBaseInfo.apiExpParam = new AdInfo.H5Config();
        adBaseInfo.apiExpParam.parseJson(jSONObject.optJSONObject("apiExpParam"));
        adBaseInfo.taskType = jSONObject.optInt("taskType");
        adBaseInfo.campaignType = jSONObject.optInt("campaignType");
        adBaseInfo.itemType = jSONObject.optInt("itemType");
        adBaseInfo.industryFirstLevelId = jSONObject.optInt("industryFirstLevelId");
        adBaseInfo.extraClickReward = jSONObject.optBoolean("extraClickReward");
        adBaseInfo.enableClientProofreadTime = jSONObject.optBoolean("enableClientProofreadTime");
    }

    private static JSONObject b(AdInfo.AdBaseInfo adBaseInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (adBaseInfo.creativeId != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "creativeId", adBaseInfo.creativeId);
        }
        if (adBaseInfo.adSourceType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adSourceType", adBaseInfo.adSourceType);
        }
        if (adBaseInfo.liveStreamId != null && !adBaseInfo.liveStreamId.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "liveStreamId", adBaseInfo.liveStreamId);
        }
        if (adBaseInfo.roiType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "roiType", adBaseInfo.roiType);
        }
        if (adBaseInfo.liveDisplayWatchingCount != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "liveDisplayWatchingCount", adBaseInfo.liveDisplayWatchingCount);
        }
        if (adBaseInfo.universeLiveType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "universeLiveType", adBaseInfo.universeLiveType);
        }
        if (adBaseInfo.viewCount != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "viewCount", adBaseInfo.viewCount);
        }
        if (adBaseInfo.sdkExtraData != null && !adBaseInfo.sdkExtraData.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "sdkExtraData", adBaseInfo.sdkExtraData);
        }
        if (adBaseInfo.adDescription != null && !adBaseInfo.adDescription.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adDescription", adBaseInfo.adDescription);
        }
        if (adBaseInfo.installAppLabel != null && !adBaseInfo.installAppLabel.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "installAppLabel", adBaseInfo.installAppLabel);
        }
        if (adBaseInfo.openAppLabel != null && !adBaseInfo.openAppLabel.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "openAppLabel", adBaseInfo.openAppLabel);
        }
        if (adBaseInfo.adMarkIcon != null && !adBaseInfo.adMarkIcon.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adMarkIcon", adBaseInfo.adMarkIcon);
        }
        if (adBaseInfo.adGrayMarkIcon != null && !adBaseInfo.adGrayMarkIcon.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adGrayMarkIcon", adBaseInfo.adGrayMarkIcon);
        }
        if (adBaseInfo.adSourceDescription != null && !adBaseInfo.adSourceDescription.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adSourceDescription", adBaseInfo.adSourceDescription);
        }
        if (adBaseInfo.adOperationType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adOperationType", adBaseInfo.adOperationType);
        }
        if (adBaseInfo.adActionDescription != null && !adBaseInfo.adActionDescription.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adActionDescription", adBaseInfo.adActionDescription);
        }
        if (adBaseInfo.adActionBarColor != null && !adBaseInfo.adActionBarColor.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adActionBarColor", adBaseInfo.adActionBarColor);
        }
        if (adBaseInfo.adShowDuration != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adShowDuration", adBaseInfo.adShowDuration);
        }
        if (adBaseInfo.appName != null && !adBaseInfo.appName.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "appName", adBaseInfo.appName);
        }
        if (adBaseInfo.realAppName != null && !adBaseInfo.realAppName.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "realAppName", adBaseInfo.realAppName);
        }
        if (adBaseInfo.appIconUrl != null && !adBaseInfo.appIconUrl.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "appIconUrl", adBaseInfo.appIconUrl);
        }
        if (adBaseInfo.appPackageName != null && !adBaseInfo.appPackageName.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "appPackageName", adBaseInfo.appPackageName);
        }
        if (adBaseInfo.appScore != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "appScore", adBaseInfo.appScore);
        }
        if (adBaseInfo.appDownloadCountDesc != null && !adBaseInfo.appDownloadCountDesc.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "appDownloadCountDesc", adBaseInfo.appDownloadCountDesc);
        }
        if (adBaseInfo.appCategory != null && !adBaseInfo.appCategory.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "appCategory", adBaseInfo.appCategory);
        }
        if (adBaseInfo.appVersion != null && !adBaseInfo.appVersion.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "appVersion", adBaseInfo.appVersion);
        }
        if (adBaseInfo.corporationName != null && !adBaseInfo.corporationName.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "corporationName", adBaseInfo.corporationName);
        }
        if (adBaseInfo.packageSize != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "packageSize", adBaseInfo.packageSize);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "appImageUrl", adBaseInfo.appImageUrl);
        com.kwad.sdk.utils.aa.a(jSONObject, "appImageSize", adBaseInfo.appImageSize);
        if (adBaseInfo.appDescription != null && !adBaseInfo.appDescription.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "appDescription", adBaseInfo.appDescription);
        }
        if (adBaseInfo.enableSkipAd != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "enableSkipAd", adBaseInfo.enableSkipAd);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "adCacheSwitch", adBaseInfo.adCacheSwitch);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "adCacheSecond", adBaseInfo.adCacheSecond);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "adCacheStrategy", adBaseInfo.adCacheStrategy);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "adCacheSize", adBaseInfo.adCacheSize);
        if (adBaseInfo.adRolloutSize != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adRolloutSize", adBaseInfo.adRolloutSize);
        }
        if (adBaseInfo.skipSecond != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "skipSecond", adBaseInfo.skipSecond);
        }
        if (adBaseInfo.ecpm != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, SplashAd.KEY_BIDFAIL_ECPM, adBaseInfo.ecpm);
        }
        if (adBaseInfo.videoPlayedNS != null && !adBaseInfo.videoPlayedNS.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "videoPlayedNS", adBaseInfo.videoPlayedNS);
        }
        if (adBaseInfo.videoPlayedNSConfig != null && !adBaseInfo.videoPlayedNSConfig.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "videoPlayedNSConfig", adBaseInfo.videoPlayedNSConfig);
        }
        if (adBaseInfo.productName != null && !adBaseInfo.productName.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "productName", adBaseInfo.productName);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "expParam", adBaseInfo.mABParams.toJson().toString());
        if (adBaseInfo.showUrl != null && !adBaseInfo.showUrl.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "showUrl", adBaseInfo.showUrl);
        }
        if (adBaseInfo.clickUrl != null && !adBaseInfo.clickUrl.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, Constants.KEYS.EXPOSED_CLICK_URL_KEY, adBaseInfo.clickUrl);
        }
        if (adBaseInfo.convUrl != null && !adBaseInfo.convUrl.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "convUrl", adBaseInfo.convUrl);
        }
        if (adBaseInfo.adAttributeType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adAttributeType", adBaseInfo.adAttributeType);
        }
        com.kwad.sdk.utils.aa.a(jSONObject, "apiExpParam", adBaseInfo.apiExpParam);
        if (adBaseInfo.taskType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "taskType", adBaseInfo.taskType);
        }
        if (adBaseInfo.campaignType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "campaignType", adBaseInfo.campaignType);
        }
        if (adBaseInfo.itemType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "itemType", adBaseInfo.itemType);
        }
        if (adBaseInfo.industryFirstLevelId != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "industryFirstLevelId", adBaseInfo.industryFirstLevelId);
        }
        if (adBaseInfo.extraClickReward) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "extraClickReward", adBaseInfo.extraClickReward);
        }
        if (adBaseInfo.enableClientProofreadTime) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "enableClientProofreadTime", adBaseInfo.enableClientProofreadTime);
        }
        return jSONObject;
    }
}
