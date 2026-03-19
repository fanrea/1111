package com.kwad.components.ct.horizontal.video.b.c;

import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.components.ct.widget.KSHalfPageLoadingView;
import com.kwad.components.ct.widget.KSPageLoadingView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.network.e;
import com.kwad.sdk.lib.b.f;
import com.kwad.sdk.lib.b.g;
import com.kwad.sdk.lib.widget.a.c;
import com.kwad.sdk.lib.widget.a.d;
import com.kwad.sdk.utils.ac;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends com.kwad.components.ct.horizontal.video.b.b.a {
    private c<CtAdTemplate, ?> aFU;
    private d aFW;
    private KSHalfPageLoadingView arZ;
    private com.kwad.components.ct.widget.b avW;
    private com.kwad.sdk.lib.b.c<?, CtAdTemplate> avY;
    private com.kwad.components.ct.horizontal.video.c aOE = new com.kwad.components.ct.horizontal.video.c() { // from class: com.kwad.components.ct.horizontal.video.b.c.b.1
        @Override // com.kwad.components.ct.horizontal.video.c
        public final void A(CtAdTemplate ctAdTemplate) {
            if (b.this.arZ != null) {
                b.this.arZ.Cu();
            }
        }
    };
    private KSPageLoadingView.a asf = new KSPageLoadingView.a() { // from class: com.kwad.components.ct.horizontal.video.b.c.b.2
        @Override // com.kwad.components.ct.widget.KSPageLoadingView.a
        public final void zP() {
            if (b.this.avY != null) {
                b.this.avY.refresh();
            }
        }
    };
    private f awa = new g() { // from class: com.kwad.components.ct.horizontal.video.b.c.b.3
        @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
        public final void m(boolean z, boolean z2) {
            if (z) {
                if (b.this.aFU.isEmpty()) {
                    b.this.arZ.Cu();
                }
                b.this.arZ.Lz();
            } else {
                b.this.avW.Cu();
                b.this.arZ.LA();
            }
        }

        @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
        public final void n(boolean z, boolean z2) {
            b.this.arZ.hide();
            b.this.arZ.LA();
            b.this.arZ.setBackgroundColor(0);
            if (z) {
                if (b.this.aFU.isEmpty()) {
                    b.this.arZ.Ju();
                } else {
                    if (!b.this.aFW.ad(b.this.avW)) {
                        b.this.aFW.addFooterView(b.this.avW);
                    }
                    ((com.kwad.components.ct.horizontal.video.b.b.b) b.this.cck).Wj.scrollToPosition(0);
                }
            }
            b.this.avW.ce(b.this.avY.Gx());
        }

        @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
        public final void a(boolean z, int i, String str) {
            b.this.arZ.hide();
            b.this.arZ.LA();
            if (z) {
                b.this.arZ.setBackgroundColor(-1);
                if (e.bCI.errorCode == i) {
                    b.this.arZ.Lx();
                } else if (e.bCw.errorCode == i) {
                    b.this.arZ.Jt();
                } else {
                    b.this.arZ.Ju();
                }
            } else {
                b.this.arZ.setBackgroundColor(0);
                if (e.bCw.errorCode == i) {
                    ac.dm(b.this.getContext());
                } else if (e.bCI.errorCode != i) {
                    ac.dn(b.this.getContext());
                }
            }
            b.this.avW.ce(b.this.avY.Gx());
        }
    };

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.arZ = (KSHalfPageLoadingView) findViewById(R.id.ksad_horizontal_detail_video_related_page_loading);
        this.avW = new com.kwad.components.ct.widget.b(getContext(), true, "无更多内容");
    }

    @Override // com.kwad.components.ct.horizontal.video.b.b.a, com.kwad.sdk.lib.a.a.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.avY = ((com.kwad.components.ct.horizontal.video.b.b.b) this.cck).avY;
        this.aFU = ((com.kwad.components.ct.horizontal.video.b.b.b) this.cck).aFU;
        this.aFW = ((com.kwad.components.ct.horizontal.video.b.b.b) this.cck).aFW;
        this.avY.a(this.awa);
        this.arZ.setRetryClickListener(this.asf);
        this.arZ.setBackgroundColor(0);
        if (((com.kwad.components.ct.horizontal.video.b.b.b) this.cck).aLD != null) {
            ((com.kwad.components.ct.horizontal.video.b.b.b) this.cck).aLD.a(this.aOE);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.avY.b(this.awa);
        this.arZ.setRetryClickListener(null);
        this.arZ.setBackgroundColor(0);
        if (((com.kwad.components.ct.horizontal.video.b.b.b) this.cck).aLD != null) {
            ((com.kwad.components.ct.horizontal.video.b.b.b) this.cck).aLD.b(this.aOE);
        }
    }
}
