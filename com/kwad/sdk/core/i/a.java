package com.kwad.sdk.core.i;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class a {
    private static c bIi;
    private static c bIj;

    public static c r(boolean z, boolean z2) {
        c cVar;
        com.kwad.sdk.core.d.c.d("KSUserAgentManager", "obtainUAGetter useKwaiUA: " + z + ", unionUAMark: " + z2);
        if (z) {
            if (bIi == null) {
                bIi = new b();
            }
            cVar = bIi;
        } else {
            if (bIj == null) {
                bIj = new d();
            }
            cVar = bIj;
        }
        cVar.cA(z2);
        com.kwad.sdk.core.d.c.d("KSUserAgentManager", "obtainUAGetter result: " + cVar);
        return cVar;
    }
}
