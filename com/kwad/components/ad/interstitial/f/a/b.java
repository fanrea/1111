package com.kwad.components.ad.interstitial.f.a;

import android.app.Activity;
import android.app.Dialog;
import android.os.Vibrator;
import android.widget.FrameLayout;
import com.kwad.components.ad.h.a.a.b;
import com.kwad.components.ad.interstitial.f.c;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.u.m;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.al;
import com.kwad.components.core.webview.jshandler.ar;
import com.kwad.components.core.webview.jshandler.ba;
import com.kwad.components.core.webview.jshandler.bc;
import com.kwad.components.core.webview.jshandler.bo;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.components.core.webview.jshandler.z;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.b;
import com.kwad.components.core.webview.tachikoma.b.n;
import com.kwad.components.core.webview.tachikoma.b.q;
import com.kwad.components.core.webview.tachikoma.c.l;
import com.kwad.components.core.webview.tachikoma.c.u;
import com.kwad.components.core.webview.tachikoma.c.y;
import com.kwad.components.core.webview.tachikoma.e;
import com.kwad.components.core.webview.tachikoma.f.g;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.t;
import com.kwad.sdk.core.g.d;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.bs;
import com.kwad.sdk.utils.bx;
import com.kwad.sdk.utils.ca;
import java.io.File;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends a {
    private static long ps = 400;
    private FrameLayout eI;
    private d iQ;
    private Vibrator iS;
    private ba kq;
    private com.kwad.components.ad.h.a.a.b pr;
    private boolean pu;
    private e pv;
    private boolean pt = false;
    private final c.b oK = new c.b() { // from class: com.kwad.components.ad.interstitial.f.a.b.1
        @Override // com.kwad.components.ad.interstitial.f.c.b
        public final void c(long j, long j2) {
            com.kwad.components.ad.interstitial.report.a.eT().b(b.this.oa.mAdTemplate, j, j2);
            if (b.this.pv != null) {
                com.kwad.components.core.webview.tachikoma.c.a aVar = new com.kwad.components.core.webview.tachikoma.c.a();
                aVar.aiT = b.this.oa.oc ? 1 : 0;
                b.this.pv.b(aVar);
            }
        }
    };
    private com.kwad.sdk.core.j.c gZ = new com.kwad.sdk.core.j.d() { // from class: com.kwad.components.ad.interstitial.f.a.b.9
        @Override // com.kwad.sdk.core.j.d, com.kwad.sdk.core.j.c
        public final void by() {
            if (b.this.kq != null && !b.this.pt) {
                b.a(b.this, true);
                b.this.kq.vd();
                b.this.kq.ve();
            }
            if (b.this.kq != null) {
                b.this.kq.vh();
            }
            if (b.this.pr != null) {
                b.this.pr.fV();
            }
            if (!b.this.pu) {
                b.this.oa.mN.getTimerHelper().startTiming();
            }
            if (b.this.pu || b.this.oa.oe || b.this.oa.mH == null) {
                return;
            }
            b.this.oa.mH.onAdShow();
            com.kwad.components.ad.interstitial.report.c.eX().a(b.this.oa.mAdTemplate, 3);
            b.b(b.this, true);
        }

        @Override // com.kwad.sdk.core.j.d, com.kwad.sdk.core.j.c
        public final void bz() {
            if (b.this.kq != null) {
                b.this.kq.vi();
            }
            if (b.this.pr != null) {
                b.this.pr.fU();
            }
        }
    };

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void aF() {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void aG() {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getRegisterViewKey() {
        return null;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTKReaderScene() {
        return "tk_interstitial";
    }

    static /* synthetic */ boolean a(b bVar, boolean z) {
        bVar.pt = true;
        return true;
    }

    static /* synthetic */ boolean b(b bVar, boolean z) {
        bVar.pu = true;
        return true;
    }

    @Override // com.kwad.components.ad.interstitial.f.a.a, com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.ksad_tk_view);
        this.eI = frameLayout;
        frameLayout.setVisibility(0);
    }

    @Override // com.kwad.components.ad.interstitial.f.a.a, com.kwad.components.ad.interstitial.f.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
    }

    @Override // com.kwad.components.ad.interstitial.f.a.a, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.pt = false;
        this.pu = false;
        bx.b(getContext(), this.iS);
        d dVar = this.iQ;
        if (dVar != null) {
            dVar.bX(getContext());
        }
        if (this.oa.mF != null) {
            this.oa.mF.b(this.gZ);
        }
        this.oa.b(this.oK);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTkTemplateId() {
        return com.kwad.sdk.core.response.b.b.em(this.oa.mAdTemplate);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final FrameLayout getTKContainer() {
        return this.eI;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(TKRenderFailReason tKRenderFailReason) {
        this.eI.setVisibility(8);
        if (this.oa.oh != null) {
            g gVar = this.oa.oh;
            getTkTemplateId();
            gVar.x(getTKReaderScene());
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void aE() {
        com.kwad.components.ad.interstitial.report.c.eX().C(this.oa.mAdTemplate);
        if (this.oa.oh != null) {
            this.oa.oh.a(getTkTemplateId(), 0L, 0L, 0L);
        }
        if (this.kq != null && this.oa.mF.ai()) {
            this.pt = true;
            this.kq.vd();
            this.kq.ve();
        }
        this.oa.mF.a(this.gZ);
    }

    @Override // com.kwad.components.ad.interstitial.f.a.a, com.kwad.components.core.webview.tachikoma.j
    public final void a(t tVar, com.kwad.sdk.core.webview.b bVar) {
        super.a(tVar, bVar);
        com.kwad.components.ad.h.a.a.b bVarJ = com.kwad.components.ad.h.a.a.b.J(this.oa.mAdTemplate);
        this.pr = bVarJ;
        if (bVarJ != null) {
            bVarJ.a(new b.InterfaceC0414b() { // from class: com.kwad.components.ad.interstitial.f.a.b.10
                @Override // com.kwad.components.ad.h.a.a.b.InterfaceC0414b
                public final void Q(int i) {
                    if (i == com.kwad.components.ad.h.a.a.b.sf) {
                        b.this.oa.c(b.this.getContext(), b.this.oa.mAdTemplate);
                        b.this.oa.a(true, -1, null);
                    }
                    b.this.eA();
                }
            });
            tVar.c(this.pr);
            this.pr.az();
        }
        tVar.c(eO());
        tVar.c(new ar(getOpenNewPageListener()));
        if (com.kwad.sdk.core.response.b.b.dX(com.kwad.sdk.core.response.b.e.eP(this.oa.mAdTemplate))) {
            tVar.c(new bc(new bc.a() { // from class: com.kwad.components.ad.interstitial.f.a.b.11
                @Override // com.kwad.components.core.webview.jshandler.bc.a
                public final void cQ() {
                    b.this.cK();
                }
            }));
        }
        tVar.c(eN());
        tVar.c(eM());
        tVar.c(eK());
        tVar.c(a(bVar));
        tVar.c(eP());
        tVar.c(eL());
        tVar.c(new q() { // from class: com.kwad.components.ad.interstitial.f.a.b.12
            @Override // com.kwad.components.core.webview.tachikoma.b.q, com.kwad.sdk.core.webview.c.a
            public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
                super.a(str, cVar);
                m.f(b.this.getContext(), b.this.oa.mAdTemplate);
            }
        });
        this.pv = eJ();
        this.oa.a(this.oK);
        tVar.c(this.pv);
        tVar.c(new com.kwad.components.core.webview.tachikoma.b(new b.a() { // from class: com.kwad.components.ad.interstitial.f.a.b.13
            @Override // com.kwad.components.core.webview.tachikoma.b.a
            public final void eS() {
                com.kwad.components.ad.interstitial.d.a.L(b.this.getContext());
            }
        }));
        tVar.c(eI());
    }

    @Override // com.kwad.components.ad.interstitial.f.a.a, com.kwad.components.core.webview.tachikoma.j
    public final void a(ba baVar) {
        super.a(baVar);
        this.kq = baVar;
    }

    private com.kwad.components.core.webview.tachikoma.c eI() {
        return new com.kwad.components.core.webview.tachikoma.c() { // from class: com.kwad.components.ad.interstitial.f.a.b.14
            @Override // com.kwad.components.core.webview.tachikoma.c, com.kwad.sdk.core.webview.c.a
            public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
                super.a(str, cVar);
                com.kwad.components.core.webview.tachikoma.c.c cVar2 = new com.kwad.components.core.webview.tachikoma.c.c();
                cVar2.aiV = com.kwad.components.ad.interstitial.d.a.dV();
                cVar.a(cVar2);
            }
        };
    }

    private e eJ() {
        return new e() { // from class: com.kwad.components.ad.interstitial.f.a.b.15
            @Override // com.kwad.components.core.webview.tachikoma.e, com.kwad.sdk.core.webview.c.a
            public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
                super.a(str, cVar);
                com.kwad.components.core.webview.tachikoma.c.a aVar = new com.kwad.components.core.webview.tachikoma.c.a();
                aVar.aiT = b.this.oa.oc ? 1 : 0;
                cVar.a(aVar);
            }
        };
    }

    private com.kwad.components.core.webview.tachikoma.b.g eK() {
        l lVar = new l();
        lVar.ajd = this.oa.oo;
        return new com.kwad.components.core.webview.tachikoma.b.g(lVar);
    }

    private com.kwad.components.ad.h.a.a.a eL() {
        final com.kwad.components.ad.h.a.a.a aVar = new com.kwad.components.ad.h.a.a.a();
        this.oa.oj.add(new c.d() { // from class: com.kwad.components.ad.interstitial.f.a.b.16
            @Override // com.kwad.components.ad.interstitial.f.c.d
            public final void eg() {
                aVar.fT();
            }
        });
        return aVar;
    }

    private z a(com.kwad.sdk.core.webview.b bVar) {
        return new z(bVar, this.oa.mApkDownloadHelper, new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ad.interstitial.f.a.b.2
            @Override // com.kwad.sdk.core.webview.d.a.a
            public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
                if (aVar != null) {
                    com.kwad.components.ad.interstitial.report.a.eT().a(b.this.oa.mAdTemplate, aVar.bMs, aVar.oz);
                    b.this.oa.oc = true;
                    b.this.oa.c(aVar.bMs, aVar.oz);
                    if (b.this.oa.mN == null || !com.kwad.components.ad.interstitial.d.b.u(b.this.oa.mAdTemplate)) {
                        return;
                    }
                    b.this.oa.a(false, -1, b.this.oa.ed);
                    b.this.oa.mN.dismiss();
                    b.this.oa.ac();
                }
            }
        });
    }

    private bo eM() {
        bo boVar = new bo(getContext(), this.oa.mAdTemplate);
        boVar.a(new bo.a() { // from class: com.kwad.components.ad.interstitial.f.a.b.3
            @Override // com.kwad.components.core.webview.jshandler.bo.a
            public final boolean eR() {
                com.kwad.components.core.page.a.launch(b.this.getContext(), b.this.oa.mAdTemplate);
                b.this.oa.a(true, -1, null);
                bx.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.ad.interstitial.f.a.b.3.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        b.this.eA();
                    }
                }, 0L);
                return false;
            }
        });
        return boVar;
    }

    private n eN() {
        return new n() { // from class: com.kwad.components.ad.interstitial.f.a.b.4
            @Override // com.kwad.components.core.webview.tachikoma.b.w, com.kwad.sdk.core.webview.c.a
            public final void a(String str, final com.kwad.sdk.core.webview.c.c cVar) {
                super.a(str, cVar);
                bx.runOnUiThreadDelay(new bh() { // from class: com.kwad.components.ad.interstitial.f.a.b.4.1
                    @Override // com.kwad.sdk.utils.bh
                    public final void doTask() {
                        com.kwad.components.core.webview.tachikoma.c.d dVar = new com.kwad.components.core.webview.tachikoma.c.d();
                        dVar.aiW = ao.isWifiConnected(b.this.getContext()) || b.this.oa.dG.isDataFlowAutoStart() || b.v(b.this.oa.mAdTemplate);
                        cVar.a(dVar);
                    }
                }, 0L);
            }
        };
    }

    public static boolean v(AdTemplate adTemplate) {
        File fileDw = com.kwad.sdk.core.diskcache.b.a.ZH().dw(com.kwad.sdk.core.response.b.a.L(com.kwad.sdk.core.response.b.e.eP(adTemplate)));
        return fileDw != null && fileDw.exists();
    }

    private al eO() {
        return new al(new al.b() { // from class: com.kwad.components.ad.interstitial.f.a.b.5
            @Override // com.kwad.components.core.webview.jshandler.al.b
            public final void a(final al.a aVar) {
                if (b.this.oa.mN != null) {
                    b.this.oa.hG.post(new bh() { // from class: com.kwad.components.ad.interstitial.f.a.b.5.1
                        @Override // com.kwad.sdk.utils.bh
                        public final void doTask() {
                            if (aVar.type != 0 || b.this.oa.oc || b.this.oa.od || !com.kwad.components.ad.interstitial.g.a.d(b.this.oa)) {
                                b.this.eQ();
                                b.this.oa.a(aVar.type == 3, aVar.afp, null);
                                b.this.eA();
                            } else {
                                b.this.oa.od = true;
                                com.kwad.components.ad.interstitial.c.b.K(b.this.getContext());
                            }
                        }
                    });
                }
            }
        });
    }

    private x eP() {
        return new x() { // from class: com.kwad.components.ad.interstitial.f.a.b.6
            @Override // com.kwad.components.core.webview.jshandler.x
            public final void b(y yVar) {
                super.b(yVar);
                if (b.this.oa.oe || b.this.oa.mH == null) {
                    return;
                }
                b.this.oa.mH.onVideoPlayStart();
            }

            @Override // com.kwad.components.core.webview.jshandler.x
            public final void d(y yVar) {
                super.d(yVar);
                b.this.oa.mAdTemplate.setmCurPlayTime(yVar.sp);
            }

            @Override // com.kwad.components.core.webview.jshandler.x
            public final void c(y yVar) {
                super.c(yVar);
                if (b.this.oa.oe || b.this.oa.mH == null) {
                    return;
                }
                b.this.oa.mH.onVideoPlayEnd();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cK() {
        if (getContext() != null) {
            this.iS = (Vibrator) getContext().getSystemService("vibrator");
        }
        float fDF = com.kwad.sdk.core.response.b.b.dF(this.oa.mAdTemplate);
        if (this.iQ == null) {
            d dVar = new d(fDF);
            this.iQ = dVar;
            dVar.a(new com.kwad.sdk.core.g.b() { // from class: com.kwad.components.ad.interstitial.f.a.b.7
                @Override // com.kwad.sdk.core.g.b
                public final void ci() {
                }

                @Override // com.kwad.sdk.core.g.b
                public final void d(double d) {
                    if (ca.v(b.this.getTKContainer(), 100)) {
                        b.this.g(d);
                    }
                    bx.a(new bh() { // from class: com.kwad.components.ad.interstitial.f.a.b.7.1
                        @Override // com.kwad.sdk.utils.bh
                        public final void doTask() {
                            b.this.iQ.abR();
                        }
                    }, null, 500L);
                }
            });
        }
        this.iQ.K(fDF);
        this.iQ.bW(getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(double d) {
        this.oa.a(new c.C0420c(getContext()).m(true).f(d).L(2).a(this.oa.hG.getTouchCoords()).M(157));
        bx.vibrate(getContext(), this.iS, ps);
    }

    private ar.a getOpenNewPageListener() {
        return new ar.a() { // from class: com.kwad.components.ad.interstitial.f.a.b.8
            @Override // com.kwad.components.core.webview.jshandler.ar.a
            public final void a(com.kwad.components.core.webview.a.b bVar) {
                AdWebViewActivityProxy.launch(b.this.getContext(), new AdWebViewActivityProxy.a.C0479a().aE(bVar.title).aF(bVar.url).aG(true).q(b.this.oa.mAdResultData).rk());
            }
        };
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(ae.a aVar) {
        float height;
        float width;
        float fBv = com.kwad.sdk.c.a.a.bv(getContext());
        FrameLayout frameLayout = this.eI;
        if (frameLayout != null) {
            height = frameLayout.getHeight();
            width = this.eI.getWidth();
        } else {
            height = 0.0f;
            width = 0.0f;
        }
        if (height == 0.0f || width == 0.0f) {
            aVar.width = (int) ((bs.getScreenWidth(getContext()) / fBv) + 0.5f);
            aVar.height = (int) ((bs.getScreenHeight(getContext()) / fBv) + 0.5f);
        } else {
            aVar.width = (int) ((width / fBv) + 0.5f);
            aVar.height = (int) ((height / fBv) + 0.5f);
        }
    }

    @Override // com.kwad.components.ad.interstitial.f.a.a, com.kwad.components.core.webview.tachikoma.j
    public final void a(u uVar) {
        super.a(uVar);
        if (this.oa.mH != null) {
            this.oa.mH.onSkippedAd();
        }
        if (this.oa.of != null) {
            this.oa.of.a(-1L, -1L, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eA() {
        if (this.oa == null) {
            return;
        }
        if (this.oa.mN != null && a(this.oa.mN)) {
            this.oa.mN.dismiss();
        }
        try {
            KsInterstitialAd.AdInteractionListener adInteractionListener = this.oa.mH;
            if (adInteractionListener != null) {
                adInteractionListener.onAdClosed();
            }
        } catch (Throwable th) {
            com.kwad.components.core.d.a.reportSdkCaughtException(th);
        }
    }

    private static boolean a(Dialog dialog) {
        Activity ownerActivity = dialog.getOwnerActivity();
        return (ownerActivity == null || ownerActivity.isFinishing()) ? false : true;
    }

    @Override // com.kwad.components.ad.interstitial.f.a.a, com.kwad.components.core.webview.tachikoma.j
    public final void a(WebCloseStatus webCloseStatus) {
        this.oa.a(webCloseStatus.closeType == 2, -1, null);
        eA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eQ() {
        ba baVar = this.kq;
        if (baVar != null) {
            baVar.vf();
            this.kq.vg();
        }
        com.kwad.components.ad.h.a.a.b bVar = this.pr;
        if (bVar != null) {
            bVar.fU();
        }
    }
}
