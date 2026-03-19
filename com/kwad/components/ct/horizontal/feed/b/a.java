package com.kwad.components.ct.horizontal.feed.b;

import android.graphics.Color;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.components.ct.widget.KSPageLoadingView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.network.e;
import com.kwad.sdk.lib.b.f;
import com.kwad.sdk.lib.b.g;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.ao;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends com.kwad.components.ct.horizontal.feed.a.a {
    private com.kwad.sdk.lib.widget.a.c<CtAdTemplate, ?> aFU;
    private com.kwad.sdk.lib.widget.a.d aFW;
    private KSPageLoadingView aFX;
    private com.kwad.components.core.widget.a.b amL;
    private com.kwad.components.ct.widget.b avW;
    private com.kwad.sdk.lib.b.c<?, CtAdTemplate> avY;
    private KSPageLoadingView.a asf = new KSPageLoadingView.a() { // from class: com.kwad.components.ct.horizontal.feed.b.a.1
        @Override // com.kwad.components.ct.widget.KSPageLoadingView.a
        public final void zP() {
            if (a.this.avY != null) {
                a.this.avY.refresh();
            }
        }
    };
    private f awa = new g() { // from class: com.kwad.components.ct.horizontal.feed.b.a.2
        @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
        public final void m(boolean z, boolean z2) {
            if (z) {
                if (a.this.aFU.isEmpty()) {
                    a.this.aFX.Fi();
                    return;
                }
                return;
            }
            a.this.avW.Cu();
        }

        @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
        public final void n(boolean z, boolean z2) {
            a.this.aFX.hide();
            if (z) {
                if (a.this.aFU.isEmpty()) {
                    a.this.aFX.cd(a.this.amL.wO());
                } else if (!a.this.aFW.ad(a.this.avW)) {
                    a.this.aFW.addFooterView(a.this.avW);
                }
            }
            a.this.avW.ce(a.this.avY.Gx());
        }

        @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
        public final void a(boolean z, int i, String str) {
            a.this.aFX.hide();
            if (z) {
                if (a.this.aFU.isEmpty()) {
                    if (e.bCI.errorCode == i) {
                        a.this.aFX.Lg();
                    } else if (ao.isNetworkConnected(a.this.aFX.getContext())) {
                        a.this.aFX.cd(a.this.amL.wO());
                    } else {
                        a.this.aFX.cc(a.this.amL.wO());
                    }
                }
            } else if (e.bCw.errorCode == i) {
                ac.dm(a.this.getContext());
            } else if (e.bCI.errorCode == i) {
                ac.dp(a.this.getContext());
            } else {
                ac.dn(a.this.getContext());
            }
            a.this.avW.ce(a.this.avY.Gx());
        }
    };

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.aFX = (KSPageLoadingView) findViewById(R.id.ksad_page_loading);
        com.kwad.components.ct.widget.b bVar = new com.kwad.components.ct.widget.b(getContext(), true, "无更多内容");
        this.avW = bVar;
        bVar.setBackgroundColor(Color.parseColor("#f8f8f8"));
    }

    @Override // com.kwad.components.ct.horizontal.feed.a.a, com.kwad.sdk.lib.a.a.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.amL = ((com.kwad.components.ct.horizontal.feed.a.b) this.cck).aFs;
        this.avY = ((com.kwad.components.ct.horizontal.feed.a.b) this.cck).avY;
        this.aFU = ((com.kwad.components.ct.horizontal.feed.a.b) this.cck).aFU;
        this.aFW = ((com.kwad.components.ct.horizontal.feed.a.b) this.cck).aFW;
        this.avY.a(this.awa);
        this.aFX.setRetryClickListener(this.asf);
        this.aFX.setScene(((com.kwad.components.ct.horizontal.feed.a.b) this.cck).mSceneImpl);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.avY.b(this.awa);
        this.aFX.setRetryClickListener(null);
    }
}
