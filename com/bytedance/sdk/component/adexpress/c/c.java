package com.bytedance.sdk.component.adexpress.c;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class c {
    public static Drawable d(Context context, com.bytedance.sdk.component.adexpress.dynamic.b.h hVar) {
        if (context == null || hVar == null) {
            return null;
        }
        return d(context, (int) gb.d(context, hVar.w()), hVar.cb(), hVar.zw());
    }

    public static Drawable d(Context context, int i, int i2, int i3) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        if (context != null) {
            gradientDrawable.setStroke(i, i2);
        }
        gradientDrawable.setColor(i3);
        return gradientDrawable;
    }
}
