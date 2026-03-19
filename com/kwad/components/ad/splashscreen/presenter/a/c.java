package com.kwad.components.ad.splashscreen.presenter.a;

import android.app.Activity;
import com.kwad.components.ad.splashscreen.presenter.e;
import com.kwad.components.core.webview.jshandler.a;
import com.kwad.components.core.webview.jshandler.ba;
import com.kwad.components.core.webview.tachikoma.b.o;
import com.kwad.components.core.webview.tachikoma.b.p;
import com.kwad.components.core.webview.tachikoma.c.n;
import com.kwad.components.core.webview.tachikoma.c.u;
import com.kwad.components.core.webview.tachikoma.j;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.t;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.widget.i;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public abstract class c extends e implements j {
    private b Lc;

    public void a(ba baVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(o oVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(p pVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(n nVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(u uVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public void a(WebCloseStatus webCloseStatus) {
    }

    public void a(t tVar, com.kwad.sdk.core.webview.b bVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void aF() {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void aG() {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void g(AdTemplate adTemplate) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public String getRegisterViewKey() {
        return null;
    }

    protected int nj() {
        return 1000;
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public void ay() {
        super.ay();
        int iNj = nj();
        b bVar = new b(getContext(), iNj, iNj);
        this.Lc = bVar;
        bVar.a((Activity) null, this.HX.mAdResultData, this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void onUnbind() {
        super.onUnbind();
        this.Lc.kD();
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public i getTouchCoordsView() {
        return this.HX.mRootContainer;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(a.C0490a c0490a) {
        String str = c0490a.adW;
        str.hashCode();
        switch (str) {
            case "adShowCallback":
                this.HX.lN();
                break;
            case "adDownloadConfirmTipCancel":
                this.HX.lS();
                break;
            case "adCloseCallback":
                this.HX.lP();
                break;
            case "adDownloadConfirmTipShow":
                this.HX.lR();
                break;
            case "adDownloadConfirmTipDismiss":
                this.HX.lT();
                break;
            case "adAutoCloseCallback":
                this.HX.lO();
                break;
            case "adShowErrorCallback":
                this.HX.lM();
                break;
            case "adClickCallback":
                this.HX.lQ();
                break;
        }
    }
}
