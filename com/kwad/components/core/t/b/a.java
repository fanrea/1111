package com.kwad.components.core.t.b;

import android.widget.FrameLayout;
import com.kwad.components.core.proxy.f;
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
import com.kwad.sdk.R;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.t;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.c.g;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.bs;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends Presenter implements j {
    private FrameLayout aac;
    private ba aad;
    protected boolean aae;
    protected com.kwad.components.core.t.a.b aaf;
    private com.kwad.components.core.n.a.a aag = new com.kwad.components.core.n.a.a() { // from class: com.kwad.components.core.t.b.a.1
        @Override // com.kwad.components.core.n.a.a
        public final void hc() {
        }

        @Override // com.kwad.components.core.n.a.a
        public final void c(f fVar) {
            a.this.tj();
        }

        @Override // com.kwad.components.core.n.a.a
        public final void d(f fVar) {
            a.this.tk();
        }

        @Override // com.kwad.components.core.n.a.a
        public final void hd() {
            a.this.tl();
        }
    };
    private i hF;

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(a.C0490a c0490a) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(TKRenderFailReason tKRenderFailReason) {
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
    public final String getRegisterViewKey() {
        return null;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTKReaderScene() {
        return "tk_activity";
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.aaf = (com.kwad.components.core.t.a.b) amf();
        this.aac = (FrameLayout) findViewById(R.id.ksad_js_container);
        i iVar = new i(getContext(), 1000, 0);
        this.hF = iVar;
        iVar.a(this.aaf.ZR);
        if (this.aaf.ZV != null) {
            this.aaf.ZV.a(this.hF);
            this.hF.a(new g() { // from class: com.kwad.components.core.t.b.a.2
                @Override // com.kwad.sdk.core.webview.c.g
                public final void callTKBridge(String str) {
                    if (a.this.aaf.ZV != null) {
                        a.this.aaf.ZV.callTKBridge(str);
                    }
                }
            });
            this.hF.a("hasTKBridge", Boolean.TRUE);
        }
        this.hF.a(getActivity(), this.aaf.mAdResultData, this);
        this.aaf.Th.add(this.aag);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        tl();
        this.hF.kD();
        this.aaf.Th.remove(this.aag);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTkTemplateId() {
        return this.aaf.ZR.templateId;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final com.kwad.sdk.widget.i getTouchCoordsView() {
        return this.aaf.mRootContainer;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final FrameLayout getTKContainer() {
        return this.aac;
    }

    private void ti() {
        ba baVar = this.aad;
        if (baVar == null) {
            return;
        }
        if (!this.aae) {
            baVar.vd();
            this.aad.ve();
            this.aae = true;
            return;
        }
        baVar.vh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tj() {
        ti();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tk() {
        ba baVar = this.aad;
        if (baVar == null || !this.aae) {
            return;
        }
        baVar.vi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tl() {
        ba baVar = this.aad;
        if (baVar == null || !this.aae) {
            return;
        }
        baVar.vf();
        this.aad.vg();
        if (this.aaf.ZV != null) {
            this.aaf.ZV.callbackDismiss();
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void aE() {
        ti();
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(ae.a aVar) {
        float fBv = com.kwad.sdk.c.a.a.bv(getContext());
        aVar.width = (int) ((bs.getScreenWidth(getContext()) / fBv) + 0.5f);
        aVar.height = (int) ((bs.getScreenHeight(getContext()) / fBv) + 0.5f);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(WebCloseStatus webCloseStatus) {
        getActivity().finish();
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(ba baVar) {
        this.aad = baVar;
    }
}
