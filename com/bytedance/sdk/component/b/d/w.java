package com.bytedance.sdk.component.b.d;

import java.util.Arrays;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
final class w extends an {
    final transient byte[][] an;
    final transient int[] h;

    w(b bVar, int i) {
        super(null);
        sy.d(bVar.hc, 0L, i);
        e eVar = bVar.d;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            if (eVar.b == eVar.hc) {
                throw new AssertionError("s.limit == s.pos");
            }
            i3 += eVar.b - eVar.hc;
            i4++;
            eVar = eVar.an;
        }
        this.an = new byte[i4][];
        this.h = new int[i4 * 2];
        e eVar2 = bVar.d;
        int i5 = 0;
        while (i2 < i) {
            this.an[i5] = eVar2.d;
            i2 += eVar2.b - eVar2.hc;
            if (i2 > i) {
                i2 = i;
            }
            int[] iArr = this.h;
            iArr[i5] = i2;
            iArr[this.an.length + i5] = eVar2.hc;
            eVar2.c = true;
            i5++;
            eVar2 = eVar2.an;
        }
    }

    @Override // com.bytedance.sdk.component.b.d.an
    public String d() {
        return tt().d();
    }

    @Override // com.bytedance.sdk.component.b.d.an
    public String hc() {
        return tt().hc();
    }

    @Override // com.bytedance.sdk.component.b.d.an
    public String u() {
        return tt().u();
    }

    @Override // com.bytedance.sdk.component.b.d.an
    public an an() {
        return tt().an();
    }

    @Override // com.bytedance.sdk.component.b.d.an
    public an b() {
        return tt().b();
    }

    @Override // com.bytedance.sdk.component.b.d.an
    public an c() {
        return tt().c();
    }

    @Override // com.bytedance.sdk.component.b.d.an
    public an d(int i, int i2) {
        return tt().d(i, i2);
    }

    @Override // com.bytedance.sdk.component.b.d.an
    public byte d(int i) {
        sy.d(this.h[this.an.length - 1], i, 1L);
        int iHc = hc(i);
        int i2 = iHc == 0 ? 0 : this.h[iHc - 1];
        int[] iArr = this.h;
        byte[][] bArr = this.an;
        return bArr[iHc][(i - i2) + iArr[bArr.length + iHc]];
    }

    private int hc(int i) {
        int iBinarySearch = Arrays.binarySearch(this.h, 0, this.an.length, i + 1);
        return iBinarySearch >= 0 ? iBinarySearch : ~iBinarySearch;
    }

    @Override // com.bytedance.sdk.component.b.d.an
    public int h() {
        return this.h[this.an.length - 1];
    }

    @Override // com.bytedance.sdk.component.b.d.an
    public byte[] gb() {
        int[] iArr = this.h;
        byte[][] bArr = this.an;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr2 = this.h;
            int i3 = iArr2[length + i];
            int i4 = iArr2[i];
            System.arraycopy(this.an[i], i3, bArr2, i2, i4 - i2);
            i++;
            i2 = i4;
        }
        return bArr2;
    }

    @Override // com.bytedance.sdk.component.b.d.an
    void d(b bVar) {
        int length = this.an.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr = this.h;
            int i3 = iArr[length + i];
            int i4 = iArr[i];
            e eVar = new e(this.an[i], i3, (i3 + i4) - i2, true, false);
            if (bVar.d == null) {
                eVar.h = eVar;
                eVar.an = eVar;
                bVar.d = eVar;
            } else {
                bVar.d.h.d(eVar);
            }
            i++;
            i2 = i4;
        }
        bVar.hc += i2;
    }

    @Override // com.bytedance.sdk.component.b.d.an
    public boolean d(int i, an anVar, int i2, int i3) {
        if (i < 0 || i > h() - i3) {
            return false;
        }
        int iHc = hc(i);
        while (i3 > 0) {
            int i4 = iHc == 0 ? 0 : this.h[iHc - 1];
            int iMin = Math.min(i3, ((this.h[iHc] - i4) + i4) - i);
            int[] iArr = this.h;
            byte[][] bArr = this.an;
            if (!anVar.d(i2, bArr[iHc], (i - i4) + iArr[bArr.length + iHc], iMin)) {
                return false;
            }
            i += iMin;
            i2 += iMin;
            i3 -= iMin;
            iHc++;
        }
        return true;
    }

    @Override // com.bytedance.sdk.component.b.d.an
    public boolean d(int i, byte[] bArr, int i2, int i3) {
        if (i < 0 || i > h() - i3 || i2 < 0 || i2 > bArr.length - i3) {
            return false;
        }
        int iHc = hc(i);
        while (i3 > 0) {
            int i4 = iHc == 0 ? 0 : this.h[iHc - 1];
            int iMin = Math.min(i3, ((this.h[iHc] - i4) + i4) - i);
            int[] iArr = this.h;
            byte[][] bArr2 = this.an;
            if (!sy.d(bArr2[iHc], (i - i4) + iArr[bArr2.length + iHc], bArr, i2, iMin)) {
                return false;
            }
            i += iMin;
            i2 += iMin;
            i3 -= iMin;
            iHc++;
        }
        return true;
    }

    private an tt() {
        return new an(gb());
    }

    @Override // com.bytedance.sdk.component.b.d.an
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof an) {
            an anVar = (an) obj;
            if (anVar.h() == h() && d(0, anVar, 0, h())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bytedance.sdk.component.b.d.an
    public int hashCode() {
        int i = this.c;
        if (i != 0) {
            return i;
        }
        int length = this.an.length;
        int i2 = 0;
        int i3 = 1;
        int i4 = 0;
        while (i2 < length) {
            byte[] bArr = this.an[i2];
            int[] iArr = this.h;
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
        this.c = i3;
        return i3;
    }

    @Override // com.bytedance.sdk.component.b.d.an
    public String toString() {
        return tt().toString();
    }
}
