package com.baidu.mobads.container.util.animation;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.view.View;
import com.baidu.mobads.container.util.animation.a;
import com.baidu.mobads.container.util.animation.c;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class x extends c.a {
    final /* synthetic */ Drawable[] a;
    final /* synthetic */ w b;

    x(w wVar, Drawable[] drawableArr) {
        this.b = wVar;
        this.a = drawableArr;
    }

    @Override // com.baidu.mobads.container.util.animation.c.a, com.baidu.mobads.container.util.animation.a.a
    public void a(float f, View view) {
        float f2 = (f - this.b.d) / (this.b.e - this.b.d);
        float fMin = Math.min(view.getWidth(), view.getHeight());
        int i = (int) (this.b.f * fMin * f2);
        int i2 = (int) (fMin * this.b.g * f2);
        if (a.EnumC0133a.BACKGROUND.equals(this.b.a)) {
            this.a[0].setAlpha((int) ((1.0f - f2) * 255.0f));
            LayerDrawable layerDrawable = new LayerDrawable(this.a);
            int i3 = -i;
            int i4 = -i2;
            layerDrawable.setLayerInset(0, i3, i4, i3, i4);
            view.setBackgroundDrawable(layerDrawable);
            return;
        }
        this.b.c.setAlpha(1.0f - Math.abs((f2 - 0.5f) * 2.0f));
        this.b.c.setScaleX(view.getScaleX() * (((i * 2.0f) / view.getWidth()) + 1.0f));
        this.b.c.setScaleY(view.getScaleY() * (((i2 * 2.0f) / view.getHeight()) + 1.0f));
    }
}
