package com.fendasz.moku.planet.common;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.text.style.ReplacementSpan;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class MokuVerticalCenterSpan extends ReplacementSpan {
    private int color;
    private int fontSizepx;

    public MokuVerticalCenterSpan(int i) {
        this.color = 0;
        this.fontSizepx = i;
    }

    public MokuVerticalCenterSpan(int i, int i2) {
        this.fontSizepx = i;
        this.color = i2;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        return (int) getCustomTextPaint(paint).measureText(charSequence.subSequence(i, i2).toString());
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        CharSequence charSequenceSubSequence = charSequence.subSequence(i, i2);
        TextPaint customTextPaint = getCustomTextPaint(paint);
        Paint.FontMetricsInt fontMetricsInt = customTextPaint.getFontMetricsInt();
        canvas.drawText(charSequenceSubSequence.toString(), f, i4 - (((((fontMetricsInt.descent + i4) + i4) + fontMetricsInt.ascent) / 2) - ((i5 + i3) / 2)), customTextPaint);
    }

    private TextPaint getCustomTextPaint(Paint paint) {
        TextPaint textPaint = new TextPaint(paint);
        textPaint.setTextSize(this.fontSizepx);
        int i = this.color;
        if (i != 0) {
            textPaint.setColor(i);
        }
        return textPaint;
    }
}
