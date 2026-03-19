package lkxssdk.p;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public final class c {
    public final a a;

    public c(a aVar) {
        this.a = aVar;
    }

    public void a(int[] iArr, int i) throws d {
        int[] iArr2;
        b bVar;
        b bVar2;
        int i2 = i;
        b bVar3 = new b(this.a, iArr);
        int[] iArr3 = new int[i2];
        int i3 = 1;
        boolean z = true;
        for (int i4 = 0; i4 < i2; i4++) {
            a aVar = this.a;
            int iA = bVar3.a(aVar.d[aVar.j + i4]);
            iArr3[(i2 - 1) - i4] = iA;
            if (iA != 0) {
                z = false;
            }
        }
        if (z) {
            return;
        }
        b bVar4 = new b(this.a, iArr3);
        b bVarA = this.a.a(i2, 1);
        if (bVarA.a() < bVar4.a()) {
            bVarA = bVar4;
            bVar4 = bVarA;
        }
        a aVar2 = this.a;
        b bVar5 = aVar2.f;
        b bVar6 = aVar2.g;
        b bVar7 = bVar5;
        while (bVar4.a() * 2 >= i2) {
            if (bVar4.b()) {
                throw new d("r_{i-1} was zero");
            }
            b bVarA2 = this.a.f;
            int iA2 = this.a.a(bVar4.b(bVar4.a()));
            while (bVarA.a() >= bVar4.a() && !bVarA.b()) {
                int iA3 = bVarA.a() - bVar4.a();
                int iB = this.a.b(bVarA.b(bVarA.a()), iA2);
                bVarA2 = bVarA2.a(this.a.a(iA3, iB));
                if (iA3 < 0) {
                    throw new IllegalArgumentException();
                }
                if (iB == 0) {
                    bVar2 = bVar4.a.f;
                } else {
                    int length = bVar4.b.length;
                    int[] iArr4 = new int[iA3 + length];
                    for (int i5 = 0; i5 < length; i5++) {
                        iArr4[i5] = bVar4.a.b(bVar4.b[i5], iB);
                    }
                    bVar2 = new b(bVar4.a, iArr4);
                }
                bVarA = bVarA.a(bVar2);
            }
            if (!bVarA2.a.equals(bVar6.a)) {
                throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
            }
            if (bVarA2.b() || bVar6.b()) {
                bVar = bVarA2.a.f;
            } else {
                int[] iArr5 = bVarA2.b;
                int length2 = iArr5.length;
                int[] iArr6 = bVar6.b;
                int length3 = iArr6.length;
                int[] iArr7 = new int[(length2 + length3) - i3];
                for (int i6 = 0; i6 < length2; i6++) {
                    int i7 = iArr5[i6];
                    int i8 = 0;
                    while (i8 < length3) {
                        int i9 = i6 + i8;
                        iArr7[i9] = iArr7[i9] ^ bVarA2.a.b(i7, iArr6[i8]);
                        i8++;
                        iArr5 = iArr5;
                    }
                }
                bVar = new b(bVarA2.a, iArr7);
            }
            b bVarA3 = bVar.a(bVar7);
            if (bVarA.a() >= bVar4.a()) {
                throw new IllegalStateException("Division algorithm failed to reduce polynomial? r: " + bVarA + ", rLast: " + bVar4);
            }
            bVar7 = bVar6;
            i3 = 1;
            bVar6 = bVarA3;
            i2 = i;
            b bVar8 = bVarA;
            bVarA = bVar4;
            bVar4 = bVar8;
        }
        int iB2 = bVar6.b(0);
        if (iB2 == 0) {
            throw new d("sigmaTilde(0) was zero");
        }
        int iA4 = this.a.a(iB2);
        b bVarC = bVar6.c(iA4);
        b bVarC2 = bVar4.c(iA4);
        int iA5 = bVarC.a();
        if (iA5 == 1) {
            iArr2 = new int[]{bVarC.b(1)};
        } else {
            int[] iArr8 = new int[iA5];
            int i10 = 0;
            for (int i11 = 1; i11 < this.a.h && i10 < iA5; i11++) {
                if (bVarC.a(i11) == 0) {
                    iArr8[i10] = this.a.a(i11);
                    i10++;
                }
            }
            if (i10 != iA5) {
                throw new d("Error locator degree does not match number of roots");
            }
            iArr2 = iArr8;
        }
        int length4 = iArr2.length;
        int[] iArr9 = new int[length4];
        for (int i12 = 0; i12 < length4; i12++) {
            int iA6 = this.a.a(iArr2[i12]);
            int iB3 = 1;
            for (int i13 = 0; i13 < length4; i13++) {
                if (i12 != i13) {
                    int iB4 = this.a.b(iArr2[i13], iA6);
                    iB3 = this.a.b(iB3, (iB4 & 1) == 0 ? iB4 | 1 : iB4 & (-2));
                }
            }
            iArr9[i12] = this.a.b(bVarC2.a(iA6), this.a.a(iB3));
            a aVar3 = this.a;
            if (aVar3.j != 0) {
                iArr9[i12] = aVar3.b(iArr9[i12], iA6);
            }
        }
        for (int i14 = 0; i14 < iArr2.length; i14++) {
            int length5 = iArr.length - 1;
            a aVar4 = this.a;
            int i15 = iArr2[i14];
            aVar4.getClass();
            if (i15 == 0) {
                throw new IllegalArgumentException();
            }
            int i16 = length5 - aVar4.e[i15];
            if (i16 < 0) {
                throw new d("Bad error location");
            }
            iArr[i16] = iArr[i16] ^ iArr9[i14];
        }
    }
}
