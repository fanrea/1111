package com.kwad.components.ct.home.b;

import com.kwad.components.ct.response.model.CtAdTemplate;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class h implements com.kwad.components.ct.api.a.a.c<CtAdTemplate> {
    private com.kwad.components.ct.api.a.a.a aJw;
    private com.kwad.components.ct.api.a.a.a aJx;

    public h(com.kwad.components.ct.api.a.a.a aVar) {
        this.aJw = aVar;
        this.aJx = aVar;
    }

    @Override // com.kwad.components.ct.api.a.a.c
    public final void a(com.kwad.components.ct.api.a.a.b bVar) {
        this.aJx.a(bVar);
    }

    @Override // com.kwad.components.ct.api.a.a.c
    public final void b(com.kwad.components.ct.api.a.a.b bVar) {
        this.aJx.b(bVar);
    }

    @Override // com.kwad.components.ct.api.a.a.c
    public final com.kwad.components.ct.api.a.a.a xd() {
        return this.aJw;
    }

    @Override // com.kwad.components.ct.api.a.a.c
    public final boolean a(com.kwad.components.ct.api.a.a.a aVar) {
        com.kwad.components.ct.api.a.a.a aVar2 = this.aJx;
        if (aVar2 == aVar) {
            return false;
        }
        aVar2.release();
        this.aJx = aVar;
        return true;
    }

    @Override // com.kwad.components.ct.api.a.a.c
    public final List<CtAdTemplate> xc() {
        return this.aJx.xc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.components.ct.api.a.a.c
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void b(int i, CtAdTemplate ctAdTemplate) {
        this.aJw.a(i, ctAdTemplate);
    }

    @Override // com.kwad.components.ct.api.a.a.c
    public final void t(List<CtAdTemplate> list) {
        this.aJw.t(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.components.ct.api.a.a.c
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public int aX(CtAdTemplate ctAdTemplate) {
        return this.aJw.aW(ctAdTemplate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.components.ct.api.a.a.c
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public int aW(CtAdTemplate ctAdTemplate) {
        return this.aJx.aW(ctAdTemplate);
    }

    @Override // com.kwad.components.ct.api.a.a.c
    public final void refresh(int i) {
        this.aJx.refresh(i);
    }

    @Override // com.kwad.components.ct.api.a.a.c
    public final void a(com.kwad.sdk.o.a aVar) {
        com.kwad.components.ct.api.a.a.a aVar2 = this.aJx;
        if (aVar2 instanceof c) {
            c cVar = (c) aVar2;
            if (com.kwad.sdk.o.b.b(aVar)) {
                cVar.bT(aVar.getUrl());
                com.kwad.components.ct.e.b.JK().bY(aVar.getUrl());
            } else {
                if (!com.kwad.sdk.o.b.c(aVar)) {
                    return;
                }
                cVar.bU(aVar.getUrl());
                com.kwad.components.ct.e.b.JK().bZ(com.kwad.sdk.o.b.ih(aVar.getUrl()));
            }
            this.aJx.refresh(4);
        }
    }

    @Override // com.kwad.components.ct.api.a.a.c
    public final void bk(boolean z) {
        this.aJx.bk(z);
    }

    @Override // com.kwad.components.ct.api.a.a.c
    public final void release() {
        this.aJx.release();
    }
}
