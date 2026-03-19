package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.TKAdLiveShopItemInfo;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class mo implements com.kwad.sdk.core.d<TKAdLiveShopItemInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((TKAdLiveShopItemInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((TKAdLiveShopItemInfo) bVar, jSONObject);
    }

    private static void a(TKAdLiveShopItemInfo tKAdLiveShopItemInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        tKAdLiveShopItemInfo.itemId = jSONObject.optString("itemId");
        if (JSONObject.NULL.toString().equals(tKAdLiveShopItemInfo.itemId)) {
            tKAdLiveShopItemInfo.itemId = "";
        }
        tKAdLiveShopItemInfo.imageUrl = jSONObject.optString("imageUrl");
        if (JSONObject.NULL.toString().equals(tKAdLiveShopItemInfo.imageUrl)) {
            tKAdLiveShopItemInfo.imageUrl = "";
        }
        tKAdLiveShopItemInfo.title = jSONObject.optString("title");
        if (JSONObject.NULL.toString().equals(tKAdLiveShopItemInfo.title)) {
            tKAdLiveShopItemInfo.title = "";
        }
        tKAdLiveShopItemInfo.price = jSONObject.optString("price");
        if (JSONObject.NULL.toString().equals(tKAdLiveShopItemInfo.price)) {
            tKAdLiveShopItemInfo.price = "";
        }
    }

    private static JSONObject b(TKAdLiveShopItemInfo tKAdLiveShopItemInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (tKAdLiveShopItemInfo.itemId != null && !tKAdLiveShopItemInfo.itemId.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "itemId", tKAdLiveShopItemInfo.itemId);
        }
        if (tKAdLiveShopItemInfo.imageUrl != null && !tKAdLiveShopItemInfo.imageUrl.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "imageUrl", tKAdLiveShopItemInfo.imageUrl);
        }
        if (tKAdLiveShopItemInfo.title != null && !tKAdLiveShopItemInfo.title.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "title", tKAdLiveShopItemInfo.title);
        }
        if (tKAdLiveShopItemInfo.price != null && !tKAdLiveShopItemInfo.price.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "price", tKAdLiveShopItemInfo.price);
        }
        return jSONObject;
    }
}
