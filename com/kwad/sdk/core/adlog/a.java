package com.kwad.sdk.core.adlog;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.track.AdTrackLog;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.aj;
import com.kwad.sdk.utils.bq;
import com.qq.e.comm.pi.IBidding;
import java.util.Iterator;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class a extends com.kwad.sdk.core.network.b {
    int bvg;
    private final com.kwad.sdk.core.adlog.c.a bvh;
    private final AdTemplate mAdTemplate;

    @Override // com.kwad.sdk.core.network.b
    public final void buildBaseBody() {
    }

    @Override // com.kwad.sdk.core.network.b
    public final void buildBaseHeader() {
    }

    public a(com.kwad.sdk.core.adlog.c.a aVar) {
        this.bvh = aVar;
        this.mAdTemplate = aVar.adTemplate;
        this.bvg = aVar.buM;
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final JSONObject getBody() {
        return this.mBodyParams;
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final String getUrl() {
        String strReplaceFirst;
        String strReplaceFirst2;
        Context context = ServiceProvider.getContext();
        AdInfo adInfoEP = e.eP(this.mAdTemplate);
        int i = this.bvg;
        if (i == 1) {
            String str = adInfoEP.adBaseInfo.showUrl;
            if (this.mAdTemplate.mBidEcpm == 0 && ((h) ServiceProvider.get(h.class)).Uk()) {
                strReplaceFirst2 = str.replaceFirst("__PR__", String.valueOf(com.kwad.sdk.core.response.b.a.aV(e.eP(this.mAdTemplate))));
            } else {
                strReplaceFirst2 = str.replaceFirst("__PR__", String.valueOf(this.mAdTemplate.mBidEcpm));
            }
            strReplaceFirst = strReplaceFirst2.replaceFirst("__TYPE__", String.valueOf(this.mAdTemplate.mVideoPlayerStatus.mVideoPlayerType)).replaceFirst("__BEHAVIOR__", String.valueOf(this.mAdTemplate.mVideoPlayerStatus.mVideoPlayerBehavior));
            a(strReplaceFirst, this.bvh);
            a(strReplaceFirst, this.mAdTemplate, this.bvh);
        } else if (i == 2) {
            strReplaceFirst = aj.aD(context, aj.a(adInfoEP.adBaseInfo.clickUrl, this.bvh.oB)).replaceFirst("__PR__", String.valueOf(this.mAdTemplate.mBidEcpm)).replaceFirst("__TYPE__", String.valueOf(this.mAdTemplate.mVideoPlayerStatus.mVideoPlayerType)).replaceFirst("__BEHAVIOR__", String.valueOf(this.mAdTemplate.mVideoPlayerStatus.mVideoPlayerBehavior));
            b(strReplaceFirst, this.bvh);
            a(strReplaceFirst, this.mAdTemplate, this.bvh);
        } else {
            strReplaceFirst = adInfoEP.adBaseInfo.convUrl.replaceFirst("__ACTION__", String.valueOf(this.bvg)).replaceFirst("__PR__", String.valueOf(this.mAdTemplate.mBidEcpm)).replaceFirst("__TYPE__", String.valueOf(this.mAdTemplate.mVideoPlayerStatus.mVideoPlayerType)).replaceFirst("__BEHAVIOR__", String.valueOf(this.mAdTemplate.mVideoPlayerStatus.mVideoPlayerBehavior));
            c(strReplaceFirst, this.bvh);
        }
        Xe();
        return strReplaceFirst;
    }

    private void a(String str, com.kwad.sdk.core.adlog.c.a aVar) {
        if (aVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (aVar.bwD >= 0) {
            putBody("adOrder", aVar.bwD);
        }
        if (aVar.QW >= 0) {
            putBody("adInterstitialSource", aVar.QW);
        }
        if (!TextUtils.isEmpty(aVar.bwb)) {
            putBody("adRenderArea", aVar.bwb);
        }
        putBody("adxResult", aVar.adxResult);
        if (aVar.bwH != 0) {
            putBody("fingerSwipeType", aVar.bwH);
        }
        if (aVar.bwI != 0) {
            putBody("fingerSwipeDistance", aVar.bwI);
        }
        if (aVar.bwA != -1) {
            putBody("installStatus", aVar.bwA);
        }
        if (aVar.QY != null) {
            putBody("clientExtData", aVar.QY.toJson().toString());
        }
        if (aVar.bwL != null) {
            putBody("clientPkFailAdInfo", aVar.bwL);
        }
        if (aVar.Ra != -1) {
            putBody("triggerType", aVar.Ra);
        }
        if (aVar.QZ != 0) {
            putBody("photoSizeStyle", aVar.QZ);
        }
    }

    private void a(String str, AdTemplate adTemplate, com.kwad.sdk.core.adlog.c.a aVar) {
        if (TextUtils.isEmpty(str) || adTemplate == null) {
            return;
        }
        if (adTemplate.mInitVoiceStatus != 0) {
            putBody("initVoiceStatus", adTemplate.mInitVoiceStatus);
        }
        if (this.mAdTemplate.mBidEcpm == 0) {
            putBody("ecpmType", 2);
        } else {
            putBody("ecpmType", 1);
        }
        if (aVar == null) {
            return;
        }
        if (aVar.bws != 0) {
            putBody("adAggPageSource", aVar.bws);
        }
        if (TextUtils.isEmpty(aVar.QX)) {
            return;
        }
        putBody("payload", aVar.QX);
    }

    private void b(String str, com.kwad.sdk.core.adlog.c.a aVar) {
        if (aVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (aVar.oz != 0) {
            putBody("itemClickType", aVar.oz);
        }
        if (!TextUtils.isEmpty(aVar.QX)) {
            putBody("payload", aVar.QX);
        }
        if (aVar.bws != 0) {
            putBody("adAggPageSource", aVar.bws);
        }
        if (aVar.bwD >= 0) {
            putBody("adOrder", aVar.bwD);
        }
        if (aVar.QW >= 0) {
            putBody("adInterstitialSource", aVar.QW);
        }
        if (aVar.Ra != -1) {
            putBody("triggerType", aVar.Ra);
        }
        if (aVar.bwK != 0) {
            putBody("cardCloseType", aVar.bwK);
        }
        putBody("adxResult", aVar.adxResult);
        if (aVar.oC > 0.0d) {
            putBody("splashShakeAcceleration", aVar.oC);
        }
        if (!TextUtils.isEmpty(aVar.bwE)) {
            putBody("splashInteractionRotateAngle", aVar.bwE);
        }
        if (aVar.bwH != 0) {
            putBody("fingerSwipeType", aVar.bwH);
        }
        if (aVar.bwI != 0) {
            putBody("fingerSwipeDistance", aVar.bwI);
        }
        if (aVar.AM > 0) {
            putBody("playedDuration", aVar.AM);
        }
        if (aVar.bwC > 0) {
            putBody("playedRate", aVar.bwC);
        }
        if (aVar.bwL != null) {
            putBody("clientPkFailAdInfo", aVar.bwL);
        }
        if (aVar.bwk != -1) {
            putBody("retainCodeType", aVar.bwk);
        }
        if (aVar.QY != null) {
            putBody("clientExtData", aVar.QY.toJson().toString());
        }
        if (aVar.bwJ != 0) {
            putBody("finger_swiper_angle", aVar.bwJ);
        }
        if (aVar.QZ != 0) {
            putBody("photoSizeStyle", aVar.QZ);
        }
    }

    private void c(String str, com.kwad.sdk.core.adlog.c.a aVar) {
        if (aVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (aVar.bvZ != 0) {
            putBody("itemCloseType", aVar.bvZ);
        }
        if (aVar.bvX > 0) {
            putBody("photoPlaySecond", aVar.bvX);
        }
        if (aVar.bvY != 0) {
            putBody("awardReceiveStage", aVar.bvY);
        }
        if (aVar.bwa != 0) {
            putBody("elementType", aVar.bwa);
        }
        if (!TextUtils.isEmpty(aVar.QX)) {
            putBody("payload", aVar.QX);
        }
        if (aVar.QY != null) {
            putBody("clientExtData", aVar.QY.toJson().toString());
        }
        if (aVar.bwl > 0) {
            putBody("deeplinkType", aVar.bwl);
        }
        if (!TextUtils.isEmpty(aVar.bwm)) {
            putBody("deeplinkAppName", aVar.bwm);
        }
        if (aVar.bwn != 0) {
            putBody("deeplinkFailedReason", aVar.bwn);
        }
        if (aVar.downloadSource > 0) {
            putBody("downloadSource", aVar.downloadSource);
        }
        if (aVar.bwK != 0) {
            putBody("cardCloseType", aVar.bwK);
        }
        if (aVar.bwo > 0) {
            putBody("isPackageChanged", aVar.bwo);
        }
        putBody("installedFrom", aVar.bwp);
        putBody("isChangedEndcard", aVar.bwr);
        if (aVar.bws != 0) {
            putBody("adAggPageSource", aVar.bws);
        }
        if (aVar.bwq != null) {
            putBody("downloadFailedReason", aVar.bwq);
        }
        if (!bq.isNullString(aVar.bwu)) {
            putBody("installedPackageName", aVar.bwu);
        }
        if (!bq.isNullString(aVar.bwt)) {
            putBody("serverPackageName", aVar.bwt);
        }
        if (aVar.bww > 0) {
            putBody("closeButtonClickTime", aVar.bww);
        }
        if (aVar.bwv > 0) {
            putBody("closeButtonImpressionTime", aVar.bwv);
        }
        if (aVar.downloadStatus >= 0) {
            putBody("downloadStatus", aVar.downloadStatus);
        }
        if (aVar.bwx > 0) {
            putBody("landingPageLoadedDuration", aVar.bwx);
        }
        if (aVar.Rz > 0) {
            putBody("leaveTime", aVar.Rz);
        }
        if (aVar.bwy > 0) {
            putBody("adItemClickBackDuration", aVar.bwy);
        }
        if (aVar.bwk != -1) {
            putBody("retainCodeType", aVar.bwk);
        }
        if (aVar.bwc > -1) {
            putBody(IBidding.HIGHEST_LOSS_PRICE, aVar.bwc);
        }
        if (aVar.bwd >= 0 || aVar.bwd == -9999) {
            putBody("impFailReason", aVar.bwd);
        }
        if (aVar.bwe > -1 || aVar.bwe == -9999) {
            putBody("winEcpm", aVar.bwe);
        }
        if (aVar.adnType > 0 || aVar.adnType == -9999) {
            putBody("adnType", aVar.adnType);
        }
        if (!TextUtils.isEmpty(aVar.adnName)) {
            putBody("adnName", aVar.adnName);
        }
        if (!TextUtils.isEmpty(aVar.bwf)) {
            putBody("adnAdvertiser", aVar.bwf);
        }
        if (!TextUtils.isEmpty(aVar.bwg)) {
            putBody("adnTitle", aVar.bwg);
        }
        if (!TextUtils.isEmpty(aVar.bwh)) {
            putBody("adnRequestId", aVar.bwh);
        }
        putBody("adnShowType", aVar.bwi);
        putBody("adnClickType", aVar.bwj);
        putBody("adnMaterialType", aVar.adnMaterialType);
        if (!TextUtils.isEmpty(aVar.adnMaterialUrl)) {
            putBody("adnMaterialUrl", aVar.adnMaterialUrl);
        }
        putBody("downloadCardType", aVar.bwB);
        putBody("landingPageType", aVar.Vc);
        if (aVar.QW >= 0) {
            putBody("adInterstitialSource", aVar.QW);
        }
        if (aVar.bwF > 0) {
            putBody("downloadInstallType", aVar.bwF);
        }
        if (aVar.bwH != 0) {
            putBody("fingerSwipeType", aVar.bwH);
        }
        if (aVar.bwI != 0) {
            putBody("fingerSwipeDistance", aVar.bwI);
        }
        if (aVar.bwG > 0) {
            putBody("businessSceneType", aVar.bwG);
        }
        if (aVar.AM > 0) {
            putBody("playedDuration", aVar.AM);
        }
        if (aVar.bwC > 0) {
            putBody("playedRate", aVar.bwC);
        }
        if (aVar.bwz != -1) {
            putBody("appStorePageType", aVar.bwz);
        }
        if (aVar.Ra != -1) {
            putBody("triggerType", aVar.Ra);
        }
        if (aVar.QZ != 0) {
            putBody("photoSizeStyle", aVar.QZ);
        }
    }

    private void Xe() {
        JSONObject jSONObject = this.bvh.bvW;
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        aa.putValue(jSONObject, "clientTimestamp", System.currentTimeMillis());
        putBody("extData", jSONObject.toString());
    }

    /* renamed from: com.kwad.sdk.core.adlog.a$a, reason: collision with other inner class name */
    public static class C0576a extends com.kwad.sdk.core.response.a.a {
        public int bvi;
        public String bvj;
        public String bvk;
        public String bvm;
        public int bvn;
        public int bvo;
        public int bvp;
        public int bvq;
        public int bvr;
        public boolean bvs;
        public String bvt;
        public JSONObject bvu;
        public int bvw;
        public int bvx;
        public AdTrackLog bvy;
        public String templateId;
        public int bvl = -1;
        public long duration = -1;
        public int showLiveStatus = -1;
        public int bvv = 0;
        public int showLiveStyle = -1;

        @Override // com.kwad.sdk.core.response.a.a
        public void afterToJson(JSONObject jSONObject) {
            super.afterToJson(jSONObject);
            int i = this.bvl;
            if (i != -1) {
                aa.putValue(jSONObject, "shield_reason", i);
            }
            long j = this.duration;
            if (j != -1) {
                aa.putValue(jSONObject, "duration", j);
            }
            int i2 = this.showLiveStatus;
            if (i2 != -1) {
                aa.putValue(jSONObject, "show_live_status", i2);
            }
            int i3 = this.showLiveStyle;
            if (i3 != -1) {
                aa.putValue(jSONObject, "show_live_style", i3);
            }
            AdTrackLog adTrackLog = this.bvy;
            if (adTrackLog != null) {
                aa.putValue(jSONObject, "ad_track_log", adTrackLog.toJson().toString());
            }
            JSONObject jSONObject2 = this.bvu;
            if (jSONObject2 != null) {
                try {
                    Iterator<String> itKeys = jSONObject2.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        jSONObject.putOpt(next, this.bvu.get(next));
                    }
                } catch (Throwable unused) {
                }
            }
        }

        public final AdTrackLog a(AdTemplate adTemplate, String str, String str2, com.kwad.sdk.g.a<AdTrackLog> aVar) {
            h hVar;
            if (adTemplate == null || (hVar = (h) ServiceProvider.get(h.class)) == null || !hVar.Uv()) {
                return null;
            }
            AdTrackLog adTrackLog = new AdTrackLog(str, str2);
            this.bvy = adTrackLog;
            adTrackLog.bindABParams(adTemplate);
            if (aVar != null) {
                aVar.accept(this.bvy);
            }
            return this.bvy;
        }
    }
}
