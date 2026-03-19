package com.bytedance.adsdk.ugeno.widget.text;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.TextView;
import com.bytedance.adsdk.ugeno.b;
import com.bytedance.adsdk.ugeno.b.u;
import com.bytedance.adsdk.ugeno.d.gb;
import com.bytedance.adsdk.ugeno.d.h;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class UGTextView extends TextView implements u, h {
    private gb b;
    private b d;
    private float hc;

    public UGTextView(Context context) {
        super(context);
        this.b = new gb(this);
    }

    public void d(b bVar) {
        this.d = bVar;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        b bVar = this.d;
        if (bVar != null) {
            int[] iArrD = bVar.d(i, i2);
            super.onMeasure(iArrD[0], iArrD[1]);
        } else {
            super.onMeasure(i, i2);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        b bVar = this.d;
        if (bVar != null) {
            bVar.d(i, i2, i3, i4);
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // com.bytedance.adsdk.ugeno.b.u, com.bytedance.adsdk.ugeno.d.h
    public float getRipple() {
        return this.hc;
    }

    public void setShine(float f) {
        gb gbVar = this.b;
        if (gbVar != null) {
            gbVar.b(f);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.d.h
    public float getShine() {
        return this.b.getShine();
    }

    public void setStretch(float f) {
        gb gbVar = this.b;
        if (gbVar != null) {
            gbVar.c(f);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.d.h
    public float getStretch() {
        return this.b.getStretch();
    }

    public void setRubIn(float f) {
        gb gbVar = this.b;
        if (gbVar != null) {
            gbVar.u(f);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.d.h
    public float getRubIn() {
        return this.b.getRubIn();
    }

    public void setRipple(float f) {
        this.hc = f;
        gb gbVar = this.b;
        if (gbVar != null) {
            gbVar.hc(f);
        }
        postInvalidate();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        b bVar = this.d;
        if (bVar != null) {
            bVar.d(canvas, this);
            this.d.d(canvas);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        b bVar = this.d;
        if (bVar != null) {
            bVar.hc(i, i2, i3, i3);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        b bVar = this.d;
        if (bVar != null) {
            bVar.u();
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b bVar = this.d;
        if (bVar != null) {
            bVar.an();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        b bVar = this.d;
        if (bVar != null) {
            bVar.d(z);
        }
    }

    public void setBorderRadius(float f) {
        gb gbVar = this.b;
        if (gbVar != null) {
            gbVar.d(f);
        }
    }

    public float getBorderRadius() {
        return this.b.d();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.b.d(i);
    }
}
