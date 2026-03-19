package lkxssdk.p;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public final class b {
    public final a a;
    public final int[] b;

    public b(a aVar, int[] iArr) {
        if (iArr.length == 0) {
            throw new IllegalArgumentException();
        }
        this.a = aVar;
        int length = iArr.length;
        if (length <= 1 || iArr[0] != 0) {
            this.b = iArr;
            return;
        }
        int i = 1;
        while (i < length && iArr[i] == 0) {
            i++;
        }
        if (i == length) {
            this.b = new int[]{0};
            return;
        }
        int i2 = length - i;
        int[] iArr2 = new int[i2];
        this.b = iArr2;
        System.arraycopy(iArr, i, iArr2, 0, i2);
    }

    public int a() {
        return this.b.length - 1;
    }

    public int a(int i) {
        if (i == 0) {
            return b(0);
        }
        if (i != 1) {
            int[] iArr = this.b;
            int iB = iArr[0];
            int length = iArr.length;
            for (int i2 = 1; i2 < length; i2++) {
                iB = this.a.b(i, iB) ^ this.b[i2];
            }
            return iB;
        }
        int i3 = 0;
        for (int i4 : this.b) {
            a aVar = a.a;
            i3 ^= i4;
        }
        return i3;
    }

    public b a(b bVar) {
        if (!this.a.equals(bVar.a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        if (b()) {
            return bVar;
        }
        if (bVar.b()) {
            return this;
        }
        int[] iArr = this.b;
        int[] iArr2 = bVar.b;
        if (iArr.length <= iArr2.length) {
            iArr = iArr2;
            iArr2 = iArr;
        }
        int[] iArr3 = new int[iArr.length];
        int length = iArr.length - iArr2.length;
        System.arraycopy(iArr, 0, iArr3, 0, length);
        for (int i = length; i < iArr.length; i++) {
            iArr3[i] = iArr2[i - length] ^ iArr[i];
        }
        return new b(this.a, iArr3);
    }

    public int b(int i) {
        return this.b[(r0.length - 1) - i];
    }

    public boolean b() {
        return this.b[0] == 0;
    }

    public b c(int i) {
        if (i == 0) {
            return this.a.f;
        }
        if (i == 1) {
            return this;
        }
        int length = this.b.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = this.a.b(this.b[i2], i);
        }
        return new b(this.a, iArr);
    }

    public String toString() {
        char c;
        if (b()) {
            return "0";
        }
        StringBuilder sb = new StringBuilder(a() * 8);
        int iA = a();
        while (iA >= 0) {
            int iB = b(iA);
            if (iB != 0) {
                if (iB < 0) {
                    sb.append(iA == a() ? "-" : " - ");
                    iB = -iB;
                } else if (sb.length() > 0) {
                    sb.append(" + ");
                }
                if (iA == 0 || iB != 1) {
                    a aVar = this.a;
                    aVar.getClass();
                    if (iB == 0) {
                        throw new IllegalArgumentException();
                    }
                    int i = aVar.e[iB];
                    if (i == 0) {
                        c = '1';
                    } else if (i == 1) {
                        c = 'a';
                    } else {
                        sb.append("a^");
                        sb.append(i);
                    }
                    sb.append(c);
                }
                if (iA != 0) {
                    if (iA == 1) {
                        sb.append('x');
                    } else {
                        sb.append("x^");
                        sb.append(iA);
                    }
                }
            }
            iA--;
        }
        return sb.toString();
    }
}
