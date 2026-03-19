package com.kwad.components.ad.reward.presenter.f;

import android.view.View;
import android.view.ViewGroup;
import com.kwad.components.ad.reward.e.j;
import com.kwad.components.ad.reward.e.n;
import com.kwad.components.ad.reward.g;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.ba;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.b.e;
import com.kwad.sdk.R;
import com.kwad.sdk.components.t;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class h extends g implements j, com.kwad.components.ad.reward.presenter.platdetail.actionbar.a {
    private boolean BM;
    private boolean BN;
    private View BQ;
    private ba eK;
    private boolean BR = false;
    private com.kwad.components.ad.reward.e.g mPlayEndPageListener = new com.kwad.components.ad.reward.e.a() { // from class: com.kwad.components.ad.reward.presenter.f.h.1
        @Override // com.kwad.components.ad.reward.e.g
        public final void dc() {
            h.this.BP.setVisibility(8);
        }
    };
    private g.a BS = new g.a() { // from class: com.kwad.components.ad.reward.presenter.f.h.2
        @Override // com.kwad.components.ad.reward.g.a
        public final void hh() {
            h.this.BN = true;
        }

        @Override // com.kwad.components.ad.reward.g.a
        public final void hi() {
            h.this.BN = true;
            h.this.km();
        }

        @Override // com.kwad.components.ad.reward.g.a
        public final void hj() {
            h.this.BN = false;
            if (h.this.eK != null) {
                h.this.eK.vi();
            }
        }

        @Override // com.kwad.components.ad.reward.g.a
        public final void hk() {
            h.this.BN = false;
        }
    };

    @Override // com.kwad.components.ad.reward.e.j
    public final void a(PlayableSource playableSource, n nVar) {
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void g(AdTemplate adTemplate) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTKReaderScene() {
        return "tk_top_floor_bar";
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.vb.a(this.BS);
        this.vb.tw.a(this);
        this.vb.b(this.mPlayEndPageListener);
        com.kwad.components.ad.reward.a.gl().a(this);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        ba baVar = this.eK;
        if (baVar != null) {
            baVar.vf();
            this.eK.vg();
        }
        super.onUnbind();
        this.vb.b(this.BS);
        this.vb.tw.b(this);
        this.vb.c(this.mPlayEndPageListener);
        com.kwad.components.ad.reward.a.gl().b(this);
        this.vb.a((com.kwad.components.core.webview.tachikoma.f.a) null);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTkTemplateId() {
        return com.kwad.sdk.core.response.b.b.ed(this.vb.mAdTemplate);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void aE() {
        super.aE();
        km();
        this.BR = true;
        this.BP.setVisibility(0);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(TKRenderFailReason tKRenderFailReason) {
        ba baVar = this.eK;
        if (baVar != null) {
            baVar.vf();
            this.eK.vg();
        }
        this.BR = false;
        this.BP.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void km() {
        ba baVar = this.eK;
        if (baVar == null || !this.BN) {
            return;
        }
        if (!this.BM) {
            baVar.vd();
            this.eK.ve();
            this.BM = true;
            return;
        }
        baVar.vh();
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(ae.a aVar) {
        float fBv = com.kwad.sdk.c.a.a.bv(getContext());
        float screenHeight = com.kwad.sdk.c.a.a.getScreenHeight(getContext());
        aVar.width = (int) ((com.kwad.sdk.c.a.a.getScreenWidth(getContext()) / fBv) + 0.5f);
        aVar.height = (int) ((screenHeight / fBv) + 0.5f);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.g
    protected final int jb() {
        return R.id.ksad_js_topfloor;
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(t tVar, com.kwad.sdk.core.webview.b bVar) {
        super.a(tVar, bVar);
        tVar.c(new com.kwad.components.core.webview.tachikoma.b.e(kp()));
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(ba baVar) {
        super.a(baVar);
        this.eK = baVar;
    }

    private e.b kp() {
        return new e.b() { // from class: com.kwad.components.ad.reward.presenter.f.h.3
            @Override // com.kwad.components.core.webview.tachikoma.b.e.b
            public final int kq() {
                if (h.this.vb.ua != null) {
                    return com.kwad.sdk.c.a.a.px2dip(h.this.getContext(), r0.dw());
                }
                if (h.this.BQ == null) {
                    return 0;
                }
                if (!(h.this.BQ.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                    return com.kwad.sdk.c.a.a.px2dip(h.this.getContext(), h.this.BQ.getHeight());
                }
                return com.kwad.sdk.c.a.a.px2dip(h.this.getContext(), h.this.BQ.getHeight() + ((ViewGroup.MarginLayoutParams) r0).bottomMargin);
            }
        };
    }

    @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.a
    public final void a(RewardActionBarControl.ShowActionBarResult showActionBarResult, View view) {
        this.BQ = view;
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void dp() {
        if (this.BR) {
            this.BP.setVisibility(0);
        }
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void dq() {
        if (this.BR) {
            this.BP.setVisibility(8);
        }
    }
}
