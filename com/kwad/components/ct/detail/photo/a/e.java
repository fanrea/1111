package com.kwad.components.ct.detail.photo.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.bytedance.sdk.djx.core.log.ILogConst;
import com.kwad.components.core.u.r;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.ag;
import com.kwad.components.core.webview.jshandler.aj;
import com.kwad.components.core.webview.jshandler.al;
import com.kwad.components.core.webview.jshandler.am;
import com.kwad.components.core.webview.jshandler.an;
import com.kwad.components.core.webview.jshandler.at;
import com.kwad.components.core.webview.jshandler.ba;
import com.kwad.components.core.webview.jshandler.bd;
import com.kwad.components.core.webview.jshandler.n;
import com.kwad.components.core.webview.jshandler.o;
import com.kwad.components.core.webview.jshandler.z;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.components.ec.api.EcLiveComponents;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.utils.ca;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class e implements d {
    private WebView UO;
    private ViewTreeObserver.OnGlobalLayoutListener aoY;
    private String aof;
    private ViewGroup app;
    private int apz;
    private ViewGroup aqJ;
    private String aqK;
    private a aqL;
    private com.kwad.components.core.webview.a gB;
    private com.kwad.sdk.core.webview.b gC;
    private ba gE;
    private ValueAnimator gJ;
    private ValueAnimator gK;
    private FrameLayout gO;

    /* renamed from: if, reason: not valid java name */
    private AdBaseFrameLayout f13if;
    private CtAdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private int gD = -1;
    private boolean apq = false;
    private boolean apr = false;
    private com.kwad.sdk.core.webview.d.a.a gF = new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ct.detail.photo.a.e.2
        @Override // com.kwad.sdk.core.webview.d.a.a
        public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
            if (com.kwad.sdk.core.response.b.a.aJ(com.kwad.components.ct.response.a.a.eP(e.this.mAdTemplate))) {
                e.this.UO.post(e.this.aqM);
            } else {
                e.this.UO.postDelayed(e.this.aqM, 100L);
            }
        }
    };
    private Runnable aqM = new Runnable() { // from class: com.kwad.components.ct.detail.photo.a.e.3
        @Override // java.lang.Runnable
        public final void run() {
            if (e.this.aqL != null) {
                e.this.aqL.zo();
            }
            e.this.br(false);
        }
    };
    private al.b gH = new al.b() { // from class: com.kwad.components.ct.detail.photo.a.e.4
        @Override // com.kwad.components.core.webview.jshandler.al.b
        public final void a(al.a aVar) {
            if (e.this.aqL != null) {
                e.this.aqL.zn();
            }
            e.this.br(true);
        }
    };
    private at.b gI = new at.b() { // from class: com.kwad.components.ct.detail.photo.a.e.5
        @Override // com.kwad.components.core.webview.jshandler.at.b
        public final void a(at.a aVar) {
            e.this.gD = aVar.status;
        }
    };

    public interface a {
        void zn();

        void zo();
    }

    static /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener a(e eVar, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        eVar.aoY = null;
        return null;
    }

    public final void a(ViewGroup viewGroup, ViewGroup viewGroup2, FrameLayout frameLayout, WebView webView, AdBaseFrameLayout adBaseFrameLayout, CtAdTemplate ctAdTemplate, com.kwad.components.core.e.d.c cVar) {
        this.app = viewGroup;
        this.aqJ = viewGroup2;
        this.gO = frameLayout;
        this.UO = webView;
        this.f13if = adBaseFrameLayout;
        this.mAdTemplate = ctAdTemplate;
        this.mApkDownloadHelper = cVar;
        this.aof = com.kwad.sdk.core.response.b.d.ew(ctAdTemplate).strongStyleCardUrl;
        gx();
        bh();
    }

    private void gx() {
        this.gO.setVisibility(4);
        this.UO.setBackgroundColor(0);
        this.UO.getBackground().setAlpha(0);
    }

    private void bh() {
        com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
        this.gC = bVar;
        bVar.setAdTemplate(this.mAdTemplate);
        this.gC.mScreenOrientation = 0;
        this.gC.bLv = this.f13if;
        this.gC.Vu = this.gO;
        this.gC.UO = this.UO;
    }

    public final void bi() {
        this.aoY = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.kwad.components.ct.detail.photo.a.e.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                e.this.gO.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                e.a(e.this, (ViewTreeObserver.OnGlobalLayoutListener) null);
                e.this.yq();
            }
        };
        this.gO.getViewTreeObserver().addOnGlobalLayoutListener(this.aoY);
    }

    @Override // com.kwad.components.ct.detail.photo.a.d
    public final void release() {
        this.apq = false;
        this.apr = false;
        this.gD = -1;
        this.aqK = "";
        bk();
        bq();
        if (this.aoY != null) {
            this.gO.getViewTreeObserver().removeOnGlobalLayoutListener(this.aoY);
        }
        this.app.setTranslationX(0.0f);
        this.gO.setVisibility(8);
        this.UO.removeCallbacks(this.aqM);
    }

    @Override // com.kwad.components.ct.detail.photo.a.d
    public final boolean yb() {
        yI();
        return this.gD == 1 || this.apr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yq() {
        this.apz = this.gO.getWidth() + com.kwad.sdk.c.a.a.a(this.gO.getContext(), 12.0f);
        com.kwad.sdk.core.d.c.d("PatchAdWebCard", "initWebCard mWebCardContainerWidth:" + this.apz);
        this.gO.setTranslationX(-this.apz);
        this.gO.setVisibility(0);
        bj();
        this.gD = -1;
        this.UO.loadUrl(this.aof);
    }

    private void bj() {
        bk();
        com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(this.UO);
        this.gB = aVar;
        a(aVar);
        this.UO.addJavascriptInterface(this.gB, "KwaiAd");
    }

    private void bk() {
        com.kwad.components.core.webview.a aVar = this.gB;
        if (aVar != null) {
            aVar.destroy();
            this.gB = null;
        }
    }

    private void a(com.kwad.components.core.webview.a aVar) {
        EcLiveComponents ecLiveComponents = (EcLiveComponents) com.kwad.sdk.components.d.g(EcLiveComponents.class);
        if ((TextUtils.isEmpty(this.aqK) || ecLiveComponents == null) ? false : true) {
            aVar.a(ecLiveComponents.LI());
            aVar.a(ecLiveComponents.LJ());
        } else {
            aVar.a(new an(this.gC));
            aVar.a(new ac(this.gC, this.mApkDownloadHelper, this.gF, (byte) 0));
            aVar.a(new z(this.gC, this.mApkDownloadHelper, this.gF));
        }
        aVar.b(new o(this.gC));
        aVar.b(new n(this.gC));
        aVar.a(new ag(this.gC));
        aVar.a(new aj(this.gC));
        aVar.a(new ae(this.gC));
        aVar.a(new am(this.gC, null));
        aVar.a(new at(this.gI, this.aof));
        ba baVar = new ba();
        this.gE = baVar;
        aVar.a(baVar);
        aVar.a(new bd(this.gC, this.mApkDownloadHelper));
        aVar.a(new al(this.gH));
    }

    private void yI() {
        if (this.apq || this.apr) {
            return;
        }
        this.apq = true;
        com.kwad.sdk.core.d.c.d("PatchAdWebCard", "showWebActionBar");
        if (this.gD == 1) {
            bm();
        } else {
            br();
        }
    }

    private void bm() {
        bq();
        ValueAnimator valueAnimatorA = r.a(this.app, this.gO, this.apz);
        this.gJ = valueAnimatorA;
        valueAnimatorA.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ct.detail.photo.a.e.6
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                if (e.this.gE != null) {
                    e.this.gE.vd();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (e.this.gE != null) {
                    e.this.gE.ve();
                }
            }
        });
        this.gJ.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void br(boolean z) {
        if (ca.a(this.UO, 50, false)) {
            this.apr = z;
            if (z && TextUtils.isEmpty(this.aqK)) {
                this.aqJ.setVisibility(8);
            }
            bq();
            ValueAnimator valueAnimatorA = r.a(this.gO, this.app, this.apz);
            this.gK = valueAnimatorA;
            valueAnimatorA.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ct.detail.photo.a.e.7
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    if (e.this.gE != null) {
                        e.this.gE.vf();
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    if (e.this.gE != null) {
                        e.this.gE.vg();
                    }
                }
            });
            this.gK.start();
        }
    }

    private void bq() {
        ValueAnimator valueAnimator = this.gJ;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.gJ.cancel();
        }
        ValueAnimator valueAnimator2 = this.gK;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllListeners();
            this.gK.cancel();
        }
    }

    private void br() {
        int i = this.gD;
        com.kwad.sdk.core.d.c.w("PatchAdWebCard", "show webCard fail, reason: " + (i == -1 ? "timeout" : i != 1 ? "h5error" : ILogConst.DRAW_ENTER_TYPE_OTHER));
        com.kwad.sdk.core.adlog.c.cr(this.mAdTemplate);
    }

    public final void a(a aVar) {
        this.aqL = aVar;
    }
}
