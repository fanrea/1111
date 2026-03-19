package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdStyleInfo;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class ba implements com.kwad.sdk.core.d<AdStyleInfo.PlayEndInfo.AdWebCardInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdStyleInfo.PlayEndInfo.AdWebCardInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdStyleInfo.PlayEndInfo.AdWebCardInfo) bVar, jSONObject);
    }

    private static void a(AdStyleInfo.PlayEndInfo.AdWebCardInfo adWebCardInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adWebCardInfo.typeLandscape = jSONObject.optLong("typeLandscape");
        adWebCardInfo.typePortrait = jSONObject.optLong("typePortrait");
        adWebCardInfo.cardUrl = jSONObject.optString("cardUrl");
        if (JSONObject.NULL.toString().equals(adWebCardInfo.cardUrl)) {
            adWebCardInfo.cardUrl = "";
        }
        adWebCardInfo.cardData = jSONObject.optString("cardData");
        if (JSONObject.NULL.toString().equals(adWebCardInfo.cardData)) {
            adWebCardInfo.cardData = "";
        }
        adWebCardInfo.cardShowPlayCount = jSONObject.optInt("cardShowPlayCount");
        adWebCardInfo.cardShowTime = jSONObject.optLong("cardShowTime");
        adWebCardInfo.cardDelayTime = jSONObject.optLong("cardDelayTime");
    }

    private static JSONObject b(AdStyleInfo.PlayEndInfo.AdWebCardInfo adWebCardInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (adWebCardInfo.typeLandscape != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "typeLandscape", adWebCardInfo.typeLandscape);
        }
        if (adWebCardInfo.typePortrait != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "typePortrait", adWebCardInfo.typePortrait);
        }
        if (adWebCardInfo.cardUrl != null && !adWebCardInfo.cardUrl.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "cardUrl", adWebCardInfo.cardUrl);
        }
        if (adWebCardInfo.cardData != null && !adWebCardInfo.cardData.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "cardData", adWebCardInfo.cardData);
        }
        if (adWebCardInfo.cardShowPlayCount != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "cardShowPlayCount", adWebCardInfo.cardShowPlayCount);
        }
        if (adWebCardInfo.cardShowTime != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "cardShowTime", adWebCardInfo.cardShowTime);
        }
        if (adWebCardInfo.cardDelayTime != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "cardDelayTime", adWebCardInfo.cardDelayTime);
        }
        return jSONObject;
    }
}
