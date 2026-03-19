package lkxssdk.o;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public final class b {
    public final byte[] a;
    public int b;
    public int c;

    public b(byte[] bArr) {
        this.a = bArr;
    }

    public int a() {
        return ((this.a.length - this.b) * 8) - this.c;
    }

    public int a(int i) {
        if (i < 1 || i > 32 || i > a()) {
            throw new IllegalArgumentException(String.valueOf(i));
        }
        int i2 = this.c;
        int i3 = 0;
        if (i2 > 0) {
            int i4 = 8 - i2;
            int iMin = Math.min(i, i4);
            int i5 = i4 - iMin;
            byte[] bArr = this.a;
            int i6 = this.b;
            int i7 = (((255 >> (8 - iMin)) << i5) & bArr[i6]) >> i5;
            i -= iMin;
            int i8 = this.c + iMin;
            this.c = i8;
            if (i8 == 8) {
                this.c = 0;
                this.b = i6 + 1;
            }
            i3 = i7;
        }
        if (i <= 0) {
            return i3;
        }
        while (i >= 8) {
            int i9 = i3 << 8;
            byte[] bArr2 = this.a;
            int i10 = this.b;
            i3 = (bArr2[i10] & 255) | i9;
            this.b = i10 + 1;
            i -= 8;
        }
        if (i <= 0) {
            return i3;
        }
        int i11 = 8 - i;
        int i12 = (i3 << i) | ((((255 >> i11) << i11) & this.a[this.b]) >> i11);
        this.c += i;
        return i12;
    }
}
