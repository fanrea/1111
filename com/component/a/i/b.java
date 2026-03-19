package com.component.a.i;

import android.graphics.RectF;
import android.graphics.drawable.shapes.OvalShape;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class b extends OvalShape {
    private float a = 0.0f;

    public void a(float f) {
        this.a = f;
    }

    @Override // android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
    protected void onResize(float f, float f2) {
        RectF rectFRect = rect();
        if (f > this.a && f2 > this.a) {
            rectFRect.set(this.a, this.a, f - this.a, f2 - this.a);
        } else {
            rectFRect.set(0.0f, 0.0f, f, f2);
        }
    }
}
