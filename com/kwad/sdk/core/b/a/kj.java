package com.kwad.sdk.core.b.a;

import com.kwad.components.ct.response.model.CtPhotoInfo;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class kj implements com.kwad.sdk.core.d<CtPhotoInfo.ProductInfo.ProductDetail> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((CtPhotoInfo.ProductInfo.ProductDetail) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((CtPhotoInfo.ProductInfo.ProductDetail) bVar, jSONObject);
    }

    private static void a(CtPhotoInfo.ProductInfo.ProductDetail productDetail, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        productDetail.weakStyleIcon = jSONObject.optString("weakStyleIcon");
        if (JSONObject.NULL.toString().equals(productDetail.weakStyleIcon)) {
            productDetail.weakStyleIcon = "";
        }
        productDetail.weakStyleTitle = jSONObject.optString("weakStyleTitle");
        if (JSONObject.NULL.toString().equals(productDetail.weakStyleTitle)) {
            productDetail.weakStyleTitle = "";
        }
        productDetail.weakStyleAppearTime = jSONObject.optInt("weakStyleAppearTime");
        productDetail.weakStyleShowTime = jSONObject.optInt("weakStyleShowTime");
        productDetail.weakStyleEnableClose = jSONObject.optBoolean("weakStyleEnableClose");
        productDetail.weakStyleAdMark = jSONObject.optString("weakStyleAdMark");
        if (JSONObject.NULL.toString().equals(productDetail.weakStyleAdMark)) {
            productDetail.weakStyleAdMark = "";
        }
        productDetail.strongStyleItemId = jSONObject.optLong("strongStyleItemId");
        productDetail.strongStylePicUrl = jSONObject.optString("strongStylePicUrl");
        if (JSONObject.NULL.toString().equals(productDetail.strongStylePicUrl)) {
            productDetail.strongStylePicUrl = "";
        }
        productDetail.strongStyleTitle = jSONObject.optString("strongStyleTitle");
        if (JSONObject.NULL.toString().equals(productDetail.strongStyleTitle)) {
            productDetail.strongStyleTitle = "";
        }
        productDetail.strongStyleItemPrice = jSONObject.optString("strongStyleItemPrice");
        if (JSONObject.NULL.toString().equals(productDetail.strongStyleItemPrice)) {
            productDetail.strongStyleItemPrice = "";
        }
        productDetail.strongStyleItemUrl = jSONObject.optString("strongStyleItemUrl");
        if (JSONObject.NULL.toString().equals(productDetail.strongStyleItemUrl)) {
            productDetail.strongStyleItemUrl = "";
        }
        productDetail.strongStyleCardUrl = jSONObject.optString("strongStyleCardUrl");
        if (JSONObject.NULL.toString().equals(productDetail.strongStyleCardUrl)) {
            productDetail.strongStyleCardUrl = "";
        }
        productDetail.strongStyleEnableClose = jSONObject.optBoolean("strongStyleEnableClose");
        productDetail.strongStyleAdMark = jSONObject.optString("strongStyleAdMark");
        if (JSONObject.NULL.toString().equals(productDetail.strongStyleAdMark)) {
            productDetail.strongStyleAdMark = "";
        }
        productDetail.strongStyleAppearTime = jSONObject.optInt("strongStyleAppearTime");
        productDetail.strongStylePriceAfterComm = jSONObject.optString("strongStylePriceAfterComm");
        if (JSONObject.NULL.toString().equals(productDetail.strongStylePriceAfterComm)) {
            productDetail.strongStylePriceAfterComm = "";
        }
        productDetail.strongStyleUserCommAmountBuying = jSONObject.optString("strongStyleUserCommAmountBuying");
        if (JSONObject.NULL.toString().equals(productDetail.strongStyleUserCommAmountBuying)) {
            productDetail.strongStyleUserCommAmountBuying = "";
        }
        productDetail.strongStyleUserCommAmountSharing = jSONObject.optString("strongStyleUserCommAmountSharing");
        if (JSONObject.NULL.toString().equals(productDetail.strongStyleUserCommAmountSharing)) {
            productDetail.strongStyleUserCommAmountSharing = "";
        }
        productDetail.platformTypeCode = jSONObject.optInt("platformTypeCode");
        productDetail.nebulaKwaiLink = jSONObject.optString("nebulaKwaiLink");
        if (JSONObject.NULL.toString().equals(productDetail.nebulaKwaiLink)) {
            productDetail.nebulaKwaiLink = "";
        }
        productDetail.linkCode = jSONObject.optString("linkCode");
        if (JSONObject.NULL.toString().equals(productDetail.linkCode)) {
            productDetail.linkCode = "";
        }
    }

    private static JSONObject b(CtPhotoInfo.ProductInfo.ProductDetail productDetail, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (productDetail.weakStyleIcon != null && !productDetail.weakStyleIcon.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "weakStyleIcon", productDetail.weakStyleIcon);
        }
        if (productDetail.weakStyleTitle != null && !productDetail.weakStyleTitle.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "weakStyleTitle", productDetail.weakStyleTitle);
        }
        if (productDetail.weakStyleAppearTime != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "weakStyleAppearTime", productDetail.weakStyleAppearTime);
        }
        if (productDetail.weakStyleShowTime != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "weakStyleShowTime", productDetail.weakStyleShowTime);
        }
        if (productDetail.weakStyleEnableClose) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "weakStyleEnableClose", productDetail.weakStyleEnableClose);
        }
        if (productDetail.weakStyleAdMark != null && !productDetail.weakStyleAdMark.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "weakStyleAdMark", productDetail.weakStyleAdMark);
        }
        if (productDetail.strongStyleItemId != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "strongStyleItemId", productDetail.strongStyleItemId);
        }
        if (productDetail.strongStylePicUrl != null && !productDetail.strongStylePicUrl.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "strongStylePicUrl", productDetail.strongStylePicUrl);
        }
        if (productDetail.strongStyleTitle != null && !productDetail.strongStyleTitle.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "strongStyleTitle", productDetail.strongStyleTitle);
        }
        if (productDetail.strongStyleItemPrice != null && !productDetail.strongStyleItemPrice.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "strongStyleItemPrice", productDetail.strongStyleItemPrice);
        }
        if (productDetail.strongStyleItemUrl != null && !productDetail.strongStyleItemUrl.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "strongStyleItemUrl", productDetail.strongStyleItemUrl);
        }
        if (productDetail.strongStyleCardUrl != null && !productDetail.strongStyleCardUrl.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "strongStyleCardUrl", productDetail.strongStyleCardUrl);
        }
        if (productDetail.strongStyleEnableClose) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "strongStyleEnableClose", productDetail.strongStyleEnableClose);
        }
        if (productDetail.strongStyleAdMark != null && !productDetail.strongStyleAdMark.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "strongStyleAdMark", productDetail.strongStyleAdMark);
        }
        if (productDetail.strongStyleAppearTime != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "strongStyleAppearTime", productDetail.strongStyleAppearTime);
        }
        if (productDetail.strongStylePriceAfterComm != null && !productDetail.strongStylePriceAfterComm.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "strongStylePriceAfterComm", productDetail.strongStylePriceAfterComm);
        }
        if (productDetail.strongStyleUserCommAmountBuying != null && !productDetail.strongStyleUserCommAmountBuying.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "strongStyleUserCommAmountBuying", productDetail.strongStyleUserCommAmountBuying);
        }
        if (productDetail.strongStyleUserCommAmountSharing != null && !productDetail.strongStyleUserCommAmountSharing.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "strongStyleUserCommAmountSharing", productDetail.strongStyleUserCommAmountSharing);
        }
        if (productDetail.platformTypeCode != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "platformTypeCode", productDetail.platformTypeCode);
        }
        if (productDetail.nebulaKwaiLink != null && !productDetail.nebulaKwaiLink.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "nebulaKwaiLink", productDetail.nebulaKwaiLink);
        }
        if (productDetail.linkCode != null && !productDetail.linkCode.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "linkCode", productDetail.linkCode);
        }
        return jSONObject;
    }
}
