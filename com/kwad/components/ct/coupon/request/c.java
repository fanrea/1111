package com.kwad.components.ct.coupon.request;

import android.os.Handler;
import android.os.Looper;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.utils.bh;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c {
    private static final Handler mHandler = new Handler(Looper.getMainLooper());

    public interface a {
        void a(CouponStatusResponse couponStatusResponse);

        void by(int i);

        void xK();
    }

    public final void a(final b bVar, final a aVar) {
        new l<com.kwad.components.ct.coupon.request.a, CouponStatusResponse>() { // from class: com.kwad.components.ct.coupon.request.c.1
            @Override // com.kwad.sdk.core.network.l
            public final /* synthetic */ BaseResultData parseData(String str) {
                return bw(str);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            /* renamed from: ya, reason: merged with bridge method [inline-methods] */
            public com.kwad.components.ct.coupon.request.a createRequest() {
                return new com.kwad.components.ct.coupon.request.a(bVar);
            }

            private static CouponStatusResponse bw(String str) {
                JSONObject jSONObject = new JSONObject(str);
                CouponStatusResponse couponStatusResponse = new CouponStatusResponse();
                couponStatusResponse.parseJson(jSONObject);
                return couponStatusResponse;
            }
        }.request(new o<com.kwad.components.ct.coupon.request.a, CouponStatusResponse>() { // from class: com.kwad.components.ct.coupon.request.c.2
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onError(f fVar, int i, String str) {
                r(i, str);
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(f fVar, BaseResultData baseResultData) {
                b((CouponStatusResponse) baseResultData);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onStartRequest(com.kwad.components.ct.coupon.request.a aVar2) {
                super.onStartRequest(aVar2);
                c.mHandler.post(new bh() { // from class: com.kwad.components.ct.coupon.request.c.2.1
                    @Override // com.kwad.sdk.utils.bh
                    public final void doTask() {
                        aVar.xK();
                    }
                });
            }

            private void b(final CouponStatusResponse couponStatusResponse) {
                c.mHandler.post(new bh() { // from class: com.kwad.components.ct.coupon.request.c.2.2
                    @Override // com.kwad.sdk.utils.bh
                    public final void doTask() {
                        aVar.a(couponStatusResponse);
                        com.kwad.sdk.core.d.c.d("RequestCouponStatusManager", "onSuccess " + couponStatusResponse.toJson().toString());
                    }
                });
            }

            private void r(final int i, final String str) {
                c.mHandler.post(new bh() { // from class: com.kwad.components.ct.coupon.request.c.2.3
                    @Override // com.kwad.sdk.utils.bh
                    public final void doTask() {
                        com.kwad.sdk.core.d.c.d("RequestCouponStatusManager", "load onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i), str));
                        aVar.by(i);
                    }
                });
            }
        });
    }
}
