package com.bytedance.sdk.component.hc.d.hc;

import java.util.Arrays;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
final class gb extends c {
    final transient int[] gb;
    final transient byte[][] h;

    gb(d dVar, int i) {
        super(null);
        tc.d(dVar.hc, 0L, i);
        an anVar = dVar.d;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            if (anVar.b == anVar.hc) {
                throw new AssertionError("s.limit == s.pos");
            }
            i3 += anVar.b - anVar.hc;
            i4++;
            anVar = anVar.an;
        }
        this.h = new byte[i4][];
        this.gb = new int[i4 * 2];
        an anVar2 = dVar.d;
        int i5 = 0;
        while (i2 < i) {
            this.h[i5] = anVar2.d;
            i2 += anVar2.b - anVar2.hc;
            if (i2 > i) {
                i2 = i;
            }
            int[] iArr = this.gb;
            iArr[i5] = i2;
            iArr[this.h.length + i5] = anVar2.hc;
            anVar2.c = true;
            i5++;
            anVar2 = anVar2.an;
        }
    }

    @Override // com.bytedance.sdk.component.hc.d.hc.c
    public String d() {
        return u().d();
    }

    @Override // com.bytedance.sdk.component.hc.d.hc.c
    public String hc() {
        return u().hc();
    }

    @Override // com.bytedance.sdk.component.hc.d.hc.c
    public c d(int i, int i2) {
        return u().d(i, i2);
    }

    @Override // com.bytedance.sdk.component.hc.d.hc.c
    public byte d(int i) {
        tc.d(this.gb[this.h.length - 1], i, 1L);
        int iHc = hc(i);
        int i2 = iHc == 0 ? 0 : this.gb[iHc - 1];
        int[] iArr = this.gb;
        byte[][] bArr = this.h;
        return bArr[iHc][(i - i2) + iArr[bArr.length + iHc]];
    }

    private int hc(int i) {
        int iBinarySearch = Arrays.binarySearch(this.gb, 0, this.h.length, i + 1);
        return iBinarySearch >= 0 ? iBinarySearch : ~iBinarySearch;
    }

    @Override // com.bytedance.sdk.component.hc.d.hc.c
    public int b() {
        return this.gb[this.h.length - 1];
    }

    @Override // com.bytedance.sdk.component.hc.d.hc.c
    public byte[] c() {
        int[] iArr = this.gb;
        byte[][] bArr = this.h;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr2 = this.gb;
            int i3 = iArr2[length + i];
            int i4 = iArr2[i];
            System.arraycopy(this.h[i], i3, bArr2, i2, i4 - i2);
            i++;
            i2 = i4;
        }
        return bArr2;
    }

    @Override // com.bytedance.sdk.component.hc.d.hc.c
    public boolean d(int i, c cVar, int i2, int i3) {
        if (i < 0 || i > b() - i3) {
            return false;
        }
        int iHc = hc(i);
        while (i3 > 0) {
            int i4 = iHc == 0 ? 0 : this.gb[iHc - 1];
            int iMin = Math.min(i3, ((this.gb[iHc] - i4) + i4) - i);
            int[] iArr = this.gb;
            byte[][] bArr = this.h;
            if (!cVar.d(i2, bArr[iHc], (i - i4) + iArr[bArr.length + iHc], iMin)) {
                return false;
            }
            i += iMin;
            i2 += iMin;
            i3 -= iMin;
            iHc++;
        }
        return true;
    }

    @Override // com.bytedance.sdk.component.hc.d.hc.c
    public boolean d(int i, byte[] bArr, int i2, int i3) {
        if (i < 0 || i > b() - i3 || i2 < 0 || i2 > bArr.length - i3) {
            return false;
        }
        int iHc = hc(i);
        while (i3 > 0) {
            int i4 = iHc == 0 ? 0 : this.gb[iHc - 1];
            int iMin = Math.min(i3, ((this.gb[iHc] - i4) + i4) - i);
            int[] iArr = this.gb;
            byte[][] bArr2 = this.h;
            if (!tc.d(bArr2[iHc], (i - i4) + iArr[bArr2.length + iHc], bArr, i2, iMin)) {
                return false;
            }
            i += iMin;
            i2 += iMin;
            i3 -= iMin;
            iHc++;
        }
        return true;
    }

    private c u() {
        return new c(c());
    }

    @Override // com.bytedance.sdk.component.hc.d.hc.c
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            if (cVar.b() == b() && d(0, cVar, 0, b())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bytedance.sdk.component.hc.d.hc.c
    public int hashCode() {
        int i = this.u;
        if (i != 0) {
            return i;
        }
        int length = this.h.length;
        int i2 = 0;
        int i3 = 1;
        int i4 = 0;
        while (i2 < length) {
            byte[] bArr = this.h[i2];
            int[] iArr = this.gb;
            int i5 = iArr[length + i2];
            int i6 = iArr[i2];
            int i7 = (i6 - i4) + i5;
            while (i5 < i7) {
                i3 = (i3 * 31) + bArr[i5];
                i5++;
            }
            i2++;
            i4 = i6;
        }
        this.u = i3;
        return i3;
    }

    @Override // com.bytedance.sdk.component.hc.d.hc.c
    public String toString() {
        return u().toString();
    }
}
