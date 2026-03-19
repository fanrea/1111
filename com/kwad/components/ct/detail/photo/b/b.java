package com.kwad.components.ct.detail.photo.b;

import android.animation.ValueAnimator;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewStub;
import com.kwad.components.core.u.r;
import com.kwad.components.core.video.n;
import com.kwad.components.core.video.o;
import com.kwad.components.ct.detail.viewpager.SlidePlayViewPager;
import com.kwad.components.ct.home.j;
import com.kwad.lottie.LottieAnimationView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.j.c;
import com.kwad.sdk.utils.ag;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends com.kwad.components.ct.detail.b {
    private SlidePlayViewPager aok;
    private com.kwad.components.ct.detail.e.a aoz;
    private LottieAnimationView asA;
    private com.kwad.components.core.widget.a.b asB;
    private ValueAnimator asF;
    private ValueAnimator asG;
    private ViewStub asy;
    private View asz;
    private boolean asC = false;
    private boolean asD = false;
    private boolean asE = false;
    private boolean asH = false;
    private final com.kwad.components.core.k.a aoQ = new com.kwad.components.core.k.b() { // from class: com.kwad.components.ct.detail.photo.b.b.1
        @Override // com.kwad.components.core.k.b, com.kwad.components.core.k.a
        public final void qy() {
            if (b.this.asH) {
                return;
            }
            if (b.this.aok.getCurrentItem() != b.this.aok.getPreItem()) {
                ag.dF(b.this.getContext());
                b.this.zY();
                b.a(b.this, true);
            }
        }
    };
    private final n mVideoPlayStateListener = new o() { // from class: com.kwad.components.ct.detail.photo.b.b.2
        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayProgress(long j, long j2) {
            super.onMediaPlayProgress(j, j2);
            b.this.V(j2);
        }
    };
    private final c gZ = new c() { // from class: com.kwad.components.ct.detail.photo.b.b.3
        @Override // com.kwad.sdk.core.j.c
        public final void by() {
            b.this.asC = true;
        }

        @Override // com.kwad.sdk.core.j.c
        public final void bz() {
            b.this.asC = false;
        }
    };

    static /* synthetic */ boolean a(b bVar, boolean z) {
        bVar.asH = true;
        return true;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.asy = (ViewStub) findViewById(R.id.ksad_slide_up_guide_view_stub);
    }

    @Override // com.kwad.components.ct.detail.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        j jVar;
        super.ay();
        if (ag.dE(getContext()) && (jVar = this.aop.aol) != null) {
            this.aok = this.aop.aok;
            this.asB = jVar.aFs;
            com.kwad.components.ct.detail.e.a aVar = this.aop.aoz;
            this.aoz = aVar;
            if (aVar == null || this.aok == null || this.asB == null) {
                return;
            }
            aVar.c(this.mVideoPlayStateListener);
            this.asB.a(this.gZ);
            this.aop.aoq.add(this.aoQ);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        zZ();
        cE();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        zZ();
        cE();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zY() {
        this.asD = false;
        this.asE = false;
        com.kwad.components.ct.detail.e.a aVar = this.aoz;
        if (aVar != null) {
            aVar.d(this.mVideoPlayStateListener);
        }
        com.kwad.components.core.widget.a.b bVar = this.asB;
        if (bVar != null) {
            bVar.b(this.gZ);
            this.asC = false;
        }
    }

    private void zZ() {
        zY();
        this.aop.aoq.remove(this.aoQ);
    }

    private void cE() {
        ValueAnimator valueAnimator = this.asF;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.asG;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(long j) {
        if (!ag.dE(getContext())) {
            zZ();
            return;
        }
        if (!this.aop.aoA && this.asC && j >= com.kwad.components.ct.detail.a.b.yX() && !this.asD) {
            this.asD = true;
            this.aop.aoA = true;
            if (this.asy.getParent() != null) {
                this.asz = this.asy.inflate();
                LottieAnimationView lottieAnimationView = (LottieAnimationView) findViewById(R.id.ksad_guider_up_anim);
                this.asA = lottieAnimationView;
                lottieAnimationView.setAnimation(R.raw.ksad_detail_guider_slide_up_new);
                this.asA.setRepeatMode(1);
                this.asA.setRepeatCount(-1);
            }
            this.asA.PZ();
            ValueAnimator valueAnimatorH = r.h(this.asz, true);
            this.asF = valueAnimatorH;
            valueAnimatorH.start();
            this.aok.h(false, 2);
            this.asz.setClickable(true);
            this.asz.setOnTouchListener(new View.OnTouchListener() { // from class: com.kwad.components.ct.detail.photo.b.b.4
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    b.this.Aa();
                    return false;
                }
            });
            com.kwad.components.ct.e.b.JK().ab(this.aop.mAdTemplate);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Aa() {
        if (this.asE) {
            return;
        }
        this.asE = true;
        ag.dF(getContext());
        ValueAnimator valueAnimatorH = r.h(this.asz, false);
        this.asG = valueAnimatorH;
        valueAnimatorH.start();
        SlidePlayViewPager slidePlayViewPager = this.aok;
        if (slidePlayViewPager != null) {
            slidePlayViewPager.h(true, 2);
        }
        zZ();
    }
}
