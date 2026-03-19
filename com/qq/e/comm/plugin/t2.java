package com.qq.e.comm.plugin;

import android.animation.Animator;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class t2 implements Animator.AnimatorListener {
    private final x7 a;
    private final int b;
    private r2 c;
    private int d = 0;
    private boolean e;

    t2(x7 x7Var) {
        this.a = x7Var;
        this.b = x7Var.a.g + 1;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.e = false;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        r2 r2Var;
        int i = this.b;
        if (i <= 0 || this.e) {
            return;
        }
        int i2 = this.d + 1;
        this.d = i2;
        if (i2 != i || (r2Var = this.c) == null) {
            return;
        }
        r2Var.a(this.a.a.b);
        this.d = 0;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        this.d = 0;
        this.e = true;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        this.d++;
    }

    public void a(r2 r2Var) {
        this.c = r2Var;
    }
}
