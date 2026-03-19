package com.kwad.components.ct.tube.channel.detail.c;

import android.os.SystemClock;
import com.kwad.sdk.internal.api.SceneImpl;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class d extends com.kwad.components.ct.tube.channel.detail.b.a {
    private long aFZ;
    private String aGa;
    private com.kwad.components.core.widget.a.b amL;
    private boolean amM;
    private final com.kwad.sdk.core.j.c gZ = new com.kwad.sdk.core.j.c() { // from class: com.kwad.components.ct.tube.channel.detail.c.d.1
        @Override // com.kwad.sdk.core.j.c
        public final void by() {
            if (d.this.amM) {
                com.kwad.components.ct.e.b.JK().g(d.this.mSceneImpl);
            } else {
                d.a(d.this, true);
                com.kwad.components.ct.e.b.JK().f(d.this.mSceneImpl);
            }
            d.this.aFZ = SystemClock.elapsedRealtime();
        }

        @Override // com.kwad.sdk.core.j.c
        public final void bz() {
            if (d.this.aFZ > 0) {
                com.kwad.components.ct.e.b.JK().a(d.this.mSceneImpl, SystemClock.elapsedRealtime() - d.this.aFZ);
                d.this.aFZ = 0L;
            }
        }
    };
    private SceneImpl mSceneImpl;

    static /* synthetic */ boolean a(d dVar, boolean z) {
        dVar.amM = true;
        return true;
    }

    @Override // com.kwad.components.ct.tube.channel.detail.b.a, com.kwad.sdk.lib.a.a.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        com.kwad.components.core.widget.a.b bVar = this.aVW.aFs;
        this.amL = bVar;
        if (bVar == null) {
            return;
        }
        bVar.a(this.gZ);
        this.mSceneImpl = this.aVW.mSceneImpl;
        this.aGa = String.valueOf(this.aVW.aGE.hashCode());
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
