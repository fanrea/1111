package com.lingku.xuanshang.xutils.common.util;

import com.lingku.xuanshang.xutils.x;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class DensityUtil {
    public static float a = -1.0f;
    public static int b = -1;
    public static int c = -1;

    public static int dip2px(float f) {
        return (int) ((f * getDensity()) + 0.5f);
    }

    public static float getDensity() {
        if (a <= 0.0f) {
            a = x.app().getResources().getDisplayMetrics().density;
        }
        return a;
    }

    public static int getScreenHeight() {
        if (c <= 0) {
            c = x.app().getResources().getDisplayMetrics().heightPixels;
        }
        return c;
    }

    public static int getScreenWidth() {
        if (b <= 0) {
            b = x.app().getResources().getDisplayMetrics().widthPixels;
        }
        return b;
    }

    public static int px2dip(float f) {
        return (int) ((f / getDensity()) + 0.5f);
    }
}
