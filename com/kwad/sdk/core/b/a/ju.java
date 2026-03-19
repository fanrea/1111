package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdStyleInfo;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class ju implements com.kwad.sdk.core.d<AdStyleInfo.PlayDetailInfo.PatchEcInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdStyleInfo.PlayDetailInfo.PatchEcInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdStyleInfo.PlayDetailInfo.PatchEcInfo) bVar, jSONObject);
    }

    private static void a(AdStyleInfo.PlayDetailInfo.PatchEcInfo patchEcInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        patchEcInfo.strongStyleItemId = jSONObject.optString("strongStyleItemId");
        if (JSONObject.NULL.toString().equals(patchEcInfo.strongStyleItemId)) {
            patchEcInfo.strongStyleItemId = "";
        }
        patchEcInfo.strongStylePicUrl = jSONObject.optString("strongStylePicUrl");
        if (JSONObject.NULL.toString().equals(patchEcInfo.strongStylePicUrl)) {
            patchEcInfo.strongStylePicUrl = "";
        }
        patchEcInfo.strongStyleItemUrl = jSONObject.optString("strongStyleItemUrl");
        if (JSONObject.NULL.toString().equals(patchEcInfo.strongStyleItemUrl)) {
            patchEcInfo.strongStyleItemUrl = "";
        }
        patchEcInfo.strongStyleItemPrice = jSONObject.optString("strongStyleItemPrice");
        if (JSONObject.NULL.toString().equals(patchEcInfo.strongStyleItemPrice)) {
            patchEcInfo.strongStyleItemPrice = "";
        }
        patchEcInfo.strongStylePriceAfterComm = jSONObject.optString("strongStylePriceAfterComm");
        if (JSONObject.NULL.toString().equals(patchEcInfo.strongStylePriceAfterComm)) {
            patchEcInfo.strongStylePriceAfterComm = "";
        }
        patchEcInfo.strongStyleUserCommAmountBuying = jSONObject.optString("strongStyleUserCommAmountBuying");
        if (JSONObject.NULL.toString().equals(patchEcInfo.strongStyleUserCommAmountBuying)) {
            patchEcInfo.strongStyleUserCommAmountBuying = "";
        }
        patchEcInfo.strongStyleUserCommAmountSharing = jSONObject.optString("strongStyleUserCommAmountSharing");
        if (JSONObject.NULL.toString().equals(patchEcInfo.strongStyleUserCommAmountSharing)) {
            patchEcInfo.strongStyleUserCommAmountSharing = "";
        }
        patchEcInfo.nebulaKwaiLink = jSONObject.optString("nebulaKwaiLink");
        if (JSONObject.NULL.toString().equals(patchEcInfo.nebulaKwaiLink)) {
            patchEcInfo.nebulaKwaiLink = "";
        }
        patchEcInfo.linkCode = jSONObject.optString("linkCode");
        if (JSONObject.NULL.toString().equals(patchEcInfo.linkCode)) {
            patchEcInfo.linkCode = "";
        }
        patchEcInfo.platformTypeCode = jSONObject.optInt("platformTypeCode");
    }

    private static JSONObject b(AdStyleInfo.PlayDetailInfo.PatchEcInfo patchEcInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (patchEcInfo.strongStyleItemId != null && !patchEcInfo.strongStyleItemId.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "strongStyleItemId", patchEcInfo.strongStyleItemId);
        }
        if (patchEcInfo.strongStylePicUrl != null && !patchEcInfo.strongStylePicUrl.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "strongStylePicUrl", patchEcInfo.strongStylePicUrl);
        }
        if (patchEcInfo.strongStyleItemUrl != null && !patchEcInfo.strongStyleItemUrl.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "strongStyleItemUrl", patchEcInfo.strongStyleItemUrl);
        }
        if (patchEcInfo.strongStyleItemPrice != null && !patchEcInfo.strongStyleItemPrice.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "strongStyleItemPrice", patchEcInfo.strongStyleItemPrice);
        }
        if (patchEcInfo.strongStylePriceAfterComm != null && !patchEcInfo.strongStylePriceAfterComm.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "strongStylePriceAfterComm", patchEcInfo.strongStylePriceAfterComm);
        }
        if (patchEcInfo.strongStyleUserCommAmountBuying != null && !patchEcInfo.strongStyleUserCommAmountBuying.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "strongStyleUserCommAmountBuying", patchEcInfo.strongStyleUserCommAmountBuying);
        }
        if (patchEcInfo.strongStyleUserCommAmountSharing != null && !patchEcInfo.strongStyleUserCommAmountSharing.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "strongStyleUserCommAmountSharing", patchEcInfo.strongStyleUserCommAmountSharing);
        }
        if (patchEcInfo.nebulaKwaiLink != null && !patchEcInfo.nebulaKwaiLink.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "nebulaKwaiLink", patchEcInfo.nebulaKwaiLink);
        }
        if (patchEcInfo.linkCode != null && !patchEcInfo.linkCode.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "linkCode", patchEcInfo.linkCode);
        }
        if (patchEcInfo.platformTypeCode != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "platformTypeCode", patchEcInfo.platformTypeCode);
        }
        return jSONObject;
    }
}
