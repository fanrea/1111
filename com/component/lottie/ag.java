package com.component.lottie;

import android.animation.ValueAnimator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class ag implements ValueAnimator.AnimatorUpdateListener {
    final /* synthetic */ af a;

    ag(af afVar) {
        this.a = afVar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        if (this.a.u != null) {
            this.a.u.a(this.a.g.e());
        }
    }
}
