package com.kwad.sdk.mobileid.a;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.mobileid.d;
import com.kwad.sdk.mobileid.model.CMTokenResponse;
import com.kwad.sdk.mobileid.model.UaidTokenResponse;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ag;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class a extends com.kwad.sdk.mobileid.b {
    private l<b, CMTokenResponse> aeV;
    private int retryCount = 0;
    private int bEq = 3;

    static /* synthetic */ int c(a aVar) {
        int i = aVar.retryCount;
        aVar.retryCount = i + 1;
        return i;
    }

    @Override // com.kwad.sdk.mobileid.b
    public final void cG(Context context) {
        b(context, false);
    }

    public final void b(final Context context, final boolean z) {
        d dVar;
        if (z) {
            dVar = new d(true, "uaidTokenCanRequestByWifi");
        } else {
            dVar = new d(true, "uaidTokenCanRequest");
        }
        com.kwad.sdk.mobileid.c.b(context, dVar);
        l<b, CMTokenResponse> lVar = new l<b, CMTokenResponse>() { // from class: com.kwad.sdk.mobileid.a.a.1
            @Override // com.kwad.sdk.core.network.a
            public final /* synthetic */ f createRequest() {
                return alU();
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.l
            /* renamed from: hO, reason: merged with bridge method [inline-methods] */
            public CMTokenResponse parseData(String str) {
                CMTokenResponse cMTokenResponse = new CMTokenResponse();
                cMTokenResponse.parseJson(new JSONObject(str));
                ag.ao(context, cMTokenResponse.getResultToken());
                com.kwad.sdk.mobileid.a.alL();
                com.kwad.sdk.mobileid.c.a(context, cMTokenResponse);
                return cMTokenResponse;
            }

            private static b alU() {
                return new b();
            }
        };
        this.aeV = lVar;
        lVar.request(new o<b, CMTokenResponse>() { // from class: com.kwad.sdk.mobileid.a.a.2
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onError(f fVar, int i, String str) {
                M(i, str);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(b bVar, CMTokenResponse cMTokenResponse) {
                d dVar2;
                super.onSuccess(bVar, cMTokenResponse);
                boolean z2 = !TextUtils.isEmpty(ag.dI(context));
                boolean z3 = a.this.retryCount < a.this.bEq;
                if (z2 && z3) {
                    a.c(a.this);
                    if (z) {
                        dVar2 = new d(true, "uaidTokenCanRequestByWifi");
                    } else {
                        dVar2 = new d(true, "uaidTokenCanRequest");
                    }
                    a.this.cH(context);
                } else if (!z2) {
                    dVar2 = new d(false, "noRequestUaidTokenEmpty");
                } else {
                    dVar2 = new d(false, "noRequestUaidRetry");
                }
                com.kwad.sdk.mobileid.c.c(context, dVar2);
            }

            private void M(int i, String str) {
                com.kwad.sdk.mobileid.c.b(context, i, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cH(final Context context) {
        new l<c, UaidTokenResponse>() { // from class: com.kwad.sdk.mobileid.a.a.3
            @Override // com.kwad.sdk.core.network.a
            public final /* synthetic */ f createRequest() {
                return alV();
            }

            private static c alV() {
                return new c();
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.l
            /* renamed from: hP, reason: merged with bridge method [inline-methods] */
            public UaidTokenResponse parseData(String str) {
                UaidTokenResponse uaidTokenResponse = new UaidTokenResponse();
                uaidTokenResponse.parseJson(new JSONObject(str));
                if (!TextUtils.isEmpty(uaidTokenResponse.uaid)) {
                    ag.an(ServiceProvider.anu(), uaidTokenResponse.uaid);
                    ag.f(ServiceProvider.anu(), System.currentTimeMillis());
                }
                ag.ao(ServiceProvider.anu(), "");
                com.kwad.sdk.mobileid.c.a(context, uaidTokenResponse);
                return uaidTokenResponse;
            }
        }.request(new o<c, UaidTokenResponse>() { // from class: com.kwad.sdk.mobileid.a.a.4
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onError(f fVar, int i, String str) {
                N(i, str);
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(f fVar, BaseResultData baseResultData) {
                alW();
            }

            private void N(int i, String str) {
                com.kwad.sdk.mobileid.a.alL();
                com.kwad.sdk.mobileid.c.c(context, i, str);
            }

            private static void alW() {
                com.kwad.sdk.mobileid.a.alL();
            }
        });
    }
}
