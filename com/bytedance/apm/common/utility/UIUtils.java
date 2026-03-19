package com.bytedance.apm.common.utility;

import android.content.Context;
import android.util.DisplayMetrics;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class UIUtils {
    private static int mDpi = -1;
    private static String sScreenResolution = "";

    public static String getScreenResolution(Context context) {
        if (StringUtils.isEmpty(sScreenResolution) && context != null) {
            int screenWidth = getScreenWidth(context);
            int screenHeight = getScreenHeight(context);
            if (screenWidth > 0 && screenHeight > 0) {
                sScreenResolution = screenWidth + "*" + screenHeight;
            }
        }
        return sScreenResolution;
    }

    public static int getScreenWidth(Context context) {
        DisplayMetrics displayMetrics;
        if (context == null || (displayMetrics = context.getResources().getDisplayMetrics()) == null) {
            return 0;
        }
        return displayMetrics.widthPixels;
    }

    public static int getScreenHeight(Context context) {
        DisplayMetrics displayMetrics;
        if (context == null || (displayMetrics = context.getResources().getDisplayMetrics()) == null) {
            return 0;
        }
        return displayMetrics.heightPixels;
    }

    public static int getDpi(Context context) {
        if (mDpi == -1 && context != null) {
            mDpi = context.getApplicationContext().getResources().getDisplayMetrics().densityDpi;
        }
        return mDpi;
    }
}
