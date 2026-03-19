package com.kwad.components.ct.emotion.widget;

import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.widget.TextView;
import java.lang.ref.WeakReference;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public abstract class e {
    protected final WeakReference<TextView> aCM;
    private int aCN = 1;
    protected boolean aCO = false;
    protected boolean aCP = true;

    public abstract void a(Editable editable);

    protected abstract void a(TextView textView, int i, int i2);

    public e(TextView textView) {
        this.aCM = new WeakReference<>(textView);
    }

    protected static void c(CharSequence charSequence) {
        String string = charSequence.toString();
        if (charSequence instanceof Spanned) {
            Spannable spannableString = charSequence instanceof Spannable ? (Spannable) charSequence : new SpannableString(charSequence);
            for (ImageSpan imageSpan : (ImageSpan[]) spannableString.getSpans(0, spannableString.length(), ImageSpan.class)) {
                int spanStart = spannableString.getSpanStart(imageSpan);
                if (spanStart > spannableString.length() - 1 || spannableString.getSpanEnd(imageSpan) > spannableString.length() || (imageSpan.getSource() != null && string.indexOf(imageSpan.getSource(), spanStart) != spannableString.getSpanStart(imageSpan))) {
                    spannableString.removeSpan(imageSpan);
                }
            }
        }
    }
}
