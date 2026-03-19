package com.netease.htprotect.p001OO8;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.Display;
import android.view.WindowManager;

/* renamed from: com.netease.htprotect.OO〇8.〇o〇0O〇0O, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class o0O0O {
    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public static Pair m506O8oO888(Context context) {
        int i;
        int i2 = 0;
        try {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            if (Build.VERSION.SDK_INT >= 17) {
                defaultDisplay.getRealSize(point);
            } else {
                defaultDisplay.getSize(point);
            }
            i = point.x;
            try {
                i2 = point.y;
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            i = 0;
        }
        if (i == 0 || i2 == 0) {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            i = displayMetrics.widthPixels;
            i2 = displayMetrics.heightPixels;
        }
        return new Pair(Integer.valueOf(i), Integer.valueOf(i2));
    }
}
