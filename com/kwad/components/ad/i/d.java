package com.kwad.components.ad.i;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.kwad.components.core.webview.jshandler.a;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.ba;
import com.kwad.components.core.webview.jshandler.z;
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
import com.kwad.sdk.widget.KSFrameLayout;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class d extends KSFrameLayout implements j, com.kwad.sdk.core.j.c {
    public static String sF = "PUSH_VIEW_TAG";
    private ba gE;
    private final com.kwad.components.core.widget.a.c gR;
    private i hF;
    private AdTemplate sG;
    private com.kwad.components.ad.b.a.b sH;
    private boolean sI;
    private ViewGroup sJ;
    private boolean sK;

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
    public final FrameLayout getTKContainer() {
        return this;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTKReaderScene() {
        return "tk_push_ad";
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final com.kwad.sdk.widget.i getTouchCoordsView() {
        return this;
    }

    public d(Context context, AdTemplate adTemplate) {
        super(context);
        this.sI = false;
        setTag(sF);
        this.sG = adTemplate;
        this.gR = new com.kwad.components.core.widget.a.c(this, 100);
        this.hF = new i(-1L, getContext()) { // from class: com.kwad.components.ad.i.d.1
            {
                super(-1L, context);
            }

            @Override // com.kwad.components.core.webview.tachikoma.i
            public final void a(com.kwad.sdk.core.webview.b bVar, com.kwad.components.core.e.d.c cVar, t tVar, ViewGroup viewGroup) {
                super.a(bVar, cVar, tVar, viewGroup);
                tVar.c(new z(bVar, cVar, this) { // from class: com.kwad.components.ad.i.d.1.1
                    @Override // com.kwad.components.core.webview.jshandler.z
                    public final void Y(int i) {
                        super.Y(i);
                        if (i == 3) {
                            d.this.a((WebCloseStatus) null);
                        }
                    }
                });
            }
        };
        this.hF.a((Activity) null, com.kwad.sdk.core.response.b.c.ev(this.sG), this);
    }

    public final boolean c(com.kwad.components.ad.b.a.b bVar) {
        this.sH = bVar;
        if (!this.sI || !gi()) {
            return false;
        }
        gf();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ge() {
        if (this.sK) {
            return;
        }
        this.sK = true;
        gh();
        destroy();
    }

    private void destroy() {
        this.hF.kD();
        ViewGroup viewGroup = this.sJ;
        if (viewGroup != null) {
            viewGroup.removeView(this);
        }
        ViewParent parent = getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this);
        }
    }

    private void gf() {
        com.kwad.components.ad.b.a.b bVar = this.sH;
        if (bVar != null) {
            bVar.Y();
        }
        ba baVar = this.gE;
        if (baVar != null) {
            baVar.vd();
            this.gE.ve();
        }
    }

    public final boolean gg() {
        return this.sI;
    }

    private void gh() {
        com.kwad.components.ad.b.a.b bVar = this.sH;
        if (bVar != null) {
            bVar.Z();
        }
        ba baVar = this.gE;
        if (baVar != null) {
            baVar.vf();
            this.gE.vg();
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void ae() {
        super.ae();
        this.gR.a(this);
        this.gR.wK();
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void af() {
        super.af();
        this.gR.release();
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTkTemplateId() {
        return com.kwad.sdk.core.response.b.b.er(this.sG);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(TKRenderFailReason tKRenderFailReason) {
        com.kwad.sdk.core.d.c.d("PushAdView", "onTkLoadFailed");
        this.sI = false;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void aE() {
        com.kwad.sdk.core.d.c.d("PushAdView", "onTkLoadSuccess");
        this.sI = true;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
        com.kwad.sdk.core.d.c.d("PushAdView", "onAdClicked");
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(ae.a aVar) {
        float fBv = com.kwad.sdk.c.a.a.bv(getContext());
        float screenHeight = com.kwad.sdk.c.a.a.getScreenHeight(getContext());
        aVar.width = (int) ((com.kwad.sdk.c.a.a.getScreenWidth(getContext()) / fBv) + 0.5f);
        aVar.height = (int) ((screenHeight / fBv) + 0.5f);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(ba baVar) {
        this.gE = baVar;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(WebCloseStatus webCloseStatus) {
        ge();
    }

    @Override // com.kwad.sdk.core.j.c
    public final void by() {
        com.kwad.sdk.core.d.c.d("PushAdView", "onPageVisible: ");
        ba baVar = this.gE;
        if (baVar != null) {
            baVar.vh();
        }
    }

    @Override // com.kwad.sdk.core.j.c
    public final void bz() {
        com.kwad.sdk.core.d.c.d("PushAdView", "onPageInvisible: ");
        ba baVar = this.gE;
        if (baVar != null) {
            baVar.vi();
        }
    }

    private boolean gi() {
        try {
            com.kwad.sdk.core.c.b.aaf();
            final Activity currentActivity = com.kwad.sdk.core.c.b.getCurrentActivity();
            if (currentActivity != null && !currentActivity.isFinishing()) {
                View viewFindViewById = currentActivity.getWindow().getDecorView().findViewById(R.id.content);
                if (!(viewFindViewById instanceof ViewGroup)) {
                    return false;
                }
                this.sJ = (ViewGroup) viewFindViewById;
                this.sJ.addView(this, new ViewGroup.LayoutParams(-1, -1));
                com.kwad.sdk.core.c.b.aaf();
                com.kwad.sdk.core.c.b.a(new com.kwad.sdk.core.c.d() { // from class: com.kwad.components.ad.i.d.2
                    @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
                    /* renamed from: onActivityDestroyed */
                    public final void b(Activity activity) {
                        super.b(activity);
                        com.kwad.sdk.core.c.b.aaf();
                        com.kwad.sdk.core.c.b.b((com.kwad.sdk.core.c.c) this);
                        if (activity.equals(currentActivity)) {
                            d.this.ge();
                        }
                    }
                });
                return true;
            }
            return false;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTrace(th);
            return false;
        }
    }
}
