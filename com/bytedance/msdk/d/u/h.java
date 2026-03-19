package com.bytedance.msdk.d.u;

import android.content.Context;
import android.util.DisplayMetrics;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class h {
    private static float b = -1.0f;
    private static int c = -1;
    private static float d = -1.0f;
    private static int hc = -1;
    private static int u = -1;

    static {
        d(com.bytedance.msdk.core.hc.getContext());
    }

    public static void d(Context context) {
        Context context2 = context == null ? com.bytedance.msdk.core.hc.getContext() : context;
        if (context2 == null) {
            return;
        }
        DisplayMetrics displayMetrics = context2.getResources().getDisplayMetrics();
        d = displayMetrics.density;
        hc = displayMetrics.densityDpi;
        b = displayMetrics.scaledDensity;
        c = displayMetrics.widthPixels;
        u = displayMetrics.heightPixels;
        if (context == null || context.getResources() == null || context.getResources().getConfiguration() == null) {
            return;
        }
        if (context.getResources().getConfiguration().orientation == 1) {
            int i = c;
            int i2 = u;
            if (i > i2) {
                c = i2;
                u = i;
                return;
            }
            return;
        }
        int i3 = c;
        int i4 = u;
        if (i3 < i4) {
            c = i4;
            u = i3;
        }
    }

    public static int d(Context context, float f) {
        d(context);
        float fC = c(context);
        if (fC <= 0.0f) {
            fC = 1.0f;
        }
        return (int) ((f / fC) + 0.5f);
    }

    public static int hc(Context context) {
        d(context);
        return c;
    }

    public static int b(Context context) {
        d(context);
        return u;
    }

    public static float c(Context context) {
        d(context);
        return d;
    }

    public static int u(Context context) {
        d(context);
        return hc;
    }

    public static int hc(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
