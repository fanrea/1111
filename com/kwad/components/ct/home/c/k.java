package com.kwad.components.ct.home.c;

import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.internal.api.SceneImpl;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class k extends com.kwad.components.ct.home.e {
    private String aGa;
    private com.kwad.sdk.core.j.c aKm;
    private KsFragment aKn;
    com.kwad.components.core.widget.a.b aKo;
    private long aKp;
    private boolean amM;
    private SceneImpl mAdScene;

    static /* synthetic */ boolean a(k kVar, boolean z) {
        kVar.amM = true;
        return true;
    }

    @Override // com.kwad.components.ct.home.e, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        com.kwad.components.ct.home.j jVar = this.aGP.aol;
        if (jVar == null) {
            return;
        }
        com.kwad.components.core.widget.a.b bVar = jVar.aFs;
        this.aKo = bVar;
        if (bVar == null) {
            return;
        }
        this.mAdScene = this.aGP.mSceneImpl;
        com.kwad.components.core.proxy.h hVar = this.aGP.aGE;
        this.aKn = hVar;
        this.aGa = String.valueOf(hVar.hashCode());
        if (this.aKm == null) {
            com.kwad.sdk.core.j.c cVar = new com.kwad.sdk.core.j.c() { // from class: com.kwad.components.ct.home.c.k.1
                @Override // com.kwad.sdk.core.j.c
                public final void by() {
                    if (k.this.amM) {
                        com.kwad.components.ct.e.b.JK().b(k.this.mAdScene, k.this.aGP.aGS);
                    } else {
                        k.a(k.this, true);
                        com.kwad.components.ct.e.b.JK().a(k.this.mAdScene, k.this.aGP.aGS);
                    }
                    k.this.aKp = System.currentTimeMillis();
                }

                @Override // com.kwad.sdk.core.j.c
                public final void bz() {
                    if (k.this.mAdScene == null || k.this.aKn == null || k.this.aKp <= 0) {
                        return;
                    }
                    com.kwad.components.ct.e.b.JK().a(k.this.mAdScene, System.currentTimeMillis() - k.this.aKp, k.this.aGP.aGS);
                    k.this.aKp = 0L;
                }
            };
            this.aKm = cVar;
            this.aKo.a(cVar);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        com.kwad.components.core.widget.a.b bVar;
        super.onUnbind();
        com.kwad.sdk.core.j.c cVar = this.aKm;
        if (cVar == null || (bVar = this.aKo) == null) {
            return;
        }
        bVar.b(cVar);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        com.kwad.sdk.core.scene.b.abP().fS(this.aGa);
    }
}
