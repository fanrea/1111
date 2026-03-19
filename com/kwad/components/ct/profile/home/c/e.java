package com.kwad.components.ct.profile.home.c;

import com.kwad.sdk.internal.api.SceneImpl;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class e extends com.kwad.components.ct.profile.home.b.a {
    private long aFZ;
    private String aGa;
    private com.kwad.components.core.widget.a.b amL;
    private boolean amM;
    private com.kwad.sdk.core.j.c gZ = new com.kwad.sdk.core.j.c() { // from class: com.kwad.components.ct.profile.home.c.e.1
        @Override // com.kwad.sdk.core.j.c
        public final void by() {
            if (e.this.amM) {
                com.kwad.components.ct.e.b.JK().g(e.this.mSceneImpl);
            } else {
                e.a(e.this, true);
                com.kwad.components.ct.e.b.JK().f(e.this.mSceneImpl);
            }
            e.this.aFZ = System.currentTimeMillis();
        }

        @Override // com.kwad.sdk.core.j.c
        public final void bz() {
            if (e.this.aFZ > 0) {
                com.kwad.components.ct.e.b.JK().a(e.this.mSceneImpl, System.currentTimeMillis() - e.this.aFZ);
                e.this.aFZ = 0L;
            }
        }
    };
    private SceneImpl mSceneImpl;

    static /* synthetic */ boolean a(e eVar, boolean z) {
        eVar.amM = true;
        return true;
    }

    @Override // com.kwad.components.ct.profile.home.b.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        com.kwad.components.core.widget.a.b bVar = this.aRf.aFs;
        this.amL = bVar;
        if (bVar == null) {
            return;
        }
        bVar.a(this.gZ);
        this.mSceneImpl = this.aRf.mSceneImpl;
        this.aGa = String.valueOf(this.aRf.aRh.hashCode());
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
