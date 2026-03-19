package com.kwad.sdk.collector;

import android.content.Context;
import com.kwad.sdk.collector.d;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.utils.bs;
import com.kwad.sdk.utils.s;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class c {

    public interface a {
        void H(int i, String str);

        void b(AppStatusRules appStatusRules);
    }

    public static void a(final Context context, final a aVar) {
        if (context == null) {
            return;
        }
        d.a(context, new d.a() { // from class: com.kwad.sdk.collector.c.1
            @Override // com.kwad.sdk.collector.d.a
            public final void onLoaded() {
                c.b(context, aVar);
            }

            @Override // com.kwad.sdk.collector.d.a
            public final void dS(String str) {
                com.kwad.sdk.core.d.c.e("AppStatusFetchConfigManager", "onLoadError: " + str);
            }
        });
    }

    public static void b(final Context context, final a aVar) {
        new l<com.kwad.sdk.collector.a.a, AppStatusRules>() { // from class: com.kwad.sdk.collector.c.2
            @Override // com.kwad.sdk.core.network.l
            public final /* synthetic */ BaseResultData parseData(String str) {
                return dT(str);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            /* renamed from: Wn, reason: merged with bridge method [inline-methods] */
            public com.kwad.sdk.collector.a.a createRequest() {
                if (!s.aob()) {
                    return new com.kwad.sdk.collector.a.a(null);
                }
                return new com.kwad.sdk.collector.a.a(bs.eU(context));
            }

            private static AppStatusRules dT(String str) {
                return AppStatusRules.createFromJson(str);
            }
        }.request(new o<com.kwad.sdk.collector.a.a, AppStatusRules>() { // from class: com.kwad.sdk.collector.c.3
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(com.kwad.sdk.core.network.f fVar, BaseResultData baseResultData) {
                a((AppStatusRules) baseResultData);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onStartRequest(com.kwad.sdk.collector.a.a aVar2) {
                super.onStartRequest(aVar2);
            }

            private void a(AppStatusRules appStatusRules) {
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.b(appStatusRules);
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onError(com.kwad.sdk.collector.a.a aVar2, int i, String str) {
                super.onError(aVar2, i, str);
                a aVar3 = aVar;
                if (aVar3 != null) {
                    aVar3.H(i, str);
                }
            }
        });
    }
}
