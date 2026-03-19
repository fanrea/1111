package com.fendasz.moku.planet.utils.canvas;

import android.graphics.Canvas;
import android.graphics.Paint;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class CanvasUtils {
    private static final String TAG = "CanvasUtils";

    public static float getTextWidth(Paint paint, String str) {
        return paint.measureText(str);
    }

    public static float getTextHeight(Paint paint, float f) {
        paint.setTextSize(f);
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        return fontMetrics.descent - fontMetrics.ascent;
    }

    public static float getTextAscent(Paint paint) {
        return Math.abs(paint.getFontMetrics().ascent);
    }

    public static int getTextSize(Paint paint, float f) {
        int i = (int) (2.0f * f);
        while (getTextHeight(paint, i) > f) {
            i--;
        }
        return i;
    }

    public static int getTextSize(float f) {
        int i = (int) (2.0f * f);
        while (getTextHeight(new Paint(), i) > f) {
            i--;
        }
        return i;
    }

    public static Paint getPaint(Paint.Style style, int i, float f) {
        Paint paint = new Paint(1);
        paint.setStyle(style);
        paint.setColor(i);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(f);
        return paint;
    }

    public static void drawLine(Canvas canvas, int i, float f, float f2, float f3, float f4, float f5) {
        canvas.drawLine(f2, f3, f4, f5, getPaint(Paint.Style.STROKE, i, f));
    }
}
