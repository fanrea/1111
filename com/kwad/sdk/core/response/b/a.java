package com.kwad.sdk.core.response.b;

import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import com.baidu.mobads.sdk.internal.cm;
import com.kwad.sdk.api.model.KSAdInfoData;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aj;
import com.kwad.sdk.utils.ap;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.utils.bq;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class a {
    public static String abI() {
        return "继续下载";
    }

    public static String abJ() {
        return "继续下载";
    }

    public static long K(AdInfo adInfo) {
        return adInfo.adBaseInfo.creativeId;
    }

    public static String L(AdInfo adInfo) {
        return aZ(adInfo).materialUrl;
    }

    public static int M(AdInfo adInfo) {
        if (bk(adInfo) == 2) {
            return aY(adInfo).videoDuration;
        }
        return aZ(adInfo).videoDuration;
    }

    public static long N(AdInfo adInfo) {
        int i;
        if (bk(adInfo) == 2) {
            i = aY(adInfo).videoDuration;
        } else {
            i = aZ(adInfo).videoDuration;
        }
        return i * 1000;
    }

    public static AdInfo.AdMaterialInfo.MaterialFeature O(AdInfo adInfo) {
        List<AdInfo.AdMaterialInfo.MaterialFeature> list = adInfo.adMaterialInfo.materialFeatureList;
        if (ap.aM(list)) {
            return list.get(0);
        }
        return new AdInfo.AdMaterialInfo.MaterialFeature();
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String P(com.kwad.sdk.core.response.model.AdInfo r6) {
        /*
            int r0 = bk(r6)
            r1 = 3
            r2 = 1
            if (r0 == r2) goto L35
            r3 = 2
            if (r0 == r3) goto L12
            if (r0 == r1) goto L12
            r2 = 8
            if (r0 == r2) goto L58
            goto L7b
        L12:
            com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo r0 = r6.adMaterialInfo
            java.util.List<com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo$MaterialFeature> r0 = r0.materialFeatureList
            java.util.Iterator r0 = r0.iterator()
        L1a:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L35
            java.lang.Object r4 = r0.next()
            com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo$MaterialFeature r4 = (com.kwad.sdk.core.response.model.AdInfo.AdMaterialInfo.MaterialFeature) r4
            int r5 = r4.featureType
            if (r5 != r3) goto L1a
            java.lang.String r5 = r4.firstFrame
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L1a
            java.lang.String r6 = r4.firstFrame
            return r6
        L35:
            com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo r0 = r6.adMaterialInfo
            java.util.List<com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo$MaterialFeature> r0 = r0.materialFeatureList
            java.util.Iterator r0 = r0.iterator()
        L3d:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L58
            java.lang.Object r3 = r0.next()
            com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo$MaterialFeature r3 = (com.kwad.sdk.core.response.model.AdInfo.AdMaterialInfo.MaterialFeature) r3
            int r4 = r3.featureType
            if (r4 != r2) goto L3d
            java.lang.String r4 = r3.firstFrame
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L3d
            java.lang.String r6 = r3.firstFrame
            return r6
        L58:
            com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo r6 = r6.adMaterialInfo
            java.util.List<com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo$MaterialFeature> r6 = r6.materialFeatureList
            java.util.Iterator r6 = r6.iterator()
        L60:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L7b
            java.lang.Object r0 = r6.next()
            com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo$MaterialFeature r0 = (com.kwad.sdk.core.response.model.AdInfo.AdMaterialInfo.MaterialFeature) r0
            int r2 = r0.featureType
            if (r2 != r1) goto L60
            java.lang.String r2 = r0.firstFrame
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L60
            java.lang.String r6 = r0.firstFrame
            return r6
        L7b:
            java.lang.String r6 = ""
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.response.b.a.P(com.kwad.sdk.core.response.model.AdInfo):java.lang.String");
    }

    public static boolean Q(AdInfo adInfo) {
        return adInfo.adConversionInfo.supportThirdDownload == 1;
    }

    public static int R(AdInfo adInfo) {
        return aZ(adInfo).videoWidth;
    }

    public static int S(AdInfo adInfo) {
        return aZ(adInfo).videoHeight;
    }

    public static boolean a(AdInfo.SmallAppJumpInfo smallAppJumpInfo) {
        return (smallAppJumpInfo == null || TextUtils.isEmpty(smallAppJumpInfo.mediaSmallAppId) || TextUtils.isEmpty(smallAppJumpInfo.originId) || TextUtils.isEmpty(smallAppJumpInfo.smallAppJumpUrl)) ? false : true;
    }

    public static boolean T(AdInfo adInfo) {
        return adInfo.adConversionInfo.webUriSourceType == 2;
    }

    public static boolean U(AdInfo adInfo) {
        return adInfo.adConversionInfo.appSecondConfirmationSwitch;
    }

    public static List<Integer> V(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.dynamicAdStyleInfo.slideInfo.angle;
    }

    public static boolean W(AdInfo adInfo) {
        return adInfo.adConversionInfo.h5SecondConfirmationSwitch;
    }

    public static boolean X(AdInfo adInfo) {
        AdInfo.AdMaterialInfo.MaterialFeature materialFeatureAZ = aZ(adInfo);
        return materialFeatureAZ.videoWidth <= materialFeatureAZ.videoHeight;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x004f  */
    @java.lang.Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String Y(com.kwad.sdk.core.response.model.AdInfo r6) {
        /*
            int r0 = bk(r6)
            r1 = 3
            r2 = 1
            if (r0 == r2) goto L41
            r3 = 2
            if (r0 == r3) goto L13
            if (r0 == r1) goto L13
            r2 = 8
            if (r0 == r2) goto L64
            goto L87
        L13:
            com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo r0 = r6.adMaterialInfo
            java.util.List<com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo$MaterialFeature> r0 = r0.materialFeatureList
            java.util.Iterator r0 = r0.iterator()
        L1b:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L41
            java.lang.Object r4 = r0.next()
            com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo$MaterialFeature r4 = (com.kwad.sdk.core.response.model.AdInfo.AdMaterialInfo.MaterialFeature) r4
            int r5 = r4.featureType
            if (r5 != r3) goto L1b
            java.lang.String r5 = r4.materialUrl
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L36
            java.lang.String r6 = r4.materialUrl
            return r6
        L36:
            java.lang.String r5 = r4.coverUrl
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L1b
            java.lang.String r6 = r4.coverUrl
            return r6
        L41:
            com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo r0 = r6.adMaterialInfo
            java.util.List<com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo$MaterialFeature> r0 = r0.materialFeatureList
            java.util.Iterator r0 = r0.iterator()
        L49:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L64
            java.lang.Object r3 = r0.next()
            com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo$MaterialFeature r3 = (com.kwad.sdk.core.response.model.AdInfo.AdMaterialInfo.MaterialFeature) r3
            int r4 = r3.featureType
            if (r4 != r2) goto L49
            java.lang.String r4 = r3.coverUrl
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L49
            java.lang.String r6 = r3.coverUrl
            return r6
        L64:
            com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo r6 = r6.adMaterialInfo
            java.util.List<com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo$MaterialFeature> r6 = r6.materialFeatureList
            java.util.Iterator r6 = r6.iterator()
        L6c:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L87
            java.lang.Object r0 = r6.next()
            com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo$MaterialFeature r0 = (com.kwad.sdk.core.response.model.AdInfo.AdMaterialInfo.MaterialFeature) r0
            int r2 = r0.featureType
            if (r2 != r1) goto L6c
            java.lang.String r2 = r0.coverUrl
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L6c
            java.lang.String r6 = r0.coverUrl
            return r6
        L87:
            java.lang.String r6 = ""
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.response.b.a.Y(com.kwad.sdk.core.response.model.AdInfo):java.lang.String");
    }

    public static String Z(AdInfo adInfo) {
        int iBk = bk(adInfo);
        if (iBk != 1) {
            if (iBk != 2 && iBk != 3) {
                return "";
            }
            for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature : adInfo.adMaterialInfo.materialFeatureList) {
                if (materialFeature.featureType == 2 && !TextUtils.isEmpty(materialFeature.blurBackgroundUrl)) {
                    return materialFeature.blurBackgroundUrl;
                }
            }
        }
        return bb(adInfo).blurBackgroundUrl;
    }

    public static String aa(AdInfo adInfo) {
        return aZ(adInfo).webpCoverUrl;
    }

    private static int ab(AdInfo adInfo) {
        return aZ(adInfo).width;
    }

    private static int ac(AdInfo adInfo) {
        return aZ(adInfo).height;
    }

    public static long ad(AdInfo adInfo) {
        return aZ(adInfo).photoId;
    }

    public static String I(int i, String str) {
        if (str == null) {
            str = "下载中  %s%%";
        }
        return String.format(str, Integer.valueOf(i));
    }

    @Deprecated
    public static String ft(int i) {
        return I(i, "下载中  %s%%");
    }

    public static String fu(int i) {
        return "下载中..." + i + "%";
    }

    public static String b(AdInfo adInfo, int i) {
        return "下载中..." + i + "%  (" + J(adInfo.totalBytes * (i / 100.0f)) + "/" + J(adInfo.totalBytes) + ")";
    }

    public static String fv(int i) {
        return "继续下载 " + i + "%";
    }

    private static String J(float f) {
        return String.format("%.1fM", Float.valueOf((f / 1000.0f) / 1000.0f));
    }

    public static String cB(AdTemplate adTemplate) {
        if (adTemplate != null && adTemplate.mAdScene != null && adTemplate.mAdScene.getAdStyle() == 2 && !de(e.eP(adTemplate)) && !df(e.eP(adTemplate))) {
            return "安装获取奖励";
        }
        if (adTemplate == null) {
            return "立即安装";
        }
        AdInfo adInfoEP = e.eP(adTemplate);
        return TextUtils.isEmpty(adInfoEP.adBaseInfo.installAppLabel) ? "立即安装" : adInfoEP.adBaseInfo.installAppLabel;
    }

    public static boolean cC(AdTemplate adTemplate) {
        return e.eP(adTemplate).adBaseInfo.apiExpParam.aggregateMiddlePageShowPathSwitch;
    }

    public static String cD(AdTemplate adTemplate) {
        return e.eP(adTemplate).adMatrixInfo.adDataV2.rewardWebTaskCloseInfo.templateId;
    }

    public static String ae(AdInfo adInfo) {
        return (adInfo == null || TextUtils.isEmpty(adInfo.adBaseInfo.openAppLabel)) ? "立即打开" : adInfo.adBaseInfo.openAppLabel;
    }

    public static long af(AdInfo adInfo) {
        return adInfo.adRewardInfo.rewardTime;
    }

    public static int ag(AdInfo adInfo) {
        return adInfo.adRewardInfo.skipShowTime;
    }

    public static long ah(AdInfo adInfo) {
        return adInfo.adRewardInfo.skipShowTime * 1000;
    }

    public static long ai(AdInfo adInfo) {
        return adInfo.adRewardInfo.rewardTime * 1000;
    }

    private static int aj(AdInfo adInfo) {
        if (adInfo.adStyleConfInfo != null) {
            return adInfo.adStyleConfInfo.rewardSkipConfirmSwitch;
        }
        com.kwad.sdk.core.d.c.w("AdInfoHelper", "adInfo.adStyleConfInfo is null");
        return 1;
    }

    public static boolean ak(AdInfo adInfo) {
        if (adInfo.adStyleConfInfo.nativeAdInfo != null && adInfo.adStyleConfInfo.nativeAdInfo.shakeInfo != null) {
            return adInfo.adStyleConfInfo.nativeAdInfo.shakeInfo.enableShake;
        }
        com.kwad.sdk.core.d.c.w("AdInfoHelper", "adInfo.adStyleConfInfo.nativeAdInfo is null");
        return false;
    }

    public static int al(AdInfo adInfo) {
        if (adInfo.adStyleConfInfo.nativeAdInfo != null) {
            return adInfo.adStyleConfInfo.nativeAdInfo.shakeInfo.acceleration;
        }
        com.kwad.sdk.core.d.c.w("AdInfoHelper", "adInfo.adStyleConfInfo.nativeAdInfo is null");
        return 2;
    }

    public static boolean am(AdInfo adInfo) {
        return aj(adInfo) != 0;
    }

    public static long an(AdInfo adInfo) {
        if (adInfo.adStyleConfInfo != null) {
            return adInfo.adStyleConfInfo.fullScreenSkipShowTime * 1000;
        }
        com.kwad.sdk.core.d.c.w("AdInfoHelper", "adInfo.adStyleConfInfo is null");
        return 5000L;
    }

    public static long ao(AdInfo adInfo) {
        if (adInfo.adStyleConfInfo != null) {
            return adInfo.adStyleConfInfo.closeDelaySeconds * 1000;
        }
        com.kwad.sdk.core.d.c.w("AdInfoHelper", "adInfo.adStyleConfInfo is null");
        return 0L;
    }

    public static int ap(AdInfo adInfo) {
        return adInfo.adStyleConfInfo.adShowVideoH5Info.showPageType;
    }

    public static boolean aq(AdInfo adInfo) {
        return adInfo.adStyleConfInfo.adShowVideoH5Info.videoAutoLoopAtH5;
    }

    public static boolean ar(AdInfo adInfo) {
        return adInfo.adStyleConfInfo.adShowVideoH5Info.videoMutedAtH5;
    }

    public static boolean as(AdInfo adInfo) {
        return adInfo.adStyleConfInfo.adShowVideoH5Info.videoClickAtH5;
    }

    public static long at(AdInfo adInfo) {
        if (adInfo.adStyleConfInfo != null) {
            return adInfo.adStyleConfInfo.playableCloseSeconds * 1000;
        }
        com.kwad.sdk.core.d.c.w("AdInfoHelper", "adInfo.adStyleConfInfo is null");
        return 0L;
    }

    public static boolean au(AdInfo adInfo) {
        return !aJ(adInfo) && av(adInfo);
    }

    public static boolean av(AdInfo adInfo) {
        if (adInfo.adRewardInfo.showLandingPage == 1) {
            return ((aS(adInfo) && aR(adInfo) == 1) || dl(adInfo)) ? false : true;
        }
        return false;
    }

    public static String aw(AdInfo adInfo) {
        return adInfo.adBaseInfo.adDescription;
    }

    public static String ax(AdInfo adInfo) {
        return adInfo.advertiserInfo.authorIconGuide;
    }

    public static String ay(AdInfo adInfo) {
        return adInfo.adBaseInfo.appName;
    }

    private static String az(AdInfo adInfo) {
        return adInfo.adBaseInfo.realAppName;
    }

    public static String aA(AdInfo adInfo) {
        return adInfo.adBaseInfo.productName;
    }

    public static String aB(AdInfo adInfo) {
        if (adInfo == null || adInfo.adBaseInfo == null) {
            return null;
        }
        return adInfo.adBaseInfo.appPackageName;
    }

    public static String aC(AdInfo adInfo) {
        return adInfo.adBaseInfo.appDownloadCountDesc;
    }

    public static float aD(AdInfo adInfo) {
        if (adInfo.adBaseInfo.appScore <= 0) {
            return 0.0f;
        }
        return adInfo.adBaseInfo.appScore / 10.0f;
    }

    public static boolean aE(AdInfo adInfo) {
        return adInfo.adBaseInfo.enableClientProofreadTime;
    }

    public static float aF(AdInfo adInfo) {
        float f = adInfo.adBaseInfo.appScore;
        if (f < 30.0f) {
            return 3.0f;
        }
        if (f < 35.0f) {
            return 3.5f;
        }
        if (f < 40.0f) {
            return 4.0f;
        }
        return f < 45.0f ? 4.5f : 5.0f;
    }

    public static String aG(AdInfo adInfo) {
        return bq.isNullString(adInfo.adBaseInfo.adSourceDescription) ? "广告" : adInfo.adBaseInfo.adSourceDescription;
    }

    public static String aH(AdInfo adInfo) {
        if (adInfo == null) {
            return "立即下载";
        }
        String str = adInfo.adBaseInfo.adActionDescription;
        if (TextUtils.isEmpty(str)) {
            return aJ(adInfo) ? "立即下载" : "查看详情";
        }
        return str;
    }

    public static String aI(AdInfo adInfo) {
        String str = adInfo.adBaseInfo.adActionDescription;
        if (TextUtils.isEmpty(str)) {
            return aJ(adInfo) ? "点我试玩" : "查看详情";
        }
        return str;
    }

    public static boolean aJ(AdInfo adInfo) {
        return aU(adInfo) == 1;
    }

    public static boolean aK(AdInfo adInfo) {
        return adInfo.adStyleConfInfo.rewardVideoInteractSwitch && !TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.rewardVideoInteractInfo.templateId);
    }

    public static int aL(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.rewardVideoInteractInfo.intervalShow;
    }

    public static int aM(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.rewardVideoInteractInfo.dayMaxLimit;
    }

    public static int aN(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.rewardVideoInteractInfo.showTime;
    }

    public static int aO(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.rewardVideoInteractInfo.rewardTime;
    }

    public static int aP(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.rewardVideoTaskInfo.showTime;
    }

    public static int aQ(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.rewardVideoTaskInfo.thresholdTime;
    }

    public static int aR(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.rewardVideoTaskInfo.taskType;
    }

    public static boolean aS(AdInfo adInfo) {
        return !TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.rewardVideoTaskInfo.templateId);
    }

    public static boolean aT(AdInfo adInfo) {
        return adInfo.downloadSafeInfo.complianceInfo != null && aJ(adInfo) && adInfo.downloadSafeInfo.complianceInfo.titleBarTextSwitch == 1;
    }

    public static int aU(AdInfo adInfo) {
        int i = adInfo.adBaseInfo.adOperationType;
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2) {
                return 0;
            }
        }
        return i2;
    }

    public static int aV(AdInfo adInfo) {
        return adInfo.adBaseInfo.ecpm;
    }

    public static String aW(AdInfo adInfo) {
        com.kwad.sdk.service.a.f fVar = (com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class);
        return TextUtils.isEmpty(adInfo.adConversionInfo.h5Url) ? "" : aj.c(fVar == null ? null : fVar.getContext(), adInfo.adConversionInfo.h5Url, aE(adInfo));
    }

    public static int aX(AdInfo adInfo) {
        return adInfo.adConversionInfo.h5Type;
    }

    public static AdInfo.AdMaterialInfo.MaterialFeature aY(AdInfo adInfo) {
        for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature : adInfo.adMaterialInfo.materialFeatureList) {
            if (materialFeature != null && materialFeature.featureType == 2 && !TextUtils.isEmpty(materialFeature.materialUrl)) {
                return materialFeature;
            }
        }
        com.kwad.sdk.core.d.c.w("AdInfoHelper", "getImageMaterialFeature in null");
        return new AdInfo.AdMaterialInfo.MaterialFeature();
    }

    public static AdInfo.AdMaterialInfo.MaterialFeature aZ(AdInfo adInfo) {
        for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature : adInfo.adMaterialInfo.materialFeatureList) {
            if (materialFeature != null && materialFeature.featureType == 1 && !TextUtils.isEmpty(materialFeature.materialUrl)) {
                return materialFeature;
            }
        }
        com.kwad.sdk.core.d.c.w("AdInfoHelper", "getVideoMaterialFeature in null");
        return new AdInfo.AdMaterialInfo.MaterialFeature();
    }

    public static boolean ba(AdInfo adInfo) {
        AdInfo.AdMaterialInfo.MaterialFeature materialFeatureAY;
        if (bi(adInfo)) {
            materialFeatureAY = aZ(adInfo);
        } else {
            materialFeatureAY = aY(adInfo);
        }
        return materialFeatureAY.height > materialFeatureAY.width;
    }

    public static AdInfo.AdMaterialInfo.MaterialFeature bb(AdInfo adInfo) {
        List<AdInfo.AdMaterialInfo.MaterialFeature> list = adInfo.adMaterialInfo.materialFeatureList;
        AdInfo.AdMaterialInfo.MaterialFeature materialFeature = list.size() > 0 ? list.get(0) : null;
        return materialFeature == null ? new AdInfo.AdMaterialInfo.MaterialFeature() : materialFeature;
    }

    public static boolean bc(AdInfo adInfo) {
        AdInfo.AdMaterialInfo.MaterialFeature materialFeatureAZ = aZ(adInfo);
        return materialFeatureAZ.height > materialFeatureAZ.width;
    }

    public static long bd(AdInfo adInfo) {
        return bb(adInfo).likeCount;
    }

    public static long be(AdInfo adInfo) {
        return bb(adInfo).commentCount;
    }

    public static String bf(AdInfo adInfo) {
        return adInfo.adPreloadInfo.preloadId;
    }

    public static List<String> bg(AdInfo adInfo) {
        ArrayList arrayList = new ArrayList();
        int iBk = bk(adInfo);
        if (iBk != 2 && iBk != 3) {
            return arrayList;
        }
        for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature : adInfo.adMaterialInfo.materialFeatureList) {
            if (materialFeature.featureType == 2 && !TextUtils.isEmpty(materialFeature.materialUrl)) {
                arrayList.add(materialFeature.materialUrl);
            }
        }
        return arrayList;
    }

    public static String bh(AdInfo adInfo) {
        if (bi(adInfo)) {
            return L(adInfo);
        }
        List<String> listBg = bg(adInfo);
        return listBg.size() > 0 ? listBg.get(0) : "";
    }

    public static boolean bi(AdInfo adInfo) {
        return bk(adInfo) == 1;
    }

    public static boolean bj(AdInfo adInfo) {
        return aY(adInfo).featureType == 2;
    }

    public static int bk(AdInfo adInfo) {
        int i = adInfo.adMaterialInfo.materialType;
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2) {
                if (i != 5) {
                    return i != 8 ? 0 : 8;
                }
                return 3;
            }
        }
        return i2;
    }

    public static int bl(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.actionBarInfo.cardType;
    }

    public static int bm(AdInfo adInfo) {
        if (adInfo.adDrawInfo == null || adInfo.adDrawInfo.liveTypeInfo == null) {
            return 7;
        }
        return adInfo.adDrawInfo.liveTypeInfo.actionbarCardType;
    }

    public static String bn(AdInfo adInfo) {
        return adInfo.adBaseInfo.liveStreamId;
    }

    public static boolean bo(AdInfo adInfo) {
        return adInfo.adMaterialInfo.materialType == 1;
    }

    public static boolean bp(AdInfo adInfo) {
        return adInfo.adConversionInfo.needDeeplinkReplaceAdapta;
    }

    public static boolean bq(AdInfo adInfo) {
        return adInfo.adConversionInfo.interceptH5JumpAppMkt;
    }

    public static int br(AdInfo adInfo) {
        return adInfo.adConversionInfo.interceptH5JumpTimeOut;
    }

    public static boolean bs(AdInfo adInfo) {
        return adInfo.adConversionInfo.isSupportKeepPlaying;
    }

    public static long bt(AdInfo adInfo) {
        return adInfo.adConversionInfo.keepPlayingBackOffTime;
    }

    public static boolean bu(AdInfo adInfo) {
        return new JSONObject(adInfo.adBaseInfo.videoPlayedNSConfig).length() != 0;
    }

    public static List<Integer> bv(AdInfo adInfo) throws NumberFormatException {
        String str = adInfo.adBaseInfo.videoPlayedNS;
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            try {
                for (String str2 : str.split(",")) {
                    int i = Integer.parseInt(str2);
                    if (i > 0) {
                        arrayList.add(Integer.valueOf(i));
                    }
                }
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.printStackTrace(e);
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(3);
        }
        return arrayList;
    }

    public static boolean b(AdInfo adInfo, boolean z) {
        return ((z && aJ(adInfo)) || adInfo.adBaseInfo.mABParams.showVideoAtH5 == 0 || bq.isNullString(aW(adInfo))) ? false : true;
    }

    private static int[] bw(AdInfo adInfo) {
        String[] strArrSplit;
        int[] iArr = {3, 3, 3};
        String str = adInfo.adBaseInfo.mABParams.drawActionBarTimes;
        if (TextUtils.isEmpty(str)) {
            return iArr;
        }
        try {
            strArrSplit = str.split(",");
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
        if (strArrSplit.length < 3) {
            return iArr;
        }
        iArr[0] = Integer.parseInt(strArrSplit[0]);
        iArr[1] = Integer.parseInt(strArrSplit[1]);
        iArr[2] = Integer.parseInt(strArrSplit[2]);
        return iArr;
    }

    public static int bx(AdInfo adInfo) {
        int i = bw(adInfo)[0];
        if (i > 0) {
            return i;
        }
        return 3;
    }

    public static int by(AdInfo adInfo) {
        int i = bw(adInfo)[1];
        if (i <= 0) {
            i = 3;
        }
        return i + bx(adInfo);
    }

    public static int bz(AdInfo adInfo) {
        int i = bw(adInfo)[2];
        if (i <= 0) {
            i = 3;
        }
        return i + by(adInfo);
    }

    public static com.kwad.sdk.core.response.model.b bA(AdInfo adInfo) {
        boolean z;
        String strP = P(adInfo);
        int iR = R(adInfo);
        int iS = S(adInfo);
        if (bq.isNullString(strP) || bq.iI(strP) || iR == 0 || iS == 0) {
            strP = Y(adInfo);
            iR = ab(adInfo);
            iS = ac(adInfo);
            z = true;
        } else {
            z = false;
        }
        boolean z2 = z;
        String str = strP;
        com.kwad.sdk.core.d.c.d("AdInfoHelper", "frameUrl=" + str + " useCover=" + z2 + " isAd=true");
        return new com.kwad.sdk.core.response.model.b(str, iR, iS, true, z2);
    }

    public static com.kwad.sdk.core.response.model.b bB(AdInfo adInfo) {
        boolean z;
        String strY = Y(adInfo);
        int iAb = ab(adInfo);
        int iAc = ac(adInfo);
        if (bq.isNullString(strY) || iAb == 0 || iAc == 0) {
            strY = P(adInfo);
            iAb = R(adInfo);
            iAc = S(adInfo);
            z = false;
        } else {
            z = true;
        }
        return new com.kwad.sdk.core.response.model.b(strY, iAb, iAc, true, z);
    }

    public static com.kwad.sdk.core.response.model.b bC(AdInfo adInfo) {
        boolean z;
        String strAa = aa(adInfo);
        if (bq.isNullString(strAa)) {
            strAa = Y(adInfo);
        }
        int iAb = ab(adInfo);
        int iAc = ac(adInfo);
        if (bq.isNullString(strAa) || iAb == 0 || iAc == 0) {
            strAa = P(adInfo);
            iAb = R(adInfo);
            iAc = S(adInfo);
            z = false;
        } else {
            z = true;
        }
        return new com.kwad.sdk.core.response.model.b(strAa, iAb, iAc, true, z);
    }

    public static String bD(AdInfo adInfo) {
        String str = adInfo.adBaseInfo.adActionBarColor;
        return (bq.isNullString(str) || !str.matches("^#([0-9a-fA-F]{8}|[0-9a-fA-F]{6}|[0-9a-fA-F]{3})$")) ? "#FFE4A704" : str;
    }

    public static String bE(AdInfo adInfo) {
        String str = adInfo.downloadSafeInfo.webPageTipbarText;
        return !TextUtils.isEmpty(str) ? str : "您访问的网站由第三方提供";
    }

    public static boolean bF(AdInfo adInfo) {
        return adInfo.downloadSafeInfo.secWindowPopSwitch;
    }

    public static boolean bG(AdInfo adInfo) {
        return adInfo.downloadSafeInfo.secWindowPopNoWifiSwitch;
    }

    public static int bH(AdInfo adInfo) {
        if (aJ(adInfo)) {
            if (adInfo.downloadSafeInfo.complianceInfo == null) {
                return -1;
            }
            return adInfo.downloadSafeInfo.complianceInfo.materialJumpType;
        }
        if (adInfo.unDownloadConf.unDownloadRegionConf == null) {
            return -1;
        }
        return adInfo.unDownloadConf.unDownloadRegionConf.materialJumpType;
    }

    public static boolean bI(AdInfo adInfo) {
        return adInfo.downloadSafeInfo.webPageTipbarSwitch;
    }

    public static int bJ(AdInfo adInfo) {
        if (adInfo == null) {
            return 0;
        }
        int i = adInfo.status;
        if (i == 0) {
            return 1;
        }
        if (1 == i || 2 == i || 3 == i || 4 == i) {
            return 2;
        }
        return 8 == i ? 3 : 0;
    }

    public static int bK(AdInfo adInfo) {
        return adInfo.status;
    }

    public static String bL(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.adBaseInfo.corporationName;
        }
        return null;
    }

    public static String bM(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.downloadSafeInfo.permissionInfo;
        }
        return null;
    }

    public static String bN(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.downloadSafeInfo.appPermissionInfoUrl;
        }
        return null;
    }

    public static String bO(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.downloadSafeInfo.introductionInfo;
        }
        return null;
    }

    public static String bP(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.downloadSafeInfo.introductionInfoUrl;
        }
        return null;
    }

    public static String bQ(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.downloadSafeInfo.appPrivacyUrl;
        }
        return null;
    }

    public static String bR(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.adBaseInfo.appVersion;
        }
        return null;
    }

    public static long bS(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.adBaseInfo.packageSize;
        }
        return 0L;
    }

    public static boolean bT(AdInfo adInfo) {
        if (adInfo != null && adInfo.adConversionInfo != null) {
            boolean z = (adInfo.adConversionInfo.playableUrl == null || adInfo.adConversionInfo.playableStyleInfo == null || TextUtils.isEmpty(adInfo.adConversionInfo.playableUrl.trim())) ? false : true;
            if (bW(adInfo) && z) {
                return true;
            }
        }
        return false;
    }

    public static long bU(AdInfo adInfo) {
        if (adInfo == null || adInfo.adConversionInfo == null) {
            return 0L;
        }
        return adInfo.adConversionInfo.h5DeeplinkLimitedTimeMs;
    }

    public static long bV(AdInfo adInfo) {
        if (adInfo == null || adInfo.adConversionInfo == null) {
            return 0L;
        }
        return adInfo.adConversionInfo.playableDeeplinkLimitedTimeMs;
    }

    public static boolean bW(AdInfo adInfo) {
        if (aq.isOrientationPortrait()) {
            return bY(adInfo);
        }
        return bX(adInfo);
    }

    private static boolean bX(AdInfo adInfo) {
        if (adInfo == null || adInfo.adConversionInfo == null || adInfo.adConversionInfo.playableStyleInfo == null) {
            return false;
        }
        int i = adInfo.adConversionInfo.playableStyleInfo.playableOrientation;
        return i == 0 || i == 2;
    }

    private static boolean bY(AdInfo adInfo) {
        if (adInfo == null || adInfo.adConversionInfo == null || adInfo.adConversionInfo.playableStyleInfo == null) {
            return false;
        }
        int i = adInfo.adConversionInfo.playableStyleInfo.playableOrientation;
        return i == 0 || i == 1;
    }

    public static String bZ(AdInfo adInfo) {
        if (adInfo == null || adInfo.adConversionInfo == null) {
            return null;
        }
        return adInfo.adConversionInfo.playableUrl;
    }

    public static String ca(AdInfo adInfo) {
        if (adInfo == null || adInfo.adConversionInfo == null) {
            return null;
        }
        return adInfo.adConversionInfo.callbackUrl;
    }

    public static String cb(AdInfo adInfo) {
        if (adInfo == null || adInfo.adConversionInfo == null) {
            return null;
        }
        return adInfo.adConversionInfo.callbackUrlInfo;
    }

    public static String cc(AdInfo adInfo) {
        if (adInfo == null || adInfo.serverExt == null) {
            return null;
        }
        return adInfo.serverExt;
    }

    public static String cd(AdInfo adInfo) {
        if (adInfo == null || adInfo.adConversionInfo == null) {
            return null;
        }
        return adInfo.adConversionInfo.adExt;
    }

    public static boolean ce(AdInfo adInfo) {
        return adInfo.fullScreenVideoInfo.fullScreenEndCardSwitch;
    }

    public static boolean cf(AdInfo adInfo) {
        return adInfo.adRewardInfo.rewardVideoEndCardSwitch;
    }

    public static boolean cg(AdInfo adInfo) {
        return (adInfo == null || adInfo.adBannerInfo == null || adInfo.adBannerInfo.videoSoundType != 2) ? false : true;
    }

    public static boolean ch(AdInfo adInfo) {
        if (adInfo == null || adInfo.adBannerInfo == null) {
            return false;
        }
        return adInfo.adBannerInfo.videoAutoPlayType == 1 || adInfo.adBannerInfo.videoAutoPlayType == 0;
    }

    public static boolean ci(AdInfo adInfo) {
        return (adInfo == null || adInfo.adBannerInfo == null || adInfo.adBannerInfo.videoAutoPlayType != 2) ? false : true;
    }

    public static boolean cj(AdInfo adInfo) {
        return (adInfo == null || adInfo.adFeedInfo == null || adInfo.adFeedInfo.videoSoundType != 2) ? false : true;
    }

    public static boolean ck(AdInfo adInfo) {
        return (adInfo == null || adInfo.adDrawInfo == null || adInfo.adDrawInfo.videoSoundType != 1) ? false : true;
    }

    public static boolean cl(AdInfo adInfo) {
        if (adInfo == null || adInfo.adFeedInfo == null) {
            return false;
        }
        return adInfo.adFeedInfo.videoAutoPlayType == 1 || adInfo.adFeedInfo.videoAutoPlayType == 0;
    }

    public static boolean cm(AdInfo adInfo) {
        return (adInfo == null || adInfo.adFeedInfo == null || adInfo.adFeedInfo.videoAutoPlayType != 2) ? false : true;
    }

    public static boolean cn(AdInfo adInfo) {
        return (adInfo == null || adInfo.adFeedInfo == null || adInfo.adFeedInfo.videoAutoPlayType != 3) ? false : true;
    }

    public static boolean co(AdInfo adInfo) {
        if (adInfo == null || adInfo.adMaterialInfo == null) {
            return false;
        }
        return adInfo.adMaterialInfo.videoVoice;
    }

    public static boolean cp(AdInfo adInfo) {
        com.kwad.sdk.service.a.h hVar = (com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class);
        return (hVar == null || !hVar.Ux()) && !TextUtils.isEmpty(aW(adInfo)) && adInfo.adStyleInfo.adBrowseInfo.enableAdBrowse == 1;
    }

    public static String cq(AdInfo adInfo) {
        String str = adInfo.adStyleInfo.adBrowseInfo.rewardDescription;
        return TextUtils.isEmpty(str) ? "浏览页面" : str;
    }

    public static int cr(AdInfo adInfo) {
        if (adInfo == null) {
            return 0;
        }
        return adInfo.adStyleConfInfo.actionBarType;
    }

    public static int cs(AdInfo adInfo) {
        if (adInfo == null) {
            return 0;
        }
        return adInfo.adStyleConfInfo.endCardType;
    }

    public static int ct(AdInfo adInfo) {
        if (adInfo == null) {
            return 0;
        }
        return adInfo.adStyleConfInfo.confirmCardType;
    }

    public static long cu(AdInfo adInfo) {
        if (adInfo == null || adInfo.adBaseInfo == null) {
            return 0L;
        }
        return adInfo.adBaseInfo.viewCount;
    }

    public static boolean cv(AdInfo adInfo) {
        return (adInfo == null || !aJ(adInfo) || adInfo == null || adInfo.adBaseInfo == null || adInfo.adBaseInfo.apiExpParam == null || adInfo.adBaseInfo.apiExpParam.apiMisTouch == 1 || adInfo.adBaseInfo.apiExpParam.apiBreathLamp != 1) ? false : true;
    }

    public static boolean cw(AdInfo adInfo) {
        if (!aJ(adInfo) || adInfo == null || adInfo.adBaseInfo == null || adInfo.adBaseInfo.apiExpParam == null || adInfo.adBaseInfo.apiExpParam.apiMisTouch == 1 || cv(adInfo)) {
            return false;
        }
        int i = adInfo.adBaseInfo.apiExpParam.apiAdTag;
        return i == 1 || i == 3;
    }

    public static boolean cx(AdInfo adInfo) {
        if (adInfo == null || adInfo.adBaseInfo == null || adInfo.adBaseInfo.apiExpParam == null) {
            return false;
        }
        return adInfo.adBaseInfo.apiExpParam.deeplinkOptimizeSwitch;
    }

    public static String cy(AdInfo adInfo) {
        if (adInfo == null || adInfo.adBaseInfo == null || adInfo.adBaseInfo.apiExpParam == null) {
            return null;
        }
        return adInfo.adBaseInfo.apiExpParam.tagTip;
    }

    public static String cz(AdInfo adInfo) {
        String strAA;
        if (aJ(adInfo)) {
            strAA = ay(adInfo);
        } else {
            strAA = aA(adInfo);
        }
        if (TextUtils.isEmpty(strAA)) {
            strAA = adInfo.advertiserInfo.rawUserName;
        }
        return TextUtils.isEmpty(strAA) ? "可爱的广告君" : strAA;
    }

    public static String cA(AdInfo adInfo) {
        String strAz = az(adInfo);
        return TextUtils.isEmpty(strAz) ? "可爱的广告君" : strAz;
    }

    public static String cB(AdInfo adInfo) {
        return adInfo.advertiserInfo.rawUserName;
    }

    public static String cC(AdInfo adInfo) {
        String str = adInfo.adBaseInfo.appIconUrl;
        return (TextUtils.isEmpty(str) || !aJ(adInfo)) ? adInfo.advertiserInfo.portraitUrl : str;
    }

    public static long cD(AdInfo adInfo) {
        return adInfo.advertiserInfo.userId;
    }

    public static String cE(AdInfo adInfo) {
        return bq.isNullString(adInfo.adConversionInfo.liveServiceToken) ? "" : adInfo.adConversionInfo.liveServiceToken;
    }

    public static long cF(AdInfo adInfo) {
        return adInfo.adConversionInfo.liveVisitorId;
    }

    public static String cG(AdInfo adInfo) {
        return (adInfo == null || adInfo.adSplashInfo == null || adInfo.adSplashInfo.skipTips == null || TextUtils.isEmpty(adInfo.adSplashInfo.skipTips)) ? "跳过" : adInfo.adSplashInfo.skipTips;
    }

    public static AdInfo.CutRuleInfo cH(AdInfo adInfo) {
        return adInfo.adSplashInfo.cutRuleInfo;
    }

    public static int cI(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashEndCardTKInfo.endCardShowSecond;
    }

    public static boolean cJ(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashEndCardTKInfo.endCardShowCountDown;
    }

    public static int cK(AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.retainWindowBasedAdShowCount;
    }

    public static int cL(AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.retainWindowDailyShowCount;
    }

    public static int cM(AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.retainWindowStyle;
    }

    public static String cN(AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.retainWindowText;
    }

    public static int cO(AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.cycleAggregateStyle;
    }

    public static boolean cP(AdInfo adInfo) {
        return adInfo.adSplashInfo.skipType == 2 || adInfo.adSplashInfo.skipType == 3;
    }

    public static boolean cQ(AdInfo adInfo) {
        if (cR(adInfo)) {
            return adInfo.adSplashInfo.skipType == 0 || adInfo.adSplashInfo.skipType == 2;
        }
        return false;
    }

    public static boolean cR(AdInfo adInfo) {
        return adInfo.adSplashInfo.skipSecond >= 0;
    }

    public static boolean cS(AdInfo adInfo) {
        return (adInfo == null || adInfo.adSplashInfo == null || adInfo.adSplashInfo.countdownShow != 1) ? false : true;
    }

    public static boolean cT(AdInfo adInfo) {
        return adInfo.adSplashInfo.impressionStatisticalChangeSwitch;
    }

    public static int cU(AdInfo adInfo) {
        double d = adInfo.adSplashInfo.impressionLimitSize;
        if (d <= 0.0d || d > 1.0d) {
            d = 0.699999988079071d;
        }
        return ((int) d) * 100;
    }

    public static boolean cV(AdInfo adInfo) {
        if (adInfo == null || adInfo.downloadSafeInfo == null) {
            return false;
        }
        return adInfo.downloadSafeInfo.downloadPauseEnable;
    }

    public static String cW(AdInfo adInfo) {
        return adInfo.adBaseInfo.sdkExtraData;
    }

    @Deprecated
    public static boolean cX(AdInfo adInfo) {
        return adInfo.adStyleConfInfo.innerAdType == 3;
    }

    public static boolean cY(AdInfo adInfo) {
        return adInfo.advertiserInfo.followed;
    }

    @Deprecated
    public static boolean cZ(AdInfo adInfo) {
        return adInfo.adStyleConfInfo.innerAdType == 1;
    }

    public static String da(AdInfo adInfo) {
        int i = adInfo.advertiserInfo.fansCount;
        if (i >= 200 && i < 10000) {
            return String.valueOf(i);
        }
        if (i < 10000) {
            return null;
        }
        return new DecimalFormat(cm.d).format(i / 10000.0d) + "w";
    }

    public static SpannableString c(AdInfo adInfo, int i) {
        String str;
        int iIndexOf;
        String strDa = da(adInfo);
        if (strDa == null || (iIndexOf = (str = String.format("已有%s粉丝关注了TA", strDa)).indexOf(strDa)) < 0) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(i), iIndexOf, strDa.length() + iIndexOf, 18);
        return spannableString;
    }

    public static String db(AdInfo adInfo) {
        return adInfo.advertiserInfo.brief;
    }

    public static String dc(AdInfo adInfo) {
        return adInfo.advertiserInfo.portraitUrl;
    }

    @Deprecated
    public static boolean dd(AdInfo adInfo) {
        return adInfo.adStyleConfInfo.innerAdType == 4 || adInfo.adStyleConfInfo.innerAdType == 5;
    }

    @Deprecated
    public static boolean de(AdInfo adInfo) {
        return adInfo.adStyleConfInfo.innerAdType == 7;
    }

    public static boolean df(AdInfo adInfo) {
        return adInfo.adBaseInfo.universeLiveType == 1 && cD(adInfo) != 0;
    }

    public static boolean dg(AdInfo adInfo) {
        return df(adInfo) || de(adInfo);
    }

    public static String dh(AdInfo adInfo) {
        com.kwad.sdk.service.a.f fVar = (com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class);
        return aj.c(fVar == null ? null : fVar.getContext(), adInfo.adConversionInfo.deeplinkUrl, aE(adInfo));
    }

    public static String di(AdInfo adInfo) {
        return adInfo.adConversionInfo.appDownloadUrl;
    }

    public static AdProductInfo dj(AdInfo adInfo) {
        return adInfo.adProductInfo;
    }

    public static String dk(AdInfo adInfo) {
        return adInfo.adConversionInfo.marketUrl;
    }

    @Deprecated
    public static boolean cE(AdTemplate adTemplate) {
        AdInfo adInfoEP = e.eP(adTemplate);
        AdMatrixInfo.MerchantLiveReservationInfo merchantLiveReservationInfoDS = b.dS(adTemplate);
        return (merchantLiveReservationInfoDS != null && !merchantLiveReservationInfoDS.isEmpty()) && adInfoEP.adStyleConfInfo.innerAdType == 2;
    }

    public static boolean dl(AdInfo adInfo) {
        if (aJ(adInfo)) {
            return false;
        }
        return adInfo.adBaseInfo.extraClickReward;
    }

    public static boolean dm(AdInfo adInfo) {
        return dl(adInfo) && ai(adInfo) < N(adInfo);
    }

    public static boolean dn(AdInfo adInfo) {
        if (!TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.pushTKInfo.templateId)) {
            return true;
        }
        com.kwad.sdk.core.d.c.d("AdInfoHelper", "isPushAdEnable pushTK TemplateId is empty");
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* renamed from: do, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m456do(com.kwad.sdk.core.response.model.AdInfo r9) {
        /*
            com.kwad.sdk.core.response.model.AdInfo$AdStyleConfInfo r0 = r9.adStyleConfInfo
            boolean r0 = r0.adPushSwitch
            r1 = 0
            if (r0 != 0) goto L8
            return r1
        L8:
            long r2 = com.kwad.sdk.utils.ag.aoK()
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            r6 = 1
            if (r0 > 0) goto L15
        L13:
            r1 = r6
            goto L2d
        L15:
            com.kwad.sdk.core.response.model.AdInfo$AdStyleConfInfo r9 = r9.adStyleConfInfo
            int r9 = r9.adPushIntervalTime
            long r7 = (long) r9
            int r9 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r9 > 0) goto L20
            r7 = 900(0x384, double:4.447E-321)
        L20:
            r4 = 1000(0x3e8, double:4.94E-321)
            long r7 = r7 * r4
            long r4 = java.lang.System.currentTimeMillis()
            long r4 = r4 - r2
            int r9 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r9 <= 0) goto L2d
            goto L13
        L2d:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r0 = "isPushAdEnable intervalEnable: "
            r9.<init>(r0)
            java.lang.StringBuilder r9 = r9.append(r1)
            java.lang.String r9 = r9.toString()
            java.lang.String r0 = "AdInfoHelper"
            com.kwad.sdk.core.d.c.d(r0, r9)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.response.b.a.m456do(com.kwad.sdk.core.response.model.AdInfo):boolean");
    }

    public static int dp(AdInfo adInfo) {
        return adInfo.adStyleConfInfo.adPushShowAfterTime * 1000;
    }

    public static boolean dq(AdInfo adInfo) {
        return (!df(adInfo) || TextUtils.isEmpty(b.eD(adInfo)) || dr(adInfo)) ? false : true;
    }

    private static boolean dr(AdInfo adInfo) {
        return adInfo.adStyleConfInfo.useNativeForOuterLiveAd;
    }

    public static long ds(AdInfo adInfo) {
        return adInfo.adRewardInfo.callBackStrategyInfo.callBackAdvanceMs;
    }

    public static boolean dt(AdInfo adInfo) {
        return adInfo.adRewardInfo.callBackStrategyInfo.serverCheckSwitch;
    }

    public static boolean du(AdInfo adInfo) {
        return adInfo.adRewardInfo.callBackStrategyInfo.rewardAdvanceSwitch;
    }

    public static boolean dv(AdInfo adInfo) {
        return adInfo.adRewardInfo.rewardFraudVerifyInfo.fraudVerifySwitch;
    }

    public static long dw(AdInfo adInfo) {
        return adInfo.adRewardInfo.rewardFraudVerifyInfo.fraudVerifyAdvanceMs;
    }

    public static KSAdInfoData dx(AdInfo adInfo) {
        KSAdInfoData interactionType = KSAdInfoData.obtain().setAdDescription(aw(adInfo)).setProductName(aA(adInfo)).setAdSource(aG(adInfo)).setVideoUrl(L(adInfo)).setMaterialType(bk(adInfo)).setAppIconUrl(cC(adInfo)).setAppName(ay(adInfo)).setImageList(dy(adInfo)).setVideoCoverImageUrl(dz(adInfo)).setInteractionType(aU(adInfo));
        try {
            interactionType.setCreativeId(K(adInfo));
        } catch (Throwable unused) {
        }
        return interactionType;
    }

    private static List<String> dy(AdInfo adInfo) {
        ArrayList arrayList = new ArrayList();
        int iBk = bk(adInfo);
        if (iBk == 2 || iBk == 3) {
            for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature : adInfo.adMaterialInfo.materialFeatureList) {
                if (materialFeature.featureType == 2 && !TextUtils.isEmpty(materialFeature.materialUrl)) {
                    arrayList.add(materialFeature.materialUrl);
                }
            }
        }
        return arrayList;
    }

    private static String dz(AdInfo adInfo) {
        AdInfo.AdMaterialInfo.MaterialFeature materialFeatureAZ = aZ(adInfo);
        if (TextUtils.isEmpty(materialFeatureAZ.coverUrl)) {
            return null;
        }
        return materialFeatureAZ.coverUrl;
    }

    public static String I(AdInfo adInfo) {
        return adInfo.downloadFilePath;
    }

    public static String dA(AdInfo adInfo) {
        return adInfo.adConversionInfo.smallAppJumpInfo.mediaSmallAppId;
    }

    public static boolean dB(AdInfo adInfo) {
        int i = adInfo.adMaterialInfo.derivativeMaterialType;
        return i == 6 || i == 2;
    }

    public static int dC(AdInfo adInfo) {
        if (adInfo == null) {
            return 0;
        }
        return adInfo.adBaseInfo.campaignType;
    }

    public static int dD(AdInfo adInfo) {
        if (adInfo == null) {
            return 0;
        }
        return adInfo.ocpcActionType;
    }

    public static int dE(AdInfo adInfo) {
        if (adInfo == null) {
            return 0;
        }
        return adInfo.adBaseInfo.industryFirstLevelId;
    }

    public static int dF(AdInfo adInfo) {
        if (adInfo == null) {
            return 0;
        }
        return adInfo.adConversionInfo.webUriSourceType;
    }

    public static int dG(AdInfo adInfo) {
        return adInfo.adBannerInfo.videoAutoPlayType;
    }

    public static boolean dH(AdInfo adInfo) {
        return adInfo.adBannerInfo.isSupportCarousel;
    }

    public static boolean dI(AdInfo adInfo) {
        try {
            if (adInfo.adMatrixInfo.adDataV2.styleComponentInfo != null) {
                return adInfo.adMatrixInfo.adDataV2.styleComponentInfo.styleComponentFlag;
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static String dJ(AdInfo adInfo) {
        try {
            if (adInfo.adMatrixInfo.adDataV2.styleComponentInfo != null) {
                return AdMatrixInfo.ComponentParam.obtain().setPageId(Long.valueOf(adInfo.adMatrixInfo.adDataV2.styleComponentInfo.playCardInfo != null ? adInfo.adMatrixInfo.adDataV2.styleComponentInfo.playCardInfo.pageId : 0L)).setEndCardPageId(Long.valueOf(adInfo.adMatrixInfo.adDataV2.styleComponentInfo.endCardInfo != null ? adInfo.adMatrixInfo.adDataV2.styleComponentInfo.endCardInfo.pageId : 0L)).toJson().toString();
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    public static boolean dK(AdInfo adInfo) {
        return adInfo.ksUaPattern;
    }

    public static boolean dL(AdInfo adInfo) {
        return adInfo.unionMark;
    }
}
