package com.kwad.sdk.core.response.b;

import android.text.TextUtils;
import com.kwad.sdk.api.model.KsLiveInfo;
import com.kwad.sdk.api.model.liveModel.KsCouponInfo;
import com.kwad.sdk.api.model.liveModel.KsLiveBaseInfo;
import com.kwad.sdk.api.model.liveModel.KsLiveShopInfo;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.CouponInfo;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.service.ServiceProvider;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class e {
    private static g abK() {
        com.kwad.sdk.service.a.f fVar = (com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class);
        if (fVar != null) {
            return fVar.wU();
        }
        return null;
    }

    public static boolean eH(AdTemplate adTemplate) {
        return (adTemplate.realShowType != 2 || adTemplate.adInfoList.isEmpty() || adTemplate.adInfoList.get(0) == null) ? false : true;
    }

    public static long eI(AdTemplate adTemplate) {
        return adTemplate.posId;
    }

    public static int eJ(AdTemplate adTemplate) {
        return adTemplate.adStyle;
    }

    @Deprecated
    public static int eK(AdTemplate adTemplate) {
        if (adTemplate != null) {
            return (adTemplate.mAdScene == null || adTemplate.mAdScene.adStyle == 0) ? eJ(adTemplate) : adTemplate.mAdScene.getAdStyle();
        }
        return 0;
    }

    public static int eL(AdTemplate adTemplate) {
        return adTemplate.contentType;
    }

    public static long eM(AdTemplate adTemplate) {
        return adTemplate.llsid;
    }

    public static String eN(AdTemplate adTemplate) {
        return adTemplate.extra;
    }

    public static String eO(AdTemplate adTemplate) {
        return adTemplate.impAdExtra;
    }

    public static AdInfo eP(AdTemplate adTemplate) {
        AdInfo adInfo = adTemplate.adInfoList.size() > 0 ? adTemplate.adInfoList.get(0) : null;
        if (adInfo != null) {
            return adInfo;
        }
        com.kwad.sdk.core.d.c.e("AdTemplateHelper", "adInfo in null");
        return new AdInfo();
    }

    public static PhotoInfo eQ(AdTemplate adTemplate) {
        return adTemplate.photoInfo;
    }

    public static String eR(AdTemplate adTemplate) {
        if (eH(adTemplate)) {
            return a.L(eP(adTemplate));
        }
        return h.d(eQ(adTemplate));
    }

    public static String eS(AdTemplate adTemplate) {
        return eP(adTemplate).adConversionInfo.appDownloadUrl;
    }

    public static String be(AdTemplate adTemplate) {
        g gVarAbK = abK();
        String strBe = gVarAbK == null ? "" : gVarAbK.be(adTemplate);
        return TextUtils.isEmpty(strBe) ? strBe : a.Z(eP(adTemplate));
    }

    public static String bf(AdTemplate adTemplate) {
        if (eH(adTemplate)) {
            return a.cC(eP(adTemplate));
        }
        g gVarAbK = abK();
        return gVarAbK == null ? "" : gVarAbK.bf(adTemplate);
    }

    public static long bg(AdTemplate adTemplate) {
        if (eH(adTemplate)) {
            return a.ad(eP(adTemplate));
        }
        g gVarAbK = abK();
        return gVarAbK == null ? adTemplate.hashCode() : gVarAbK.bg(adTemplate);
    }

    public static int bh(AdTemplate adTemplate) {
        g gVarAbK = abK();
        if (gVarAbK == null) {
            return 0;
        }
        return gVarAbK.bh(adTemplate);
    }

    public static boolean k(AdTemplate adTemplate, boolean z) {
        if (adTemplate == null) {
            return false;
        }
        AdInfo adInfoEP = eP(adTemplate);
        return a.aJ(adInfoEP) && !a.dl(adInfoEP) && !z && eT(adTemplate) == 2;
    }

    public static boolean P(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return false;
        }
        AdInfo adInfoEP = eP(adTemplate);
        return (a.aJ(adInfoEP) || a.dl(adInfoEP) || eT(adTemplate) != 3) ? false : true;
    }

    public static int eT(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return -1;
        }
        return eP(adTemplate).adBaseInfo.taskType;
    }

    public static String eU(AdTemplate adTemplate) {
        if (eH(adTemplate)) {
            return a.cW(eP(adTemplate));
        }
        return h.t(eQ(adTemplate));
    }

    public static long eV(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return 0L;
        }
        return eP(adTemplate).adBaseInfo.creativeId;
    }

    public static boolean eW(AdTemplate adTemplate) {
        return eP(adTemplate).adConversionInfo.blockCallbackIfSpam && adTemplate.mCheatingFlow;
    }

    public static boolean eX(AdTemplate adTemplate) {
        int iL = l(adTemplate, true);
        return iL == 1 || iL == 2;
    }

    public static boolean eY(AdTemplate adTemplate) {
        int iL = l(adTemplate, false);
        return iL == 1 || iL == 2;
    }

    public static int l(AdTemplate adTemplate, boolean z) {
        int i;
        AdInfo adInfoEP = eP(adTemplate);
        if (!ff(adTemplate)) {
            return adInfoEP.adBaseInfo.mABParams.playableStyle;
        }
        if (z) {
            i = adInfoEP.adMatrixInfo.adDataV2.actionBarInfo.cardType;
        } else {
            i = adInfoEP.adMatrixInfo.adDataV2.endCardInfo.cardType;
        }
        if (i == 5) {
            return 1;
        }
        return i == 6 ? 2 : -1;
    }

    public static AdTemplate b(List<AdTemplate> list, long j, int i) {
        if (j >= 0 && list != null) {
            for (AdTemplate adTemplate : list) {
                if (b(adTemplate, j, i)) {
                    return adTemplate;
                }
            }
        }
        return null;
    }

    public static boolean c(List<AdTemplate> list, long j, int i) {
        AdTemplate adTemplateB = b(list, j, i);
        if (adTemplateB == null) {
            return false;
        }
        long jEV = eV(adTemplateB);
        int iEJ = eJ(adTemplateB);
        if (i > 0) {
            if (jEV != j || iEJ != i) {
                return false;
            }
        } else if (jEV != j) {
            return false;
        }
        return true;
    }

    public static boolean b(AdTemplate adTemplate, long j, int i) {
        long jEV = eV(adTemplate);
        int iEJ = eJ(adTemplate);
        if (i > 0) {
            if (jEV == j && iEJ == i) {
                return true;
            }
        } else if (jEV == j) {
            return true;
        }
        return false;
    }

    public static int eZ(AdTemplate adTemplate) {
        return eP(adTemplate).adBaseInfo.ecpm;
    }

    public static boolean fa(AdTemplate adTemplate) {
        AdInfo adInfoEP = eP(adTemplate);
        return adInfoEP.adStyleConfInfo.adPushDownloadJumpType == 0 && eJ(adTemplate) == 17 && a.aJ(adInfoEP);
    }

    public static int fb(AdTemplate adTemplate) {
        if (adTemplate.adVideoPreCacheConfig == null) {
            com.kwad.sdk.service.a.h hVar = (com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class);
            if (hVar != null) {
                return hVar.Uw();
            }
            return 800;
        }
        return adTemplate.adVideoPreCacheConfig.adVideoPreCacheSize;
    }

    public static KsLiveInfo fc(AdTemplate adTemplate) {
        AdInfo adInfoEP = eP(adTemplate);
        if (adInfoEP.adBaseInfo.roiType == 0) {
            return null;
        }
        KsLiveInfo ksLiveInfo = new KsLiveInfo();
        ksLiveInfo.setRoiType(adInfoEP.adBaseInfo.roiType);
        KsLiveBaseInfo ksLiveBaseInfo = ksLiveInfo.getKsLiveBaseInfo();
        if (adInfoEP.advertiserInfo.userName != null) {
            ksLiveBaseInfo.setUserName(adInfoEP.advertiserInfo.userName);
        }
        if (adInfoEP.advertiserInfo.portraitUrl != null) {
            ksLiveBaseInfo.setPortraitUrl(adInfoEP.advertiserInfo.portraitUrl);
        }
        if (adInfoEP.adBaseInfo.liveDisplayWatchingCount > 0) {
            ksLiveBaseInfo.setLiveDisplayWatchingCount(adInfoEP.adBaseInfo.liveDisplayWatchingCount);
        }
        KsLiveShopInfo ksLiveShopInfo = new KsLiveShopInfo();
        AdProductInfo adProductInfo = adInfoEP.adProductInfo;
        ksLiveShopInfo.setIcon(adProductInfo.icon);
        ksLiveShopInfo.setName(adProductInfo.name);
        ksLiveShopInfo.setPrice(adProductInfo.price);
        ksLiveShopInfo.setOriginPrice(adProductInfo.originPrice);
        ksLiveShopInfo.setVolume(adProductInfo.volume);
        if (adProductInfo.couponList != null && adProductInfo.couponList.size() > 0) {
            ksLiveShopInfo.setHaveCoupon(true);
        }
        ksLiveInfo.getKsLiveShopInfo().add(ksLiveShopInfo);
        KsCouponInfo ksCouponInfo = new KsCouponInfo();
        CouponInfo firstCouponList = adProductInfo.getFirstCouponList();
        if (firstCouponList != null) {
            ksCouponInfo.setDisplayBase(firstCouponList.displayBase);
            ksCouponInfo.setDisplayType(firstCouponList.displayType);
            ksCouponInfo.setDisplayValue(firstCouponList.displayValue);
            ksCouponInfo.setEndFetchTime(firstCouponList.endFetchTime);
            ksCouponInfo.setStartFetchTime(firstCouponList.startFetchTime);
            ksLiveInfo.getKsCouponInfo().add(ksCouponInfo);
        }
        return ksLiveInfo;
    }

    public static int fd(AdTemplate adTemplate) {
        return eP(adTemplate).adBaseInfo.adRolloutSize;
    }

    public static boolean fe(AdTemplate adTemplate) {
        int iEJ = eJ(adTemplate);
        if (iEJ == 13) {
            return true;
        }
        return iEJ == 23 && fd(adTemplate) == 2;
    }

    public static boolean ff(AdTemplate adTemplate) {
        int iEJ = eJ(adTemplate);
        if (iEJ == 3) {
            return true;
        }
        return iEJ == 23 && fd(adTemplate) == 1;
    }

    public static int fg(AdTemplate adTemplate) {
        return adTemplate.type;
    }

    public static int fh(AdTemplate adTemplate) {
        return adTemplate.defaultType;
    }
}
