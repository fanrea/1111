package com.kwad.components.ct.request;

import android.os.Handler;
import android.os.Looper;
import com.kwad.components.ct.response.model.home.AuthorShieldResponse;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.utils.bh;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b {
    private static final Handler mHandler = new Handler(Looper.getMainLooper());
    private com.kwad.sdk.core.network.l<com.kwad.components.ct.request.a, AuthorShieldResponse> aeV;
    private boolean asX = false;

    public interface a {
        void Ah();

        void zH();
    }

    static /* synthetic */ boolean a(b bVar, boolean z) {
        bVar.asX = false;
        return false;
    }

    public final void a(final String str, final int i, final a aVar) {
        if (this.asX) {
            return;
        }
        this.asX = true;
        com.kwad.sdk.core.network.l<com.kwad.components.ct.request.a, AuthorShieldResponse> lVar = new com.kwad.sdk.core.network.l<com.kwad.components.ct.request.a, AuthorShieldResponse>() { // from class: com.kwad.components.ct.request.b.1
            @Override // com.kwad.sdk.core.network.l
            public final /* synthetic */ BaseResultData parseData(String str2) {
                return ca(str2);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            /* renamed from: JW, reason: merged with bridge method [inline-methods] */
            public com.kwad.components.ct.request.a createRequest() {
                return new com.kwad.components.ct.request.a(str, i);
            }

            private static AuthorShieldResponse ca(String str2) {
                JSONObject jSONObject = new JSONObject(str2);
                AuthorShieldResponse authorShieldResponse = new AuthorShieldResponse();
                authorShieldResponse.parseJson(jSONObject);
                return authorShieldResponse;
            }
        };
        this.aeV = lVar;
        lVar.request(new com.kwad.sdk.core.network.o<com.kwad.components.ct.request.a, AuthorShieldResponse>() { // from class: com.kwad.components.ct.request.b.2
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onError(com.kwad.sdk.core.network.f fVar, int i2, String str2) {
                A(i2, str2);
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(com.kwad.sdk.core.network.f fVar, BaseResultData baseResultData) {
                a((AuthorShieldResponse) baseResultData);
            }

            private void a(final AuthorShieldResponse authorShieldResponse) {
                b.mHandler.post(new bh() { // from class: com.kwad.components.ct.request.b.2.1
                    @Override // com.kwad.sdk.utils.bh
                    public final void doTask() {
                        aVar.Ah();
                        b.a(b.this, false);
                    }
                });
            }

            private void A(final int i2, final String str2) {
                b.mHandler.post(new bh() { // from class: com.kwad.components.ct.request.b.2.2
                    @Override // com.kwad.sdk.utils.bh
                    public final void doTask() {
                        aVar.zH();
                        b.a(b.this, false);
                    }
                });
            }
        });
    }

    public final void release() {
        com.kwad.sdk.core.network.l<com.kwad.components.ct.request.a, AuthorShieldResponse> lVar = this.aeV;
        if (lVar != null) {
            lVar.cancel();
        }
        mHandler.removeCallbacksAndMessages(null);
    }
}
