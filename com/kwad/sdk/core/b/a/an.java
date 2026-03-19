package com.kwad.sdk.core.b.a;

import com.baidu.mobads.container.rewardvideo.RemoteRewardActivity;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.CouponInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class an implements com.kwad.sdk.core.d<AdProductInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdProductInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdProductInfo) bVar, jSONObject);
    }

    private static void a(AdProductInfo adProductInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adProductInfo.icon = jSONObject.optString("icon");
        if (JSONObject.NULL.toString().equals(adProductInfo.icon)) {
            adProductInfo.icon = "";
        }
        adProductInfo.name = jSONObject.optString("name");
        if (JSONObject.NULL.toString().equals(adProductInfo.name)) {
            adProductInfo.name = "";
        }
        adProductInfo.price = jSONObject.optString("price");
        if (JSONObject.NULL.toString().equals(adProductInfo.price)) {
            adProductInfo.price = "";
        }
        adProductInfo.originPrice = jSONObject.optString("originPrice");
        if (JSONObject.NULL.toString().equals(adProductInfo.originPrice)) {
            adProductInfo.originPrice = "";
        }
        adProductInfo.couponList = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("couponList");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                CouponInfo couponInfo = new CouponInfo();
                couponInfo.parseJson(jSONArrayOptJSONArray.optJSONObject(i));
                adProductInfo.couponList.add(couponInfo);
            }
        }
        adProductInfo.volume = jSONObject.optString("volume");
        if (JSONObject.NULL.toString().equals(adProductInfo.volume)) {
            adProductInfo.volume = "";
        }
        adProductInfo.rating = jSONObject.optString(RemoteRewardActivity.JSON_BANNER_RATING_ID);
        if (JSONObject.NULL.toString().equals(adProductInfo.rating)) {
            adProductInfo.rating = "";
        }
        adProductInfo.seckillInfo = new AdProductInfo.SpikeInfo();
        adProductInfo.seckillInfo.parseJson(jSONObject.optJSONObject("seckillInfo"));
    }

    private static JSONObject b(AdProductInfo adProductInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (adProductInfo.icon != null && !adProductInfo.icon.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "icon", adProductInfo.icon);
        }
        if (adProductInfo.name != null && !adProductInfo.name.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "name", adProductInfo.name);
        }
        if (adProductInfo.price != null && !adProductInfo.price.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "price", adProductInfo.price);
        }
        if (adProductInfo.originPrice != null && !adProductInfo.originPrice.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "originPrice", adProductInfo.originPrice);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "couponList", adProductInfo.couponList);
        if (adProductInfo.volume != null && !adProductInfo.volume.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "volume", adProductInfo.volume);
        }
        if (adProductInfo.rating != null && !adProductInfo.rating.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, RemoteRewardActivity.JSON_BANNER_RATING_ID, adProductInfo.rating);
        }
        com.kwad.sdk.utils.aa.a(jSONObject, "seckillInfo", adProductInfo.seckillInfo);
        return jSONObject;
    }
}
