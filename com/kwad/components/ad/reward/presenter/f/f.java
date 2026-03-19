package com.kwad.components.ad.reward.presenter.f;

import android.text.TextUtils;
import android.widget.FrameLayout;
import com.kwad.components.ad.reward.e.j;
import com.kwad.components.ad.reward.e.n;
import com.kwad.components.ad.reward.k.l;
import com.kwad.components.ad.reward.page.BackPressHandleResult;
import com.kwad.components.core.j.a;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.p;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.b;
import com.kwad.components.core.webview.tachikoma.c.u;
import com.kwad.sdk.R;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.t;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class f extends a implements j, a.InterfaceC0474a {
    protected FrameLayout Bt;
    private List<com.kwad.components.core.j.c> dw;
    private com.kwad.components.core.webview.tachikoma.e pv;
    private boolean Bu = false;
    private final com.kwad.components.core.webview.tachikoma.f.a tF = new com.kwad.components.core.webview.tachikoma.f.a() { // from class: com.kwad.components.ad.reward.presenter.f.f.1
        @Override // com.kwad.components.core.webview.tachikoma.f.a
        public final void ko() {
            if (f.this.pv != null) {
                com.kwad.components.core.webview.tachikoma.c.a aVar = new com.kwad.components.core.webview.tachikoma.c.a();
                aVar.aiT = f.this.vb.kz ? 1 : 0;
                f.this.pv.b(aVar);
            }
        }
    };

    @Override // com.kwad.components.ad.reward.e.j
    public final void dq() {
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void g(AdTemplate adTemplate) {
    }

    public String getTKReaderScene() {
        return "tk_reward";
    }

    @Override // com.kwad.components.core.j.a.InterfaceC0474a
    public final void onError(int i, String str) {
    }

    @Override // com.kwad.components.core.j.a.InterfaceC0474a
    public final void onRequestResult(int i) {
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.Bt = (FrameLayout) findViewById(dz());
    }

    protected int dz() {
        return R.id.ksad_js_reward_card;
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        if (!this.Bu) {
            W(true);
        }
        this.vb.tJ = true ^ this.Bu;
        this.vb.a((a.InterfaceC0474a) this);
        com.kwad.components.ad.reward.a.gl().a(this);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.vb.b((a.InterfaceC0474a) this);
        com.kwad.components.ad.reward.a.gl().b(this);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
        if (aVar == null || com.kwad.sdk.core.response.b.e.c(this.vb.mAdResultData.getProceedTemplateList(), aVar.creativeId, aVar.adStyle)) {
            this.vb.tt.db();
            return;
        }
        if (aVar.adTemplate != null && !aVar.bMu) {
            this.vb.tt.db();
            return;
        }
        com.kwad.components.core.j.c cVarA = com.kwad.components.ad.reward.g.a(this.dw, aVar.creativeId);
        if (cVarA != null) {
            this.vb.a(cVarA);
        }
    }

    public final BackPressHandleResult hB() {
        if (this.Bx == null) {
            return BackPressHandleResult.NOT_HANDLED;
        }
        return this.Bx.hB();
    }

    private void W(boolean z) {
        com.kwad.sdk.core.d.c.d("TkRewardPagePresenter", "fullTK: " + z);
        FrameLayout frameLayout = this.Bt;
        if (frameLayout == null) {
            return;
        }
        frameLayout.setVisibility(z ? 0 : 8);
    }

    public String getTkTemplateId() {
        return com.kwad.sdk.core.response.b.b.ee(this.vb.mAdTemplate);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public FrameLayout getTKContainer() {
        return this.Bt;
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(TKRenderFailReason tKRenderFailReason) {
        super.a(tKRenderFailReason);
        com.kwad.components.ad.reward.monitor.b.a(this.mAdTemplate, tKRenderFailReason);
        com.kwad.sdk.core.d.c.d("TkRewardPagePresenter", "onTkLoadFailed");
        this.Bu = true;
        this.vb.tJ = false;
        W(false);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.a, com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(t tVar, com.kwad.sdk.core.webview.b bVar) {
        super.a(tVar, bVar);
        tVar.c(new com.kwad.components.ad.reward.c.f(new com.kwad.components.ad.reward.c.d() { // from class: com.kwad.components.ad.reward.presenter.f.f.2
            @Override // com.kwad.components.ad.reward.c.d
            public final void a(com.kwad.components.ad.reward.c.b bVar2) {
                com.kwad.sdk.core.d.c.d("TkRewardPagePresenter", "onUpdateExtraReward : " + bVar2.ic());
                f.this.a(bVar2);
            }
        }));
        this.pv = eJ();
        this.vb.a(this.tF);
        tVar.c(this.pv);
        tVar.c(new com.kwad.components.core.webview.tachikoma.b(new b.a() { // from class: com.kwad.components.ad.reward.presenter.f.f.3
            @Override // com.kwad.components.core.webview.tachikoma.b.a
            public final void eS() {
                com.kwad.components.ad.reward.model.b.L(f.this.vb.mContext);
            }
        }));
        tVar.c(eI());
        tVar.c(new com.kwad.components.core.webview.jshandler.j(new p() { // from class: com.kwad.components.ad.reward.presenter.f.f.4
            @Override // com.kwad.components.core.webview.jshandler.p
            public final void a(com.kwad.components.core.webview.jshandler.j jVar, String str) {
                if (TextUtils.equals(str, "autoCallApp")) {
                    jVar.ba(com.kwad.components.ad.reward.g.g(com.kwad.sdk.core.response.b.e.eP(f.this.vb.mAdTemplate)) && com.kwad.sdk.core.local.a.aai() && f.this.vb.mScreenOrientation == 0);
                }
            }
        }));
    }

    private com.kwad.components.core.webview.tachikoma.e eJ() {
        return new com.kwad.components.core.webview.tachikoma.e() { // from class: com.kwad.components.ad.reward.presenter.f.f.5
            @Override // com.kwad.components.core.webview.tachikoma.e, com.kwad.sdk.core.webview.c.a
            public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
                super.a(str, cVar);
                com.kwad.components.core.webview.tachikoma.c.a aVar = new com.kwad.components.core.webview.tachikoma.c.a();
                aVar.aiT = f.this.vb.kz ? 1 : 0;
                cVar.a(aVar);
            }
        };
    }

    private com.kwad.components.core.webview.tachikoma.c eI() {
        return new com.kwad.components.core.webview.tachikoma.c() { // from class: com.kwad.components.ad.reward.presenter.f.f.6
            @Override // com.kwad.components.core.webview.tachikoma.c, com.kwad.sdk.core.webview.c.a
            public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
                super.a(str, cVar);
                com.kwad.components.core.webview.tachikoma.c.c cVar2 = new com.kwad.components.core.webview.tachikoma.c.c();
                cVar2.aiV = com.kwad.components.ad.reward.model.b.dV();
                cVar.a(cVar2);
            }
        };
    }

    @Override // com.kwad.components.core.j.a.InterfaceC0474a
    public final void f(List<com.kwad.components.core.j.c> list) {
        if (list == null || list.size() == 0 || this.Bx == null) {
            return;
        }
        this.dw = list;
        List<AdTemplate> listA = a(list, this.vb.mAdTemplate);
        com.kwad.sdk.core.webview.b bVarVw = this.Bx.vw();
        if (bVarVw != null) {
            bVarVw.setAdTemplateList(listA);
        }
        l lVarKC = this.Bx.kC();
        if (lVarKC != null) {
            lVarKC.h(listA);
        } else {
            this.Bx.i(listA);
        }
    }

    private static List<AdTemplate> a(List<com.kwad.components.core.j.c> list, AdTemplate adTemplate) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(adTemplate);
        arrayList.addAll(com.kwad.components.core.j.c.p(list));
        return arrayList;
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void a(PlayableSource playableSource, n nVar) {
        FrameLayout frameLayout;
        if (this.Bu || (frameLayout = this.Bt) == null) {
            return;
        }
        frameLayout.setVisibility(8);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(u uVar) {
        com.kwad.sdk.core.d.c.d("TkRewardPagePresenter", "onSkipClick: " + uVar.adZ);
        if (this.vb != null && this.vb.tt != null) {
            this.vb.tt.onVideoSkipToEnd(uVar.adZ * 1000);
        }
        com.kwad.components.ad.reward.presenter.f.u(this.vb);
        com.kwad.components.ad.reward.g.a(this.vb.tB, new com.kwad.sdk.g.a<com.kwad.components.ad.reward.k.a>() { // from class: com.kwad.components.ad.reward.presenter.f.f.7
            @Override // com.kwad.sdk.g.a
            public final /* synthetic */ void accept(com.kwad.components.ad.reward.k.a aVar) {
                c(aVar);
            }

            private static void c(com.kwad.components.ad.reward.k.a aVar) {
                aVar.jZ();
            }
        });
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(WebCloseStatus webCloseStatus) {
        super.a(webCloseStatus);
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void dp() {
        FrameLayout frameLayout;
        if (this.Bu || (frameLayout = this.Bt) == null) {
            return;
        }
        frameLayout.setVisibility(0);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.a, com.kwad.components.core.webview.tachikoma.j
    public final void a(ae.a aVar) {
        float height;
        float width;
        float fBv = com.kwad.sdk.c.a.a.bv(getContext());
        FrameLayout frameLayout = this.Bt;
        if (frameLayout != null) {
            height = frameLayout.getHeight();
            width = this.Bt.getWidth();
        } else {
            height = 0.0f;
            width = 0.0f;
        }
        if (height == 0.0f || width == 0.0f) {
            super.a(aVar);
        } else {
            aVar.width = (int) ((width / fBv) + 0.5f);
            aVar.height = (int) ((height / fBv) + 0.5f);
        }
    }
}
