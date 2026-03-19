package com.kwad.components.ct.tube.panel.choose.c;

import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.components.ct.tube.view.EpisodeChooseLoadingView;
import com.kwad.components.ct.widget.KSPageLoadingView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.network.e;
import com.kwad.sdk.lib.b.f;
import com.kwad.sdk.lib.b.g;
import com.kwad.sdk.lib.widget.a.c;
import com.kwad.sdk.utils.ao;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends com.kwad.components.ct.tube.panel.choose.b.a {
    private c<CtAdTemplate, ?> aFU;
    private EpisodeChooseLoadingView aXE;
    private com.kwad.components.core.widget.a.b amL;
    private com.kwad.sdk.lib.b.c<?, CtAdTemplate> avY;
    private final KSPageLoadingView.a asf = new KSPageLoadingView.a() { // from class: com.kwad.components.ct.tube.panel.choose.c.a.1
        @Override // com.kwad.components.ct.widget.KSPageLoadingView.a
        public final void zP() {
            if (a.this.avY != null) {
                a.this.avY.refresh();
            }
        }
    };
    private final f awa = new g() { // from class: com.kwad.components.ct.tube.panel.choose.c.a.2
        @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
        public final void m(boolean z, boolean z2) {
            if (z && a.this.aFU.isEmpty()) {
                a.this.aXE.Fi();
            }
        }

        @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
        public final void n(boolean z, boolean z2) {
            a.this.aXE.hide();
            if (z && a.this.aFU.isEmpty()) {
                a.this.aXE.cd(a.this.amL.wO());
            }
        }

        @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
        public final void a(boolean z, int i, String str) {
            a.this.aXE.hide();
            if (z && a.this.aFU.isEmpty()) {
                if (e.bCI.errorCode == i) {
                    a.this.aXE.Lg();
                } else if (ao.isNetworkConnected(a.this.aXE.getContext())) {
                    a.this.aXE.cd(a.this.amL.wO());
                } else {
                    a.this.aXE.cc(a.this.amL.wO());
                }
            }
        }
    };

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.aXE = (EpisodeChooseLoadingView) findViewById(R.id.ksad_page_loading);
    }

    @Override // com.kwad.components.ct.tube.panel.choose.b.a, com.kwad.sdk.lib.a.a.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.amL = this.aXn.aFs;
        this.avY = this.aXn.avY;
        this.aFU = this.aXn.aFU;
        this.avY.a(this.awa);
        this.aXE.setRetryClickListener(this.asf);
        this.aXE.setScene(this.aXn.mSceneImpl);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.avY.b(this.awa);
        this.aXE.setRetryClickListener(null);
    }
}
