package com.fendasz.moku.planet.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class ViewUtil {
    public static int dp2px(int i) {
        return (int) ((i * ((int) Resources.getSystem().getDisplayMetrics().density)) + 0.5f);
    }

    public static void applyRoundedCornerBackground(View view, int i, float f, Context context) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(i);
        gradientDrawable.setCornerRadius(f * context.getResources().getDisplayMetrics().density);
        view.setBackground(gradientDrawable);
    }

    public static GradientDrawable createRoundedCorner(Context context, int i, float f) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(i);
        gradientDrawable.setCornerRadius(f * context.getResources().getDisplayMetrics().density);
        return gradientDrawable;
    }
}
