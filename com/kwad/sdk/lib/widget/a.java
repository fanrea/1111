package com.kwad.sdk.lib.widget;

import android.text.Layout;
import android.text.TextPaint;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class a {
    private float ccH = -1.0f;
    private float ccI = 10.0f;
    private float ccJ = 1.0f;
    private float ccK = 0.0f;
    private float ccL = 1.0f;

    /* renamed from: com.kwad.sdk.lib.widget.a$a, reason: collision with other inner class name */
    public interface InterfaceC0620a {
        CharSequence getText();

        TextPaint getTextPaint();
    }

    public static float a(CharSequence charSequence, TextPaint textPaint, float f) {
        textPaint.setTextSize(f);
        return Layout.getDesiredWidth(charSequence, textPaint);
    }
}
