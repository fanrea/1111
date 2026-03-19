package com.kwad.components.ad.reward.presenter.platdetail.actionbar;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.kwad.components.ad.reward.n.n;
import com.kwad.components.ad.reward.n.r;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.u.l;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class e extends com.kwad.components.ad.reward.presenter.b implements RewardActionBarControl.c {
    private n Ag;
    private int Ah;
    private FrameLayout.LayoutParams Ai;
    private n.a Aj;
    private ViewGroup lz;
    private KsLogoView xE;

    public e(ViewGroup viewGroup, n.a aVar) {
        this.lz = viewGroup;
        this.Aj = aVar;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.xE = (KsLogoView) findViewById(R.id.ksad_ad_label_play_bar);
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.vb.tw.a(this);
        AdInfo adInfoEP = com.kwad.sdk.core.response.b.e.eP(this.vb.mAdTemplate);
        this.Ah = this.xE.getVisibility();
        this.Ai = d.a(getContext(), adInfoEP, this.xE, R.dimen.ksad_reward_order_logo_margin_bottom, !this.vb.tu.la());
        n nVar = new n(this.lz, new com.kwad.components.ad.reward.n.a(getContext(), this.vb) { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.e.1
            @Override // com.kwad.components.ad.reward.n.a, com.kwad.components.ad.reward.n.b
            public final void jw() {
                e.this.vb.a(1, e.this.getContext(), 10, 2);
            }

            @Override // com.kwad.components.ad.reward.n.a, com.kwad.components.ad.reward.n.b
            public final void jx() {
                e.this.vb.a(1, e.this.getContext(), 10, 2);
            }
        });
        this.Ag = nVar;
        nVar.a(this.Aj);
        this.Ag.b(r.ab(this.vb.mAdTemplate));
        l.a(new com.kwad.components.core.widget.f(), this.Ag.hT());
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.xE.setVisibility(this.Ah);
        FrameLayout.LayoutParams layoutParams = this.Ai;
        if (layoutParams != null) {
            this.xE.setLayoutParams(layoutParams);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl.c
    public final void e(a aVar) {
        this.lz.setVisibility(0);
        RewardActionBarControl.a(aVar, this.lz, RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_ORDER);
    }
}
