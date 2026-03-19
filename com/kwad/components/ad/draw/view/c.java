package com.kwad.components.ad.draw.view;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.widget.FrameLayout;
import com.kwad.components.ad.draw.c;
import com.kwad.components.core.webview.jshandler.a;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.ba;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.a.g;
import com.kwad.components.core.webview.tachikoma.b.o;
import com.kwad.components.core.webview.tachikoma.b.p;
import com.kwad.components.core.webview.tachikoma.c.n;
import com.kwad.components.core.webview.tachikoma.c.u;
import com.kwad.components.core.webview.tachikoma.c.y;
import com.kwad.components.core.webview.tachikoma.i;
import com.kwad.components.core.webview.tachikoma.j;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.t;
import com.kwad.sdk.core.c.d;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.p.m;
import com.kwad.sdk.widget.KSFrameLayout;
import java.lang.ref.WeakReference;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c extends KSFrameLayout {
    private KsDrawAd.AdInteractionListener eU;
    private boolean eY;
    private com.kwad.sdk.core.j.b fa;
    private boolean fn;
    private com.kwad.components.core.widget.a.c gR;
    private boolean gU;
    private final com.kwad.sdk.core.j.c gZ;
    private i hF;
    private KSFrameLayout hG;
    private c.a hH;
    private boolean hI;
    private int hJ;
    private boolean hK;
    private long hr;
    private AdInfo mAdInfo;
    private AdResultData mAdResultData;
    private AdTemplate mAdTemplate;
    private Context mContext;

    static /* synthetic */ boolean b(c cVar, boolean z) {
        cVar.fn = true;
        return true;
    }

    public c(Context context) {
        super(context);
        this.gZ = new com.kwad.sdk.core.j.c() { // from class: com.kwad.components.ad.draw.view.c.2
            @Override // com.kwad.sdk.core.j.c
            public final void by() {
                if (!c.this.mAdTemplate.mPvReported && c.this.eU != null && !c.this.mAdTemplate.mHasAdShow) {
                    c.this.eU.onAdShow();
                    com.kwad.components.ad.draw.a.c.a(c.this.mAdTemplate, 2, 2);
                    c.this.mAdTemplate.mHasAdShow = true;
                }
                if (!c.this.hK) {
                    c.this.setLifeStatue("showStart");
                    c.this.setLifeStatue("showEnd");
                    c.this.hK = true;
                }
                c.this.setLifeStatue("pageVisiable");
            }

            @Override // com.kwad.sdk.core.j.c
            public final void bz() {
                c.this.setLifeStatue("pageInvisiable");
            }
        };
        B(context);
    }

    private void B(Context context) {
        this.mContext = context;
        m.inflate(context, R.layout.ksad_draw_tk_layout, this);
        this.hG = (KSFrameLayout) findViewById(R.id.ksad_draw_tk_container);
        int iA = e.a(com.kwad.sdk.core.config.c.bzn);
        this.hF = new i(context, iA, iA);
        final WeakReference weakReference = new WeakReference(m.fb(context));
        com.kwad.sdk.core.c.b.aaf();
        com.kwad.sdk.core.c.b.a(new d() { // from class: com.kwad.components.ad.draw.view.c.1
            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            /* renamed from: onActivityDestroyed */
            public final void b(Activity activity) {
                Activity activity2 = (Activity) weakReference.get();
                if (activity2 == null || !activity2.equals(activity)) {
                    return;
                }
                if (c.this.hF != null) {
                    c.this.setLifeStatue("hideStart");
                    c.this.setLifeStatue("hideEnd");
                    c.this.hK = false;
                    c.this.hF.kD();
                }
                com.kwad.sdk.core.c.b.aaf();
                com.kwad.sdk.core.c.b.b((com.kwad.sdk.core.c.c) this);
            }
        });
    }

    public final void setPageExitListener(com.kwad.sdk.core.j.b bVar) {
        this.fa = bVar;
    }

    public final void setAdInteractionListener(KsDrawAd.AdInteractionListener adInteractionListener) {
        this.eU = adInteractionListener;
    }

    public final void setTKLoadStateListener(c.a aVar) {
        this.hH = aVar;
    }

    public final void c(AdResultData adResultData) {
        this.mAdResultData = adResultData;
        AdTemplate adTemplateS = com.kwad.sdk.core.response.b.c.s(adResultData);
        this.mAdTemplate = adTemplateS;
        this.mAdInfo = com.kwad.sdk.core.response.b.e.eP(adTemplateS);
        this.gR = new com.kwad.components.ad.draw.b(this.hG);
        bQ();
    }

    private void bQ() {
        this.gR.a(this.fa);
        this.gR.a(this.gZ);
        this.gR.wK();
        if (this.hF != null) {
            this.hr = SystemClock.elapsedRealtime();
            com.kwad.components.ad.draw.a.b.h(this.mAdTemplate);
            this.hF.a(m.fb(this.mContext), this.mAdResultData, new j() { // from class: com.kwad.components.ad.draw.view.c.3
                @Override // com.kwad.components.core.webview.tachikoma.j
                public final void a(ba baVar) {
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
                public final void a(WebCloseStatus webCloseStatus) {
                }

                @Override // com.kwad.components.core.webview.tachikoma.j
                public final void a(t tVar, com.kwad.sdk.core.webview.b bVar) {
                }

                @Override // com.kwad.components.core.webview.tachikoma.j
                public final void aF() {
                }

                @Override // com.kwad.components.core.webview.tachikoma.j
                public final void g(AdTemplate adTemplate) {
                }

                @Override // com.kwad.components.core.webview.tachikoma.j
                public final String getRegisterViewKey() {
                    return "ksad-draw-card";
                }

                @Override // com.kwad.components.core.webview.tachikoma.j
                public final String getTKReaderScene() {
                    return "tk_draw_card";
                }

                @Override // com.kwad.components.core.webview.tachikoma.j
                public final com.kwad.sdk.widget.i getTouchCoordsView() {
                    return null;
                }

                @Override // com.kwad.components.core.webview.tachikoma.j
                public final String getTkTemplateId() {
                    return com.kwad.sdk.core.response.b.b.eu(c.this.mAdTemplate);
                }

                @Override // com.kwad.components.core.webview.tachikoma.j
                public final FrameLayout getTKContainer() {
                    return c.this.hG;
                }

                @Override // com.kwad.components.core.webview.tachikoma.j
                public final void a(TKRenderFailReason tKRenderFailReason) {
                    if (c.this.hH != null) {
                        c.this.hH.aO();
                    }
                    c.this.hG.setVisibility(8);
                }

                @Override // com.kwad.components.core.webview.tachikoma.j
                public final void aE() {
                    if (c.this.hH != null) {
                        c.this.hH.aN();
                    }
                    c.this.hG.setVisibility(0);
                }

                @Override // com.kwad.components.core.webview.tachikoma.j
                public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
                    if (c.this.eU != null) {
                        c.this.eU.onAdClicked();
                    }
                    if (c.this.fn) {
                        return;
                    }
                    c.b(c.this, true);
                    com.kwad.components.ad.draw.a.c.b(c.this.mAdTemplate, 2, 2);
                }

                @Override // com.kwad.components.core.webview.tachikoma.j
                public final void a(ae.a aVar) {
                    aVar.width = com.kwad.sdk.c.a.a.px2dip(c.this.getContext(), c.this.hG.getWidth());
                    aVar.height = com.kwad.sdk.c.a.a.px2dip(c.this.getContext(), c.this.hG.getHeight());
                }

                @Override // com.kwad.components.core.webview.tachikoma.j
                public final void a(a.C0490a c0490a) {
                    if (c.this.eU != null) {
                        String str = c0490a.adW;
                        str.hashCode();
                        if (str.equals("adShowCallback")) {
                            c.this.eU.onAdShow();
                            if (c.this.mAdTemplate == null || c.this.mAdTemplate.mHasAdShow) {
                                return;
                            }
                            com.kwad.components.ad.draw.a.c.a(c.this.mAdTemplate, 2, 2);
                            c.this.mAdTemplate.mHasAdShow = true;
                            return;
                        }
                        if (str.equals("adClickCallback")) {
                            c.this.eU.onAdClicked();
                            if (c.this.fn) {
                                return;
                            }
                            c.b(c.this, true);
                            com.kwad.components.ad.draw.a.c.b(c.this.mAdTemplate, 2, 2);
                        }
                    }
                }

                @Override // com.kwad.components.core.webview.tachikoma.j
                public final void aG() {
                    c.this.bR();
                    c.this.bS();
                    c cVar = c.this;
                    cVar.A(cVar.hJ);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bR() {
        i iVar = this.hF;
        if (iVar != null) {
            iVar.a("setVideoPlayStatusCallback", (String) null, new g() { // from class: com.kwad.components.ad.draw.view.c.4
                @Override // com.kwad.components.core.webview.tachikoma.a.g
                public final void bU() {
                    if (c.this.eU != null) {
                        c.this.eU.onVideoPlayResume();
                    }
                }

                @Override // com.kwad.components.core.webview.tachikoma.a.g
                public final void bV() {
                    if (c.this.eU != null) {
                        c.this.eU.onVideoPlayPause();
                    }
                }

                @Override // com.kwad.components.core.webview.tachikoma.a.g
                public final void a(y yVar) {
                    if (c.this.eU != null) {
                        c.this.eU.onVideoPlayError();
                        com.kwad.components.ad.draw.a.b.a(c.this.mAdTemplate, SystemClock.elapsedRealtime() - c.this.hr, "video play error");
                    }
                }

                @Override // com.kwad.components.core.webview.tachikoma.a.g
                public final void bW() {
                    if (c.this.eU != null) {
                        c.this.eU.onVideoPlayEnd();
                    }
                }

                @Override // com.kwad.components.core.webview.tachikoma.a.g
                public final void bX() {
                    if (c.this.eU != null) {
                        c.this.eU.onVideoPlayStart();
                        com.kwad.components.ad.draw.a.b.a(c.this.mAdTemplate, SystemClock.elapsedRealtime() - c.this.hr);
                        c.this.bS();
                    }
                }
            });
        }
    }

    public final void setLifeStatue(String str) {
        i iVar = this.hF;
        if (iVar != null) {
            iVar.a("setLifeStatus", str, (com.kwad.sdk.components.m) null);
        }
    }

    public final void setVideoSound(boolean z) {
        this.gU = !z;
        this.hI = true;
        bS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bS() {
        if (this.hF != null) {
            n nVar = new n();
            nVar.ajg = bT();
            this.hF.a("setVideoMuteStateListener", nVar.toJson().toString(), (com.kwad.sdk.components.m) null);
        }
    }

    public final void A(int i) {
        this.hJ = i;
        if (this.hF == null) {
            return;
        }
        a aVar = new a();
        aVar.status = this.hJ;
        aVar.hM = this.eY;
        this.hF.a("setVideoPlayerStatus", aVar.toJson().toString(), (com.kwad.sdk.components.m) null);
    }

    private boolean bT() {
        if (this.hI) {
            return this.gU;
        }
        return com.kwad.sdk.core.response.b.a.ck(com.kwad.sdk.core.response.b.e.eP(this.mAdTemplate));
    }

    public final void bP() {
        this.eY = true;
        A(0);
    }

    public class a extends com.kwad.sdk.core.response.a.a {
        public boolean hM;
        public int status;

        public a() {
        }
    }
}
