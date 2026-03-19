package com.kwad.components.ad.reward.presenter.platdetail.actionbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.SystemClock;
import android.view.animation.DecelerateInterpolator;
import com.bytedance.sdk.djx.core.log.ILogConst;
import com.kwad.components.ad.reward.e.g;
import com.kwad.components.ad.reward.k.q;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.playable.PlayableSource;
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
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.utils.aq;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class f extends com.kwad.components.ad.reward.presenter.b {
    private boolean Al;
    private long Am;
    private am.a gA;
    private com.kwad.components.core.webview.a gB;
    private com.kwad.sdk.core.webview.b gC;
    private ba gE;
    private ValueAnimator gJ;
    private ValueAnimator gK;
    private KsAdWebView gz;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private String mUrl;
    private RewardActionBarControl tw;
    private KsLogoView xE;
    private int gD = -1;
    private RewardActionBarControl.d zT = new RewardActionBarControl.d() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f.1
        @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl.d
        public final boolean f(a aVar) {
            f fVar = f.this;
            fVar.Al = fVar.f(aVar);
            return f.this.Al;
        }
    };
    private g mPlayEndPageListener = new com.kwad.components.ad.reward.e.a() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f.2
        @Override // com.kwad.components.ad.reward.e.g
        public final void dc() {
            f.this.release();
        }
    };
    private com.kwad.sdk.core.webview.d.a.a gF = new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f.3
        @Override // com.kwad.sdk.core.webview.d.a.a
        public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
            f.this.vb.tt.db();
        }
    };
    private am.b gG = new am.b() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f.5
        @Override // com.kwad.components.core.webview.jshandler.am.b
        public final void a(am.a aVar) {
            f.this.gA = aVar;
            f.this.gz.setTranslationY(aVar.height + aVar.bottomMargin);
        }
    };
    private al.b gH = new al.b() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f.6
        @Override // com.kwad.components.core.webview.jshandler.al.b
        public final void a(al.a aVar) {
            f.this.Al = false;
            f.this.bo();
        }
    };
    private at.b gI = new at.b() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f.7
        @Override // com.kwad.components.core.webview.jshandler.at.b
        public final void a(at.a aVar) {
            f.this.gD = aVar.status;
            long jElapsedRealtime = SystemClock.elapsedRealtime() - f.this.Am;
            com.kwad.sdk.core.d.c.i("RewardActionBarWeb", "load time:" + jElapsedRealtime + ", pageStatus: " + f.this.gD);
            if (f.this.gD == 1) {
                com.kwad.components.core.q.a.ss().i(f.this.vb.mAdTemplate, jElapsedRealtime);
            } else {
                com.kwad.components.ad.reward.monitor.c.a(f.this.vb.mAdTemplate, f.this.vb.tI, "play_card", com.kwad.sdk.core.response.b.b.cR(f.this.vb.mAdTemplate), System.currentTimeMillis() - f.this.gz.getLoadTime(), 3);
            }
            if (f.this.vb.gQ()) {
                return;
            }
            f.this.tw.ju();
        }
    };

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.gz = (KsAdWebView) findViewById(R.id.ksad_play_web_card_webView);
        this.xE = (KsLogoView) findViewById(R.id.ksad_ad_label_play_bar);
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        com.kwad.components.ad.reward.monitor.c.a(this.vb.tI, "play_card");
        RewardActionBarControl rewardActionBarControl = this.vb.tw;
        this.tw = rewardActionBarControl;
        rewardActionBarControl.a(this.zT);
        dr();
    }

    private void dr() {
        if (this.gz == null || !com.kwad.sdk.core.response.b.b.cU(this.vb.mAdTemplate)) {
            return;
        }
        this.mApkDownloadHelper = this.vb.mApkDownloadHelper;
        bh();
        bi();
        this.vb.b(this.mPlayEndPageListener);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        RewardActionBarControl rewardActionBarControl = this.tw;
        if (rewardActionBarControl != null) {
            rewardActionBarControl.a((RewardActionBarControl.d) null);
        }
        this.vb.c(this.mPlayEndPageListener);
        bq();
        release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void release() {
        this.gD = -1;
        KsAdWebView ksAdWebView = this.gz;
        if (ksAdWebView != null) {
            ksAdWebView.setVisibility(8);
        }
        bk();
    }

    private void bh() {
        com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
        this.gC = bVar;
        bVar.setAdTemplate(this.vb.mAdTemplate);
        this.gC.mScreenOrientation = this.vb.mScreenOrientation;
        this.gC.bLv = this.vb.mRootContainer;
        this.gC.Vu = this.vb.mRootContainer;
        this.gC.UO = this.gz;
    }

    private void bi() {
        this.gD = -1;
        bj();
        this.gz.setBackgroundColor(0);
        this.gz.getBackground().setAlpha(0);
        this.gz.setVisibility(4);
        this.gz.setClientConfig(this.gz.getClientConfig().fj(this.vb.mAdTemplate).b(jy()));
        this.Am = SystemClock.elapsedRealtime();
        this.mUrl = com.kwad.sdk.core.response.b.b.cR(this.vb.mAdTemplate);
        com.kwad.sdk.core.d.c.d("RewardActionBarWeb", "startPreloadWebView url: " + this.mUrl);
        com.kwad.components.ad.reward.monitor.c.a(this.vb.mAdTemplate, this.vb.tI, "play_card", this.mUrl);
        this.gz.loadUrl(this.mUrl);
    }

    private KsAdWebView.e jy() {
        return new KsAdWebView.e() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f.4
            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onPageStart() {
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onReceivedHttpError(int i, String str, String str2) {
                com.kwad.components.ad.reward.monitor.c.a(f.this.vb.mAdTemplate, f.this.vb.tI, "play_card", com.kwad.sdk.core.response.b.b.cR(f.this.vb.mAdTemplate), System.currentTimeMillis() - f.this.gz.getLoadTime(), 2);
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onPageFinished() {
                com.kwad.components.ad.reward.monitor.c.a(f.this.vb.tI, "play_card", f.this.mUrl, System.currentTimeMillis() - f.this.gz.getLoadTime());
            }
        };
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
        aVar.a(new com.kwad.components.core.webview.tachikoma.b.f());
        aVar.a(new q(this.gC, this.mApkDownloadHelper, this.vb, -1L, this.gF, null));
        aVar.a(new ag(this.gC));
        aVar.a(new aj(this.gC));
        aVar.a(new ae(this.gC));
        aVar.a(new am(this.gC, this.gG));
        aVar.a(new at(this.gI, com.kwad.sdk.core.response.b.b.cR(this.vb.mAdTemplate)));
        ba baVar = new ba();
        this.gE = baVar;
        aVar.a(baVar);
        aVar.a(new bd(this.gC, this.mApkDownloadHelper));
        aVar.a(new al(this.gH));
        aVar.a(new an(this.gC));
        aVar.b(new o(this.gC));
        aVar.b(new n(this.gC));
        aVar.a(new com.kwad.components.ad.reward.i.b(getContext(), this.vb.mAdTemplate, PlayableSource.ACTIONBAR_CLICK));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f(a aVar) {
        KsAdWebView ksAdWebView = this.gz;
        if (ksAdWebView == null) {
            return false;
        }
        if (ksAdWebView.getVisibility() == 0) {
            return true;
        }
        if (this.gD == 1) {
            g(aVar);
            return true;
        }
        br();
        return false;
    }

    private void g(final a aVar) {
        if (this.gA == null) {
            bn();
            return;
        }
        Y(this.vb.mAdTemplate);
        bq();
        this.gz.setVisibility(0);
        ValueAnimator valueAnimatorC = r.c(this.gz, this.gA.height + this.gA.bottomMargin, 0);
        this.gJ = valueAnimatorC;
        valueAnimatorC.setInterpolator(new DecelerateInterpolator(2.0f));
        this.gJ.setDuration(500L);
        this.gJ.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f.8
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                if (f.this.gE != null) {
                    f.this.gE.vd();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (f.this.gE != null) {
                    f.this.gE.ve();
                }
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.a(RewardActionBarControl.ShowActionBarResult.SHOW_H5_SUCCESS, f.this.gz);
                }
            }
        });
        this.gJ.start();
    }

    private void bn() {
        Y(this.vb.mAdTemplate);
        ba baVar = this.gE;
        if (baVar != null) {
            baVar.vd();
        }
        this.gz.setVisibility(0);
        ba baVar2 = this.gE;
        if (baVar2 != null) {
            baVar2.ve();
        }
    }

    private void Y(AdTemplate adTemplate) {
        KsLogoView ksLogoView;
        if (!com.kwad.sdk.core.response.b.a.cZ(com.kwad.sdk.core.response.b.e.eP(adTemplate)) || aq.isOrientationPortrait() || (ksLogoView = this.xE) == null) {
            return;
        }
        ksLogoView.setVisibility(0);
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
        this.gK.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f.9
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                if (f.this.gE != null) {
                    f.this.gE.vf();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                f.this.gz.setVisibility(4);
                if (f.this.gE != null) {
                    f.this.gE.vg();
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
        com.kwad.sdk.core.d.c.w("RewardActionBarWeb", "show webCard fail, reason: " + (i == -1 ? "timeout" : i != 1 ? "h5error" : ILogConst.DRAW_ENTER_TYPE_OTHER));
    }
}
