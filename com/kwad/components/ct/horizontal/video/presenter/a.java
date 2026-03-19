package com.kwad.components.ct.horizontal.video.presenter;

import android.text.TextUtils;
import com.bytedance.sdk.djx.core.log.ILogConst;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.core.video.o;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.ad;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.ag;
import com.kwad.components.core.webview.jshandler.aj;
import com.kwad.components.core.webview.jshandler.al;
import com.kwad.components.core.webview.jshandler.an;
import com.kwad.components.core.webview.jshandler.at;
import com.kwad.components.core.webview.jshandler.ba;
import com.kwad.components.core.webview.jshandler.bd;
import com.kwad.components.core.webview.jshandler.n;
import com.kwad.components.core.webview.jshandler.z;
import com.kwad.components.ct.request.i;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.components.ct.response.model.CtPhotoInfo;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KSApiWebView;
import com.kwad.sdk.utils.ca;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends com.kwad.components.ct.horizontal.video.a.a {
    private com.kwad.components.ct.horizontal.video.b aLG;
    private KSApiWebView aoT;
    private com.kwad.components.core.webview.a gB;
    private com.kwad.sdk.core.webview.b gC;
    private ba gE;

    /* renamed from: if, reason: not valid java name */
    private AdBaseFrameLayout f18if;
    private long time;
    private int gD = -1;
    private int aOM = 0;
    private boolean aON = false;
    private boolean aOO = false;
    private com.kwad.components.ct.horizontal.video.d aOH = new com.kwad.components.ct.horizontal.video.d() { // from class: com.kwad.components.ct.horizontal.video.presenter.a.1
        @Override // com.kwad.components.ct.horizontal.video.d
        public final void update() {
            a.this.A(null);
        }
    };
    private o aMT = new o() { // from class: com.kwad.components.ct.horizontal.video.presenter.a.2
        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPrepared() {
            super.onMediaPrepared();
            a.this.Iv();
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayProgress(long j, long j2) {
            super.onMediaPlayProgress(j, j2);
            if (!a.this.aOO && j == j2) {
                a.a(a.this, true);
            }
            com.kwad.sdk.core.d.c.d("HorizontalVideoAdEndWebPresenter", "onVideoPlayProgress ");
            if (j - j2 >= com.kwad.components.ct.horizontal.a.b.Hl() || a.this.aOD.aLH) {
                return;
            }
            a.this.startRequest();
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayCompleted() {
            super.onMediaPlayCompleted();
            com.kwad.sdk.core.d.c.d("HorizontalVideoAdEndWebPresenter", "onVideoPlayCompleted ");
            a.a(a.this, true);
            a.this.yr();
        }
    };
    private al.b gH = new al.b() { // from class: com.kwad.components.ct.horizontal.video.presenter.a.3
        @Override // com.kwad.components.core.webview.jshandler.al.b
        public final void a(al.a aVar) {
            a.this.nQ();
        }
    };
    private at.b gI = new at.b() { // from class: com.kwad.components.ct.horizontal.video.presenter.a.4
        @Override // com.kwad.components.core.webview.jshandler.at.b
        public final void a(at.a aVar) {
            a.this.gD = aVar.status;
            if (a.this.aON) {
                a.this.yr();
            }
            com.kwad.sdk.core.d.c.i("HorizontalVideoAdEndWebPresenter", "updatePageStatus status :" + aVar + " load time:" + (System.currentTimeMillis() - a.this.time));
        }
    };

    static /* synthetic */ boolean a(a aVar, boolean z) {
        aVar.aON = true;
        return true;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.aoT = (KSApiWebView) findViewById(R.id.ksad_horizontal_play_end_web_card);
        this.f18if = (AdBaseFrameLayout) findViewById(R.id.ksad_horizontal_video_player_view);
    }

    @Override // com.kwad.components.ct.horizontal.video.a.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        if (this.aOD.aLD != null) {
            this.aOD.aLD.a(this);
            this.aOD.aLD.a(this.aOH);
        }
        A(this.aOD.mAdTemplate);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        if (this.aOD.aLD != null) {
            this.aOD.aLD.b(this);
            this.aOD.aLD.b(this.aOH);
        }
        com.kwad.components.ct.horizontal.video.b bVar = this.aLG;
        if (bVar != null) {
            bVar.d(this.aMT);
        }
    }

    @Override // com.kwad.components.ct.horizontal.video.c
    public final void A(CtAdTemplate ctAdTemplate) {
        this.aOD.aLH = false;
        this.aOD.aLI = null;
        nQ();
        Iv();
        com.kwad.components.ct.horizontal.video.b bVar = this.aOD.aLG;
        this.aLG = bVar;
        if (bVar != null) {
            bVar.c(this.aMT);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Iv() {
        this.aOM = 0;
        this.aON = false;
        this.aOO = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startRequest() {
        if (this.aOD.aLH || this.aOD.aLI != null || this.aOM > 3) {
            return;
        }
        com.kwad.sdk.core.d.c.d("HorizontalVideoAdEndWebPresenter", "startRequest ");
        this.aOM++;
        this.aOD.aLH = true;
        ImpInfo impInfo = new ImpInfo(this.aOD.mAdTemplate.mAdScene);
        impInfo.pageScene = r0.getPageScene();
        impInfo.subPageScene = 102L;
        impInfo.sdkExtraData = com.kwad.components.ct.response.a.a.aZ(this.aOD.mAdTemplate);
        CtPhotoInfo ctPhotoInfoAy = com.kwad.components.ct.response.a.a.ay(this.aOD.mAdTemplate);
        long j = com.kwad.components.ct.response.a.c.j((PhotoInfo) ctPhotoInfoAy);
        com.kwad.components.core.request.model.c cVar = new com.kwad.components.core.request.model.c();
        cVar.photoId = j;
        cVar.authorId = com.kwad.components.ct.response.a.c.e(ctPhotoInfoAy);
        i.a(j, impInfo, cVar, new i.a() { // from class: com.kwad.components.ct.horizontal.video.presenter.a.5
            @Override // com.kwad.components.ct.request.i.a
            public final void zH() {
                com.kwad.sdk.core.d.c.d("HorizontalVideoAdEndWebPresenter", "onError ");
                a.this.aOD.aLH = false;
            }

            @Override // com.kwad.components.ct.request.i.a
            public final void b(long j2, CtAdTemplate ctAdTemplate) {
                com.kwad.sdk.core.d.c.d("HorizontalVideoAdEndWebPresenter", "onSuccess ");
                a.this.aOD.aLH = true;
                a.this.aOD.aLI = ctAdTemplate;
                if (com.kwad.sdk.core.response.b.a.aJ(com.kwad.components.ct.response.a.a.eP(a.this.aOD.aLI))) {
                    a.this.aOD.mApkDownloadHelper = new com.kwad.components.core.e.d.c(a.this.aOD.aLI);
                } else {
                    a.this.aOD.mApkDownloadHelper = null;
                }
                a.this.fy();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fy() {
        bh();
        this.aoT.setVisibility(4);
        bj();
        this.gD = -1;
        this.time = System.currentTimeMillis();
        if (this.aOD.aLI != null) {
            String strCR = com.kwad.sdk.core.response.b.b.cR(this.aOD.aLI);
            if (TextUtils.isEmpty(strCR)) {
                return;
            }
            this.aoT.loadUrl(strCR);
        }
    }

    private void bh() {
        com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
        this.gC = bVar;
        bVar.setAdTemplate(this.aOD.aLI);
        this.gC.mScreenOrientation = 0;
        this.gC.bLv = this.f18if;
        this.gC.Vu = this.f18if;
        this.gC.UO = this.aoT;
    }

    private void a(com.kwad.components.core.webview.a aVar) {
        aVar.a(new ac(this.gC, this.aOD.mApkDownloadHelper, null, (byte) 0));
        aVar.a(new z(this.gC, this.aOD.mApkDownloadHelper, (com.kwad.sdk.core.webview.d.a.a) null));
        aVar.a(new ag(this.gC));
        aVar.a(new aj(this.gC));
        aVar.a(new ae(this.gC));
        aVar.a(new at(this.gI, com.kwad.sdk.core.response.b.b.cR(this.aOD.aLI)));
        ba baVar = new ba();
        this.gE = baVar;
        aVar.a(baVar);
        aVar.a(new bd(this.gC, this.aOD.mApkDownloadHelper));
        aVar.a(new an(this.gC));
        aVar.b(new com.kwad.components.core.webview.jshandler.o(this.gC));
        aVar.b(new n(this.gC));
        aVar.a(new al(this.gH));
        aVar.a(new ad(this.gC, new ad.a() { // from class: com.kwad.components.ct.horizontal.video.presenter.a.6
            @Override // com.kwad.components.core.webview.jshandler.ad.a
            public final void cP() {
                a.this.nQ();
            }
        }));
    }

    private void bk() {
        com.kwad.components.core.webview.a aVar = this.gB;
        if (aVar != null) {
            aVar.destroy();
            this.gB = null;
        }
    }

    private void bj() {
        bk();
        com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(this.aoT);
        this.gB = aVar;
        a(aVar);
        this.aoT.addJavascriptInterface(this.gB, "KwaiAd");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yr() {
        com.kwad.sdk.core.d.c.d("HorizontalVideoAdEndWebPresenter", "showWebCard mPageState: " + this.gD);
        if (this.gD == 1) {
            ba baVar = this.gE;
            if (baVar != null) {
                baVar.vd();
            }
            this.aoT.setVisibility(0);
            ba baVar2 = this.gE;
            if (baVar2 != null) {
                baVar2.ve();
            }
            zE();
            this.aON = false;
            this.aOO = true;
            return;
        }
        br();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nQ() {
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
        com.kwad.sdk.core.d.c.e("HorizontalVideoAdEndWebPresenter", "show webCard fail, reason: " + (i == -1 ? "timeout" : i != 1 ? "h5error" : ILogConst.DRAW_ENTER_TYPE_OTHER));
    }

    private void zE() {
        if (this.aOD.aLI != null) {
            com.kwad.components.core.u.b.tq().a(this.aOD.aLI, null, null);
        }
    }
}
