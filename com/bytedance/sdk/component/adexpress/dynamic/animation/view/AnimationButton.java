package com.bytedance.sdk.component.adexpress.dynamic.animation.view;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.TextView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class AnimationButton extends TextView implements hc {
    private float b;
    private float c;
    d d;
    private float hc;
    private float u;

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.hc
    public float getShineValue() {
        return this.b;
    }

    public void setShineValue(float f) {
        this.b = f;
        postInvalidate();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.hc
    public float getRippleValue() {
        return this.hc;
    }

    public void setRippleValue(float f) {
        this.hc = f;
        postInvalidate();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.hc
    public float getMarqueeValue() {
        return this.c;
    }

    public void setMarqueeValue(float f) {
        this.c = f;
        postInvalidate();
    }

    public float getStretchValue() {
        return this.u;
    }

    public void setStretchValue(float f) {
        this.u = f;
        this.d.d(this, f);
    }

    public AnimationButton(Context context) {
        super(context);
        this.d = new d();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.d.d(canvas, this, this);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.d.d(this, i, i2);
    }
}
