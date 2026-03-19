package com.kwad.components.ad.reward.model;

import android.text.TextUtils;
import com.kwad.components.ad.reward.n.r;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.CouponInfo;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a {
    private String iconUrl;
    private String liveStartTime;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private String originPrice;
    private int playableStyle;
    private String price;
    private String title;
    private String uM;
    private List<String> wH;
    private String wI;
    private String wJ;
    private String wK;
    private boolean wL;
    private String wM;
    private String wN = "查看详情";
    private String wO = "立即预约";
    private List<String> wP;
    private AdTemplate wQ;

    public static a S(AdTemplate adTemplate) {
        CouponInfo firstCouponList;
        if (adTemplate == null) {
            return null;
        }
        AdInfo adInfoEP = e.eP(adTemplate);
        AdProductInfo adProductInfoDj = com.kwad.sdk.core.response.b.a.dj(adInfoEP);
        a aVar = new a();
        String name = adProductInfoDj.getName();
        aVar.title = name;
        if (TextUtils.isEmpty(name)) {
            aVar.title = com.kwad.sdk.core.response.b.a.aA(adInfoEP);
        }
        aVar.iconUrl = adProductInfoDj.getIcon();
        aVar.uM = com.kwad.sdk.core.response.b.a.aw(adInfoEP);
        aVar.price = adProductInfoDj.getPrice();
        aVar.originPrice = adProductInfoDj.getOriginPrice();
        if (!adProductInfoDj.isCouponListEmpty() && (firstCouponList = adProductInfoDj.getFirstCouponList()) != null) {
            aVar.V(CouponInfo.jinniuFormatCoupon(firstCouponList));
            aVar.U(firstCouponList.getFormattedJinniuPrefix());
        }
        return aVar;
    }

    public static a a(r rVar, boolean z) {
        AdTemplate adTemplate;
        if (rVar == null || (adTemplate = rVar.getAdTemplate()) == null) {
            return null;
        }
        AdInfo adInfoEP = e.eP(adTemplate);
        a aVar = new a();
        aVar.title = com.kwad.sdk.core.response.b.a.cz(adInfoEP);
        aVar.iconUrl = com.kwad.sdk.core.response.b.a.cC(adInfoEP);
        aVar.uM = com.kwad.sdk.core.response.b.a.aw(adInfoEP);
        aVar.wH = com.kwad.sdk.core.response.b.d.eG(adTemplate);
        aVar.wI = com.kwad.sdk.core.response.b.a.aH(adInfoEP);
        aVar.playableStyle = e.l(adTemplate, z);
        aVar.wQ = adTemplate;
        aVar.mApkDownloadHelper = rVar.in();
        return aVar;
    }

    public static a T(AdTemplate adTemplate) {
        AdMatrixInfo.MerchantLiveReservationInfo merchantLiveReservationInfoDS = com.kwad.sdk.core.response.b.b.dS(adTemplate);
        a aVar = new a();
        aVar.iconUrl = merchantLiveReservationInfoDS.userHeadUrl;
        aVar.liveStartTime = merchantLiveReservationInfoDS.liveStartTime;
        aVar.title = merchantLiveReservationInfoDS.title;
        aVar.wL = merchantLiveReservationInfoDS.needShowSubscriberCount();
        aVar.wM = merchantLiveReservationInfoDS.getFormattedLiveSubscribeCount();
        aVar.wP = merchantLiveReservationInfoDS.bookUserUrlList;
        aVar.wN = merchantLiveReservationInfoDS.playEndCard.detailBtnTitle;
        aVar.wO = merchantLiveReservationInfoDS.playEndCard.reservationBtnTitle;
        aVar.wQ = adTemplate;
        return aVar;
    }

    public final String hs() {
        return this.iconUrl;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String ht() {
        return this.uM;
    }

    public final String getPrice() {
        return this.price;
    }

    public final String getOriginPrice() {
        return this.originPrice;
    }

    public final String ik() {
        return this.wK;
    }

    public final String il() {
        return this.wJ;
    }

    private void U(String str) {
        this.wJ = str;
    }

    private void V(String str) {
        this.wK = str;
    }

    public final AdTemplate im() {
        return this.wQ;
    }

    public final com.kwad.components.core.e.d.c in() {
        return this.mApkDownloadHelper;
    }

    public final List<String> io() {
        return this.wH;
    }

    public final boolean ip() {
        List<String> list = this.wH;
        return list == null || list.size() == 0;
    }

    public final int iq() {
        return this.playableStyle;
    }

    public final String ir() {
        return this.wM;
    }

    public final String is() {
        return this.wO;
    }

    public final boolean it() {
        return this.wL;
    }

    public final List<String> iu() {
        return this.wP;
    }

    public final String iv() {
        return this.liveStartTime;
    }
}
