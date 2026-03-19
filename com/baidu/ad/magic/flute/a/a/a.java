package com.baidu.ad.magic.flute.a.a;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class a {
    private static final byte[][] a = {new byte[]{0, 0}, new byte[]{0, 1}, new byte[]{0, 2}, new byte[]{1, 0}, new byte[]{1, 1}, new byte[]{1, 2}, new byte[]{2, 0}, new byte[]{2, 1}};

    public static int a(int i) {
        int i2 = i % 3;
        char c = 1;
        if (i2 == 1) {
            i += 2;
            c = 2;
        } else if (i2 == 2) {
            i++;
        } else {
            c = 0;
        }
        int i3 = (i / 3) * 2;
        return c > 0 ? i3 + 1 : i3;
    }

    public static b a(byte[] bArr) {
        int length = (((bArr.length - 1) / 2) * 3) - (bArr.length % 2 != 0 ? bArr[bArr.length - 1] : 0);
        int i = length / 8;
        if (length % 8 > 0) {
            i++;
        }
        byte[] bArr2 = new byte[i];
        int i2 = 0;
        int i3 = 8;
        for (int i4 = 0; i4 < bArr.length - 1; i4 += 2) {
            byte b = (byte) (((bArr[i4] * 3) + bArr[i4 + 1]) & 255);
            for (int i5 = 2; i5 >= 0; i5--) {
                if (i3 <= 0) {
                    i2++;
                    i3 = 8;
                }
                if (i2 >= i) {
                    break;
                }
                bArr2[i2] = (byte) ((bArr2[i2] << 1) | ((b >> i5) & 1));
                i3--;
            }
        }
        if (i3 > 0 && i2 < i) {
            bArr2[i2] = (byte) (bArr2[i2] << i3);
        }
        return new b(bArr2, length);
    }

    public static byte[] a(byte[] bArr, int i) {
        int i2;
        byte b;
        int i3 = i % 3;
        if (i3 == 1) {
            i2 = i + 2;
            b = 2;
        } else if (i3 == 2) {
            i2 = i + 1;
            b = 1;
        } else {
            i2 = i;
            b = 0;
        }
        int i4 = (i2 / 3) * 2;
        if (b > 0) {
            i4++;
        }
        byte[] bArr2 = new byte[i4];
        int i5 = 0;
        int i6 = 0;
        for (byte b2 : bArr) {
            for (int i7 = 7; i7 >= 0; i7--) {
                bArr2[i5] = (byte) ((bArr2[i5] << 1) | ((b2 >> i7) & 1));
                if (i6 % 3 == 2) {
                    bArr2[i5 + 1] = a[bArr2[i5]][1];
                    bArr2[i5] = a[bArr2[i5]][0];
                    i5 += 2;
                }
                i6++;
                if (i6 == i) {
                    break;
                }
            }
            if (i6 == i) {
                break;
            }
        }
        if (b > 0) {
            bArr2[i5] = (byte) (bArr2[i5] << b);
            bArr2[i5 + 1] = a[bArr2[i5]][1];
            bArr2[i5] = a[bArr2[i5]][0];
            bArr2[i5 + 2] = b;
        }
        return bArr2;
    }
}
