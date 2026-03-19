package com.tk.core.component.text.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class c extends Drawable {
    private final Drawable agA;
    private final int agC;
    private final Drawable agz;
    private ColorFilter gf;
    private final int km;
    private final int us;
    private int mAlpha = 255;
    private final int agB = 0;

    public c(Drawable drawable, Drawable drawable2, int i, int i2, int i3, int i4) {
        this.agz = drawable;
        this.agA = drawable2;
        this.us = i;
        this.km = i2;
        this.agC = i4;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        canvas.save();
        this.agz.draw(canvas);
        canvas.restore();
        if (this.agB > 0 || this.agC > 0) {
            canvas.translate(this.agB, this.agC);
        }
        this.agA.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        this.mAlpha = i;
        this.agz.setAlpha(i);
        this.agA.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.mAlpha;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.gf = colorFilter;
        this.agz.setColorFilter(colorFilter);
        this.agA.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public final ColorFilter getColorFilter() {
        return this.gf;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return ((this.agz.getOpacity() & (-3)) & this.agA.getOpacity()) == -3 ? -3 : -1;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.us;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.km;
    }
}
