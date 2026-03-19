package com.kwad.components.ct.home.c;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c extends com.kwad.components.ct.home.e {
    @Override // com.kwad.components.ct.home.e, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        com.kwad.components.ct.api.b bVar = (com.kwad.components.ct.api.b) com.kwad.sdk.components.d.g(com.kwad.components.ct.api.b.class);
        com.kwad.components.ct.response.model.cached.a aVarWY = bVar != null ? bVar.wY() : null;
        if (aVarWY == null) {
            return;
        }
        com.kwad.components.ct.home.b.g.F(aVarWY.p(this.aGP.mSceneImpl));
        bVar.wZ();
        this.aGP.aok.setInitStartPosition(this.aGP.aGI);
    }
}
