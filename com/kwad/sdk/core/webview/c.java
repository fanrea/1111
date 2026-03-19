package com.kwad.sdk.core.webview;

import com.kwad.sdk.core.webview.a.c;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class c {
    private long bLF;
    private boolean bLG;

    public final void a(c.a aVar) {
        if (aVar != null) {
            com.kwad.sdk.core.adlog.c.a(aVar.getAdTemplate(), aVar.pz());
        }
        if (aVar != null) {
            this.bLF = System.currentTimeMillis();
        }
    }

    public final void b(c.a aVar) {
        if (aVar != null) {
            com.kwad.sdk.core.adlog.c.l(aVar.getAdTemplate(), System.currentTimeMillis() - this.bLF);
        }
    }

    public final void c(c.a aVar) {
        if (aVar == null || this.bLG) {
            return;
        }
        this.bLG = true;
        long jCurrentTimeMillis = 0;
        if (this.bLF > 0) {
            jCurrentTimeMillis = System.currentTimeMillis() - this.bLF;
            this.bLF = -1L;
        }
        com.kwad.sdk.core.adlog.c.a(aVar.getAdTemplate(), aVar.pz(), jCurrentTimeMillis);
    }

    public static void d(c.a aVar) {
        if (aVar != null) {
            com.kwad.sdk.core.adlog.c.b(aVar.getAdTemplate(), aVar.pz());
        }
    }
}
