package com.kwad.sdk.core.view;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.style.ImageSpan;
import java.lang.ref.WeakReference;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class b extends ImageSpan {
    private Paint.FontMetricsInt aCE;
    private WeakReference<Drawable> aCF;
    private boolean bKq;
    private Rect bKr;

    public b(Drawable drawable, String str) {
        super(drawable, str, 1);
        this.bKq = true;
        this.aCE = new Paint.FontMetricsInt();
    }

    public final b I(int i, int i2) {
        this.bKq = false;
        this.bKr = new Rect(0, 0, i, i2);
        return this;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        Rect bounds = a(paint).getBounds();
        if (fontMetricsInt != null) {
            paint.getFontMetricsInt(fontMetricsInt);
            fontMetricsInt.ascent = fontMetricsInt.ascent;
            fontMetricsInt.descent = fontMetricsInt.descent;
            fontMetricsInt.top = fontMetricsInt.top;
            fontMetricsInt.bottom = fontMetricsInt.bottom;
        }
        return bounds.right;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        Drawable drawableA = a(paint);
        if (paint instanceof TextPaint) {
            drawableA.setState(((TextPaint) paint).drawableState);
        }
        int fontMetricsInt = paint.getFontMetricsInt(this.aCE);
        int i6 = i4 + this.aCE.ascent;
        int i7 = (fontMetricsInt - (drawableA.getBounds().bottom - drawableA.getBounds().top)) / 2;
        canvas.save();
        canvas.translate(f, i6 + i7);
        drawableA.draw(canvas);
        canvas.restore();
    }

    private Drawable a(Paint paint) {
        WeakReference<Drawable> weakReference = this.aCF;
        Drawable drawable = weakReference != null ? weakReference.get() : null;
        if (drawable == null) {
            drawable = getDrawable();
            if (this.bKq) {
                int fontMetricsInt = paint.getFontMetricsInt(null);
                drawable.setBounds(0, 0, fontMetricsInt, fontMetricsInt);
            } else {
                Rect rect = this.bKr;
                if (rect != null) {
                    drawable.setBounds(rect);
                }
            }
            this.aCF = new WeakReference<>(drawable);
        }
        return drawable;
    }
}
