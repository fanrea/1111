package com.fendasz.moku.planet.utils.canvas;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class CanvasHelper {
    private static final String TAG = "CanvasHelper";

    public static Bitmap getBackBitmap(int i, int i2, int i3) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
        drawBackBitmap(new Canvas(bitmapCreateBitmap), i);
        return bitmapCreateBitmap;
    }

    private static void drawBackBitmap(Canvas canvas, int i) {
        int width = canvas.getWidth();
        int i2 = (int) ((width / 2) * 0.618d);
        float height = canvas.getHeight();
        float f = height / 10.0f;
        float f2 = i2;
        float f3 = height / 2.0f;
        float f4 = width - i2;
        CanvasUtils.drawLine(canvas, i, f, f2, f3, f4, (int) ((r1 / 2) * 0.618d));
        CanvasUtils.drawLine(canvas, i, f, f2, f3, f4, r1 - r3);
    }
}
