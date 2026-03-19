package com.component.lottie.e;

import java.util.AbstractList;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public final class q extends AbstractList<j> implements RandomAccess {
    final j[] a;
    final int[] b;

    private q(j[] jVarArr, int[] iArr) {
        this.a = jVarArr;
        this.b = iArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x00bc, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.component.lottie.e.q a(com.component.lottie.e.j... r11) {
        /*
            Method dump skipped, instructions count: 259
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.component.lottie.e.q.a(com.component.lottie.e.j[]):com.component.lottie.e.q");
    }

    private static void a(long j, e eVar, int i, List<j> list, int i2, int i3, List<Integer> list2) {
        int iIntValue;
        int i4;
        int i5;
        int i6;
        int i7;
        e eVar2;
        if (i2 >= i3) {
            throw new AssertionError();
        }
        for (int i8 = i2; i8 < i3; i8++) {
            if (list.get(i8).k() < i) {
                throw new AssertionError();
            }
        }
        j jVar = list.get(i2);
        j jVar2 = list.get(i3 - 1);
        if (i != jVar.k()) {
            iIntValue = -1;
            i4 = i2;
        } else {
            int i9 = i2 + 1;
            i4 = i9;
            iIntValue = list2.get(i2).intValue();
            jVar = list.get(i9);
        }
        if (jVar.b(i) != jVar2.b(i)) {
            int i10 = 1;
            for (int i11 = i4 + 1; i11 < i3; i11++) {
                if (list.get(i11 - 1).b(i) != list.get(i11).b(i)) {
                    i10++;
                }
            }
            int i12 = i4;
            long jA = j + a(eVar) + 2 + (i10 * 2);
            eVar.j(i10);
            eVar.j(iIntValue);
            int i13 = i12;
            while (i13 < i3) {
                byte b = list.get(i13).b(i);
                int i14 = i12;
                if (i13 == i14 || b != list.get(i13 - 1).b(i)) {
                    eVar.j(b & 255);
                }
                i13++;
                i12 = i14;
            }
            e eVar3 = new e();
            int i15 = i12;
            while (i15 < i3) {
                byte b2 = list.get(i15).b(i);
                int i16 = i15 + 1;
                int i17 = i16;
                while (true) {
                    if (i17 < i3) {
                        if (b2 == list.get(i17).b(i)) {
                            i17++;
                        } else {
                            i6 = i17;
                            break;
                        }
                    } else {
                        i6 = i3;
                        break;
                    }
                }
                if (i16 != i6 || i + 1 != list.get(i15).k()) {
                    eVar.j((int) ((a(eVar3) + jA) * (-1)));
                    i7 = i6;
                    eVar2 = eVar3;
                    a(jA, eVar3, i + 1, list, i15, i6, list2);
                } else {
                    eVar.j(list2.get(i15).intValue());
                    i7 = i6;
                    eVar2 = eVar3;
                }
                eVar3 = eVar2;
                i15 = i7;
            }
            e eVar4 = eVar3;
            eVar.a_(eVar4, eVar4.b());
            return;
        }
        int iMin = Math.min(jVar.k(), jVar2.k());
        int i18 = 0;
        for (int i19 = i; i19 < iMin && jVar.b(i19) == jVar2.b(i19); i19++) {
            i18++;
        }
        long jA2 = 1 + j + a(eVar) + 2 + i18;
        eVar.j(-i18);
        eVar.j(iIntValue);
        int i20 = i;
        while (true) {
            i5 = i + i18;
            if (i20 >= i5) {
                break;
            }
            eVar.j(jVar.b(i20) & 255);
            i20++;
        }
        if (i4 + 1 == i3) {
            if (i5 == list.get(i4).k()) {
                eVar.j(list2.get(i4).intValue());
                return;
            }
            throw new AssertionError();
        }
        e eVar5 = new e();
        eVar.j((int) ((a(eVar5) + jA2) * (-1)));
        a(jA2, eVar5, i5, list, i4, i3, list2);
        eVar.a_(eVar5, eVar5.b());
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public j get(int i) {
        return this.a[i];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.a.length;
    }

    private static int a(e eVar) {
        return (int) (eVar.b() / 4);
    }
}
