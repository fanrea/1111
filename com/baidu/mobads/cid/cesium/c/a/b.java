package com.baidu.mobads.cid.cesium.c.a;

import java.lang.reflect.Array;
import java.security.InvalidKeyException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public final class b implements a {
    private static int[] g;
    private static int[] h;
    private static final byte[] i = new byte[256];
    private static final byte[] j = new byte[256];
    private static final int[] k = new int[256];
    private static final int[] l = new int[256];
    private static final int[] m = new int[256];
    private static final int[] n = new int[256];
    private static final int[] o = new int[256];
    private static final int[] p = new int[256];
    private static final int[] q = new int[256];
    private static final int[] r = new int[256];
    private static final int[] s = new int[256];
    private static final int[] t = new int[256];
    private static final int[] u = new int[256];
    private static final int[] v = new int[256];
    private static final byte[] w = new byte[30];
    private boolean b = false;
    private boolean c = false;
    private Object[] d = null;
    private int[] e = null;
    private int f = 0;

    static {
        g = new int[256];
        h = new int[256];
        g[0] = 1;
        for (int i2 = 1; i2 < 256; i2++) {
            int i3 = i2 - 1;
            int i4 = (g[i3] << 1) ^ g[i3];
            if ((i4 & 256) != 0) {
                i4 ^= 283;
            }
            g[i2] = i4;
        }
        for (int i5 = 1; i5 < 255; i5++) {
            h[g[i5]] = i5;
        }
        byte[][] bArr = {new byte[]{1, 1, 1, 1, 1, 0, 0, 0}, new byte[]{0, 1, 1, 1, 1, 1, 0, 0}, new byte[]{0, 0, 1, 1, 1, 1, 1, 0}, new byte[]{0, 0, 0, 1, 1, 1, 1, 1}, new byte[]{1, 0, 0, 0, 1, 1, 1, 1}, new byte[]{1, 1, 0, 0, 0, 1, 1, 1}, new byte[]{1, 1, 1, 0, 0, 0, 1, 1}, new byte[]{1, 1, 1, 1, 0, 0, 0, 1}};
        byte[] bArr2 = {0, 1, 1, 0, 0, 0, 1, 1};
        byte[][] bArr3 = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, 256, 8);
        bArr3[1][7] = 1;
        for (int i6 = 2; i6 < 256; i6++) {
            int i7 = g[255 - h[i6]];
            for (int i8 = 0; i8 < 8; i8++) {
                bArr3[i6][i8] = (byte) ((i7 >>> (7 - i8)) & 1);
            }
        }
        byte[][] bArr4 = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, 256, 8);
        for (int i9 = 0; i9 < 256; i9++) {
            for (int i10 = 0; i10 < 8; i10++) {
                bArr4[i9][i10] = bArr2[i10];
                for (int i11 = 0; i11 < 8; i11++) {
                    byte[] bArr5 = bArr4[i9];
                    bArr5[i10] = (byte) (bArr5[i10] ^ (bArr[i10][i11] * bArr3[i9][i11]));
                }
            }
        }
        for (int i12 = 0; i12 < 256; i12++) {
            i[i12] = (byte) (bArr4[i12][0] << 7);
            for (int i13 = 1; i13 < 8; i13++) {
                byte[] bArr6 = i;
                bArr6[i12] = (byte) (bArr6[i12] ^ (bArr4[i12][i13] << (7 - i13)));
            }
            j[i[i12] & 255] = (byte) i12;
        }
        byte[][] bArr7 = {new byte[]{2, 1, 1, 3}, new byte[]{3, 2, 1, 1}, new byte[]{1, 3, 2, 1}, new byte[]{1, 1, 3, 2}};
        byte[][] bArr8 = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, 4, 8);
        for (int i14 = 0; i14 < 4; i14++) {
            for (int i15 = 0; i15 < 4; i15++) {
                bArr8[i14][i15] = bArr7[i14][i15];
            }
            bArr8[i14][i14 + 4] = 1;
        }
        byte[][] bArr9 = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, 4, 4);
        for (int i16 = 0; i16 < 4; i16++) {
            byte b = bArr8[i16][i16];
            if (b == 0) {
                int i17 = i16 + 1;
                while (bArr8[i17][i16] == 0 && i17 < 4) {
                    i17++;
                }
                if (i17 == 4) {
                    throw new RuntimeException("G matrix is not invertible");
                }
                for (int i18 = 0; i18 < 8; i18++) {
                    byte b2 = bArr8[i16][i18];
                    bArr8[i16][i18] = bArr8[i17][i18];
                    bArr8[i17][i18] = b2;
                }
                b = bArr8[i16][i16];
            }
            for (int i19 = 0; i19 < 8; i19++) {
                if (bArr8[i16][i19] != 0) {
                    bArr8[i16][i19] = (byte) g[((h[bArr8[i16][i19] & 255] + 255) - h[b & 255]) % 255];
                }
            }
            for (int i20 = 0; i20 < 4; i20++) {
                if (i16 != i20) {
                    for (int i21 = i16 + 1; i21 < 8; i21++) {
                        byte[] bArr10 = bArr8[i20];
                        bArr10[i21] = (byte) (bArr10[i21] ^ a(bArr8[i16][i21], bArr8[i20][i16]));
                    }
                    bArr8[i20][i16] = 0;
                }
            }
        }
        for (int i22 = 0; i22 < 4; i22++) {
            for (int i23 = 0; i23 < 4; i23++) {
                bArr9[i22][i23] = bArr8[i22][i23 + 4];
            }
        }
        for (int i24 = 0; i24 < 256; i24++) {
            byte b3 = i[i24];
            k[i24] = a(b3, bArr7[0]);
            l[i24] = a(b3, bArr7[1]);
            m[i24] = a(b3, bArr7[2]);
            n[i24] = a(b3, bArr7[3]);
            byte b4 = j[i24];
            o[i24] = a(b4, bArr9[0]);
            p[i24] = a(b4, bArr9[1]);
            q[i24] = a(b4, bArr9[2]);
            r[i24] = a(b4, bArr9[3]);
            s[i24] = a(i24, bArr9[0]);
            t[i24] = a(i24, bArr9[1]);
            u[i24] = a(i24, bArr9[2]);
            v[i24] = a(i24, bArr9[3]);
        }
        int iA = 1;
        w[0] = 1;
        for (int i25 = 1; i25 < 30; i25++) {
            iA = a(2, iA);
            w[i25] = (byte) iA;
        }
        h = null;
        g = null;
    }

    private static final int a(int i2, int i3) {
        if (i2 == 0 || i3 == 0) {
            return 0;
        }
        return g[(h[i2 & 255] + h[i3 & 255]) % 255];
    }

    private static final int a(int i2, byte[] bArr) {
        if (i2 == 0) {
            return 0;
        }
        int i3 = h[i2 & 255];
        return ((bArr[0] != 0 ? g[(h[bArr[0] & 255] + i3) % 255] & 255 : 0) << 24) | ((bArr[1] != 0 ? g[(h[bArr[1] & 255] + i3) % 255] & 255 : 0) << 16) | ((bArr[2] != 0 ? g[(h[bArr[2] & 255] + i3) % 255] & 255 : 0) << 8) | (bArr[3] != 0 ? g[(i3 + h[bArr[3] & 255]) % 255] & 255 : 0);
    }

    private void a(boolean z) {
        int[][] iArr = (int[][]) this.d[z ? 1 : 0];
        int length = iArr.length;
        this.e = new int[length * 4];
        for (int i2 = 0; i2 < length; i2++) {
            for (int i3 = 0; i3 < 4; i3++) {
                this.e[(i2 * 4) + i3] = iArr[i2][i3];
            }
        }
        if (z) {
            int i4 = this.e[this.e.length - 4];
            int i5 = this.e[this.e.length - 3];
            int i6 = this.e[this.e.length - 2];
            int i7 = this.e[this.e.length - 1];
            for (int length2 = this.e.length - 1; length2 > 3; length2--) {
                this.e[length2] = this.e[length2 - 4];
            }
            this.e[0] = i4;
            this.e[1] = i5;
            this.e[2] = i6;
            this.e[3] = i7;
        }
        this.b = length >= 13;
        this.c = length == 15;
        this.f = (length - 1) * 4;
    }

    static final boolean a(int i2) {
        for (int i3 = 0; i3 < a.length; i3++) {
            if (i2 == a[i3]) {
                return true;
            }
        }
        return false;
    }

    private static Object[] a(byte[] bArr) throws InvalidKeyException {
        int i2;
        if (bArr == null) {
            throw new InvalidKeyException("Empty key");
        }
        if (!a(bArr.length)) {
            throw new InvalidKeyException("Invalid AES key length: " + bArr.length + " bytes");
        }
        int iB = b(bArr.length);
        int i3 = iB + 1;
        int i4 = i3 * 4;
        char c = 0;
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, i3, 4);
        int[][] iArr2 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, i3, 4);
        int length = bArr.length / 4;
        int[] iArr3 = new int[length];
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            iArr3[i5] = ((bArr[i6 + 2] & 255) << 8) | (bArr[i6] << 24) | ((bArr[i6 + 1] & 255) << 16) | (bArr[i6 + 3] & 255);
            i5++;
            i6 += 4;
        }
        int i7 = 0;
        int i8 = 0;
        while (i7 < length && i8 < i4) {
            int i9 = i8 / 4;
            int i10 = i8 % 4;
            iArr[i9][i10] = iArr3[i7];
            iArr2[iB - i9][i10] = iArr3[i7];
            i7++;
            i8++;
        }
        int i11 = 0;
        while (i8 < i4) {
            int i12 = iArr3[length - 1];
            int i13 = iArr3[c];
            int i14 = (((i[(i12 >>> 16) & 255] << 24) ^ ((i[(i12 >>> 8) & 255] & 255) << 16)) ^ ((i[i12 & 255] & 255) << 8)) ^ (i[i12 >>> 24] & 255);
            int i15 = i11 + 1;
            iArr3[c] = ((w[i11] << 24) ^ i14) ^ i13;
            int i16 = 1;
            int i17 = 0;
            if (length != 8) {
                while (i16 < length) {
                    iArr3[i16] = iArr3[i16] ^ iArr3[i17];
                    i16++;
                    i17++;
                }
            } else {
                while (true) {
                    i2 = length / 2;
                    if (i16 >= i2) {
                        break;
                    }
                    iArr3[i16] = iArr3[i16] ^ iArr3[i17];
                    i16++;
                    i17++;
                }
                int i18 = iArr3[i2 - 1];
                iArr3[i2] = ((i[i18 >>> 24] << 24) ^ ((((i[(i18 >>> 8) & 255] & 255) << 8) ^ (i[i18 & 255] & 255)) ^ ((i[(i18 >>> 16) & 255] & 255) << 16))) ^ iArr3[i2];
                int i19 = i2 + 1;
                while (i19 < length) {
                    iArr3[i19] = iArr3[i19] ^ iArr3[i2];
                    i19++;
                    i2++;
                }
            }
            int i20 = 0;
            while (i20 < length && i8 < i4) {
                int i21 = i8 / 4;
                int i22 = i8 % 4;
                iArr[i21][i22] = iArr3[i20];
                iArr2[iB - i21][i22] = iArr3[i20];
                i20++;
                i8++;
            }
            i11 = i15;
            c = 0;
        }
        for (int i23 = 1; i23 < iB; i23++) {
            for (int i24 = 0; i24 < 4; i24++) {
                int i25 = iArr2[i23][i24];
                iArr2[i23][i24] = v[i25 & 255] ^ ((s[(i25 >>> 24) & 255] ^ t[(i25 >>> 16) & 255]) ^ u[(i25 >>> 8) & 255]);
            }
        }
        return new Object[]{iArr, iArr2};
    }

    private static int b(int i2) {
        return (i2 >> 2) + 6;
    }

    int a() {
        return 16;
    }

    void a(boolean z, String str, byte[] bArr) throws InvalidKeyException {
        if (!a(bArr.length)) {
            throw new InvalidKeyException("Invalid AES key length: " + bArr.length + " bytes");
        }
        this.d = a(bArr);
        a(z);
    }

    void a(byte[] bArr, int i2, byte[] bArr2, int i3) {
        int i4 = i2 + 1;
        int i5 = i4 + 1;
        int i6 = (bArr[i2] << 24) | ((bArr[i4] & 255) << 16);
        int i7 = i5 + 1;
        int i8 = i6 | ((bArr[i5] & 255) << 8);
        int i9 = i7 + 1;
        int i10 = (i8 | (bArr[i7] & 255)) ^ this.e[0];
        int i11 = i9 + 1;
        int i12 = i11 + 1;
        int i13 = ((bArr[i11] & 255) << 16) | (bArr[i9] << 24);
        int i14 = i12 + 1;
        int i15 = i13 | ((bArr[i12] & 255) << 8);
        int i16 = i14 + 1;
        int i17 = (i15 | (bArr[i14] & 255)) ^ this.e[1];
        int i18 = i16 + 1;
        int i19 = i18 + 1;
        int i20 = ((bArr[i18] & 255) << 16) | (bArr[i16] << 24);
        int i21 = i19 + 1;
        int i22 = i20 | ((bArr[i19] & 255) << 8);
        int i23 = i21 + 1;
        int i24 = (i22 | (bArr[i21] & 255)) ^ this.e[2];
        int i25 = i23 + 1;
        int i26 = i25 + 1;
        int i27 = ((bArr[i25] & 255) << 16) | (bArr[i23] << 24);
        int i28 = i27 | ((bArr[i26] & 255) << 8);
        int i29 = ((bArr[i26 + 1] & 255) | i28) ^ this.e[3];
        int i30 = 4;
        while (i30 < this.f) {
            int i31 = i30 + 1;
            int i32 = this.e[i30] ^ (((k[i10 >>> 24] ^ l[(i17 >>> 16) & 255]) ^ m[(i24 >>> 8) & 255]) ^ n[i29 & 255]);
            int i33 = i31 + 1;
            int i34 = (((k[i17 >>> 24] ^ l[(i24 >>> 16) & 255]) ^ m[(i29 >>> 8) & 255]) ^ n[i10 & 255]) ^ this.e[i31];
            int i35 = i33 + 1;
            int i36 = (((k[i24 >>> 24] ^ l[(i29 >>> 16) & 255]) ^ m[(i10 >>> 8) & 255]) ^ n[i17 & 255]) ^ this.e[i33];
            i29 = (((k[i29 >>> 24] ^ l[(i10 >>> 16) & 255]) ^ m[(i17 >>> 8) & 255]) ^ n[i24 & 255]) ^ this.e[i35];
            i10 = i32;
            i24 = i36;
            i30 = i35 + 1;
            i17 = i34;
        }
        int i37 = i30 + 1;
        int i38 = this.e[i30];
        int i39 = i3 + 1;
        bArr2[i3] = (byte) (i[i10 >>> 24] ^ (i38 >>> 24));
        int i40 = i39 + 1;
        bArr2[i39] = (byte) (i[(i17 >>> 16) & 255] ^ (i38 >>> 16));
        int i41 = i40 + 1;
        bArr2[i40] = (byte) (i[(i24 >>> 8) & 255] ^ (i38 >>> 8));
        int i42 = i41 + 1;
        bArr2[i41] = (byte) (i38 ^ i[i29 & 255]);
        int i43 = i37 + 1;
        int i44 = this.e[i37];
        int i45 = i42 + 1;
        bArr2[i42] = (byte) (i[i17 >>> 24] ^ (i44 >>> 24));
        int i46 = i45 + 1;
        bArr2[i45] = (byte) (i[(i24 >>> 16) & 255] ^ (i44 >>> 16));
        int i47 = i46 + 1;
        bArr2[i46] = (byte) (i[(i29 >>> 8) & 255] ^ (i44 >>> 8));
        int i48 = i47 + 1;
        bArr2[i47] = (byte) (i44 ^ i[i10 & 255]);
        int i49 = i43 + 1;
        int i50 = this.e[i43];
        int i51 = i48 + 1;
        bArr2[i48] = (byte) (i[i24 >>> 24] ^ (i50 >>> 24));
        int i52 = i51 + 1;
        bArr2[i51] = (byte) (i[(i29 >>> 16) & 255] ^ (i50 >>> 16));
        int i53 = i52 + 1;
        bArr2[i52] = (byte) (i[(i10 >>> 8) & 255] ^ (i50 >>> 8));
        int i54 = i53 + 1;
        bArr2[i53] = (byte) (i50 ^ i[i17 & 255]);
        int i55 = this.e[i49];
        int i56 = i54 + 1;
        bArr2[i54] = (byte) (i[i29 >>> 24] ^ (i55 >>> 24));
        int i57 = i56 + 1;
        bArr2[i56] = (byte) (i[(i10 >>> 16) & 255] ^ (i55 >>> 16));
        bArr2[i57] = (byte) (i[(i17 >>> 8) & 255] ^ (i55 >>> 8));
        bArr2[i57 + 1] = (byte) (i[i24 & 255] ^ i55);
    }

    void b(byte[] bArr, int i2, byte[] bArr2, int i3) {
        int i4;
        int i5 = i2 + 1;
        int i6 = i5 + 1;
        int i7 = (bArr[i2] << 24) | ((bArr[i5] & 255) << 16);
        int i8 = i6 + 1;
        int i9 = i7 | ((bArr[i6] & 255) << 8);
        int i10 = i8 + 1;
        int i11 = (i9 | (bArr[i8] & 255)) ^ this.e[4];
        int i12 = i10 + 1;
        int i13 = i12 + 1;
        int i14 = ((bArr[i12] & 255) << 16) | (bArr[i10] << 24);
        int i15 = i13 + 1;
        int i16 = i14 | ((bArr[i13] & 255) << 8);
        int i17 = i15 + 1;
        int i18 = (i16 | (bArr[i15] & 255)) ^ this.e[5];
        int i19 = i17 + 1;
        int i20 = i19 + 1;
        int i21 = ((bArr[i19] & 255) << 16) | (bArr[i17] << 24);
        int i22 = i20 + 1;
        int i23 = i21 | ((bArr[i20] & 255) << 8);
        int i24 = i22 + 1;
        int i25 = (i23 | (bArr[i22] & 255)) ^ this.e[6];
        int i26 = i24 + 1;
        int i27 = i26 + 1;
        int i28 = ((bArr[i26] & 255) << 16) | (bArr[i24] << 24);
        int i29 = i28 | ((bArr[i27] & 255) << 8);
        int i30 = ((bArr[i27 + 1] & 255) | i29) ^ this.e[7];
        if (this.b) {
            int i31 = (((o[i11 >>> 24] ^ p[(i30 >>> 16) & 255]) ^ q[(i25 >>> 8) & 255]) ^ r[i18 & 255]) ^ this.e[8];
            int i32 = (((o[i18 >>> 24] ^ p[(i11 >>> 16) & 255]) ^ q[(i30 >>> 8) & 255]) ^ r[i25 & 255]) ^ this.e[9];
            int i33 = (((o[i25 >>> 24] ^ p[(i18 >>> 16) & 255]) ^ q[(i11 >>> 8) & 255]) ^ r[i30 & 255]) ^ this.e[10];
            int i34 = (((o[i30 >>> 24] ^ p[(i25 >>> 16) & 255]) ^ q[(i18 >>> 8) & 255]) ^ r[i11 & 255]) ^ this.e[11];
            i11 = (((o[i31 >>> 24] ^ p[(i34 >>> 16) & 255]) ^ q[(i33 >>> 8) & 255]) ^ r[i32 & 255]) ^ this.e[12];
            i18 = (((o[i32 >>> 24] ^ p[(i31 >>> 16) & 255]) ^ q[(i34 >>> 8) & 255]) ^ r[i33 & 255]) ^ this.e[13];
            i25 = (((o[i33 >>> 24] ^ p[(i32 >>> 16) & 255]) ^ q[(i31 >>> 8) & 255]) ^ r[i34 & 255]) ^ this.e[14];
            i30 = (((o[i34 >>> 24] ^ p[(i33 >>> 16) & 255]) ^ q[(i32 >>> 8) & 255]) ^ r[i31 & 255]) ^ this.e[15];
            if (this.c) {
                int i35 = (((o[i11 >>> 24] ^ p[(i30 >>> 16) & 255]) ^ q[(i25 >>> 8) & 255]) ^ r[i18 & 255]) ^ this.e[16];
                int i36 = (((o[i18 >>> 24] ^ p[(i11 >>> 16) & 255]) ^ q[(i30 >>> 8) & 255]) ^ r[i25 & 255]) ^ this.e[17];
                int i37 = (((o[i25 >>> 24] ^ p[(i18 >>> 16) & 255]) ^ q[(i11 >>> 8) & 255]) ^ r[i30 & 255]) ^ this.e[18];
                int i38 = (((o[i30 >>> 24] ^ p[(i25 >>> 16) & 255]) ^ q[(i18 >>> 8) & 255]) ^ r[i11 & 255]) ^ this.e[19];
                i11 = (((o[i35 >>> 24] ^ p[(i38 >>> 16) & 255]) ^ q[(i37 >>> 8) & 255]) ^ r[i36 & 255]) ^ this.e[20];
                i18 = (((o[i36 >>> 24] ^ p[(i35 >>> 16) & 255]) ^ q[(i38 >>> 8) & 255]) ^ r[i37 & 255]) ^ this.e[21];
                i25 = (((o[i37 >>> 24] ^ p[(i36 >>> 16) & 255]) ^ q[(i35 >>> 8) & 255]) ^ r[i38 & 255]) ^ this.e[22];
                i30 = (((o[i38 >>> 24] ^ p[(i37 >>> 16) & 255]) ^ q[(i36 >>> 8) & 255]) ^ r[i35 & 255]) ^ this.e[23];
                i4 = 24;
            } else {
                i4 = 16;
            }
        } else {
            i4 = 8;
        }
        int i39 = i4 + 1;
        int i40 = this.e[i4] ^ (((o[i11 >>> 24] ^ p[(i30 >>> 16) & 255]) ^ q[(i25 >>> 8) & 255]) ^ r[i18 & 255]);
        int i41 = i39 + 1;
        int i42 = (((o[i18 >>> 24] ^ p[(i11 >>> 16) & 255]) ^ q[(i30 >>> 8) & 255]) ^ r[i25 & 255]) ^ this.e[i39];
        int i43 = i41 + 1;
        int i44 = (((o[i25 >>> 24] ^ p[(i18 >>> 16) & 255]) ^ q[(i11 >>> 8) & 255]) ^ r[i30 & 255]) ^ this.e[i41];
        int i45 = ((o[i30 >>> 24] ^ p[(i25 >>> 16) & 255]) ^ q[(i18 >>> 8) & 255]) ^ r[i11 & 255];
        int i46 = i43 + 1;
        int i47 = i45 ^ this.e[i43];
        int i48 = i46 + 1;
        int i49 = (((o[i40 >>> 24] ^ p[(i47 >>> 16) & 255]) ^ q[(i44 >>> 8) & 255]) ^ r[i42 & 255]) ^ this.e[i46];
        int i50 = i48 + 1;
        int i51 = (((o[i42 >>> 24] ^ p[(i40 >>> 16) & 255]) ^ q[(i47 >>> 8) & 255]) ^ r[i44 & 255]) ^ this.e[i48];
        int i52 = i50 + 1;
        int i53 = (((o[i44 >>> 24] ^ p[(i42 >>> 16) & 255]) ^ q[(i40 >>> 8) & 255]) ^ r[i47 & 255]) ^ this.e[i50];
        int i54 = ((o[i47 >>> 24] ^ p[(i44 >>> 16) & 255]) ^ q[(i42 >>> 8) & 255]) ^ r[i40 & 255];
        int i55 = i52 + 1;
        int i56 = i54 ^ this.e[i52];
        int i57 = i55 + 1;
        int i58 = (((o[i49 >>> 24] ^ p[(i56 >>> 16) & 255]) ^ q[(i53 >>> 8) & 255]) ^ r[i51 & 255]) ^ this.e[i55];
        int i59 = i57 + 1;
        int i60 = (((o[i51 >>> 24] ^ p[(i49 >>> 16) & 255]) ^ q[(i56 >>> 8) & 255]) ^ r[i53 & 255]) ^ this.e[i57];
        int i61 = i59 + 1;
        int i62 = (((o[i53 >>> 24] ^ p[(i51 >>> 16) & 255]) ^ q[(i49 >>> 8) & 255]) ^ r[i56 & 255]) ^ this.e[i59];
        int i63 = ((o[i56 >>> 24] ^ p[(i53 >>> 16) & 255]) ^ q[(i51 >>> 8) & 255]) ^ r[i49 & 255];
        int i64 = i61 + 1;
        int i65 = i63 ^ this.e[i61];
        int i66 = i64 + 1;
        int i67 = (((o[i58 >>> 24] ^ p[(i65 >>> 16) & 255]) ^ q[(i62 >>> 8) & 255]) ^ r[i60 & 255]) ^ this.e[i64];
        int i68 = i66 + 1;
        int i69 = (((o[i60 >>> 24] ^ p[(i58 >>> 16) & 255]) ^ q[(i65 >>> 8) & 255]) ^ r[i62 & 255]) ^ this.e[i66];
        int i70 = i68 + 1;
        int i71 = (((o[i62 >>> 24] ^ p[(i60 >>> 16) & 255]) ^ q[(i58 >>> 8) & 255]) ^ r[i65 & 255]) ^ this.e[i68];
        int i72 = ((o[i65 >>> 24] ^ p[(i62 >>> 16) & 255]) ^ q[(i60 >>> 8) & 255]) ^ r[i58 & 255];
        int i73 = i70 + 1;
        int i74 = i72 ^ this.e[i70];
        int i75 = i73 + 1;
        int i76 = (((o[i67 >>> 24] ^ p[(i74 >>> 16) & 255]) ^ q[(i71 >>> 8) & 255]) ^ r[i69 & 255]) ^ this.e[i73];
        int i77 = i75 + 1;
        int i78 = (((o[i69 >>> 24] ^ p[(i67 >>> 16) & 255]) ^ q[(i74 >>> 8) & 255]) ^ r[i71 & 255]) ^ this.e[i75];
        int i79 = i77 + 1;
        int i80 = (((o[i71 >>> 24] ^ p[(i69 >>> 16) & 255]) ^ q[(i67 >>> 8) & 255]) ^ r[i74 & 255]) ^ this.e[i77];
        int i81 = ((o[i74 >>> 24] ^ p[(i71 >>> 16) & 255]) ^ q[(i69 >>> 8) & 255]) ^ r[i67 & 255];
        int i82 = i79 + 1;
        int i83 = i81 ^ this.e[i79];
        int i84 = i82 + 1;
        int i85 = (((o[i76 >>> 24] ^ p[(i83 >>> 16) & 255]) ^ q[(i80 >>> 8) & 255]) ^ r[i78 & 255]) ^ this.e[i82];
        int i86 = i84 + 1;
        int i87 = (((o[i78 >>> 24] ^ p[(i76 >>> 16) & 255]) ^ q[(i83 >>> 8) & 255]) ^ r[i80 & 255]) ^ this.e[i84];
        int i88 = i86 + 1;
        int i89 = (((o[i80 >>> 24] ^ p[(i78 >>> 16) & 255]) ^ q[(i76 >>> 8) & 255]) ^ r[i83 & 255]) ^ this.e[i86];
        int i90 = ((o[i83 >>> 24] ^ p[(i80 >>> 16) & 255]) ^ q[(i78 >>> 8) & 255]) ^ r[i76 & 255];
        int i91 = i88 + 1;
        int i92 = i90 ^ this.e[i88];
        int i93 = i91 + 1;
        int i94 = (((o[i85 >>> 24] ^ p[(i92 >>> 16) & 255]) ^ q[(i89 >>> 8) & 255]) ^ r[i87 & 255]) ^ this.e[i91];
        int i95 = i93 + 1;
        int i96 = (((o[i87 >>> 24] ^ p[(i85 >>> 16) & 255]) ^ q[(i92 >>> 8) & 255]) ^ r[i89 & 255]) ^ this.e[i93];
        int i97 = i95 + 1;
        int i98 = (((o[i89 >>> 24] ^ p[(i87 >>> 16) & 255]) ^ q[(i85 >>> 8) & 255]) ^ r[i92 & 255]) ^ this.e[i95];
        int i99 = ((o[i92 >>> 24] ^ p[(i89 >>> 16) & 255]) ^ q[(i87 >>> 8) & 255]) ^ r[i85 & 255];
        int i100 = i97 + 1;
        int i101 = i99 ^ this.e[i97];
        int i102 = i100 + 1;
        int i103 = (((o[i94 >>> 24] ^ p[(i101 >>> 16) & 255]) ^ q[(i98 >>> 8) & 255]) ^ r[i96 & 255]) ^ this.e[i100];
        int i104 = i102 + 1;
        int i105 = (((o[i96 >>> 24] ^ p[(i94 >>> 16) & 255]) ^ q[(i101 >>> 8) & 255]) ^ r[i98 & 255]) ^ this.e[i102];
        int i106 = i104 + 1;
        int i107 = (((o[i98 >>> 24] ^ p[(i96 >>> 16) & 255]) ^ q[(i94 >>> 8) & 255]) ^ r[i101 & 255]) ^ this.e[i104];
        int i108 = ((o[i101 >>> 24] ^ p[(i98 >>> 16) & 255]) ^ q[(i96 >>> 8) & 255]) ^ r[i94 & 255];
        int i109 = i106 + 1;
        int i110 = i108 ^ this.e[i106];
        int i111 = i109 + 1;
        int i112 = (((o[i103 >>> 24] ^ p[(i110 >>> 16) & 255]) ^ q[(i107 >>> 8) & 255]) ^ r[i105 & 255]) ^ this.e[i109];
        int i113 = i111 + 1;
        int i114 = (((o[i105 >>> 24] ^ p[(i103 >>> 16) & 255]) ^ q[(i110 >>> 8) & 255]) ^ r[i107 & 255]) ^ this.e[i111];
        int i115 = (((o[i107 >>> 24] ^ p[(i105 >>> 16) & 255]) ^ q[(i103 >>> 8) & 255]) ^ r[i110 & 255]) ^ this.e[i113];
        int i116 = (((o[i110 >>> 24] ^ p[(i107 >>> 16) & 255]) ^ q[(i105 >>> 8) & 255]) ^ r[i103 & 255]) ^ this.e[i113 + 1];
        int i117 = this.e[0];
        int i118 = i3 + 1;
        bArr2[i3] = (byte) (j[i112 >>> 24] ^ (i117 >>> 24));
        int i119 = i118 + 1;
        bArr2[i118] = (byte) (j[(i116 >>> 16) & 255] ^ (i117 >>> 16));
        int i120 = i119 + 1;
        bArr2[i119] = (byte) (j[(i115 >>> 8) & 255] ^ (i117 >>> 8));
        int i121 = i120 + 1;
        bArr2[i120] = (byte) (i117 ^ j[i114 & 255]);
        int i122 = this.e[1];
        int i123 = i121 + 1;
        bArr2[i121] = (byte) (j[i114 >>> 24] ^ (i122 >>> 24));
        int i124 = i123 + 1;
        bArr2[i123] = (byte) (j[(i112 >>> 16) & 255] ^ (i122 >>> 16));
        int i125 = i124 + 1;
        bArr2[i124] = (byte) (j[(i116 >>> 8) & 255] ^ (i122 >>> 8));
        int i126 = i125 + 1;
        bArr2[i125] = (byte) (i122 ^ j[i115 & 255]);
        int i127 = this.e[2];
        int i128 = i126 + 1;
        bArr2[i126] = (byte) (j[i115 >>> 24] ^ (i127 >>> 24));
        int i129 = i128 + 1;
        bArr2[i128] = (byte) (j[(i114 >>> 16) & 255] ^ (i127 >>> 16));
        int i130 = i129 + 1;
        bArr2[i129] = (byte) (j[(i112 >>> 8) & 255] ^ (i127 >>> 8));
        int i131 = i130 + 1;
        bArr2[i130] = (byte) (i127 ^ j[i116 & 255]);
        int i132 = this.e[3];
        int i133 = i131 + 1;
        bArr2[i131] = (byte) (j[i116 >>> 24] ^ (i132 >>> 24));
        int i134 = i133 + 1;
        bArr2[i133] = (byte) (j[(i115 >>> 16) & 255] ^ (i132 >>> 16));
        bArr2[i134] = (byte) (j[(i114 >>> 8) & 255] ^ (i132 >>> 8));
        bArr2[i134 + 1] = (byte) (j[i112 & 255] ^ i132);
    }
}
