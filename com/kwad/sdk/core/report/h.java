package com.kwad.sdk.core.report;

import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class h extends com.kwad.sdk.core.response.a.a {
    public int bEI;
    public long creativeId;
    public long llsid;
    public int score;
    public String source = "union";

    public static h cA(AdTemplate adTemplate) {
        h hVar = new h();
        hVar.creativeId = com.kwad.sdk.core.response.b.e.eV(adTemplate);
        hVar.llsid = com.kwad.sdk.core.response.b.e.eM(adTemplate);
        int iEZ = com.kwad.sdk.core.response.b.e.eZ(adTemplate);
        hVar.score = iEZ;
        hVar.bEI = iEZ > 0 ? 1 : 0;
        return hVar;
    }

    public final String abl() {
        return toJson().toString();
    }
}
