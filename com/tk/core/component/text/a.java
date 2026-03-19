package com.tk.core.component.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.style.ImageSpan;
import java.lang.ref.WeakReference;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public class a extends ImageSpan {
    private boolean aeN;
    private Rect aeO;
    private Paint.FontMetricsInt aeP;
    protected float aeQ;
    protected float aeR;
    protected float aeS;
    protected float aeT;
    protected TextPaint aeU;
    private WeakReference<Drawable> aeV;

    public a(Drawable drawable, String str) {
        super(drawable, str, 1);
        this.aeN = true;
        this.aeT = 0.0f;
        this.aeP = new Paint.FontMetricsInt();
    }

    public final a aQ(int i, int i2) {
        this.aeN = false;
        this.aeO = new Rect(0, 0, i, i2);
        return this;
    }

    public final a J(float f) {
        this.aeR = f;
        return this;
    }

    public final a K(float f) {
        this.aeS = f;
        return this;
    }

    public final a L(float f) {
        this.aeQ = f;
        return this;
    }

    public final void M(float f) {
        this.aeT = f;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        Drawable drawableA = a(paint);
        if (drawableA == null) {
            return 0;
        }
        Rect bounds = drawableA.getBounds();
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
        return (int) (bounds.right + this.aeS + this.aeR);
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        int fontMetricsInt;
        Drawable drawableA = a(paint);
        if (drawableA == null) {
            return;
        }
        if (paint instanceof TextPaint) {
            drawableA.setState(((TextPaint) paint).drawableState);
        }
        if (this.aeT > 0.0f) {
            if (this.aeU == null) {
                this.aeU = new TextPaint(paint);
            }
            this.aeU.setTextSize(this.aeT);
            fontMetricsInt = this.aeU.getFontMetricsInt(this.aeP);
        } else {
            fontMetricsInt = paint.getFontMetricsInt(this.aeP);
        }
        int i6 = i4 + this.aeP.ascent;
        int i7 = (fontMetricsInt - (drawableA.getBounds().bottom - drawableA.getBounds().top)) / 2;
        canvas.save();
        canvas.translate(f + this.aeR, i6 + i7 + this.aeQ);
        drawableA.draw(canvas);
        canvas.restore();
    }

    protected final Drawable a(Paint paint) {
        WeakReference<Drawable> weakReference = this.aeV;
        Drawable drawable = weakReference != null ? weakReference.get() : null;
        if (drawable == null) {
            drawable = getDrawable();
            if (this.aeN) {
                int fontMetricsInt = paint.getFontMetricsInt(null);
                drawable.setBounds(0, 0, fontMetricsInt, fontMetricsInt);
            } else {
                Rect rect = this.aeO;
                if (rect != null) {
                    drawable.setBounds(rect);
                }
            }
            this.aeV = new WeakReference<>(drawable);
        }
        return drawable;
    }
}
