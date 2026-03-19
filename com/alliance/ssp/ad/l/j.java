package com.alliance.ssp.ad.l;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: SwipeDecorator.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class j extends AnimatorListenerAdapter {
    public final /* synthetic */ k a;

    public j(k kVar) {
        this.a = kVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.a.h.start();
    }
}
