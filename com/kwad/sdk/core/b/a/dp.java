package com.kwad.sdk.core.b.a;

import com.kwad.components.ct.coupon.bridge.WebCardGetCouponStatusHandler;
import com.kwad.components.ct.coupon.model.CouponStatus;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class dp implements com.kwad.sdk.core.d<WebCardGetCouponStatusHandler.CouponStatusParams> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((WebCardGetCouponStatusHandler.CouponStatusParams) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((WebCardGetCouponStatusHandler.CouponStatusParams) bVar, jSONObject);
    }

    private static void a(WebCardGetCouponStatusHandler.CouponStatusParams couponStatusParams, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        couponStatusParams.couponStatus = new CouponStatus();
        couponStatusParams.couponStatus.parseJson(jSONObject.optJSONObject("couponStatus"));
        couponStatusParams.impInfo = jSONObject.optJSONArray("impInfo");
    }

    private static JSONObject b(WebCardGetCouponStatusHandler.CouponStatusParams couponStatusParams, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.aa.a(jSONObject, "couponStatus", couponStatusParams.couponStatus);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "impInfo", couponStatusParams.impInfo);
        return jSONObject;
    }
}
