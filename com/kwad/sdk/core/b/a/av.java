package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdStatusInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.AdVideoPreCacheConfig;
import com.kwad.sdk.core.response.model.PageInfo;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class av implements com.kwad.sdk.core.d<AdTemplate> {
    @Override // com.kwad.sdk.core.d
    public final /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        l((AdTemplate) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return m((AdTemplate) bVar, jSONObject);
    }

    private static void l(AdTemplate adTemplate, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adTemplate.mOriginJString = jSONObject.optString("mOriginJString");
        if (JSONObject.NULL.toString().equals(adTemplate.mOriginJString)) {
            adTemplate.mOriginJString = "";
        }
        adTemplate.posId = jSONObject.optLong("posId");
        adTemplate.adStyle = jSONObject.optInt("adStyle");
        adTemplate.type = jSONObject.optInt("type");
        adTemplate.subType = jSONObject.optInt("subType");
        adTemplate.defaultType = jSONObject.optInt("defaultType");
        adTemplate.contentType = jSONObject.optInt("contentType");
        adTemplate.adInfoList = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("adInfo");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                AdInfo adInfo = new AdInfo();
                adInfo.parseJson(jSONArrayOptJSONArray.optJSONObject(i));
                adTemplate.adInfoList.add(adInfo);
            }
        }
        adTemplate.impAdExtra = jSONObject.optString("impAdExtra");
        if (JSONObject.NULL.toString().equals(adTemplate.impAdExtra)) {
            adTemplate.impAdExtra = "";
        }
        adTemplate.llsid = jSONObject.optLong("llsid");
        adTemplate.mIsFromContent = jSONObject.optBoolean("mIsFromContent");
        adTemplate.extra = jSONObject.optString("extra");
        if (JSONObject.NULL.toString().equals(adTemplate.extra)) {
            adTemplate.extra = "";
        }
        adTemplate.mUniqueId = jSONObject.optString("mUniqueId");
        if (JSONObject.NULL.toString().equals(adTemplate.mUniqueId)) {
            adTemplate.mUniqueId = "";
        }
        adTemplate.mBidEcpm = jSONObject.optLong("mBidEcpm");
        adTemplate.mAdScene = new SceneImpl();
        adTemplate.mAdScene.parseJson(jSONObject.optJSONObject("mAdScene"));
        adTemplate.realShowType = jSONObject.optInt("realShowType");
        adTemplate.mInitVoiceStatus = jSONObject.optInt("mInitVoiceStatus");
        adTemplate.mMediaPlayerType = jSONObject.optInt("mMediaPlayerType");
        adTemplate.mVideoPlayerStatus = new VideoPlayerStatus();
        adTemplate.mVideoPlayerStatus.parseJson(jSONObject.optJSONObject("mVideoPlayerStatus"));
        adTemplate.mOutClickTimeParam = jSONObject.optLong("mOutClickTimeParam", new Long("-1").longValue());
        adTemplate.mVisibleTimeParam = jSONObject.optLong("mVisibleTimeParam", new Long("-1").longValue());
        adTemplate.mIsLeftSlipStatus = jSONObject.optInt("mIsLeftSlipStatus");
        adTemplate.mPhotoResponseType = jSONObject.optInt("mPhotoResponseType");
        adTemplate.mPageInfo = new PageInfo();
        adTemplate.mPageInfo.parseJson(jSONObject.optJSONObject("mPageInfo"));
        adTemplate.mIsForceJumpLandingPage = jSONObject.optBoolean("mIsForceJumpLandingPage", new Boolean("false").booleanValue());
        adTemplate.mIsAudioEnable = jSONObject.optBoolean("mIsAudioEnable");
        adTemplate.mRewardVerifyCalled = jSONObject.optBoolean("mRewardVerifyCalled");
        adTemplate.isWebViewDownload = jSONObject.optBoolean("isWebViewDownload");
        adTemplate.watched = jSONObject.optBoolean("watched");
        adTemplate.swipeAngle = jSONObject.optInt("swipeAngle");
        adTemplate.converted = jSONObject.optBoolean("converted");
        adTemplate.fromCache = jSONObject.optBoolean("fromCache", new Boolean("false").booleanValue());
        adTemplate.requestStartTime = jSONObject.optLong("requestStartTime");
        adTemplate.loadDataTime = jSONObject.optLong("loadDataTime");
        adTemplate.showStartTime = jSONObject.optLong("showStartTime");
        adTemplate.addStartTime = jSONObject.optLong("addStartTime");
        adTemplate.showTime = jSONObject.optLong("showTime");
        adTemplate.notNetworkRequest = jSONObject.optBoolean("notNetworkRequest");
        adTemplate.downloadDuration = jSONObject.optLong("downloadDuration");
        adTemplate.adLoadTotalTime = jSONObject.optLong("adLoadTotalTime");
        adTemplate.adShowStartTimeStamp = jSONObject.optLong("adShowStartTimeStamp");
        adTemplate.mAdStatusInfo = new AdStatusInfo();
        adTemplate.mAdStatusInfo.parseJson(jSONObject.optJSONObject("mAdStatusInfo"));
        adTemplate.adVideoPreCacheConfig = new AdVideoPreCacheConfig();
        adTemplate.adVideoPreCacheConfig.parseJson(jSONObject.optJSONObject("adVideoPreCacheConfig"));
        adTemplate.isNativeRewardPreview = jSONObject.optBoolean("isNativeRewardPreview");
        adTemplate.mInstallApkFromSDK = jSONObject.optBoolean("mInstallApkFromSDK");
        adTemplate.mInstallApkFormUser = jSONObject.optBoolean("mInstallApkFormUser");
        adTemplate.mClickOpenAppStore = jSONObject.optBoolean("mClickOpenAppStore");
        adTemplate.mDataLoadTraceElement = jSONObject.optString("mDataLoadTraceElement");
        if (JSONObject.NULL.toString().equals(adTemplate.mDataLoadTraceElement)) {
            adTemplate.mDataLoadTraceElement = "";
        }
        adTemplate.mDataCacheTraceElement = jSONObject.optString("mDataCacheTraceElement");
        if (JSONObject.NULL.toString().equals(adTemplate.mDataCacheTraceElement)) {
            adTemplate.mDataCacheTraceElement = "";
        }
        adTemplate.downLoadType = jSONObject.optInt("downLoadType", new Integer("3").intValue());
    }

    private static JSONObject m(AdTemplate adTemplate, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (adTemplate.mOriginJString != null && !adTemplate.mOriginJString.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "mOriginJString", adTemplate.mOriginJString);
        }
        if (adTemplate.posId != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "posId", adTemplate.posId);
        }
        if (adTemplate.adStyle != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adStyle", adTemplate.adStyle);
        }
        if (adTemplate.type != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "type", adTemplate.type);
        }
        if (adTemplate.subType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "subType", adTemplate.subType);
        }
        if (adTemplate.defaultType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "defaultType", adTemplate.defaultType);
        }
        if (adTemplate.contentType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "contentType", adTemplate.contentType);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "adInfo", adTemplate.adInfoList);
        if (adTemplate.impAdExtra != null && !adTemplate.impAdExtra.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "impAdExtra", adTemplate.impAdExtra);
        }
        if (adTemplate.llsid != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "llsid", adTemplate.llsid);
        }
        if (adTemplate.mIsFromContent) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "mIsFromContent", adTemplate.mIsFromContent);
        }
        if (adTemplate.extra != null && !adTemplate.extra.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "extra", adTemplate.extra);
        }
        if (adTemplate.mUniqueId != null && !adTemplate.mUniqueId.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "mUniqueId", adTemplate.mUniqueId);
        }
        if (adTemplate.mBidEcpm != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "mBidEcpm", adTemplate.mBidEcpm);
        }
        com.kwad.sdk.utils.aa.a(jSONObject, "mAdScene", adTemplate.mAdScene);
        if (adTemplate.realShowType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "realShowType", adTemplate.realShowType);
        }
        if (adTemplate.mInitVoiceStatus != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "mInitVoiceStatus", adTemplate.mInitVoiceStatus);
        }
        if (adTemplate.mMediaPlayerType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "mMediaPlayerType", adTemplate.mMediaPlayerType);
        }
        com.kwad.sdk.utils.aa.a(jSONObject, "mVideoPlayerStatus", adTemplate.mVideoPlayerStatus);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "mOutClickTimeParam", adTemplate.mOutClickTimeParam);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "mVisibleTimeParam", adTemplate.mVisibleTimeParam);
        if (adTemplate.mIsLeftSlipStatus != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "mIsLeftSlipStatus", adTemplate.mIsLeftSlipStatus);
        }
        if (adTemplate.mPhotoResponseType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "mPhotoResponseType", adTemplate.mPhotoResponseType);
        }
        com.kwad.sdk.utils.aa.a(jSONObject, "mPageInfo", adTemplate.mPageInfo);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "mIsForceJumpLandingPage", adTemplate.mIsForceJumpLandingPage);
        if (adTemplate.mIsAudioEnable) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "mIsAudioEnable", adTemplate.mIsAudioEnable);
        }
        if (adTemplate.mRewardVerifyCalled) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "mRewardVerifyCalled", adTemplate.mRewardVerifyCalled);
        }
        if (adTemplate.isWebViewDownload) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "isWebViewDownload", adTemplate.isWebViewDownload);
        }
        if (adTemplate.watched) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "watched", adTemplate.watched);
        }
        if (adTemplate.swipeAngle != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "swipeAngle", adTemplate.swipeAngle);
        }
        if (adTemplate.converted) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "converted", adTemplate.converted);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "fromCache", adTemplate.fromCache);
        if (adTemplate.requestStartTime != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "requestStartTime", adTemplate.requestStartTime);
        }
        if (adTemplate.loadDataTime != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "loadDataTime", adTemplate.loadDataTime);
        }
        if (adTemplate.showStartTime != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "showStartTime", adTemplate.showStartTime);
        }
        if (adTemplate.addStartTime != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "addStartTime", adTemplate.addStartTime);
        }
        if (adTemplate.showTime != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "showTime", adTemplate.showTime);
        }
        if (adTemplate.notNetworkRequest) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "notNetworkRequest", adTemplate.notNetworkRequest);
        }
        if (adTemplate.downloadDuration != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "downloadDuration", adTemplate.downloadDuration);
        }
        if (adTemplate.adLoadTotalTime != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adLoadTotalTime", adTemplate.adLoadTotalTime);
        }
        if (adTemplate.adShowStartTimeStamp != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adShowStartTimeStamp", adTemplate.adShowStartTimeStamp);
        }
        com.kwad.sdk.utils.aa.a(jSONObject, "mAdStatusInfo", adTemplate.mAdStatusInfo);
        com.kwad.sdk.utils.aa.a(jSONObject, "adVideoPreCacheConfig", adTemplate.adVideoPreCacheConfig);
        if (adTemplate.isNativeRewardPreview) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "isNativeRewardPreview", adTemplate.isNativeRewardPreview);
        }
        if (adTemplate.mInstallApkFromSDK) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "mInstallApkFromSDK", adTemplate.mInstallApkFromSDK);
        }
        if (adTemplate.mInstallApkFormUser) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "mInstallApkFormUser", adTemplate.mInstallApkFormUser);
        }
        if (adTemplate.mClickOpenAppStore) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "mClickOpenAppStore", adTemplate.mClickOpenAppStore);
        }
        if (adTemplate.mDataLoadTraceElement != null && !adTemplate.mDataLoadTraceElement.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "mDataLoadTraceElement", adTemplate.mDataLoadTraceElement);
        }
        if (adTemplate.mDataCacheTraceElement != null && !adTemplate.mDataCacheTraceElement.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "mDataCacheTraceElement", adTemplate.mDataCacheTraceElement);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "downLoadType", adTemplate.downLoadType);
        return jSONObject;
    }
}
