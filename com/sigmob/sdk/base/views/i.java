package com.sigmob.sdk.base.views;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.czhj.sdk.common.utils.Dips;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class i extends FrameLayout {
    private static float a = 0.0f;
    private static final int b = 1700;
    private j c;
    private j d;
    private j e;

    public i(Context context) {
        super(context);
        a();
    }

    public i(Context context, AttributeSet attrs) {
        super(context, attrs);
        a();
    }

    public i(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        a();
    }

    private void a() {
        a = Dips.dipsToIntPixels(6.0f, getContext());
        j jVar = new j(getContext());
        this.c = jVar;
        addView(jVar, new ViewGroup.LayoutParams(-1, -1));
        j jVar2 = new j(getContext());
        this.d = jVar2;
        addView(jVar2, new ViewGroup.LayoutParams(-1, -1));
        j jVar3 = new j(getContext());
        this.e = jVar3;
        jVar3.a(true);
        addView(this.e, new ViewGroup.LayoutParams(-1, -1));
        a(this.c, 0);
        a(this.d, 566);
    }

    public void a(final j view, int delay) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "translationY", 0.0f, Dips.dipsToIntPixels(-30.0f, getContext()));
        objectAnimatorOfFloat.setDuration(1700L);
        long j = delay;
        objectAnimatorOfFloat.setStartDelay(j);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.1f);
        objectAnimatorOfFloat2.setDuration(1700L);
        objectAnimatorOfFloat2.setStartDelay(j);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(a, Dips.dipsToIntPixels(1.0f, getContext()));
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.sigmob.sdk.base.views.i.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                view.setLineWidth(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        valueAnimatorOfFloat.setDuration(1360L);
        valueAnimatorOfFloat.setStartDelay(j + 340);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2, valueAnimatorOfFloat);
        animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.sigmob.sdk.base.views.i.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                animator.start();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        animatorSet.start();
    }
}
