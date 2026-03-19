package com.kwad.components.ct.response.a;

import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.b.g;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.PhotoInfo;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b implements g {
    @Override // com.kwad.sdk.core.response.b.g
    public final String be(AdTemplate adTemplate) {
        CtAdTemplate ctAdTemplateBa = ba(adTemplate);
        if (a.as(ctAdTemplateBa)) {
            return c.b(a.ay(ctAdTemplateBa));
        }
        return com.kwad.sdk.core.response.b.a.Z(e.eP(ctAdTemplateBa));
    }

    @Override // com.kwad.sdk.core.response.b.g
    public final String bf(AdTemplate adTemplate) {
        CtAdTemplate ctAdTemplateBa = ba(adTemplate);
        if (e.eH(ctAdTemplateBa)) {
            return com.kwad.sdk.core.response.b.a.cC(e.eP(ctAdTemplateBa));
        }
        if (a.at(ctAdTemplateBa)) {
            return d.p(a.az(ctAdTemplateBa));
        }
        return c.l(a.ay(ctAdTemplateBa));
    }

    @Override // com.kwad.sdk.core.response.b.g
    public final long bg(AdTemplate adTemplate) {
        CtAdTemplate ctAdTemplateBa = ba(adTemplate);
        if (a.as(ctAdTemplateBa)) {
            return c.j((PhotoInfo) a.ay(ctAdTemplateBa));
        }
        if (e.eH(ctAdTemplateBa)) {
            return com.kwad.sdk.core.response.b.a.ad(e.eP(ctAdTemplateBa));
        }
        if (a.at(ctAdTemplateBa)) {
            return d.a(a.az(ctAdTemplateBa));
        }
        return ctAdTemplateBa.hashCode();
    }

    @Override // com.kwad.sdk.core.response.b.g
    public final int bh(AdTemplate adTemplate) {
        CtAdTemplate ctAdTemplateBa = ba(adTemplate);
        if (a.as(ctAdTemplateBa)) {
            return c.k((PhotoInfo) a.ay(ctAdTemplateBa));
        }
        if (a.at(ctAdTemplateBa)) {
            return d.b(a.az(ctAdTemplateBa));
        }
        return 0;
    }

    private static CtAdTemplate ba(AdTemplate adTemplate) {
        return a.ba(adTemplate);
    }
}
