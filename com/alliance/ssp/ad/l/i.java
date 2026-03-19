package com.alliance.ssp.ad.l;

import android.animation.ValueAnimator;
import java.util.List;

/* compiled from: SwipeDecorator.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class i implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ List a;
    public final /* synthetic */ k b;

    public i(k kVar, List list) {
        this.b = kVar;
        this.a = list;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        k.a(this.b, ((Float) valueAnimator.getAnimatedValue()).floatValue(), this.a, 2);
    }
}
