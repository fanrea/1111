package com.bytedance.adsdk.lottie.u;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.os.Build;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class d extends ValueAnimator {
    private final Set<ValueAnimator.AnimatorUpdateListener> d = new CopyOnWriteArraySet();
    private final Set<Animator.AnimatorListener> hc = new CopyOnWriteArraySet();
    private final Set<Animator.AnimatorPauseListener> b = new CopyOnWriteArraySet();

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getStartDelay() {
        throw new UnsupportedOperationException("LottieAnimator does not support getStartDelay.");
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public void setStartDelay(long j) {
        throw new UnsupportedOperationException("LottieAnimator does not support setStartDelay.");
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public ValueAnimator setDuration(long j) {
        throw new UnsupportedOperationException("LottieAnimator does not support setDuration.");
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public void setInterpolator(TimeInterpolator timeInterpolator) {
        throw new UnsupportedOperationException("LottieAnimator does not support setInterpolator.");
    }

    @Override // android.animation.ValueAnimator
    public void addUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.d.add(animatorUpdateListener);
    }

    @Override // android.animation.ValueAnimator
    public void removeUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.d.remove(animatorUpdateListener);
    }

    @Override // android.animation.ValueAnimator
    public void removeAllUpdateListeners() {
        this.d.clear();
    }

    @Override // android.animation.Animator
    public void addListener(Animator.AnimatorListener animatorListener) {
        this.hc.add(animatorListener);
    }

    @Override // android.animation.Animator
    public void removeListener(Animator.AnimatorListener animatorListener) {
        this.hc.remove(animatorListener);
    }

    @Override // android.animation.Animator
    public void removeAllListeners() {
        this.hc.clear();
    }

    void d(boolean z) {
        for (Animator.AnimatorListener animatorListener : this.hc) {
            if (Build.VERSION.SDK_INT >= 26) {
                animatorListener.onAnimationStart(this, z);
            } else {
                animatorListener.onAnimationStart(this);
            }
        }
    }

    @Override // android.animation.Animator
    public void addPauseListener(Animator.AnimatorPauseListener animatorPauseListener) {
        this.b.add(animatorPauseListener);
    }

    @Override // android.animation.Animator
    public void removePauseListener(Animator.AnimatorPauseListener animatorPauseListener) {
        this.b.remove(animatorPauseListener);
    }

    void d() {
        Iterator<Animator.AnimatorListener> it = this.hc.iterator();
        while (it.hasNext()) {
            it.next().onAnimationRepeat(this);
        }
    }

    void hc(boolean z) {
        for (Animator.AnimatorListener animatorListener : this.hc) {
            if (Build.VERSION.SDK_INT >= 26) {
                animatorListener.onAnimationEnd(this, z);
            } else {
                animatorListener.onAnimationEnd(this);
            }
        }
    }

    void hc() {
        Iterator<Animator.AnimatorListener> it = this.hc.iterator();
        while (it.hasNext()) {
            it.next().onAnimationCancel(this);
        }
    }

    void b() {
        Iterator<ValueAnimator.AnimatorUpdateListener> it = this.d.iterator();
        while (it.hasNext()) {
            it.next().onAnimationUpdate(this);
        }
    }

    void c() {
        if (Build.VERSION.SDK_INT >= 19) {
            Iterator<Animator.AnimatorPauseListener> it = this.b.iterator();
            while (it.hasNext()) {
                it.next().onAnimationPause(this);
            }
        }
    }

    void u() {
        if (Build.VERSION.SDK_INT >= 19) {
            Iterator<Animator.AnimatorPauseListener> it = this.b.iterator();
            while (it.hasNext()) {
                it.next().onAnimationResume(this);
            }
        }
    }
}
