package com.kwad.components.core.webview.tachikoma.d;

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

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public abstract class a extends Presenter implements j {
    protected b ajp;
    protected i hF;

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(o oVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public void a(p pVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(n nVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public void a(u uVar) {
    }

    protected void a(b bVar) {
    }

    public void a(t tVar, com.kwad.sdk.core.webview.b bVar) {
    }

    public void a(com.kwad.sdk.core.webview.d.b.a aVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public void aF() {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void g(AdTemplate adTemplate) {
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void ay() {
        super.ay();
        b bVar = (b) amf();
        this.ajp = bVar;
        a(bVar);
        if (this.hF == null) {
            this.hF = jc();
        }
        if (this.ajp.ZR != null) {
            this.hF.a(this.ajp.ZR);
        }
        this.hF.a(this.ajp.mActivity, this.ajp.mAdResultData, this);
    }

    protected i jc() {
        return new i(this.ajp.CF, getContext());
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.hF.kD();
        this.hF = null;
    }

    public void a(WebCloseStatus webCloseStatus) {
        if (this.ajp.ahi != null) {
            this.ajp.ahi.dismiss();
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public com.kwad.sdk.widget.i getTouchCoordsView() {
        return this.ajp.ajq;
    }
}
