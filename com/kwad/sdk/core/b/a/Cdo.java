package com.kwad.sdk.core.b.a;

import com.kwad.components.ct.coupon.model.CouponStatusInfo;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.do, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class Cdo implements com.kwad.sdk.core.d<CouponStatusInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((CouponStatusInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((CouponStatusInfo) bVar, jSONObject);
    }

    private static void a(CouponStatusInfo couponStatusInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        couponStatusInfo.statusCode = jSONObject.optInt("statusCode", new Integer("-1").intValue());
        couponStatusInfo.statusName = jSONObject.optString("statusName");
        if (JSONObject.NULL.toString().equals(couponStatusInfo.statusName)) {
            couponStatusInfo.statusName = "";
        }
        couponStatusInfo.currTotalAmount = jSONObject.optDouble("currTotalAmount");
        couponStatusInfo.couponLeftTimes = jSONObject.optInt("couponLeftTimes");
        couponStatusInfo.isNewUser = jSONObject.optBoolean("isNewUser");
    }

    private static JSONObject b(CouponStatusInfo couponStatusInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "statusCode", couponStatusInfo.statusCode);
        if (couponStatusInfo.statusName != null && !couponStatusInfo.statusName.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "statusName", couponStatusInfo.statusName);
        }
        if (couponStatusInfo.currTotalAmount != 0.0d) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "currTotalAmount", couponStatusInfo.currTotalAmount);
        }
        if (couponStatusInfo.couponLeftTimes != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "couponLeftTimes", couponStatusInfo.couponLeftTimes);
        }
        if (couponStatusInfo.isNewUser) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "isNewUser", couponStatusInfo.isNewUser);
        }
        return jSONObject;
    }
}
