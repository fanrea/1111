package com.tk.core.component.text.a;

import android.text.TextPaint;
import android.text.style.CharacterStyle;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class g extends CharacterStyle {
    private float aeQ;
    private float ahc;
    private float ahd;
    private final int ahe;

    public g(float f, float f2, float f3, int i) {
        this.ahc = 1.0f;
        this.ahd = 1.0f;
        this.aeQ = 1.0f;
        this.ahc = f;
        this.ahd = f2;
        this.aeQ = f3;
        this.ahe = i;
    }

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint textPaint) {
        textPaint.setShadowLayer(this.ahc, this.ahd, this.aeQ, this.ahe);
    }
}
