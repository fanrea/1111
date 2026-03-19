package com.kwad.components.core.page.c;

import android.text.TextUtils;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.ag;
import com.kwad.components.core.webview.jshandler.aj;
import com.kwad.components.core.webview.jshandler.an;
import com.kwad.components.core.webview.jshandler.ar;
import com.kwad.components.core.webview.jshandler.at;
import com.kwad.components.core.webview.jshandler.ba;
import com.kwad.components.core.webview.jshandler.bd;
import com.kwad.components.core.webview.jshandler.n;
import com.kwad.components.core.webview.jshandler.o;
import com.kwad.components.core.webview.jshandler.z;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class f extends c {
    private WebView UO;
    private int Vt = -1;
    private ViewGroup Vu;
    private final a Vv;
    private com.kwad.components.core.webview.a gB;
    private com.kwad.sdk.core.webview.b gC;
    private AdTemplate mAdTemplate;
    private final boolean mIsRewardLandPage;

    public interface a {
        void aV(int i);
    }

    public f(a aVar, boolean z) {
        this.Vv = aVar;
        this.mIsRewardLandPage = z;
    }

    @Override // com.kwad.components.core.page.c.c, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        AdTemplate adTemplate = this.Vr.mAdTemplate;
        this.mAdTemplate = adTemplate;
        String strDe = com.kwad.sdk.core.response.b.b.de(adTemplate);
        if (!TextUtils.isEmpty(strDe)) {
            bh();
            aG(strDe);
        } else {
            a aVar = this.Vv;
            if (aVar != null) {
                aVar.aV(this.Vt);
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        bk();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.UO = (WebView) findViewById(R.id.ksad_landing_page_webview);
        this.Vu = (ViewGroup) findViewById(R.id.ksad_web_card_container);
        this.UO.setBackgroundColor(0);
    }

    private void bh() {
        com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
        this.gC = bVar;
        bVar.setAdTemplate(this.mAdTemplate);
        this.gC.Vu = this.Vu;
        this.gC.UO = this.UO;
    }

    private void aG(String str) {
        bj();
        this.UO.loadUrl(str);
    }

    private void bj() {
        bk();
        com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(this.UO);
        this.gB = aVar;
        a(aVar);
        this.UO.addJavascriptInterface(this.gB, "KwaiAd");
    }

    private void a(com.kwad.components.core.webview.a aVar) {
        com.kwad.sdk.core.d.c.d("LandPageWebViewPresenter", "registerWebCardHandler");
        com.kwad.components.core.e.d.c cVar = new com.kwad.components.core.e.d.c(this.Vr.mAdTemplate);
        aVar.a(new ag(this.gC));
        aVar.a(new aj(this.gC));
        aVar.a(new bd(this.gC, cVar));
        aVar.a(new ae(this.gC));
        aVar.a(new ba());
        aVar.a(new at(rr(), com.kwad.sdk.core.response.b.b.de(this.mAdTemplate)));
        aVar.a(new an(this.gC));
        aVar.b(new o(this.gC));
        aVar.b(new n(this.gC));
        aVar.a(new ar(getOpenNewPageListener()));
        aVar.a(new ac(this.gC, cVar, null, (byte) 0));
        aVar.a(new z(this.gC, cVar, null, 2, this.mIsRewardLandPage));
    }

    private at.b rr() {
        return new at.b() { // from class: com.kwad.components.core.page.c.f.1
            @Override // com.kwad.components.core.webview.jshandler.at.b
            public final void a(at.a aVar) {
                f.this.Vt = aVar.status;
                if (f.this.Vv != null) {
                    f.this.Vv.aV(aVar.status);
                }
                if (aVar.status == 1) {
                    f.this.Vu.setVisibility(0);
                } else {
                    f.this.UO.setVisibility(8);
                }
            }
        };
    }

    private ar.a getOpenNewPageListener() {
        return new ar.a() { // from class: com.kwad.components.core.page.c.f.2
            @Override // com.kwad.components.core.webview.jshandler.ar.a
            public final void a(com.kwad.components.core.webview.a.b bVar) {
                AdWebViewActivityProxy.launch(f.this.UO.getContext(), new AdWebViewActivityProxy.a.C0479a().aE(bVar.title).aF(bVar.url).aG(true).aE(f.this.mAdTemplate).rk());
            }
        };
    }

    private void bk() {
        com.kwad.components.core.webview.a aVar = this.gB;
        if (aVar != null) {
            aVar.destroy();
            this.gB = null;
        }
    }
}
