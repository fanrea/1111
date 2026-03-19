package com.baidu.enan.e.b.a;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class e {
    public static String a(Context context) {
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics.xdpi > displayMetrics.ydpi ? displayMetrics.ydpi + "/" + displayMetrics.xdpi : displayMetrics.xdpi + "/" + displayMetrics.ydpi;
        } catch (Throwable th) {
            com.baidu.enan.f.b.a(th);
            return "";
        }
    }
}
