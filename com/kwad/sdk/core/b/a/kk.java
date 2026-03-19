package com.kwad.sdk.core.b.a;

import com.kwad.components.ct.response.model.CtPhotoInfo;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class kk implements com.kwad.sdk.core.d<CtPhotoInfo.ProductInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((CtPhotoInfo.ProductInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((CtPhotoInfo.ProductInfo) bVar, jSONObject);
    }

    private static void a(CtPhotoInfo.ProductInfo productInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        productInfo.productId = jSONObject.optLong("productId");
        productInfo.shennongjiaLog = jSONObject.optString("shennongjiaLog");
        if (JSONObject.NULL.toString().equals(productInfo.shennongjiaLog)) {
            productInfo.shennongjiaLog = "";
        }
        productInfo.productDetails = jSONObject.optString("productDetail");
        if (JSONObject.NULL.toString().equals(productInfo.productDetails)) {
            productInfo.productDetails = "";
        }
    }

    private static JSONObject b(CtPhotoInfo.ProductInfo productInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (productInfo.productId != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "productId", productInfo.productId);
        }
        if (productInfo.shennongjiaLog != null && !productInfo.shennongjiaLog.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "shennongjiaLog", productInfo.shennongjiaLog);
        }
        if (productInfo.productDetails != null && !productInfo.productDetails.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "productDetail", productInfo.productDetails);
        }
        return jSONObject;
    }
}
