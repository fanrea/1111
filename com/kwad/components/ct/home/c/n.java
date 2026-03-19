package com.kwad.components.ct.home.c;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class n extends com.kwad.components.ct.home.e implements com.kwad.sdk.core.j.c {
    private com.kwad.components.core.widget.a.b amL;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.components.ct.home.e, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        com.kwad.components.ct.home.j jVar = this.aGP.aol;
        if (jVar != null) {
            this.amL = jVar.aFs;
        }
        this.amL.a(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.amL.b(this);
        com.kwad.components.core.r.d.sT().g(this.aGP.aGE);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        com.kwad.components.core.r.d.sT().g(this.aGP.aGE);
    }

    @Override // com.kwad.sdk.core.j.c
    public final void by() {
        com.kwad.components.core.r.d.sT().f(this.aGP.aGE);
    }

    @Override // com.kwad.sdk.core.j.c
    public final void bz() {
        com.kwad.components.core.r.d.sT().g(this.aGP.aGE);
    }
}
