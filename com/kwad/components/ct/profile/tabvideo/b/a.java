package com.kwad.components.ct.profile.tabvideo.b;

import com.kwad.components.ct.profile.widget.KSProfilePageLoadingView;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.components.ct.widget.KSPageLoadingView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.network.e;
import com.kwad.sdk.lib.a.a.b;
import com.kwad.sdk.lib.b.f;
import com.kwad.sdk.lib.b.g;
import com.kwad.sdk.lib.widget.a.c;
import com.kwad.sdk.lib.widget.a.d;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.ao;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends com.kwad.sdk.lib.a.a.a<CtAdTemplate, b<?, CtAdTemplate>> {
    private c<CtAdTemplate, ?> aFU;
    private d aFW;
    private KSProfilePageLoadingView aRu;
    private com.kwad.components.ct.widget.b avW;
    private com.kwad.sdk.lib.b.c<?, CtAdTemplate> avY;
    private KSPageLoadingView.a asf = new KSPageLoadingView.a() { // from class: com.kwad.components.ct.profile.tabvideo.b.a.1
        @Override // com.kwad.components.ct.widget.KSPageLoadingView.a
        public final void zP() {
            if (a.this.avY != null) {
                a.this.avY.refresh();
            }
        }
    };
    private f awa = new g() { // from class: com.kwad.components.ct.profile.tabvideo.b.a.2
        @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
        public final void m(boolean z, boolean z2) {
            if (z) {
                if (a.this.aFU.isEmpty()) {
                    a.this.aRu.Fi();
                    return;
                }
                return;
            }
            a.this.avW.Cu();
        }

        @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
        public final void n(boolean z, boolean z2) {
            a.this.aRu.hide();
            if (z) {
                if (a.this.aFU.isEmpty()) {
                    a.this.aRu.Ju();
                } else if (!a.this.aFW.ad(a.this.avW)) {
                    a.this.aFW.addFooterView(a.this.avW);
                }
            }
            a.this.avW.ce(a.this.avY.Gx());
        }

        @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
        public final void a(boolean z, int i, String str) {
            a.this.aRu.hide();
            if (z) {
                if (a.this.aFU.isEmpty()) {
                    if (ao.isNetworkConnected(a.this.aRu.getContext())) {
                        a.this.aRu.Ju();
                    } else {
                        a.this.aRu.Jt();
                    }
                }
            } else if (e.bCw.errorCode == i) {
                ac.dm(a.this.getContext());
            } else {
                ac.dn(a.this.getContext());
            }
            a.this.avW.ce(a.this.avY.Gx());
        }
    };

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.aRu = (KSProfilePageLoadingView) findViewById(R.id.ksad_page_loading);
        this.avW = new com.kwad.components.ct.widget.b(getContext(), false);
    }

    @Override // com.kwad.sdk.lib.a.a.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.avY = this.cck.avY;
        this.aFW = this.cck.aFW;
        this.aFU = this.cck.aFU;
        this.avY.a(this.awa);
        this.aRu.setRetryClickListener(this.asf);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.avY.b(this.awa);
        this.aRu.setRetryClickListener(null);
    }
}
