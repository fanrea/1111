package com.kwad.components.ad.reward.presenter.h;

import android.content.DialogInterface;
import com.kwad.components.ad.reward.g;
import com.kwad.components.ad.reward.k.a.d;
import com.kwad.components.ad.reward.presenter.f.g;
import com.kwad.components.core.n.a.b;
import com.kwad.components.core.video.o;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.ba;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.b.p;
import com.kwad.components.core.webview.tachikoma.c.n;
import com.kwad.components.core.webview.tachikoma.c.u;
import com.kwad.components.core.webview.tachikoma.c.w;
import com.kwad.components.core.webview.tachikoma.f;
import com.kwad.components.core.webview.tachikoma.j;
import com.kwad.sdk.R;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.t;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.utils.as;
import com.kwad.sdk.utils.bs;
import com.kwad.sdk.utils.bx;
import com.kwad.sdk.widget.i;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends g implements j {
    private d Bx;
    private boolean Cj;
    private f Ck;
    private long Cl;
    private AdInfo mAdInfo;
    private boolean yV;
    private boolean yW;
    private g.b yX = new g.b() { // from class: com.kwad.components.ad.reward.presenter.h.a.1
        @Override // com.kwad.components.ad.reward.g.b
        public final boolean interceptPlayCardResume() {
            return a.this.BP != null && a.this.BP.getVisibility() == 0;
        }
    };
    private final com.kwad.components.core.n.a.a xA = new b() { // from class: com.kwad.components.ad.reward.presenter.h.a.2
        @Override // com.kwad.components.core.n.a.b, com.kwad.components.core.n.a.a
        public final void d(com.kwad.components.core.proxy.f fVar) {
            super.d(fVar);
            a.this.Cj = true;
        }

        @Override // com.kwad.components.core.n.a.b, com.kwad.components.core.n.a.a
        public final void c(com.kwad.components.core.proxy.f fVar) {
            a.this.Cj = false;
            if (a.this.Ck == null) {
                return;
            }
            w wVar = new w();
            if (com.kwad.components.core.s.a.sX().td()) {
                com.kwad.components.core.s.a.sX().aR(false);
                if (com.kwad.sdk.core.response.b.a.aR(a.this.mAdInfo) == 0) {
                    wVar.ajl = 1;
                    a.this.Ck.b(wVar);
                    return;
                } else if (com.kwad.components.core.s.a.sX().sZ()) {
                    wVar.ajl = 1;
                    a.this.Ck.b(wVar);
                    return;
                } else {
                    wVar.ajl = 0;
                    a.this.Ck.b(wVar);
                    return;
                }
            }
            if (com.kwad.components.core.s.a.sX().tb() && com.kwad.sdk.core.response.b.a.aR(a.this.mAdInfo) == 1) {
                if (com.kwad.components.core.s.a.sX().tc() == 1) {
                    if (as.aE(a.this.getContext(), com.kwad.sdk.core.response.b.a.aB(a.this.mAdInfo))) {
                        wVar.ajl = 2;
                        com.kwad.components.core.s.a.sX().bd(2);
                        a.this.Ck.b(wVar);
                        return;
                    } else {
                        wVar.ajl = 0;
                        a.this.Ck.b(wVar);
                        return;
                    }
                }
                if (com.kwad.components.core.s.a.sX().tc() == 3) {
                    wVar.ajl = 1;
                    com.kwad.components.core.s.a.sX().bd(0);
                    a.this.Ck.b(wVar);
                }
            }
        }
    };
    private final o lv = new o() { // from class: com.kwad.components.ad.reward.presenter.h.a.3
        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayProgress(long j, long j2) {
            super.onMediaPlayProgress(j, j2);
            long jA = com.kwad.components.ad.reward.g.a(j, a.this.mAdInfo);
            long jAQ = com.kwad.sdk.core.response.b.a.aQ(a.this.mAdInfo) * 1000;
            if (j2 <= a.this.Cl || jA - j2 <= jAQ || a.this.yV) {
                return;
            }
            if (com.kwad.sdk.core.response.b.a.aR(a.this.mAdInfo) == 1) {
                if (as.aE(a.this.getContext(), com.kwad.sdk.core.response.b.a.aB(a.this.mAdInfo))) {
                    return;
                }
            } else if (a.this.vb.kz) {
                return;
            }
            a.b(a.this, true);
            a.this.Bx.a(a.this.vb.getActivity(), a.this.vb.mAdResultData, a.this);
            a.this.ks();
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
    public final void aF() {
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void g(AdTemplate adTemplate) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTKReaderScene() {
        return "tk_reward_task_card";
    }

    static /* synthetic */ boolean b(a aVar, boolean z) {
        aVar.yV = true;
        return true;
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        getContext();
        if (aq.apb()) {
            this.Cj = false;
            c.d("TkRewardVideoTaskPresenter", "onBind: ");
            if (this.Bx == null) {
                this.Bx = new d(this.vb, -1L, getContext(), new DialogInterface.OnDismissListener() { // from class: com.kwad.components.ad.reward.presenter.h.a.4
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        if (a.this.Ck == null) {
                            return;
                        }
                        w wVar = new w();
                        if (com.kwad.components.core.s.a.sX().td()) {
                            com.kwad.components.core.s.a.sX().aR(false);
                            if (com.kwad.sdk.core.response.b.a.aR(a.this.mAdInfo) == 0) {
                                wVar.ajl = 1;
                                a.this.Ck.b(wVar);
                                return;
                            } else if (com.kwad.components.core.s.a.sX().sZ()) {
                                wVar.ajl = 1;
                                a.this.Ck.b(wVar);
                                return;
                            } else {
                                wVar.ajl = 0;
                                a.this.Ck.b(wVar);
                                return;
                            }
                        }
                        if (com.kwad.components.core.s.a.sX().tb() && com.kwad.sdk.core.response.b.a.aR(a.this.mAdInfo) == 1) {
                            if (com.kwad.components.core.s.a.sX().tc() == 1) {
                                if (as.aE(a.this.getContext(), com.kwad.sdk.core.response.b.a.aB(a.this.mAdInfo))) {
                                    return;
                                }
                                wVar.ajl = 0;
                                a.this.Ck.b(wVar);
                                return;
                            }
                            if (com.kwad.components.core.s.a.sX().tc() == 3) {
                                wVar.ajl = 1;
                                com.kwad.components.core.s.a.sX().bd(0);
                                a.this.Ck.b(wVar);
                            }
                        }
                    }
                });
            }
            this.mAdInfo = e.eP(this.vb.mAdTemplate);
            this.Cl = com.kwad.sdk.core.response.b.a.aP(r0) * 1000;
            if (this.vb.tu != null) {
                this.vb.tu.a(this.lv);
            }
            this.vb.a(this.yX);
            this.vb.Th.add(this.xA);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        if (this.vb.tu != null) {
            this.vb.tu.b(this.lv);
        }
        this.vb.b(this.yX);
        this.vb.Th.remove(this.xA);
        d dVar = this.Bx;
        if (dVar != null) {
            dVar.kD();
            this.Bx = null;
        }
        this.BP.setVisibility(8);
        com.kwad.components.core.s.a.sX().clear();
        this.yV = false;
        this.yW = false;
        this.Cj = false;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTkTemplateId() {
        return com.kwad.sdk.core.response.b.b.ei(this.vb.mAdTemplate);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final i getTouchCoordsView() {
        return this.vb.mRootContainer;
    }

    @Override // com.kwad.components.ad.reward.presenter.f.g
    public final int jb() {
        return R.id.ksad_js_task;
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(TKRenderFailReason tKRenderFailReason) {
        c.d("TkRewardVideoTaskPresenter", "onTkLoadFailed: ");
        this.BP.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ks() {
        this.BP.setVisibility(0);
        if (this.vb.tu != null) {
            this.vb.tu.pause();
        }
        this.yW = true;
    }

    private f kt() {
        return new f() { // from class: com.kwad.components.ad.reward.presenter.h.a.5
            @Override // com.kwad.components.core.webview.tachikoma.b.w, com.kwad.sdk.core.webview.c.a
            public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
                super.a(str, cVar);
            }
        };
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(t tVar, com.kwad.sdk.core.webview.b bVar) {
        f fVarKt = kt();
        this.Ck = fVarKt;
        tVar.c(fVarKt);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
        this.vb.tt.db();
        c.d("jky", "onAdClicked convertPageType: " + aVar.bMr);
        if (com.kwad.sdk.core.response.b.a.aS(this.mAdInfo)) {
            com.kwad.components.core.s.a.sX().bc(aVar.bMr);
            if (aVar.bMr == -1) {
                com.kwad.components.core.s.a.sX().aR(false);
                com.kwad.components.core.s.a.sX().bd(0);
            } else {
                if (com.kwad.sdk.core.response.b.a.aJ(this.mAdInfo)) {
                    if (com.kwad.components.core.s.a.sX().tc() == 2) {
                        com.kwad.components.core.s.a.sX().bd(3);
                        return;
                    } else {
                        com.kwad.components.core.s.a.sX().bd(1);
                        return;
                    }
                }
                com.kwad.components.core.s.a.sX().aR(true);
            }
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(ae.a aVar) {
        float fBv = com.kwad.sdk.c.a.a.bv(getContext());
        aVar.width = (int) ((bs.getScreenWidth(getContext()) / fBv) + 0.5f);
        aVar.height = (int) ((bs.getScreenHeight(getContext()) / fBv) + 0.5f);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(WebCloseStatus webCloseStatus) {
        boolean z = false;
        this.vb.tL = webCloseStatus != null && webCloseStatus.interactSuccess;
        int iSY = com.kwad.components.core.s.a.sX().sY();
        if (this.vb.tu != null) {
            if (this.vb.tL) {
                this.vb.tu.kX();
                if (iSY == 1) {
                    iL();
                    z = true;
                }
            }
            if (this.yW && !this.Cj && !z) {
                this.vb.tu.resume();
            }
        }
        this.BP.setVisibility(8);
    }

    private void iL() {
        boolean z = com.kwad.components.ad.reward.presenter.i.z(this.vb);
        c.d("jky", "onPlayCompleted: " + z);
        if (z) {
            bx.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.h.a.6
                @Override // java.lang.Runnable
                public final void run() {
                    if (a.this.vb.tt != null) {
                        a.this.vb.tt.onRewardVerify();
                    }
                    a.this.vb.tu.pause();
                    a.this.vb.gO();
                }
            }, 200L);
            return;
        }
        if (this.vb.tt != null) {
            this.vb.tt.onRewardVerify();
        }
        this.vb.tu.pause();
        this.vb.gO();
    }
}
