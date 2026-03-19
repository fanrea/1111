package com.kwad.components.ct.response.a;

import android.text.TextUtils;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.components.ct.response.model.CtPhotoInfo;
import com.kwad.components.ct.response.model.hotspot.HotspotInfo;
import com.kwad.components.ct.response.model.hotspot.NewsInfo;
import com.kwad.components.ct.response.model.live.LiveInfo;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdStyleInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.utils.bq;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends e {
    public static CtAdTemplate ba(AdTemplate adTemplate) {
        if (adTemplate instanceof CtAdTemplate) {
            return (CtAdTemplate) adTemplate;
        }
        return new CtAdTemplate(adTemplate);
    }

    public static List<AdTemplate> O(List<CtAdTemplate> list) {
        if (list == null || list.isEmpty()) {
            return new ArrayList(0);
        }
        ArrayList arrayList = new ArrayList(list.size());
        arrayList.addAll(list);
        return arrayList;
    }

    public static boolean aq(CtAdTemplate ctAdTemplate) {
        return ctAdTemplate.realShowType == 4 && ctAdTemplate.mLiveInfo != null;
    }

    public static boolean ar(CtAdTemplate ctAdTemplate) {
        return (ctAdTemplate.realShowType != 6 || ctAdTemplate.mLiveInfo == null || ctAdTemplate.adInfoList.isEmpty() || ctAdTemplate.adInfoList.get(0) == null) ? false : true;
    }

    public static boolean as(CtAdTemplate ctAdTemplate) {
        return ctAdTemplate.realShowType == 1 && ctAdTemplate.photoInfo != null;
    }

    public static boolean at(CtAdTemplate ctAdTemplate) {
        return ctAdTemplate.realShowType == 5 && ctAdTemplate.newsInfo != null;
    }

    public static boolean au(CtAdTemplate ctAdTemplate) {
        return ctAdTemplate.realShowType == 3;
    }

    public static boolean av(CtAdTemplate ctAdTemplate) {
        return ctAdTemplate.realShowType == 3 && ctAdTemplate.thirdFromAdx;
    }

    public static long aw(CtAdTemplate ctAdTemplate) {
        return ctAdTemplate.posId;
    }

    public static int ax(CtAdTemplate ctAdTemplate) {
        return ctAdTemplate.contentType;
    }

    public static CtPhotoInfo ay(CtAdTemplate ctAdTemplate) {
        return ctAdTemplate.photoInfo;
    }

    public static NewsInfo az(CtAdTemplate ctAdTemplate) {
        return ctAdTemplate.newsInfo;
    }

    public static String aA(CtAdTemplate ctAdTemplate) {
        if (eH(ctAdTemplate)) {
            return com.kwad.sdk.core.response.b.a.L(eP(ctAdTemplate));
        }
        return c.d((PhotoInfo) ay(ctAdTemplate));
    }

    public static long aB(CtAdTemplate ctAdTemplate) {
        if (eH(ctAdTemplate)) {
            return com.kwad.sdk.core.response.b.a.M(eP(ctAdTemplate)) * 1000;
        }
        return c.f((PhotoInfo) ay(ctAdTemplate)).longValue();
    }

    public static com.kwad.sdk.core.response.model.b f(CtAdTemplate ctAdTemplate, boolean z) {
        if (z) {
            return aD(ctAdTemplate);
        }
        if (eH(ctAdTemplate)) {
            return com.kwad.sdk.core.response.b.a.bA(eP(ctAdTemplate));
        }
        return c.D(ay(ctAdTemplate));
    }

    public static com.kwad.sdk.core.response.model.b aC(CtAdTemplate ctAdTemplate) {
        if (eH(ctAdTemplate)) {
            return com.kwad.sdk.core.response.b.a.bC(eP(ctAdTemplate));
        }
        return c.E(ay(ctAdTemplate));
    }

    public static com.kwad.sdk.core.response.model.b aD(CtAdTemplate ctAdTemplate) {
        if (eH(ctAdTemplate)) {
            return com.kwad.sdk.core.response.b.a.bB(eP(ctAdTemplate));
        }
        if (at(ctAdTemplate)) {
            return d.i(az(ctAdTemplate));
        }
        return c.E(ay(ctAdTemplate));
    }

    public static String aE(CtAdTemplate ctAdTemplate) {
        if (eH(ctAdTemplate)) {
            String strY = com.kwad.sdk.core.response.b.a.Y(eP(ctAdTemplate));
            return !TextUtils.isEmpty(strY) ? strY : com.kwad.sdk.core.response.b.a.P(eP(ctAdTemplate));
        }
        if (at(ctAdTemplate)) {
            return d.h(az(ctAdTemplate));
        }
        String strA = c.a(ay(ctAdTemplate));
        return !TextUtils.isEmpty(strA) ? strA : c.g((PhotoInfo) ay(ctAdTemplate));
    }

    public static String aF(CtAdTemplate ctAdTemplate) {
        if (as(ctAdTemplate)) {
            return c.g((PhotoInfo) ay(ctAdTemplate));
        }
        return com.kwad.sdk.core.response.b.a.P(eP(ctAdTemplate));
    }

    public static String aG(CtAdTemplate ctAdTemplate) {
        if (as(ctAdTemplate)) {
            return c.m(ay(ctAdTemplate));
        }
        return com.kwad.sdk.core.response.b.a.ax(eP(ctAdTemplate));
    }

    public static long aH(CtAdTemplate ctAdTemplate) {
        if (eH(ctAdTemplate)) {
            return com.kwad.sdk.core.response.b.a.bd(eP(ctAdTemplate));
        }
        return c.m((PhotoInfo) ay(ctAdTemplate));
    }

    public static long aI(CtAdTemplate ctAdTemplate) {
        if (eH(ctAdTemplate)) {
            return com.kwad.sdk.core.response.b.a.be(eP(ctAdTemplate));
        }
        return c.o((PhotoInfo) ay(ctAdTemplate));
    }

    public static String aJ(CtAdTemplate ctAdTemplate) {
        if (eH(ctAdTemplate)) {
            AdInfo adInfoEP = eP(ctAdTemplate);
            if (com.kwad.sdk.core.response.b.a.aJ(adInfoEP)) {
                String strAy = com.kwad.sdk.core.response.b.a.ay(adInfoEP);
                if (!bq.isNullString(strAy)) {
                    return "@" + strAy;
                }
            } else {
                String strAA = com.kwad.sdk.core.response.b.a.aA(adInfoEP);
                if (!bq.isNullString(strAA)) {
                    return "@" + strAA;
                }
            }
            return adInfoEP.advertiserInfo.userName;
        }
        if (c.o(ay(ctAdTemplate))) {
            return c.w(ay(ctAdTemplate));
        }
        return c.g(ay(ctAdTemplate));
    }

    public static int aK(CtAdTemplate ctAdTemplate) {
        int iH = c.h(ay(ctAdTemplate));
        if (iH <= 0) {
            return 16;
        }
        return iH;
    }

    public static String aL(CtAdTemplate ctAdTemplate) {
        if (eH(ctAdTemplate)) {
            return com.kwad.sdk.core.response.b.a.cz(eP(ctAdTemplate));
        }
        if (at(ctAdTemplate)) {
            return d.e(az(ctAdTemplate));
        }
        return c.k(ay(ctAdTemplate));
    }

    public static String aM(CtAdTemplate ctAdTemplate) {
        return at(ctAdTemplate) ? d.f(az(ctAdTemplate)) : "";
    }

    public static String aN(CtAdTemplate ctAdTemplate) {
        if (eH(ctAdTemplate)) {
            return com.kwad.sdk.core.response.b.a.aw(eP(ctAdTemplate));
        }
        if (at(ctAdTemplate)) {
            return d.d(az(ctAdTemplate));
        }
        return c.c((PhotoInfo) ay(ctAdTemplate));
    }

    public static int aO(CtAdTemplate ctAdTemplate) {
        int i = c.i(ay(ctAdTemplate));
        if (i <= 0) {
            return 14;
        }
        return i;
    }

    public static long aP(CtAdTemplate ctAdTemplate) {
        if (eH(ctAdTemplate)) {
            return 0L;
        }
        if (at(ctAdTemplate)) {
            return d.g(az(ctAdTemplate));
        }
        return c.p((PhotoInfo) ay(ctAdTemplate));
    }

    public static String aQ(CtAdTemplate ctAdTemplate) {
        if (eH(ctAdTemplate)) {
            return com.kwad.sdk.core.response.b.a.aw(eP(ctAdTemplate));
        }
        return c.q((PhotoInfo) ay(ctAdTemplate));
    }

    public static String aR(CtAdTemplate ctAdTemplate) {
        if (eH(ctAdTemplate)) {
            return eP(ctAdTemplate).advertiserInfo.adAuthorText;
        }
        return c.n(ay(ctAdTemplate));
    }

    public static LiveInfo aS(CtAdTemplate ctAdTemplate) {
        return ctAdTemplate.mLiveInfo;
    }

    public static String aT(CtAdTemplate ctAdTemplate) {
        if (eH(ctAdTemplate)) {
            return com.kwad.sdk.core.response.b.a.aa(eP(ctAdTemplate));
        }
        return c.K(ay(ctAdTemplate));
    }

    public static long aU(CtAdTemplate ctAdTemplate) {
        if (eH(ctAdTemplate)) {
            return com.kwad.sdk.core.response.b.a.cu(eP(ctAdTemplate));
        }
        return c.n((PhotoInfo) ay(ctAdTemplate));
    }

    public static boolean aV(CtAdTemplate ctAdTemplate) {
        return ctAdTemplate.mAdScene != null && ctAdTemplate.mAdScene.getPageScene() == 14;
    }

    public static boolean aW(CtAdTemplate ctAdTemplate) {
        if (ctAdTemplate.mAdScene != null) {
            return com.kwad.sdk.core.scene.a.fw(ctAdTemplate.mAdScene.getPageScene());
        }
        return false;
    }

    public static String aX(CtAdTemplate ctAdTemplate) {
        return as(ctAdTemplate) ? c.I(ay(ctAdTemplate)) : "";
    }

    public static HotspotInfo aY(CtAdTemplate ctAdTemplate) {
        return c.J(ay(ctAdTemplate));
    }

    public static String aZ(CtAdTemplate ctAdTemplate) {
        if (eH(ctAdTemplate)) {
            return com.kwad.sdk.core.response.b.a.cW(eP(ctAdTemplate));
        }
        return c.t((PhotoInfo) ay(ctAdTemplate));
    }

    public static boolean ba(CtAdTemplate ctAdTemplate) {
        if (as(ctAdTemplate)) {
            return ctAdTemplate.photoInfo.productInfo.productId != 0 || ctAdTemplate.photoAd.requestPatchEc;
        }
        return false;
    }

    public static long bb(CtAdTemplate ctAdTemplate) {
        if (eH(ctAdTemplate)) {
            return com.kwad.sdk.core.response.b.a.cD(eP(ctAdTemplate));
        }
        if (as(ctAdTemplate)) {
            return c.e(ay(ctAdTemplate));
        }
        return 0L;
    }

    public static String bb(AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.b.d.ew(adTemplate) instanceof AdStyleInfo.PlayDetailInfo.PatchEcInfo ? ((AdStyleInfo.PlayDetailInfo.PatchEcInfo) com.kwad.sdk.core.response.b.d.ew(adTemplate)).linkCode : "";
    }

    public static int bc(AdTemplate adTemplate) {
        if (com.kwad.sdk.core.response.b.d.ew(adTemplate) instanceof AdStyleInfo.PlayDetailInfo.PatchEcInfo) {
            return ((AdStyleInfo.PlayDetailInfo.PatchEcInfo) com.kwad.sdk.core.response.b.d.ew(adTemplate)).platformTypeCode;
        }
        return 0;
    }

    public static String bd(AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.b.d.ew(adTemplate) instanceof AdStyleInfo.PlayDetailInfo.PatchEcInfo ? ((AdStyleInfo.PlayDetailInfo.PatchEcInfo) com.kwad.sdk.core.response.b.d.ew(adTemplate)).strongStyleUserCommAmountSharing : "";
    }

    public static boolean bc(CtAdTemplate ctAdTemplate) {
        return c.b((PhotoInfo) ay(ctAdTemplate));
    }
}
