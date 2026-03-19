package com.kwad.sdk.core.b.a;

import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.sdk.core.scene.URLPackage;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class gx implements com.kwad.sdk.core.d<ImpInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((ImpInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((ImpInfo) bVar, jSONObject);
    }

    private static void a(ImpInfo impInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        impInfo.pageScene = jSONObject.optLong("pageScene");
        impInfo.subPageScene = jSONObject.optLong("subPageScene");
        impInfo.sdkExtraData = jSONObject.optString("sdkExtraData");
        if (JSONObject.NULL.toString().equals(impInfo.sdkExtraData)) {
            impInfo.sdkExtraData = "";
        }
        impInfo.posId = jSONObject.optLong("posId");
        impInfo.entryScene = jSONObject.optLong("entryScene");
        impInfo.adNum = jSONObject.optInt("adNum");
        impInfo.action = jSONObject.optInt("action");
        impInfo.width = jSONObject.optInt("width");
        impInfo.height = jSONObject.optInt("height");
        impInfo.cpmBidFloor = jSONObject.optLong("cpmBidFloor");
        impInfo.adStyle = jSONObject.optInt("adStyle");
        impInfo.urlPackage = new URLPackage();
        impInfo.urlPackage.parseJson(jSONObject.optJSONObject("urlPackage"));
        impInfo.promoteId = jSONObject.optString("promoteId");
        if (JSONObject.NULL.toString().equals(impInfo.promoteId)) {
            impInfo.promoteId = "";
        }
        impInfo.comment = jSONObject.optString("comment");
        if (JSONObject.NULL.toString().equals(impInfo.comment)) {
            impInfo.comment = "";
        }
        impInfo.backUrl = jSONObject.optString("backUrl");
        if (JSONObject.NULL.toString().equals(impInfo.backUrl)) {
            impInfo.backUrl = "";
        }
        impInfo.userCommRateBuying = jSONObject.optLong("userCommRateBuying");
        impInfo.userCommRateSharing = jSONObject.optLong("userCommRateSharing");
        impInfo.screenOrientation = jSONObject.optInt("screenOrientation");
        impInfo.extraData = jSONObject.optString("extraData");
        if (JSONObject.NULL.toString().equals(impInfo.extraData)) {
            impInfo.extraData = "";
        }
    }

    private static JSONObject b(ImpInfo impInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (impInfo.pageScene != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "pageScene", impInfo.pageScene);
        }
        if (impInfo.subPageScene != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "subPageScene", impInfo.subPageScene);
        }
        if (impInfo.sdkExtraData != null && !impInfo.sdkExtraData.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "sdkExtraData", impInfo.sdkExtraData);
        }
        if (impInfo.posId != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "posId", impInfo.posId);
        }
        if (impInfo.entryScene != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "entryScene", impInfo.entryScene);
        }
        if (impInfo.adNum != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adNum", impInfo.adNum);
        }
        if (impInfo.action != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "action", impInfo.action);
        }
        if (impInfo.width != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "width", impInfo.width);
        }
        if (impInfo.height != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "height", impInfo.height);
        }
        if (impInfo.cpmBidFloor != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "cpmBidFloor", impInfo.cpmBidFloor);
        }
        if (impInfo.adStyle != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adStyle", impInfo.adStyle);
        }
        com.kwad.sdk.utils.aa.a(jSONObject, "urlPackage", impInfo.urlPackage);
        if (impInfo.promoteId != null && !impInfo.promoteId.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "promoteId", impInfo.promoteId);
        }
        if (impInfo.comment != null && !impInfo.comment.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "comment", impInfo.comment);
        }
        if (impInfo.backUrl != null && !impInfo.backUrl.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "backUrl", impInfo.backUrl);
        }
        if (impInfo.userCommRateBuying != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "userCommRateBuying", impInfo.userCommRateBuying);
        }
        if (impInfo.userCommRateSharing != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "userCommRateSharing", impInfo.userCommRateSharing);
        }
        if (impInfo.screenOrientation != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "screenOrientation", impInfo.screenOrientation);
        }
        if (impInfo.extraData != null && !impInfo.extraData.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "extraData", impInfo.extraData);
        }
        return jSONObject;
    }
}
