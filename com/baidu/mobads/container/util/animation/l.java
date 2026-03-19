package com.baidu.mobads.container.util.animation;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateInterpolator;
import com.baidu.mobads.container.util.animation.e;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class l extends e.a {
    final /* synthetic */ aj a;
    final /* synthetic */ int b;
    final /* synthetic */ int c;
    final /* synthetic */ int d;

    l(aj ajVar, int i, int i2, int i3) {
        this.a = ajVar;
        this.b = i;
        this.c = i2;
        this.d = i3;
    }

    @Override // com.baidu.mobads.container.util.animation.e.a
    public void a(AnimatorSet animatorSet) {
        c cVar = new c(this.a, new m(this));
        ValueAnimator valueAnimatorA = cVar.a(1.0f, 0.0f);
        valueAnimatorA.setInterpolator(new AccelerateInterpolator());
        double d = this.b;
        Double.isNaN(d);
        valueAnimatorA.setDuration((long) (d * 0.15d));
        ValueAnimator valueAnimatorA2 = cVar.a(0.0f, 1.0f);
        valueAnimatorA2.setInterpolator(new e.c(0.25f));
        double d2 = this.b;
        Double.isNaN(d2);
        valueAnimatorA2.setDuration((long) (d2 * 0.85d));
        animatorSet.play(valueAnimatorA2).before(valueAnimatorA);
        e.a(animatorSet, this.c, -1);
        animatorSet.setStartDelay(this.d);
        animatorSet.start();
    }
}
