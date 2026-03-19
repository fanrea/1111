package com.baidu.mobads.container.util;

import android.content.Context;
import android.graphics.Rect;
import android.os.PowerManager;
import android.util.DisplayMetrics;
import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class r {
    public static final int a = 4;
    public static final int b = 1;
    public static final int c = 6;
    public static final int d = 3;
    public static final int e = 0;

    public static boolean a(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        Rect rectD = bv.d(view.getContext());
        int width = iArr[0] + (view.getWidth() / 2);
        int height = iArr[1] + (view.getHeight() / 2);
        return width <= 0 || width >= rectD.width() || height <= 0 || height >= rectD.height();
    }

    public static boolean a(Context context) {
        try {
            return ((PowerManager) context.getSystemService("power")).isScreenOn();
        } catch (Exception e2) {
            bq.a().a(e2);
            return true;
        }
    }

    public static boolean b(View view) {
        return view != null && (view.getWidth() < 10 || view.getHeight() < 10);
    }

    public static boolean c(View view) {
        if (view != null && view.isShown()) {
            return true;
        }
        return false;
    }

    public static boolean a(View view, int i) {
        if (view == null || view.getVisibility() != 0 || view.getParent() == null) {
            return false;
        }
        if (!view.getGlobalVisibleRect(new Rect())) {
            return false;
        }
        long height = view.getHeight() * view.getWidth();
        return height > 0 && (r1.height() * r1.width()) * 100 >= ((long) i) * height;
    }

    public static int a(View view, Context context) {
        if (view != null) {
            try {
                if (view.isShown()) {
                    DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                    int i = displayMetrics.heightPixels;
                    int i2 = displayMetrics.widthPixels;
                    Rect rect = new Rect();
                    view.getGlobalVisibleRect(rect);
                    if (rect.top > i || rect.left > i2) {
                        return 0;
                    }
                    double dWidth = rect.width() * rect.height();
                    double width = view.getWidth() * view.getHeight();
                    Double.isNaN(dWidth);
                    Double.isNaN(width);
                    return (int) ((dWidth * 100.0d) / width);
                }
            } catch (Exception e2) {
                return 0;
            }
        }
        return 0;
    }

    public static int d(View view) {
        if (view == null) {
            return 1;
        }
        if (!a(view.getContext())) {
            return 4;
        }
        if (!c(view)) {
            return 1;
        }
        if (!e(view)) {
            return 6;
        }
        if (a(view, 50)) {
            return 0;
        }
        return 3;
    }

    private static boolean e(View view) {
        return view.getWidth() > 15 && view.getHeight() > 15;
    }
}
