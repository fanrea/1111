package com.kwad.components.ad.interstitial.f.a;

import com.kwad.components.core.webview.jshandler.a;
import com.kwad.components.core.webview.jshandler.ba;
import com.kwad.components.core.webview.tachikoma.b.i;
import com.kwad.components.core.webview.tachikoma.b.o;
import com.kwad.components.core.webview.tachikoma.b.p;
import com.kwad.components.core.webview.tachikoma.c.n;
import com.kwad.components.core.webview.tachikoma.c.u;
import com.kwad.components.core.webview.tachikoma.i;
import com.kwad.components.core.webview.tachikoma.j;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.t;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public abstract class a extends com.kwad.components.ad.interstitial.f.b implements j {
    private i hF;

    @Override // com.kwad.components.core.webview.tachikoma.j
    public void a(ba baVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(p pVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(n nVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public void a(u uVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public void a(WebCloseStatus webCloseStatus) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void g(AdTemplate adTemplate) {
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void onCreate() {
        super.onCreate();
        this.hF = new i(-1L, getContext());
    }

    @Override // com.kwad.components.ad.interstitial.f.b, com.kwad.sdk.mvp.Presenter
    public void ay() {
        super.ay();
        this.hF.a(getActivity(), this.oa.mAdResultData, this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void onUnbind() {
        super.onUnbind();
        i iVar = this.hF;
        if (iVar != null) {
            iVar.kD();
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public com.kwad.sdk.widget.i getTouchCoordsView() {
        return this.oa.hG;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public void a(t tVar, com.kwad.sdk.core.webview.b bVar) {
        tVar.c(new com.kwad.components.core.webview.tachikoma.b.i(new i.a() { // from class: com.kwad.components.ad.interstitial.f.a.a.1
            @Override // com.kwad.components.core.webview.tachikoma.b.i.a
            public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
                com.kwad.components.ad.interstitial.report.a.eT().a(a.this.oa.mAdTemplate, 1L, 177L);
                a.this.a(aVar);
            }
        }));
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(a.C0490a c0490a) {
        if (this.oa == null || this.oa.mH == null) {
            return;
        }
        String str = c0490a.adW;
        str.hashCode();
        switch (str) {
            case "adSkipCallback":
                this.oa.mH.onSkippedAd();
                break;
            case "adShowCallback":
                this.oa.mH.onAdShow();
                break;
            case "adCloseCallback":
                this.oa.mH.onAdClosed();
                break;
            case "adAutoCloseCallback":
                this.oa.mH.onPageDismiss();
                break;
            case "adClickCallback":
                this.oa.mH.onAdClicked();
                break;
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
        this.oa.oc = true;
        this.oa.c(aVar.bMs, aVar.oz);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(o oVar) {
        n nVar = new n();
        nVar.ajg = !this.oa.dG.isVideoSoundEnable();
        oVar.c(nVar);
    }
}
