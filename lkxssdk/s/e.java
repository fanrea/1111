package lkxssdk.s;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import lkxssdk.n.m;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class e {
    public static final a a = new a();
    public final lkxssdk.o.a b;
    public boolean d;
    public final m f;
    public final List<d> c = new ArrayList();
    public final int[] e = new int[5];

    public static final class a implements Comparator<d>, Serializable {
        @Override // java.util.Comparator
        public int compare(d dVar, d dVar2) {
            return Float.compare(dVar.c, dVar2.c);
        }
    }

    public e(lkxssdk.o.a aVar, m mVar) {
        this.b = aVar;
        this.f = mVar;
    }

    public static float a(int[] iArr, int i) {
        return ((i - iArr[4]) - iArr[3]) - (iArr[2] / 2.0f);
    }

    public static void a(int[] iArr) {
        iArr[0] = iArr[2];
        iArr[1] = iArr[3];
        iArr[2] = iArr[4];
        iArr[3] = 1;
        iArr[4] = 0;
    }

    public static boolean b(int[] iArr) {
        int i = 0;
        for (int i2 = 0; i2 < 5; i2++) {
            int i3 = iArr[i2];
            if (i3 == 0) {
                return false;
            }
            i += i3;
        }
        if (i < 7) {
            return false;
        }
        float f = i / 7.0f;
        float f2 = f / 2.0f;
        return Math.abs(f - ((float) iArr[0])) < f2 && Math.abs(f - ((float) iArr[1])) < f2 && Math.abs((f * 3.0f) - ((float) iArr[2])) < 3.0f * f2 && Math.abs(f - ((float) iArr[3])) < f2 && Math.abs(f - ((float) iArr[4])) < f2;
    }

    public final boolean a(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int[] iArrA = a();
        int i6 = 0;
        while (i >= i6 && i2 >= i6 && this.b.b(i2 - i6, i - i6)) {
            iArrA[2] = iArrA[2] + 1;
            i6++;
        }
        if (iArrA[2] == 0) {
            return false;
        }
        while (i >= i6 && i2 >= i6 && !this.b.b(i2 - i6, i - i6)) {
            iArrA[1] = iArrA[1] + 1;
            i6++;
        }
        if (iArrA[1] == 0) {
            return false;
        }
        while (i >= i6 && i2 >= i6 && this.b.b(i2 - i6, i - i6)) {
            iArrA[0] = iArrA[0] + 1;
            i6++;
        }
        if (iArrA[0] == 0) {
            return false;
        }
        lkxssdk.o.a aVar = this.b;
        int i7 = aVar.b;
        int i8 = aVar.a;
        int i9 = 1;
        while (true) {
            int i10 = i + i9;
            if (i10 >= i7 || (i5 = i2 + i9) >= i8 || !this.b.b(i5, i10)) {
                break;
            }
            iArrA[2] = iArrA[2] + 1;
            i9++;
        }
        while (true) {
            int i11 = i + i9;
            if (i11 >= i7 || (i4 = i2 + i9) >= i8 || this.b.b(i4, i11)) {
                break;
            }
            iArrA[3] = iArrA[3] + 1;
            i9++;
        }
        if (iArrA[3] == 0) {
            return false;
        }
        while (true) {
            int i12 = i + i9;
            if (i12 >= i7 || (i3 = i2 + i9) >= i8 || !this.b.b(i3, i12)) {
                break;
            }
            iArrA[4] = iArrA[4] + 1;
            i9++;
        }
        if (iArrA[4] == 0) {
            return false;
        }
        int i13 = 0;
        for (int i14 = 0; i14 < 5; i14++) {
            int i15 = iArrA[i14];
            if (i15 == 0) {
                return false;
            }
            i13 += i15;
        }
        if (i13 < 7) {
            return false;
        }
        float f = i13 / 7.0f;
        float f2 = f / 1.333f;
        return Math.abs(f - ((float) iArrA[0])) < f2 && Math.abs(f - ((float) iArrA[1])) < f2 && Math.abs((f * 3.0f) - ((float) iArrA[2])) < 3.0f * f2 && Math.abs(f - ((float) iArrA[3])) < f2 && Math.abs(f - ((float) iArrA[4])) < f2;
    }

    public final boolean b() {
        int size = this.c.size();
        float fAbs = 0.0f;
        float f = 0.0f;
        int i = 0;
        for (d dVar : this.c) {
            if (dVar.d >= 2) {
                i++;
                f += dVar.c;
            }
        }
        if (i < 3) {
            return false;
        }
        float f2 = f / size;
        Iterator<d> it = this.c.iterator();
        while (it.hasNext()) {
            fAbs += Math.abs(it.next().c - f2);
        }
        return fAbs <= f * 0.05f;
    }

    public final int[] a() {
        Arrays.fill(this.e, 0);
        return this.e;
    }

    /* JADX WARN: Removed duplicated region for block: B:121:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0216 A[LOOP:12: B:127:0x01b4->B:141:0x0216, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:143:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0219 A[EDGE_INSN: B:180:0x0219->B:142:0x0219 BREAK  A[LOOP:12: B:127:0x01b4->B:141:0x0216], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:181:0x01f5 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00dc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean a(int[] r18, int r19, int r20) {
        /*
            Method dump skipped, instructions count: 558
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: lkxssdk.s.e.a(int[], int, int):boolean");
    }

    public static double a(d dVar, d dVar2) {
        double d = dVar.a - dVar2.a;
        double d2 = dVar.b - dVar2.b;
        return (d * d) + (d2 * d2);
    }
}
