package com.kwad.components.ct.coupon.bridge;

import android.os.Handler;
import android.os.Looper;
import com.kwad.components.ct.coupon.model.CouponStatusInfo;
import com.kwad.sdk.utils.bh;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class f implements com.kwad.sdk.core.webview.c.a {
    private Handler aeI = new Handler(Looper.getMainLooper());
    private com.kwad.components.ct.coupon.bridge.a.a anl;

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "updateCouponStatus";
    }

    public f(com.kwad.components.ct.coupon.bridge.a.a aVar) {
        this.anl = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        final CouponStatusInfo couponStatusInfo = new CouponStatusInfo();
        com.kwad.sdk.core.d.c.d("WebCardUpdateCouponStatusHandler", "couponStatusInfo 1 =" + couponStatusInfo.toJson().toString());
        try {
            com.kwad.sdk.core.d.c.d("WebCardUpdateCouponStatusHandler", "couponStatusInfo data=" + str);
            couponStatusInfo.parseJson(new JSONObject(str));
            com.kwad.sdk.core.d.c.d("WebCardUpdateCouponStatusHandler", "couponStatusInfo 2 =" + couponStatusInfo.toJson().toString());
        } catch (JSONException e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
        if (couponStatusInfo.statusCode == -1) {
            com.kwad.sdk.core.d.c.d("WebCardUpdateCouponStatusHandler", "couponStatusInfo return data=" + str);
        } else {
            this.aeI.post(new bh() { // from class: com.kwad.components.ct.coupon.bridge.f.1
                @Override // com.kwad.sdk.utils.bh
                public final void doTask() {
                    if (f.this.anl != null) {
                        f.this.anl.a(couponStatusInfo);
                    }
                }
            });
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.anl = null;
        this.aeI.removeCallbacksAndMessages(null);
    }
}
