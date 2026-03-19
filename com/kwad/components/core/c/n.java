package com.kwad.components.core.c;

import com.kwad.sdk.core.response.model.AdResultData;
import com.sigmob.sdk.base.mta.PointCategory;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class n implements c {
    @Override // com.kwad.components.core.c.c
    public final String getName() {
        return "StrategyNetworkOnlyFetcher";
    }

    @Override // com.kwad.components.core.c.c
    public final void d(com.kwad.components.core.request.model.a aVar) {
        a(aVar, new j(aVar));
    }

    public static void a(final com.kwad.components.core.request.model.a aVar, j jVar) {
        new com.kwad.components.core.o.a(aVar.Tk) { // from class: com.kwad.components.core.c.n.1
            @Override // com.kwad.components.core.o.a, com.kwad.sdk.core.network.a
            /* renamed from: oC */
            public final com.kwad.components.core.request.a createRequest() {
                if (aVar.getAdStyle() == 4) {
                    com.kwad.components.ad.b.i iVar = (com.kwad.components.ad.b.i) com.kwad.sdk.components.d.g(com.kwad.components.ad.b.i.class);
                    aVar.YQ = iVar.W();
                }
                return new com.kwad.components.core.request.a(aVar);
            }

            @Override // com.kwad.components.core.o.a, com.kwad.sdk.core.network.l
            /* renamed from: ak, reason: merged with bridge method [inline-methods] */
            public final AdResultData parseData(String str) {
                AdResultData adResultDataCreateFromResponseJson = AdResultData.createFromResponseJson(str, aVar.Tk.adScene);
                adResultDataCreateFromResponseJson.setAdSource(PointCategory.NETWORK);
                return adResultDataCreateFromResponseJson;
            }
        }.request(jVar);
    }
}
