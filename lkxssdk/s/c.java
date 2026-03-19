package lkxssdk.s;

import lkxssdk.n.g;
import lkxssdk.n.l;
import lkxssdk.n.m;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class c {
    public final lkxssdk.o.a a;
    public m b;

    public c(lkxssdk.o.a aVar) {
        this.a = aVar;
    }

    public final float a(l lVar, l lVar2) {
        float fB = b((int) lVar.a, (int) lVar.b, (int) lVar2.a, (int) lVar2.b);
        float fB2 = b((int) lVar2.a, (int) lVar2.b, (int) lVar.a, (int) lVar.b);
        return Float.isNaN(fB) ? fB2 / 7.0f : Float.isNaN(fB2) ? fB / 7.0f : (fB + fB2) / 14.0f;
    }

    public final float b(int i, int i2, int i3, int i4) {
        float f;
        float f2;
        float fA = a(i, i2, i3, i4);
        int i5 = i - (i3 - i);
        int i6 = 0;
        if (i5 < 0) {
            f = i / (i - i5);
            i5 = 0;
        } else {
            int i7 = this.a.a;
            if (i5 >= i7) {
                int i8 = i7 - 1;
                f = (i8 - i) / (i5 - i);
                i5 = i8;
            } else {
                f = 1.0f;
            }
        }
        float f3 = i2;
        int i9 = (int) (f3 - ((i4 - i2) * f));
        if (i9 < 0) {
            f2 = f3 / (i2 - i9);
        } else {
            int i10 = this.a.b;
            if (i9 >= i10) {
                i6 = i10 - 1;
                f2 = (i6 - i2) / (i9 - i2);
            } else {
                i6 = i9;
                f2 = 1.0f;
            }
        }
        return (fA + a(i, i2, (int) (i + ((i5 - i) * f2)), i6)) - 1.0f;
    }

    public final a a(float f, int i, int i2, float f2) throws g {
        a aVarA;
        a aVarA2;
        int i3 = (int) (f2 * f);
        int iMax = Math.max(0, i - i3);
        int iMin = Math.min(this.a.a - 1, i + i3) - iMax;
        float f3 = 3.0f * f;
        if (iMin >= f3) {
            int iMax2 = Math.max(0, i2 - i3);
            int iMin2 = Math.min(this.a.b - 1, i2 + i3) - iMax2;
            if (iMin2 >= f3) {
                b bVar = new b(this.a, iMax, iMax2, iMin, iMin2, f, this.b);
                int i4 = bVar.c;
                int i5 = bVar.f;
                int i6 = bVar.e + i4;
                int i7 = bVar.d + (i5 / 2);
                int[] iArr = new int[3];
                for (int i8 = 0; i8 < i5; i8++) {
                    int i9 = ((i8 & 1) == 0 ? (i8 + 1) / 2 : -((i8 + 1) / 2)) + i7;
                    iArr[0] = 0;
                    iArr[1] = 0;
                    iArr[2] = 0;
                    int i10 = i4;
                    while (i10 < i6 && !bVar.a.b(i10, i9)) {
                        i10++;
                    }
                    int i11 = 0;
                    while (i10 < i6) {
                        if (!bVar.a.b(i10, i9)) {
                            if (i11 == 1) {
                                i11++;
                            }
                            iArr[i11] = iArr[i11] + 1;
                        } else if (i11 == 1) {
                            iArr[1] = iArr[1] + 1;
                        } else if (i11 != 2) {
                            i11++;
                            iArr[i11] = iArr[i11] + 1;
                        } else {
                            if (bVar.a(iArr) && (aVarA2 = bVar.a(iArr, i9, i10)) != null) {
                                return aVarA2;
                            }
                            iArr[0] = iArr[2];
                            iArr[1] = 1;
                            iArr[2] = 0;
                            i11 = 1;
                        }
                        i10++;
                    }
                    if (bVar.a(iArr) && (aVarA = bVar.a(iArr, i9, i6)) != null) {
                        return aVarA;
                    }
                }
                if (bVar.b.isEmpty()) {
                    throw g.c;
                }
                return bVar.b.get(0);
            }
            throw g.c;
        }
        throw g.c;
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x0094, code lost:
    
        if (r2 != r0) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0096, code lost:
    
        r0 = r20 - r1;
        r4 = r19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x009d, code lost:
    
        return Float.NaN;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final float a(int r18, int r19, int r20, int r21) {
        /*
            r17 = this;
            int r0 = r21 - r19
            int r0 = java.lang.Math.abs(r0)
            int r1 = r20 - r18
            int r1 = java.lang.Math.abs(r1)
            r3 = 1
            if (r0 <= r1) goto L11
            r0 = r3
            goto L12
        L11:
            r0 = 0
        L12:
            if (r0 == 0) goto L1d
            r4 = r18
            r1 = r19
            r6 = r20
            r5 = r21
            goto L25
        L1d:
            r1 = r18
            r4 = r19
            r5 = r20
            r6 = r21
        L25:
            int r7 = r5 - r1
            int r7 = java.lang.Math.abs(r7)
            int r8 = r6 - r4
            int r9 = java.lang.Math.abs(r8)
            int r10 = -r7
            r11 = 2
            int r10 = r10 / r11
            r12 = -1
            if (r1 >= r5) goto L39
            r13 = r3
            goto L3a
        L39:
            r13 = r12
        L3a:
            if (r4 >= r6) goto L3d
            r12 = r3
        L3d:
            int r5 = r5 + r13
            r14 = r1
            r15 = r4
            r2 = 0
        L41:
            if (r14 == r5) goto L8d
            if (r0 == 0) goto L47
            r11 = r15
            goto L48
        L47:
            r11 = r14
        L48:
            r16 = r0
            if (r0 == 0) goto L4e
            r0 = r14
            goto L4f
        L4e:
            r0 = r15
        L4f:
            if (r2 != r3) goto L59
            r20 = r5
            r19 = r8
            r8 = r3
            r3 = r17
            goto L60
        L59:
            r3 = r17
            r20 = r5
            r19 = r8
            r8 = 0
        L60:
            lkxssdk.o.a r5 = r3.a
            boolean r0 = r5.b(r11, r0)
            if (r8 != r0) goto L7a
            r0 = 2
            if (r2 != r0) goto L78
            int r14 = r14 - r1
            double r0 = (double) r14
            int r15 = r15 - r4
            double r4 = (double) r15
        L6f:
            double r0 = r0 * r0
            double r4 = r4 * r4
            double r0 = r0 + r4
            double r0 = java.lang.Math.sqrt(r0)
            float r0 = (float) r0
            return r0
        L78:
            int r2 = r2 + 1
        L7a:
            int r10 = r10 + r9
            if (r10 <= 0) goto L83
            if (r15 != r6) goto L81
            r0 = 2
            goto L94
        L81:
            int r15 = r15 + r12
            int r10 = r10 - r7
        L83:
            int r14 = r14 + r13
            r8 = r19
            r5 = r20
            r0 = r16
            r3 = 1
            r11 = 2
            goto L41
        L8d:
            r3 = r17
            r20 = r5
            r19 = r8
            r0 = r11
        L94:
            if (r2 != r0) goto L9d
            int r5 = r20 - r1
            double r0 = (double) r5
            r6 = r19
            double r4 = (double) r6
            goto L6f
        L9d:
            r0 = 2143289344(0x7fc00000, float:NaN)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: lkxssdk.s.c.a(int, int, int, int):float");
    }
}
