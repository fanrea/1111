package com.qq.e.comm.plugin;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class y5 {
    private static RectF a = new RectF();
    private static Path b = new Path();

    /* JADX WARN: Removed duplicated region for block: B:14:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:71:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(android.graphics.Canvas r13, android.graphics.Paint r14, float r15, float r16, float r17, float r18, float r19, float r20, float r21) {
        /*
            Method dump skipped, instructions count: 308
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.y5.b(android.graphics.Canvas, android.graphics.Paint, float, float, float, float, float, float, float):void");
    }

    public static void b(Canvas canvas, Paint paint, int i, int i2, int i3, int[] iArr) {
        int i4;
        int i5;
        int i6;
        int i7;
        if (i3 == 0) {
            return;
        }
        int i8 = 0;
        if (iArr == null || iArr.length < 4) {
            i4 = i;
            i5 = 0;
            i6 = 0;
            i7 = 0;
        } else {
            int i9 = iArr[0];
            i6 = iArr[1];
            int i10 = iArr[2];
            i5 = iArr[3];
            i4 = i;
            i7 = i9;
            i8 = i10;
        }
        b(canvas, paint, i4, i2, i3, i7, i6, i5, i8);
    }

    public static void a(Canvas canvas, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        if (canvas == null) {
            return;
        }
        if (i4 < 0) {
            i4 = 0;
        }
        if (i5 < 0) {
            i5 = 0;
        }
        if (i6 < 0) {
            i6 = 0;
        }
        if (i7 < 0) {
            i7 = 0;
        }
        if (i4 == 0 && i5 == 0 && i6 == 0 && i7 == 0) {
            return;
        }
        b.reset();
        float f = i4;
        b.moveTo(f, 0.0f);
        b.lineTo(i - i5, 0.0f);
        if (i5 > 0) {
            float f2 = i5 * 2;
            float f3 = i;
            a.set(f3 - f2, 0.0f, f3, f2);
            b.arcTo(a, 270.0f, 90.0f);
        }
        float f4 = i;
        b.lineTo(f4, i2 - i7);
        if (i7 > 0) {
            float f5 = i7 * 2;
            float f6 = i2;
            a.set(f4 - f5, f6 - f5, f4, f6);
            b.arcTo(a, 0.0f, 90.0f);
        }
        float f7 = i2;
        b.lineTo(i6, f7);
        if (i6 > 0) {
            float f8 = i6 * 2;
            a.set(0.0f, f7 - f8, f8, f7);
            b.arcTo(a, 90.0f, 90.0f);
        }
        b.lineTo(0.0f, f);
        if (i4 > 0) {
            float f9 = i4 * 2;
            a.set(0.0f, 0.0f, f9, f9);
            b.arcTo(a, 180.0f, 90.0f);
        }
        canvas.clipPath(b);
    }

    public static void a(Canvas canvas, int i, int i2, int i3, int[] iArr) {
        if (iArr == null || iArr.length < 4) {
            return;
        }
        a(canvas, i, i2, i3, iArr[0], iArr[1], iArr[3], iArr[2]);
    }

    public static void a(Canvas canvas, Paint paint, float f, float f2, float f3, float f4, float f5, float f6, float f7) {
        if (canvas == null || paint == null) {
            return;
        }
        if (f4 < 0.0f) {
            f4 = 0.0f;
        }
        if (f5 < 0.0f) {
            f5 = 0.0f;
        }
        if (f6 < 0.0f) {
            f6 = 0.0f;
        }
        if (f7 < 0.0f) {
            f7 = 0.0f;
        }
        if (f3 > 0.0f) {
            f3 -= 1.0f;
        }
        b.reset();
        b.moveTo(f4, f3);
        b.lineTo(f - f5, f3);
        if (f5 > 0.0f) {
            float f8 = (f5 - f3) * 2.0f;
            a.set(f - f8, 0.0f, f, f8);
            a.offset(-f3, f3);
            b.arcTo(a, 270.0f, 90.0f);
        }
        b.lineTo(f - f3, f2 - f7);
        if (f7 > 0.0f) {
            float f9 = (f7 - f3) * 2.0f;
            a.set(f - f9, f2 - f9, f, f2);
            float f10 = -f3;
            a.offset(f10, f10);
            b.arcTo(a, 0.0f, 90.0f);
        }
        b.lineTo(f6, f2 - f3);
        if (f6 > 0.0f) {
            float f11 = (f6 - f3) * 2.0f;
            a.set(0.0f, f2 - f11, f11, f2);
            a.offset(f3, -f3);
            b.arcTo(a, 90.0f, 90.0f);
        }
        b.lineTo(f3, f4);
        if (f4 > 0.0f) {
            float f12 = (f4 - f3) * 2.0f;
            a.set(0.0f, 0.0f, f12, f12);
            a.offset(f3, f3);
            b.arcTo(a, 180.0f, 90.0f);
        }
        canvas.drawPath(b, paint);
    }

    public static void a(Canvas canvas, Paint paint, int i, int i2, int i3, int[] iArr) {
        if (canvas == null || paint == null) {
            return;
        }
        if (i3 == 0 && (iArr == null || iArr.length < 4)) {
            canvas.drawPaint(paint);
        } else if (iArr != null && iArr.length >= 4) {
            a(canvas, paint, i, i2, i3, iArr[0], iArr[1], iArr[3], iArr[2]);
        } else {
            a(canvas, paint, i, i2, i3, 0.0f, 0.0f, 0.0f, 0.0f);
        }
    }
}
