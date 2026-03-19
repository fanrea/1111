package com.kwad.components.ct.detail.photo.presenter;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.SystemClock;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.RelativeLayout;
import com.kwad.components.ct.detail.photo.e.h;
import com.kwad.components.ct.widget.KsAdFrameLayout;
import com.kwad.lottie.LottieAnimationView;
import com.kwad.sdk.R;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends com.kwad.components.ct.detail.b implements com.kwad.components.core.k.e {
    private RelativeLayout avd;
    private KsAdFrameLayout ave;
    private com.kwad.components.ct.detail.photo.widget.a avf;
    private GestureDetector.SimpleOnGestureListener avg;
    private long avh;
    private boolean avi;
    private int avj;
    private h avl;
    private final Random avb = new Random();
    private List<Integer> avc = new ArrayList();
    private LinkedList<LottieAnimationView> avk = new LinkedList<>();
    private final Runnable avm = new Runnable() { // from class: com.kwad.components.ct.detail.photo.presenter.b.1
        @Override // java.lang.Runnable
        public final void run() {
            b.this.avf.Z(com.kwad.components.ct.detail.photo.widget.a.awX);
        }
    };
    private com.kwad.components.core.k.e avn = new com.kwad.components.core.k.e() { // from class: com.kwad.components.ct.detail.photo.presenter.b.2
    };
    private com.kwad.components.core.k.a aoQ = new com.kwad.components.core.k.b() { // from class: com.kwad.components.ct.detail.photo.presenter.b.3
        @Override // com.kwad.components.core.k.b, com.kwad.components.core.k.a
        public final void qy() {
            super.qy();
            b.this.aop.aos.add(b.this.avn);
        }

        @Override // com.kwad.components.core.k.b, com.kwad.components.core.k.a
        public final void qz() {
            super.qz();
            b.this.avd.removeCallbacks(b.this.avm);
            b.this.avf.Z(com.kwad.components.ct.detail.photo.widget.a.awX);
            b.this.aop.aos.remove(b.this.avn);
            if (b.this.avd != null) {
                for (int i = 0; i < b.this.avd.getChildCount(); i++) {
                    if ((b.this.avd.getChildAt(i) instanceof LottieAnimationView) && ((LottieAnimationView) b.this.avd.getChildAt(i)).isAnimating()) {
                        ((LottieAnimationView) b.this.avd.getChildAt(i)).Qa();
                    }
                }
            }
            b.this.avk.clear();
            if (b.this.avd != null) {
                b.this.avd.removeAllViews();
            }
        }
    };

    public b() {
        h hVar = new h();
        this.avl = hVar;
        d(hVar);
    }

    private void AO() {
        if (this.avg == null) {
            this.avg = new GestureDetector.SimpleOnGestureListener() { // from class: com.kwad.components.ct.detail.photo.presenter.b.4
                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
                public final boolean onDoubleTap(MotionEvent motionEvent) {
                    return b.this.onDoubleTap(motionEvent);
                }

                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
                public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                    return super.onSingleTapConfirmed(motionEvent);
                }

                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
                public final boolean onSingleTapUp(MotionEvent motionEvent) {
                    b.this.onSingleTapUp(motionEvent);
                    return super.onSingleTapUp(motionEvent);
                }
            };
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        if (getContext() != null) {
            this.avj = getContext().getResources().getDimensionPixelSize(R.dimen.ksad_slide_play_center_like_view_size);
        }
        this.avd = (RelativeLayout) findViewById(R.id.ksad_slide_play_like_image);
        this.ave = (KsAdFrameLayout) findViewById(R.id.ksad_video_container);
        AO();
        for (int i = -15; i < 15; i++) {
            this.avc.add(Integer.valueOf(i));
        }
        this.ave.setClickable(true);
        AP();
    }

    @Override // com.kwad.components.ct.detail.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.aop.aoq.add(this.aoQ);
        this.ave.a(this.avf);
        this.avd.setVisibility(0);
    }

    private void AP() {
        if (this.avf == null) {
            if (this.avg == null) {
                AO();
            }
            this.avf = new com.kwad.components.ct.detail.photo.widget.a(getContext(), this.avg) { // from class: com.kwad.components.ct.detail.photo.presenter.b.5
                @Override // com.kwad.components.ct.detail.photo.widget.a, android.view.GestureDetector
                public final boolean onTouchEvent(MotionEvent motionEvent) {
                    if (motionEvent.getActionMasked() == 6) {
                        return b.this.e(motionEvent);
                    }
                    return super.onTouchEvent(motionEvent);
                }
            };
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        getRootView().setOnTouchListener(null);
        this.avd.setOnTouchListener(null);
        this.ave.b(this.avf);
        this.aop.aos.remove(this.avn);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        RelativeLayout relativeLayout = this.avd;
        if (relativeLayout != null) {
            relativeLayout.removeCallbacks(this.avm);
        }
        super.onDestroy();
    }

    private boolean e(float f, float f2) {
        this.avf.Z(500L);
        this.avd.removeCallbacks(this.avm);
        this.avd.postDelayed(this.avm, 500L);
        this.avl.BG();
        g(f, f2);
        return true;
    }

    private boolean f(float f, float f2) {
        this.avh = SystemClock.elapsedRealtime();
        this.avi = true;
        return e(f, f2);
    }

    private void g(float f, float f2) {
        if (getContext() == null) {
            return;
        }
        boolean z = f > -1.0f && f2 > -1.0f;
        int i = this.avj;
        if (!z) {
            i = (int) (i * 1.2f);
        }
        LottieAnimationView lottieAnimationViewPollFirst = this.avk.pollFirst();
        if (lottieAnimationViewPollFirst == null) {
            lottieAnimationViewPollFirst = new LottieAnimationView(getContext());
            lottieAnimationViewPollFirst.co(true);
            RelativeLayout relativeLayout = this.avd;
            int i2 = this.avj;
            relativeLayout.addView(lottieAnimationViewPollFirst, new RelativeLayout.LayoutParams(i2, i2));
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) lottieAnimationViewPollFirst.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i;
        if (z) {
            float f3 = i / 2.0f;
            lottieAnimationViewPollFirst.setTranslationX(f - f3);
            lottieAnimationViewPollFirst.setTranslationY((f2 - f3) - (this.avj / 3.0f));
            List<Integer> list = this.avc;
            lottieAnimationViewPollFirst.setRotation(list.get(this.avb.nextInt(list.size())).intValue());
            layoutParams.addRule(13, 0);
        } else {
            lottieAnimationViewPollFirst.setTranslationX(0.0f);
            lottieAnimationViewPollFirst.setTranslationY(0.0f);
            lottieAnimationViewPollFirst.setRotation(0.0f);
            layoutParams.addRule(13, -1);
        }
        lottieAnimationViewPollFirst.setLayoutParams(layoutParams);
        a(lottieAnimationViewPollFirst, z);
    }

    private void a(final LottieAnimationView lottieAnimationView, boolean z) {
        lottieAnimationView.Qa();
        lottieAnimationView.setVisibility(4);
        lottieAnimationView.setAnimation(R.raw.ksad_detail_center_like_anim_new_ui);
        lottieAnimationView.setSpeed(z ? 2.0f : 1.5f);
        lottieAnimationView.a(new AnimatorListenerAdapter() { // from class: com.kwad.components.ct.detail.photo.presenter.b.6
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                lottieAnimationView.b(this);
                if (b.this.avd.indexOfChild(lottieAnimationView) >= 0) {
                    lottieAnimationView.setVisibility(4);
                    if (b.this.avk.contains(lottieAnimationView)) {
                        b.this.avk.offer(lottieAnimationView);
                    }
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                lottieAnimationView.setVisibility(0);
            }
        });
        lottieAnimationView.PZ();
    }

    private boolean AQ() {
        return SystemClock.elapsedRealtime() - this.avh < ((long) ViewConfiguration.getJumpTapTimeout());
    }

    public final boolean onDoubleTap(MotionEvent motionEvent) {
        this.avh = SystemClock.elapsedRealtime();
        if (this.avi) {
            return true;
        }
        e(motionEvent.getX(), motionEvent.getY());
        return true;
    }

    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        if (AQ()) {
            return f(motionEvent.getX(), motionEvent.getY());
        }
        this.avi = false;
        return false;
    }

    public final boolean e(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (AQ()) {
            return f(motionEvent.getX(actionIndex), motionEvent.getY(actionIndex));
        }
        return false;
    }
}
