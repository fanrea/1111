package com.kwad.components.ct.emotion.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.style.ImageSpan;
import android.view.View;
import java.lang.ref.WeakReference;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c extends ImageSpan {
    private Paint.FontMetricsInt aCE;
    private WeakReference<Drawable> aCF;

    public c(Drawable drawable, String str, View view) {
        super(drawable, str);
        this.aCE = new Paint.FontMetricsInt();
        drawable.setCallback(view);
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        Rect bounds = DU().getBounds();
        if (fontMetricsInt != null) {
            Paint.FontMetricsInt fontMetricsInt2 = paint.getFontMetricsInt();
            int i3 = fontMetricsInt2.bottom - fontMetricsInt2.top;
            int i4 = (bounds.bottom - bounds.top) / 2;
            int i5 = i3 / 4;
            int i6 = i4 - i5;
            int i7 = -(i4 + i5);
            fontMetricsInt.ascent = i7;
            fontMetricsInt.top = i7;
            fontMetricsInt.bottom = i6;
            fontMetricsInt.descent = i6;
        }
        return (int) (bounds.right * 1.1d);
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        Drawable drawableDU = DU();
        if (paint instanceof TextPaint) {
            drawableDU.setState(((TextPaint) paint).drawableState);
        }
        int fontMetricsInt = paint.getFontMetricsInt(this.aCE);
        int i6 = i4 + this.aCE.ascent;
        int i7 = (fontMetricsInt - (drawableDU.getBounds().bottom - drawableDU.getBounds().top)) / 2;
        canvas.save();
        canvas.translate(f, i6 + i7);
        drawableDU.draw(canvas);
        canvas.restore();
    }

    private Drawable DU() {
        WeakReference<Drawable> weakReference = this.aCF;
        if (weakReference == null || weakReference.get() == null) {
            this.aCF = new WeakReference<>(getDrawable());
        }
        return this.aCF.get();
    }
}
