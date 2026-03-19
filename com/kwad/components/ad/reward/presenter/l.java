package com.kwad.components.ad.reward.presenter;

import android.content.res.Resources;
import android.view.View;
import com.kwad.components.ad.reward.n.g;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class l extends b implements com.kwad.components.ad.reward.presenter.platdetail.actionbar.a {
    private RewardActionBarControl tw;
    private com.kwad.components.ad.reward.n.g xC;
    private KsLogoView xE;
    private com.kwad.components.ad.reward.n.l xF;
    private boolean xD = false;
    private com.kwad.components.core.video.o lv = new com.kwad.components.core.video.o() { // from class: com.kwad.components.ad.reward.presenter.l.1
        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayProgress(long j, long j2) throws Resources.NotFoundException {
            super.onMediaPlayProgress(j, j2);
            l.this.iJ();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void iJ() throws Resources.NotFoundException {
        if (this.xD) {
            return;
        }
        com.kwad.components.ad.reward.n.g gVar = this.xC;
        if (gVar == null) {
            this.tw.P(false);
        } else {
            gVar.a(new g.a() { // from class: com.kwad.components.ad.reward.presenter.l.2
                @Override // com.kwad.components.ad.reward.n.g.a
                public final void iK() {
                    l.this.tw.P(true);
                }
            }, 500L);
        }
        this.xD = true;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.xE = (KsLogoView) findViewById(R.id.ksad_ad_label_play_bar);
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.tw = this.vb.tw;
        this.vb.tu.a(this.lv);
        AdTemplate adTemplate = this.vb.mAdTemplate;
        boolean z = com.kwad.sdk.core.response.b.b.dS(adTemplate).displayWeakCard;
        this.vb.B(z);
        if (z) {
            if (this.xC == null) {
                this.xC = new com.kwad.components.ad.reward.n.g(this.vb);
            }
            this.xC.f((AdBaseFrameLayout) findViewById(R.id.ksad_root_container));
            this.xC.b(com.kwad.components.ad.reward.n.r.ab(adTemplate));
        }
        AdInfo adInfoEP = com.kwad.sdk.core.response.b.e.eP(adTemplate);
        if (com.kwad.sdk.core.response.b.a.cE(adTemplate)) {
            if (this.xF == null) {
                this.xF = new com.kwad.components.ad.reward.n.l(this.vb);
            }
            this.xF.h(this.vb.mRootContainer);
            this.xF.b(com.kwad.components.ad.reward.n.r.ab(adTemplate));
            com.kwad.components.ad.reward.presenter.platdetail.actionbar.d.a(getContext(), adInfoEP, this.xE, R.dimen.ksad_live_subscribe_card_logo_margin_bottom, false);
        }
        this.vb.tw.a(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.vb.tu.b(this.lv);
        this.vb.tw.b(this);
        com.kwad.components.ad.reward.n.l lVar = this.xF;
        if (lVar != null) {
            lVar.onUnbind();
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.a
    public final void a(RewardActionBarControl.ShowActionBarResult showActionBarResult, View view) {
        com.kwad.components.ad.reward.n.l lVar = this.xF;
        if (lVar != null) {
            lVar.ln();
        }
    }
}
