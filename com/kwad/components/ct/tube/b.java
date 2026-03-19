package com.kwad.components.ct.tube;

import com.kwad.components.ct.api.tube.TubeEpisodeHomeParam;
import com.kwad.components.ct.d;
import com.kwad.components.ct.home.i;
import com.kwad.sdk.internal.api.SceneImpl;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends d {
    public c aVt;
    private final TubeEpisodeHomeParam aVu;

    public b(TubeEpisodeHomeParam tubeEpisodeHomeParam, c cVar) {
        super(new SceneImpl(tubeEpisodeHomeParam.mEntryScene));
        this.aVu = tubeEpisodeHomeParam;
        this.aVt = cVar;
    }

    @Override // com.kwad.components.ct.d
    public final i wX() {
        return com.kwad.components.ct.tube.slide.b.a(this.aVu);
    }

    public final void playSelectPage(int i) {
        c cVar;
        i iVar;
        if (this.alL == null || (cVar = this.aVt) == null || cVar.Kd() || (iVar = this.alL.get()) == null) {
            return;
        }
        ((com.kwad.components.ct.tube.slide.b) iVar).playSelectPage(i);
    }
}
