package com.kwad.sdk.core.b.a;

import com.kwad.components.ct.coupon.model.CouponStatus;
import com.kwad.components.ct.coupon.model.CouponStatusInfo;
import com.kwad.sdk.core.response.model.SdkConfigData;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class dn implements com.kwad.sdk.core.d<CouponStatus> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((CouponStatus) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((CouponStatus) bVar, jSONObject);
    }

    private static void a(CouponStatus couponStatus, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        couponStatus.couponActiveConfig = new SdkConfigData.CouponActiveConfig();
        couponStatus.couponActiveConfig.parseJson(jSONObject.optJSONObject("couponActiveConfig"));
        couponStatus.couponStatusInfo = new CouponStatusInfo();
        couponStatus.couponStatusInfo.parseJson(jSONObject.optJSONObject("couponStatusInfo"));
        couponStatus.currentWatchVideoCount = jSONObject.optInt("currentWatchVideoCount");
        couponStatus.winningTimes = jSONObject.optInt("winningTimes");
    }

    private static JSONObject b(CouponStatus couponStatus, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.aa.a(jSONObject, "couponActiveConfig", couponStatus.couponActiveConfig);
        com.kwad.sdk.utils.aa.a(jSONObject, "couponStatusInfo", couponStatus.couponStatusInfo);
        if (couponStatus.currentWatchVideoCount != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "currentWatchVideoCount", couponStatus.currentWatchVideoCount);
        }
        if (couponStatus.winningTimes != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "winningTimes", couponStatus.winningTimes);
        }
        return jSONObject;
    }
}
