package com.kwad.components.ct.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class c extends GradientDrawable {
    private TextPaint atR;
    private CharSequence baN;
    private float baO;
    private StaticLayout baP;
    private int baQ;

    public c() {
        TextPaint textPaint = new TextPaint(1);
        this.atR = textPaint;
        textPaint.setColor(-1);
        this.atR.setTextAlign(Paint.Align.CENTER);
    }

    public final void setText(CharSequence charSequence) {
        this.baN = charSequence;
        if (!TextUtils.isEmpty(charSequence)) {
            this.baO = this.atR.measureText((String) this.baN);
        }
        this.baP = new StaticLayout(this.baN, this.atR, 200, Layout.Alignment.ALIGN_NORMAL, 1.0f, 1.0f, true);
    }

    public final void setTextSize(float f) {
        this.atR.setTextSize(f);
    }

    public final void setTextColor(int i) {
        this.atR.setColor(i);
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int i;
        super.draw(canvas);
        Rect bounds = getBounds();
        canvas.save();
        if (bounds.width() >= this.baQ) {
            i = bounds.right - (this.baQ / 2);
        } else {
            i = bounds.left + (this.baQ / 2);
        }
        canvas.translate(i, bounds.centerY() - (this.baO / 2.0f));
        this.baP.draw(canvas);
        canvas.restore();
    }

    public final void setWidth(int i) {
        this.baQ = i;
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.baQ;
    }
}
