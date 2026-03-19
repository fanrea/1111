package com.kwad.components.ad.fullscreen.c;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.kwad.components.ad.reward.RewardRenderResult;
import com.kwad.components.ad.reward.e.g;
import com.kwad.components.ad.reward.page.BackPressHandleResult;
import com.kwad.components.ad.reward.presenter.d;
import com.kwad.components.ad.reward.presenter.f.h;
import com.kwad.components.ad.reward.presenter.j;
import com.kwad.components.ad.reward.presenter.k;
import com.kwad.components.ad.reward.presenter.l;
import com.kwad.components.ad.reward.presenter.m;
import com.kwad.components.ad.reward.presenter.r;
import com.kwad.components.ad.reward.presenter.v;
import com.kwad.components.core.e.e.f;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.sdk.R;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.aq;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends com.kwad.components.ad.reward.presenter.b implements g, f {
    private com.kwad.components.core.n.b lA;
    private r lB;
    private FrameLayout lC;
    private com.kwad.components.ad.reward.presenter.f.b lD;
    private com.kwad.components.core.webview.tachikoma.f.g lE;
    private com.kwad.components.ad.reward.presenter.e.a lF;
    private com.kwad.components.ad.reward.presenter.f.f lG;
    private boolean lH = false;
    private com.kwad.components.ad.fullscreen.b ly;
    private ViewGroup lz;

    @Override // com.kwad.components.ad.reward.e.g
    public final int getPriority() {
        return 0;
    }

    public b(com.kwad.components.core.n.b bVar, ViewGroup viewGroup, com.kwad.components.ad.fullscreen.b bVar2, com.kwad.components.ad.reward.g gVar) {
        this.lA = bVar;
        this.ly = bVar2;
        this.lz = viewGroup;
        this.vb = gVar;
        dg();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.lC = (FrameLayout) this.lz.findViewById(R.id.ksad_reward_play_layout);
    }

    private static boolean a(com.kwad.components.ad.reward.g gVar) {
        if (!e.Yc()) {
            com.kwad.components.ad.reward.monitor.b.a(gVar.mAdTemplate, TKRenderFailReason.SWITCH_CLOSE);
            return false;
        }
        if (com.kwad.sdk.core.response.b.a.bj(com.kwad.sdk.core.response.b.e.eP(gVar.mAdTemplate))) {
            return false;
        }
        AdMatrixInfo.FullScreenInfo fullScreenInfoDT = com.kwad.sdk.core.response.b.b.dT(gVar.mAdTemplate);
        if (fullScreenInfoDT != null && fullScreenInfoDT.renderType == 1) {
            return true;
        }
        com.kwad.components.ad.reward.monitor.b.a(gVar.mAdTemplate, TKRenderFailReason.TK_FILE_LOAD_ERROR);
        return false;
    }

    private void dg() {
        if (this.ly == null) {
            return;
        }
        dl();
        AdInfo adInfoCZ = this.ly.cZ();
        boolean zDq = com.kwad.sdk.core.response.b.a.dq(adInfoCZ);
        boolean zEE = com.kwad.sdk.core.response.b.b.eE(adInfoCZ);
        if (zDq) {
            this.vb.a(RewardRenderResult.LIVE_TK);
            com.kwad.components.core.webview.tachikoma.e.c.wq().a(dm());
            di();
        } else if (zEE) {
            com.kwad.components.core.webview.tachikoma.e.c.wq().a(dm());
            this.vb.a(RewardRenderResult.TK_IMAGE);
            dj();
        } else if (a(this.vb)) {
            this.vb.a(RewardRenderResult.FULLSCREEN_TK);
            dk();
            com.kwad.components.core.webview.tachikoma.e.c.wq().a(dm());
        } else {
            this.vb.a(RewardRenderResult.DEFAULT);
            dh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dh() {
        com.kwad.components.core.webview.tachikoma.e.c.wq().b(this.lE);
        com.kwad.components.core.e.e.g.qh().a(this);
        AdTemplate adTemplate = this.ly.getAdTemplate();
        AdInfo adInfoCZ = this.ly.cZ();
        boolean z = this.ly.da() && !aq.isOrientationPortrait();
        if (this.ly.lb) {
            a(this);
        }
        a(new v(), true);
        if (com.kwad.sdk.core.response.b.a.aT(adInfoCZ)) {
            a(new d(), true);
        }
        a(new m(), true);
        a(new com.kwad.components.ad.reward.presenter.platdetail.c(), true);
        if (com.kwad.sdk.core.response.b.b.dO(adInfoCZ)) {
            a(new h(), true);
        }
        if (!z) {
            a(new com.kwad.components.ad.reward.presenter.platdetail.actionbar.c(), true);
        }
        a(new com.kwad.components.ad.reward.presenter.c.a(), true);
        if (com.kwad.sdk.core.response.b.b.dY(adTemplate)) {
            a(new com.kwad.components.ad.fullscreen.c.a.f(), true);
        }
        if (com.kwad.sdk.core.response.b.a.bj(adInfoCZ)) {
            a(new com.kwad.components.ad.reward.presenter.platdetail.b(), true);
        }
        a(new l(), true);
        if (com.kwad.sdk.core.response.b.a.df(adInfoCZ)) {
            a(new com.kwad.components.ad.reward.presenter.b.c(), true);
            a(new com.kwad.components.ad.reward.presenter.b.b(), true);
            a(new k(), true);
            a(new com.kwad.components.ad.reward.presenter.b.a(), true);
        }
        r rVar = new r(adTemplate, false, false);
        this.lB = rVar;
        a((Presenter) rVar, true);
        a(new c(), true);
        a(new a(), true);
        a(new com.kwad.components.ad.reward.presenter.d.b(adTemplate, false), true);
        a(new com.kwad.components.ad.reward.presenter.e(adInfoCZ, this.lz), true);
        a(new j(), true);
    }

    private void di() {
        com.kwad.components.ad.fullscreen.c.c.c cVar = new com.kwad.components.ad.fullscreen.c.c.c();
        this.lD = cVar;
        d(cVar);
    }

    private void dj() {
        com.kwad.components.ad.fullscreen.c.c.a aVar = new com.kwad.components.ad.fullscreen.c.c.a();
        this.lG = aVar;
        d(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar) {
        if (this.lH) {
            return;
        }
        bVar.a((Presenter) new com.kwad.components.ad.reward.presenter.a(this.vb), true);
        this.lH = true;
    }

    private void dk() {
        a((Presenter) new com.kwad.components.ad.fullscreen.c.c.b(), true);
    }

    private void dl() {
        AdInfo adInfoCZ = this.ly.cZ();
        if (!this.ly.lb) {
            a(this);
        }
        if (com.kwad.sdk.core.response.b.b.eB(adInfoCZ) && aq.isOrientationPortrait()) {
            com.kwad.components.ad.reward.presenter.e.a aVar = new com.kwad.components.ad.reward.presenter.e.a();
            this.lF = aVar;
            a((Presenter) aVar, true);
        }
    }

    private com.kwad.components.core.webview.tachikoma.f.g dm() {
        if (this.lE == null) {
            this.lE = new com.kwad.components.core.webview.tachikoma.f.g() { // from class: com.kwad.components.ad.fullscreen.c.b.1
                @Override // com.kwad.components.core.webview.tachikoma.f.g
                public final void a(String str, long j, long j2, long j3) {
                    b.this.vb.on = true;
                }

                @Override // com.kwad.components.core.webview.tachikoma.f.b
                public final void x(String str) {
                    if ("tk_fullscreen".equals(str) || "tk_live_video".equals(str)) {
                        b bVar = b.this;
                        bVar.a(bVar);
                        com.kwad.components.ad.reward.g.a(b.this.getContext(), b.this.vb, b.this.dn());
                        b.this.dh();
                        return;
                    }
                    if ("tk_image_video".equals(str)) {
                        b bVar2 = b.this;
                        bVar2.a(bVar2);
                        b.this.vb.a(RewardRenderResult.DEFAULT);
                        b.this.dh();
                    }
                }
            };
        }
        return this.lE;
    }

    public final boolean onBackPressed() {
        r rVar = this.lB;
        if (rVar != null && rVar.onBackPressed()) {
            return true;
        }
        com.kwad.components.ad.reward.presenter.e.a aVar = this.lF;
        if (aVar != null && aVar.hB() == BackPressHandleResult.HANDLED) {
            return true;
        }
        com.kwad.components.ad.reward.presenter.f.b bVar = this.lD;
        return bVar != null && bVar.hB() == BackPressHandleResult.HANDLED;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrameLayout dn() {
        if (this.lC == null) {
            this.lC = (FrameLayout) this.lz.findViewById(R.id.ksad_reward_play_layout);
        }
        return this.lC;
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.vb.b(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.vb.c(this);
        com.kwad.components.core.e.e.g.qh().b(this);
        com.kwad.components.core.webview.tachikoma.e.c.wq().b(this.lE);
    }

    @Override // com.kwad.components.ad.reward.e.g
    public final void dc() {
        this.vb.D(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(g gVar) {
        return getPriority() - gVar.getPriority();
    }

    @Override // com.kwad.components.core.e.e.f
    public final void show() {
        this.vb.gI();
        this.vb.E(true);
    }

    @Override // com.kwad.components.core.e.e.f
    public final void dismiss() {
        this.vb.E(false);
        this.vb.gH();
    }
}
