package com.kwad.components.ad.reward.presenter.g;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.kwad.components.ad.reward.e.l;
import com.kwad.components.ad.reward.g;
import com.kwad.components.ad.reward.l.d;
import com.kwad.components.ad.reward.n.c;
import com.kwad.components.ad.reward.n.q;
import com.kwad.sdk.R;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.widget.KSFrameLayout;
import com.kwad.sdk.widget.e;
import com.kwad.sdk.widget.j;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends com.kwad.components.ad.reward.presenter.b implements c.a, com.kwad.sdk.core.webview.d.a.a, e {
    private ViewGroup BU;
    private q BV;
    private ViewGroup BW;
    private com.kwad.components.ad.reward.n.e BX;
    private c BY;
    private c BZ;
    private final l mRewardVerifyListener = new l() { // from class: com.kwad.components.ad.reward.presenter.g.a.1
        @Override // com.kwad.components.ad.reward.e.l
        public final void onRewardVerify() {
            if (a.this.BY != null) {
                a.this.BY.le();
            }
            if (a.this.BZ != null) {
                a.this.BZ.le();
            }
        }
    };
    private com.kwad.components.ad.reward.l.a.a ud;

    @Override // com.kwad.sdk.core.webview.d.a.a
    public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        com.kwad.sdk.core.d.c.d("LandPageOpenTaskPresenter", "onBind");
        if (g.P(this.vb.mAdTemplate)) {
            this.ud = d.kN();
            this.vb.ud = this.ud;
            com.kwad.components.ad.reward.b.gp().a(this.mRewardVerifyListener);
            AdBaseFrameLayout adBaseFrameLayout = (AdBaseFrameLayout) findViewById(R.id.ksad_root_container);
            ViewGroup viewGroup = (ViewGroup) findViewById(R.id.ksad_activity_apk_info_area_native);
            this.BU = viewGroup;
            if (viewGroup != null) {
                viewGroup.setClickable(true);
                this.BU.setVisibility(8);
                new j(this.BU, this);
                c cVar = new c(this.BU);
                this.BZ = cVar;
                cVar.a(this);
                this.BZ.c(this.vb.mAdTemplate, false);
                ((KSFrameLayout) findViewById(R.id.ksad_right_area_webview_container)).setWidthBasedRatio(false);
                q qVar = new q((KsAdWebView) findViewById(R.id.ksad_right_area_webview), this.BU, null, this);
                this.BV = qVar;
                qVar.a(this.vb.mAdTemplate, adBaseFrameLayout);
            }
            a(adBaseFrameLayout);
        }
    }

    private void a(AdBaseFrameLayout adBaseFrameLayout) {
        getContext();
        if (!aq.apb()) {
            com.kwad.sdk.core.d.c.d("LandPageOpenTaskPresenter", "initBottomActionBar screen is horizontal");
            return;
        }
        ((ViewStub) findViewById(R.id.ksad_reward_apk_info_stub)).inflate();
        KSFrameLayout kSFrameLayout = (KSFrameLayout) findViewById(R.id.ksad_reward_apk_info_card_root);
        kSFrameLayout.setRadius(getContext().getResources().getDimension(R.dimen.ksad_reward_apk_info_card_step_icon_radius));
        if (com.kwad.sdk.core.response.b.d.eG(this.vb.mAdTemplate).size() == 0) {
            kSFrameLayout.setRatio(0.0f);
            com.kwad.sdk.c.a.a.t(kSFrameLayout, com.kwad.sdk.c.a.a.a(getContext(), 136.0f));
        } else {
            kSFrameLayout.setRatio(0.0f);
            com.kwad.sdk.c.a.a.t(kSFrameLayout, com.kwad.sdk.c.a.a.a(getContext(), 155.0f));
        }
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.ksad_reward_apk_info_card_native_container);
        this.BW = viewGroup;
        viewGroup.setClickable(true);
        new j(this.BW, this);
        c cVar = new c(this.BW);
        this.BY = cVar;
        cVar.a(this);
        this.BY.c(this.vb.mAdTemplate, true);
        com.kwad.components.ad.reward.n.e eVar = new com.kwad.components.ad.reward.n.e((KsAdWebView) findViewById(R.id.ksad_reward_apk_info_card_h5), this.BW, null, this);
        this.BX = eVar;
        eVar.a(this.vb.mAdTemplate, adBaseFrameLayout);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.sdk.core.d.c.d("LandPageOpenTaskPresenter", "onUnbind");
        com.kwad.components.ad.reward.n.e eVar = this.BX;
        if (eVar != null) {
            eVar.lg();
            this.BX = null;
        }
        c cVar = this.BZ;
        if (cVar != null) {
            cVar.ld();
        }
        com.kwad.components.ad.reward.b.gp().b(this.mRewardVerifyListener);
        this.vb.ud = null;
    }

    @Override // com.kwad.components.ad.reward.n.c.a
    public final void d(boolean z, int i) {
        e(z, 1);
    }

    @Override // com.kwad.sdk.widget.e
    public final void a(View view) {
        e(view, true);
    }

    @Override // com.kwad.sdk.widget.e
    public final void b(View view) {
        if (com.kwad.sdk.core.response.b.d.eE(this.vb.mAdTemplate)) {
            e(view, false);
        }
    }

    private void e(View view, boolean z) {
        int id = view.getId();
        if (id == R.id.ksad_reward_apk_info_card_native_container || id == R.id.ksad_activity_apk_info_area_native) {
            e(z, 2);
        }
    }

    private void e(boolean z, int i) {
        this.vb.a(1, getContext(), z ? 1 : 153, i);
    }
}
