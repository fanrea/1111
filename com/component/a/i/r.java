package com.component.a.i;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.component.a.f.e;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class r {
    /* JADX WARN: Removed duplicated region for block: B:19:0x005c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.Bitmap a(android.content.Context r13, android.graphics.Bitmap r14, android.graphics.RectF r15, int r16, float r17, boolean r18) {
        /*
            r0 = r17
            r1 = 0
            if (r14 == 0) goto Lb8
            boolean r2 = r14.isRecycled()     // Catch: java.lang.Throwable -> Laf
            if (r2 != 0) goto Lb8
        Ld:
            android.graphics.Matrix r7 = new android.graphics.Matrix     // Catch: java.lang.Throwable -> Laf
            r7.<init>()     // Catch: java.lang.Throwable -> Laf
            int r2 = r14.getWidth()     // Catch: java.lang.Throwable -> Laf
            int r3 = r14.getHeight()     // Catch: java.lang.Throwable -> Laf
            r4 = 0
            if (r15 == 0) goto L5c
            float r5 = r15.width()     // Catch: java.lang.Throwable -> Laf
            float r6 = r15.height()     // Catch: java.lang.Throwable -> Laf
            if (r2 <= 0) goto L5c
            if (r3 <= 0) goto L5c
            r8 = 1
            r9 = r16
            if (r9 != r8) goto L55
        L2f:
            float r8 = (float) r2     // Catch: java.lang.Throwable -> Laf
            float r9 = r8 * r6
            float r10 = (float) r3     // Catch: java.lang.Throwable -> Laf
            float r11 = r5 * r10
            r12 = 1056964608(0x3f000000, float:0.5)
            int r9 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r9 <= 0) goto L48
            float r6 = r6 / r10
            float r5 = r5 / r6
            float r8 = r8 - r5
            float r8 = r8 * r12
            int r5 = java.lang.Math.round(r8)     // Catch: java.lang.Throwable -> Laf
            r4 = r5
            r5 = r6
            r6 = 0
            goto L51
        L48:
            float r5 = r5 / r8
            float r6 = r6 / r5
            float r10 = r10 - r6
            float r10 = r10 * r12
            int r6 = java.lang.Math.round(r10)     // Catch: java.lang.Throwable -> Laf
        L51:
            r7.setScale(r5, r5)     // Catch: java.lang.Throwable -> Laf
            goto L5d
        L55:
            float r8 = (float) r2     // Catch: java.lang.Throwable -> Laf
            float r5 = r5 / r8
            float r8 = (float) r3     // Catch: java.lang.Throwable -> Laf
            float r6 = r6 / r8
            r7.setScale(r5, r6)     // Catch: java.lang.Throwable -> Laf
        L5c:
            r6 = 0
        L5d:
            r5 = 0
            int r5 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r5 <= 0) goto L65
            r7.postScale(r0, r0)     // Catch: java.lang.Throwable -> Laf
        L65:
            int r0 = r4 * 2
            int r5 = r2 - r0
            int r0 = r6 * 2
            int r0 = r3 - r0
            r8 = 1
            r2 = r14
            r3 = r4
            r4 = r6
            r6 = r0
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> Laf
            if (r18 == 0) goto Lae
            com.baidu.mobads.container.util.x r2 = com.baidu.mobads.container.util.x.a(r1)     // Catch: java.lang.Throwable -> Laf
            int r2 = r2.a()     // Catch: java.lang.Throwable -> Laf
            r3 = 17
            if (r2 < r3) goto Lae
            android.renderscript.RenderScript r2 = android.renderscript.RenderScript.create(r13)     // Catch: java.lang.Throwable -> Laf
            android.renderscript.Element r3 = android.renderscript.Element.U8_4(r2)     // Catch: java.lang.Throwable -> Laf
            android.renderscript.ScriptIntrinsicBlur r3 = android.renderscript.ScriptIntrinsicBlur.create(r2, r3)     // Catch: java.lang.Throwable -> Laf
            android.renderscript.Allocation r4 = android.renderscript.Allocation.createFromBitmap(r2, r0)     // Catch: java.lang.Throwable -> Laf
            android.renderscript.Type r5 = r4.getType()     // Catch: java.lang.Throwable -> Laf
            android.renderscript.Allocation r5 = android.renderscript.Allocation.createTyped(r2, r5)     // Catch: java.lang.Throwable -> Laf
            r6 = 1092091904(0x41180000, float:9.5)
            r3.setRadius(r6)     // Catch: java.lang.Throwable -> Laf
            r3.setInput(r4)     // Catch: java.lang.Throwable -> Laf
            r3.forEach(r5)     // Catch: java.lang.Throwable -> Laf
            r5.copyTo(r0)     // Catch: java.lang.Throwable -> Laf
            r2.destroy()     // Catch: java.lang.Throwable -> Laf
        Lae:
            return r0
        Laf:
            r0 = move-exception
            com.baidu.mobads.container.util.bq r2 = com.baidu.mobads.container.util.bq.a()
            r2.a(r0)
            goto Lb9
        Lb8:
        Lb9:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.component.a.i.r.a(android.content.Context, android.graphics.Bitmap, android.graphics.RectF, int, float, boolean):android.graphics.Bitmap");
    }

    public static Drawable a(Context context, e.f fVar) {
        int[] iArr;
        float[] fArr;
        if (fVar == null || fVar.a().length() <= 0) {
            return null;
        }
        String strA = fVar.a(e.f.a);
        int iA = fVar.a(-1);
        float fA = fVar.a(1.0f);
        if (TextUtils.isEmpty(fVar.a().optString("alpha", "")) && TextUtils.isEmpty(fVar.a().optString(TypedValues.Custom.S_COLOR, ""))) {
            fA = 0.0f;
        }
        int iA2 = a(iA, fA);
        int iA3 = a.a(context, fVar.f(0));
        int iA4 = a(fVar.e(-1), fVar.e(1.0f));
        int[] iArr2 = {iA2};
        GradientDrawable.Orientation orientation = GradientDrawable.Orientation.TOP_BOTTOM;
        if (fVar.b() == 1) {
            GradientDrawable.Orientation orientation2 = GradientDrawable.Orientation.TOP_BOTTOM;
            iArr = new int[]{a(fVar.c(-1), fVar.c(1.0f)), a(fVar.d(-1), fVar.d(1.0f))};
            orientation = orientation2;
        } else if (fVar.b() != 2) {
            iArr = iArr2;
        } else {
            GradientDrawable.Orientation orientation3 = GradientDrawable.Orientation.LEFT_RIGHT;
            iArr = new int[]{a(fVar.c(-1), fVar.c(1.0f)), a(fVar.d(-1), fVar.d(1.0f))};
            orientation = orientation3;
        }
        if (e.f.a.equals(strA)) {
            float[] fArrA = fVar.a(new float[8]);
            float f = fVar.f(-2.0f);
            if (fArrA.length >= 8) {
                fArr = fArrA;
            } else {
                fArr = new float[8];
            }
            for (int i = 0; i < 8; i++) {
                fArr[i] = a.a(context, fArr[i]);
            }
            return a(0, orientation, iArr, iA4, iA3, fArr, f);
        }
        if (e.f.b.equals(strA)) {
            return a(1, orientation, iArr, iA4, iA3, null, -2.0f);
        }
        if (e.f.c.equals(strA)) {
            return new v(iA2);
        }
        return null;
    }

    public static Drawable a(int i, GradientDrawable.Orientation orientation, int[] iArr, int i2, int i3, float[] fArr, float f) {
        if (iArr == null) {
            iArr = new int[]{-1};
        }
        q qVar = new q(orientation, iArr, f);
        qVar.setGradientType(0);
        if (iArr.length == 1) {
            qVar.setColor(iArr[0]);
        }
        if (i3 > 0) {
            qVar.setStroke(i3, i2);
        }
        qVar.setShape(i);
        if (i == 0 && fArr != null && fArr.length >= 8) {
            qVar.setCornerRadii(fArr);
        }
        return qVar;
    }

    public static int a(int i, float f) {
        if (f < 0.0f) {
            f = 0.0f;
        } else if (f > 1.0f) {
            f = 1.0f;
        }
        return (i & 16777215) | (((int) ((f * 255.0f) + 0.5f)) << 24);
    }

    public static float a(float f, float f2, float f3, float f4) {
        if (f3 >= -1.0f && f3 <= 1.0f) {
            if (f3 < 0.0f && f > 0.0f) {
                return f * Math.abs(f3);
            }
            if (f2 > 0.0f) {
                return f2 * Math.abs(f3);
            }
        }
        return f4;
    }
}
