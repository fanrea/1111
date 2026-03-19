package com.kwad.components.ct.feed.home.c;

import com.kwad.sdk.internal.api.SceneImpl;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c extends com.kwad.components.ct.feed.home.b.a {
    private long aFZ;
    private String aGa;
    private com.kwad.components.core.widget.a.b amL;
    private boolean amM;
    private com.kwad.sdk.core.j.c gZ = new com.kwad.sdk.core.j.c() { // from class: com.kwad.components.ct.feed.home.c.c.1
        @Override // com.kwad.sdk.core.j.c
        public final void by() {
            if (c.this.amM) {
                com.kwad.components.ct.e.b.JK().g(c.this.mSceneImpl);
            } else {
                c.a(c.this, true);
                com.kwad.components.ct.e.b.JK().f(c.this.mSceneImpl);
            }
            c.this.aFZ = System.currentTimeMillis();
        }

        @Override // com.kwad.sdk.core.j.c
        public final void bz() {
            if (c.this.aFZ > 0) {
                com.kwad.components.ct.e.b.JK().a(c.this.mSceneImpl, System.currentTimeMillis() - c.this.aFZ);
                c.this.aFZ = 0L;
            }
        }
    };
    private SceneImpl mSceneImpl;

    static /* synthetic */ boolean a(c cVar, boolean z) {
        cVar.amM = true;
        return true;
    }

    @Override // com.kwad.components.ct.feed.home.b.a, com.kwad.sdk.lib.a.a.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        com.kwad.components.core.widget.a.b bVar = this.aFr.aFs;
        this.amL = bVar;
        if (bVar == null) {
            return;
        }
        bVar.a(this.gZ);
        this.mSceneImpl = this.aFr.mSceneImpl;
        this.aGa = String.valueOf(this.aFr.aGE.hashCode());
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
