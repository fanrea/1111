package com.kwad.components.ad.reward.n;

import android.view.View;
import android.view.ViewGroup;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.ag;
import com.kwad.components.core.webview.jshandler.aj;
import com.kwad.components.core.webview.jshandler.am;
import com.kwad.components.core.webview.jshandler.an;
import com.kwad.components.core.webview.jshandler.at;
import com.kwad.components.core.webview.jshandler.bd;
import com.kwad.components.core.webview.jshandler.bh;
import com.kwad.components.core.webview.jshandler.z;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.utils.bq;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class e extends com.kwad.sdk.core.download.a.a implements am.b, at.b {
    private View DG;
    private bh DH;
    private f DI;
    private com.kwad.components.core.webview.a gB;
    private com.kwad.sdk.core.webview.b gC;
    private com.kwad.sdk.core.webview.d.a.a gF;
    private KsAdWebView gz;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private final com.kwad.components.ad.reward.e.l mRewardVerifyListener = new com.kwad.components.ad.reward.e.l() { // from class: com.kwad.components.ad.reward.n.e.1
        @Override // com.kwad.components.ad.reward.e.l
        public final void onRewardVerify() {
            if (e.this.DH != null) {
                e.this.DH.ai(true);
            }
        }
    };

    public e(KsAdWebView ksAdWebView, View view, com.kwad.components.core.e.d.c cVar, com.kwad.sdk.core.webview.d.a.a aVar) {
        this.DG = view;
        this.gz = ksAdWebView;
        this.mApkDownloadHelper = cVar;
        this.gF = aVar;
    }

    public final void a(f fVar) {
        this.DI = fVar;
    }

    public final void a(AdTemplate adTemplate, ViewGroup viewGroup) {
        KsAdWebView ksAdWebView = this.gz;
        if (ksAdWebView != null) {
            ksAdWebView.setBackgroundColor(0);
            if (this.gz.getBackground() != null) {
                this.gz.getBackground().setAlpha(0);
            }
        }
        com.kwad.components.ad.reward.b.gp().a(this.mRewardVerifyListener);
        this.mAdTemplate = adTemplate;
        b(adTemplate, viewGroup);
        aa(com.kwad.sdk.core.response.b.b.cR(this.mAdTemplate));
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.b(this);
        }
    }

    public final void lg() {
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.c(this);
        }
        com.kwad.components.ad.reward.b.gp().b(this.mRewardVerifyListener);
    }

    private void ad(boolean z) {
        com.kwad.sdk.core.d.c.d("BottomCardWebViewHelper", "switchWebView: " + z);
        KsAdWebView ksAdWebView = this.gz;
        if (ksAdWebView == null) {
            return;
        }
        ksAdWebView.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lh() {
        View view = this.DG;
        if (view != null) {
            view.setVisibility(0);
        }
        ad(false);
    }

    private void b(AdTemplate adTemplate, ViewGroup viewGroup) {
        com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
        this.gC = bVar;
        bVar.setAdTemplate(adTemplate);
        this.gC.mScreenOrientation = 0;
        this.gC.bLv = null;
        this.gC.Vu = viewGroup;
        this.gC.UO = this.gz;
        this.gC.mReportExtData = null;
        this.gC.bLx = true;
    }

    private void aa(String str) {
        if (bq.isNullString(str)) {
            lh();
            return;
        }
        bk();
        this.gz.setClientConfig(this.gz.getClientConfig().fj(this.mAdTemplate).b(getWebErrorListener()));
        com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(this.gz);
        this.gB = aVar;
        a(aVar, str);
        this.gz.addJavascriptInterface(this.gB, "KwaiAd");
        this.gz.loadUrl(str);
    }

    private KsAdWebView.e getWebErrorListener() {
        return new KsAdWebView.e() { // from class: com.kwad.components.ad.reward.n.e.2
            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onPageFinished() {
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onPageStart() {
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onReceivedHttpError(int i, String str, String str2) {
                com.kwad.sdk.core.d.c.d("BottomCardWebViewHelper", "onReceivedHttpError: " + i + ", " + str);
                e.this.lh();
            }
        };
    }

    private void a(com.kwad.components.core.webview.a aVar, String str) {
        aVar.a(new z(this.gC, this.mApkDownloadHelper, this.gF));
        aVar.a(new ag(this.gC));
        aVar.a(new ae(this.gC));
        aVar.a(new at(this, str));
        bh bhVar = new bh();
        this.DH = bhVar;
        aVar.a(bhVar);
        aVar.a(new an(this.gC));
        aVar.b(new com.kwad.components.core.webview.jshandler.o(this.gC));
        aVar.b(new com.kwad.components.core.webview.jshandler.n(this.gC));
        aVar.a(new aj(this.gC));
        aVar.a(new com.kwad.components.core.webview.tachikoma.b.f());
        aVar.a(new am(this.gC, this));
        aVar.a(new bd(this.gC, this.mApkDownloadHelper));
        aVar.a(new com.kwad.components.ad.reward.i.b(this.gz.getContext(), this.mAdTemplate, PlayableSource.ACTIONBAR_CLICK));
    }

    private void bk() {
        com.kwad.components.core.webview.a aVar = this.gB;
        if (aVar != null) {
            aVar.destroy();
            this.gB = null;
        }
    }

    @Override // com.kwad.components.core.webview.jshandler.at.b
    public final void a(at.a aVar) {
        com.kwad.sdk.core.d.c.d("BottomCardWebViewHelper", getClass().getName() + " updatePageStatus: " + aVar);
        if (aVar.status == 1) {
            ad(true);
        } else {
            lh();
        }
    }

    @Override // com.kwad.components.core.webview.jshandler.am.b
    public final void a(am.a aVar) {
        com.kwad.sdk.core.d.c.d("BottomCardWebViewHelper", "onAdFrameValid : " + aVar.toJson());
    }

    private void k(String str, int i) {
        f fVar = this.DI;
        if (fVar != null) {
            fVar.i(str, i);
        }
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onIdle() {
        AdTemplate adTemplate = this.mAdTemplate;
        k(adTemplate != null ? com.kwad.sdk.core.response.b.a.aH(com.kwad.sdk.core.response.b.e.eP(adTemplate)) : "立即下载", 100);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onProgressUpdate(int i) {
        if (i != 0) {
            k(com.kwad.sdk.core.response.b.a.ft(i), i);
        }
    }

    @Override // com.kwad.sdk.core.download.a.a
    public final void onPaused(int i) {
        k(com.kwad.sdk.core.response.b.a.fv(i), i);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadFinished() {
        AdTemplate adTemplate = this.mAdTemplate;
        k(adTemplate == null ? "" : com.kwad.sdk.core.response.b.a.cB(adTemplate), 100);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onInstalled() {
        AdTemplate adTemplate = this.mAdTemplate;
        k(adTemplate != null ? com.kwad.sdk.core.response.b.a.ae(com.kwad.sdk.core.response.b.e.eP(adTemplate)) : "立即打开", 100);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadFailed() {
        AdTemplate adTemplate = this.mAdTemplate;
        k(adTemplate != null ? com.kwad.sdk.core.response.b.a.aH(com.kwad.sdk.core.response.b.e.eP(adTemplate)) : "立即下载", 100);
    }
}
