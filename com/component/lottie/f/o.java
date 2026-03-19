package com.component.lottie.f;

import android.graphics.Color;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class o implements ap<com.component.lottie.d.b.d> {
    private int a;

    public o(int i) {
        this.a = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00d9  */
    @Override // com.component.lottie.f.ap
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.component.lottie.d.b.d b(com.component.lottie.f.a.c r12, float r13) {
        /*
            Method dump skipped, instructions count: 246
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.component.lottie.f.o.b(com.component.lottie.f.a.c, float):com.component.lottie.d.b.d");
    }

    private void a(com.component.lottie.d.b.d dVar, List<Float> list) {
        int i = this.a * 4;
        if (list.size() <= i) {
            return;
        }
        int size = (list.size() - i) / 2;
        double[] dArr = new double[size];
        double[] dArr2 = new double[size];
        int i2 = 0;
        while (i < list.size()) {
            if (i % 2 == 0) {
                dArr[i2] = list.get(i).floatValue();
            } else {
                dArr2[i2] = list.get(i).floatValue();
                i2++;
            }
            i++;
        }
        for (int i3 = 0; i3 < dVar.c(); i3++) {
            int i4 = dVar.b()[i3];
            dVar.b()[i3] = Color.argb(a(dVar.a()[i3], dArr, dArr2), Color.red(i4), Color.green(i4), Color.blue(i4));
        }
    }

    private int a(double d, double[] dArr, double[] dArr2) {
        for (int i = 1; i < dArr.length; i++) {
            int i2 = i - 1;
            double d2 = dArr[i2];
            double d3 = dArr[i];
            if (dArr[i] >= d) {
                return (int) (com.component.lottie.g.f.a(dArr2[i2], dArr2[i], com.component.lottie.g.f.b((d - d2) / (d3 - d2), 0.0d, 1.0d)) * 255.0d);
            }
        }
        return (int) (dArr2[dArr2.length - 1] * 255.0d);
    }
}
