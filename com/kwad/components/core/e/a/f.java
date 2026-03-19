package com.kwad.components.core.e.a;

import android.app.Activity;
import android.widget.FrameLayout;
import com.kwad.components.core.webview.jshandler.a;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.ba;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.b.o;
import com.kwad.components.core.webview.tachikoma.b.p;
import com.kwad.components.core.webview.tachikoma.c.n;
import com.kwad.components.core.webview.tachikoma.c.u;
import com.kwad.components.core.webview.tachikoma.i;
import com.kwad.components.core.webview.tachikoma.j;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.t;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.bx;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class f extends Presenter implements j, com.kwad.sdk.core.j.c {
    private com.kwad.components.core.widget.a.c PZ;
    private a Qj;
    private ba gE;
    private i hF;
    private AdTemplate mAdTemplate;

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(a.C0490a c0490a) {
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
    public final void a(t tVar, com.kwad.sdk.core.webview.b bVar) {
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
    public final String getRegisterViewKey() {
        return null;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTKReaderScene() {
        return "tk_installed_activate";
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        a aVar = (a) amf();
        this.Qj = aVar;
        this.mAdTemplate = aVar.mAdTemplate;
        this.PZ = this.Qj.PZ;
        this.hF = new i(getContext()) { // from class: com.kwad.components.core.e.a.f.1
            @Override // com.kwad.components.core.webview.tachikoma.i
            public final boolean oX() {
                return true;
            }
        };
        this.hF.a((Activity) null, com.kwad.sdk.core.response.b.c.ev(this.mAdTemplate), this);
        this.PZ.a(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.hF.kD();
        this.PZ.b(this);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTkTemplateId() {
        return com.kwad.sdk.core.response.b.b.cH(this.mAdTemplate).installedActivateInfo.templateId;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final com.kwad.sdk.widget.i getTouchCoordsView() {
        return this.Qj.PY;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final FrameLayout getTKContainer() {
        return this.Qj.PY;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(TKRenderFailReason tKRenderFailReason) {
        com.kwad.sdk.core.d.c.d("InstalledActivatePresenter", "onTkLoadFailed");
        ak(true);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void aE() {
        com.kwad.sdk.core.d.c.d("InstalledActivatePresenter", "onTkLoadSuccess");
        this.Qj.aa();
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
        com.kwad.sdk.core.d.c.d("InstalledActivatePresenter", "onAdClicked");
        ak(false);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(ae.a aVar) {
        float fBv = com.kwad.sdk.c.a.a.bv(getContext());
        float screenHeight = com.kwad.sdk.c.a.a.getScreenHeight(getContext());
        aVar.width = (int) ((com.kwad.sdk.c.a.a.getScreenWidth(getContext()) / fBv) + 0.5f);
        aVar.height = (int) ((screenHeight / fBv) + 0.5f);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(WebCloseStatus webCloseStatus) {
        ak(false);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(ba baVar) {
        this.gE = baVar;
        this.Qj.gE = baVar;
    }

    @Override // com.kwad.sdk.core.j.c
    public final void by() {
        com.kwad.sdk.core.d.c.d("InstalledActivatePresenter", "onPageVisible");
        ba baVar = this.gE;
        if (baVar != null) {
            baVar.vh();
        }
    }

    @Override // com.kwad.sdk.core.j.c
    public final void bz() {
        com.kwad.sdk.core.d.c.d("InstalledActivatePresenter", "onPageInvisible");
        ba baVar = this.gE;
        if (baVar != null) {
            baVar.vi();
        }
    }

    private void ak(boolean z) {
        if (!z) {
            this.Qj.ac();
        }
        bx.runOnUiThread(new bh() { // from class: com.kwad.components.core.e.a.f.2
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                f.this.Qj.Qa.oR();
            }
        });
    }
}
