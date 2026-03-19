package com.qq.e.comm.plugin;

import android.graphics.Bitmap;
import android.graphics.Color;
import com.qq.e.comm.plugin.kt;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class lt {
    private static final a[] a;
    private static final int b;

    static {
        a aVar = new a(0.0f, Color.rgb(161, 166, 178));
        a = new a[]{aVar, new a(0.0f, 10.0f, Color.rgb(178, 79, 71)), new a(340.0f, 360.0f, Color.rgb(178, 79, 71)), new a(10.0f, 30.0f, Color.rgb(204, 116, 82)), new a(30.0f, 60.0f, Color.rgb(204, 142, 71)), new a(60.0f, 120.0f, Color.rgb(159, 163, 95)), new a(120.0f, 180.0f, Color.rgb(120, 161, 112)), new a(180.0f, 190.0f, Color.rgb(107, 153, 153)), new a(190.0f, 240.0f, Color.rgb(125, 158, 184)), new a(240.0f, 260.0f, Color.rgb(142, 130, 178)), new a(260.0f, 310.0f, Color.rgb(158, 115, 148)), new a(310.0f, 340.0f, Color.rgb(184, 114, 135))};
        b = aVar.d;
    }

    public static kt b(Bitmap bitmap) {
        return new kt.b(bitmap).a();
    }

    public static int a(Bitmap bitmap, int i) {
        kt.d dVarA = a(bitmap);
        if (dVarA == null) {
            return b;
        }
        float[] fArrC = dVarA.c();
        int i2 = 0;
        while (true) {
            a[] aVarArr = a;
            if (i2 < aVarArr.length) {
                int iA = aVarArr[i2].a(fArrC);
                if (iA != b) {
                    if (i == 0) {
                        return iA;
                    }
                    int length = (((i2 - 1) + i) % (aVarArr.length - 1)) + 1;
                    if (length < 0) {
                        length += aVarArr.length;
                    }
                    return aVarArr[length].d;
                }
                i2++;
            } else {
                return b;
            }
        }
    }

    /* compiled from: A */
    private static class a {
        private final float a;
        private final float b;
        private final float c;
        private final int d;

        a(float f, float f2, int i) {
            this.a = -1.0f;
            this.b = f < 0.0f ? -1.0f : f;
            this.c = f2 >= 360.0f ? -1.0f : f2;
            this.d = i;
        }

        final int a(float[] fArr) {
            float f = this.a;
            if (f != -1.0f && fArr[1] > f) {
                return lt.b;
            }
            float f2 = this.b;
            if (f2 != -1.0f && fArr[0] < f2) {
                return lt.b;
            }
            float f3 = this.c;
            if (f3 != -1.0f && fArr[0] >= f3) {
                return lt.b;
            }
            return this.d;
        }

        a(float f, int i) {
            this.a = (f > 1.0f || f < 0.0f) ? -1.0f : f;
            this.c = -1.0f;
            this.b = -1.0f;
            this.d = i;
        }
    }

    public static kt.d a(Bitmap bitmap) {
        kt ktVarB = b(bitmap);
        kt.d[] dVarArr = {ktVarB.h(), ktVarB.d(), ktVarB.c(), ktVarB.g(), ktVarB.e(), ktVarB.f()};
        kt.d dVar = null;
        for (int i = 0; i < 6; i++) {
            kt.d dVar2 = dVarArr[i];
            if (dVar2 != null && (dVar == null || dVar2.d() > dVar.d())) {
                dVar = dVar2;
            }
        }
        return dVar;
    }
}
