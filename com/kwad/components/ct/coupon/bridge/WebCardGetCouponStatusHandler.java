package com.kwad.components.ct.coupon.bridge;

import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.ct.coupon.model.CouponStatus;
import com.kwad.sdk.utils.aa;
import java.io.Serializable;
import org.json.JSONArray;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class WebCardGetCouponStatusHandler implements com.kwad.sdk.core.webview.c.a {
    private final CouponStatus amC;
    private ImpInfo amX;

    public static class CouponStatusParams extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b, Serializable {
        private static final long serialVersionUID = -2484597607614168681L;
        public CouponStatus couponStatus;
        public JSONArray impInfo;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "getCouponStatus";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    public WebCardGetCouponStatusHandler(CouponStatus couponStatus, ImpInfo impInfo) {
        this.amC = couponStatus;
        this.amX = impInfo;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        com.kwad.sdk.core.d.c.d("WebCardGetCouponStatusHandler", "WebCardGetCouponStatusHandler =" + this.amC.toJson());
        CouponStatusParams couponStatusParams = new CouponStatusParams();
        couponStatusParams.couponStatus = this.amC;
        JSONArray jSONArray = new JSONArray();
        aa.a(jSONArray, this.amX.toJson());
        couponStatusParams.impInfo = jSONArray;
        com.kwad.sdk.core.d.c.d("WebCardGetCouponStatusHandler", "couponStatusParams =" + couponStatusParams.toJson().toString());
        cVar.a(couponStatusParams);
    }
}
