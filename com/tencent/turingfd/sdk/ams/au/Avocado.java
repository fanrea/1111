package com.tencent.turingfd.sdk.ams.au;

import java.util.ArrayList;
import java.util.regex.Pattern;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class Avocado {
    public static final String[] a;
    public static volatile Pattern[] b;

    static {
        int[] iArr = Cfinally.o;
        String strA = Cfinally.a(iArr);
        int[] iArr2 = Cfinally.p;
        String strA2 = Cfinally.a(iArr2);
        int[] iArr3 = Cfinally.q;
        String strA3 = Cfinally.a(iArr3);
        int[] iArr4 = Cfinally.r;
        String strA4 = Cfinally.a(iArr4);
        int[] iArr5 = Cfinally.s;
        String strA5 = Cfinally.a(iArr5);
        int[] iArr6 = Cfinally.t;
        String strA6 = Cfinally.a(iArr6);
        int[] iArr7 = Cfinally.u;
        String strA7 = Cfinally.a(iArr7);
        int[] iArr8 = Cfinally.v;
        String strA8 = Cfinally.a(iArr8);
        String strA9 = Cfinally.a(Cfinally.w);
        int[] iArr9 = Cfinally.x;
        String strA10 = Cfinally.a(iArr9);
        String strA11 = Cfinally.a(Cfinally.y);
        String strA12 = Cfinally.a(Cfinally.z);
        String strA13 = Cfinally.a(Cfinally.A);
        String strA14 = Cfinally.a(Cfinally.B);
        String strA15 = Cfinally.a(Cfinally.C);
        String strA16 = Cfinally.a(Cfinally.D);
        int[] iArr10 = Cfinally.E;
        String strA17 = Cfinally.a(iArr10);
        int[] iArr11 = Cfinally.F;
        String strA18 = Cfinally.a(iArr11);
        int[] iArr12 = Cfinally.G;
        String strA19 = Cfinally.a(iArr12);
        int[] iArr13 = Cfinally.H;
        String strA20 = Cfinally.a(iArr13);
        int[] iArr14 = Cfinally.I;
        a = new String[]{strA, strA2, strA3, strA4, strA5, strA6, strA7, strA8, strA9, strA10, strA11, strA12, strA13, strA14, strA15, strA16, strA17, strA18, strA19, strA20, Cfinally.a(iArr14)};
        Cfinally.a(iArr);
        Cfinally.a(iArr2);
        Cfinally.a(iArr3);
        Cfinally.a(iArr4);
        Cfinally.a(iArr5);
        Cfinally.a(iArr6);
        Cfinally.a(iArr7);
        Cfinally.a(iArr8);
        Cfinally.a(iArr9);
        Cfinally.a(iArr10);
        Cfinally.a(iArr11);
        Cfinally.a(iArr12);
        Cfinally.a(iArr13);
        Cfinally.a(iArr14);
        b = null;
    }

    public static synchronized Pattern[] a() {
        if (b != null) {
            return b;
        }
        String[] strArr = a;
        b = new Pattern[strArr.length];
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < b.length; i++) {
            try {
                arrayList.add(Pattern.compile(strArr[i]));
            } catch (Throwable unused) {
            }
        }
        b = (Pattern[]) arrayList.toArray(new Pattern[0]);
        return b;
    }
}
