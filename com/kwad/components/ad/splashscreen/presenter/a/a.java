package com.kwad.components.ad.splashscreen.presenter.a;

import android.os.SystemClock;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.kwad.components.ad.splashscreen.f;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.ba;
import com.kwad.components.core.webview.jshandler.j;
import com.kwad.components.core.webview.jshandler.p;
import com.kwad.components.core.webview.jshandler.z;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.b.m;
import com.kwad.components.core.webview.tachikoma.b.u;
import com.kwad.sdk.R;
import com.kwad.sdk.components.t;
import com.kwad.sdk.utils.bh;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends c implements com.kwad.sdk.core.j.c {
    private m KT;
    private boolean KW = false;
    f Kp = new f() { // from class: com.kwad.components.ad.splashscreen.presenter.a.a.4
        @Override // com.kwad.components.ad.splashscreen.f
        public final void lG() {
            a.this.eI.postDelayed(new Runnable() { // from class: com.kwad.components.ad.splashscreen.presenter.a.a.4.1
                @Override // java.lang.Runnable
                public final void run() {
                    a.this.eI.setVisibility(8);
                }
            }, 500L);
            if (a.this.eK != null) {
                a.this.eK.vf();
                a.this.eK.vg();
            }
        }
    };
    private FrameLayout eI;
    private ba eK;

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTKReaderScene() {
        return "tk_splash";
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.eI = (FrameLayout) findViewById(R.id.splash_full_tk_play_card_view);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTkTemplateId() {
        return com.kwad.sdk.core.response.b.b.cH(this.HX.mAdTemplate).splashPlayCardTKInfo.templateId;
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.a.c
    protected final int nj() {
        return (int) (com.kwad.sdk.core.response.b.b.dV(this.HX.mAdTemplate) - (SystemClock.elapsedRealtime() - this.HX.Hr));
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
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(TKRenderFailReason tKRenderFailReason) {
        ba baVar = this.eK;
        if (baVar != null) {
            baVar.vf();
            this.eK.vg();
        }
        this.eI.setVisibility(8);
        nl();
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void aE() {
        ba baVar;
        if (this.HX.dA) {
            return;
        }
        ba baVar2 = this.eK;
        if (baVar2 != null) {
            baVar2.vd();
            this.eK.ve();
        }
        if (this.KW && (baVar = this.eK) != null) {
            baVar.vh();
        }
        this.eI.setVisibility(0);
    }

    private void nl() {
        if (this.HX.Hi != null) {
            this.HX.Hi.no();
        }
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
        tVar.c(nm());
        tVar.c(new j(new p() { // from class: com.kwad.components.ad.splashscreen.presenter.a.a.1
            @Override // com.kwad.components.core.webview.jshandler.p
            public final void a(j jVar, String str) {
                if (TextUtils.equals(str, "getSplashShowStartTime")) {
                    jVar.P(a.this.HX.mAdTemplate.showTime);
                }
            }
        }));
    }

    private m nk() {
        m mVar = new m();
        this.KT = mVar;
        return mVar;
    }

    private z a(com.kwad.sdk.core.webview.b bVar) {
        return new z(bVar, this.HX.mApkDownloadHelper, new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ad.splashscreen.presenter.a.a.2
            @Override // com.kwad.sdk.core.webview.d.a.a
            public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
                if (aVar != null) {
                    a.this.HX.mRootContainer.post(new bh() { // from class: com.kwad.components.ad.splashscreen.presenter.a.a.2.1
                        @Override // com.kwad.sdk.utils.bh
                        public final void doTask() {
                            a.this.HX.ab();
                        }
                    });
                }
            }
        });
    }

    private u nm() {
        u uVar = new u();
        uVar.a(new u.a() { // from class: com.kwad.components.ad.splashscreen.presenter.a.a.3
            @Override // com.kwad.components.core.webview.tachikoma.b.u.a
            public final void a(final u.b bVar) {
                int i = bVar.status;
                if (i == 1) {
                    a.this.HX.mRootContainer.post(new bh() { // from class: com.kwad.components.ad.splashscreen.presenter.a.a.3.1
                        @Override // com.kwad.sdk.utils.bh
                        public final void doTask() {
                            if (com.kwad.components.core.e.c.b.pe()) {
                                a.this.HX.mRootContainer.postDelayed(this, 1000L);
                            } else {
                                a.this.HX.lU();
                            }
                        }
                    });
                    return;
                }
                if (i == 2) {
                    a.this.HX.mRootContainer.post(new bh() { // from class: com.kwad.components.ad.splashscreen.presenter.a.a.3.2
                        @Override // com.kwad.sdk.utils.bh
                        public final void doTask() {
                            com.kwad.components.ad.splashscreen.monitor.a.mb().ai(a.this.HX.mAdTemplate);
                            a.this.HX.lW();
                        }
                    });
                } else if (i == 3) {
                    a.this.HX.mRootContainer.post(new bh() { // from class: com.kwad.components.ad.splashscreen.presenter.a.a.3.3
                        @Override // com.kwad.sdk.utils.bh
                        public final void doTask() {
                            a.this.HX.lL();
                        }
                    });
                } else if (i == 4) {
                    a.this.HX.mRootContainer.post(new bh() { // from class: com.kwad.components.ad.splashscreen.presenter.a.a.3.4
                        @Override // com.kwad.sdk.utils.bh
                        public final void doTask() {
                            a.this.HX.c(bVar.errorCode, bVar.errorMsg);
                        }
                    });
                }
            }
        });
        return uVar;
    }

    @Override // com.kwad.sdk.core.j.c
    public final void by() {
        if (this.HX.dA) {
            return;
        }
        ba baVar = this.eK;
        if (baVar != null) {
            baVar.vh();
        } else {
            this.KW = true;
        }
    }

    @Override // com.kwad.sdk.core.j.c
    public final void bz() {
        ba baVar;
        if (this.HX.dA || (baVar = this.eK) == null) {
            return;
        }
        baVar.vi();
    }
}
