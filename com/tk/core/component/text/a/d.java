package com.tk.core.component.text.a;

import android.text.TextPaint;
import android.text.style.SuperscriptSpan;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class d extends SuperscriptSpan {
    private final int agC;

    public d(int i) {
        this.agC = i;
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
        textPaint.baselineShift += this.agC;
    }
}
