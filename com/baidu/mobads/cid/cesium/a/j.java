package com.baidu.mobads.cid.cesium.a;

import com.netease.htprotect.p010Ooo.p014o0o0.p015O8oO888.C00oOOo;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class j {
    private final byte[] a;
    private final int[] b;
    private final byte[] c;
    private final int d;
    private int e;
    private int f;

    protected j() {
        this(0);
    }

    protected j(int i) {
        this.a = new byte[1];
        this.b = new int[4];
        this.c = new byte[16];
        this.d = i;
        b();
    }

    private static int a(byte[] bArr, int i) {
        return (int) (b(bArr, i, 4) & C00oOOo.f362O8oO888);
    }

    private static long b(byte[] bArr, int i, int i2) {
        if (i2 > 8) {
            throw new IllegalArgumentException("can't read more than eight bytes into a long value");
        }
        long j = 0;
        for (int i3 = 0; i3 < i2; i3++) {
            j |= (bArr[i + i3] & 255) << (i3 * 8);
        }
        return j;
    }

    private void b() {
        this.b[0] = (this.d - 1640531535) - 2048144777;
        this.b[1] = this.d - 2048144777;
        this.b[2] = this.d;
        this.b[3] = this.d - (-1640531535);
    }

    private void b(byte[] bArr, int i) {
        int i2 = this.b[0];
        int i3 = this.b[1];
        int i4 = this.b[2];
        int i5 = this.b[3];
        int iRotateLeft = Integer.rotateLeft(i2 + (a(bArr, i) * (-2048144777)), 13) * (-1640531535);
        int iRotateLeft2 = Integer.rotateLeft(i3 + (a(bArr, i + 4) * (-2048144777)), 13) * (-1640531535);
        int iRotateLeft3 = Integer.rotateLeft(i4 + (a(bArr, i + 8) * (-2048144777)), 13) * (-1640531535);
        int iRotateLeft4 = Integer.rotateLeft(i5 + (a(bArr, i + 12) * (-2048144777)), 13) * (-1640531535);
        this.b[0] = iRotateLeft;
        this.b[1] = iRotateLeft2;
        this.b[2] = iRotateLeft3;
        this.b[3] = iRotateLeft4;
        this.f = 0;
    }

    protected long a() {
        int i = 0;
        int iRotateLeft = (this.e > 16 ? Integer.rotateLeft(this.b[0], 1) + Integer.rotateLeft(this.b[1], 7) + Integer.rotateLeft(this.b[2], 12) + Integer.rotateLeft(this.b[3], 18) : this.b[2] + 374761393) + this.e;
        int i2 = this.f - 4;
        while (i <= i2) {
            iRotateLeft = Integer.rotateLeft(iRotateLeft + (a(this.c, i) * (-1028477379)), 17) * 668265263;
            i += 4;
        }
        while (i < this.f) {
            iRotateLeft = Integer.rotateLeft(iRotateLeft + ((this.c[i] & 255) * 374761393), 11) * (-1640531535);
            i++;
        }
        int i3 = (iRotateLeft ^ (iRotateLeft >>> 15)) * (-2048144777);
        int i4 = (i3 ^ (i3 >>> 13)) * (-1028477379);
        return (i4 ^ (i4 >>> 16)) & C00oOOo.f362O8oO888;
    }

    protected void a(byte[] bArr, int i, int i2) {
        if (i2 <= 0) {
            return;
        }
        this.e += i2;
        int i3 = i + i2;
        if (this.f + i2 < 16) {
            System.arraycopy(bArr, i, this.c, this.f, i2);
            this.f += i2;
            return;
        }
        if (this.f > 0) {
            int i4 = 16 - this.f;
            System.arraycopy(bArr, i, this.c, this.f, i4);
            b(this.c, 0);
            i += i4;
        }
        int i5 = i3 - 16;
        while (i <= i5) {
            b(bArr, i);
            i += 16;
        }
        if (i < i3) {
            this.f = i3 - i;
            System.arraycopy(bArr, i, this.c, 0, this.f);
        }
    }
}
