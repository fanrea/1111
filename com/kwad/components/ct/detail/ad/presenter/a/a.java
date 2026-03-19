package com.kwad.components.ct.detail.ad.presenter.a;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.TextView;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.u.r;
import com.kwad.components.core.video.n;
import com.kwad.components.core.video.o;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.response.b.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.view.AdDownloadProgressBar;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends com.kwad.components.ct.detail.b implements View.OnClickListener {
    private com.kwad.components.ct.detail.e.a aoz;
    private TextView apf;
    private ViewGroup apg;
    private AdDownloadProgressBar aph;
    private AdDownloadProgressBar api;
    private ValueAnimator apj;
    private ValueAnimator apk;
    private Animator apl;

    /* renamed from: if, reason: not valid java name */
    private AdBaseFrameLayout f6if;
    private AdInfo mAdInfo;
    private CtAdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private com.kwad.components.core.k.a aoQ = new com.kwad.components.core.k.b() { // from class: com.kwad.components.ct.detail.ad.presenter.a.a.2
        @Override // com.kwad.components.core.k.b, com.kwad.components.core.k.a
        public final void qz() {
            super.qz();
            a.this.yE();
            a.this.yF();
        }
    };
    private n mVideoPlayStateListener = new o() { // from class: com.kwad.components.ct.detail.ad.presenter.a.a.3
        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayProgress(long j, long j2) {
            if (j2 < d.ez(a.this.mAdTemplate)) {
                if (j2 >= d.ey(a.this.mAdTemplate)) {
                    a.this.yB();
                } else if (j2 >= d.ex(a.this.mAdTemplate)) {
                    a.this.yz();
                }
            }
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayCompleted() {
            super.onMediaPlayCompleted();
            a.this.yF();
        }
    };
    private KsAppDownloadListener fJ = new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.ct.detail.ad.presenter.a.a.4
        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onIdle() {
            a.this.aph.setText(com.kwad.sdk.core.response.b.a.aI(a.this.mAdInfo));
            a.this.api.setText(com.kwad.sdk.core.response.b.a.aI(a.this.mAdInfo));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onProgressUpdate(int i) {
            if (a.this.apl != null && a.this.apl.isStarted()) {
                a.this.apl.cancel();
                a.this.apl = null;
            }
            float f = i;
            a.this.aph.b(com.kwad.sdk.core.response.b.a.b(a.this.mAdInfo, i), f);
            a.this.api.b(com.kwad.sdk.core.response.b.a.b(a.this.mAdInfo, i), f);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFinished() {
            a.this.aph.setText(com.kwad.sdk.core.response.b.a.cB(a.this.mAdTemplate));
            a.this.api.setText(com.kwad.sdk.core.response.b.a.cB(a.this.mAdTemplate));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFailed() {
            a.this.aph.setText(com.kwad.sdk.core.response.b.a.aI(a.this.mAdInfo));
            a.this.api.setText(com.kwad.sdk.core.response.b.a.aI(a.this.mAdInfo));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onInstalled() {
            a.this.aph.setText(com.kwad.sdk.core.response.b.a.ae(a.this.mAdInfo));
            a.this.api.setText(com.kwad.sdk.core.response.b.a.ae(a.this.mAdInfo));
        }

        @Override // com.kwad.sdk.core.download.a.a
        public final void onPaused(int i) {
            AdDownloadProgressBar adDownloadProgressBar = a.this.aph;
            AdInfo unused = a.this.mAdInfo;
            float f = i;
            adDownloadProgressBar.b(com.kwad.sdk.core.response.b.a.abI(), f);
            AdDownloadProgressBar adDownloadProgressBar2 = a.this.api;
            AdInfo unused2 = a.this.mAdInfo;
            adDownloadProgressBar2.b(com.kwad.sdk.core.response.b.a.abI(), f);
        }
    };

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.f6if = (AdBaseFrameLayout) findViewById(R.id.ksad_root_container);
        this.apg = (ViewGroup) findViewById(R.id.ksad_progress_container);
        this.aph = (AdDownloadProgressBar) findViewById(R.id.ksad_translate_progress);
        this.api = (AdDownloadProgressBar) findViewById(R.id.ksad_light_progress);
        this.apf = (TextView) findViewById(R.id.ksad_bottom_adtag);
        yw();
        yx();
    }

    @Override // com.kwad.components.ct.detail.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        CtAdTemplate ctAdTemplate = this.aop.mAdTemplate;
        this.mAdTemplate = ctAdTemplate;
        this.mAdInfo = com.kwad.components.ct.response.a.a.eP(ctAdTemplate);
        this.mApkDownloadHelper = this.aop.mApkDownloadHelper;
        this.aoz = this.aop.aoz;
        this.aph.setText(com.kwad.sdk.core.response.b.a.aI(this.mAdInfo));
        this.aph.setVisibility(8);
        this.api.setText(com.kwad.sdk.core.response.b.a.aI(this.mAdInfo));
        this.api.setProgressDrawable(Color.parseColor(com.kwad.sdk.core.response.b.a.bD(this.mAdInfo)));
        this.api.setVisibility(8);
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.b(this.fJ);
        }
        com.kwad.components.ct.detail.e.a aVar = this.aoz;
        if (aVar != null) {
            aVar.c(this.mVideoPlayStateListener);
        }
        yy();
        this.aop.aoq.add(this.aoQ);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        yD();
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.c(this.fJ);
        }
        com.kwad.components.ct.detail.e.a aVar = this.aoz;
        if (aVar != null) {
            aVar.d(this.mVideoPlayStateListener);
        }
        this.aop.aoq.remove(this.aoQ);
        Animator animator = this.apl;
        if (animator != null) {
            animator.cancel();
            this.apl = null;
        }
    }

    private void yw() {
        this.aph.setProgressDrawable(Color.parseColor("#4D36384B"));
        this.aph.setTextColor(Color.parseColor("#66FFFFFF"));
        this.aph.a(null, null, getContext().getResources().getDrawable(R.drawable.ksad_btn_arrow_gray), null, com.kwad.sdk.c.a.a.a(getContext(), 2.0f));
    }

    private void yx() {
        this.api.setTextColor(Color.parseColor("#CCFFFFFF"));
        this.api.a(null, null, getContext().getResources().getDrawable(R.drawable.ksad_btn_arrow_light), null, com.kwad.sdk.c.a.a.a(getContext(), 2.0f));
    }

    private void yy() {
        String strCy = com.kwad.sdk.core.response.b.a.cy(this.mAdInfo);
        if (TextUtils.isEmpty(strCy)) {
            strCy = "免费查看";
        }
        boolean zCw = com.kwad.sdk.core.response.b.a.cw(this.mAdInfo);
        if (zCw) {
            this.apf.setText(strCy);
        }
        this.apf.setVisibility(zCw ? 0 : 8);
        this.apf.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AnimatorSet G(final View view) {
        Interpolator interpolatorCreate = PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
        Interpolator interpolatorCreate2 = PathInterpolatorCompat.create(0.42f, 0.0f, 1.0f, 1.0f);
        AnimatorSet animatorSetA = a(view, 300, interpolatorCreate, 1.0f, 0.95f);
        AnimatorSet animatorSetA2 = a(view, 300, interpolatorCreate2, 0.95f, 1.0f);
        AnimatorSet animatorSetA3 = a(view, 300, interpolatorCreate, 1.0f, 0.95f);
        AnimatorSet animatorSetA4 = a(view, 300, interpolatorCreate2, 0.95f, 1.0f);
        final AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(300L);
        animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.kwad.components.ct.detail.ad.presenter.a.a.1
            private boolean mo = false;

            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                this.mo = false;
            }

            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                if (this.mo) {
                    return;
                }
                view.postDelayed(new Runnable() { // from class: com.kwad.components.ct.detail.ad.presenter.a.a.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        animatorSet.start();
                    }
                }, 1000L);
            }

            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationCancel(Animator animator) {
                this.mo = true;
            }
        });
        animatorSet.playSequentially(animatorSetA, animatorSetA2, animatorSetA3, animatorSetA4);
        return animatorSet;
    }

    private static AnimatorSet a(View view, int i, Interpolator interpolator, float... fArr) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "scaleX", fArr);
        objectAnimatorOfFloat.setInterpolator(interpolator);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, "scaleY", fArr);
        objectAnimatorOfFloat2.setInterpolator(interpolator);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
        animatorSet.setDuration(300L);
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yz() {
        if (this.aph.getVisibility() == 0 || this.api.getVisibility() == 0) {
            return;
        }
        yG();
        yA();
        this.aph.setAlpha(1.0f);
        this.aph.setVisibility(0);
        this.aph.setOnClickListener(this);
        ViewGroup viewGroup = this.apg;
        ValueAnimator valueAnimatorE = r.e(viewGroup, 0, com.kwad.sdk.c.a.a.a(viewGroup.getContext(), 39.0f));
        this.apj = valueAnimatorE;
        valueAnimatorE.start();
    }

    private void yA() {
        ValueAnimator valueAnimator = this.apj;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.apj.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yB() {
        if (this.api.getVisibility() == 0) {
            return;
        }
        yC();
        this.apg.setVisibility(0);
        if (com.kwad.sdk.core.response.b.a.cv(this.mAdInfo)) {
            this.apg.postDelayed(new Runnable() { // from class: com.kwad.components.ct.detail.ad.presenter.a.a.5
                @Override // java.lang.Runnable
                public final void run() {
                    if (a.this.apl == null && a.this.api != null) {
                        a aVar = a.this;
                        aVar.apl = aVar.G(aVar.api);
                    }
                    if (a.this.apl != null) {
                        a.this.apl.start();
                    }
                }
            }, 1000L);
        }
        this.api.setOnClickListener(this);
        ValueAnimator valueAnimatorC = r.c(this.aph, this.api);
        this.apk = valueAnimatorC;
        valueAnimatorC.start();
    }

    private void yC() {
        ValueAnimator valueAnimator = this.apk;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.apk.cancel();
        }
    }

    private void yD() {
        yA();
        yC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yE() {
        yC();
        this.api.setAlpha(1.0f);
        this.api.setVisibility(8);
        this.apg.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yF() {
        yA();
        this.aph.setAlpha(1.0f);
        this.aph.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.apf) {
            a(111, 2, false);
        } else {
            a(1, 1, true);
        }
    }

    private void a(int i, int i2, boolean z) {
        if ((this.aop.aoy instanceof com.kwad.components.ct.detail.ad.a) && com.kwad.components.core.u.d.tu()) {
            com.kwad.components.ct.e.b.JK().b(this.aop.mAdTemplate, 1);
        }
        com.kwad.components.core.e.d.a.a(new a.C0469a(getContext()).aC(this.mAdTemplate).b(this.mApkDownloadHelper).aG(i2).aq(z).aF(i).d(this.f6if.getTouchCoords()).as(true));
    }

    private void yG() {
        com.kwad.sdk.core.adlog.c.b(this.mAdTemplate, 19, (JSONObject) null);
    }
}
