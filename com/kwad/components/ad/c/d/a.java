package com.kwad.components.ad.c.d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.ba;
import com.kwad.components.core.webview.jshandler.z;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.b.o;
import com.kwad.components.core.webview.tachikoma.c.n;
import com.kwad.components.core.widget.a;
import com.kwad.sdk.R;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.t;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.utils.bh;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends c {
    private FrameLayout eI;
    private boolean eJ;
    private ba eK;
    private o eL;
    private boolean ec;
    private Context mContext;

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTKReaderScene() {
        return "tk_splash";
    }

    public a(Context context) {
        this.mContext = context.getApplicationContext();
    }

    @Override // com.kwad.components.ad.c.c.a, com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.banner_full_tk_card_view);
        this.eI = frameLayout;
        a((ViewGroup) frameLayout.getParent());
    }

    private void a(ViewGroup viewGroup) {
        if (e.Yx() || e.Yw() < 0.0f) {
            return;
        }
        com.kwad.components.core.widget.a aVar = new com.kwad.components.core.widget.a(viewGroup.getContext(), viewGroup);
        viewGroup.addView(aVar);
        aVar.setViewCallback(new a.InterfaceC0500a() { // from class: com.kwad.components.ad.c.d.a.1
            @Override // com.kwad.components.core.widget.a.InterfaceC0500a
            public final void ae() {
            }

            @Override // com.kwad.components.core.widget.a.InterfaceC0500a
            public final void af() {
            }

            @Override // com.kwad.components.core.widget.a.InterfaceC0500a
            public final void onWindowFocusChanged(boolean z) {
                if (a.this.eK != null) {
                    if (z) {
                        a.this.eK.vh();
                        n nVar = new n();
                        if (a.this.eJ) {
                            a aVar2 = a.this;
                            nVar.ajg = !aVar2.f(aVar2.eq.mAdTemplate.mIsAudioEnable);
                        } else {
                            nVar.ajg = false;
                        }
                        a.this.eL.c(nVar);
                        return;
                    }
                    a aVar3 = a.this;
                    aVar3.f(aVar3.eq.mAdTemplate.mIsAudioEnable);
                    a.this.eK.vi();
                }
            }

            @Override // com.kwad.components.core.widget.a.InterfaceC0500a
            public final void c(View view) {
                com.kwad.sdk.core.d.c.e("BannerFullTKCardPresenter ", "onViewVisible");
            }

            @Override // com.kwad.components.core.widget.a.InterfaceC0500a
            public final void aD() {
                com.kwad.sdk.core.d.c.e("BannerFullTKCardPresenter ", "onViewFirstInVisible");
            }
        });
        aVar.ww();
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTkTemplateId() {
        return com.kwad.sdk.core.response.b.b.cH(this.eq.mAdTemplate).bannerTKInfo.templateId;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final FrameLayout getTKContainer() {
        return this.eI;
    }

    @Override // com.kwad.components.ad.c.d.c, com.kwad.components.ad.c.c.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
    }

    @Override // com.kwad.components.ad.c.d.c, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        ba baVar = this.eK;
        if (baVar != null) {
            baVar.vf();
            this.eK.vg();
        }
        super.onUnbind();
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(TKRenderFailReason tKRenderFailReason) {
        ba baVar = this.eK;
        if (baVar != null) {
            baVar.vf();
            this.eK.vg();
        }
        this.eI.setVisibility(8);
        this.eq.dA = true;
        this.eq.du.ad();
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void aE() {
        if (this.eq.dA) {
            return;
        }
        ba baVar = this.eK;
        if (baVar != null) {
            baVar.vh();
            this.eK.vd();
            this.eK.ve();
        }
        this.eI.setVisibility(0);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(ae.a aVar) {
        aVar.width = com.kwad.sdk.c.a.a.px2dip(getContext(), this.eq.dt.getWidth());
        aVar.height = com.kwad.sdk.c.a.a.px2dip(getContext(), this.eq.dt.getHeight());
    }

    @Override // com.kwad.components.ad.c.d.c, com.kwad.components.core.webview.tachikoma.j
    public final void a(ba baVar) {
        super.a(baVar);
        this.eK = baVar;
    }

    @Override // com.kwad.components.ad.c.d.c, com.kwad.components.core.webview.tachikoma.j
    public final void a(t tVar, com.kwad.sdk.core.webview.b bVar) {
        super.a(tVar, bVar);
        tVar.c(a(bVar));
    }

    private z a(com.kwad.sdk.core.webview.b bVar) {
        return new z(bVar, (com.kwad.components.core.e.d.c) null, new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ad.c.d.a.2
            @Override // com.kwad.sdk.core.webview.d.a.a
            public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
                if (aVar != null) {
                    a.this.eq.dt.post(new bh() { // from class: com.kwad.components.ad.c.d.a.2.1
                        @Override // com.kwad.sdk.utils.bh
                        public final void doTask() {
                            a.this.eq.ab();
                        }
                    });
                }
            }
        });
    }

    @Override // com.kwad.components.ad.c.d.c, com.kwad.components.core.webview.tachikoma.j
    public final void a(WebCloseStatus webCloseStatus) {
        this.eK.vg();
        this.eq.dt.removeAllViews();
        onDestroy();
        this.eq.ac();
    }

    @Override // com.kwad.components.ad.c.d.c, com.kwad.components.core.webview.tachikoma.j
    public final void a(o oVar) {
        this.eL = oVar;
        oVar.a(new o.a() { // from class: com.kwad.components.ad.c.d.a.3
            @Override // com.kwad.components.core.webview.tachikoma.b.o.a
            public final boolean isMuted() {
                boolean z;
                try {
                    if (e.Yy() || !com.kwad.components.core.u.a.aC(a.this.eq.mContext).to()) {
                        if ((a.this.eq.dv instanceof KSAdVideoPlayConfigImpl) && ((KSAdVideoPlayConfigImpl) a.this.eq.dv).getVideoSoundValue() != 0) {
                            z = !a.this.eq.dv.isVideoSoundEnable();
                        } else {
                            z = !com.kwad.sdk.core.response.b.a.cg(com.kwad.sdk.core.response.b.e.eP(a.this.eq.mAdTemplate));
                        }
                    }
                    if (a.this.eq.mAdTemplate != null) {
                        a.this.eq.mAdTemplate.mIsAudioEnable = z ? false : true;
                    }
                    a.this.eJ = z;
                    return z;
                } catch (Throwable unused) {
                    return true;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f(boolean z) {
        if (!z) {
            com.kwad.components.core.u.a.aC(this.mContext).aS(false);
            return false;
        }
        if (!e.Yy()) {
            if (com.kwad.components.core.u.a.aC(this.mContext).tp()) {
                return !com.kwad.components.core.u.a.aC(this.mContext).to();
            }
            return com.kwad.components.core.u.a.aC(this.mContext).aS(false);
        }
        if (!this.ec) {
            this.ec = com.kwad.components.core.u.a.aC(this.mContext).aS(true);
        }
        return this.ec;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
    }
}
