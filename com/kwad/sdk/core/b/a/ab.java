package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.WebCardRegisterLiveShopListener;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class ab implements com.kwad.sdk.core.d<WebCardRegisterLiveShopListener.AdLiveItemShopInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((WebCardRegisterLiveShopListener.AdLiveItemShopInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((WebCardRegisterLiveShopListener.AdLiveItemShopInfo) bVar, jSONObject);
    }

    private static void a(WebCardRegisterLiveShopListener.AdLiveItemShopInfo adLiveItemShopInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adLiveItemShopInfo.status = jSONObject.optInt("status");
        adLiveItemShopInfo.title = jSONObject.optString("title");
        if (JSONObject.NULL.toString().equals(adLiveItemShopInfo.title)) {
            adLiveItemShopInfo.title = "";
        }
        adLiveItemShopInfo.url = jSONObject.optString("url");
        if (JSONObject.NULL.toString().equals(adLiveItemShopInfo.url)) {
            adLiveItemShopInfo.url = "";
        }
        adLiveItemShopInfo.price = jSONObject.optString("price");
        if (JSONObject.NULL.toString().equals(adLiveItemShopInfo.price)) {
            adLiveItemShopInfo.price = "";
        }
    }

    private static JSONObject b(WebCardRegisterLiveShopListener.AdLiveItemShopInfo adLiveItemShopInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (adLiveItemShopInfo.status != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "status", adLiveItemShopInfo.status);
        }
        if (adLiveItemShopInfo.title != null && !adLiveItemShopInfo.title.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "title", adLiveItemShopInfo.title);
        }
        if (adLiveItemShopInfo.url != null && !adLiveItemShopInfo.url.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "url", adLiveItemShopInfo.url);
        }
        if (adLiveItemShopInfo.price != null && !adLiveItemShopInfo.price.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "price", adLiveItemShopInfo.price);
        }
        return jSONObject;
    }
}
