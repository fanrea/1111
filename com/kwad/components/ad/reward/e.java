package com.kwad.components.ad.reward;

import android.text.TextUtils;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.BaseResultData;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class e {
    /* synthetic */ e(byte b2) {
        this();
    }

    private e() {
    }

    static class a {
        private static e tq = new e(0);
    }

    public static e gD() {
        return a.tq;
    }

    public final void M(AdTemplate adTemplate) {
        com.kwad.sdk.core.d.c.d("RewardCallbackVerifyHelper", "handleRewardVerify");
        AdInfo adInfoEP = com.kwad.sdk.core.response.b.e.eP(adTemplate);
        if (!TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.cb(adInfoEP))) {
            N(adTemplate);
        } else {
            p.b(adTemplate, adInfoEP);
        }
    }

    private static void N(AdTemplate adTemplate) {
        new b(adTemplate).startRequest();
    }

    static class b extends com.kwad.sdk.core.network.l<f, BaseResultData> {
        private AdTemplate adTemplate;
        private com.kwad.sdk.core.network.o<f, BaseResultData> tr = new com.kwad.sdk.core.network.o<f, BaseResultData>() { // from class: com.kwad.components.ad.reward.e.b.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(f fVar, BaseResultData baseResultData) {
                super.onSuccess(fVar, baseResultData);
                com.kwad.components.core.q.a.ss().g(b.this.adTemplate, 0, "success");
                com.kwad.sdk.core.d.c.i("RewardCallbackVerifyHelper", "callbackUrlInfo verify success");
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onError(f fVar, int i, String str) {
                super.onError(fVar, i, str);
                com.kwad.components.core.q.a.ss().g(b.this.adTemplate, 1, str);
                com.kwad.sdk.core.d.c.i("RewardCallbackVerifyHelper", "callbackUrlInfo verify failed");
            }
        };

        public b(AdTemplate adTemplate) {
            this.adTemplate = adTemplate;
        }

        public final void startRequest() {
            request(this.tr);
        }

        @Override // com.kwad.sdk.core.network.l
        public final BaseResultData parseData(String str) {
            BaseResultData baseResultData = new BaseResultData() { // from class: com.kwad.components.ad.reward.RewardCallbackVerifyHelper$ServerCallbackNetworking$2
            };
            if (!TextUtils.isEmpty(str)) {
                try {
                    baseResultData.parseJson(new JSONObject(str));
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTrace(th);
                }
            }
            return baseResultData;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.kwad.sdk.core.network.a
        /* renamed from: gF, reason: merged with bridge method [inline-methods] */
        public f createRequest() {
            return new f(this.adTemplate);
        }
    }
}
