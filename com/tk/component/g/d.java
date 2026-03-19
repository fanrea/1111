package com.tk.component.g;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.tk.component.scroll.b.b.h;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class d {
    private static final Interpolator tT = new Interpolator() { // from class: com.tk.component.g.d.1
        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    };
    private ValueAnimator Xi;
    private h Xj;
    private Interpolator Xk;
    private boolean mIsDestroy;

    public d(h hVar) {
        this.Xj = hVar;
    }

    public final void a(int i, boolean z, long j, boolean z2) {
        int currentItem;
        int height;
        if (this.Xj == null) {
            return;
        }
        mI();
        if (!z || j <= 0) {
            h hVar = this.Xj;
            if (hVar != null) {
                hVar.h(i, z);
                return;
            }
            return;
        }
        h hVar2 = this.Xj;
        if (hVar2 != null) {
            currentItem = hVar2.getCurrentItem();
            if (this.Xj.getOrientation() == 0) {
                height = this.Xj.getWidth();
            } else {
                height = this.Xj.getHeight();
            }
        } else {
            currentItem = 0;
            height = -1;
        }
        if (height <= 0 || currentItem == i) {
            return;
        }
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, height * (i - currentItem));
        this.Xi = valueAnimatorOfInt;
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tk.component.g.d.2
            private int Xl;

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (d.this.mIsDestroy) {
                    return;
                }
                int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                float f = iIntValue - this.Xl;
                if (d.this.Xj != null) {
                    d.this.Xj.s(-f);
                }
                this.Xl = iIntValue;
            }
        });
        valueAnimatorOfInt.addListener(new Animator.AnimatorListener() { // from class: com.tk.component.g.d.3
            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                if (d.this.mIsDestroy || d.this.Xj == null) {
                    return;
                }
                d.this.Xj.of();
            }

            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                if (animator != null) {
                    animator.removeAllListeners();
                    if (animator instanceof ValueAnimator) {
                        ((ValueAnimator) animator).removeAllUpdateListeners();
                    }
                }
                if (d.this.mIsDestroy || d.this.Xj == null) {
                    return;
                }
                d.this.Xj.og();
            }

            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationCancel(Animator animator) {
                if (animator != null) {
                    animator.removeAllListeners();
                    if (animator instanceof ValueAnimator) {
                        ((ValueAnimator) animator).removeAllUpdateListeners();
                    }
                }
                if (d.this.mIsDestroy || d.this.Xj == null) {
                    return;
                }
                d.this.Xj.og();
            }
        });
        if (z2) {
            if (this.Xk == null) {
                this.Xk = new LinearInterpolator();
            }
            valueAnimatorOfInt.setInterpolator(this.Xk);
        } else {
            valueAnimatorOfInt.setInterpolator(tT);
        }
        valueAnimatorOfInt.setDuration(j);
        valueAnimatorOfInt.start();
    }

    private void mI() {
        ValueAnimator valueAnimator = this.Xi;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return;
        }
        this.Xi.cancel();
        this.Xi = null;
    }

    public final void dX() {
        h hVar = this.Xj;
        if (hVar != null) {
            hVar.og();
        }
        mI();
    }

    public final void oH() {
        this.mIsDestroy = true;
    }

    public final void onDestroy() {
        oH();
        mI();
        this.Xj = null;
    }
}
