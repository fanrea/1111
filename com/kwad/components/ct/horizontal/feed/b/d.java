package com.kwad.components.ct.horizontal.feed.b;

import com.kwad.sdk.internal.api.SceneImpl;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class d extends com.kwad.components.ct.horizontal.feed.a.a {
    private long aFZ;
    private String aGa;
    private boolean aNi;
    private com.kwad.components.core.widget.a.b amL;
    private com.kwad.sdk.core.j.c gZ = new com.kwad.sdk.core.j.c() { // from class: com.kwad.components.ct.horizontal.feed.b.d.1
        @Override // com.kwad.sdk.core.j.c
        public final void by() {
            if (!d.this.aNi) {
                d.a(d.this, true);
                com.kwad.components.ct.e.b.JK().c(d.this.mSceneImpl, ((com.kwad.components.ct.horizontal.feed.a.b) d.this.cck).aLP ? 1 : 0);
            } else {
                com.kwad.components.ct.e.b.JK().d(d.this.mSceneImpl, ((com.kwad.components.ct.horizontal.feed.a.b) d.this.cck).aLP ? 1 : 0);
            }
            d.this.aFZ = System.currentTimeMillis();
        }

        @Override // com.kwad.sdk.core.j.c
        public final void bz() {
            if (d.this.aFZ > 0) {
                com.kwad.components.ct.e.b.JK().a(d.this.mSceneImpl, System.currentTimeMillis() - d.this.aFZ, ((com.kwad.components.ct.horizontal.feed.a.b) d.this.cck).aLP ? 1 : 0);
                d.this.aFZ = 0L;
            }
        }
    };
    private SceneImpl mSceneImpl;

    static /* synthetic */ boolean a(d dVar, boolean z) {
        dVar.aNi = true;
        return true;
    }

    @Override // com.kwad.components.ct.horizontal.feed.a.a, com.kwad.sdk.lib.a.a.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        com.kwad.components.core.widget.a.b bVar = ((com.kwad.components.ct.horizontal.feed.a.b) this.cck).aFs;
        this.amL = bVar;
        if (bVar == null) {
            return;
        }
        bVar.a(this.gZ);
        this.mSceneImpl = ((com.kwad.components.ct.horizontal.feed.a.b) this.cck).mSceneImpl;
        this.aGa = String.valueOf(((com.kwad.components.ct.horizontal.feed.a.b) this.cck).aGE.hashCode());
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.core.widget.a.b bVar = this.amL;
        if (bVar != null) {
            bVar.b(this.gZ);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        com.kwad.sdk.core.scene.b.abP().fS(this.aGa);
    }
}
