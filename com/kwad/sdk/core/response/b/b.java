package com.kwad.sdk.core.response.b;

import android.text.TextUtils;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.FeedSlideConf;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.utils.bq;
import java.util.List;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class b {
    private static Random bGS = new Random();

    public static AdMatrixInfo cF(AdTemplate adTemplate) {
        if (e.eH(adTemplate)) {
            return e.eP(adTemplate).adMatrixInfo;
        }
        return new AdMatrixInfo();
    }

    public static List<AdMatrixInfo.MatrixTemplate> cG(AdTemplate adTemplate) {
        return cF(adTemplate).styles.templateList;
    }

    public static AdMatrixInfo.AdDataV2 cH(AdTemplate adTemplate) {
        return e.eP(adTemplate).adMatrixInfo.adDataV2;
    }

    public static AdMatrixInfo.MatrixTemplate k(AdTemplate adTemplate, String str) {
        for (AdMatrixInfo.MatrixTemplate matrixTemplate : cF(adTemplate).styles.templateList) {
            if (bq.isEquals(str, matrixTemplate.templateId)) {
                return matrixTemplate;
            }
        }
        return null;
    }

    private static AdMatrixInfo.TemplateData l(AdTemplate adTemplate, String str) {
        for (AdMatrixInfo.TemplateData templateData : cF(adTemplate).adDataV2.templateDataList) {
            if (bq.isEquals(str, templateData.templateId)) {
                return templateData;
            }
        }
        return null;
    }

    private static long m(AdTemplate adTemplate, String str) {
        AdMatrixInfo.TemplateData templateDataL = l(adTemplate, str);
        if (templateDataL != null) {
            return templateDataL.templateDelayTime;
        }
        return 0L;
    }

    public static FeedSlideConf cI(AdTemplate adTemplate) {
        JSONArray jSONArrayOptJSONArray;
        AdMatrixInfo.TemplateData templateDataL = l(adTemplate, dm(adTemplate).templateId);
        try {
            JSONObject jSONObjectOptJSONObject = new JSONObject(templateDataL != null ? templateDataL.data : "").optJSONObject("slideInfo");
            if (jSONObjectOptJSONObject != null && (jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("angle")) != null && jSONArrayOptJSONArray.length() > 1) {
                FeedSlideConf feedSlideConf = new FeedSlideConf();
                feedSlideConf.minRange = ((Integer) jSONArrayOptJSONArray.get(0)).intValue();
                feedSlideConf.maxRange = ((Integer) jSONArrayOptJSONArray.get(1)).intValue();
                return feedSlideConf;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    private static AdMatrixInfo.BottomBannerInfo cJ(AdTemplate adTemplate) {
        return cF(adTemplate).adDataV2.bottomBannerInfo;
    }

    public static AdMatrixInfo.InterstitialCardInfo cK(AdTemplate adTemplate) {
        return cF(adTemplate).adDataV2.interstitialCardInfo;
    }

    public static String cL(AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate matrixTemplateK = k(adTemplate, cF(adTemplate).adDataV2.splashActionBarInfo.templateId);
        return matrixTemplateK != null ? matrixTemplateK.templateUrl : "";
    }

    public static String cM(AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate matrixTemplateK = k(adTemplate, cJ(adTemplate).templateId);
        return matrixTemplateK != null ? matrixTemplateK.templateUrl : "";
    }

    public static long cN(AdTemplate adTemplate) {
        return m(adTemplate, cJ(adTemplate).templateId);
    }

    public static int cO(AdTemplate adTemplate) {
        return cJ(adTemplate).bannerAdType;
    }

    public static int cP(AdTemplate adTemplate) {
        return cJ(adTemplate).bannerSizeType;
    }

    private static AdMatrixInfo.ActionBarInfoNew cQ(AdTemplate adTemplate) {
        return cF(adTemplate).adDataV2.actionBarInfo;
    }

    public static String cR(AdTemplate adTemplate) {
        AdInfo adInfoEP = e.eP(adTemplate);
        boolean z = e.ff(adTemplate) || e.eJ(adTemplate) == 2;
        if (a.df(adInfoEP)) {
            return "";
        }
        if (z && a.cE(adTemplate)) {
            AdMatrixInfo.MatrixTemplate matrixTemplateK = k(adTemplate, dS(adTemplate).templateId);
            return matrixTemplateK != null ? matrixTemplateK.templateUrl : "";
        }
        AdMatrixInfo.MatrixTemplate matrixTemplateK2 = k(adTemplate, cQ(adTemplate).templateId);
        return matrixTemplateK2 != null ? matrixTemplateK2.templateUrl : "";
    }

    public static boolean fN(String str) {
        try {
            return ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).dx(str);
        } catch (Exception unused) {
            return false;
        }
    }

    public static long cS(AdTemplate adTemplate) {
        return cQ(adTemplate).maxTimeOut;
    }

    public static long cT(AdTemplate adTemplate) {
        return m(adTemplate, cQ(adTemplate).templateId);
    }

    public static boolean cU(AdTemplate adTemplate) {
        return !TextUtils.isEmpty(cR(adTemplate));
    }

    private static AdMatrixInfo.AggregationCardInfo cV(AdTemplate adTemplate) {
        return cF(adTemplate).adDataV2.aggregationCardInfo;
    }

    public static String cW(AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate matrixTemplateK = k(adTemplate, cV(adTemplate).templateId);
        return matrixTemplateK != null ? matrixTemplateK.templateUrl : "";
    }

    public static long cX(AdTemplate adTemplate) {
        return m(adTemplate, cV(adTemplate).templateId);
    }

    public static long cY(AdTemplate adTemplate) {
        return cV(adTemplate).changeTime * 1000;
    }

    public static int cZ(AdTemplate adTemplate) {
        return cV(adTemplate).maxTimesPerDay;
    }

    public static long da(AdTemplate adTemplate) {
        return cV(adTemplate).intervalTime;
    }

    public static boolean db(AdTemplate adTemplate) {
        AdInfo adInfoEP = e.eP(adTemplate);
        return !a.aJ(adInfoEP) && a.av(adInfoEP);
    }

    public static boolean dc(AdTemplate adTemplate) {
        if (!TextUtils.isEmpty(cW(adTemplate)) && cX(adTemplate) > 0) {
            return aq.isOrientationPortrait();
        }
        return false;
    }

    private static AdMatrixInfo.BaseMatrixTemplate dd(AdTemplate adTemplate) {
        return cF(adTemplate).adDataV2.halfCardInfo;
    }

    public static String de(AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate matrixTemplateK = k(adTemplate, dd(adTemplate).templateId);
        return matrixTemplateK != null ? matrixTemplateK.templateUrl : "";
    }

    private static AdMatrixInfo.EndCardInfo df(AdTemplate adTemplate) {
        return cF(adTemplate).adDataV2.endCardInfo;
    }

    public static int dg(AdTemplate adTemplate) {
        return df(adTemplate).cardShowPlayCount;
    }

    public static String dh(AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate matrixTemplateK = k(adTemplate, df(adTemplate).templateId);
        return matrixTemplateK != null ? matrixTemplateK.templateUrl : "";
    }

    public static boolean di(AdTemplate adTemplate) {
        return !TextUtils.isEmpty(dh(adTemplate));
    }

    private static String dj(AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate matrixTemplateK = k(adTemplate, e.eP(adTemplate).adMatrixInfo.adDataV2.activityMiddlePageInfo.templateId);
        return matrixTemplateK != null ? matrixTemplateK.templateUrl : "";
    }

    public static String dk(AdTemplate adTemplate) {
        if (dl(adTemplate)) {
            return dj(adTemplate);
        }
        return a.aW(e.eP(adTemplate));
    }

    private static boolean dl(AdTemplate adTemplate) {
        return (adTemplate.mIsForceJumpLandingPage || a.cC(adTemplate) || !dR(e.eP(adTemplate))) ? false : true;
    }

    private static AdMatrixInfo.FeedInfo dm(AdTemplate adTemplate) {
        if (m457do(adTemplate)) {
            return cF(adTemplate).adDataV2.adUnionFeedLiveTemplateInfo;
        }
        return cF(adTemplate).adDataV2.feedInfo;
    }

    private static AdMatrixInfo.NativeMatrixAdInfo dn(AdTemplate adTemplate) {
        return cF(adTemplate).adDataV2.nativeAdInfo;
    }

    /* renamed from: do, reason: not valid java name */
    private static boolean m457do(AdTemplate adTemplate) {
        return a.df(e.eP(adTemplate));
    }

    private static AdMatrixInfo.FeedInfo dp(AdTemplate adTemplate) {
        return cF(adTemplate).adDataV2.adUnionFeedLiveMediaInfo;
    }

    public static String dq(AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate matrixTemplateK = k(adTemplate, dm(adTemplate).templateId);
        return matrixTemplateK != null ? matrixTemplateK.templateUrl : "";
    }

    private static AdMatrixInfo.FeedTKInfo dr(AdTemplate adTemplate) {
        return cF(adTemplate).adDataV2.feedTKCardInfo;
    }

    public static String ds(AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate matrixTemplateK = k(adTemplate, dp(adTemplate).templateId);
        return matrixTemplateK != null ? matrixTemplateK.templateUrl : "";
    }

    public static boolean dt(AdTemplate adTemplate) {
        return dm(adTemplate).interactionInfo.interactiveStyle == 2;
    }

    public static boolean du(AdTemplate adTemplate) {
        return dm(adTemplate).interactionInfo.shakeInfo.clickDisabled;
    }

    public static int dv(AdTemplate adTemplate) {
        AdMatrixInfo.AdInteractionInfo adInteractionInfo = dm(adTemplate).interactionInfo;
        if (adInteractionInfo == null || adInteractionInfo.shakeInfo == null) {
            return 0;
        }
        return adInteractionInfo.shakeInfo.acceleration;
    }

    public static boolean dw(AdTemplate adTemplate) {
        AdMatrixInfo.AdInteractionInfo adInteractionInfo = dn(adTemplate).interactionInfo;
        if (adInteractionInfo == null || adInteractionInfo.shakeInfo == null) {
            return false;
        }
        return adInteractionInfo.shakeInfo.enable;
    }

    public static int dx(AdTemplate adTemplate) {
        AdMatrixInfo.AdInteractionInfo adInteractionInfo = dn(adTemplate).interactionInfo;
        if (adInteractionInfo == null || adInteractionInfo.shakeInfo == null) {
            return 0;
        }
        return adInteractionInfo.shakeInfo.acceleration;
    }

    public static double dy(AdTemplate adTemplate) {
        return e.eP(adTemplate).adStyleInfo.feedAdInfo.heightRatio;
    }

    public static boolean dM(AdInfo adInfo) {
        return !TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.splashEndCardTKInfo.templateId);
    }

    public static boolean dN(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashEndCardTKInfo.endCardFullScreenClick;
    }

    public static boolean dO(AdInfo adInfo) {
        return !TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.topFloorTKInfo.templateId);
    }

    public static boolean dP(AdInfo adInfo) {
        return !TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.splashPlayCardTKInfo.templateId);
    }

    public static boolean dQ(AdInfo adInfo) {
        if (dR(adInfo)) {
            return adInfo.adMatrixInfo.adDataV2.activityMiddlePageInfo.showHeaderBar;
        }
        return true;
    }

    public static boolean dR(AdInfo adInfo) {
        return !TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.activityMiddlePageInfo.templateId);
    }

    public static String dS(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.rotateInfo.title;
    }

    public static String dT(AdInfo adInfo) {
        try {
            return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.shakeInfo.subtitle;
        } catch (Exception unused) {
            return "摇一摇";
        }
    }

    public static long dU(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.tkDefaultTimeout;
    }

    public static String dV(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.rotateInfo.subTitle;
    }

    public static String dW(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.splashActionBarInfo.title;
    }

    public static boolean dz(AdTemplate adTemplate) {
        return !TextUtils.isEmpty(dq(adTemplate));
    }

    public static boolean dA(AdTemplate adTemplate) {
        return !TextUtils.isEmpty(dr(adTemplate).templateId);
    }

    public static boolean dB(AdTemplate adTemplate) {
        return !TextUtils.isEmpty(eu(adTemplate));
    }

    public static String dC(AdTemplate adTemplate) {
        AdMatrixInfo.FeedTKInfo feedTKInfoDr = dr(adTemplate);
        return TextUtils.isEmpty(feedTKInfoDr.templateId) ? "ksad-feed-card" : feedTKInfoDr.templateId;
    }

    public static boolean dD(AdTemplate adTemplate) {
        return !TextUtils.isEmpty(ds(adTemplate));
    }

    private static AdMatrixInfo.InterstitialCardInfo dE(AdTemplate adTemplate) {
        return cF(adTemplate).adDataV2.interstitialCardInfo;
    }

    public static boolean dX(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.interstitialCardInfo.interactionInfo.interactiveStyle == 2;
    }

    public static float dF(AdTemplate adTemplate) {
        int i;
        try {
            i = e.eP(adTemplate).adMatrixInfo.adDataV2.interstitialCardInfo.interactionInfo.shakeInfo.acceleration;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            i = 7;
        }
        if (i > 0) {
            return i;
        }
        return 7.0f;
    }

    public static boolean dG(AdTemplate adTemplate) {
        try {
            return e.eP(adTemplate).adMatrixInfo.adDataV2.interstitialCardInfo.renderType == 1;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            return false;
        }
    }

    public static String dH(AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate matrixTemplateK = k(adTemplate, dE(adTemplate).templateId);
        return matrixTemplateK != null ? matrixTemplateK.templateUrl : "";
    }

    public static float dI(AdTemplate adTemplate) {
        int i;
        try {
            i = e.eP(adTemplate).adMatrixInfo.adDataV2.splashInfo.interactionInfo.shakeInfo.acceleration;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            i = 7;
        }
        return i;
    }

    public static AdMatrixInfo.RotateInfo dJ(AdTemplate adTemplate) {
        try {
            return e.eP(adTemplate).adMatrixInfo.adDataV2.splashInfo.interactionInfo.rotateInfo;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            return null;
        }
    }

    public static AdMatrixInfo.RotateInfo dK(AdTemplate adTemplate) {
        try {
            AdMatrixInfo.AdInteractionInfo adInteractionInfo = dm(adTemplate).interactionInfo;
            if (adInteractionInfo != null) {
                return adInteractionInfo.rotateInfo;
            }
            return null;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            return null;
        }
    }

    public static AdMatrixInfo.RotateInfo dL(AdTemplate adTemplate) {
        try {
            AdMatrixInfo.AdInteractionInfo adInteractionInfo = dn(adTemplate).interactionInfo;
            if (adInteractionInfo != null) {
                return adInteractionInfo.rotateInfo;
            }
            return null;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            return null;
        }
    }

    public static int dY(AdInfo adInfo) {
        try {
            int i = adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.shakeInfo.componentIndex;
            if (i != 2) {
                return 1;
            }
            return i;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            return 1;
        }
    }

    public static boolean dZ(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.isMediaDisable && adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle == 4;
    }

    public static boolean ea(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle == 2;
    }

    public static int eb(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle;
    }

    public static int ec(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactivityDefaultStyle;
    }

    public static boolean ed(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactivityDefaultStyle == 2;
    }

    public static boolean ee(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle == 1;
    }

    public static boolean ef(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactivityDefaultStyle == 1;
    }

    public static boolean eg(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle == 3;
    }

    public static boolean eh(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle == 10;
    }

    public static boolean ei(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactivityDefaultStyle == 3;
    }

    public static boolean ej(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactivityDefaultStyle == 10;
    }

    public static boolean ek(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactivityDefaultStyle == 9;
    }

    public static boolean el(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactivityDefaultStyle == 12;
    }

    public static boolean em(AdInfo adInfo) {
        try {
            if (adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle != 4) {
                return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle == 9;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean en(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle == 4;
    }

    public static boolean eo(AdInfo adInfo) {
        return !adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.shakeInfo.clickDisabled;
    }

    public static long ep(AdInfo adInfo) {
        try {
            long j = adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.switchDefaultTime;
            if (j <= 0) {
                return 1500L;
            }
            return j;
        } catch (Exception unused) {
            return 1500L;
        }
    }

    public static boolean eq(AdInfo adInfo) {
        return !adInfo.adMatrixInfo.adDataV2.neoVideoInfo.interactionInfo.shakeInfo.clickDisabled;
    }

    public static boolean g(AdInfo adInfo) {
        return (!adInfo.adRewardInfo.recommendAggregateSwitch || a.dl(adInfo) || a.bT(adInfo)) ? false : true;
    }

    private static AdMatrixInfo.BaseMatrixTemplate dM(AdTemplate adTemplate) {
        return cF(adTemplate).adDataV2.complianceCardInfo;
    }

    public static String dN(AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate matrixTemplateK = k(adTemplate, dM(adTemplate).templateId);
        return matrixTemplateK != null ? matrixTemplateK.templateUrl : "";
    }

    public static boolean dO(AdTemplate adTemplate) {
        return !TextUtils.isEmpty(dN(adTemplate));
    }

    private static AdMatrixInfo.BaseMatrixTemplate dP(AdTemplate adTemplate) {
        return cF(adTemplate).adDataV2.downloadConfirmCardInfo;
    }

    public static String dQ(AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate matrixTemplateK = k(adTemplate, dP(adTemplate).templateId);
        return matrixTemplateK != null ? matrixTemplateK.templateUrl : "";
    }

    public static boolean dR(AdTemplate adTemplate) {
        return !TextUtils.isEmpty(dQ(adTemplate));
    }

    public static AdMatrixInfo.MerchantLiveReservationInfo dS(AdTemplate adTemplate) {
        return cF(adTemplate).adDataV2.merchantLiveReservationInfo;
    }

    public static AdMatrixInfo.FullScreenInfo dT(AdTemplate adTemplate) {
        return cF(adTemplate).adDataV2.fullScreenInfo;
    }

    public static AdMatrixInfo.SplashPlayCardTKInfo dU(AdTemplate adTemplate) {
        return cF(adTemplate).adDataV2.splashPlayCardTKInfo;
    }

    public static long dV(AdTemplate adTemplate) {
        return cF(adTemplate).adDataV2.splashPlayCardTKInfo.tkTimeout;
    }

    public static int dW(AdTemplate adTemplate) {
        return cF(adTemplate).adDataV2.splashPlayCardTKInfo.renderType;
    }

    public static AdMatrixInfo.AdBannerTKInfo dX(AdTemplate adTemplate) {
        return cF(adTemplate).adDataV2.bannerTKInfo;
    }

    public static boolean dY(AdTemplate adTemplate) {
        AdInfo adInfoEP = e.eP(adTemplate);
        if (g(adInfoEP) || e.eX(adTemplate)) {
            return false;
        }
        return !(cQ(adTemplate).cardType == 4) && e.eP(adTemplate).adStyleInfo2.playDetailInfo.detailCommonInfo.rewardInteractionType <= 0 && adInfoEP.adMatrixInfo.adDataV2.fullScreenInfo.interactionInfo.interactiveStyle == 2;
    }

    public static boolean dZ(AdTemplate adTemplate) {
        AdInfo adInfoEP = e.eP(adTemplate);
        if (g(adInfoEP) || e.eX(adTemplate)) {
            return false;
        }
        return ((cQ(adTemplate).cardType == 4) || e.eP(adTemplate).adStyleInfo2.playDetailInfo.detailWebCardInfo.cardType == 4 || adInfoEP.adMatrixInfo.adDataV2.neoVideoInfo.interactionInfo.interactiveStyle != 2) ? false : true;
    }

    public static float er(AdInfo adInfo) {
        int i;
        try {
            i = adInfo.adMatrixInfo.adDataV2.fullScreenInfo.interactionInfo.shakeInfo.acceleration;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            i = 7;
        }
        return i;
    }

    public static float es(AdInfo adInfo) {
        int i;
        try {
            i = adInfo.adMatrixInfo.adDataV2.neoVideoInfo.interactionInfo.shakeInfo.acceleration;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            i = 7;
        }
        return i;
    }

    public static String et(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.fullScreenInfo.interactionInfo.shakeInfo.title;
    }

    public static String eu(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.neoVideoInfo.interactionInfo.shakeInfo.title;
    }

    public static String ev(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.fullScreenInfo.interactionInfo.shakeInfo.subtitle;
    }

    public static String ew(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.neoVideoInfo.interactionInfo.shakeInfo.subtitle;
    }

    public static AdMatrixInfo.DownloadTexts ex(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.fullScreenInfo.interactionInfo.splashActionBarInfo.downloadTexts;
    }

    public static AdMatrixInfo.DownloadTexts ey(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.neoVideoInfo.interactionInfo.splashActionBarInfo.downloadTexts;
    }

    public static boolean ez(AdInfo adInfo) {
        for (AdMatrixInfo.MatrixTag matrixTag : adInfo.adMatrixInfo.tag) {
            if ("playEndClose".equals(matrixTag.type)) {
                return matrixTag.isHide;
            }
        }
        return false;
    }

    public static boolean eA(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.neoTKInfo.renderType == 1;
    }

    public static int a(boolean z, AdInfo adInfo) {
        if (z) {
            return adInfo.adMatrixInfo.adDataV2.neoTKInfo.renderType;
        }
        return adInfo.adMatrixInfo.adDataV2.fullScreenInfo.renderType;
    }

    public static boolean eB(AdInfo adInfo) {
        return (a.bT(adInfo) || TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.preLandingPageTKInfo.templateId)) ? false : true;
    }

    public static int eC(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.preLandingPageTKInfo.preLandingPageShowType;
    }

    public static String eD(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.videoLiveTKInfo.templateId;
    }

    public static AdMatrixInfo.PreLandingPageTKInfo ea(AdTemplate adTemplate) {
        return e.eP(adTemplate).adMatrixInfo.adDataV2.preLandingPageTKInfo;
    }

    public static boolean eb(AdTemplate adTemplate) {
        return cH(adTemplate).installedActivateInfo.cardSwitch;
    }

    public static long ec(AdTemplate adTemplate) {
        long j = cH(adTemplate).installedActivateInfo.showTime;
        if (j > 0) {
            return j;
        }
        return 0L;
    }

    public static boolean eE(AdInfo adInfo) {
        return a.bj(adInfo) && !TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.videoImageTKInfo.templateId);
    }

    public static String ed(AdTemplate adTemplate) {
        return cH(adTemplate).topFloorTKInfo.templateId;
    }

    public static String ee(AdTemplate adTemplate) {
        return cH(adTemplate).neoTKInfo.templateId;
    }

    public static String ef(AdTemplate adTemplate) {
        return cH(adTemplate).videoLiveTKInfo.templateId;
    }

    public static String eg(AdTemplate adTemplate) {
        return cH(adTemplate).videoImageTKInfo.templateId;
    }

    public static String eh(AdTemplate adTemplate) {
        return cH(adTemplate).fullScreenInfo.templateId;
    }

    public static String ei(AdTemplate adTemplate) {
        return cH(adTemplate).rewardVideoTaskInfo.templateId;
    }

    public static String ej(AdTemplate adTemplate) {
        return cH(adTemplate).splashPlayCardTKInfo.templateId;
    }

    public static String ek(AdTemplate adTemplate) {
        return cH(adTemplate).splashEndCardTKInfo.templateId;
    }

    public static String el(AdTemplate adTemplate) {
        return cH(adTemplate).bannerTKInfo.templateId;
    }

    public static String em(AdTemplate adTemplate) {
        return cH(adTemplate).interstitialCardInfo.templateId;
    }

    public static String en(AdTemplate adTemplate) {
        return cH(adTemplate).confirmTKInfo.templateId;
    }

    public static String eo(AdTemplate adTemplate) {
        return cH(adTemplate).activityTKInfo.templateId;
    }

    public static String ep(AdTemplate adTemplate) {
        return cH(adTemplate).rewardWebTaskCloseInfo.templateId;
    }

    public static String eq(AdTemplate adTemplate) {
        return cH(adTemplate).rewardVideoInteractInfo.templateId;
    }

    public static String er(AdTemplate adTemplate) {
        return cH(adTemplate).pushTKInfo.templateId;
    }

    public static String es(AdTemplate adTemplate) {
        return cH(adTemplate).preLandingPageTKInfo.templateId;
    }

    public static String et(AdTemplate adTemplate) {
        return cH(adTemplate).feedTKCardInfo.templateId;
    }

    public static String eu(AdTemplate adTemplate) {
        return cH(adTemplate).drawTKCardInfo.templateId;
    }
}
