package com.qq.e.comm.plugin;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class qv extends AnimatorListenerAdapter {
    private boolean a = false;
    private int b = 0;
    private b c;
    private final s2 d;

    qv(s2 s2Var) {
        this.d = s2Var;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.a = false;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        s2 s2Var = this.d;
        int i = s2Var.g;
        if (!this.a && (i < 0 || this.b < i)) {
            this.b++;
            if (s2Var.d() && this.b % 2 == 1) {
                if (this.c == null) {
                    this.c = new b();
                }
                this.c.a = animator;
                k8.a().postDelayed(this.c, this.d.f);
                return;
            }
            animator.setStartDelay(this.d.f);
            animator.start();
            return;
        }
        this.b = 0;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        this.a = true;
        this.b = 0;
        b bVar = this.c;
        if (bVar != null) {
            bVar.a = null;
        }
        animator.setStartDelay(this.d.d);
    }

    /* compiled from: A */
    private static class b implements Runnable {
        Animator a;

        private b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Animator animator = this.a;
            if (animator instanceof ValueAnimator) {
                ((ValueAnimator) animator).reverse();
            }
        }
    }
}
