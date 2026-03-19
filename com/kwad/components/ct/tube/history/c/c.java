package com.kwad.components.ct.tube.history.c;

import com.kwad.components.ct.response.model.tube.TubeInfo;
import com.kwad.components.ct.widget.KSPageLoadingView;
import com.kwad.sdk.R;
import com.kwad.sdk.lib.b.g;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.ao;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c extends com.kwad.components.ct.tube.history.b.a {
    private com.kwad.sdk.lib.widget.a.c<TubeInfo, ?> aFU;
    private com.kwad.sdk.lib.widget.a.d aFW;
    private KSPageLoadingView aFX;
    private com.kwad.components.ct.tube.view.a aWi;
    private com.kwad.components.core.widget.a.b amL;
    private com.kwad.sdk.lib.b.c<?, TubeInfo> avY;
    private final KSPageLoadingView.a asf = new KSPageLoadingView.a() { // from class: com.kwad.components.ct.tube.history.c.c.1
        @Override // com.kwad.components.ct.widget.KSPageLoadingView.a
        public final void zP() {
            if (c.this.avY != null) {
                c.this.avY.refresh();
            }
        }
    };
    private final com.kwad.sdk.lib.b.f awa = new g() { // from class: com.kwad.components.ct.tube.history.c.c.2
        @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
        public final void m(boolean z, boolean z2) {
            if (z) {
                if (c.this.aFU.isEmpty()) {
                    c.this.aFX.Fi();
                    return;
                }
                return;
            }
            c.this.aWi.Cu();
        }

        @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
        public final void n(boolean z, boolean z2) {
            c.this.aFX.hide();
            if (z) {
                if (c.this.aFU.isEmpty()) {
                    c.this.aFX.cd(c.this.amL.wO());
                } else if (!c.this.aFW.ad(c.this.aWi)) {
                    c.this.aFW.addFooterView(c.this.aWi);
                }
            }
            c.this.aWi.ce(c.this.avY.Gx());
        }

        @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
        public final void a(boolean z, int i, String str) {
            c.this.aFX.hide();
            if (z) {
                if (c.this.aFU.isEmpty()) {
                    if (com.kwad.sdk.core.network.e.bCI.errorCode == i) {
                        c.this.aFX.Lg();
                    } else if (ao.isNetworkConnected(c.this.aFX.getContext())) {
                        c.this.aFX.cd(c.this.amL.wO());
                    } else {
                        c.this.aFX.cc(c.this.amL.wO());
                    }
                }
            } else if (com.kwad.sdk.core.network.e.bCw.errorCode == i) {
                ac.dm(c.this.getContext());
            } else if (com.kwad.sdk.core.network.e.bCI.errorCode == i) {
                ac.m462do(c.this.getContext());
            } else {
                ac.dn(c.this.getContext());
            }
            c.this.aWi.ce(c.this.avY.Gx());
        }
    };

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.aFX = (KSPageLoadingView) findViewById(R.id.ksad_page_loading);
        this.aWi = new com.kwad.components.ct.tube.view.a(getContext(), com.kwad.components.ct.f.d.Kb().wR() != 1, getContext().getString(R.string.ksad_tube_no_more_tip));
    }

    @Override // com.kwad.components.ct.tube.history.b.a, com.kwad.sdk.lib.a.a.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.amL = this.aWQ.aFs;
        this.avY = this.aWQ.avY;
        this.aFU = this.aWQ.aFU;
        this.aFW = this.aWQ.aFW;
        this.avY.a(this.awa);
        this.aFX.setRetryClickListener(this.asf);
        this.aFX.setScene(this.aWQ.mSceneImpl);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.avY.b(this.awa);
        this.aFX.setRetryClickListener(null);
    }
}
