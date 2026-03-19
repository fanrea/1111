package com.kwad.components.ad.reward.presenter.b;

import android.view.View;
import com.kwad.components.ad.reward.n.r;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.video.o;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c extends com.kwad.components.ad.reward.presenter.b implements com.kwad.components.ad.reward.presenter.platdetail.actionbar.a {
    private RewardActionBarControl tw;
    private o xI = new o() { // from class: com.kwad.components.ad.reward.presenter.b.c.1
        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayProgress(long j, long j2) {
            super.onMediaPlayProgress(j, j2);
            c.this.iJ();
        }
    };
    private com.kwad.components.ad.reward.n.o ze;

    @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.a
    public final void a(RewardActionBarControl.ShowActionBarResult showActionBarResult, View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iJ() {
        this.tw.P(false);
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.tw = this.vb.tw;
        this.vb.tu.a(this.xI);
        AdTemplate adTemplate = this.vb.mAdTemplate;
        AdInfo adInfoEP = e.eP(adTemplate);
        if (com.kwad.sdk.core.response.b.a.df(adInfoEP)) {
            if (this.ze == null) {
                this.ze = new com.kwad.components.ad.reward.n.o(this.vb);
            }
            this.ze.c(this.vb.mRootContainer, com.kwad.sdk.core.response.b.a.bl(adInfoEP));
            this.ze.b(r.ab(adTemplate));
            findViewById(R.id.ksad_reward_origin_live_root).setVisibility(8);
        }
        this.vb.tw.a(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.vb.tu.b(this.xI);
        this.vb.tw.b(this);
        com.kwad.components.ad.reward.n.o oVar = this.ze;
        if (oVar != null) {
            oVar.onUnbind();
        }
    }
}
