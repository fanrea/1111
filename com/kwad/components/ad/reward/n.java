package com.kwad.components.ad.reward;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.kwad.components.ad.reward.page.BackPressHandleResult;
import com.kwad.components.ad.reward.presenter.r;
import com.kwad.components.ad.reward.presenter.t;
import com.kwad.components.ad.reward.presenter.u;
import com.kwad.components.ad.reward.presenter.v;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdGlobalConfigInfo;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.aq;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class n extends com.kwad.components.ad.reward.presenter.b implements com.kwad.components.ad.reward.e.g, com.kwad.components.core.e.e.f {
    private com.kwad.components.core.n.b lA;
    private r lB;
    private FrameLayout lC;
    private com.kwad.components.ad.reward.presenter.f.b lD;
    private com.kwad.components.ad.reward.presenter.e.a lF;
    private com.kwad.components.ad.reward.presenter.f.f lG;
    private ViewGroup lz;
    private Context mContext;
    private com.kwad.components.ad.reward.model.c mModel;
    private g vb;
    private a vc;
    private boolean lH = false;
    private com.kwad.components.core.webview.tachikoma.f.g oh = new com.kwad.components.core.webview.tachikoma.f.g() { // from class: com.kwad.components.ad.reward.n.1
        @Override // com.kwad.components.core.webview.tachikoma.f.g
        public final void a(String str, long j, long j2, long j3) {
            n.this.vb.on = true;
        }

        @Override // com.kwad.components.core.webview.tachikoma.f.b
        public final void x(String str) {
            if ("tk_reward".equals(str) || "tk_live_video".equals(str)) {
                n nVar = n.this;
                nVar.a(nVar);
                g.a(n.this.getContext(), n.this.vb, n.this.dn());
                n.this.vb.a(RewardRenderResult.DEFAULT);
                n nVar2 = n.this;
                nVar2.a(nVar2.lA, n.this.mModel);
                return;
            }
            if ("tk_image_video".equals(str)) {
                n nVar3 = n.this;
                nVar3.a(nVar3);
                n.this.vb.a(RewardRenderResult.DEFAULT);
                n nVar4 = n.this;
                nVar4.a(nVar4.lA, n.this.mModel);
            }
        }
    };

    public interface a {
        void onUnbind();
    }

    @Override // com.kwad.components.ad.reward.e.g
    public final int getPriority() {
        return 0;
    }

    public n(com.kwad.components.core.n.b bVar, Context context, ViewGroup viewGroup, com.kwad.components.ad.reward.model.c cVar, g gVar) {
        boolean z = false;
        this.mContext = context;
        this.lz = viewGroup;
        this.mModel = cVar;
        this.vb = gVar;
        this.lA = bVar;
        a(cVar);
        AdInfo adInfoCZ = cVar.cZ();
        boolean zEE = com.kwad.sdk.core.response.b.b.eE(adInfoCZ);
        boolean z2 = (com.kwad.sdk.core.response.b.a.df(adInfoCZ) && a(this.vb.mAdResultData.adGlobalConfigInfo)) || com.kwad.sdk.core.response.b.a.bj(adInfoCZ) || g.Q(cVar.getAdTemplate());
        if (com.kwad.sdk.core.response.b.a.dq(adInfoCZ) && a(this.vb.mAdResultData.adGlobalConfigInfo)) {
            z = true;
        }
        com.kwad.sdk.core.d.c.d("RewardPresenter", "notFullTk: " + z2 + ", mLoadStrategy: " + this.vb.un);
        if (z) {
            com.kwad.components.core.webview.tachikoma.e.c.wq().a(this.oh);
            gVar.a(RewardRenderResult.LIVE_TK);
            di();
        } else if (zEE) {
            com.kwad.components.core.webview.tachikoma.e.c.wq().a(this.oh);
            gVar.a(RewardRenderResult.TK_IMAGE);
            dj();
        } else if (!z2 && this.vb.un.equals(LoadStrategy.FULL_TK)) {
            com.kwad.components.core.webview.tachikoma.e.c.wq().a(this.oh);
            gVar.a(RewardRenderResult.NEO_TK);
            hA();
        } else {
            gVar.a(RewardRenderResult.DEFAULT);
            a(bVar, cVar);
        }
    }

    private static boolean a(AdGlobalConfigInfo adGlobalConfigInfo) {
        return adGlobalConfigInfo == null || adGlobalConfigInfo.neoPageType != 1;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.lC = (FrameLayout) this.lz.findViewById(R.id.ksad_reward_play_layout);
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
        com.kwad.components.ad.reward.c.a.hZ().setCallerContext(this.vb);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.vb.c(this);
        a aVar = this.vc;
        if (aVar != null) {
            aVar.onUnbind();
        }
        com.kwad.components.core.e.e.g.qh().b(this);
        com.kwad.components.ad.reward.c.a.hZ().reset();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        this.lA = null;
        com.kwad.components.core.webview.tachikoma.e.c.wq().b(this.oh);
    }

    private void hA() {
        com.kwad.components.ad.reward.presenter.f.f fVar = new com.kwad.components.ad.reward.presenter.f.f();
        this.lG = fVar;
        d(fVar);
    }

    private void dj() {
        com.kwad.components.ad.reward.presenter.f.c cVar = new com.kwad.components.ad.reward.presenter.f.c();
        this.lG = cVar;
        d(cVar);
    }

    private void di() {
        com.kwad.components.ad.reward.presenter.f.b bVar = new com.kwad.components.ad.reward.presenter.f.b();
        this.lD = bVar;
        d(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(n nVar) {
        if (this.lH) {
            return;
        }
        nVar.a((Presenter) new com.kwad.components.ad.reward.presenter.a(this.vb), true);
        this.lH = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.kwad.components.core.n.b bVar, com.kwad.components.ad.reward.model.c cVar) {
        if (this.mModel == null) {
            return;
        }
        com.kwad.components.core.e.e.g.qh().a(this);
        AdInfo adInfoCZ = this.mModel.cZ();
        AdTemplate adTemplate = this.mModel.getAdTemplate();
        if (cVar.lb) {
            a(this);
        }
        a(new v(), true);
        if (com.kwad.sdk.core.response.b.a.aT(adInfoCZ)) {
            a(new com.kwad.components.ad.reward.presenter.d(), true);
        }
        a(new com.kwad.components.ad.reward.presenter.m(), true);
        a(new com.kwad.components.ad.reward.presenter.h(), true);
        a(new com.kwad.components.ad.reward.presenter.platdetail.c(), true);
        a(new com.kwad.components.ad.reward.presenter.platdetail.a.e(), true);
        boolean zIw = cVar.iw();
        boolean zIx = cVar.ix();
        boolean z = cVar.da() && !aq.isOrientationPortrait();
        if (!zIw && !zIx && !z) {
            a(new com.kwad.components.ad.reward.presenter.platdetail.actionbar.c(), true);
        }
        a(new com.kwad.components.ad.reward.presenter.n(), true);
        a(new com.kwad.components.ad.reward.presenter.c(adInfoCZ), true);
        a(new com.kwad.components.ad.reward.presenter.d.b(adTemplate, true), true);
        a(new com.kwad.components.ad.reward.presenter.c.a(), true);
        a(new u(), true);
        a(new com.kwad.components.ad.reward.presenter.e(adInfoCZ, this.lz), true);
        r rVar = new r(adTemplate);
        this.lB = rVar;
        a((Presenter) rVar, true);
        a(new com.kwad.components.ad.reward.presenter.l(), true);
        if (this.vb.tI && com.kwad.components.ad.reward.d.a.b(this.vb.mContext, com.kwad.sdk.core.response.b.e.eP(adTemplate))) {
            a(new com.kwad.components.ad.reward.presenter.a.a(), true);
        }
        if (com.kwad.sdk.core.response.b.b.dZ(adTemplate)) {
            a(new t(), true);
        }
        if (com.kwad.sdk.core.response.b.a.bj(adInfoCZ)) {
            a(new com.kwad.components.ad.reward.presenter.platdetail.b(), true);
        }
        if (com.kwad.sdk.core.response.b.a.df(adInfoCZ)) {
            a(new com.kwad.components.ad.reward.presenter.b.c(), true);
            a(new com.kwad.components.ad.reward.presenter.b.a(), true);
            a(new com.kwad.components.ad.reward.presenter.b.b(), true);
            a(new com.kwad.components.ad.reward.presenter.k(), true);
        }
        a(new com.kwad.components.ad.reward.presenter.j(), true);
    }

    private void a(com.kwad.components.ad.reward.model.c cVar) {
        AdInfo adInfoCZ = cVar.cZ();
        if (!cVar.lb) {
            a(this);
        }
        if (g.g(adInfoCZ)) {
            d(new com.kwad.components.ad.reward.presenter.g());
        }
        if (com.kwad.sdk.core.response.b.a.aS(adInfoCZ) && aq.apb()) {
            d(new com.kwad.components.ad.reward.presenter.h.a());
        }
        if (com.kwad.sdk.core.response.b.b.dO(adInfoCZ)) {
            d(new com.kwad.components.ad.reward.presenter.f.h());
        }
        if (com.kwad.sdk.core.response.b.b.eB(adInfoCZ) && aq.isOrientationPortrait()) {
            com.kwad.components.ad.reward.presenter.e.a aVar = new com.kwad.components.ad.reward.presenter.e.a();
            this.lF = aVar;
            d(aVar);
        }
    }

    public final void a(a aVar) {
        this.vc = aVar;
    }

    public final BackPressHandleResult hB() {
        r rVar = this.lB;
        if (rVar != null && rVar.onBackPressed()) {
            return BackPressHandleResult.HANDLED;
        }
        com.kwad.components.ad.reward.presenter.e.a aVar = this.lF;
        if (aVar != null && aVar.hB() == BackPressHandleResult.HANDLED) {
            return BackPressHandleResult.HANDLED;
        }
        com.kwad.components.ad.reward.presenter.f.b bVar = this.lD;
        if (bVar != null) {
            return bVar.hB();
        }
        com.kwad.components.ad.reward.presenter.f.f fVar = this.lG;
        if (fVar != null) {
            return fVar.hB();
        }
        return BackPressHandleResult.NOT_HANDLED;
    }

    @Override // com.kwad.components.ad.reward.e.g
    public final void dc() {
        this.vb.D(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(com.kwad.components.ad.reward.e.g gVar) {
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
