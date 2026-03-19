package com.component.a.i;

import android.graphics.Outline;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class q extends GradientDrawable {
    private final float a;
    private boolean b;

    public q(GradientDrawable.Orientation orientation, int[] iArr, float f) {
        super(orientation, iArr);
        this.b = false;
        this.a = f;
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        if (this.a >= -1.0f && this.a <= 1.0f) {
            Rect bounds = getBounds();
            float fA = r.a(bounds.width(), bounds.height(), this.a, -1.0f);
            if (fA >= 0.0f) {
                this.b = true;
                setCornerRadius(fA);
                this.b = false;
            }
        }
        super.getOutline(outline);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (!this.b) {
            super.invalidateSelf();
        }
    }
}
