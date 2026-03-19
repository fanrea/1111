package com.kwad.components.ad.reward.m;

import com.kwad.components.ad.reward.g;
import com.kwad.components.core.video.o;
import com.kwad.sdk.utils.i;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class e {
    private com.kwad.components.ad.reward.f.a Dh;
    private d Di;
    private b Dj;
    private com.kwad.components.ad.k.a Dk;
    private g vb;
    private int Dg = 0;
    private int Dl = 0;
    private List<o> Dm = new CopyOnWriteArrayList();

    public e(g gVar) {
        this.vb = gVar;
        this.Dk = new a(gVar.mAdTemplate);
    }

    public final void a(int i, com.kwad.components.ad.k.a aVar) {
        this.Dg = i;
        if (i == 1) {
            this.Di = (d) aVar;
        } else if (i == 2) {
            this.Dh = (com.kwad.components.ad.reward.f.a) aVar;
        } else if (i == 3) {
            this.Dj = (b) aVar;
        }
        this.Dk = aVar;
        Iterator<o> it = this.Dm.iterator();
        while (it.hasNext()) {
            this.Dk.b(it.next());
        }
        this.Dm.clear();
    }

    private com.kwad.components.ad.k.a kZ() {
        return this.Dk;
    }

    public final boolean la() {
        return this.Dh != null;
    }

    public final void a(o oVar) {
        if (kZ().kV()) {
            this.Dm.add(oVar);
        } else {
            kZ().b(oVar);
        }
    }

    public final void b(o oVar) {
        kZ().a(oVar);
        if (oVar != null) {
            this.Dm.remove(oVar);
        }
    }

    public final void kX() {
        d dVar = this.Di;
        if (dVar != null) {
            dVar.kX();
        }
    }

    public final void a(i.a aVar) {
        d dVar = this.Di;
        if (dVar != null) {
            dVar.a(aVar);
        }
    }

    public final void b(i.a aVar) {
        d dVar = this.Di;
        if (dVar != null) {
            dVar.b(aVar);
        }
    }

    public final com.kwad.components.ad.reward.f.a lb() {
        return this.Dh;
    }

    public final b lc() {
        return this.Dj;
    }

    public final void kW() {
        d dVar = this.Di;
        if (dVar != null) {
            dVar.kW();
        } else {
            b bVar = this.Dj;
            if (bVar != null) {
                bVar.kW();
            }
        }
        this.vb.gL();
    }

    public final long getPlayDuration() {
        return kZ().getPlayDuration();
    }

    public final void skipToEnd() {
        kZ().skipToEnd();
    }

    public final void setAudioEnabled(boolean z, boolean z2) {
        this.Dl = z ? 2 : 1;
        kZ().setAudioEnabled(z, z2);
    }

    public final void resume() {
        int i;
        kZ().resume();
        com.kwad.components.ad.reward.f.a aVar = this.Dh;
        if (aVar == null || (i = this.Dl) <= 0) {
            return;
        }
        aVar.setAudioEnabled(i == 2, false);
    }

    public final void pause() {
        kZ().pause();
    }

    public final void release() {
        kZ().release();
    }
}
