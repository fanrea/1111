package com.tk.core.component.text;

import android.graphics.Paint;
import android.text.style.LineHeightSpan;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class b implements LineHeightSpan {
    private final int km;

    public b(float f) {
        this.km = (int) Math.ceil(f);
    }

    @Override // android.text.style.LineHeightSpan
    public final void chooseHeight(CharSequence charSequence, int i, int i2, int i3, int i4, Paint.FontMetricsInt fontMetricsInt) {
        int i5 = this.km - ((-fontMetricsInt.ascent) + fontMetricsInt.descent);
        double d = fontMetricsInt.ascent;
        double d2 = i5 / 2.0f;
        double dFloor = Math.floor(d2);
        Double.isNaN(d);
        fontMetricsInt.ascent = (int) (d - dFloor);
        double d3 = fontMetricsInt.descent;
        double dCeil = Math.ceil(d2);
        Double.isNaN(d3);
        fontMetricsInt.descent = (int) (d3 + dCeil);
        fontMetricsInt.top = fontMetricsInt.ascent;
        fontMetricsInt.bottom = fontMetricsInt.descent;
    }
}
