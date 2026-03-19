package com.kwad.components.ad.reward.presenter.a;

import com.kwad.components.ad.reward.g;
import com.kwad.components.ad.reward.k.q;
import com.kwad.components.ad.reward.presenter.f.g;
import com.kwad.components.core.video.o;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.ba;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.b.p;
import com.kwad.components.core.webview.tachikoma.c.n;
import com.kwad.components.core.webview.tachikoma.c.u;
import com.kwad.components.core.webview.tachikoma.i;
import com.kwad.components.core.webview.tachikoma.j;
import com.kwad.sdk.R;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.t;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.response.b.b;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.utils.bs;
import com.kwad.sdk.utils.ca;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends g implements j {
    private i hF;
    private AdInfo mAdInfo;
    private long yT;
    private long yU;
    private boolean yV;
    private boolean yW;
    private g.b yX = new g.b() { // from class: com.kwad.components.ad.reward.presenter.a.a.1
        @Override // com.kwad.components.ad.reward.g.b
        public final boolean interceptPlayCardResume() {
            return a.this.BP != null && a.this.BP.getVisibility() == 0;
        }
    };
    private final o lv = new o() { // from class: com.kwad.components.ad.reward.presenter.a.a.2
        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayProgress(long j, long j2) {
            super.onMediaPlayProgress(j, j2);
            long jA = com.kwad.components.ad.reward.g.a(j, a.this.mAdInfo);
            if (j2 <= a.this.yT || jA - j2 <= a.this.yU || a.this.yV) {
                return;
            }
            a.a(a.this, true);
            a.this.hF.a(a.this.vb.getActivity(), a.this.vb.mAdResultData, a.this);
        }
    };

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(ba baVar) {
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(com.kwad.components.core.webview.tachikoma.b.o oVar) {
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(p pVar) {
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(n nVar) {
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(u uVar) {
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void aF() {
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void g(AdTemplate adTemplate) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTKReaderScene() {
        return "tk_reward_interact_card";
    }

    static /* synthetic */ boolean a(a aVar, boolean z) {
        aVar.yV = true;
        return true;
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        if (this.hF == null) {
            this.hF = jc();
        }
        this.mAdInfo = e.eP(this.vb.mAdTemplate);
        this.yT = com.kwad.sdk.core.response.b.a.aN(r0) * 1000;
        this.yU = com.kwad.sdk.core.response.b.a.aO(this.mAdInfo) * 1000;
        this.vb.tu.a(this.lv);
        this.vb.a(this.yX);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.vb.tu.b(this.lv);
        this.vb.b(this.yX);
        this.hF.kD();
        this.hF = null;
        this.BP.setVisibility(8);
        this.yV = false;
        this.yW = false;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTkTemplateId() {
        return b.eq(this.vb.mAdTemplate);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final com.kwad.sdk.widget.i getTouchCoordsView() {
        return this.vb.mRootContainer;
    }

    @Override // com.kwad.components.ad.reward.presenter.f.g
    public final int jb() {
        return R.id.ksad_js_interact;
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(TKRenderFailReason tKRenderFailReason) {
        c.d("TkRewardInteractPresenter", "onTkLoadFailed: ");
        this.BP.setVisibility(8);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void aE() {
        c.d("TkRewardInteractPresenter", "onTkLoadSuccess: ");
        getContext();
        if (aq.apb()) {
            this.BP.setVisibility(0);
            com.kwad.components.ad.reward.d.a.S(this.vb.mContext);
            this.vb.tu.pause();
            this.yW = true;
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(t tVar, com.kwad.sdk.core.webview.b bVar) {
        tVar.c(new q(bVar, this.vb.mApkDownloadHelper, this.vb, -1L, new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ad.reward.presenter.a.a.3
            @Override // com.kwad.sdk.core.webview.d.a.a
            public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
                if (a.this.vb.tt != null) {
                    a.this.vb.tt.db();
                }
            }
        }, null));
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(ae.a aVar) {
        float fBv = com.kwad.sdk.c.a.a.bv(getContext());
        aVar.width = (int) ((bs.getScreenWidth(getContext()) / fBv) + 0.5f);
        aVar.height = (int) ((bs.getScreenHeight(getContext()) / fBv) + 0.5f);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(WebCloseStatus webCloseStatus) {
        this.vb.tL = webCloseStatus != null && webCloseStatus.interactSuccess;
        if (this.vb.tL) {
            this.vb.tu.kX();
        }
        if (this.yW && ca.v(this.BP, 30)) {
            this.vb.tu.resume();
        }
        this.BP.setVisibility(8);
    }

    private i jc() {
        return new i(-1L, getContext());
    }
}
