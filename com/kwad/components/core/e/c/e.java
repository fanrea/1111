package com.kwad.components.core.e.c;

import android.view.View;
import com.kwad.components.core.e.c.b;
import com.kwad.components.core.webview.jshandler.ag;
import com.kwad.components.core.webview.jshandler.aj;
import com.kwad.components.core.webview.jshandler.al;
import com.kwad.components.core.webview.jshandler.am;
import com.kwad.components.core.webview.jshandler.an;
import com.kwad.components.core.webview.jshandler.at;
import com.kwad.components.core.webview.jshandler.ba;
import com.kwad.components.core.webview.jshandler.bd;
import com.kwad.components.core.webview.jshandler.n;
import com.kwad.components.core.webview.jshandler.o;
import com.kwad.components.core.webview.jshandler.z;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.ae;
import com.kwad.sdk.utils.as;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class e extends c implements View.OnClickListener {
    private Runnable QE;
    public b Qv;
    public b.C0468b Qw;
    private com.kwad.components.core.webview.a gB;
    private com.kwad.sdk.core.webview.b gC;
    private ba gE;
    private KsAdWebView gz;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private boolean QF = false;
    private com.kwad.sdk.core.webview.d.a.a gF = new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.core.e.c.e.1
        @Override // com.kwad.sdk.core.webview.d.a.a
        public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
            com.kwad.sdk.core.d.c.d("DownloadTipsDialogWebCardPresenter", "onAdClicked convertBridgeClicked: " + e.this.QF);
            e.a(e.this, true);
        }
    };
    private am.b gG = new am.b() { // from class: com.kwad.components.core.e.c.e.4
        @Override // com.kwad.components.core.webview.jshandler.am.b
        public final void a(am.a aVar) {
            com.kwad.sdk.core.d.c.d("DownloadTipsDialogWebCardPresenter", "onAdFrameValid=" + aVar);
            e.this.gz.setTranslationY(aVar.height + aVar.bottomMargin);
        }
    };
    private al.b gH = new al.b() { // from class: com.kwad.components.core.e.c.e.5
        @Override // com.kwad.components.core.webview.jshandler.al.b
        public final void a(al.a aVar) {
            com.kwad.sdk.core.d.c.d("DownloadTipsDialogWebCardPresenter", "handleWebCardHide");
            e.this.bp();
        }
    };
    private at.b gI = new at.b() { // from class: com.kwad.components.core.e.c.e.6
        @Override // com.kwad.components.core.webview.jshandler.at.b
        public final void a(at.a aVar) {
            com.kwad.sdk.core.d.c.i("DownloadTipsDialogWebCardPresenter", "updatePageStatus mPageState: " + aVar);
            if (aVar.status == 1) {
                e.this.pl();
                return;
            }
            e.this.bp();
            if (e.this.getContext() != null) {
                ac.ae(e.this.getContext(), ae.dv(e.this.getContext()));
            }
        }
    };

    static /* synthetic */ boolean a(e eVar, boolean z) {
        eVar.QF = true;
        return true;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.gz = (KsAdWebView) findViewById(R.id.ksad_download_tips_web_card_webView);
    }

    @Override // com.kwad.components.core.e.c.c, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.Qv = this.Qx.Qv;
        this.Qw = this.Qx.Qw;
        this.mAdTemplate = this.Qx.mAdTemplate;
        this.Qx.mRootContainer.setOnClickListener(this);
        this.mApkDownloadHelper = this.Qx.mApkDownloadHelper;
        bh();
        pj();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        pl();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        release();
    }

    private void release() {
        this.gz.setVisibility(8);
        this.gz.release();
        bk();
    }

    private void bh() {
        com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
        this.gC = bVar;
        bVar.setAdTemplate(this.Qx.mAdTemplate);
        this.gC.bLv = this.Qx.mRootContainer;
        this.gC.Vu = this.Qx.mRootContainer;
        this.gC.UO = this.gz;
    }

    private void pj() {
        bj();
        this.gz.loadUrl(this.Qw.url);
        this.gz.postDelayed(pk(), 1500L);
        this.gz.setBackgroundColor(0);
        this.gz.getBackground().setAlpha(0);
        this.gz.setVisibility(0);
    }

    private Runnable pk() {
        if (this.QE == null) {
            this.QE = new Runnable() { // from class: com.kwad.components.core.e.c.e.2
                @Override // java.lang.Runnable
                public final void run() {
                    e.this.bp();
                    if (e.this.getContext() != null) {
                        ac.ae(e.this.getContext(), ae.dv(e.this.getContext()));
                    }
                }
            };
        }
        return this.QE;
    }

    private void bj() {
        com.kwad.sdk.core.d.c.d("DownloadTipsDialogWebCardPresenter", "setupJsBridge");
        bk();
        com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(this.gz);
        this.gB = aVar;
        a(aVar);
        this.gz.addJavascriptInterface(this.gB, "KwaiAd");
    }

    private void bk() {
        com.kwad.components.core.webview.a aVar = this.gB;
        if (aVar != null) {
            aVar.destroy();
            this.gB = null;
        }
    }

    private void a(com.kwad.components.core.webview.a aVar) {
        aVar.a(new com.kwad.components.core.webview.jshandler.ac(this.gC, this.mApkDownloadHelper, this.gF));
        aVar.a(new z(this.gC, this.mApkDownloadHelper, this.gF, 1));
        aVar.a(new ag(this.gC));
        aVar.a(new aj(this.gC));
        aVar.a(new com.kwad.components.core.webview.jshandler.ae(this.gC));
        aVar.a(new am(this.gC, this.gG));
        aVar.a(new at(this.gI, this.Qw.url));
        ba baVar = new ba();
        this.gE = baVar;
        aVar.a(baVar);
        aVar.a(new bd(this.gC, this.mApkDownloadHelper, new com.kwad.sdk.core.download.a.c() { // from class: com.kwad.components.core.e.c.e.3
            @Override // com.kwad.sdk.core.download.a.c, com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                super.onInstalled();
                AdInfo adInfoEP = com.kwad.sdk.core.response.b.e.eP(e.this.mAdTemplate);
                String strAB = com.kwad.sdk.core.response.b.a.aB(adInfoEP);
                if (com.kwad.sdk.core.response.b.a.aS(adInfoEP) && com.kwad.sdk.core.response.b.a.aJ(adInfoEP) && as.aE(e.this.getContext(), strAB) && com.kwad.components.core.s.a.sX().tb() && com.kwad.sdk.core.response.b.a.aR(adInfoEP) == 1) {
                    e.this.Qv.dismiss();
                }
            }
        }));
        aVar.a(new al(this.gH));
        aVar.a(new an(this.gC));
        aVar.b(new o(this.gC));
        aVar.b(new n(this.gC));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pl() {
        Runnable runnable = this.QE;
        if (runnable != null) {
            this.gz.removeCallbacks(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bp() {
        com.kwad.sdk.core.d.c.d("DownloadTipsDialogWebCardPresenter", "hideWithOutAnimation  convertBridgeClicked: " + this.QF);
        if (this.gz.getVisibility() != 0) {
            return;
        }
        ba baVar = this.gE;
        if (baVar != null) {
            baVar.vf();
        }
        this.gz.setVisibility(4);
        ba baVar2 = this.gE;
        if (baVar2 != null) {
            baVar2.vg();
        }
        if (this.QF) {
            com.kwad.sdk.core.adlog.c.cs(this.mAdTemplate);
        }
        b bVar = this.Qv;
        if (bVar == null || !bVar.isShowing()) {
            return;
        }
        this.Qv.al(this.QF);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        com.kwad.sdk.core.adlog.c.cs(this.mAdTemplate);
        b bVar = this.Qv;
        if (bVar != null) {
            bVar.dismiss();
        }
    }
}
