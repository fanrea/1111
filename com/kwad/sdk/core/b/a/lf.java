package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.internal.api.AdLabelImpl;
import com.kwad.sdk.internal.api.NativeAdExtraDataImpl;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.internal.api.SplashExtraDataImpl;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class lf implements com.kwad.sdk.core.d<SceneImpl> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((SceneImpl) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((SceneImpl) bVar, jSONObject);
    }

    private static void a(SceneImpl sceneImpl, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        sceneImpl.urlPackage = new URLPackage();
        sceneImpl.urlPackage.parseJson(jSONObject.optJSONObject("urlPackage"));
        sceneImpl.posId = jSONObject.optLong("posId");
        sceneImpl.entryScene = jSONObject.optLong("entryScene");
        sceneImpl.adNum = jSONObject.optInt("adNum");
        sceneImpl.action = jSONObject.optInt("action");
        sceneImpl.width = jSONObject.optInt("width");
        sceneImpl.height = jSONObject.optInt("height");
        sceneImpl.adStyle = jSONObject.optInt("adStyle");
        sceneImpl.screenOrientation = jSONObject.optInt("screenOrientation");
        sceneImpl.mKsAdLabel = new AdLabelImpl();
        sceneImpl.mKsAdLabel.parseJson(jSONObject.optJSONObject("mKsAdLabel"));
        sceneImpl.splashExtraData = new SplashExtraDataImpl();
        sceneImpl.splashExtraData.parseJson(jSONObject.optJSONObject("splashExtraData"));
        sceneImpl.nativeAdExtraData = new NativeAdExtraDataImpl();
        sceneImpl.nativeAdExtraData.parseJson(jSONObject.optJSONObject("nativeAdExtraData"));
        sceneImpl.promoteId = jSONObject.optString("promoteId");
        if (JSONObject.NULL.toString().equals(sceneImpl.promoteId)) {
            sceneImpl.promoteId = "";
        }
        sceneImpl.comment = jSONObject.optString("comment");
        if (JSONObject.NULL.toString().equals(sceneImpl.comment)) {
            sceneImpl.comment = "";
        }
        sceneImpl.userCommRateBuying = jSONObject.optLong("userCommRateBuying");
        sceneImpl.userCommRateSharing = jSONObject.optLong("userCommRateSharing");
        sceneImpl.backUrl = jSONObject.optString("backUrl");
        if (JSONObject.NULL.toString().equals(sceneImpl.backUrl)) {
            sceneImpl.backUrl = "";
        }
        sceneImpl.bidResponse = jSONObject.optString("bidResponse");
        if (JSONObject.NULL.toString().equals(sceneImpl.bidResponse)) {
            sceneImpl.bidResponse = "";
        }
        sceneImpl.bidResponseV2 = jSONObject.optString("bidResponseV2");
        if (JSONObject.NULL.toString().equals(sceneImpl.bidResponseV2)) {
            sceneImpl.bidResponseV2 = "";
        }
    }

    private static JSONObject b(SceneImpl sceneImpl, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.aa.a(jSONObject, "urlPackage", sceneImpl.urlPackage);
        if (sceneImpl.posId != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "posId", sceneImpl.posId);
        }
        if (sceneImpl.entryScene != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "entryScene", sceneImpl.entryScene);
        }
        if (sceneImpl.adNum != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adNum", sceneImpl.adNum);
        }
        if (sceneImpl.action != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "action", sceneImpl.action);
        }
        if (sceneImpl.width != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "width", sceneImpl.width);
        }
        if (sceneImpl.height != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "height", sceneImpl.height);
        }
        if (sceneImpl.adStyle != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adStyle", sceneImpl.adStyle);
        }
        if (sceneImpl.screenOrientation != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "screenOrientation", sceneImpl.screenOrientation);
        }
        com.kwad.sdk.utils.aa.a(jSONObject, "mKsAdLabel", sceneImpl.mKsAdLabel);
        com.kwad.sdk.utils.aa.a(jSONObject, "splashExtraData", sceneImpl.splashExtraData);
        com.kwad.sdk.utils.aa.a(jSONObject, "nativeAdExtraData", sceneImpl.nativeAdExtraData);
        if (sceneImpl.promoteId != null && !sceneImpl.promoteId.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "promoteId", sceneImpl.promoteId);
        }
        if (sceneImpl.comment != null && !sceneImpl.comment.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "comment", sceneImpl.comment);
        }
        if (sceneImpl.userCommRateBuying != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "userCommRateBuying", sceneImpl.userCommRateBuying);
        }
        if (sceneImpl.userCommRateSharing != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "userCommRateSharing", sceneImpl.userCommRateSharing);
        }
        if (sceneImpl.backUrl != null && !sceneImpl.backUrl.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "backUrl", sceneImpl.backUrl);
        }
        if (sceneImpl.bidResponse != null && !sceneImpl.bidResponse.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "bidResponse", sceneImpl.bidResponse);
        }
        if (sceneImpl.bidResponseV2 != null && !sceneImpl.bidResponseV2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "bidResponseV2", sceneImpl.bidResponseV2);
        }
        return jSONObject;
    }
}
