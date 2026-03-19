package com.kwad.components.ad.splashscreen.presenter.playcard;

import android.os.SystemClock;
import android.widget.FrameLayout;
import com.kwad.components.ad.splashscreen.f;
import com.kwad.components.ad.splashscreen.g;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.ba;
import com.kwad.components.core.webview.jshandler.z;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.b.m;
import com.kwad.sdk.R;
import com.kwad.sdk.components.t;
import com.kwad.sdk.core.response.b.e;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class d extends com.kwad.components.ad.splashscreen.presenter.a.c implements g, com.kwad.sdk.core.j.c {
    private m KT;
    f Kp = new f() { // from class: com.kwad.components.ad.splashscreen.presenter.playcard.d.2
        @Override // com.kwad.components.ad.splashscreen.f
        public final void lG() {
            d.this.eI.setVisibility(8);
            if (d.this.eK != null) {
                d.this.eK.vf();
                d.this.eK.vg();
            }
        }
    };
    private FrameLayout eI;
    private ba eK;

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTKReaderScene() {
        return "tk_splash";
    }

    @Override // com.kwad.components.ad.splashscreen.g
    public final void lK() {
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.eI = (FrameLayout) findViewById(R.id.splash_tk_play_card_view);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTkTemplateId() {
        return com.kwad.sdk.core.response.b.b.ej(this.HX.mAdTemplate);
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.a.c
    public final int nj() {
        return (int) (com.kwad.sdk.core.response.b.b.dU(e.eP(this.HX.mAdTemplate)) - (SystemClock.elapsedRealtime() - this.HX.Hr));
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final FrameLayout getTKContainer() {
        return this.eI;
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.a.c, com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        com.kwad.components.ad.splashscreen.monitor.b.md();
        com.kwad.components.ad.splashscreen.monitor.b.b(this.HX.mAdTemplate, this.HX.Hj);
        this.HX.Hk.a(this);
        this.HX.a(this);
        this.HX.a(this.Kp);
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.a.c, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        ba baVar = this.eK;
        if (baVar != null) {
            baVar.vf();
            this.eK.vg();
        }
        super.onUnbind();
        this.HX.Hk.b(this);
        this.HX.b(this.Kp);
        this.HX.b(this);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(TKRenderFailReason tKRenderFailReason) {
        ba baVar = this.eK;
        if (baVar != null) {
            baVar.vf();
            this.eK.vg();
        }
        this.eI.setVisibility(8);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void aE() {
        if (this.HX.dA) {
            return;
        }
        ba baVar = this.eK;
        if (baVar != null) {
            baVar.vd();
            this.eK.ve();
        }
        this.eI.setVisibility(0);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(ae.a aVar) {
        aVar.width = com.kwad.sdk.c.a.a.px2dip(getContext(), this.HX.mRootContainer.getWidth());
        aVar.height = com.kwad.sdk.c.a.a.px2dip(getContext(), this.HX.mRootContainer.getHeight());
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.a.c, com.kwad.components.core.webview.tachikoma.j
    public final void a(ba baVar) {
        super.a(baVar);
        this.eK = baVar;
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.a.c, com.kwad.components.core.webview.tachikoma.j
    public final void a(t tVar, com.kwad.sdk.core.webview.b bVar) {
        super.a(tVar, bVar);
        tVar.c(a(bVar));
        tVar.c(nk());
    }

    private m nk() {
        m mVar = new m();
        this.KT = mVar;
        return mVar;
    }

    private z a(com.kwad.sdk.core.webview.b bVar) {
        return new z(bVar, this.HX.mApkDownloadHelper, new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ad.splashscreen.presenter.playcard.d.1
            @Override // com.kwad.sdk.core.webview.d.a.a
            public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
                if (aVar != null) {
                    d.this.HX.mRootContainer.post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.presenter.playcard.d.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            d.this.HX.ab();
                        }
                    });
                }
            }
        });
    }

    @Override // com.kwad.sdk.core.j.c
    public final void by() {
        ba baVar;
        if (this.HX.dA || (baVar = this.eK) == null) {
            return;
        }
        baVar.vh();
    }

    @Override // com.kwad.sdk.core.j.c
    public final void bz() {
        ba baVar;
        if (this.HX.dA || (baVar = this.eK) == null) {
            return;
        }
        baVar.vi();
    }

    @Override // com.kwad.components.ad.splashscreen.g
    public final void ak(int i) {
        m mVar = this.KT;
        if (mVar != null) {
            mVar.bq(i);
        }
    }
}
