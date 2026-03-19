package com.component.a.i;

import android.content.Context;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import com.baidu.mobads.container.util.bq;
import com.baidu.mobads.container.util.bv;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class a {
    private static volatile DisplayMetrics a;
    private static volatile Rect b;

    public static Rect a(Context context, boolean z) {
        if (a == null || z) {
            a = bv.g(context);
            try {
                if (a.widthPixels > a.heightPixels) {
                    b = new Rect(0, 0, a.heightPixels, a.widthPixels);
                } else {
                    b = new Rect(0, 0, a.widthPixels, a.heightPixels);
                }
            } catch (Throwable th) {
                bq.a().d(th.getMessage());
            }
        }
        return b;
    }

    public static float a(Context context) {
        a(context, false);
        if (a != null) {
            return a.density;
        }
        return 0.0f;
    }

    public static float b(Context context) {
        a(context, false);
        if (a != null) {
            return a.scaledDensity;
        }
        return 0.0f;
    }

    public static int c(Context context) {
        a(context, false);
        if (b == null) {
            return 0;
        }
        return b.width();
    }

    public static int d(Context context) {
        a(context, false);
        if (b == null) {
            return 0;
        }
        return b.height();
    }

    public static int a(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int b(Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
