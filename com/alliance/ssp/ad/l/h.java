package com.alliance.ssp.ad.l;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;

/* compiled from: SwipeDecorator.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class h extends AnimatorListenerAdapter {
    public final /* synthetic */ ImageView a;
    public final /* synthetic */ k b;

    public h(k kVar, ImageView imageView) {
        this.b = kVar;
        this.a = imageView;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        super.onAnimationStart(animator);
        k kVar = this.b;
        ImageView imageView = this.a;
        kVar.getClass();
        imageView.animate().alpha(0.0f).setDuration(300L).setInterpolator(new AccelerateDecelerateInterpolator());
    }
}
