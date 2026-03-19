package com.kwad.components.ad.reward.presenter.f;

import android.content.DialogInterface;
import com.kwad.components.ad.reward.RewardRenderResult;
import com.kwad.components.ad.reward.e.l;
import com.kwad.components.ad.reward.k.d;
import com.kwad.components.ad.reward.k.e;
import com.kwad.components.ad.reward.k.h;
import com.kwad.components.ad.reward.k.i;
import com.kwad.components.ad.reward.k.j;
import com.kwad.components.ad.reward.k.k;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.u.m;
import com.kwad.components.core.webview.jshandler.a;
import com.kwad.components.core.webview.jshandler.ai;
import com.kwad.components.core.webview.jshandler.al;
import com.kwad.components.core.webview.jshandler.ba;
import com.kwad.components.core.webview.jshandler.bm;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.b.h;
import com.kwad.components.core.webview.tachikoma.b.o;
import com.kwad.components.core.webview.tachikoma.b.p;
import com.kwad.components.core.webview.tachikoma.b.y;
import com.kwad.components.core.webview.tachikoma.c.n;
import com.kwad.components.core.webview.tachikoma.c.q;
import com.kwad.components.core.webview.tachikoma.c.r;
import com.kwad.components.core.webview.tachikoma.c.u;
import com.kwad.components.core.webview.tachikoma.c.z;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.t;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.TKAdLiveShopItemInfo;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.bx;
import com.kwad.sdk.utils.i;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public abstract class d extends com.kwad.components.ad.reward.presenter.b implements DialogInterface.OnDismissListener, com.kwad.components.ad.reward.k.a.e, y.a {
    private i BA;
    private j BB;
    private z BC;
    private boolean BD;
    private com.kwad.components.core.webview.tachikoma.b.h BE;
    protected e BF;
    protected com.kwad.components.ad.reward.k.a.d Bx;
    private p By;
    private o Bz;
    private bm.b BG = new bm.b() { // from class: com.kwad.components.ad.reward.presenter.f.d.1
        @Override // com.kwad.components.core.webview.jshandler.bm.b
        public final void ae(int i) {
            com.kwad.sdk.core.adlog.c.b bVarF = new com.kwad.sdk.core.adlog.c.b().eP(i).f(d.this.vb.mRootContainer.getTouchCoords());
            com.kwad.components.core.e.d.a.a(new a.C0469a(d.this.getContext()).aC(d.this.vb.mAdTemplate).b(d.this.vb.mApkDownloadHelper).aq(false));
            com.kwad.components.ad.reward.j.b.a(d.this.vb.mAdTemplate, d.this.kj(), (String) null, bVarF, (JSONObject) null);
        }
    };
    private final i.a lW = new i.a() { // from class: com.kwad.components.ad.reward.presenter.f.d.5
        @Override // com.kwad.sdk.utils.i.a
        public final void onAudioBeReleased() {
        }

        @Override // com.kwad.sdk.utils.i.a
        public final void onAudioBeOccupied() {
            if (d.this.Bz == null || com.kwad.components.ad.reward.a.b.hG()) {
                return;
            }
            n nVar = new n();
            nVar.ajg = true;
            d.this.Bz.c(nVar);
        }
    };
    private final l mRewardVerifyListener = new l() { // from class: com.kwad.components.ad.reward.presenter.f.d.6
        @Override // com.kwad.components.ad.reward.e.l
        public final void onRewardVerify() {
            if (d.this.BA != null) {
                com.kwad.components.core.webview.tachikoma.c.h hVar = new com.kwad.components.core.webview.tachikoma.c.h();
                hVar.aiY = 1;
                d.this.BA.a(hVar);
            }
        }
    };
    private final com.kwad.components.ad.reward.e.g mPlayEndPageListener = new com.kwad.components.ad.reward.e.a() { // from class: com.kwad.components.ad.reward.presenter.f.d.7
        @Override // com.kwad.components.ad.reward.e.g
        public final void dc() {
            if (d.this.BB != null) {
                bx.runOnUiThreadDelay(new bh() { // from class: com.kwad.components.ad.reward.presenter.f.d.7.1
                    @Override // com.kwad.sdk.utils.bh
                    public final void doTask() {
                        com.kwad.components.core.webview.tachikoma.c.p pVar = new com.kwad.components.core.webview.tachikoma.c.p();
                        pVar.scene = 1;
                        d.this.BB.a(pVar);
                        if (d.this.BE != null) {
                            d.this.BE.be(d.this.vb.um);
                        }
                    }
                }, 0L);
            }
        }
    };
    private final com.kwad.components.core.video.o lv = new com.kwad.components.core.video.o() { // from class: com.kwad.components.ad.reward.presenter.f.d.8
        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPreparing() {
            d.this.j(0.0d);
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayProgress(long j, long j2) {
            d.this.a(j, j2);
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayStart() {
            d.this.j(0.0d);
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayCompleted() {
            d.this.iL();
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayError(int i, int i2) {
            d.this.kh();
        }
    };

    public void a(WebCloseStatus webCloseStatus) {
    }

    public void aF() {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void aG() {
    }

    public void g(AdTemplate adTemplate) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public String getRegisterViewKey() {
        return null;
    }

    protected boolean ka() {
        return false;
    }

    public d() {
        if (ka()) {
            this.BF = new e();
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public void ay() {
        super.ay();
        this.BD = true;
        this.vb.a(this);
        if (this.Bx == null) {
            this.Bx = new com.kwad.components.ad.reward.k.a.d(this.vb, -1L, getContext());
        }
        if (this.BC == null) {
            this.BC = new z();
        }
        this.Bx.a(this.vb.getActivity(), this.vb.mAdResultData, this);
        e eVar = this.BF;
        if (eVar != null) {
            eVar.A(this.vb);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void onUnbind() {
        super.onUnbind();
        if (this.BD) {
            e eVar = this.BF;
            if (eVar != null) {
                eVar.B(this.vb);
            }
            this.vb.b(this);
            com.kwad.components.ad.reward.k.a.d dVar = this.Bx;
            if (dVar != null) {
                dVar.kD();
            }
            if (this.vb.tu != null) {
                this.vb.tu.b(this.lv);
                this.vb.tu.b(this.lW);
            }
            com.kwad.components.ad.reward.b.gp().b(this.mRewardVerifyListener);
            this.vb.c(this.mPlayEndPageListener);
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        com.kwad.components.ad.reward.k.a.d dVar = this.Bx;
        if (dVar == null || dVar.kB() == null) {
            return;
        }
        this.Bx.kB().ie();
    }

    public com.kwad.sdk.widget.i getTouchCoordsView() {
        return this.vb.mRootContainer;
    }

    public void a(t tVar, com.kwad.sdk.core.webview.b bVar) {
        k kVar = new k();
        kVar.a(new k.a() { // from class: com.kwad.components.ad.reward.presenter.f.d.9
            @Override // com.kwad.components.ad.reward.k.k.a
            public final void d(r rVar) {
                com.kwad.components.ad.reward.c.gs().c(rVar);
            }
        });
        tVar.c(kVar);
        long j = this.vb.ug;
        tVar.c(new com.kwad.components.ad.reward.k.g(j > 0 ? ((int) j) / 1000 : 0));
        com.kwad.components.ad.reward.k.i iVar = new com.kwad.components.ad.reward.k.i();
        this.BA = iVar;
        tVar.c(iVar);
        j jVar = new j();
        this.BB = jVar;
        tVar.c(jVar);
        com.kwad.components.ad.reward.b.gp().a(this.mRewardVerifyListener);
        this.vb.b(this.mPlayEndPageListener);
        tVar.c(new al(new al.b() { // from class: com.kwad.components.ad.reward.presenter.f.d.10
            @Override // com.kwad.components.core.webview.jshandler.al.b
            public final void a(al.a aVar) {
                d.this.getTKContainer().setVisibility(8);
            }
        }));
        com.kwad.components.ad.reward.k.d dVar = new com.kwad.components.ad.reward.k.d();
        dVar.a(new d.a() { // from class: com.kwad.components.ad.reward.presenter.f.d.11
            @Override // com.kwad.components.ad.reward.k.d.a
            public final void a(final q qVar) {
                com.kwad.components.core.e.d.a.a(new a.C0469a(d.this.getContext()).aC(d.this.vb.mAdTemplate).b(d.this.vb.mApkDownloadHelper).aG(1).a(new a.b() { // from class: com.kwad.components.ad.reward.presenter.f.d.11.1
                    @Override // com.kwad.components.core.e.d.a.b
                    public final void onAdClicked() {
                        if (qVar.aji) {
                            d.this.kd();
                        } else {
                            d.this.ke();
                        }
                    }
                }));
            }
        });
        tVar.c(dVar);
        com.kwad.components.ad.reward.k.e eVar = new com.kwad.components.ad.reward.k.e();
        eVar.a(new e.a() { // from class: com.kwad.components.ad.reward.presenter.f.d.12
            @Override // com.kwad.components.ad.reward.k.e.a
            public final void kk() {
                com.kwad.components.core.e.d.a.a(new a.C0469a(d.this.getContext()).aC(d.this.vb.mAdTemplate).b(d.this.vb.mApkDownloadHelper).aG(2).a(new a.b() { // from class: com.kwad.components.ad.reward.presenter.f.d.12.1
                    @Override // com.kwad.components.core.e.d.a.b
                    public final void onAdClicked() {
                        d.this.kf();
                    }
                }));
            }
        });
        tVar.c(eVar);
        tVar.c(new com.kwad.components.ad.reward.k.h(new h.a() { // from class: com.kwad.components.ad.reward.presenter.f.d.13
            @Override // com.kwad.components.ad.reward.k.h.a
            public final void af(int i) {
                if (com.kwad.components.ad.reward.g.Q(d.this.vb.mAdTemplate)) {
                    if (!com.kwad.components.ad.reward.g.O(d.this.vb.mAdTemplate) || d.this.vb.uc == null) {
                        if (com.kwad.components.ad.reward.g.P(d.this.vb.mAdTemplate) && d.this.vb.ud != null && !d.this.vb.ud.kP()) {
                            d.this.vb.ud.kO();
                        }
                    } else if (!d.this.vb.uc.kP()) {
                        d.this.vb.uc.kO();
                    }
                }
                if (d.this.vb.gW() != RewardRenderResult.DEFAULT) {
                    d.this.vb.tS = i;
                }
                d.this.notifyRewardVerify();
            }
        }));
        tVar.c(new com.kwad.components.ad.reward.k.c() { // from class: com.kwad.components.ad.reward.presenter.f.d.14
            @Override // com.kwad.components.ad.reward.k.c
            public final void kl() {
                super.kl();
                d.this.kc();
            }
        });
        tVar.c(new com.kwad.components.ad.reward.k.f() { // from class: com.kwad.components.ad.reward.presenter.f.d.15
            @Override // com.kwad.components.ad.reward.k.f
            public final void V(boolean z) {
                super.V(z);
                com.kwad.components.ad.reward.presenter.f.v(d.this.vb);
            }
        });
        tVar.c(new com.kwad.components.ad.reward.k.b() { // from class: com.kwad.components.ad.reward.presenter.f.d.16
            @Override // com.kwad.components.ad.reward.k.b
            public final void kl() {
                super.kl();
                d.this.kb();
            }
        });
        tVar.c(new com.kwad.components.core.webview.tachikoma.b.q() { // from class: com.kwad.components.ad.reward.presenter.f.d.2
            @Override // com.kwad.components.core.webview.tachikoma.b.q, com.kwad.sdk.core.webview.c.a
            public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
                super.a(str, cVar);
                m.f(d.this.getContext(), d.this.vb.mAdTemplate);
            }
        });
        tVar.c(new com.kwad.components.ad.reward.i.b(getContext(), this.vb.mAdTemplate, PlayableSource.ACTIONBAR_CLICK));
        com.kwad.components.core.webview.tachikoma.b.h hVar = new com.kwad.components.core.webview.tachikoma.b.h();
        this.BE = hVar;
        hVar.a(new h.a() { // from class: com.kwad.components.ad.reward.presenter.f.d.3
            @Override // com.kwad.components.core.webview.tachikoma.b.h.a
            public final void a(com.kwad.components.core.webview.tachikoma.b.h hVar2) {
                hVar2.be(d.this.vb.um);
            }
        });
        tVar.c(this.BE);
        tVar.c(new ai());
        tVar.c(new bm(bVar, this.vb.mApkDownloadHelper, this.BG));
        tVar.c(new y(this));
    }

    public void a(p pVar) {
        this.By = pVar;
        if (this.vb.tu != null) {
            this.vb.tu.a(this.lv);
        }
    }

    public void a(u uVar) {
        com.kwad.components.ad.reward.presenter.f.a(this.vb, false);
    }

    public void aE() {
        e eVar = this.BF;
        if (eVar != null) {
            eVar.aE();
        }
    }

    public void a(TKRenderFailReason tKRenderFailReason) {
        e eVar = this.BF;
        if (eVar != null) {
            eVar.kn();
        }
    }

    public void a(ba baVar) {
        e eVar = this.BF;
        if (eVar != null) {
            eVar.b(baVar);
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(a.C0490a c0490a) {
        a.c cVar;
        if (this.vb == null || this.vb.tt == null) {
            return;
        }
        try {
            cVar = new a.c();
            cVar.parseJson(new JSONObject(c0490a.adX));
            switch (c0490a.adW) {
                case "adClickCallback":
                    this.vb.tt.db();
                    break;
                case "videoPlayStartCallback":
                    this.vb.tt.onVideoPlayStart();
                    break;
                case "videoPlayErrorCallback":
                    this.vb.tt.onVideoPlayError(cVar.errorCode, cVar.adY);
                    break;
                case "videoPlayEndCallback":
                    this.vb.tt.onVideoPlayEnd();
                    break;
                case "adSkipWithPlayTimeCallback":
                    this.vb.tt.onVideoSkipToEnd(cVar.adZ);
                    break;
                case "adCloseCallback":
                    this.vb.tt.i(cVar.aea);
                    break;
                case "rewardVerifyCallback":
                    this.vb.tt.onRewardVerify();
                    break;
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.e("TKBasePresenter", "onOutCallback Error: " + th.getMessage());
        }
    }

    public void a(n nVar) {
        if (this.vb.tu != null) {
            this.vb.tu.setAudioEnabled(!nVar.ajg, true);
        }
    }

    public void a(com.kwad.sdk.core.webview.d.b.a aVar) {
        this.vb.tt.db();
    }

    public final void a(com.kwad.components.ad.reward.c.b bVar) {
        if (this.vb != null) {
            this.vb.b(bVar);
        }
    }

    public void a(o oVar) {
        this.Bz = oVar;
        if (this.vb.tu != null) {
            this.vb.tu.a(this.lW);
        }
        bx.runOnUiThread(new bh() { // from class: com.kwad.components.ad.reward.presenter.f.d.4
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                boolean z = com.kwad.components.core.u.a.aC(d.this.getContext()).to() || !d.this.vb.mVideoPlayConfig.isVideoSoundEnable();
                n nVar = new n();
                nVar.ajg = z;
                d.this.Bz.c(nVar);
                if (d.this.vb.tu != null) {
                    d.this.vb.tu.setAudioEnabled(!z, false);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iL() {
        if (this.vb.tN) {
            kh();
        } else {
            kg();
        }
    }

    public final void a(long j, long j2) {
        d(j, j2);
        j(j2);
    }

    @Override // com.kwad.components.core.webview.tachikoma.b.y.a
    public final void a(TKAdLiveShopItemInfo tKAdLiveShopItemInfo) {
        this.vb.mAdTemplate.tkLiveShopItemInfo = tKAdLiveShopItemInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kb() {
        com.kwad.sdk.core.adlog.c.b(this.vb.mAdTemplate, 17, this.vb.mReportExtData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kc() {
        this.vb.F(kj());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kd() {
        com.kwad.components.ad.reward.j.b.a(this.vb.mAdTemplate, kj(), "endTopBar", new com.kwad.sdk.core.adlog.c.b().eP(39).f(this.vb.mRootContainer.getTouchCoords()), this.vb.mReportExtData);
        this.vb.tt.db();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ke() {
        com.kwad.components.ad.reward.j.b.a(this.vb.mAdTemplate, kj(), (String) null, new com.kwad.sdk.core.adlog.c.b().eP(40).f(this.vb.mRootContainer.getTouchCoords()), this.vb.mReportExtData);
        this.vb.tt.db();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kf() {
        com.kwad.components.ad.reward.j.b.a(this.vb.mAdTemplate, kj(), (String) null, new com.kwad.sdk.core.adlog.c.b().eP(41).f(this.vb.mRootContainer.getTouchCoords()), this.vb.mReportExtData);
        this.vb.tt.db();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyRewardVerify() {
        this.vb.tt.onRewardVerify();
    }

    private void kg() {
        this.BC.Yk = true;
        this.BC.ajo = false;
        this.BC.sp = com.kwad.sdk.core.response.b.a.M(com.kwad.sdk.core.response.b.e.eP(this.vb.mAdTemplate));
        ki();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kh() {
        this.BC.ajo = true;
        this.BC.Yk = false;
        ki();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(double d) {
        this.BC.ajo = false;
        this.BC.Yk = false;
        this.BC.sp = (int) ((d / 1000.0d) + 0.5d);
        ki();
    }

    private void d(long j, long j2) {
        if (j2 < Math.min(com.kwad.sdk.core.response.b.a.ai(this.vb.mAdTemplate.adInfoList.get(0)), j) - 800) {
            this.vb.ue = (int) (((r3 - j2) / 1000.0f) + 0.5f);
        }
    }

    private void ki() {
        z zVar;
        p pVar = this.By;
        if (pVar == null || (zVar = this.BC) == null) {
            return;
        }
        pVar.a(zVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String kj() {
        com.kwad.components.ad.reward.k.a.d dVar = this.Bx;
        if (dVar == null) {
            return null;
        }
        return dVar.getTkTemplateId();
    }
}
