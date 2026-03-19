package com.kwad.components.core.u;

import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bh;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class b {
    private static volatile b aau;

    public static b tq() {
        if (aau == null) {
            synchronized (b.class) {
                if (aau == null) {
                    aau = new b();
                }
            }
        }
        return aau;
    }

    private b() {
    }

    public final boolean a(final AdTemplate adTemplate, JSONObject jSONObject, com.kwad.sdk.core.adlog.c.b bVar) {
        boolean z = false;
        if (((DevelopMangerComponents) com.kwad.sdk.components.d.g(DevelopMangerComponents.class)) != null) {
            com.kwad.sdk.core.d.c.d("AdEventHelper", "processAdImpress notImpression: false");
        }
        if (bVar != null) {
            bVar.b(adTemplate, null, null, null);
        }
        boolean zB = com.kwad.sdk.core.adlog.c.b(adTemplate, jSONObject, bVar);
        try {
            if (adTemplate.mAdScene != null && adTemplate.mAdScene.adStyle == 10000) {
                z = true;
            }
            if (adTemplate.adStyle == 3 || adTemplate.adStyle == 2 || adTemplate.adStyle == 13 || z) {
                com.kwad.sdk.core.response.b.e.eP(adTemplate);
                if (zB && com.kwad.sdk.components.d.g(com.kwad.components.core.p.a.c.a.class) != null) {
                    com.kwad.sdk.components.d.g(com.kwad.components.core.p.a.c.a.class);
                }
            }
        } catch (Throwable unused) {
        }
        com.kwad.sdk.utils.h.execute(new bh() { // from class: com.kwad.components.core.u.b.1
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                com.kwad.components.core.c.a aVarOh = com.kwad.components.core.c.a.oh();
                if (aVarOh != null) {
                    aVarOh.w(com.kwad.sdk.core.response.b.e.eV(adTemplate));
                }
            }
        });
        com.kwad.components.core.c.g.ou().aw(adTemplate);
        return zB;
    }
}
