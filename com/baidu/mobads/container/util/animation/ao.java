package com.baidu.mobads.container.util.animation;

import android.animation.Animator;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateDecelerateInterpolator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class ao implements Runnable {
    final /* synthetic */ View a;
    final /* synthetic */ int[] b;
    final /* synthetic */ int c;
    final /* synthetic */ ak d;

    ao(ak akVar, View view, int[] iArr, int i) {
        this.d = akVar;
        this.a = view;
        this.b = iArr;
        this.c = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        Animator animatorCreateCircularReveal = ViewAnimationUtils.createCircularReveal(this.a, this.b[0], this.b[1], this.c, 0.0f);
        animatorCreateCircularReveal.setDuration(1000L);
        animatorCreateCircularReveal.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorCreateCircularReveal.addListener(new ap(this));
        animatorCreateCircularReveal.start();
    }
}
