package com.kwad.components.ad.reward.presenter.e;

import android.widget.FrameLayout;
import com.kwad.components.ad.reward.page.BackPressHandleResult;
import com.kwad.components.ad.reward.presenter.f.g;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.ba;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.sdk.R;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.response.b.b;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.bs;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends g implements com.kwad.components.ad.reward.k.a {
    private AdMatrixInfo.PreLandingPageTKInfo Bl;
    private ba Bm;
    private boolean sI = false;
    private com.kwad.components.ad.reward.e.g Bn = new com.kwad.components.ad.reward.e.a() { // from class: com.kwad.components.ad.reward.presenter.e.a.1
        @Override // com.kwad.components.ad.reward.e.g
        public final void dc() {
            c.d("TKPreFormPresenter", "handleToSkip PlayEndPageListener onPlayEndPageShow: " + a.this.vb.tN);
            if (a.this.vb.tN) {
                return;
            }
            a.this.jW();
        }
    };

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void g(AdTemplate adTemplate) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTKReaderScene() {
        return "tk_pre_landing_page";
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.Bl = b.ea(this.vb.mAdTemplate);
        this.vb.b(this.Bn);
        this.vb.a((com.kwad.components.ad.reward.k.a) this);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.vb.c(this.Bn);
        this.vb.b((com.kwad.components.ad.reward.k.a) this);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTkTemplateId() {
        return b.es(this.vb.mAdTemplate);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.g
    public final int jb() {
        return R.id.ksad_pre_form_card;
    }

    @Override // com.kwad.components.ad.reward.presenter.f.g
    public final void a(FrameLayout frameLayout) {
        frameLayout.setVisibility(4);
        frameLayout.setClickable(false);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(ae.a aVar) {
        float fBv = com.kwad.sdk.c.a.a.bv(getContext());
        aVar.width = (int) ((bs.getScreenWidth(getContext()) / fBv) + 0.5f);
        aVar.height = (int) ((bs.getScreenHeight(getContext()) / fBv) + 0.5f);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(ba baVar) {
        super.a(baVar);
        this.Bm = baVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jW() {
        if (!this.sI || this.Bl == null) {
            return;
        }
        c.d("TKPreFormPresenter", "handleToSkip handleToPlayEnd isPlayEndShow: " + this.Bl.isPlayEndShow());
        if (this.Bl.isPlayEndShow()) {
            T(true);
        }
    }

    private void jX() {
        if (!this.sI || this.Bl == null) {
            return;
        }
        c.d("TKPreFormPresenter", "handleToSkip mPreLandingPageData isSkipShow: " + this.Bl.isSkipShow());
        if (this.Bl.isSkipShow()) {
            T(true);
        }
    }

    public final BackPressHandleResult hB() {
        if (this.Bx == null || this.BP == null) {
            return BackPressHandleResult.NOT_HANDLED;
        }
        if (this.BP.getVisibility() == 0) {
            return this.Bx.hB();
        }
        return BackPressHandleResult.NOT_HANDLED;
    }

    private void T(final boolean z) {
        c.d("TKPreFormPresenter", "switchPreForm: " + z);
        this.BP.post(new bh() { // from class: com.kwad.components.ad.reward.presenter.e.a.2
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                a.this.BP.setVisibility(z ? 0 : 4);
                a.this.BP.setClickable(z);
                if (a.this.Bm != null) {
                    if (z) {
                        a.this.Bm.vd();
                        a.this.Bm.ve();
                    } else {
                        a.this.Bm.vf();
                        a.this.Bm.vg();
                    }
                }
            }
        });
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void aE() {
        super.aE();
        c.d("TKPreFormPresenter", "onTkLoadSuccess");
        this.sI = true;
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(TKRenderFailReason tKRenderFailReason) {
        super.a(tKRenderFailReason);
        this.sI = false;
        c.d("TKPreFormPresenter", "onTkLoadFailed");
        T(false);
    }

    @Override // com.kwad.components.ad.reward.k.a
    public final void jY() {
        c.d("TKPreFormPresenter", "onPlayComplete: ");
        jW();
    }

    @Override // com.kwad.components.ad.reward.k.a
    public final void jZ() {
        c.d("TKPreFormPresenter", "onSkipClick: ");
        jX();
    }
}
