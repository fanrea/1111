package com.kwad.components.ad.feed.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.kwad.sdk.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class d extends FrameLayout {
    private int count;
    private ImageView jP;
    private ImageView jQ;
    private ImageView jR;
    private Animator jS;
    private Animator jT;
    private Animation jU;
    private Animation jV;

    static /* synthetic */ int f(d dVar) {
        int i = dVar.count;
        dVar.count = i + 1;
        return i;
    }

    public d(Context context) {
        this(context, null);
    }

    private d(Context context, AttributeSet attributeSet) {
        this(context, null, 0);
    }

    private d(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, 0);
        this.count = 0;
        B(context);
    }

    private void B(Context context) {
        com.kwad.sdk.p.m.inflate(context, R.layout.ksad_promote_ad_click, this);
        this.jP = (ImageView) findViewById(R.id.ksad_inside_circle);
        this.jQ = (ImageView) findViewById(R.id.ksad_outside_circle);
        this.jR = (ImageView) findViewById(R.id.ksad_hand);
    }

    public final void cD() {
        cF();
        this.jS.start();
    }

    public final void cE() {
        Animator animator = this.jS;
        if (animator != null) {
            animator.cancel();
        }
        Animator animator2 = this.jT;
        if (animator2 != null) {
            animator2.cancel();
        }
        Animation animation = this.jU;
        if (animation != null) {
            animation.cancel();
        }
        Animation animation2 = this.jV;
        if (animation2 != null) {
            animation2.cancel();
        }
    }

    private void cF() {
        this.jS = e(this.jR);
        this.jT = f(this.jR);
        this.jU = a(this.jP, 0.45f, com.kwad.sdk.c.a.a.a(getContext(), 34.0f));
        this.jV = a(this.jQ, 0.5f, com.kwad.sdk.c.a.a.a(getContext(), 50.0f));
        this.jS.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.feed.widget.d.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                d.this.jP.startAnimation(d.this.jU);
                d.this.jQ.startAnimation(d.this.jV);
                d.this.jT.start();
            }
        });
        this.jT.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.feed.widget.d.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                d.f(d.this);
                if (d.this.count >= 5) {
                    return;
                }
                d.this.jS.start();
            }
        });
    }

    private Animator e(View view) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "rotation", 0.0f, -10.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, "translationX", 0.0f, -com.kwad.sdk.c.a.a.a(getContext(), 9.5f));
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(view, "translationY", 0.0f, -com.kwad.sdk.c.a.a.a(getContext(), 9.5f));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(250L);
        animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat3);
        return animatorSet;
    }

    private Animator f(View view) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "rotation", -10.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, "translationX", -com.kwad.sdk.c.a.a.a(getContext(), 9.5f), 0.0f);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(view, "translationY", -com.kwad.sdk.c.a.a.a(getContext(), 9.5f), 0.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(250L);
        animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat3);
        return animatorSet;
    }

    private Animation a(final View view, float f, int i) {
        float fA = com.kwad.sdk.c.a.a.a(getContext(), 10.0f);
        AlphaAnimation alphaAnimation = new AlphaAnimation(f, 0.0f);
        float f2 = i / fA;
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, f2, 1.0f, f2, 1, 0.5f, 1, 0.5f);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(scaleAnimation);
        animationSet.setDuration(200L);
        animationSet.setAnimationListener(new Animation.AnimationListener() { // from class: com.kwad.components.ad.feed.widget.d.3
            @Override // android.view.animation.Animation.AnimationListener
            public final void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public final void onAnimationStart(Animation animation) {
                view.setVisibility(0);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public final void onAnimationEnd(Animation animation) {
                view.setVisibility(4);
            }
        });
        return animationSet;
    }
}
