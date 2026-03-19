package lkxssdk.n;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public final class h {
    public final int a;
    public final int b;
    public final byte[] c;
    public final int d;
    public final int e;

    public h(int i, int i2, int[] iArr) {
        this.a = i;
        this.b = i2;
        this.d = i;
        this.e = i2;
        int i3 = i * i2;
        this.c = new byte[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = iArr[i4];
            this.c[i4] = (byte) (((((i5 >> 16) & 255) + ((i5 >> 7) & 510)) + (i5 & 255)) / 4);
        }
    }

    public byte[] a() {
        int i = this.a;
        int i2 = this.b;
        int i3 = this.d;
        if (i == i3 && i2 == this.e) {
            return this.c;
        }
        int i4 = i * i2;
        byte[] bArr = new byte[i4];
        int i5 = (i3 * 0) + 0;
        if (i == i3) {
            System.arraycopy(this.c, i5, bArr, 0, i4);
            return bArr;
        }
        for (int i6 = 0; i6 < i2; i6++) {
            System.arraycopy(this.c, i5, bArr, i6 * i, i);
            i5 += this.d;
        }
        return bArr;
    }

    public final String toString() {
        int i = this.a;
        byte[] bArrA = new byte[i];
        StringBuilder sb = new StringBuilder(this.b * (i + 1));
        for (int i2 = 0; i2 < this.b; i2++) {
            bArrA = a(i2, bArrA);
            for (int i3 = 0; i3 < this.a; i3++) {
                int i4 = bArrA[i3] & 255;
                sb.append(i4 < 64 ? '#' : i4 < 128 ? '+' : i4 < 192 ? '.' : ' ');
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    public byte[] a(int i, byte[] bArr) {
        if (i < 0 || i >= this.b) {
            throw new IllegalArgumentException("Requested row is outside the image: " + i);
        }
        int i2 = this.a;
        if (bArr == null || bArr.length < i2) {
            bArr = new byte[i2];
        }
        System.arraycopy(this.c, ((i + 0) * this.d) + 0, bArr, 0, i2);
        return bArr;
    }
}
