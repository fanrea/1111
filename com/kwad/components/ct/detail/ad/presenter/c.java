package com.kwad.components.ct.detail.ad.presenter;

import android.view.ViewTreeObserver;
import com.bytedance.sdk.djx.core.log.ILogConst;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.video.n;
import com.kwad.components.core.video.o;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.ag;
import com.kwad.components.core.webview.jshandler.al;
import com.kwad.components.core.webview.jshandler.an;
import com.kwad.components.core.webview.jshandler.at;
import com.kwad.components.core.webview.jshandler.ba;
import com.kwad.components.core.webview.jshandler.bd;
import com.kwad.components.core.webview.jshandler.bi;
import com.kwad.components.core.webview.jshandler.bn;
import com.kwad.components.core.webview.jshandler.z;
import com.kwad.components.core.webview.tachikoma.b.f;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.R;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KSApiWebView;
import com.kwad.sdk.utils.aj;
import com.kwad.sdk.utils.ca;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c extends com.kwad.components.ct.detail.b {
    private KSApiWebView aoT;
    private boolean aoV;
    private com.kwad.components.ct.detail.e.a aoz;
    private com.kwad.components.core.webview.a gB;
    private com.kwad.sdk.core.webview.b gC;
    private ba gE;

    /* renamed from: if, reason: not valid java name */
    private AdBaseFrameLayout f8if;
    private CtAdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private long time;
    private int aoU = 0;
    private int gD = -1;
    private n mVideoPlayStateListener = new o() { // from class: com.kwad.components.ct.detail.ad.presenter.c.1
        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayCompleted() {
            c.a(c.this);
            int iDg = com.kwad.sdk.core.response.b.b.dg(c.this.mAdTemplate);
            if (iDg <= 0) {
                iDg = 1;
            }
            if (c.this.aop.aok.CU()) {
                return;
            }
            if (c.this.aoU != 1 && (c.this.aoU - 1) % iDg != 0) {
                c.this.aop.aoH = false;
                c.this.aop.aoG = true;
                return;
            }
            if (com.kwad.components.ct.detail.a.b.yT() && com.kwad.components.ct.detail.a.b.yR()) {
                if (c.this.aop.aok.hasNext()) {
                    c.this.aop.aoH = true;
                    c.this.aop.aoG = false;
                    return;
                } else {
                    c.this.aop.aoG = true;
                    c.this.aop.aoH = false;
                    return;
                }
            }
            if (com.kwad.components.ct.detail.a.b.yS() && !com.kwad.sdk.core.response.b.a.aJ(com.kwad.components.ct.response.a.a.eP(c.this.mAdTemplate))) {
                c.this.aop.aoG = true;
                c.this.aop.aoH = false;
                AdWebViewActivityProxy.launch(c.this.getContext(), c.this.mAdTemplate);
                com.kwad.sdk.core.adlog.c.a(c.this.mAdTemplate, 109, (aj.a) null);
                if ((c.this.aop.aoy instanceof com.kwad.components.ct.detail.ad.a) && com.kwad.components.core.u.d.tu()) {
                    com.kwad.components.ct.e.b.JK().b(c.this.aop.mAdTemplate, 1);
                    return;
                }
                return;
            }
            if (com.kwad.components.ct.detail.a.b.yT() || !com.kwad.components.ct.detail.a.b.yR()) {
                c.this.aop.aoH = false;
                c.this.aop.aoG = false;
                c.this.yr();
            } else if (c.this.aop.aok.hasNext()) {
                c.this.aop.aoH = true;
                c.this.aop.aoG = false;
            } else {
                c.this.aop.aoG = true;
                c.this.aop.aoH = false;
            }
        }
    };
    private com.kwad.components.core.k.a aoQ = new AnonymousClass2();
    private bi.b aoW = new bi.b() { // from class: com.kwad.components.ct.detail.ad.presenter.c.6
        @Override // com.kwad.components.core.webview.jshandler.bi.b
        public final void bd(boolean z) {
            c.this.bo(z);
        }
    };
    private bn.a agE = new bn.a() { // from class: com.kwad.components.ct.detail.ad.presenter.c.7
        @Override // com.kwad.components.core.webview.jshandler.bn.a
        public final void vn() {
            if (c.this.aoz != null) {
                c.this.aoz.restart();
            }
            c.this.nQ();
        }
    };
    private al.b gH = new al.b() { // from class: com.kwad.components.ct.detail.ad.presenter.c.8
        @Override // com.kwad.components.core.webview.jshandler.al.b
        public final void a(al.a aVar) {
            c.this.nQ();
        }
    };
    private at.b gI = new at.b() { // from class: com.kwad.components.ct.detail.ad.presenter.c.9
        @Override // com.kwad.components.core.webview.jshandler.at.b
        public final void a(at.a aVar) {
            c.this.gD = aVar.status;
            com.kwad.sdk.core.d.c.i("AdPlayEndWebPresenter", "position:" + c.this.aop.abR + " load time:" + (System.currentTimeMillis() - c.this.time));
        }
    };

    static /* synthetic */ int a(c cVar) {
        int i = cVar.aoU;
        cVar.aoU = i + 1;
        return i;
    }

    static /* synthetic */ int a(c cVar, int i) {
        cVar.aoU = 0;
        return 0;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.f8if = (AdBaseFrameLayout) findViewById(R.id.ksad_root_container);
        this.aoT = (KSApiWebView) findViewById(R.id.ksad_play_end_web_card);
    }

    @Override // com.kwad.components.ct.detail.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.mAdTemplate = this.aop.mAdTemplate;
        this.aoV = !com.kwad.sdk.core.response.b.b.di(r0);
        this.aoT.setVisibility(8);
        if (this.aoV) {
            return;
        }
        this.aoz = this.aop.aoz;
        this.mApkDownloadHelper = this.aop.mApkDownloadHelper;
        this.gC = new com.kwad.sdk.core.webview.b();
        initView();
        bh();
        com.kwad.components.ct.detail.e.a aVar = this.aoz;
        if (aVar != null) {
            aVar.c(this.mVideoPlayStateListener);
        }
        this.aop.aoq.add(this.aoQ);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        if (this.aoV) {
            return;
        }
        com.kwad.components.ct.detail.e.a aVar = this.aoz;
        if (aVar != null) {
            aVar.d(this.mVideoPlayStateListener);
        }
        this.aop.aoq.remove(this.aoQ);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        KSApiWebView kSApiWebView = this.aoT;
        if (kSApiWebView != null) {
            kSApiWebView.release();
        }
    }

    /* renamed from: com.kwad.components.ct.detail.ad.presenter.c$2, reason: invalid class name */
    final class AnonymousClass2 extends com.kwad.components.core.k.b {
        ViewTreeObserver.OnGlobalLayoutListener aoY;

        AnonymousClass2() {
        }

        @Override // com.kwad.components.core.k.b, com.kwad.components.core.k.a
        public final void qy() {
            super.qy();
            ys();
            yt();
        }

        @Override // com.kwad.components.core.k.b, com.kwad.components.core.k.a
        public final void qz() {
            super.qz();
            ys();
            c.this.bk();
            if (this.aoY != null) {
                c.this.aoT.getViewTreeObserver().removeOnGlobalLayoutListener(this.aoY);
            }
        }

        private void ys() {
            c.a(c.this, 0);
            c.this.aoT.setVisibility(4);
        }

        private void yt() {
            this.aoY = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.kwad.components.ct.detail.ad.presenter.c.2.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public final void onGlobalLayout() {
                    c.this.aoT.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    AnonymousClass2.this.aoY = null;
                    c.this.yq();
                }
            };
            c.this.aoT.getViewTreeObserver().addOnGlobalLayoutListener(this.aoY);
        }
    }

    private void bh() {
        this.gC.setAdTemplate(this.aop.mAdTemplate);
        this.gC.mScreenOrientation = 0;
        this.gC.bLv = this.f8if;
        this.gC.Vu = this.f8if;
        this.gC.UO = this.aoT;
    }

    private void initView() {
        this.aoT.setVisibility(4);
        this.aoT.setBackgroundColor(0);
        this.aoT.getBackground().setAlpha(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yq() {
        this.aoT.setVisibility(4);
        bj();
        this.gD = -1;
        this.time = System.currentTimeMillis();
        this.aoT.loadUrl(com.kwad.sdk.core.response.b.b.dh(this.mAdTemplate));
    }

    private void bj() {
        bk();
        com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(this.aoT);
        this.gB = aVar;
        a(aVar);
        this.aoT.addJavascriptInterface(this.gB, "KwaiAd");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bk() {
        com.kwad.components.core.webview.a aVar = this.gB;
        if (aVar != null) {
            aVar.destroy();
            this.gB = null;
        }
    }

    private void a(com.kwad.components.core.webview.a aVar) {
        aVar.a(new ac(this.gC, this.mApkDownloadHelper, new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ct.detail.ad.presenter.c.3
            @Override // com.kwad.sdk.core.webview.d.a.a
            public final void a(com.kwad.sdk.core.webview.d.b.a aVar2) {
                if ((c.this.aop.aoy instanceof com.kwad.components.ct.detail.ad.a) && com.kwad.components.core.u.d.tu()) {
                    com.kwad.components.ct.e.b.JK().b(c.this.aop.mAdTemplate, 1);
                }
            }
        }, (byte) 0));
        aVar.a(new z(this.gC, this.mApkDownloadHelper, new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ct.detail.ad.presenter.c.4
            @Override // com.kwad.sdk.core.webview.d.a.a
            public final void a(com.kwad.sdk.core.webview.d.b.a aVar2) {
                if ((c.this.aop.aoy instanceof com.kwad.components.ct.detail.ad.a) && com.kwad.components.core.u.d.tu()) {
                    com.kwad.components.ct.e.b.JK().b(c.this.aop.mAdTemplate, 1);
                }
            }
        }));
        aVar.a(new ag(this.gC));
        aVar.a(new com.kwad.components.core.webview.jshandler.aj(this.gC));
        aVar.a(new ae(this.gC));
        aVar.a(new at(this.gI, com.kwad.sdk.core.response.b.b.dh(this.mAdTemplate)));
        aVar.a(new f());
        ba baVar = new ba();
        this.gE = baVar;
        aVar.a(baVar);
        aVar.a(new bd(this.gC, this.mApkDownloadHelper));
        aVar.a(new al(this.gH));
        an anVar = new an(this.gC);
        aVar.b(new com.kwad.components.core.webview.jshandler.o(this.gC));
        aVar.b(new com.kwad.components.core.webview.jshandler.n(this.gC));
        anVar.a(new an.a() { // from class: com.kwad.components.ct.detail.ad.presenter.c.5
            @Override // com.kwad.components.core.webview.jshandler.an.a
            public final void onClick() {
                if ((c.this.aop.aoy instanceof com.kwad.components.ct.detail.ad.a) && com.kwad.components.core.u.d.tu()) {
                    com.kwad.components.ct.e.b.JK().b(c.this.aop.mAdTemplate, 1);
                }
            }
        });
        aVar.a(anVar);
        aVar.a(new bn(this.agE));
        aVar.a(new bi(this.aoW));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yr() {
        if (this.gD == 1) {
            ba baVar = this.gE;
            if (baVar != null) {
                baVar.vd();
            }
            this.aoT.setVisibility(0);
            ba baVar2 = this.gE;
            if (baVar2 != null) {
                baVar2.ve();
                return;
            }
            return;
        }
        br();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nQ() {
        bo(true);
        if (ca.a(this.aoT, 50, false)) {
            ba baVar = this.gE;
            if (baVar != null) {
                baVar.vf();
            }
            this.aoT.setVisibility(4);
            ba baVar2 = this.gE;
            if (baVar2 != null) {
                baVar2.vg();
            }
        }
    }

    private void br() {
        int i = this.gD;
        com.kwad.sdk.core.d.c.w("AdPlayEndWebPresenter", "show webCard fail, reason: " + (i == -1 ? "timeout" : i != 1 ? "h5error" : ILogConst.DRAW_ENTER_TYPE_OTHER));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bo(boolean z) {
        this.aop.aok.h(z, 9);
    }
}
