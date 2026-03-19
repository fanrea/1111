package com.kwad.sdk.glide.load.engine;

import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
final class p {
    private final Map<com.kwad.sdk.glide.load.c, j<?>> bUh = new HashMap();
    private final Map<com.kwad.sdk.glide.load.c, j<?>> bUi = new HashMap();

    p() {
    }

    final j<?> c(com.kwad.sdk.glide.load.c cVar, boolean z) {
        return cR(z).get(cVar);
    }

    final void a(com.kwad.sdk.glide.load.c cVar, j<?> jVar) {
        cR(jVar.agH()).put(cVar, jVar);
    }

    final void b(com.kwad.sdk.glide.load.c cVar, j<?> jVar) {
        Map<com.kwad.sdk.glide.load.c, j<?>> mapCR = cR(jVar.agH());
        if (jVar.equals(mapCR.get(cVar))) {
            mapCR.remove(cVar);
        }
    }

    private Map<com.kwad.sdk.glide.load.c, j<?>> cR(boolean z) {
        return z ? this.bUi : this.bUh;
    }
}
