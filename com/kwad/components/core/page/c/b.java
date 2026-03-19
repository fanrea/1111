package com.kwad.components.core.page.c;

import com.kwad.components.core.webview.jshandler.ag;
import com.kwad.components.core.webview.jshandler.aj;
import com.kwad.components.core.webview.jshandler.an;
import com.kwad.components.core.webview.jshandler.at;
import com.kwad.components.core.webview.jshandler.n;
import com.kwad.components.core.webview.jshandler.o;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.mvp.Presenter;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends Presenter {
    private com.kwad.components.core.webview.a gB;
    private com.kwad.sdk.core.webview.b gC;
    private at.b gI = new at.b() { // from class: com.kwad.components.core.page.c.b.1
        @Override // com.kwad.components.core.webview.jshandler.at.b
        public final void a(at.a aVar) {
        }
    };
    private AdTemplate mAdTemplate;
    private KsAdWebView mAdWebView;

    private void bj() {
        bk();
        com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(this.mAdWebView);
        this.gB = aVar;
        a(aVar);
        this.mAdWebView.addJavascriptInterface(this.gB, "KwaiAd");
    }

    private void bk() {
        com.kwad.components.core.webview.a aVar = this.gB;
        if (aVar != null) {
            aVar.destroy();
            this.gB = null;
        }
    }

    private void bh() {
        com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
        this.gC = bVar;
        bVar.setAdTemplate(this.mAdTemplate);
        this.gC.mScreenOrientation = 0;
        this.gC.UO = this.mAdWebView;
    }

    private void a(com.kwad.components.core.webview.a aVar) {
        aVar.a(new ag(this.gC));
        aVar.a(new aj(this.gC));
        aVar.a(new at(this.gI, com.kwad.sdk.core.response.b.a.aW(com.kwad.sdk.core.response.b.e.eP(this.mAdTemplate))));
        aVar.a(new an(this.gC));
        aVar.b(new o(this.gC));
        aVar.b(new n(this.gC));
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.mAdTemplate = ((com.kwad.components.core.page.recycle.e) amf()).adTemplate;
        KsAdWebView ksAdWebView = (KsAdWebView) getRootView().findViewById(R.id.ksad_video_webView);
        this.mAdWebView = ksAdWebView;
        this.mAdWebView.setClientConfig(ksAdWebView.getClientConfig().cK(true).fj(this.mAdTemplate));
        bh();
        bj();
        this.mAdWebView.loadUrl(com.kwad.sdk.core.response.b.a.aW(com.kwad.sdk.core.response.b.e.eP(this.mAdTemplate)));
        this.mAdWebView.onActivityCreate();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        bk();
        KsAdWebView ksAdWebView = this.mAdWebView;
        if (ksAdWebView != null) {
            ksAdWebView.onActivityDestroy();
            this.mAdWebView = null;
        }
    }
}
