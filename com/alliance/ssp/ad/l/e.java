package com.alliance.ssp.ad.l;

import android.animation.ValueAnimator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.alliance.ssp.ad.l.k;
import com.google.android.material.badge.BadgeDrawable;
import java.util.List;

/* compiled from: SwipeDecorator.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class e implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ k.a a;
    public final /* synthetic */ ImageView b;
    public final /* synthetic */ List c;
    public final /* synthetic */ k d;

    public e(k kVar, k.a aVar, ImageView imageView, List list) {
        this.d = kVar;
        this.a = aVar;
        this.b = imageView;
        this.c = list;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        k.a aVar = this.a;
        aVar.c = fFloatValue;
        aVar.invalidate();
        k kVar = this.d;
        ImageView imageView = this.b;
        kVar.getClass();
        imageView.setAlpha(1.0f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(kVar.a((float) (kVar.b * 0.15d)), kVar.a((float) (kVar.b * 0.14d)));
        layoutParams.gravity = BadgeDrawable.BOTTOM_START;
        layoutParams.setMargins(kVar.a((float) (kVar.b * 0.5d)), 0, 0, kVar.a(fFloatValue - ((float) (kVar.b * 0.017d))));
        imageView.setLayoutParams(layoutParams);
        k.a(this.d, fFloatValue, this.c, 1);
    }
}
