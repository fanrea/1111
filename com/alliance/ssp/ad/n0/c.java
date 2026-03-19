package com.alliance.ssp.ad.n0;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.DisplayMetrics;
import android.view.Window;
import com.alliance.ssp.ad.o0.h;

/* compiled from: PatternTemplate.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class c {
    public static String a(String str, int i) {
        return str.length() > i ? str.substring(0, i) + "..." : str;
    }

    public static Bitmap a(Window window, Context context, Bitmap bitmap, int i) {
        int iB;
        if (bitmap == null || context == null) {
            return null;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        window.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i2 = displayMetrics.widthPixels;
        int i3 = displayMetrics.heightPixels;
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint();
        paint.setColor(-16777216);
        float f = i2;
        float f2 = i3;
        canvas.drawRect(0.0f, 0.0f, f, f2, paint);
        int i4 = 0;
        if (i == 1) {
            float width = f / bitmap.getWidth();
            int height = (int) (bitmap.getHeight() * width);
            int i5 = (i3 - height) / 2;
            bitmap = Bitmap.createScaledBitmap(bitmap, (int) (bitmap.getWidth() * width), height, true);
            iB = 0;
            i4 = i5;
        } else if (i != 2) {
            iB = 0;
        } else if (bitmap.getWidth() > bitmap.getHeight()) {
            float height2 = f2 / bitmap.getHeight();
            iB = (i2 - ((int) (bitmap.getWidth() * height2))) / 2;
            bitmap = Bitmap.createScaledBitmap(bitmap, (int) (bitmap.getWidth() * height2), (int) (bitmap.getHeight() * height2), true);
        } else {
            bitmap = Bitmap.createScaledBitmap(bitmap, i2 - h.b(context, 100.0f), i3, true);
            iB = h.b(context, 50.0f);
        }
        canvas.drawBitmap(bitmap, iB, i4, paint);
        return bitmapCreateBitmap;
    }
}
