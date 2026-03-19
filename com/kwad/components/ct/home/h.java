package com.kwad.components.ct.home;

import com.kwad.components.ct.detail.e.a;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class h {
    private final a.InterfaceC0507a aGT = new a.InterfaceC0507a() { // from class: com.kwad.components.ct.home.h.1
        @Override // com.kwad.components.ct.detail.e.a.InterfaceC0507a
        public final boolean yM() {
            return h.this.aps;
        }
    };
    private com.kwad.components.ct.detail.e.a aoz;
    private boolean aps;

    public final void pause() {
        this.aps = true;
        com.kwad.components.ct.detail.e.a aVar = this.aoz;
        if (aVar != null) {
            aVar.pause();
        }
    }

    public final void resume() {
        this.aps = false;
        com.kwad.components.ct.detail.e.a aVar = this.aoz;
        if (aVar != null) {
            aVar.bC(true);
        }
    }

    public final void Fm() {
        this.aps = false;
    }

    public final void r(com.kwad.components.ct.detail.e.a aVar) {
        this.aoz = aVar;
        aVar.a(this.aGT);
    }

    public final void s(com.kwad.components.ct.detail.e.a aVar) {
        aVar.b(this.aGT);
    }
}
