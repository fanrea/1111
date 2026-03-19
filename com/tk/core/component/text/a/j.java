package com.tk.core.component.text.a;

import android.text.TextPaint;
import android.text.style.SuperscriptSpan;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class j extends SuperscriptSpan {
    private TextPaint aeU;
    private final int ahg;
    private final int ahh;
    private final String ahi;
    private TextPaint ahj;

    public j(int i, int i2, String str) {
        this.ahg = i;
        this.ahh = i2;
        this.ahi = str;
    }

    @Override // android.text.style.SuperscriptSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint textPaint) {
        b(textPaint);
    }

    @Override // android.text.style.SuperscriptSpan, android.text.style.MetricAffectingSpan
    public final void updateMeasureState(TextPaint textPaint) {
        b(textPaint);
    }

    private void b(TextPaint textPaint) {
        if (this.ahj == null) {
            this.ahj = new TextPaint(textPaint);
            this.ahj.setTextSize(this.ahg);
        }
        if (this.aeU == null) {
            this.aeU = new TextPaint(textPaint);
            this.aeU.setTextSize(this.ahh);
        }
        if ("middle".equals(this.ahi)) {
            textPaint.baselineShift -= (((int) Math.abs(this.ahj.ascent() + this.ahj.descent())) / 2) - (((int) Math.abs(this.aeU.ascent() + this.aeU.descent())) / 2);
        } else if (com.baidu.mobads.container.util.animation.j.f.equals(this.ahi)) {
            textPaint.baselineShift -= (int) Math.abs(this.ahj.ascent() - this.aeU.ascent());
        }
    }
}
