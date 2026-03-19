package io.netty.handler.codec.compression;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
final class FastLz {
    static final byte BLOCK_TYPE_COMPRESSED = 1;
    static final byte BLOCK_TYPE_NON_COMPRESSED = 0;
    static final byte BLOCK_WITHOUT_CHECKSUM = 0;
    static final byte BLOCK_WITH_CHECKSUM = 16;
    static final int CHECKSUM_OFFSET = 4;
    private static final int HASH_LOG = 13;
    private static final int HASH_MASK = 8191;
    private static final int HASH_SIZE = 8192;
    static final int LEVEL_1 = 1;
    static final int LEVEL_2 = 2;
    static final int LEVEL_AUTO = 0;
    static final int MAGIC_NUMBER = 4607066;
    static final int MAX_CHUNK_LENGTH = 65535;
    private static final int MAX_COPY = 32;
    private static final int MAX_DISTANCE = 8191;
    private static final int MAX_FARDISTANCE = 73725;
    private static final int MAX_LEN = 264;
    static final int MIN_LENGTH_TO_COMPRESSION = 32;
    private static final int MIN_RECOMENDED_LENGTH_FOR_LEVEL_2 = 65536;
    static final int OPTIONS_OFFSET = 3;

    static int calculateOutputBufferLength(int i) {
        double d = i;
        Double.isNaN(d);
        return Math.max((int) (d * 1.06d), 66);
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x01f5 A[PHI: r10
  0x01f5: PHI (r10v7 int) = (r10v6 int), (r10v10 int), (r10v13 int), (r10v16 int) binds: [B:82:0x0189, B:86:0x01a5, B:90:0x01c1, B:94:0x01dd] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x02c6  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x016f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static int compress(byte[] r22, int r23, int r24, byte[] r25, int r26, int r27) {
        /*
            Method dump skipped, instructions count: 913
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.compression.FastLz.compress(byte[], int, int, byte[], int, int):int");
    }

    static int decompress(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4) {
        int i5;
        int i6;
        long j;
        boolean z;
        byte b;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        char c = 5;
        int i12 = (bArr[i] >> 5) + 1;
        if (i12 != 1 && i12 != 2) {
            throw new DecompressionException(String.format("invalid level: %d (expected: %d or %d)", Integer.valueOf(i12), 1, 2));
        }
        long j2 = bArr[i + 0] & 31;
        int i13 = 0;
        int i14 = 1;
        boolean z2 = true;
        while (true) {
            long j3 = j2 >> c;
            long j4 = (31 & j2) << 8;
            if (j2 >= 32) {
                long j5 = j3 - 1;
                long j6 = i13;
                int i15 = i13;
                int i16 = (int) (j6 - j4);
                if (j5 != 6) {
                    j = j2;
                    z = z2;
                    b = 255;
                    i7 = i14;
                } else if (i12 == 1) {
                    i7 = i14 + 1;
                    b = 255;
                    z = z2;
                    j5 += bArr[i + i14] & 255;
                    j = j2;
                } else {
                    z = z2;
                    b = 255;
                    while (true) {
                        i7 = i14 + 1;
                        int i17 = bArr[i + i14] & 255;
                        j = j2;
                        j5 += i17;
                        if (i17 != 255) {
                            break;
                        }
                        i14 = i7;
                        j2 = j;
                    }
                }
                if (i12 == 1) {
                    i8 = i7 + 1;
                    i9 = i16 - (bArr[i + i7] & b);
                } else {
                    i8 = i7 + 1;
                    int i18 = bArr[i + i7] & b;
                    i9 = i16 - i18;
                    if (i18 == b && j4 == 7936) {
                        i9 = (int) ((j6 - (((bArr[i + i8] & b) << 8) + (bArr[i + r5] & b))) - 8191);
                        i8 = i8 + 1 + 1;
                    }
                }
                if (j6 + j5 + 3 > i4 || i9 - 1 < 0) {
                    return 0;
                }
                if (i8 < i2) {
                    i10 = i8 + 1;
                    j = bArr[i + i8] & 255;
                    i11 = i15;
                } else {
                    i10 = i8;
                    i11 = i15;
                    z = false;
                }
                if (i9 == i11) {
                    byte b2 = bArr2[(i3 + i9) - 1];
                    int i19 = i11 + 1;
                    bArr2[i3 + i11] = b2;
                    int i20 = i19 + 1;
                    bArr2[i3 + i19] = b2;
                    int i21 = i20 + 1;
                    bArr2[i3 + i20] = b2;
                    while (j5 != 0) {
                        bArr2[i3 + i21] = b2;
                        j5--;
                        i21++;
                    }
                    i14 = i10;
                    i5 = i21;
                } else {
                    int i22 = i9 - 1;
                    int i23 = i11 + 1;
                    int i24 = i22 + 1;
                    bArr2[i3 + i11] = bArr2[i3 + i22];
                    int i25 = i23 + 1;
                    int i26 = i24 + 1;
                    bArr2[i3 + i23] = bArr2[i3 + i24];
                    int i27 = i25 + 1;
                    int i28 = i26 + 1;
                    bArr2[i3 + i25] = bArr2[i3 + i26];
                    while (j5 != 0) {
                        bArr2[i3 + i27] = bArr2[i3 + i28];
                        j5--;
                        i27++;
                        i28++;
                    }
                    i14 = i10;
                    i5 = i27;
                }
                z2 = z;
            } else {
                int i29 = i13;
                long j7 = j2 + 1;
                if (i29 + j7 > i4 || i14 + j7 > i2) {
                    return 0;
                }
                while (true) {
                    i5 = i29 + 1;
                    i6 = i14 + 1;
                    bArr2[i3 + i29] = bArr[i + i14];
                    j7--;
                    if (j7 == 0) {
                        break;
                    }
                    i29 = i5;
                    i14 = i6;
                }
                boolean z3 = i6 < i2;
                if (z3) {
                    j = bArr[i + i6] & 255;
                    i14 = i6 + 1;
                } else {
                    j = j7;
                    i14 = i6;
                }
                z2 = z3;
            }
            if (!z2) {
                return i5;
            }
            i13 = i5;
            j2 = j;
            c = 5;
        }
    }

    private static int hashFunction(byte[] bArr, int i) {
        int u16 = readU16(bArr, i);
        return ((readU16(bArr, i + 1) ^ (u16 >> 3)) ^ u16) & 8191;
    }

    private static int readU16(byte[] bArr, int i) {
        int i2 = i + 1;
        if (i2 >= bArr.length) {
            return bArr[i] & 255;
        }
        return (bArr[i] & 255) | ((bArr[i2] & 255) << 8);
    }

    private FastLz() {
    }
}
