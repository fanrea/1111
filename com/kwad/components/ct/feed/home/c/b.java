package com.kwad.components.ct.feed.home.c;

import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.components.ct.widget.KSPageLoadingView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.network.e;
import com.kwad.sdk.lib.b.f;
import com.kwad.sdk.lib.b.g;
import com.kwad.sdk.lib.widget.a.d;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.ao;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends com.kwad.components.ct.feed.home.b.a {
    private com.kwad.sdk.lib.widget.a.c<CtAdTemplate, ?> aFU;
    private d aFW;
    private KSPageLoadingView aFX;
    private com.kwad.components.core.widget.a.b amL;
    private com.kwad.components.ct.widget.b avW;
    private com.kwad.sdk.lib.b.c<?, CtAdTemplate> avY;
    private KSPageLoadingView.a asf = new KSPageLoadingView.a() { // from class: com.kwad.components.ct.feed.home.c.b.1
        @Override // com.kwad.components.ct.widget.KSPageLoadingView.a
        public final void zP() {
            if (b.this.avY != null) {
                b.this.avY.refresh();
            }
        }
    };
    private f awa = new g() { // from class: com.kwad.components.ct.feed.home.c.b.2
        @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
        public final void m(boolean z, boolean z2) {
            if (z) {
                if (b.this.aFU.isEmpty()) {
                    b.this.aFX.Fi();
                    return;
                }
                return;
            }
            b.this.avW.Cu();
        }

        @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
        public final void n(boolean z, boolean z2) {
            b.this.aFX.hide();
            if (z) {
                if (b.this.aFU.isEmpty()) {
                    b.this.aFX.cd(b.this.amL.wO());
                } else if (!b.this.aFW.ad(b.this.avW)) {
                    b.this.aFW.addFooterView(b.this.avW);
                }
            }
            b.this.avW.ce(b.this.avY.Gx());
        }

        @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
        public final void a(boolean z, int i, String str) {
            b.this.aFX.hide();
            if (z) {
                if (b.this.aFU.isEmpty()) {
                    if (e.bCI.errorCode == i) {
                        b.this.aFX.Lg();
                    } else if (ao.isNetworkConnected(b.this.aFX.getContext())) {
                        b.this.aFX.cd(b.this.amL.wO());
                    } else {
                        b.this.aFX.cc(b.this.amL.wO());
                    }
                }
            } else if (e.bCw.errorCode == i) {
                ac.dm(b.this.getContext());
            } else if (e.bCI.errorCode != i) {
                ac.dn(b.this.getContext());
            }
            b.this.avW.ce(b.this.avY.Gx());
        }
    };

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.aFX = (KSPageLoadingView) findViewById(R.id.ksad_page_loading);
        this.avW = new com.kwad.components.ct.widget.b(getContext(), true);
    }

    @Override // com.kwad.components.ct.feed.home.b.a, com.kwad.sdk.lib.a.a.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.amL = this.aFr.aFs;
        this.avY = this.aFr.avY;
        this.aFU = this.aFr.aFU;
        this.aFW = this.aFr.aFW;
        this.avY.a(this.awa);
        this.aFX.setRetryClickListener(this.asf);
        this.aFX.setScene(this.aFr.mSceneImpl);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.avY.b(this.awa);
        this.aFX.setRetryClickListener(null);
    }
}
