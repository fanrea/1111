package com.bytedance.sdk.component.adexpress.c;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.bytedance.sdk.component.utils.jh;
import java.util.Locale;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class gb {
    private static boolean d;

    public static int d(float f, float f2, float f3, float f4) {
        return (((int) ((f * 255.0f) + 0.5f)) << 24) | (((int) ((f2 * 255.0f) + 0.5f)) << 16) | (((int) ((f3 * 255.0f) + 0.5f)) << 8) | ((int) ((f4 * 255.0f) + 0.5f));
    }

    public static float d(Context context, float f) {
        if (context == null) {
            context = com.bytedance.sdk.component.adexpress.d.d.d.d().b().getContext();
        }
        return (f * u(context)) + 0.5f;
    }

    public static int hc(Context context, float f) throws NoSuchMethodException, ClassNotFoundException, SecurityException {
        if (context == null) {
            context = com.bytedance.sdk.component.adexpress.d.d.d.d().b().getContext();
        }
        float fU = u(context);
        if (fU <= 0.0f) {
            fU = 1.0f;
        }
        return (int) ((f / fU) + 0.5f);
    }

    public static float b(Context context, float f) {
        if (context == null) {
            context = com.bytedance.sdk.component.adexpress.d.d.d.d().b().getContext();
        }
        return f * u(context);
    }

    private static float u(Context context) throws NoSuchMethodException, ClassNotFoundException, SecurityException {
        try {
            if (d) {
                context.getClassLoader().loadClass("android.util.DisplayMetrics").getDeclaredMethod("getDeviceDensity", new Class[0]).setAccessible(true);
                return ((Integer) r1.invoke(r0, new Object[0])).intValue() / 160.0f;
            }
        } catch (Exception unused) {
        }
        return context.getResources().getDisplayMetrics().density;
    }

    public static int d(Context context) {
        if (context == null) {
            context = com.bytedance.sdk.component.adexpress.d.d.d.d().b().getContext();
        }
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int hc(Context context) {
        if (context == null) {
            context = com.bytedance.sdk.component.adexpress.d.d.d.d().b().getContext();
        }
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static int b(Context context) {
        if (context == null) {
            context = com.bytedance.sdk.component.adexpress.d.d.d.d().b().getContext();
        }
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (Build.VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealMetrics(displayMetrics);
        } else {
            defaultDisplay.getMetrics(displayMetrics);
        }
        return displayMetrics.heightPixels;
    }

    public static String c(Context context) {
        String language;
        Locale locale;
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                locale = jh.d(context).getConfiguration().getLocales().get(0);
            } else {
                locale = Locale.getDefault();
            }
            language = locale.getLanguage();
            try {
                if (locale.getCountry().equals("TW")) {
                    language = "zhHant";
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            language = "";
        }
        return d(language);
    }

    private static String d(String str) {
        str.hashCode();
        switch (str) {
            case "ar":
                return "aa";
            case "ja":
                return "japan";
            case "ko":
                return "korea";
            case "ms":
                return "my";
            case "zh":
                return "cn";
            default:
                return str;
        }
    }
}
