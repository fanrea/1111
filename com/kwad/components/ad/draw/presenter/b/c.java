package com.kwad.components.ad.draw.presenter.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import com.bytedance.sdk.djx.core.log.ILogConst;
import com.kwad.components.ad.draw.presenter.b.a;
import com.kwad.components.core.u.r;
import com.kwad.components.core.video.n;
import com.kwad.components.core.video.o;
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
import com.kwad.components.core.webview.jshandler.z;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.KsAdWebView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c extends com.kwad.components.ad.draw.b.a {
    private ViewGroup fA;
    private am.a gA;
    private com.kwad.components.core.webview.a gB;
    private com.kwad.sdk.core.webview.b gC;
    private ba gE;
    private ValueAnimator gJ;
    private ValueAnimator gK;
    private KsAdWebView gz;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private int gD = -1;
    private n mVideoPlayStateListener = new o() { // from class: com.kwad.components.ad.draw.presenter.b.c.1
        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayCompleted() {
            super.onMediaPlayCompleted();
            c.this.release();
        }
    };
    private a.b gu = new a.b() { // from class: com.kwad.components.ad.draw.presenter.b.c.2
        @Override // com.kwad.components.ad.draw.presenter.b.a.b
        public final boolean bb() {
            return c.this.bl();
        }
    };
    private com.kwad.sdk.core.webview.d.a.a gF = new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ad.draw.presenter.b.c.3
        @Override // com.kwad.sdk.core.webview.d.a.a
        public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
            if (c.this.fm.eU != null) {
                c.this.fm.eU.onAdClicked();
            }
        }
    };
    private am.b gG = new am.b() { // from class: com.kwad.components.ad.draw.presenter.b.c.4
        @Override // com.kwad.components.core.webview.jshandler.am.b
        public final void a(am.a aVar) {
            c.this.gA = aVar;
            c.this.gz.setTranslationY(aVar.height + aVar.bottomMargin);
        }
    };
    private al.b gH = new al.b() { // from class: com.kwad.components.ad.draw.presenter.b.c.5
        @Override // com.kwad.components.core.webview.jshandler.al.b
        public final void a(al.a aVar) {
            c.this.bo();
        }
    };
    private at.b gI = new at.b() { // from class: com.kwad.components.ad.draw.presenter.b.c.6
        @Override // com.kwad.components.core.webview.jshandler.at.b
        public final void a(at.a aVar) {
            c.this.gD = aVar.status;
            com.kwad.sdk.core.d.c.i("DrawPlayWebCard", "updatePageStatus mPageState: " + aVar);
        }
    };

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.fA = (ViewGroup) findViewById(R.id.ksad_ad_normal_container);
        this.gz = (KsAdWebView) findViewById(R.id.ksad_play_web_card_webView);
    }

    @Override // com.kwad.components.ad.draw.b.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.mAdTemplate = this.fm.mAdTemplate;
        this.fm.fr.a(this.gu);
        this.mApkDownloadHelper = this.fm.mApkDownloadHelper;
        this.fm.fo.b(this.mVideoPlayStateListener);
        bh();
        bi();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.fm.fr.a((a.b) null);
        this.fm.fo.a(this.mVideoPlayStateListener);
        bq();
        release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void release() {
        this.gD = -1;
        this.gz.setVisibility(8);
        bk();
    }

    private void bh() {
        com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
        this.gC = bVar;
        bVar.setAdTemplate(this.fm.mAdTemplate);
        this.gC.mScreenOrientation = 0;
        this.gC.bLv = this.fm.mRootContainer;
        this.gC.Vu = this.fm.mRootContainer;
        this.gC.UO = this.gz;
    }

    private void bi() {
        this.gD = -1;
        bj();
        this.gz.setBackgroundColor(0);
        this.gz.getBackground().setAlpha(0);
        this.gz.setVisibility(4);
        this.gz.loadUrl(com.kwad.sdk.core.response.b.b.cR(this.mAdTemplate));
    }

    private void bj() {
        bk();
        com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(this.gz);
        this.gB = aVar;
        a(aVar);
        this.gz.addJavascriptInterface(this.gB, "KwaiAd");
    }

    private void bk() {
        com.kwad.components.core.webview.a aVar = this.gB;
        if (aVar != null) {
            aVar.destroy();
            this.gB = null;
        }
    }

    private void a(com.kwad.components.core.webview.a aVar) {
        aVar.a(new ac(this.gC, this.mApkDownloadHelper, this.gF, (byte) 0));
        aVar.a(new z(this.gC, this.mApkDownloadHelper, this.gF));
        aVar.a(new ag(this.gC));
        aVar.a(new aj(this.gC));
        aVar.a(new ae(this.gC));
        aVar.a(new am(this.gC, this.gG));
        aVar.a(new at(this.gI, com.kwad.sdk.core.response.b.b.cR(this.mAdTemplate)));
        ba baVar = new ba();
        this.gE = baVar;
        aVar.a(baVar);
        aVar.a(new bd(this.gC, this.mApkDownloadHelper));
        aVar.a(new al(this.gH));
        aVar.a(new an(this.gC));
        aVar.b(new com.kwad.components.core.webview.jshandler.o(this.gC));
        aVar.b(new com.kwad.components.core.webview.jshandler.n(this.gC));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bl() {
        if (this.gD == 1) {
            bm();
            return true;
        }
        br();
        return false;
    }

    private void bm() {
        if (this.gA == null) {
            bn();
            return;
        }
        bq();
        this.fA.setVisibility(8);
        this.gz.setVisibility(0);
        ValueAnimator valueAnimatorC = r.c(this.gz, this.gA.height + this.gA.bottomMargin, 0);
        this.gJ = valueAnimatorC;
        valueAnimatorC.setInterpolator(new DecelerateInterpolator(2.0f));
        this.gJ.setDuration(300L);
        this.gJ.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.draw.presenter.b.c.7
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                if (c.this.gE != null) {
                    c.this.gE.vd();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (c.this.gE != null) {
                    c.this.gE.ve();
                }
            }
        });
        this.gJ.start();
    }

    private void bn() {
        ba baVar = this.gE;
        if (baVar != null) {
            baVar.vd();
        }
        this.fA.setVisibility(8);
        this.gz.setVisibility(0);
        ba baVar2 = this.gE;
        if (baVar2 != null) {
            baVar2.ve();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bo() {
        if (this.gz.getVisibility() != 0) {
            return;
        }
        if (this.gA == null) {
            bp();
            return;
        }
        bq();
        ValueAnimator valueAnimatorC = r.c(this.gz, 0, this.gA.height + this.gA.bottomMargin);
        this.gK = valueAnimatorC;
        valueAnimatorC.setInterpolator(new DecelerateInterpolator(2.0f));
        this.gK.setDuration(300L);
        this.gK.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.draw.presenter.b.c.8
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                if (c.this.gE != null) {
                    c.this.gE.vf();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                c.this.gz.setVisibility(4);
                c.this.fA.setVisibility(0);
                if (c.this.gE != null) {
                    c.this.gE.vg();
                }
            }
        });
        this.gK.start();
    }

    private void bp() {
        if (this.gz.getVisibility() != 0) {
            return;
        }
        ba baVar = this.gE;
        if (baVar != null) {
            baVar.vf();
        }
        this.gz.setVisibility(4);
        this.fA.setVisibility(0);
        ba baVar2 = this.gE;
        if (baVar2 != null) {
            baVar2.vg();
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
        com.kwad.sdk.core.d.c.w("DrawPlayWebCard", "show webCard fail, reason: " + (i == -1 ? "timeout" : i != 1 ? "h5error" : ILogConst.DRAW_ENTER_TYPE_OTHER));
    }
}
