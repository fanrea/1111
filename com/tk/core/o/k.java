package com.tk.core.o;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class k {
    public static int P(Context context) {
        if (T(context)) {
            return X(context);
        }
        return 0;
    }

    private static boolean T(Context context) {
        if (m.sG()) {
            return U(context);
        }
        if (m.sH()) {
            return V(context);
        }
        if (m.sI()) {
            return W(context);
        }
        return q(context, 0);
    }

    private static boolean U(Context context) {
        return Settings.Global.getInt(context.getContentResolver(), "force_fsg_nav_bar", 0) == 0;
    }

    private static boolean V(Context context) {
        return Settings.Secure.getInt(context.getContentResolver(), "navigation_gesture_on", 0) == 0;
    }

    private static boolean W(Context context) {
        return Settings.Secure.getInt(context.getContentResolver(), "hide_navigationbar_enable", 0) == 0;
    }

    private static boolean q(Context context, int i) {
        int i2;
        if (Build.VERSION.SDK_INT < 21) {
            i2 = Settings.System.getInt(context.getContentResolver(), "navigationbar_is_min", 0);
        } else {
            i2 = Settings.Global.getInt(context.getContentResolver(), "navigationbar_is_min", 0);
        }
        return i2 == 0;
    }

    private static int X(Context context) {
        return context.getResources().getDimensionPixelSize(context.getResources().getIdentifier("navigation_bar_height", "dimen", "android"));
    }
}
