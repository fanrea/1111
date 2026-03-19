package com.kwad.components.ct.horizontal.news.c;

import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.components.ct.widget.KSPageLoadingView;
import com.kwad.sdk.utils.ac;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class g extends com.kwad.components.ct.horizontal.news.b.a {
    private com.kwad.sdk.lib.widget.a.c<CtAdTemplate, ?> aFU;
    private com.kwad.sdk.lib.widget.a.d aFW;
    private boolean aOx;
    private com.kwad.components.ct.widget.b avW;
    private com.kwad.sdk.lib.b.c<?, CtAdTemplate> avY;
    private final KSPageLoadingView.a asf = new KSPageLoadingView.a() { // from class: com.kwad.components.ct.horizontal.news.c.g.1
        @Override // com.kwad.components.ct.widget.KSPageLoadingView.a
        public final void zP() {
            if (g.this.avY != null) {
                g.this.avY.refresh();
            }
        }
    };
    private final com.kwad.sdk.lib.b.f awa = new com.kwad.sdk.lib.b.g() { // from class: com.kwad.components.ct.horizontal.news.c.g.2
        @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
        public final void m(boolean z, boolean z2) {
            if (g.this.aOx || z) {
                return;
            }
            g.this.avW.Cu();
        }

        @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
        public final void n(boolean z, boolean z2) {
            if (g.this.aOx) {
                return;
            }
            if (z && !g.this.aFU.isEmpty() && !g.this.aFW.ad(g.this.avW)) {
                g.this.aFW.addFooterView(g.this.avW);
            }
            g.this.avW.ce(g.this.avY.Gx());
        }

        @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
        public final void a(boolean z, int i, String str) {
            if (g.this.aOx) {
                return;
            }
            if (!z) {
                if (com.kwad.sdk.core.network.e.bCw.errorCode == i) {
                    ac.dm(g.this.getContext());
                } else if (com.kwad.sdk.core.network.e.bCI.errorCode != i) {
                    ac.dn(g.this.getContext());
                }
            }
            g.this.avW.ce(g.this.avY.Gx());
        }
    };
    private final com.kwad.components.ct.horizontal.news.f aNS = new com.kwad.components.ct.horizontal.news.f() { // from class: com.kwad.components.ct.horizontal.news.c.g.3
        @Override // com.kwad.components.ct.horizontal.news.f
        public final void HV() {
            g.this.aOx = false;
        }

        @Override // com.kwad.components.ct.horizontal.news.f
        public final void aN() {
            g.this.aOx = false;
        }

        @Override // com.kwad.components.ct.horizontal.news.f
        public final void HW() {
            g.this.aOx = true;
        }
    };

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.avW = new com.kwad.components.ct.widget.b(getContext(), true);
    }

    @Override // com.kwad.components.ct.horizontal.news.b.a, com.kwad.sdk.lib.a.a.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.avY = this.aNz.avY;
        this.aFU = this.aNz.aFU;
        this.aFW = this.aNz.aFW;
        this.aNz.aNL.add(this.asf);
        this.aNz.aNK.add(this.aNS);
        this.avY.a(this.awa);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.aNz.aNL.remove(this.asf);
        this.aNz.aNK.remove(this.aNS);
        this.avY.b(this.awa);
    }
}
