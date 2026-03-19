package com.tk.core.component.text.a;

import android.os.Build;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class b extends MetricAffectingSpan {
    private final float Oz;

    public b(float f) {
        this.Oz = f;
    }

    @Override // android.text.style.MetricAffectingSpan
    public final void updateMeasureState(TextPaint textPaint) {
        a(textPaint);
    }

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint textPaint) {
        a(textPaint);
    }

    private void a(TextPaint textPaint) {
        if (Build.VERSION.SDK_INT >= 21) {
            textPaint.setLetterSpacing(this.Oz);
        }
    }
}
