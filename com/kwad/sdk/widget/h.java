package com.kwad.sdk.widget;

import android.content.Context;
import android.widget.TextView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class h extends TextView {
    public h(Context context) {
        super(context);
    }

    @Override // android.widget.TextView
    public final void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        if ("".equals(charSequence) || charSequence == null || charSequence.length() == 0) {
            return;
        }
        int length = charSequence.length();
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            stringBuffer.append(((Object) charSequence.toString().subSequence(i, i2)) + "\n");
            i = i2;
        }
        super.setText(stringBuffer, bufferType);
    }
}
