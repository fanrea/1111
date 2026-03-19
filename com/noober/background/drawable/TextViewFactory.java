package com.noober.background.drawable;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class TextViewFactory {
    public static void setTextGradientColor(Context context, AttributeSet attributeSet, TextView textView) {
        new TextViewGradientColor().invoke(context, attributeSet, textView);
    }
}
