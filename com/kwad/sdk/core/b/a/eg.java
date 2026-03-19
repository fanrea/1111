package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdStyleInfo;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class eg implements com.kwad.sdk.core.d<AdStyleInfo.PlayDetailInfo.DetailWebCardInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdStyleInfo.PlayDetailInfo.DetailWebCardInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdStyleInfo.PlayDetailInfo.DetailWebCardInfo) bVar, jSONObject);
    }

    private static void a(AdStyleInfo.PlayDetailInfo.DetailWebCardInfo detailWebCardInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        detailWebCardInfo.style = jSONObject.optInt("style");
        detailWebCardInfo.maxTimeOut = jSONObject.optLong("maxTimeOut");
        detailWebCardInfo.typeLandscape = jSONObject.optLong("typeLandscape");
        detailWebCardInfo.typePortrait = jSONObject.optLong("typePortrait");
        detailWebCardInfo.cardUrl = jSONObject.optString("cardUrl");
        if (JSONObject.NULL.toString().equals(detailWebCardInfo.cardUrl)) {
            detailWebCardInfo.cardUrl = "";
        }
        detailWebCardInfo.cardData = jSONObject.optString("cardData");
        if (JSONObject.NULL.toString().equals(detailWebCardInfo.cardData)) {
            detailWebCardInfo.cardData = "";
        }
        detailWebCardInfo.cardShowTime = jSONObject.optLong("cardShowTime");
        detailWebCardInfo.cardType = jSONObject.optInt("cardType");
    }

    private static JSONObject b(AdStyleInfo.PlayDetailInfo.DetailWebCardInfo detailWebCardInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (detailWebCardInfo.style != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "style", detailWebCardInfo.style);
        }
        if (detailWebCardInfo.maxTimeOut != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "maxTimeOut", detailWebCardInfo.maxTimeOut);
        }
        if (detailWebCardInfo.typeLandscape != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "typeLandscape", detailWebCardInfo.typeLandscape);
        }
        if (detailWebCardInfo.typePortrait != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "typePortrait", detailWebCardInfo.typePortrait);
        }
        if (detailWebCardInfo.cardUrl != null && !detailWebCardInfo.cardUrl.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "cardUrl", detailWebCardInfo.cardUrl);
        }
        if (detailWebCardInfo.cardData != null && !detailWebCardInfo.cardData.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "cardData", detailWebCardInfo.cardData);
        }
        if (detailWebCardInfo.cardShowTime != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "cardShowTime", detailWebCardInfo.cardShowTime);
        }
        if (detailWebCardInfo.cardType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "cardType", detailWebCardInfo.cardType);
        }
        return jSONObject;
    }
}
