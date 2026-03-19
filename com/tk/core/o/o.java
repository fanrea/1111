package com.tk.core.o;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import java.lang.reflect.Field;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class o {
    private static DisplayMetrics ajk;
    private static int ajl;

    public static DisplayMetrics getDisplayMetrics() {
        if (ajk == null) {
            ajk = s.getContext().getResources().getDisplayMetrics();
        }
        return ajk;
    }

    public static int Y(Context context) {
        if (!(context instanceof Activity)) {
            return ec(getDisplayMetrics().widthPixels);
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return ec(displayMetrics.widthPixels);
    }

    public static int Z(Context context) {
        if (!(context instanceof Activity)) {
            return ec(getDisplayMetrics().heightPixels);
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return ec(displayMetrics.heightPixels);
    }

    public static int eb(int i) {
        float f;
        if (i >= 0) {
            f = (getDisplayMetrics().density * i) + 0.5f;
        } else {
            f = (getDisplayMetrics().density * i) - 0.5f;
        }
        return (int) f;
    }

    public static int P(float f) {
        float f2;
        if (f >= 0.0f) {
            f2 = (getDisplayMetrics().density * f) + 0.5f;
        } else {
            f2 = (getDisplayMetrics().density * f) - 0.5f;
        }
        return (int) f2;
    }

    public static int ec(int i) {
        float f;
        if (i >= 0) {
            f = (i / getDisplayMetrics().density) + 0.5f;
        } else {
            f = (i / getDisplayMetrics().density) - 0.5f;
        }
        return (int) f;
    }

    public static int Q(float f) {
        float f2;
        if (f >= 0.0f) {
            f2 = (f / getDisplayMetrics().density) + 0.5f;
        } else {
            f2 = (f / getDisplayMetrics().density) - 0.5f;
        }
        return (int) f2;
    }

    public static float R(float f) {
        return f / getDisplayMetrics().density;
    }

    public static int sN() {
        int i = ajl;
        if (i > 0) {
            return i;
        }
        Resources resources = s.getContext().getResources();
        int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            ajl = resources.getDimensionPixelSize(identifier);
        } else {
            try {
                Class<?> cls = Class.forName("com.android.internal.R$dimen");
                Object objNewInstance = cls.newInstance();
                Field field = cls.getField("status_bar_height");
                field.setAccessible(true);
                ajl = resources.getDimensionPixelSize(Integer.parseInt(field.get(objNewInstance).toString()));
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return ajl;
    }
}
