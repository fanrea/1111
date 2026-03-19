package com.tk.core.o;

import android.R;
import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.util.Pair;
import android.view.Display;
import android.view.KeyCharacterMap;
import android.view.ViewConfiguration;
import android.view.WindowManager;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class ae {
    private static int ajH = 400;
    private static Pair<Integer, Display> ajI;

    static {
        try {
            ajH = s.getContext().getResources().getInteger(R.integer.config_mediumAnimTime);
        } catch (Throwable unused) {
            ajH = 400;
        }
    }

    public static Point aa(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealSize(point);
        } else if (Build.VERSION.SDK_INT >= 14) {
            point.x = ((Integer) com.tk.core.o.a.a.callMethod(defaultDisplay, "getRawWidth", new Object[0])).intValue();
            point.y = ((Integer) com.tk.core.o.a.a.callMethod(defaultDisplay, "getRawHeight", new Object[0])).intValue();
        }
        return point;
    }

    public static int P(Context context) {
        if (context == null || !ac(context)) {
            return 0;
        }
        return context.getResources().getDimensionPixelSize(context.getResources().getIdentifier("navigation_bar_height", "dimen", "android"));
    }

    private static Display ab(Context context) {
        int i = context.getResources().getDisplayMetrics().densityDpi;
        Pair<Integer, Display> pair = ajI;
        if (pair == null || ((Integer) pair.first).intValue() != i) {
            ajI = new Pair<>(Integer.valueOf(i), ((WindowManager) context.getSystemService("window")).getDefaultDisplay());
        }
        return (Display) ajI.second;
    }

    private static boolean ac(Context context) {
        if (Build.VERSION.SDK_INT < 17) {
            return (ViewConfiguration.get(context).hasPermanentMenuKey() || KeyCharacterMap.deviceHasKey(4)) ? false : true;
        }
        Display displayAb = ab(context);
        Point point = new Point();
        Point point2 = new Point();
        displayAb.getSize(point);
        displayAb.getRealSize(point2);
        return point2.y != point.y;
    }
}
