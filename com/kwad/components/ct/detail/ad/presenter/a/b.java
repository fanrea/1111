package com.kwad.components.ct.detail.ad.presenter.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.bytedance.sdk.djx.core.log.ILogConst;
import com.kwad.components.core.u.r;
import com.kwad.components.core.u.s;
import com.kwad.components.core.video.n;
import com.kwad.components.core.video.o;
import com.kwad.components.core.webview.jshandler.aa;
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
import com.kwad.components.core.webview.jshandler.bl;
import com.kwad.components.core.webview.jshandler.z;
import com.kwad.components.core.webview.tachikoma.b.f;
import com.kwad.components.ct.detail.e.a;
import com.kwad.components.ct.detail.viewpager.SlidePlayViewPager;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.R;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.core.response.b.d;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KSApiWebView;
import com.kwad.sdk.utils.ca;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends com.kwad.components.ct.detail.b {
    private final Runnable akT;
    private KSApiWebView aoT;
    private SlidePlayViewPager aok;
    private com.kwad.components.ct.detail.e.a aoz;
    private final Runnable apA;
    private ViewGroup app;
    private RelativeLayout apy;
    private int apz;
    private com.kwad.components.core.webview.a gB;
    private com.kwad.sdk.core.webview.b gC;
    private ba gE;
    private ValueAnimator gJ;
    private ValueAnimator gK;
    private FrameLayout gO;

    /* renamed from: if, reason: not valid java name */
    private AdBaseFrameLayout f7if;
    private CtAdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private long time;
    private int gD = -1;
    private boolean apq = false;
    private boolean apr = false;
    private boolean aps = false;
    private final int apt = 12;
    private final int apu = 93;
    private final int apv = 400;
    private final int apw = 15;
    private final a.InterfaceC0507a apx = new a.InterfaceC0507a() { // from class: com.kwad.components.ct.detail.ad.presenter.a.b.1
        @Override // com.kwad.components.ct.detail.e.a.InterfaceC0507a
        public final boolean yM() {
            return b.this.aps;
        }
    };
    private final n mVideoPlayStateListener = new o() { // from class: com.kwad.components.ct.detail.ad.presenter.a.b.7
        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayProgress(long j, long j2) {
            if (b.this.apq || j2 < d.ez(b.this.mAdTemplate)) {
                return;
            }
            b.this.yI();
            b bVar = b.this;
            bVar.I(bVar.aoT);
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayCompleted() {
            super.onMediaPlayCompleted();
            if (com.kwad.components.ct.detail.d.b.a(b.this.aop)) {
                return;
            }
            b.a(b.this, false);
            b.this.br(false);
        }
    };
    private final com.kwad.components.core.k.a aoQ = new AnonymousClass8();
    private final com.kwad.sdk.core.webview.d.a.b mWebCardCloseListener = new com.kwad.sdk.core.webview.d.a.b() { // from class: com.kwad.components.ct.detail.ad.presenter.a.b.12
        @Override // com.kwad.sdk.core.webview.d.a.b
        public final void b(WebCloseStatus webCloseStatus) {
            b.this.yL();
        }
    };
    private final al.b gH = new al.b() { // from class: com.kwad.components.ct.detail.ad.presenter.a.b.13
        @Override // com.kwad.components.core.webview.jshandler.al.b
        public final void a(al.a aVar) {
            b.this.br(true);
        }
    };
    private final bl.a agy = new bl.a() { // from class: com.kwad.components.ct.detail.ad.presenter.a.b.14
        @Override // com.kwad.components.core.webview.jshandler.bl.a
        public final void vl() {
            b.this.bq(true);
            b.this.bo(false);
            b.this.yK();
        }
    };
    private final at.b gI = new at.b() { // from class: com.kwad.components.ct.detail.ad.presenter.a.b.2
        @Override // com.kwad.components.core.webview.jshandler.at.b
        public final void a(at.a aVar) {
            b.this.gD = aVar.status;
            com.kwad.sdk.core.d.c.i("ActionBarWebCard", "position:" + b.this.aop.abR + " load time:" + (System.currentTimeMillis() - b.this.time));
        }
    };

    public b() {
        Runnable runnable = new Runnable() { // from class: com.kwad.components.ct.detail.ad.presenter.a.b.3
            @Override // java.lang.Runnable
            public final void run() {
                b.this.br(false);
            }
        };
        this.akT = runnable;
        this.apA = new s(runnable);
    }

    static /* synthetic */ boolean a(b bVar, boolean z) {
        bVar.apq = false;
        return false;
    }

    static /* synthetic */ boolean c(b bVar, boolean z) {
        bVar.apr = false;
        return false;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.f7if = (AdBaseFrameLayout) findViewById(R.id.ksad_root_container);
        this.app = (ViewGroup) findViewById(R.id.ksad_bottom_content_container);
        this.gO = (FrameLayout) findViewById(R.id.ksad_web_card_container);
        this.aoT = (KSApiWebView) findViewById(R.id.ksad_actionbar_web_card);
        this.apy = (RelativeLayout) findViewById(R.id.ksad_video_bottom_container);
    }

    @Override // com.kwad.components.ct.detail.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.aok = this.aop.aok;
        CtAdTemplate ctAdTemplate = this.aop.mAdTemplate;
        this.mAdTemplate = ctAdTemplate;
        if (!com.kwad.sdk.core.response.b.b.cU(ctAdTemplate) || this.aoT == null) {
            this.gO.setVisibility(8);
            return;
        }
        this.gO.setVisibility(0);
        com.kwad.components.ct.detail.e.a aVar = this.aop.aoz;
        this.aoz = aVar;
        if (aVar != null) {
            aVar.a(this.apx);
        }
        this.mApkDownloadHelper = this.aop.mApkDownloadHelper;
        this.gC = new com.kwad.sdk.core.webview.b();
        initView();
        bh();
        com.kwad.components.ct.detail.e.a aVar2 = this.aoz;
        if (aVar2 != null) {
            aVar2.c(this.mVideoPlayStateListener);
        }
        this.aop.aoq.add(this.aoQ);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        if (!com.kwad.sdk.core.response.b.b.cU(this.mAdTemplate) || this.aoT == null) {
            return;
        }
        com.kwad.components.ct.detail.e.a aVar = this.aoz;
        if (aVar != null) {
            aVar.d(this.mVideoPlayStateListener);
        }
        this.aop.aoq.remove(this.aoQ);
        com.kwad.sdk.c.a.a.Y(this.aoT);
        Runnable runnable = this.apA;
        if (runnable != null) {
            this.aoT.removeCallbacks(runnable);
        }
        bq();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        KSApiWebView kSApiWebView = this.aoT;
        if (kSApiWebView != null) {
            kSApiWebView.release();
        }
    }

    /* renamed from: com.kwad.components.ct.detail.ad.presenter.a.b$8, reason: invalid class name */
    final class AnonymousClass8 extends com.kwad.components.core.k.b {
        ViewTreeObserver.OnGlobalLayoutListener aoY;

        AnonymousClass8() {
        }

        @Override // com.kwad.components.core.k.b, com.kwad.components.core.k.a
        public final void qy() {
            super.qy();
            ys();
            yt();
        }

        @Override // com.kwad.components.core.k.b, com.kwad.components.core.k.a
        public final void qz() {
            super.qz();
            ys();
            b.this.bk();
            b.this.bq();
            if (this.aoY != null) {
                b.this.gO.getViewTreeObserver().removeOnGlobalLayoutListener(this.aoY);
            }
        }

        private void ys() {
            b.a(b.this, false);
            b.c(b.this, false);
            b.this.app.setTranslationX(0.0f);
            b.this.gO.setTranslationX(-b.this.apz);
            b.this.aoT.removeCallbacks(b.this.apA);
        }

        private void yt() {
            this.aoY = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.kwad.components.ct.detail.ad.presenter.a.b.8.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public final void onGlobalLayout() {
                    b.this.gO.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    AnonymousClass8.this.aoY = null;
                    b.this.yH();
                    b.this.yq();
                }
            };
            b.this.gO.getViewTreeObserver().addOnGlobalLayoutListener(this.aoY);
        }
    }

    private void bh() {
        this.gC.setAdTemplate(this.aop.mAdTemplate);
        this.gC.mScreenOrientation = 0;
        this.gC.bLv = this.f7if;
        this.gC.Vu = this.gO;
        this.gC.UO = this.aoT;
    }

    private void initView() {
        this.gO.setVisibility(4);
        this.aoT.setBackgroundColor(0);
        this.aoT.getBackground().setAlpha(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yq() {
        com.kwad.sdk.core.d.c.d("ActionBarWebCard", "initWebCard mWebCardContainerWidth:" + this.apz);
        this.gO.setTranslationX(-this.apz);
        this.gO.setVisibility(0);
        bj();
        this.gD = -1;
        this.time = System.currentTimeMillis();
        this.aoT.setVisibility(0);
        this.aoT.loadUrl(com.kwad.sdk.core.response.b.b.cR(this.mAdTemplate));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yH() {
        int iA = com.kwad.sdk.c.a.a.a(this.gO.getContext(), 12.0f);
        int iA2 = com.kwad.sdk.c.a.a.a(this.gO.getContext(), 93.0f);
        int iA3 = com.kwad.sdk.c.a.a.a(this.gO.getContext(), 400.0f);
        int iA4 = com.kwad.sdk.c.a.a.a(this.gO.getContext(), 15.0f);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gO.getLayoutParams();
        marginLayoutParams.leftMargin = iA;
        marginLayoutParams.rightMargin = iA2;
        marginLayoutParams.height = iA3;
        this.gO.setLayoutParams(marginLayoutParams);
        this.gO.setPadding(0, 0, 0, iA4);
        this.apz = this.gO.getWidth() + iA;
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.apy.getLayoutParams();
        marginLayoutParams2.height = -2;
        marginLayoutParams2.width = -1;
        marginLayoutParams2.setMargins(0, 0, 0, 0);
        this.apy.setLayoutParams(marginLayoutParams2);
    }

    private void bj() {
        bk();
        com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(this.aoT);
        this.gB = aVar;
        a(aVar);
        this.aoT.addJavascriptInterface(this.gB, "KwaiAd");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bk() {
        com.kwad.components.core.webview.a aVar = this.gB;
        if (aVar != null) {
            aVar.destroy();
            this.gB = null;
        }
    }

    private void a(com.kwad.components.core.webview.a aVar) {
        aVar.a(new ac(this.gC, this.mApkDownloadHelper, new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ct.detail.ad.presenter.a.b.9
            @Override // com.kwad.sdk.core.webview.d.a.a
            public final void a(com.kwad.sdk.core.webview.d.b.a aVar2) {
                if ((b.this.aop.aoy instanceof com.kwad.components.ct.detail.ad.a) && com.kwad.components.core.u.d.tu()) {
                    com.kwad.components.ct.e.b.JK().b(b.this.aop.mAdTemplate, 1);
                }
            }
        }, (byte) 0));
        aVar.a(new z(this.gC, this.mApkDownloadHelper, new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ct.detail.ad.presenter.a.b.10
            @Override // com.kwad.sdk.core.webview.d.a.a
            public final void a(com.kwad.sdk.core.webview.d.b.a aVar2) {
                if ((b.this.aop.aoy instanceof com.kwad.components.ct.detail.ad.a) && com.kwad.components.core.u.d.tu()) {
                    com.kwad.components.ct.e.b.JK().b(b.this.aop.mAdTemplate, 1);
                }
            }
        }));
        aVar.a(new ag(this.gC));
        aVar.a(new aj(this.gC));
        aVar.a(new ae(this.gC));
        aVar.a(new am(this.gC, null));
        aVar.a(new at(this.gI, com.kwad.sdk.core.response.b.b.cR(this.mAdTemplate)));
        ba baVar = new ba();
        this.gE = baVar;
        aVar.a(baVar);
        aVar.a(new bd(this.gC, this.mApkDownloadHelper));
        aVar.a(new al(this.gH));
        an anVar = new an(this.gC);
        aVar.b(new com.kwad.components.core.webview.jshandler.o(this.gC));
        aVar.b(new com.kwad.components.core.webview.jshandler.n(this.gC));
        anVar.a(new an.a() { // from class: com.kwad.components.ct.detail.ad.presenter.a.b.11
            @Override // com.kwad.components.core.webview.jshandler.an.a
            public final void onClick() {
                if ((b.this.aop.aoy instanceof com.kwad.components.ct.detail.ad.a) && com.kwad.components.core.u.d.tu()) {
                    com.kwad.components.ct.e.b.JK().b(b.this.aop.mAdTemplate, 1);
                }
            }
        });
        aVar.a(anVar);
        aVar.a(new bl(this.agy));
        aVar.a(new f());
        aVar.a(new aa(this.mWebCardCloseListener));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bq(boolean z) {
        com.kwad.components.ct.detail.e.a aVar = this.aoz;
        if (aVar != null) {
            this.aps = z;
            if (z) {
                aVar.pause();
            } else {
                aVar.bC(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yI() {
        if (this.apq || this.apr) {
            return;
        }
        this.apq = true;
        com.kwad.sdk.core.d.c.d("ActionBarWebCard", "showWebActionBar");
        if (this.gD == 1) {
            bm();
            yJ();
        } else {
            br();
        }
    }

    private void yJ() {
        if (com.kwad.components.ct.detail.d.b.a(this.aop)) {
            return;
        }
        long jCT = com.kwad.sdk.core.response.b.b.cT(this.mAdTemplate);
        KSApiWebView kSApiWebView = this.aoT;
        Runnable runnable = this.apA;
        if (jCT <= 0) {
            jCT = 5000;
        }
        kSApiWebView.postDelayed(runnable, jCT);
    }

    private void bm() {
        bq();
        ValueAnimator valueAnimatorA = r.a(this.app, this.gO, this.apz);
        this.gJ = valueAnimatorA;
        valueAnimatorA.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ct.detail.ad.presenter.a.b.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                if (b.this.gE != null) {
                    b.this.gE.vd();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (b.this.gE != null) {
                    b.this.gE.ve();
                }
            }
        });
        this.gJ.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void br(boolean z) {
        if (ca.a(this.aoT, 50, false)) {
            this.apr = z;
            bq();
            this.aoT.removeCallbacks(this.apA);
            ValueAnimator valueAnimatorA = r.a(this.gO, this.app, this.apz);
            this.gK = valueAnimatorA;
            valueAnimatorA.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ct.detail.ad.presenter.a.b.5
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    if (b.this.gE != null) {
                        b.this.gE.vf();
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    if (b.this.gE != null) {
                        b.this.gE.vg();
                    }
                }
            });
            this.gK.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bq() {
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
        com.kwad.sdk.core.d.c.w("ActionBarWebCard", "show webCard fail, reason: " + (i == -1 ? "timeout" : i != 1 ? "h5error" : ILogConst.DRAW_ENTER_TYPE_OTHER));
        com.kwad.sdk.core.adlog.c.cr(this.mAdTemplate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yK() {
        this.aoT.removeCallbacks(this.apA);
        H(this.gO);
        this.gO.setPadding(0, 0, 0, 0);
        H(this.apy);
        H(this.aoT);
    }

    private static void H(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        marginLayoutParams.height = -1;
        marginLayoutParams.width = -1;
        marginLayoutParams.setMargins(0, 0, 0, 0);
        view.setLayoutParams(marginLayoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(View view) {
        com.kwad.sdk.c.a.a.a(view, new View.OnKeyListener() { // from class: com.kwad.components.ct.detail.ad.presenter.a.b.6
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view2, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() != 1 || i != 4) {
                    return false;
                }
                if (com.kwad.sdk.c.a.a.X(b.this.getRootView())) {
                    com.kwad.sdk.c.a.a.m(b.this.aop.aoy.getActivity());
                } else {
                    b.this.yL();
                }
                return true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bo(boolean z) {
        this.aok.h(z, 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yL() {
        br(true);
        this.aoT.setVisibility(8);
        this.gO.setVisibility(8);
        bq(false);
        bo(true);
    }
}
