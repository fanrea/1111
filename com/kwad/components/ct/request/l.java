package com.kwad.components.ct.request;

import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.ct.request.k;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.BaseResultData;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class l {
    public static <T extends AdResultData> void a(final k.a aVar, final com.kwad.components.core.request.l<T> lVar) {
        new com.kwad.sdk.core.network.l<k, T>() { // from class: com.kwad.components.ct.request.l.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            /* renamed from: EY, reason: merged with bridge method [inline-methods] */
            public k createRequest() {
                return new k(aVar);
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Incorrect return type in method signature: (Ljava/lang/String;)TT; */
            @Override // com.kwad.sdk.core.network.l
            /* renamed from: ak, reason: merged with bridge method [inline-methods] */
            public AdResultData parseData(String str) {
                JSONObject jSONObject = new JSONObject(str);
                ArrayList arrayList = new ArrayList();
                Iterator<ImpInfo> it = aVar.anZ.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().adScene);
                }
                AdResultData adResultDataSH = lVar.sH();
                adResultDataSH.setRequestAdSceneList(arrayList);
                adResultDataSH.parseJson(jSONObject);
                return adResultDataSH;
            }
        }.request(new com.kwad.sdk.core.network.o<k, T>() { // from class: com.kwad.components.ct.request.l.2
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onError(com.kwad.sdk.core.network.f fVar, int i, String str) {
                v(i, str);
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(com.kwad.sdk.core.network.f fVar, BaseResultData baseResultData) {
                r((AdResultData) baseResultData);
            }

            /* JADX WARN: Incorrect types in method signature: (TT;)V */
            private void r(AdResultData adResultData) {
                lVar.b(adResultData);
            }

            private void v(int i, String str) {
                lVar.onError(i, str);
            }
        });
    }
}
