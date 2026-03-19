package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class r implements com.kwad.sdk.core.d<AdMatrixInfo.AdDataV2> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdMatrixInfo.AdDataV2) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdMatrixInfo.AdDataV2) bVar, jSONObject);
    }

    private static void a(AdMatrixInfo.AdDataV2 adDataV2, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adDataV2.templateDataList = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("templateDatas");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                AdMatrixInfo.TemplateData templateData = new AdMatrixInfo.TemplateData();
                templateData.parseJson(jSONArrayOptJSONArray.optJSONObject(i));
                adDataV2.templateDataList.add(templateData);
            }
        }
        adDataV2.bottomBannerInfo = new AdMatrixInfo.BottomBannerInfo();
        adDataV2.bottomBannerInfo.parseJson(jSONObject.optJSONObject("bottomBannerInfo"));
        adDataV2.actionBarInfo = new AdMatrixInfo.ActionBarInfoNew();
        adDataV2.actionBarInfo.parseJson(jSONObject.optJSONObject("actionBarInfo"));
        adDataV2.aggregationCardInfo = new AdMatrixInfo.AggregationCardInfo();
        adDataV2.aggregationCardInfo.parseJson(jSONObject.optJSONObject("aggregationCardInfo"));
        adDataV2.halfCardInfo = new AdMatrixInfo.BaseMatrixTemplate();
        adDataV2.halfCardInfo.parseJson(jSONObject.optJSONObject("halfCardInfo"));
        adDataV2.endCardInfo = new AdMatrixInfo.EndCardInfo();
        adDataV2.endCardInfo.parseJson(jSONObject.optJSONObject("endCardInfo"));
        adDataV2.interstitialCardInfo = new AdMatrixInfo.InterstitialCardInfo();
        adDataV2.interstitialCardInfo.parseJson(jSONObject.optJSONObject("interstitialCardInfo"));
        adDataV2.feedInfo = new AdMatrixInfo.FeedInfo();
        adDataV2.feedInfo.parseJson(jSONObject.optJSONObject("feedInfo"));
        adDataV2.feedTKCardInfo = new AdMatrixInfo.FeedTKInfo();
        adDataV2.feedTKCardInfo.parseJson(jSONObject.optJSONObject("feedTKCardInfo"));
        adDataV2.drawTKCardInfo = new AdMatrixInfo.DrawTKInfo();
        adDataV2.drawTKCardInfo.parseJson(jSONObject.optJSONObject("drawTKCardInfo"));
        adDataV2.adUnionFeedLiveMediaInfo = new AdMatrixInfo.FeedInfo();
        adDataV2.adUnionFeedLiveMediaInfo.parseJson(jSONObject.optJSONObject("adUnionFeedLiveMediaInfo"));
        adDataV2.adUnionFeedLiveTemplateInfo = new AdMatrixInfo.FeedInfo();
        adDataV2.adUnionFeedLiveTemplateInfo.parseJson(jSONObject.optJSONObject("adUnionFeedLiveTemplateInfo"));
        adDataV2.nativeAdInfo = new AdMatrixInfo.NativeMatrixAdInfo();
        adDataV2.nativeAdInfo.parseJson(jSONObject.optJSONObject("nativeAdInfo"));
        adDataV2.complianceCardInfo = new AdMatrixInfo.BaseMatrixTemplate();
        adDataV2.complianceCardInfo.parseJson(jSONObject.optJSONObject("complianceCardInfo"));
        adDataV2.downloadConfirmCardInfo = new AdMatrixInfo.BaseMatrixTemplate();
        adDataV2.downloadConfirmCardInfo.parseJson(jSONObject.optJSONObject("downloadConfirmCardInfo"));
        adDataV2.splashInfo = new AdMatrixInfo.SplashInfo();
        adDataV2.splashInfo.parseJson(jSONObject.optJSONObject("splashInfo"));
        adDataV2.neoVideoInfo = new AdMatrixInfo.NeoVideoInfo();
        adDataV2.neoVideoInfo.parseJson(jSONObject.optJSONObject("neoVideoInfo"));
        adDataV2.fullScreenInfo = new AdMatrixInfo.FullScreenInfo();
        adDataV2.fullScreenInfo.parseJson(jSONObject.optJSONObject("fullScreenInfo"));
        adDataV2.middleTKCardInfo = new AdMatrixInfo.BaseMatrixTemplate();
        adDataV2.middleTKCardInfo.parseJson(jSONObject.optJSONObject("middleTKCardInfo"));
        adDataV2.actionBarTKInfo = new AdMatrixInfo.BaseMatrixTemplate();
        adDataV2.actionBarTKInfo.parseJson(jSONObject.optJSONObject("actionBarTKInfo"));
        adDataV2.topBarTKInfo = new AdMatrixInfo.BaseMatrixTemplate();
        adDataV2.topBarTKInfo.parseJson(jSONObject.optJSONObject("topBarTKInfo"));
        adDataV2.splashPlayCardTKInfo = new AdMatrixInfo.SplashPlayCardTKInfo();
        adDataV2.splashPlayCardTKInfo.parseJson(jSONObject.optJSONObject("splashPlayCardTKInfo"));
        adDataV2.splashEndCardTKInfo = new AdMatrixInfo.SplashEndCardTKInfo();
        adDataV2.splashEndCardTKInfo.parseJson(jSONObject.optJSONObject("splashEndCardTKInfo"));
        adDataV2.topFloorTKInfo = new AdMatrixInfo.TopFloorTKInfo();
        adDataV2.topFloorTKInfo.parseJson(jSONObject.optJSONObject("topFloorTKInfo"));
        adDataV2.activityMiddlePageInfo = new AdMatrixInfo.ActivityMiddlePageInfo();
        adDataV2.activityMiddlePageInfo.parseJson(jSONObject.optJSONObject("activityMiddlePageInfo"));
        adDataV2.bannerTKInfo = new AdMatrixInfo.AdBannerTKInfo();
        adDataV2.bannerTKInfo.parseJson(jSONObject.optJSONObject("bannerTKInfo"));
        adDataV2.confirmTKInfo = new AdMatrixInfo.BaseMatrixTemplate();
        adDataV2.confirmTKInfo.parseJson(jSONObject.optJSONObject("confirmTKInfo"));
        adDataV2.playendTKInfo = new AdMatrixInfo.BaseMatrixTemplate();
        adDataV2.playendTKInfo.parseJson(jSONObject.optJSONObject("playendTKInfo"));
        adDataV2.activityTKInfo = new AdMatrixInfo.BaseMatrixTemplate();
        adDataV2.activityTKInfo.parseJson(jSONObject.optJSONObject("activityTKInfo"));
        adDataV2.neoTKInfo = new AdMatrixInfo.BaseMatrixTemplate();
        adDataV2.neoTKInfo.parseJson(jSONObject.optJSONObject("neoTKInfo"));
        adDataV2.rewardVideoInteractInfo = new AdMatrixInfo.RewardVideoInteractInfo();
        adDataV2.rewardVideoInteractInfo.parseJson(jSONObject.optJSONObject("rewardVideoInteractInfo"));
        adDataV2.rewardVideoTaskInfo = new AdMatrixInfo.RewardVideoTaskInfo();
        adDataV2.rewardVideoTaskInfo.parseJson(jSONObject.optJSONObject("rewardVideoTaskInfo"));
        adDataV2.rewardWebTaskCloseInfo = new AdMatrixInfo.RewardWebTaskCloseInfo();
        adDataV2.rewardWebTaskCloseInfo.parseJson(jSONObject.optJSONObject("rewardWebTaskCloseInfo"));
        adDataV2.merchantLiveReservationInfo = new AdMatrixInfo.MerchantLiveReservationInfo();
        adDataV2.merchantLiveReservationInfo.parseJson(jSONObject.optJSONObject("merchantLiveReservationInfo"));
        adDataV2.pushTKInfo = new AdMatrixInfo.PushTKInfo();
        adDataV2.pushTKInfo.parseJson(jSONObject.optJSONObject("pushTKInfo"));
        adDataV2.splashActionBarInfo = new AdMatrixInfo.BaseMatrixTemplate();
        adDataV2.splashActionBarInfo.parseJson(jSONObject.optJSONObject("splashActionBarInfo"));
        adDataV2.videoLiveTKInfo = new AdMatrixInfo.BaseMatrixTemplate();
        adDataV2.videoLiveTKInfo.parseJson(jSONObject.optJSONObject("videoLiveTKInfo"));
        adDataV2.preLandingPageTKInfo = new AdMatrixInfo.PreLandingPageTKInfo();
        adDataV2.preLandingPageTKInfo.parseJson(jSONObject.optJSONObject("preLandingPageTKInfo"));
        adDataV2.installedActivateInfo = new AdMatrixInfo.InstalledActivateInfo();
        adDataV2.installedActivateInfo.parseJson(jSONObject.optJSONObject("installedActivateInfo"));
        adDataV2.videoImageTKInfo = new AdMatrixInfo.BaseMatrixTemplate();
        adDataV2.videoImageTKInfo.parseJson(jSONObject.optJSONObject("videoImageTKInfo"));
        adDataV2.dynamicAdStyleInfo = new AdMatrixInfo.DynamicAdStyleInfo();
        adDataV2.dynamicAdStyleInfo.parseJson(jSONObject.optJSONObject("dynamicAdStyleInfo"));
        adDataV2.styleComponentInfo = new AdMatrixInfo.StyleComponentInfo();
        adDataV2.styleComponentInfo.parseJson(jSONObject.optJSONObject("styleComponentInfo"));
    }

    private static JSONObject b(AdMatrixInfo.AdDataV2 adDataV2, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "templateDatas", adDataV2.templateDataList);
        com.kwad.sdk.utils.aa.a(jSONObject, "bottomBannerInfo", adDataV2.bottomBannerInfo);
        com.kwad.sdk.utils.aa.a(jSONObject, "actionBarInfo", adDataV2.actionBarInfo);
        com.kwad.sdk.utils.aa.a(jSONObject, "aggregationCardInfo", adDataV2.aggregationCardInfo);
        com.kwad.sdk.utils.aa.a(jSONObject, "halfCardInfo", adDataV2.halfCardInfo);
        com.kwad.sdk.utils.aa.a(jSONObject, "endCardInfo", adDataV2.endCardInfo);
        com.kwad.sdk.utils.aa.a(jSONObject, "interstitialCardInfo", adDataV2.interstitialCardInfo);
        com.kwad.sdk.utils.aa.a(jSONObject, "feedInfo", adDataV2.feedInfo);
        com.kwad.sdk.utils.aa.a(jSONObject, "feedTKCardInfo", adDataV2.feedTKCardInfo);
        com.kwad.sdk.utils.aa.a(jSONObject, "drawTKCardInfo", adDataV2.drawTKCardInfo);
        com.kwad.sdk.utils.aa.a(jSONObject, "adUnionFeedLiveMediaInfo", adDataV2.adUnionFeedLiveMediaInfo);
        com.kwad.sdk.utils.aa.a(jSONObject, "adUnionFeedLiveTemplateInfo", adDataV2.adUnionFeedLiveTemplateInfo);
        com.kwad.sdk.utils.aa.a(jSONObject, "nativeAdInfo", adDataV2.nativeAdInfo);
        com.kwad.sdk.utils.aa.a(jSONObject, "complianceCardInfo", adDataV2.complianceCardInfo);
        com.kwad.sdk.utils.aa.a(jSONObject, "downloadConfirmCardInfo", adDataV2.downloadConfirmCardInfo);
        com.kwad.sdk.utils.aa.a(jSONObject, "splashInfo", adDataV2.splashInfo);
        com.kwad.sdk.utils.aa.a(jSONObject, "neoVideoInfo", adDataV2.neoVideoInfo);
        com.kwad.sdk.utils.aa.a(jSONObject, "fullScreenInfo", adDataV2.fullScreenInfo);
        com.kwad.sdk.utils.aa.a(jSONObject, "middleTKCardInfo", adDataV2.middleTKCardInfo);
        com.kwad.sdk.utils.aa.a(jSONObject, "actionBarTKInfo", adDataV2.actionBarTKInfo);
        com.kwad.sdk.utils.aa.a(jSONObject, "topBarTKInfo", adDataV2.topBarTKInfo);
        com.kwad.sdk.utils.aa.a(jSONObject, "splashPlayCardTKInfo", adDataV2.splashPlayCardTKInfo);
        com.kwad.sdk.utils.aa.a(jSONObject, "splashEndCardTKInfo", adDataV2.splashEndCardTKInfo);
        com.kwad.sdk.utils.aa.a(jSONObject, "topFloorTKInfo", adDataV2.topFloorTKInfo);
        com.kwad.sdk.utils.aa.a(jSONObject, "activityMiddlePageInfo", adDataV2.activityMiddlePageInfo);
        com.kwad.sdk.utils.aa.a(jSONObject, "bannerTKInfo", adDataV2.bannerTKInfo);
        com.kwad.sdk.utils.aa.a(jSONObject, "confirmTKInfo", adDataV2.confirmTKInfo);
        com.kwad.sdk.utils.aa.a(jSONObject, "playendTKInfo", adDataV2.playendTKInfo);
        com.kwad.sdk.utils.aa.a(jSONObject, "activityTKInfo", adDataV2.activityTKInfo);
        com.kwad.sdk.utils.aa.a(jSONObject, "neoTKInfo", adDataV2.neoTKInfo);
        com.kwad.sdk.utils.aa.a(jSONObject, "rewardVideoInteractInfo", adDataV2.rewardVideoInteractInfo);
        com.kwad.sdk.utils.aa.a(jSONObject, "rewardVideoTaskInfo", adDataV2.rewardVideoTaskInfo);
        com.kwad.sdk.utils.aa.a(jSONObject, "rewardWebTaskCloseInfo", adDataV2.rewardWebTaskCloseInfo);
        com.kwad.sdk.utils.aa.a(jSONObject, "merchantLiveReservationInfo", adDataV2.merchantLiveReservationInfo);
        com.kwad.sdk.utils.aa.a(jSONObject, "pushTKInfo", adDataV2.pushTKInfo);
        com.kwad.sdk.utils.aa.a(jSONObject, "splashActionBarInfo", adDataV2.splashActionBarInfo);
        com.kwad.sdk.utils.aa.a(jSONObject, "videoLiveTKInfo", adDataV2.videoLiveTKInfo);
        com.kwad.sdk.utils.aa.a(jSONObject, "preLandingPageTKInfo", adDataV2.preLandingPageTKInfo);
        com.kwad.sdk.utils.aa.a(jSONObject, "installedActivateInfo", adDataV2.installedActivateInfo);
        com.kwad.sdk.utils.aa.a(jSONObject, "videoImageTKInfo", adDataV2.videoImageTKInfo);
        com.kwad.sdk.utils.aa.a(jSONObject, "dynamicAdStyleInfo", adDataV2.dynamicAdStyleInfo);
        com.kwad.sdk.utils.aa.a(jSONObject, "styleComponentInfo", adDataV2.styleComponentInfo);
        return jSONObject;
    }
}
