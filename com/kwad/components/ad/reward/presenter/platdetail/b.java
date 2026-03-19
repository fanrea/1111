package com.kwad.components.ad.reward.presenter.platdetail;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.components.core.video.o;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.bn;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends com.kwad.components.ad.reward.presenter.b {
    private View zn;
    private View zo;
    private View zp;
    private View zq;
    private Animator zt;
    private Animator zu;
    private Animator zv;
    private bn zy;
    private bn zz;
    private final long zk = 1600;
    private final long zl = com.alipay.sdk.m.u.b.a;
    private final long zm = 5000;
    private boolean zr = false;
    private boolean zs = false;
    private Animator zw = null;
    private long zx = com.alipay.sdk.m.u.b.a;
    private Interpolator zA = PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
    private o lv = new o() { // from class: com.kwad.components.ad.reward.presenter.platdetail.b.1
        private boolean zB = false;

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayStart() {
            super.onMediaPlayStart();
            b.this.zr = false;
            com.kwad.sdk.core.d.c.d("RewardImagePlayerPresenter", "onMediaPlayStart : ");
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayProgress(long j, long j2) {
            super.onMediaPlayProgress(j, j2);
            if (j2 < b.this.zx || this.zB) {
                return;
            }
            this.zB = true;
            b.this.ji();
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayPaused() {
            super.onMediaPlayPaused();
            b.this.zr = true;
            com.kwad.sdk.core.d.c.d("RewardImagePlayerPresenter", "onMediaPlayPaused : ");
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlaying() {
            super.onMediaPlaying();
            b.this.zr = false;
            com.kwad.sdk.core.d.c.d("RewardImagePlayerPresenter", "onMediaPlaying : ");
            if (b.this.zw == null || b.this.zw.isRunning()) {
                return;
            }
            b.this.zw.start();
            b.a(b.this, (Animator) null);
        }
    };

    static /* synthetic */ Animator a(b bVar, Animator animator) {
        bVar.zw = null;
        return null;
    }

    static /* synthetic */ View b(b bVar, View view) {
        bVar.zo = null;
        return null;
    }

    static /* synthetic */ boolean b(b bVar, boolean z) {
        bVar.zs = true;
        return true;
    }

    static /* synthetic */ View c(b bVar, View view) {
        bVar.zp = null;
        return null;
    }

    static /* synthetic */ View d(b bVar, View view) {
        bVar.zq = null;
        return null;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        jg();
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.vb.tu.a(this.lv);
        FrameLayout frameLayoutT = this.vb.tu.lc().T(getContext());
        this.zn = frameLayoutT;
        if (frameLayoutT.getParent() != null) {
            return;
        }
        ((FrameLayout) findViewById(R.id.ksad_reward_play_layout)).addView(this.zn, -1, -1);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = -this.zy.getHeight();
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.ksad_root_container);
        View viewJh = jh();
        this.zo = viewJh;
        frameLayout.addView(viewJh, -1, -1);
        View viewA = a(R.drawable.ksad_image_player_sweep1, frameLayout);
        this.zp = viewA;
        frameLayout.addView(viewA, layoutParams);
        View viewA2 = a(R.drawable.ksad_image_player_sweep2, frameLayout);
        this.zq = viewA2;
        frameLayout.addView(viewA2, layoutParams);
    }

    private void jg() {
        this.zy = new bn(getContext().getResources().getDimensionPixelSize(R.dimen.ksad_image_player_sweep_wave_width_start), getContext().getResources().getDimensionPixelSize(R.dimen.ksad_image_player_sweep_wave_height_start));
        this.zz = new bn(getContext().getResources().getDimensionPixelSize(R.dimen.ksad_image_player_sweep_wave_width_end), getContext().getResources().getDimensionPixelSize(R.dimen.ksad_image_player_sweep_wave_height_end));
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.zr = true;
        Animator animator = this.zu;
        if (animator != null) {
            animator.cancel();
        }
        Animator animator2 = this.zt;
        if (animator2 != null) {
            animator2.cancel();
        }
        Animator animator3 = this.zv;
        if (animator3 != null) {
            animator3.cancel();
        }
        this.vb.tu.b(this.lv);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        this.zn = null;
        com.kwad.components.ad.reward.m.b bVarLc = this.vb.tu.lc();
        if (bVarLc != null) {
            bVarLc.release();
        }
    }

    private View jh() {
        ImageView imageView = new ImageView(getContext());
        imageView.setClickable(false);
        imageView.setFocusable(false);
        imageView.setFocusableInTouchMode(false);
        imageView.setLongClickable(false);
        imageView.setBackgroundColor(Color.parseColor("#222222"));
        imageView.setAlpha(0.2f);
        return imageView;
    }

    private View a(int i, ViewGroup viewGroup) {
        ImageView imageView = (ImageView) LayoutInflater.from(getContext()).inflate(R.layout.ksad_image_player_sweep, viewGroup, false);
        imageView.setImageDrawable(getContext().getResources().getDrawable(i));
        return imageView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ji() {
        this.zt = b(this.zn, 1600L);
        this.zu = a(this.zp, this.zq);
        this.zv = c(this.zn, 1600L);
        this.zt.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.platdetail.b.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.r(b.this.zo);
                b.b(b.this, (View) null);
                if (b.this.zs) {
                    return;
                }
                b bVar = b.this;
                bVar.a(bVar.zu);
            }
        });
        this.zu.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.platdetail.b.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                b.b(b.this, true);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b bVar = b.this;
                bVar.a(bVar.zv);
                b.r(b.this.zp);
                b.r(b.this.zq);
                b.c(b.this, (View) null);
                b.d(b.this, null);
            }
        });
        this.zv.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.platdetail.b.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b bVar = b.this;
                bVar.a(bVar.zv);
            }
        });
        a(this.zt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Animator animator) {
        if (!this.zr) {
            animator.start();
        } else {
            this.zw = animator;
        }
    }

    private Animator a(View view, View view2) {
        Animator animatorQ = q(view);
        Animator animatorQ2 = q(view2);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view2, "scaleX", 1.0f);
        objectAnimatorOfFloat.setDuration(300L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(objectAnimatorOfFloat, animatorQ2);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.playTogether(animatorQ, animatorSet);
        return animatorSet2;
    }

    private Animator q(View view) {
        if (this.zy == null || this.zz == null) {
            jg();
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "translationY", -(com.kwad.sdk.c.a.a.getScreenHeight(getContext()) + ((this.zz.getHeight() + this.zy.getHeight()) / 2)));
        float fApK = this.zz.apK() / this.zy.apK();
        float fApL = this.zz.apL() / this.zy.apL();
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, "scaleX", 1.0f, fApK);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(view, "scaleY", 1.0f, fApL);
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.8f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(com.alipay.sdk.m.u.b.a);
        animatorSet.playTogether(objectAnimatorOfFloat2, objectAnimatorOfFloat3, objectAnimatorOfFloat, objectAnimatorOfFloat4);
        animatorSet.setInterpolator(this.zA);
        return animatorSet;
    }

    private Animator b(View view, long j) {
        float[] fArr = {1.0f, 1.106f, 1.0f, 1.106f, 1.0f};
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "scaleX", fArr);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, "scaleY", fArr);
        AnimatorSet animatorSet = new AnimatorSet();
        View view2 = this.zo;
        if (view2 != null) {
            animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2, ObjectAnimator.ofFloat(view2, "alpha", 0.2f, 0.0f));
        } else {
            animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
        }
        animatorSet.setDuration(j);
        animatorSet.setInterpolator(this.zA);
        return animatorSet;
    }

    private Animator c(View view, long j) {
        Animator animatorB = b(view, 1600L);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "alpha", 1.0f);
        objectAnimatorOfFloat.setDuration(5000L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(animatorB, objectAnimatorOfFloat);
        animatorSet.setDuration(1600L);
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void r(View view) {
        if (view != null) {
            try {
                if (view.getParent() != null) {
                    ((ViewGroup) view.getParent()).removeView(view);
                }
            } catch (Throwable th) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            }
        }
    }
}
