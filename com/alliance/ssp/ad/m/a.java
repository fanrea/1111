package com.alliance.ssp.ad.m;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/* compiled from: ScreenInfoCollector.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class a extends com.alliance.ssp.ad.n.a {
    public static float a(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (windowManager == null) {
            return 0.0f;
        }
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        float f = i / displayMetrics.xdpi;
        return (float) (Math.sqrt(Math.pow(i2, 2.0d) + Math.pow(i, 2.0d)) / Math.sqrt(Math.pow(i2 / displayMetrics.ydpi, 2.0d) + Math.pow(f, 2.0d)));
    }
}
