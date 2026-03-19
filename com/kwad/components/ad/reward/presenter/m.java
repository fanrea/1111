package com.kwad.components.ad.reward.presenter;

import com.kwad.sdk.core.response.model.AdInfo;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class m extends b {
    private long lP;
    private com.kwad.components.ad.reward.e.b tt;
    private com.kwad.components.core.video.o xH;
    private com.kwad.components.core.video.o xI = new com.kwad.components.core.video.o() { // from class: com.kwad.components.ad.reward.presenter.m.1
        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayStart() {
            super.onMediaPlayStart();
            m.this.tt.onVideoPlayStart();
            m.this.vb.ui = false;
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayCompleted() {
            super.onMediaPlayCompleted();
            if (m.this.vb.tI && m.this.vb.tN) {
                m.this.tt.onVideoSkipToEnd(m.this.lP);
            } else {
                m.this.vb.ui = true;
                m.this.tt.onVideoPlayEnd();
            }
            AdInfo adInfoEP = com.kwad.sdk.core.response.b.e.eP(m.this.vb.mAdTemplate);
            if (com.kwad.sdk.core.response.b.a.aS(adInfoEP) && com.kwad.sdk.core.response.b.a.aR(adInfoEP) == 1) {
                return;
            }
            f.u(m.this.vb);
            if (m.this.vb.ui) {
                com.kwad.components.ad.reward.l.j(m.this.vb);
            }
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayProgress(long j, long j2) {
            super.onMediaPlayProgress(j, j2);
            m.this.vb.uh = j2;
            if (m.this.vb.tN) {
                return;
            }
            m.this.lP = j2;
        }
    };
    private final com.kwad.components.core.video.o lv = new com.kwad.components.core.video.o() { // from class: com.kwad.components.ad.reward.presenter.m.2
        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayStart() {
            m.this.tt.onVideoPlayStart();
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayProgress(long j, long j2) {
            m.this.vb.uh = j2;
            m.this.vb.ui = j - j2 < 800;
            if (m.this.vb.tN) {
                return;
            }
            m.this.lP = j2;
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayError(int i, int i2) {
            m.this.tt.onVideoPlayError(i, i2);
            m.this.iE();
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayCompleted() {
            if (m.this.vb.tN) {
                m.this.tt.onVideoSkipToEnd(m.this.lP);
            } else {
                m.this.tt.onVideoPlayEnd();
            }
            AdInfo adInfoEP = com.kwad.sdk.core.response.b.e.eP(m.this.vb.mAdTemplate);
            if (com.kwad.sdk.core.response.b.a.aS(adInfoEP) && com.kwad.sdk.core.response.b.a.aR(adInfoEP) == 1) {
                return;
            }
            f.u(m.this.vb);
            if (m.this.vb.ui) {
                com.kwad.components.ad.reward.l.j(m.this.vb);
            }
        }
    };

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.vb.uh = 0L;
        this.vb.ui = false;
        this.tt = this.vb.tt;
        if (this.vb.tu.la()) {
            this.xH = this.xI;
        } else {
            this.xH = this.lv;
        }
        this.vb.tu.a(this.xH);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.vb.tu.b(this.xH);
    }
}
