package com.kwad.components.ct.emotion.a;

import com.kwad.components.ct.emotion.model.EmotionResponse;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.model.BaseResultData;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class e {

    public interface a {
        void b(EmotionResponse emotionResponse);

        void zH();
    }

    public static void a(final a aVar) {
        new l<com.kwad.components.ct.emotion.a, EmotionResponse>() { // from class: com.kwad.components.ct.emotion.a.e.1
            @Override // com.kwad.sdk.core.network.l
            public final boolean isPostByJson() {
                return false;
            }

            @Override // com.kwad.sdk.core.network.a
            public final /* synthetic */ com.kwad.sdk.core.network.f createRequest() {
                return DI();
            }

            @Override // com.kwad.sdk.core.network.l
            public final /* synthetic */ BaseResultData parseData(String str) {
                return bG(str);
            }

            private static EmotionResponse bG(String str) {
                JSONObject jSONObject = new JSONObject(str);
                EmotionResponse emotionResponse = new EmotionResponse();
                emotionResponse.parseJson(jSONObject);
                return emotionResponse;
            }

            private static com.kwad.components.ct.emotion.a DI() {
                return new com.kwad.components.ct.emotion.a();
            }
        }.request(new o<com.kwad.components.ct.emotion.a, EmotionResponse>() { // from class: com.kwad.components.ct.emotion.a.e.2
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onStartRequest(com.kwad.components.ct.emotion.a aVar2) {
                super.onStartRequest(aVar2);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(com.kwad.components.ct.emotion.a aVar2, EmotionResponse emotionResponse) {
                super.onSuccess(aVar2, emotionResponse);
                a aVar3 = aVar;
                if (aVar3 != null) {
                    aVar3.b(emotionResponse);
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onError(com.kwad.components.ct.emotion.a aVar2, int i, String str) {
                super.onError(aVar2, i, str);
                a aVar3 = aVar;
                if (aVar3 != null) {
                    aVar3.zH();
                }
            }
        });
    }
}
