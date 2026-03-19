package com.baidu.mobstat.forbes;

import androidx.core.view.MotionEventCompat;
import okio.Utf8;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public final class ak {
    private static final byte[] a = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, com.sigmob.sdk.archives.tar.e.P, 77, 78, 79, 80, 81, 82, com.sigmob.sdk.archives.tar.e.Q, 84, 85, 86, 87, com.sigmob.sdk.archives.tar.e.S, 89, 90, 97, 98, 99, 100, 101, 102, com.sigmob.sdk.archives.tar.e.T, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, com.sigmob.sdk.archives.tar.e.R, 121, 122, com.sigmob.sdk.archives.tar.e.H, com.sigmob.sdk.archives.tar.e.I, com.sigmob.sdk.archives.tar.e.J, com.sigmob.sdk.archives.tar.e.f789K, com.sigmob.sdk.archives.tar.e.L, com.sigmob.sdk.archives.tar.e.M, com.sigmob.sdk.archives.tar.e.N, com.sigmob.sdk.archives.tar.e.O, 56, 57, 43, 47};

    public static byte[] a(byte[] bArr) {
        return a(bArr, bArr.length);
    }

    public static byte[] a(byte[] bArr, int i) {
        byte b;
        int i2;
        int i3 = (i / 4) * 3;
        if (i3 == 0) {
            return new byte[0];
        }
        byte[] bArr2 = new byte[i3];
        int i4 = i;
        int i5 = 0;
        while (true) {
            byte b2 = bArr[i4 - 1];
            b = 10;
            if (b2 != 10 && b2 != 13 && b2 != 32 && b2 != 9) {
                if (b2 != 61) {
                    break;
                }
                i5++;
            }
            i4--;
        }
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (i6 < i4) {
            byte b3 = bArr[i6];
            if (b3 != b && b3 != 13 && b3 != 32 && b3 != 9) {
                if (b3 >= 65 && b3 <= 90) {
                    i2 = b3 - 65;
                } else if (b3 >= 97 && b3 <= 122) {
                    i2 = b3 - 71;
                } else if (b3 >= 48 && b3 <= 57) {
                    i2 = b3 + 4;
                } else if (b3 == 43) {
                    i2 = 62;
                } else if (b3 == 47) {
                    i2 = 63;
                } else {
                    return null;
                }
                i7 = ((byte) i2) | (i7 << 6);
                if (i9 % 4 == 3) {
                    int i10 = i8 + 1;
                    bArr2[i8] = (byte) ((16711680 & i7) >> 16);
                    int i11 = i10 + 1;
                    bArr2[i10] = (byte) ((65280 & i7) >> 8);
                    bArr2[i11] = (byte) (i7 & 255);
                    i8 = i11 + 1;
                }
                i9++;
            }
            i6++;
            b = 10;
        }
        if (i5 > 0) {
            int i12 = i7 << (i5 * 6);
            int i13 = i8 + 1;
            bArr2[i8] = (byte) ((i12 & 16711680) >> 16);
            if (i5 != 1) {
                i8 = i13;
            } else {
                i8 = i13 + 1;
                bArr2[i13] = (byte) ((i12 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8);
            }
        }
        byte[] bArr3 = new byte[i8];
        System.arraycopy(bArr2, 0, bArr3, 0, i8);
        return bArr3;
    }

    public static String b(byte[] bArr) {
        return a(bArr, "utf-8");
    }

    public static String a(byte[] bArr, String str) {
        int length = (bArr.length * 4) / 3;
        byte[] bArr2 = new byte[length + (length / 76) + 3];
        int length2 = bArr.length - (bArr.length % 3);
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < length2; i3 += 3) {
            int i4 = i + 1;
            bArr2[i] = a[(bArr[i3] & 255) >> 2];
            int i5 = i4 + 1;
            int i6 = i3 + 1;
            bArr2[i4] = a[((bArr[i3] & 3) << 4) | ((bArr[i6] & 255) >> 4)];
            int i7 = i5 + 1;
            byte[] bArr3 = a;
            int i8 = (bArr[i6] & 15) << 2;
            int i9 = i3 + 2;
            bArr2[i5] = bArr3[i8 | ((bArr[i9] & 255) >> 6)];
            i = i7 + 1;
            bArr2[i7] = a[bArr[i9] & Utf8.REPLACEMENT_BYTE];
            if ((i - i2) % 76 == 0 && i != 0) {
                i2++;
            }
        }
        switch (bArr.length % 3) {
            case 1:
                int i10 = i + 1;
                bArr2[i] = a[(bArr[length2] & 255) >> 2];
                int i11 = i10 + 1;
                bArr2[i10] = a[(bArr[length2] & 3) << 4];
                int i12 = i11 + 1;
                bArr2[i11] = 61;
                i = i12 + 1;
                bArr2[i12] = 61;
                break;
            case 2:
                int i13 = i + 1;
                bArr2[i] = a[(bArr[length2] & 255) >> 2];
                int i14 = i13 + 1;
                byte[] bArr4 = a;
                int i15 = (bArr[length2] & 3) << 4;
                int i16 = length2 + 1;
                bArr2[i13] = bArr4[i15 | ((bArr[i16] & 255) >> 4)];
                int i17 = i14 + 1;
                bArr2[i14] = a[(bArr[i16] & 15) << 2];
                i = i17 + 1;
                bArr2[i17] = 61;
                break;
        }
        return new String(bArr2, 0, i, str);
    }
}
