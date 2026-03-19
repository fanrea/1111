package com.alliance.ssp.ad.l;

import android.animation.ValueAnimator;
import com.alliance.ssp.ad.l.k;
import java.util.List;

/* compiled from: SwipeDecorator.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class f implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ k.a a;
    public final /* synthetic */ List b;
    public final /* synthetic */ k c;

    public f(k kVar, k.a aVar, List list) {
        this.c = kVar;
        this.a = aVar;
        this.b = list;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        k.a aVar = this.a;
        aVar.c = fFloatValue;
        aVar.invalidate();
        k.a(this.c, fFloatValue, this.b, 3);
    }
}
