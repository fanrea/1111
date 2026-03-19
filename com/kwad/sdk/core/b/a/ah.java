package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.qq.e.comm.pi.IBidding;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class ah implements com.kwad.sdk.core.d<com.kwad.sdk.core.adlog.c.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.adlog.c.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.adlog.c.a) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.core.adlog.c.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.adTemplate = new AdTemplate();
        aVar.adTemplate.parseJson(jSONObject.optJSONObject("adTemplate"));
        aVar.bvW = jSONObject.optJSONObject("extData");
        aVar.buM = jSONObject.optInt("adActionType");
        aVar.bvX = jSONObject.optInt("photoPlaySecond");
        aVar.bvY = jSONObject.optInt("awardReceiveStage");
        aVar.oz = jSONObject.optInt("itemClickType");
        aVar.bvZ = jSONObject.optInt("itemCloseType");
        aVar.bwa = jSONObject.optInt("elementType");
        aVar.bwb = jSONObject.optString("adRenderArea");
        if (JSONObject.NULL.toString().equals(aVar.bwb)) {
            aVar.bwb = "";
        }
        aVar.bwc = jSONObject.optLong(IBidding.HIGHEST_LOSS_PRICE);
        aVar.bwd = jSONObject.optInt("impFailReason");
        aVar.bwe = jSONObject.optLong("winEcpm");
        aVar.adnType = jSONObject.optInt("adnType");
        aVar.adnName = jSONObject.optString("adnName");
        if (JSONObject.NULL.toString().equals(aVar.adnName)) {
            aVar.adnName = "";
        }
        aVar.bwf = jSONObject.optString("adnAdvertiser");
        if (JSONObject.NULL.toString().equals(aVar.bwf)) {
            aVar.bwf = "";
        }
        aVar.bwg = jSONObject.optString("adnTitle");
        if (JSONObject.NULL.toString().equals(aVar.bwg)) {
            aVar.bwg = "";
        }
        aVar.bwh = jSONObject.optString("adnRequestId");
        if (JSONObject.NULL.toString().equals(aVar.bwh)) {
            aVar.bwh = "";
        }
        aVar.bwi = jSONObject.optInt("adnShowType");
        aVar.bwj = jSONObject.optInt("adnClickType");
        aVar.adnMaterialType = jSONObject.optInt("adnMaterialType");
        aVar.adnMaterialUrl = jSONObject.optString("adnMaterialUrl");
        if (JSONObject.NULL.toString().equals(aVar.adnMaterialUrl)) {
            aVar.adnMaterialUrl = "";
        }
        aVar.bwk = jSONObject.optInt("retainCodeType");
        aVar.QZ = jSONObject.optInt("photoSizeStyle");
        aVar.QX = jSONObject.optString("payload");
        if (JSONObject.NULL.toString().equals(aVar.QX)) {
            aVar.QX = "";
        }
        aVar.bwl = jSONObject.optInt("deeplinkType");
        aVar.bwm = jSONObject.optString("deeplinkAppName");
        if (JSONObject.NULL.toString().equals(aVar.bwm)) {
            aVar.bwm = "";
        }
        aVar.bwn = jSONObject.optInt("deeplinkFailedReason");
        aVar.downloadSource = jSONObject.optInt("downloadSource");
        aVar.bwo = jSONObject.optInt("isPackageChanged");
        aVar.bwp = jSONObject.optString("installedFrom");
        if (JSONObject.NULL.toString().equals(aVar.bwp)) {
            aVar.bwp = "";
        }
        aVar.bwq = jSONObject.optString("downloadFailedReason");
        if (JSONObject.NULL.toString().equals(aVar.bwq)) {
            aVar.bwq = "";
        }
        aVar.bwr = jSONObject.optInt("isChangedEndcard");
        aVar.bws = jSONObject.optInt("adAggPageSource");
        aVar.bwt = jSONObject.optString("serverPackageName");
        if (JSONObject.NULL.toString().equals(aVar.bwt)) {
            aVar.bwt = "";
        }
        aVar.bwu = jSONObject.optString("installedPackageName");
        if (JSONObject.NULL.toString().equals(aVar.bwu)) {
            aVar.bwu = "";
        }
        aVar.bwv = jSONObject.optInt("closeButtonImpressionTime");
        aVar.bww = jSONObject.optInt("closeButtonClickTime");
        aVar.bwx = jSONObject.optLong("landingPageLoadedDuration");
        aVar.Rz = jSONObject.optLong("leaveTime");
        aVar.bwy = jSONObject.optLong("adItemClickBackDuration");
        aVar.bwz = jSONObject.optInt("appStorePageType");
        aVar.bwA = jSONObject.optInt("installStatus");
        aVar.downloadStatus = jSONObject.optInt("downloadStatus");
        aVar.bwB = jSONObject.optInt("downloadCardType");
        aVar.QY = new a.C0576a();
        aVar.QY.parseJson(jSONObject.optJSONObject("clientExtData"));
        aVar.Vc = jSONObject.optInt("landingPageType");
        aVar.AM = jSONObject.optLong("playedDuration");
        aVar.bwC = jSONObject.optInt("playedRate");
        aVar.bwD = jSONObject.optInt("adOrder");
        aVar.QW = jSONObject.optInt("adInterstitialSource");
        aVar.oC = jSONObject.optDouble("splashShakeAcceleration");
        aVar.bwE = jSONObject.optString("splashInteractionRotateAngle");
        if (JSONObject.NULL.toString().equals(aVar.bwE)) {
            aVar.bwE = "";
        }
        aVar.bwF = jSONObject.optInt("downloadInstallType");
        aVar.bwG = jSONObject.optInt("businessSceneType");
        aVar.adxResult = jSONObject.optInt("adxResult");
        aVar.bwH = jSONObject.optInt("fingerSwipeType");
        aVar.bwI = jSONObject.optInt("fingerSwipeDistance");
        aVar.bwJ = jSONObject.optInt("finger_swipe_angle");
        aVar.Ra = jSONObject.optInt("triggerType");
        aVar.bwK = jSONObject.optInt("cardCloseType");
        aVar.bwL = jSONObject.optString("clientPkFailAdInfo");
        if (JSONObject.NULL.toString().equals(aVar.bwL)) {
            aVar.bwL = "";
        }
    }

    private static JSONObject b(com.kwad.sdk.core.adlog.c.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.aa.a(jSONObject, "adTemplate", aVar.adTemplate);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "extData", aVar.bvW);
        if (aVar.buM != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adActionType", aVar.buM);
        }
        if (aVar.bvX != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "photoPlaySecond", aVar.bvX);
        }
        if (aVar.bvY != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "awardReceiveStage", aVar.bvY);
        }
        if (aVar.oz != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "itemClickType", aVar.oz);
        }
        if (aVar.bvZ != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "itemCloseType", aVar.bvZ);
        }
        if (aVar.bwa != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "elementType", aVar.bwa);
        }
        if (aVar.bwb != null && !aVar.bwb.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adRenderArea", aVar.bwb);
        }
        if (aVar.bwc != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, IBidding.HIGHEST_LOSS_PRICE, aVar.bwc);
        }
        if (aVar.bwd != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "impFailReason", aVar.bwd);
        }
        if (aVar.bwe != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "winEcpm", aVar.bwe);
        }
        if (aVar.adnType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adnType", aVar.adnType);
        }
        if (aVar.adnName != null && !aVar.adnName.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adnName", aVar.adnName);
        }
        if (aVar.bwf != null && !aVar.bwf.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adnAdvertiser", aVar.bwf);
        }
        if (aVar.bwg != null && !aVar.bwg.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adnTitle", aVar.bwg);
        }
        if (aVar.bwh != null && !aVar.bwh.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adnRequestId", aVar.bwh);
        }
        if (aVar.bwi != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adnShowType", aVar.bwi);
        }
        if (aVar.bwj != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adnClickType", aVar.bwj);
        }
        if (aVar.adnMaterialType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adnMaterialType", aVar.adnMaterialType);
        }
        if (aVar.adnMaterialUrl != null && !aVar.adnMaterialUrl.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adnMaterialUrl", aVar.adnMaterialUrl);
        }
        if (aVar.bwk != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "retainCodeType", aVar.bwk);
        }
        if (aVar.QZ != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "photoSizeStyle", aVar.QZ);
        }
        if (aVar.QX != null && !aVar.QX.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "payload", aVar.QX);
        }
        if (aVar.bwl != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "deeplinkType", aVar.bwl);
        }
        if (aVar.bwm != null && !aVar.bwm.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "deeplinkAppName", aVar.bwm);
        }
        if (aVar.bwn != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "deeplinkFailedReason", aVar.bwn);
        }
        if (aVar.downloadSource != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "downloadSource", aVar.downloadSource);
        }
        if (aVar.bwo != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "isPackageChanged", aVar.bwo);
        }
        if (aVar.bwp != null && !aVar.bwp.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "installedFrom", aVar.bwp);
        }
        if (aVar.bwq != null && !aVar.bwq.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "downloadFailedReason", aVar.bwq);
        }
        if (aVar.bwr != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "isChangedEndcard", aVar.bwr);
        }
        if (aVar.bws != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adAggPageSource", aVar.bws);
        }
        if (aVar.bwt != null && !aVar.bwt.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "serverPackageName", aVar.bwt);
        }
        if (aVar.bwu != null && !aVar.bwu.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "installedPackageName", aVar.bwu);
        }
        if (aVar.bwv != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "closeButtonImpressionTime", aVar.bwv);
        }
        if (aVar.bww != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "closeButtonClickTime", aVar.bww);
        }
        if (aVar.bwx != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "landingPageLoadedDuration", aVar.bwx);
        }
        if (aVar.Rz != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "leaveTime", aVar.Rz);
        }
        if (aVar.bwy != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adItemClickBackDuration", aVar.bwy);
        }
        if (aVar.bwz != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "appStorePageType", aVar.bwz);
        }
        if (aVar.bwA != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "installStatus", aVar.bwA);
        }
        if (aVar.downloadStatus != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "downloadStatus", aVar.downloadStatus);
        }
        if (aVar.bwB != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "downloadCardType", aVar.bwB);
        }
        com.kwad.sdk.utils.aa.a(jSONObject, "clientExtData", aVar.QY);
        if (aVar.Vc != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "landingPageType", aVar.Vc);
        }
        if (aVar.AM != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "playedDuration", aVar.AM);
        }
        if (aVar.bwC != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "playedRate", aVar.bwC);
        }
        if (aVar.bwD != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adOrder", aVar.bwD);
        }
        if (aVar.QW != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adInterstitialSource", aVar.QW);
        }
        if (aVar.oC != 0.0d) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "splashShakeAcceleration", aVar.oC);
        }
        if (aVar.bwE != null && !aVar.bwE.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "splashInteractionRotateAngle", aVar.bwE);
        }
        if (aVar.bwF != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "downloadInstallType", aVar.bwF);
        }
        if (aVar.bwG != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "businessSceneType", aVar.bwG);
        }
        if (aVar.adxResult != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adxResult", aVar.adxResult);
        }
        if (aVar.bwH != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "fingerSwipeType", aVar.bwH);
        }
        if (aVar.bwI != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "fingerSwipeDistance", aVar.bwI);
        }
        if (aVar.bwJ != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "finger_swipe_angle", aVar.bwJ);
        }
        if (aVar.Ra != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "triggerType", aVar.Ra);
        }
        if (aVar.bwK != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "cardCloseType", aVar.bwK);
        }
        if (aVar.bwL != null && !aVar.bwL.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "clientPkFailAdInfo", aVar.bwL);
        }
        return jSONObject;
    }
}
