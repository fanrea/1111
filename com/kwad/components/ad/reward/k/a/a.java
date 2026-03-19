package com.kwad.components.ad.reward.k.a;

import com.kwad.components.ad.reward.g;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends com.kwad.components.core.webview.tachikoma.d.b {
    private g CD;

    public a(g gVar) {
        this.CD = gVar;
    }

    public final void b(com.kwad.components.ad.reward.c.b bVar) {
        com.kwad.components.ad.reward.c.a.hZ().a(this.mAdTemplate, bVar);
    }

    public final g kw() {
        return this.CD;
    }

    @Override // com.kwad.components.core.webview.tachikoma.d.b, com.kwad.sdk.mvp.a
    public final void release() {
        super.release();
        this.CD = null;
    }
}
