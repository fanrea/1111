package com.baidu.mobads.container.util.animation;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.baidu.mobads.container.util.animation.a;
import com.baidu.mobads.container.util.animation.e;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class aa extends e.a {
    final /* synthetic */ a.EnumC0133a a;
    final /* synthetic */ View b;
    final /* synthetic */ float c;
    final /* synthetic */ int d;
    final /* synthetic */ e.b e;
    final /* synthetic */ int[] f;
    final /* synthetic */ int g;
    final /* synthetic */ int h;
    final /* synthetic */ int i;
    private ShapeDrawable j;

    aa(a.EnumC0133a enumC0133a, View view, float f, int i, e.b bVar, int[] iArr, int i2, int i3, int i4) {
        this.a = enumC0133a;
        this.b = view;
        this.c = f;
        this.d = i;
        this.e = bVar;
        this.f = iArr;
        this.g = i2;
        this.h = i3;
        this.i = i4;
    }

    @Override // com.baidu.mobads.container.util.animation.e.a
    public void a(AnimatorSet animatorSet) {
        if (a.EnumC0133a.BACKGROUND.equals(this.a)) {
            float fA = com.component.a.i.r.a(this.b.getWidth(), this.b.getHeight(), this.c, this.d);
            this.j = new ShapeDrawable(new RoundRectShape(new float[]{fA, fA, fA, fA, fA, fA, fA, fA}, null, null));
            this.j.getPaint().setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
            this.b.setBackgroundDrawable(new LayerDrawable(new Drawable[]{this.b.getBackground(), this.j}));
        }
        ValueAnimator valueAnimatorA = this.e.a(new c(this.b, new ab(this)));
        valueAnimatorA.setDuration(this.g);
        valueAnimatorA.setRepeatCount(this.h);
        animatorSet.play(valueAnimatorA);
        animatorSet.setInterpolator(new LinearInterpolator());
        animatorSet.setStartDelay(this.i);
        animatorSet.start();
    }
}
