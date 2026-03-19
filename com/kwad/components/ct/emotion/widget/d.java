package com.kwad.components.ct.emotion.widget;

import android.text.Editable;
import android.widget.EditText;
import android.widget.TextView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class d extends e {
    public d(TextView textView) {
        super(textView);
    }

    @Override // com.kwad.components.ct.emotion.widget.e
    public final void a(Editable editable) {
        TextView textView = this.aCM.get();
        if (editable == null) {
            return;
        }
        int length = editable.length();
        this.aCO = true;
        try {
            c(editable);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        a(textView, 0, length);
        try {
            if (textView instanceof EditText) {
                ((EditText) textView).setSelection(textView.getSelectionStart(), textView.getSelectionEnd());
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        this.aCO = false;
    }

    @Override // com.kwad.components.ct.emotion.widget.e
    protected final void a(TextView textView, int i, int i2) {
        a.a(textView, 0, i2, false);
    }
}
