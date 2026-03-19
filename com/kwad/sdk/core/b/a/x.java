package com.kwad.sdk.core.b.a;

import com.baidu.mobstat.forbes.Config;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdStyleInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class x implements com.kwad.sdk.core.d<AdInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdInfo) bVar, jSONObject);
    }

    private static void a(AdInfo adInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adInfo.adBaseInfo = new AdInfo.AdBaseInfo();
        adInfo.adBaseInfo.parseJson(jSONObject.optJSONObject("adBaseInfo"));
        adInfo.advertiserInfo = new AdInfo.AdvertiserInfo();
        adInfo.advertiserInfo.parseJson(jSONObject.optJSONObject("advertiserInfo"));
        adInfo.adConversionInfo = new AdInfo.AdConversionInfo();
        adInfo.adConversionInfo.parseJson(jSONObject.optJSONObject("adConversionInfo"));
        adInfo.adMaterialInfo = new AdInfo.AdMaterialInfo();
        adInfo.adMaterialInfo.parseJson(jSONObject.optJSONObject("adMaterialInfo"));
        adInfo.adTrackInfoList = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("adTrackInfo");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                AdInfo.AdTrackInfo adTrackInfo = new AdInfo.AdTrackInfo();
                adTrackInfo.parseJson(jSONArrayOptJSONArray.optJSONObject(i));
                adInfo.adTrackInfoList.add(adTrackInfo);
            }
        }
        adInfo.downloadSafeInfo = new AdInfo.DownloadSafeInfo();
        adInfo.downloadSafeInfo.parseJson(jSONObject.optJSONObject("downloadSafeInfo"));
        adInfo.unDownloadConf = new AdInfo.UnDownloadConf();
        adInfo.unDownloadConf.parseJson(jSONObject.optJSONObject("unDownloadConf"));
        adInfo.status = jSONObject.optInt("status");
        adInfo.progress = jSONObject.optInt("progress");
        adInfo.soFarBytes = jSONObject.optLong("soFarBytes");
        adInfo.totalBytes = jSONObject.optLong("totalBytes");
        adInfo.downloadFilePath = jSONObject.optString("downloadFilePath");
        if (JSONObject.NULL.toString().equals(adInfo.downloadFilePath)) {
            adInfo.downloadFilePath = "";
        }
        adInfo.downloadId = jSONObject.optString("downloadId");
        if (JSONObject.NULL.toString().equals(adInfo.downloadId)) {
            adInfo.downloadId = "";
        }
        adInfo.mStartDownloadTime = jSONObject.optLong("mStartDownloadTime");
        adInfo.isAllowVideoAutoPlay = jSONObject.optBoolean("isAllowVideoAutoPlay");
        adInfo.ksUaPattern = jSONObject.optBoolean("ksUaPattern");
        adInfo.unionMark = jSONObject.optBoolean("unionMark");
        adInfo.adPreloadInfo = new AdInfo.AdPreloadInfo();
        adInfo.adPreloadInfo.parseJson(jSONObject.optJSONObject("adPreloadInfo"));
        adInfo.adSplashInfo = new AdInfo.AdSplashInfo();
        adInfo.adSplashInfo.parseJson(jSONObject.optJSONObject("adSplashInfo"));
        adInfo.adBannerInfo = new AdInfo.AdBannerInfo();
        adInfo.adBannerInfo.parseJson(jSONObject.optJSONObject("adBannerInfo"));
        adInfo.adDrawInfo = new AdInfo.AdDrawInfo();
        adInfo.adDrawInfo.parseJson(jSONObject.optJSONObject("adDrawInfo"));
        adInfo.adStyleInfo = new AdStyleInfo();
        adInfo.adStyleInfo.parseJson(jSONObject.optJSONObject("adStyleInfo"));
        adInfo.adStyleInfo2 = new AdStyleInfo();
        adInfo.adStyleInfo2.parseJson(jSONObject.optJSONObject("adStyleInfo2"));
        adInfo.adAggregateInfo = new AdInfo.AdAggregateInfo();
        adInfo.adAggregateInfo.parseJson(jSONObject.optJSONObject("adAggregateInfo"));
        adInfo.adRewardInfo = new AdInfo.AdRewardInfo();
        adInfo.adRewardInfo.parseJson(jSONObject.optJSONObject("adRewardInfo"));
        adInfo.serverExt = jSONObject.optString("serverExt");
        if (JSONObject.NULL.toString().equals(adInfo.serverExt)) {
            adInfo.serverExt = "";
        }
        adInfo.adStyleConfInfo = new AdInfo.AdStyleConfInfo();
        adInfo.adStyleConfInfo.parseJson(jSONObject.optJSONObject("adStyleConfInfo"));
        adInfo.fullScreenVideoInfo = new AdInfo.FullScreenVideoInfo();
        adInfo.fullScreenVideoInfo.parseJson(jSONObject.optJSONObject("fullScreenVideoInfo"));
        adInfo.adFeedInfo = new AdInfo.AdFeedInfo();
        adInfo.adFeedInfo.parseJson(jSONObject.optJSONObject("adFeedInfo"));
        adInfo.adInsertScreenInfo = new AdInfo.AdInsertScreenInfo();
        adInfo.adInsertScreenInfo.parseJson(jSONObject.optJSONObject("adInsertScreenInfo"));
        adInfo.adProductInfo = new AdProductInfo();
        adInfo.adProductInfo.parseJson(jSONObject.optJSONObject("adProductInfo"));
        adInfo.ocpcActionType = jSONObject.optInt("ocpcActionType");
        adInfo.adMatrixInfo = new AdMatrixInfo();
        adInfo.adMatrixInfo.parseJson(jSONObject.optJSONObject("adMatrixInfo"));
        adInfo.trace = jSONObject.optString(Config.TRACE_PART);
        if (JSONObject.NULL.toString().equals(adInfo.trace)) {
            adInfo.trace = "";
        }
    }

    private static JSONObject b(AdInfo adInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.aa.a(jSONObject, "adBaseInfo", adInfo.adBaseInfo);
        com.kwad.sdk.utils.aa.a(jSONObject, "advertiserInfo", adInfo.advertiserInfo);
        com.kwad.sdk.utils.aa.a(jSONObject, "adConversionInfo", adInfo.adConversionInfo);
        com.kwad.sdk.utils.aa.a(jSONObject, "adMaterialInfo", adInfo.adMaterialInfo);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "adTrackInfo", adInfo.adTrackInfoList);
        com.kwad.sdk.utils.aa.a(jSONObject, "downloadSafeInfo", adInfo.downloadSafeInfo);
        com.kwad.sdk.utils.aa.a(jSONObject, "unDownloadConf", adInfo.unDownloadConf);
        if (adInfo.status != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "status", adInfo.status);
        }
        if (adInfo.progress != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "progress", adInfo.progress);
        }
        if (adInfo.soFarBytes != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "soFarBytes", adInfo.soFarBytes);
        }
        if (adInfo.totalBytes != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "totalBytes", adInfo.totalBytes);
        }
        if (adInfo.downloadFilePath != null && !adInfo.downloadFilePath.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "downloadFilePath", adInfo.downloadFilePath);
        }
        if (adInfo.downloadId != null && !adInfo.downloadId.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "downloadId", adInfo.downloadId);
        }
        if (adInfo.mStartDownloadTime != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "mStartDownloadTime", adInfo.mStartDownloadTime);
        }
        if (adInfo.isAllowVideoAutoPlay) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "isAllowVideoAutoPlay", adInfo.isAllowVideoAutoPlay);
        }
        if (adInfo.ksUaPattern) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "ksUaPattern", adInfo.ksUaPattern);
        }
        if (adInfo.unionMark) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "unionMark", adInfo.unionMark);
        }
        com.kwad.sdk.utils.aa.a(jSONObject, "adPreloadInfo", adInfo.adPreloadInfo);
        com.kwad.sdk.utils.aa.a(jSONObject, "adSplashInfo", adInfo.adSplashInfo);
        com.kwad.sdk.utils.aa.a(jSONObject, "adBannerInfo", adInfo.adBannerInfo);
        com.kwad.sdk.utils.aa.a(jSONObject, "adDrawInfo", adInfo.adDrawInfo);
        com.kwad.sdk.utils.aa.a(jSONObject, "adStyleInfo", adInfo.adStyleInfo);
        com.kwad.sdk.utils.aa.a(jSONObject, "adStyleInfo2", adInfo.adStyleInfo2);
        com.kwad.sdk.utils.aa.a(jSONObject, "adAggregateInfo", adInfo.adAggregateInfo);
        com.kwad.sdk.utils.aa.a(jSONObject, "adRewardInfo", adInfo.adRewardInfo);
        if (adInfo.serverExt != null && !adInfo.serverExt.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "serverExt", adInfo.serverExt);
        }
        com.kwad.sdk.utils.aa.a(jSONObject, "adStyleConfInfo", adInfo.adStyleConfInfo);
        com.kwad.sdk.utils.aa.a(jSONObject, "fullScreenVideoInfo", adInfo.fullScreenVideoInfo);
        com.kwad.sdk.utils.aa.a(jSONObject, "adFeedInfo", adInfo.adFeedInfo);
        com.kwad.sdk.utils.aa.a(jSONObject, "adInsertScreenInfo", adInfo.adInsertScreenInfo);
        com.kwad.sdk.utils.aa.a(jSONObject, "adProductInfo", adInfo.adProductInfo);
        if (adInfo.ocpcActionType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "ocpcActionType", adInfo.ocpcActionType);
        }
        com.kwad.sdk.utils.aa.a(jSONObject, "adMatrixInfo", adInfo.adMatrixInfo);
        if (adInfo.trace != null && !adInfo.trace.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, Config.TRACE_PART, adInfo.trace);
        }
        return jSONObject;
    }
}
