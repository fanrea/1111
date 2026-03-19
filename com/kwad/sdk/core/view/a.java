package com.kwad.sdk.core.view;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class a extends GradientDrawable {
    private float Lx;
    private Drawable bKo;
    private Drawable bKp;

    public final void setProgress(float f) {
        this.Lx = f;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        if (this.Lx == 0.0f) {
            this.bKp.setBounds(getBounds());
            this.bKp.draw(canvas);
            super.draw(canvas);
            return;
        }
        if (this.bKo.getBounds().width() != getBounds().width()) {
            this.bKo.setBounds(getBounds());
        }
        if (this.bKp.getBounds().width() != getBounds().width()) {
            this.bKp.setBounds(getBounds());
        }
        canvas.save();
        int iWidth = (int) (getBounds().width() * this.Lx);
        canvas.clipRect(0, 0, iWidth, getBounds().height());
        this.bKo.draw(canvas);
        canvas.restore();
        canvas.save();
        canvas.clipRect(iWidth, 0, getBounds().width(), getBounds().height());
        this.bKp.draw(canvas);
        canvas.restore();
        super.draw(canvas);
    }
}
