package com.qq.e.comm.plugin;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.Display;
import android.view.WindowManager;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class zu {
    private static Configuration a;
    private static Pair<Integer, Integer> b;
    private static float c;

    public static int c() {
        return ((Integer) (d() ? b.first : b.second)).intValue();
    }

    public static boolean d() {
        return a.orientation == 1;
    }

    public static int a(double d) {
        if (d == 0.0d) {
            return 0;
        }
        float f = c;
        if (f < 0.0f) {
            f = 1.0f;
        }
        if (d > 0.0d) {
            double d2 = f;
            Double.isNaN(d2);
            return (int) ((d * d2) + 0.5d);
        }
        double d3 = f;
        Double.isNaN(d3);
        return -((int) (((-d) * d3) + 0.5d));
    }

    public static int b(double d) {
        if (d == 0.0d) {
            return 0;
        }
        float f = c;
        if (f < 0.0f) {
            f = 1.0f;
        }
        if (d > 0.0d) {
            double d2 = f;
            Double.isNaN(d2);
            return (int) ((d / d2) + 0.5d);
        }
        double d3 = f;
        Double.isNaN(d3);
        return -((int) (((-d) / d3) + 0.5d));
    }

    public static int b() {
        return ((Integer) (d() ? b.second : b.first)).intValue();
    }

    public static void a(Context context) {
        Context applicationContext = context.getApplicationContext();
        Configuration configuration = applicationContext.getResources().getConfiguration();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        a = configuration;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Display defaultDisplay = ((WindowManager) applicationContext.getSystemService("window")).getDefaultDisplay();
        if (Build.VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealMetrics(displayMetrics);
        } else {
            defaultDisplay.getMetrics(displayMetrics);
        }
        if (a.orientation == 1) {
            b = new Pair<>(Integer.valueOf(displayMetrics.widthPixels), Integer.valueOf(displayMetrics.heightPixels));
        } else {
            b = new Pair<>(Integer.valueOf(displayMetrics.heightPixels), Integer.valueOf(displayMetrics.widthPixels));
        }
        c = displayMetrics.density;
        v8.a(2230120, SystemClock.elapsedRealtime() - jElapsedRealtime, 1, null);
    }

    public static float a() {
        return c;
    }
}
