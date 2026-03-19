package com.tk.core.component.view;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class b {
    public static void a(View view, Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static float[] a(int i, Rect rect) {
        int i2 = ((i % 360) + 360) % 360;
        float[] fArr = new float[4];
        float f = (rect.left + rect.right) / 2.0f;
        float f2 = (rect.top + rect.bottom) / 2.0f;
        int i3 = i2 / 45;
        float fTan = (float) Math.tan(Math.toRadians(i2 % 45));
        float fTan2 = (float) Math.tan(Math.toRadians(45 - r9));
        switch (i3) {
            case 0:
                float f3 = fTan * f;
                fArr[0] = rect.left;
                fArr[1] = f2 + f3;
                fArr[2] = rect.right;
                fArr[3] = f2 - f3;
                return fArr;
            case 1:
                float f4 = f - (fTan2 * f2);
                fArr[0] = f4;
                fArr[1] = rect.bottom;
                fArr[2] = rect.right - f4;
                fArr[3] = rect.top;
                return fArr;
            case 2:
                float f5 = fTan * f2;
                fArr[0] = f + f5;
                fArr[1] = rect.bottom;
                fArr[2] = f - f5;
                fArr[3] = rect.top;
                return fArr;
            case 3:
                float f6 = f2 - (fTan2 * f);
                fArr[0] = rect.right;
                fArr[1] = rect.bottom - f6;
                fArr[2] = rect.left;
                fArr[3] = f6;
                return fArr;
            case 4:
                float f7 = fTan * f;
                fArr[2] = rect.left;
                fArr[3] = f2 + f7;
                fArr[0] = rect.right;
                fArr[1] = f2 - f7;
                return fArr;
            case 5:
                float f8 = f - (fTan2 * f2);
                fArr[2] = f8;
                fArr[3] = rect.bottom;
                fArr[0] = rect.right - f8;
                fArr[1] = rect.top;
                return fArr;
            case 6:
                float f9 = fTan * f2;
                fArr[2] = f + f9;
                fArr[3] = rect.bottom;
                fArr[0] = f - f9;
                fArr[1] = rect.top;
                return fArr;
            case 7:
                float f10 = f2 - (fTan2 * f);
                fArr[2] = rect.right;
                fArr[3] = rect.bottom - f10;
                fArr[0] = rect.left;
                fArr[1] = f10;
                return fArr;
            default:
                return fArr;
        }
    }
}
