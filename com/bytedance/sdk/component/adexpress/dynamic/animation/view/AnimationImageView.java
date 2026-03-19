package com.bytedance.sdk.component.adexpress.dynamic.animation.view;

import android.content.Context;
import android.graphics.Canvas;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bytedance.sdk.component.adexpress.dynamic.b.h;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class AnimationImageView extends ImageView implements hc {
    private h an;
    private float b;
    private float c;
    d d;
    private float hc;
    private float u;

    public h getBrickNativeValue() {
        return this.an;
    }

    public void setBrickNativeValue(h hVar) {
        this.an = hVar;
    }

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

    public AnimationImageView(Context context) {
        super(context);
        this.d = new d();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        h hVar;
        super.onDraw(canvas);
        this.d.d(canvas, this, this);
        if (getRippleValue() == 0.0f || (hVar = this.an) == null || hVar.hc() <= 0) {
            return;
        }
        ((ViewGroup) getParent()).setClipChildren(false);
        ((ViewGroup) getParent().getParent()).setClipChildren(false);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.d.d(this, i, i2);
    }
}
