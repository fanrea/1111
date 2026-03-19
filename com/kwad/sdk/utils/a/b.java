package com.kwad.sdk.utils.a;

import java.nio.charset.Charset;
import okio.Utf8;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class b {
    public static final Charset UTF_8 = Charset.forName("UTF-8");
    private char[] cov;
    public byte[] cow;
    public int position;

    public static int hE(int i) {
        if ((i >> 7) == 0) {
            return 1;
        }
        if ((i >> 14) == 0) {
            return 2;
        }
        if ((i >> 21) == 0) {
            return 3;
        }
        return (i >> 28) == 0 ? 4 : 5;
    }

    public b(int i) {
        this(new byte[i], 0);
    }

    public b(byte[] bArr) {
        this(bArr, 0);
    }

    public b(byte[] bArr, int i) {
        this.cov = null;
        this.cow = bArr;
        this.position = i;
    }

    public final byte get() {
        byte[] bArr = this.cow;
        int i = this.position;
        this.position = i + 1;
        return bArr[i];
    }

    public final void e(byte b) {
        byte[] bArr = this.cow;
        int i = this.position;
        this.position = i + 1;
        bArr[i] = b;
    }

    public final short getShort() {
        byte[] bArr = this.cow;
        int i = this.position;
        int i2 = i + 1;
        int i3 = bArr[i] & 255;
        this.position = i2 + 1;
        return (short) ((bArr[i2] << 8) | i3);
    }

    public final void a(short s) {
        byte[] bArr = this.cow;
        int i = this.position;
        int i2 = i + 1;
        bArr[i] = (byte) s;
        this.position = i2 + 1;
        bArr[i2] = (byte) (s >> 8);
    }

    public final int getInt() {
        byte[] bArr = this.cow;
        int i = this.position;
        int i2 = i + 1;
        int i3 = i2 + 1;
        int i4 = (bArr[i] & 255) | ((bArr[i2] & 255) << 8);
        int i5 = i3 + 1;
        int i6 = i4 | ((bArr[i3] & 255) << 16);
        this.position = i5 + 1;
        return (bArr[i5] << 24) | i6;
    }

    public final void hC(int i) {
        byte[] bArr = this.cow;
        int i2 = this.position;
        int i3 = i2 + 1;
        bArr[i2] = (byte) i;
        int i4 = i3 + 1;
        bArr[i3] = (byte) (i >> 8);
        int i5 = i4 + 1;
        bArr[i4] = (byte) (i >> 16);
        this.position = i5 + 1;
        bArr[i5] = (byte) (i >> 24);
    }

    public final void ae(int i, int i2) {
        byte[] bArr = this.cow;
        int i3 = i + 1;
        bArr[i] = (byte) i2;
        int i4 = i3 + 1;
        bArr[i3] = (byte) (i2 >> 8);
        bArr[i4] = (byte) (i2 >> 16);
        bArr[i4 + 1] = (byte) (i2 >> 24);
    }

    public final int aqt() {
        byte[] bArr = this.cow;
        int i = this.position;
        int i2 = i + 1;
        this.position = i2;
        byte b = bArr[i];
        if ((b >> 7) == 0) {
            return b;
        }
        int i3 = i2 + 1;
        this.position = i3;
        int i4 = (b & 127) | (bArr[i2] << 7);
        if ((i4 >> 14) == 0) {
            return i4;
        }
        int i5 = i3 + 1;
        this.position = i5;
        int i6 = (i4 & 16383) | (bArr[i3] << 14);
        if ((i6 >> 21) == 0) {
            return i6;
        }
        int i7 = i5 + 1;
        this.position = i7;
        int i8 = (i6 & 2097151) | (bArr[i5] << 21);
        if ((i8 >> 28) == 0) {
            return i8;
        }
        this.position = i7 + 1;
        return (bArr[i7] << 28) | (i8 & 268435455);
    }

    private int af(int i, int i2) {
        while ((i2 & com.alipay.sdk.m.n.a.g) != 0) {
            this.cow[i] = (byte) ((i2 & 127) | 128);
            i2 >>>= 7;
            i++;
        }
        int i3 = i + 1;
        this.cow[i] = (byte) i2;
        return i3;
    }

    public final void hD(int i) {
        this.position = af(this.position, i);
    }

    public final void j(int i, long j) {
        byte[] bArr = this.cow;
        int i2 = i + 1;
        bArr[i] = (byte) j;
        int i3 = i2 + 1;
        bArr[i2] = (byte) (j >> 8);
        int i4 = i3 + 1;
        bArr[i3] = (byte) (j >> 16);
        int i5 = i4 + 1;
        bArr[i4] = (byte) (j >> 24);
        int i6 = i5 + 1;
        bArr[i5] = (byte) (j >> 32);
        int i7 = i6 + 1;
        bArr[i6] = (byte) (j >> 40);
        bArr[i7] = (byte) (j >> 48);
        bArr[i7 + 1] = (byte) (j >> 56);
    }

    public final void bO(long j) {
        j(this.position, j);
        this.position += 8;
    }

    private long getLong(int i) {
        byte[] bArr = this.cow;
        long j = bArr[i] & 255;
        int i2 = i + 1 + 1 + 1;
        long j2 = j | ((bArr[r1] & 255) << 8) | ((bArr[r9] & 255) << 16);
        long j3 = j2 | ((bArr[i2] & 255) << 24);
        long j4 = j3 | ((bArr[r9] & 255) << 32);
        int i3 = i2 + 1 + 1 + 1;
        return j4 | ((bArr[r3] & 255) << 40) | ((255 & bArr[i3]) << 48) | (bArr[i3 + 1] << 56);
    }

    public final long getLong() {
        long j = getLong(this.position);
        this.position += 8;
        return j;
    }

    public final float getFloat() {
        return Float.intBitsToFloat(getInt());
    }

    public final double getDouble() {
        return Double.longBitsToDouble(getLong());
    }

    public final byte[] getBytes(int i) {
        byte[] bArr = new byte[i];
        System.arraycopy(this.cow, this.position, bArr, 0, i);
        this.position += i;
        return bArr;
    }

    public final void t(byte[] bArr) {
        int length = bArr.length;
        if (length > 0) {
            System.arraycopy(bArr, 0, this.cow, this.position, length);
            this.position += length;
        }
    }

    public final String getString(int i) {
        if (i < 0) {
            return null;
        }
        if (i == 0) {
            return "";
        }
        String strHH = hH(i);
        this.position += i;
        return strHH;
    }

    public final String hF(int i) {
        if (i < 0) {
            return null;
        }
        if (i == 0) {
            return "";
        }
        String strHI = hI(i);
        this.position += i;
        return strHI;
    }

    public final void iX(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        iZ(str);
    }

    public static int iY(String str) {
        int length = str.length();
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = i + 1;
            char cCharAt = str.charAt(i);
            if (cCharAt < 128) {
                i2++;
            } else if (cCharAt < 2048) {
                i2 += 2;
            } else if (cCharAt < 55296 || cCharAt > 57343) {
                i2 += 3;
            } else {
                i = i3 + 1;
                i2 += 4;
            }
            i = i3;
        }
        return i2;
    }

    private char[] hG(int i) {
        char[] cArr = this.cov;
        if (cArr == null) {
            if (i <= 256) {
                this.cov = new char[256];
            } else {
                this.cov = new char[2048];
            }
        } else if (cArr.length < i) {
            this.cov = new char[2048];
        }
        return this.cov;
    }

    private String hH(int i) {
        if (i > 2048) {
            return new String(this.cow, this.position, i, UTF_8);
        }
        char[] cArrHG = hG(i);
        byte[] bArr = this.cow;
        int i2 = this.position;
        int i3 = i + i2;
        int i4 = 0;
        while (i2 < i3) {
            int i5 = i2 + 1;
            byte b = bArr[i2];
            if (b > 0) {
                cArrHG[i4] = (char) (b ^ 1);
                i2 = i5;
                i4++;
            } else if (b < -32) {
                cArrHG[i4] = (char) (((b & 31) << 6) | (bArr[i5] & Utf8.REPLACEMENT_BYTE));
                i2 = i5 + 1;
                i4++;
            } else if (b < -16) {
                int i6 = i5 + 1;
                cArrHG[i4] = (char) (((b & 15) << 12) | ((bArr[i5] & Utf8.REPLACEMENT_BYTE) << 6) | (bArr[i6] & Utf8.REPLACEMENT_BYTE));
                i2 = i6 + 1;
                i4++;
            } else {
                int i7 = i5 + 1;
                int i8 = i7 + 1;
                int i9 = ((b & 7) << 18) | ((bArr[i5] & Utf8.REPLACEMENT_BYTE) << 12) | ((bArr[i7] & Utf8.REPLACEMENT_BYTE) << 6) | (bArr[i8] & Utf8.REPLACEMENT_BYTE);
                int i10 = i4 + 1;
                cArrHG[i4] = (char) ((i9 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
                i4 = i10 + 1;
                cArrHG[i10] = (char) ((i9 & 1023) + Utf8.LOG_SURROGATE_HEADER);
                i2 = i8 + 1;
            }
        }
        if (i2 > i3) {
            throw new IllegalArgumentException("Invalid String");
        }
        return new String(cArrHG, 0, i4);
    }

    private String hI(int i) {
        if (i > 2048) {
            return new String(this.cow, this.position, i, UTF_8);
        }
        char[] cArrHG = hG(i);
        byte[] bArr = this.cow;
        int i2 = this.position;
        int i3 = i + i2;
        int i4 = 0;
        while (i2 < i3) {
            int i5 = i2 + 1;
            byte b = bArr[i2];
            if (b > 0) {
                cArrHG[i4] = (char) b;
                i2 = i5;
                i4++;
            } else if (b < -32) {
                cArrHG[i4] = (char) (((b & 31) << 6) | (bArr[i5] & Utf8.REPLACEMENT_BYTE));
                i2 = i5 + 1;
                i4++;
            } else if (b < -16) {
                int i6 = i5 + 1;
                cArrHG[i4] = (char) (((b & 15) << 12) | ((bArr[i5] & Utf8.REPLACEMENT_BYTE) << 6) | (bArr[i6] & Utf8.REPLACEMENT_BYTE));
                i2 = i6 + 1;
                i4++;
            } else {
                int i7 = i5 + 1;
                int i8 = i7 + 1;
                int i9 = ((b & 7) << 18) | ((bArr[i5] & Utf8.REPLACEMENT_BYTE) << 12) | ((bArr[i7] & Utf8.REPLACEMENT_BYTE) << 6) | (bArr[i8] & Utf8.REPLACEMENT_BYTE);
                int i10 = i4 + 1;
                cArrHG[i4] = (char) ((i9 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
                i4 = i10 + 1;
                cArrHG[i10] = (char) ((i9 & 1023) + Utf8.LOG_SURROGATE_HEADER);
                i2 = i8 + 1;
            }
        }
        if (i2 > i3) {
            throw new IllegalArgumentException("Invalid String");
        }
        return new String(cArrHG, 0, i4);
    }

    static String l(byte[] bArr, int i) {
        char[] cArr = new char[bArr.length];
        int i2 = 0;
        int i3 = 0;
        while (i2 < i) {
            int i4 = i2 + 1;
            byte b = bArr[i2];
            if (b > 0) {
                cArr[i3] = (char) (b ^ 1);
                i2 = i4;
                i3++;
            } else if (b < -32) {
                cArr[i3] = (char) (((b & 31) << 6) | (bArr[i4] & Utf8.REPLACEMENT_BYTE));
                i2 = i4 + 1;
                i3++;
            } else if (b < -16) {
                int i5 = i4 + 1;
                cArr[i3] = (char) (((b & 15) << 12) | ((bArr[i4] & Utf8.REPLACEMENT_BYTE) << 6) | (bArr[i5] & Utf8.REPLACEMENT_BYTE));
                i2 = i5 + 1;
                i3++;
            } else {
                int i6 = i4 + 1;
                int i7 = i6 + 1;
                int i8 = ((b & 7) << 18) | ((bArr[i4] & Utf8.REPLACEMENT_BYTE) << 12) | ((bArr[i6] & Utf8.REPLACEMENT_BYTE) << 6) | (bArr[i7] & Utf8.REPLACEMENT_BYTE);
                int i9 = i3 + 1;
                cArr[i3] = (char) ((i8 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
                i3 = i9 + 1;
                cArr[i9] = (char) ((i8 & 1023) + Utf8.LOG_SURROGATE_HEADER);
                i2 = i7 + 1;
            }
        }
        if (i2 > i) {
            throw new IllegalArgumentException("Invalid String");
        }
        return new String(cArr, 0, i3);
    }

    private void iZ(String str) {
        byte[] bArr = this.cow;
        int i = this.position;
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            int i3 = i2 + 1;
            char cCharAt = str.charAt(i2);
            if (cCharAt < 128) {
                bArr[i] = (byte) (cCharAt ^ 1);
                i2 = i3;
                i++;
            } else if (cCharAt < 2048) {
                int i4 = i + 1;
                bArr[i] = (byte) ((cCharAt >>> 6) | 192);
                i = i4 + 1;
                bArr[i4] = (byte) ((cCharAt & '?') | 128);
                i2 = i3;
            } else if (cCharAt < 55296 || cCharAt > 57343) {
                int i5 = i + 1;
                bArr[i] = (byte) ((cCharAt >>> '\f') | 224);
                int i6 = i5 + 1;
                bArr[i5] = (byte) (((cCharAt >>> 6) & 63) | 128);
                bArr[i6] = (byte) ((cCharAt & '?') | 128);
                i2 = i3;
                i = i6 + 1;
            } else {
                int i7 = i3 + 1;
                int iCharAt = ((cCharAt << '\n') + str.charAt(i3)) - 56613888;
                int i8 = i + 1;
                bArr[i] = (byte) ((iCharAt >>> 18) | 240);
                int i9 = i8 + 1;
                bArr[i8] = (byte) (((iCharAt >>> 12) & 63) | 128);
                int i10 = i9 + 1;
                bArr[i9] = (byte) (((iCharAt >>> 6) & 63) | 128);
                i = i10 + 1;
                bArr[i10] = (byte) ((iCharAt & 63) | 128);
                i2 = i7;
            }
        }
        this.position = i;
    }

    public static byte[] ja(String str) {
        byte[] bArr = new byte[iY(str)];
        int length = str.length();
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = i + 1;
            char cCharAt = str.charAt(i);
            if (cCharAt < 128) {
                bArr[i2] = (byte) (cCharAt ^ 1);
                i = i3;
                i2++;
            } else if (cCharAt < 2048) {
                int i4 = i2 + 1;
                bArr[i2] = (byte) ((cCharAt >>> 6) | 192);
                i2 = i4 + 1;
                bArr[i4] = (byte) ((cCharAt & '?') | 128);
                i = i3;
            } else if (cCharAt < 55296 || cCharAt > 57343) {
                int i5 = i2 + 1;
                bArr[i2] = (byte) ((cCharAt >>> '\f') | 224);
                int i6 = i5 + 1;
                bArr[i5] = (byte) (((cCharAt >>> 6) & 63) | 128);
                bArr[i6] = (byte) ((cCharAt & '?') | 128);
                i = i3;
                i2 = i6 + 1;
            } else {
                int i7 = i3 + 1;
                int iCharAt = ((cCharAt << '\n') + str.charAt(i3)) - 56613888;
                int i8 = i2 + 1;
                bArr[i2] = (byte) ((iCharAt >>> 18) | 240);
                int i9 = i8 + 1;
                bArr[i8] = (byte) (((iCharAt >>> 12) & 63) | 128);
                int i10 = i9 + 1;
                bArr[i9] = (byte) (((iCharAt >>> 6) & 63) | 128);
                i2 = i10 + 1;
                bArr[i10] = (byte) ((iCharAt & 63) | 128);
                i = i7;
            }
        }
        return bArr;
    }

    final long ag(int i, int i2) {
        long j = 0;
        if (i2 <= 0) {
            return 0L;
        }
        int i3 = i2 >> 3;
        int i4 = i2 & 7;
        int i5 = 0;
        int i6 = i;
        for (int i7 = 0; i7 < i3; i7++) {
            j ^= getLong(i6);
            i6 += 8;
        }
        while (i5 < (i4 << 3)) {
            j ^= (this.cow[i6] & 255) << i5;
            i5 += 8;
            i6++;
        }
        int i8 = (i & 7) << 3;
        return (j >>> (64 - i8)) | (j << i8);
    }
}
