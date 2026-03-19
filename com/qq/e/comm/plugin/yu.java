package com.qq.e.comm.plugin;

import android.content.Context;
import android.util.TypedValue;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class yu {
    public static float a(Context context, float f) {
        return TypedValue.applyDimension(1, f, context.getApplicationContext().getResources().getDisplayMetrics());
    }

    public static int a(Context context, int i) {
        return (int) TypedValue.applyDimension(1, i, context.getApplicationContext().getResources().getDisplayMetrics());
    }

    public static int b(Context context) {
        try {
            return (context.getApplicationContext().getResources().getConfiguration().screenLayout & 15) >= 3 ? 2 : 1;
        } catch (Exception e) {
            e.getMessage();
            return 0;
        }
    }

    public static int c(Context context) {
        return context.getApplicationContext().getResources().getDisplayMetrics().widthPixels;
    }

    public static int b(Context context, int i) {
        return (int) ((i / context.getApplicationContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int a(Context context) {
        return context.getApplicationContext().getResources().getDisplayMetrics().heightPixels;
    }
}
