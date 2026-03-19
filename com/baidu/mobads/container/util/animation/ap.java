package com.baidu.mobads.container.util.animation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.baidu.mobads.container.util.cf;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class ap extends AnimatorListenerAdapter {
    final /* synthetic */ ao a;

    ap(ao aoVar) {
        this.a = aoVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        try {
            cf.c(this.a.a);
            if (this.a.d.h != null) {
                this.a.d.h.c();
                this.a.d.h = null;
            }
            if (this.a.d.k != null) {
                this.a.d.k.c();
            }
            this.a.d.b();
        } catch (Exception e) {
            e.printStackTrace();
            this.a.d.b();
        }
    }
}
