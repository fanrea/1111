package com.kwad.components.ct.tube.panel.c;

import com.kwad.sdk.internal.api.SceneImpl;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c extends com.kwad.components.ct.tube.panel.b.a {
    private String aGa;
    private com.kwad.components.core.widget.a.b amL;
    private boolean amM;
    private final com.kwad.sdk.core.j.c gZ = new com.kwad.sdk.core.j.c() { // from class: com.kwad.components.ct.tube.panel.c.c.1
        @Override // com.kwad.sdk.core.j.c
        public final void bz() {
        }

        @Override // com.kwad.sdk.core.j.c
        public final void by() {
            if (c.this.amM) {
                return;
            }
            c.a(c.this, true);
            com.kwad.components.ct.e.b.JK().a(c.this.mSceneImpl, c.this.aXj.aXQ.mTubeEpisode);
        }
    };
    private SceneImpl mSceneImpl;

    static /* synthetic */ boolean a(c cVar, boolean z) {
        cVar.amM = true;
        return true;
    }

    @Override // com.kwad.components.ct.tube.panel.b.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        com.kwad.components.core.widget.a.b bVar = this.aXj.aFs;
        this.amL = bVar;
        if (bVar == null) {
            return;
        }
        bVar.a(this.gZ);
        this.mSceneImpl = this.aXj.mSceneImpl;
        this.aGa = String.valueOf(this.aXj.alG.hashCode());
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
