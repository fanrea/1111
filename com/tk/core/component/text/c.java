package com.tk.core.component.text;

import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.TypefaceSpan;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class c extends TypefaceSpan {
    private final Typeface aP;

    public c(String str, Typeface typeface) {
        super((String) null);
        this.aP = typeface;
    }

    @Override // android.text.style.TypefaceSpan
    public final Typeface getTypeface() {
        return this.aP;
    }

    @Override // android.text.style.TypefaceSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint textPaint) {
        Typeface typeface = this.aP;
        if (typeface != null) {
            textPaint.setTypeface(typeface);
        } else {
            super.updateDrawState(textPaint);
        }
    }

    @Override // android.text.style.TypefaceSpan, android.text.style.MetricAffectingSpan
    public final void updateMeasureState(TextPaint textPaint) {
        Typeface typeface = this.aP;
        if (typeface != null) {
            textPaint.setTypeface(typeface);
        } else {
            super.updateMeasureState(textPaint);
        }
    }
}
