package com.baidu.mobads.container.util.animation;

import android.animation.Animator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class f implements Animator.AnimatorListener {
    final /* synthetic */ int b;
    final /* synthetic */ int c;
    final /* synthetic */ Animator d;
    private int e = 0;
    boolean a = false;

    f(int i, int i2, Animator animator) {
        this.b = i;
        this.c = i2;
        this.d = animator;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.a = false;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        if (this.a) {
            return;
        }
        if (this.b == -1 || this.e < this.b) {
            this.e++;
            if (this.c >= 0) {
                this.d.setStartDelay(this.c);
            }
            this.d.start();
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        this.a = true;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }
}
