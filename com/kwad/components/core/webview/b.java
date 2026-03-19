package com.kwad.components.core.webview;

import android.text.TextUtils;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.kwad.components.core.e.c.b;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.webview.jshandler.aa;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.ag;
import com.kwad.components.core.webview.jshandler.aj;
import com.kwad.components.core.webview.jshandler.ak;
import com.kwad.components.core.webview.jshandler.am;
import com.kwad.components.core.webview.jshandler.an;
import com.kwad.components.core.webview.jshandler.as;
import com.kwad.components.core.webview.jshandler.at;
import com.kwad.components.core.webview.jshandler.av;
import com.kwad.components.core.webview.jshandler.ax;
import com.kwad.components.core.webview.jshandler.ba;
import com.kwad.components.core.webview.jshandler.bd;
import com.kwad.components.core.webview.jshandler.bk;
import com.kwad.components.core.webview.jshandler.d;
import com.kwad.components.core.webview.jshandler.i;
import com.kwad.components.core.webview.jshandler.m;
import com.kwad.components.core.webview.jshandler.n;
import com.kwad.components.core.webview.jshandler.o;
import com.kwad.components.core.webview.jshandler.q;
import com.kwad.components.core.webview.jshandler.r;
import com.kwad.components.core.webview.jshandler.u;
import com.kwad.components.core.webview.jshandler.v;
import com.kwad.components.core.webview.jshandler.w;
import com.kwad.components.core.webview.jshandler.z;
import com.kwad.components.core.webview.tachikoma.b.f;
import com.kwad.components.core.webview.tachikoma.b.j;
import com.kwad.components.core.webview.tachikoma.b.k;
import com.kwad.components.core.webview.tachikoma.b.l;
import com.kwad.components.core.webview.tachikoma.b.s;
import com.kwad.components.core.webview.tachikoma.c.g;
import com.kwad.components.core.webview.tachikoma.c.t;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.core.download.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.KsAdWebView;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b {
    private KsAdWebView NS;
    private KsAdWebView.c Vz;
    private ViewGroup adC;
    private com.kwad.components.core.webview.a.a adD;
    private ax adE;
    private e adF;
    private boolean adG;
    private com.kwad.components.core.webview.jshandler.a.c adH;
    private at.b adI = new at.b() { // from class: com.kwad.components.core.webview.b.13
        @Override // com.kwad.components.core.webview.jshandler.at.b
        public final void a(at.a aVar) {
            if (b.this.kH != null) {
                b.this.kH.a(aVar);
            }
        }
    };
    private com.kwad.components.core.webview.a gB;
    private com.kwad.sdk.core.webview.b gC;
    private c kH;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private String mPageUrl;

    private boolean uM() {
        return false;
    }

    public final void a(a aVar) {
        this.mPageUrl = aVar.rf();
        this.mAdTemplate = aVar.getAdTemplate();
        this.adC = aVar.uS();
        this.NS = aVar.uT();
        this.kH = aVar.uU();
        this.mApkDownloadHelper = aVar.in();
        this.adG = aVar.uV();
        this.Vz = aVar.rA();
        this.adH = aVar.uW();
        fy();
        a(this.kH, this.NS);
        bh();
        if (com.kwad.sdk.core.response.b.a.Q(com.kwad.sdk.core.response.b.e.eP(this.mAdTemplate))) {
            c(this.NS);
        } else if (com.kwad.sdk.core.response.b.b.fN(this.mPageUrl)) {
            b(this.NS);
        }
    }

    private void fy() {
        this.NS.setClientConfig(this.NS.getClientConfig().fj(this.mAdTemplate).fO(uQ()).b(uP()).a(uO()).c(this.Vz));
    }

    private void bh() {
        com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
        this.gC = bVar;
        bVar.setAdTemplate(this.mAdTemplate);
        this.gC.mScreenOrientation = 0;
        this.gC.UO = this.NS;
        this.gC.Vu = this.adC;
    }

    private void b(KsAdWebView ksAdWebView) {
        bk();
        com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(ksAdWebView);
        this.gB = aVar;
        b(aVar, this.gC);
        c cVar = this.kH;
        if (cVar != null) {
            cVar.a(this.gB, this.gC);
        }
        ksAdWebView.addJavascriptInterface(this.gB, "KwaiAd");
    }

    private void c(KsAdWebView ksAdWebView) {
        bk();
        com.kwad.components.core.webview.a.a aVar = new com.kwad.components.core.webview.a.a(ksAdWebView, this.gC);
        this.adD = aVar;
        ksAdWebView.addJavascriptInterface(aVar, "KwaiAdForThird");
    }

    private void b(com.kwad.components.core.webview.a aVar, com.kwad.sdk.core.webview.b bVar) {
        ba baVar = new ba();
        aVar.a(baVar);
        a(baVar);
        aVar.a(new v());
        aVar.a(new d());
        aVar.a(new w());
        aVar.a(new q());
        aVar.a(new r());
        an anVar = new an(bVar);
        aVar.b(new o(bVar));
        aVar.b(new n(bVar));
        anVar.a(uN());
        aVar.a(anVar);
        aVar.a(new ag(bVar));
        aVar.a(new f());
        if (this.mApkDownloadHelper == null) {
            this.mApkDownloadHelper = new com.kwad.components.core.e.d.c(this.mAdTemplate);
        }
        if (!this.adG) {
            aVar.a(new ac(this.gC, this.mApkDownloadHelper, getClickListener(), uL(), false, true));
            aVar.a(new z(this.gC, this.mApkDownloadHelper, getClickListener(), uL(), 0, uM(), true));
        }
        aVar.a(new bd(this.gC, this.mApkDownloadHelper));
        aVar.a(new av(this.gC));
        aVar.a(new as(this.gC.UO.getContext(), this.mAdTemplate));
        aVar.a(new bk(new bk.a() { // from class: com.kwad.components.core.webview.b.1
            @Override // com.kwad.components.core.webview.jshandler.bk.a
            public final void uR() {
                if (com.kwad.sdk.core.response.b.b.dO(b.this.mAdTemplate)) {
                    com.kwad.components.core.e.c.b.a(b.this.gC.UO.getContext(), new b.a().aB(b.this.mAdTemplate).ap(com.kwad.sdk.core.response.b.b.dN(b.this.mAdTemplate)).pi());
                }
            }
        }));
        aVar.a(new ak(this.gC));
        aVar.a(new at(this.adI, this.mPageUrl));
        ax axVar = new ax();
        this.adE = axVar;
        aVar.a(axVar);
        aVar.a(new aa(new com.kwad.sdk.core.webview.d.a.b() { // from class: com.kwad.components.core.webview.b.6
            @Override // com.kwad.sdk.core.webview.d.a.b
            public final void b(WebCloseStatus webCloseStatus) {
                if (b.this.kH != null) {
                    b.this.kH.a(webCloseStatus);
                }
            }
        }));
        s sVar = new s();
        sVar.a(new s.a() { // from class: com.kwad.components.core.webview.b.7
            @Override // com.kwad.components.core.webview.tachikoma.b.s.a
            public final void a(t tVar) {
                if (TextUtils.isEmpty(tVar.message)) {
                    return;
                }
                com.kwad.sdk.utils.ac.d(b.this.gC.UO.getContext(), tVar.message, 0L);
            }
        });
        aVar.a(sVar);
        aVar.a(new k());
        aVar.a(new aj(bVar));
        if (com.kwad.sdk.core.response.b.a.aJ(com.kwad.sdk.core.response.b.e.eP(this.mAdTemplate))) {
            final l lVar = new l();
            aVar.a(lVar);
            this.adF = new e(this.mAdTemplate) { // from class: com.kwad.components.core.webview.b.8
                @Override // com.kwad.sdk.core.download.e, com.kwad.sdk.core.download.d
                public final void b(String str, String str2, com.kwad.sdk.core.download.f fVar) {
                    super.b(str, str2, fVar);
                    com.kwad.components.core.webview.tachikoma.c.b bVar2 = new com.kwad.components.core.webview.tachikoma.c.b();
                    bVar2.aiU = 1;
                    lVar.a(bVar2);
                }
            };
            com.kwad.sdk.core.download.c.ZJ().a(this.adF, this.mAdTemplate);
        }
        aVar.a(new com.kwad.components.core.webview.tachikoma.b.d() { // from class: com.kwad.components.core.webview.b.9
            @Override // com.kwad.components.core.webview.tachikoma.b.d
            public final void a(g gVar) {
                com.kwad.components.core.q.a.ss().a(gVar.actionType, b.this.mAdTemplate, gVar.QX);
            }
        });
        aVar.a(new j() { // from class: com.kwad.components.core.webview.b.10
            @Override // com.kwad.components.core.webview.tachikoma.b.j
            public final void a(com.kwad.components.core.webview.tachikoma.c.o oVar) {
                super.a(oVar);
                AdWebViewActivityProxy.launch(b.this.gC.UO.getContext(), new AdWebViewActivityProxy.a.C0479a().aE(oVar.title).aF(oVar.url).aG(true).aE(b.this.mAdTemplate).rk());
            }
        });
        aVar.a(new com.kwad.components.core.webview.jshandler.f());
        aVar.a(new i());
        aVar.a(new com.kwad.components.core.webview.jshandler.l());
        aVar.a(new com.kwad.components.core.webview.jshandler.e());
        ae aeVar = new ae(this.gC);
        aeVar.a(new ae.b() { // from class: com.kwad.components.core.webview.b.11
            @Override // com.kwad.components.core.webview.jshandler.ae.b
            public final void c(ae.a aVar2) {
                if (b.this.kH != null) {
                    b.this.kH.b(aVar2);
                }
            }
        });
        aVar.a(aeVar);
        aVar.a(new m(this.gC.UO.getContext(), this.mAdTemplate));
        aVar.a(new am(this.gC, new am.b() { // from class: com.kwad.components.core.webview.b.12
            @Override // com.kwad.components.core.webview.jshandler.am.b
            public final void a(am.a aVar2) {
                if (b.this.kH != null) {
                    b.this.kH.a(aVar2);
                }
            }
        }));
        aVar.a(new com.kwad.components.core.webview.jshandler.k());
        aVar.a(new u());
        aVar.a(new com.kwad.components.core.webview.jshandler.t());
        aVar.a(new com.kwad.components.core.webview.jshandler.s());
        aVar.a(new com.kwad.components.core.webview.jshandler.a.f(this.gC.getContext()));
        aVar.a(new com.kwad.components.core.webview.jshandler.a.d(this.gC.getContext()));
        aVar.a(new com.kwad.components.core.webview.jshandler.a.b(this.adH));
        aVar.a(new com.kwad.components.core.webview.jshandler.a.a());
        aVar.a(new com.kwad.components.core.webview.jshandler.a.e(this.gC.getContext()));
    }

    private boolean uL() {
        c cVar = this.kH;
        if (cVar == null) {
            return false;
        }
        return cVar.rI();
    }

    private void a(ba baVar) {
        c cVar = this.kH;
        if (cVar == null) {
            return;
        }
        cVar.a(baVar);
    }

    private com.kwad.sdk.core.webview.d.a.a getClickListener() {
        return new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.core.webview.b.2
            @Override // com.kwad.sdk.core.webview.d.a.a
            public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
                if (b.this.kH != null) {
                    b.this.kH.a(aVar);
                }
            }
        };
    }

    private an.b uN() {
        return new an.b() { // from class: com.kwad.components.core.webview.b.3
            @Override // com.kwad.components.core.webview.jshandler.an.b
            public final void onAdShow() {
                if (b.this.kH != null) {
                    b.this.kH.onAdShow();
                }
            }
        };
    }

    private KsAdWebView.b uO() {
        return new KsAdWebView.b() { // from class: com.kwad.components.core.webview.b.4
            @Override // com.kwad.sdk.core.webview.KsAdWebView.b
            public final void onSuccess() {
                if (b.this.adE != null) {
                    b.this.adE.onSuccess();
                }
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.b
            public final void onFailed() {
                if (b.this.adE != null) {
                    b.this.adE.onFailed();
                }
            }
        };
    }

    private KsAdWebView.e uP() {
        return new KsAdWebView.e() { // from class: com.kwad.components.core.webview.b.5
            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onPageStart() {
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onReceivedHttpError(int i, String str, String str2) {
                if (b.this.kH != null) {
                    b.this.kH.h(i, str);
                }
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onPageFinished() {
                if (b.this.kH != null) {
                    b.this.kH.onPageFinished();
                }
            }
        };
    }

    private int uQ() {
        return com.kwad.sdk.core.response.b.a.T(com.kwad.sdk.core.response.b.e.eP(this.mAdTemplate)) ? 5 : 1;
    }

    private void bk() {
        com.kwad.components.core.webview.a aVar = this.gB;
        if (aVar != null) {
            aVar.destroy();
            this.gB = null;
        }
        com.kwad.components.core.webview.a.a aVar2 = this.adD;
        if (aVar2 != null) {
            aVar2.destroy();
            this.adD = null;
        }
    }

    public final void kD() {
        bk();
        if (this.adF != null) {
            com.kwad.sdk.core.download.c.ZJ().a(this.adF);
        }
        this.adH = null;
    }

    private static void a(c cVar, WebView webView) {
        if (cVar == null || !cVar.rH()) {
            return;
        }
        webView.getSettings().setAllowFileAccess(true);
    }

    public static class a {
        private KsAdWebView NS;
        private KsAdWebView.c Vz;
        private ViewGroup adC;
        private boolean adG;
        private com.kwad.components.core.webview.jshandler.a.c adH;
        private c kH;
        private AdTemplate mAdTemplate;
        private com.kwad.components.core.e.d.c mApkDownloadHelper;
        private String mPageUrl;
        private JSONObject mReportExtData;

        public final String rf() {
            return this.mPageUrl;
        }

        public final a aX(String str) {
            this.mPageUrl = str;
            return this;
        }

        public final AdTemplate getAdTemplate() {
            return this.mAdTemplate;
        }

        public final a aN(AdTemplate adTemplate) {
            this.mAdTemplate = adTemplate;
            return this;
        }

        public final ViewGroup uS() {
            return this.adC;
        }

        public final a k(ViewGroup viewGroup) {
            this.adC = viewGroup;
            return this;
        }

        public final KsAdWebView uT() {
            return this.NS;
        }

        public final a d(KsAdWebView ksAdWebView) {
            this.NS = ksAdWebView;
            return this;
        }

        public final c uU() {
            return this.kH;
        }

        public final a a(c cVar) {
            this.kH = cVar;
            return this;
        }

        public final a f(com.kwad.components.core.e.d.c cVar) {
            this.mApkDownloadHelper = cVar;
            return this;
        }

        public final com.kwad.components.core.e.d.c in() {
            return this.mApkDownloadHelper;
        }

        public final KsAdWebView.c rA() {
            return this.Vz;
        }

        public final a b(KsAdWebView.c cVar) {
            this.Vz = cVar;
            return this;
        }

        public final a e(JSONObject jSONObject) {
            this.mReportExtData = jSONObject;
            return this;
        }

        public final boolean uV() {
            return this.adG;
        }

        public final a aZ(boolean z) {
            this.adG = z;
            return this;
        }

        public final com.kwad.components.core.webview.jshandler.a.c uW() {
            return this.adH;
        }

        public final a a(com.kwad.components.core.webview.jshandler.a.c cVar) {
            this.adH = cVar;
            return this;
        }
    }
}
