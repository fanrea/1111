package com.baidu.mobads.container.util.animation;

import android.animation.Animator;
import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class h implements Animator.AnimatorListener {
    final /* synthetic */ View a;
    final /* synthetic */ Animator b;
    private boolean c = false;

    h(View view, Animator animator) {
        this.a = view;
        this.b = animator;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        if (!this.c) {
            this.a.setVisibility(4);
            this.b.removeListener(this);
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        this.c = true;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }
}
