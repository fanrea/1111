package com.kwad.sdk.lib.a.b;

import com.kwad.sdk.lib.a.a.b;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class c<MODEL, CallerContext extends com.kwad.sdk.lib.a.a.b<?, MODEL>> extends com.kwad.sdk.lib.a.a.a<MODEL, CallerContext> {
    private com.kwad.sdk.lib.b.c<?, MODEL> avY;

    @Override // com.kwad.sdk.lib.a.a.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        com.kwad.sdk.lib.b.c<?, MODEL> cVar = (com.kwad.sdk.lib.b.c<?, MODEL>) this.cck.avY;
        this.avY = cVar;
        cVar.refresh();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.avY.release();
    }
}
