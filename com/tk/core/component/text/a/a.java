package com.tk.core.component.text.a;

import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class a extends com.tk.core.component.text.a {
    public a(Drawable drawable, String str) {
        super(drawable, str);
    }

    @Override // com.tk.core.component.text.a, android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        Paint.FontMetricsInt fontMetricsInt2;
        Drawable drawableA = a(paint);
        if (drawableA == null) {
            return 0;
        }
        Rect bounds = drawableA.getBounds();
        if (fontMetricsInt != null) {
            if (this.aeT > 0.0f) {
                if (this.aeU == null) {
                    this.aeU = new TextPaint(paint);
                }
                this.aeU.setTextSize(this.aeT);
                fontMetricsInt2 = this.aeU.getFontMetricsInt();
            } else {
                fontMetricsInt2 = paint.getFontMetricsInt();
            }
            int i3 = fontMetricsInt2.bottom - fontMetricsInt2.top;
            int i4 = (bounds.bottom - bounds.top) / 2;
            int i5 = i3 / 4;
            int i6 = i4 - i5;
            int i7 = i4 + i5;
            if (this.aeQ > 0.0f) {
                i7 -= (int) this.aeQ;
            } else if (this.aeQ < 0.0f) {
                i6 += (int) this.aeQ;
            }
            int i8 = -i7;
            fontMetricsInt.ascent = i8;
            fontMetricsInt.top = i8;
            fontMetricsInt.bottom = i6;
            fontMetricsInt.descent = i6;
        }
        return (int) (bounds.right + this.aeS + this.aeR);
    }
}
