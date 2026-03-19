package io.netty.handler.codec.compression;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
final class Bzip2DivSufSort {
    private static final int BUCKET_A_SIZE = 256;
    private static final int BUCKET_B_SIZE = 65536;
    private static final int INSERTIONSORT_THRESHOLD = 8;
    private static final int[] LOG_2_TABLE = {-1, 0, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7};
    private static final int SS_BLOCKSIZE = 1024;
    private static final int STACK_SIZE = 64;
    private final int[] SA;
    private final byte[] T;
    private final int n;

    private static int BUCKET_B(int i, int i2) {
        return i | (i2 << 8);
    }

    private static int BUCKET_BSTAR(int i, int i2) {
        return (i << 8) | i2;
    }

    private static int getIDX(int i) {
        return i >= 0 ? i : i ^ (-1);
    }

    Bzip2DivSufSort(byte[] bArr, int[] iArr, int i) {
        this.T = bArr;
        this.SA = iArr;
        this.n = i;
    }

    private static void swapElements(int[] iArr, int i, int[] iArr2, int i2) {
        int i3 = iArr[i];
        iArr[i] = iArr2[i2];
        iArr2[i2] = i3;
    }

    private int ssCompare(int i, int i2, int i3) {
        int[] iArr = this.SA;
        byte[] bArr = this.T;
        int i4 = iArr[i + 1] + 2;
        int i5 = iArr[i2 + 1] + 2;
        int i6 = iArr[i] + i3;
        int i7 = i3 + iArr[i2];
        while (i6 < i4 && i7 < i5 && bArr[i6] == bArr[i7]) {
            i6++;
            i7++;
        }
        if (i6 >= i4) {
            return i7 < i5 ? -1 : 0;
        }
        if (i7 < i5) {
            return (bArr[i6] & 255) - (bArr[i7] & 255);
        }
        return 1;
    }

    private int ssCompareLast(int i, int i2, int i3, int i4, int i5) {
        int i6;
        byte b;
        int[] iArr = this.SA;
        byte[] bArr = this.T;
        int i7 = iArr[i2] + i4;
        int i8 = i4 + iArr[i3];
        int i9 = iArr[i3 + 1] + 2;
        while (i7 < i5 && i8 < i9 && bArr[i7] == bArr[i8]) {
            i7++;
            i8++;
        }
        if (i7 < i5) {
            if (i8 >= i9) {
                return 1;
            }
            i6 = bArr[i7] & 255;
            b = bArr[i8];
        } else {
            if (i8 == i9) {
                return 1;
            }
            int i10 = i7 % i5;
            int i11 = iArr[i] + 2;
            while (i10 < i11 && i8 < i9 && bArr[i10] == bArr[i8]) {
                i10++;
                i8++;
            }
            if (i10 >= i11) {
                return i8 < i9 ? -1 : 0;
            }
            if (i8 >= i9) {
                return 1;
            }
            i6 = bArr[i10] & 255;
            b = bArr[i8];
        }
        return i6 - (b & 255);
    }

    private void ssInsertionSort(int i, int i2, int i3, int i4) {
        int iSsCompare;
        int[] iArr = this.SA;
        for (int i5 = i3 - 2; i2 <= i5; i5--) {
            int i6 = iArr[i5];
            int i7 = i5 + 1;
            do {
                iSsCompare = ssCompare(i + i6, iArr[i7] + i, i4);
                if (iSsCompare <= 0) {
                    break;
                }
                do {
                    iArr[i7 - 1] = iArr[i7];
                    i7++;
                    if (i7 >= i3) {
                        break;
                    }
                } while (iArr[i7] < 0);
            } while (i3 > i7);
            if (iSsCompare == 0) {
                iArr[i7] = iArr[i7] ^ (-1);
            }
            iArr[i7 - 1] = i6;
        }
    }

    private void ssFixdown(int i, int i2, int i3, int i4, int i5) {
        int[] iArr = this.SA;
        byte[] bArr = this.T;
        int i6 = iArr[i3 + i4];
        int i7 = bArr[iArr[i2 + i6] + i] & 255;
        while (true) {
            int i8 = (i4 * 2) + 1;
            if (i8 >= i5) {
                break;
            }
            int i9 = i8 + 1;
            int i10 = bArr[iArr[iArr[i3 + i8] + i2] + i] & 255;
            int i11 = bArr[iArr[iArr[i3 + i9] + i2] + i] & 255;
            if (i10 < i11) {
                i8 = i9;
                i10 = i11;
            }
            if (i10 <= i7) {
                break;
            }
            iArr[i4 + i3] = iArr[i3 + i8];
            i4 = i8;
        }
        iArr[i3 + i4] = i6;
    }

    private void ssHeapSort(int i, int i2, int i3, int i4) {
        int i5;
        int[] iArr = this.SA;
        byte[] bArr = this.T;
        int i6 = i4 % 2;
        if (i6 == 0) {
            int i7 = i4 - 1;
            int i8 = (i7 / 2) + i3;
            int i9 = i3 + i7;
            if ((bArr[iArr[iArr[i8] + i2] + i] & 255) < (bArr[iArr[iArr[i9] + i2] + i] & 255)) {
                swapElements(iArr, i9, iArr, i8);
            }
            i5 = i7;
        } else {
            i5 = i4;
        }
        for (int i10 = (i5 / 2) - 1; i10 >= 0; i10--) {
            ssFixdown(i, i2, i3, i10, i5);
        }
        if (i6 == 0) {
            swapElements(iArr, i3, iArr, i3 + i5);
            ssFixdown(i, i2, i3, 0, i5);
        }
        for (int i11 = i5 - 1; i11 > 0; i11--) {
            int i12 = iArr[i3];
            int i13 = i3 + i11;
            iArr[i3] = iArr[i13];
            ssFixdown(i, i2, i3, 0, i11);
            iArr[i13] = i12;
        }
    }

    private int ssMedian3(int i, int i2, int i3, int i4, int i5) {
        int[] iArr = this.SA;
        byte[] bArr = this.T;
        int i6 = bArr[iArr[iArr[i3] + i2] + i] & 255;
        int i7 = bArr[iArr[iArr[i4] + i2] + i] & 255;
        int i8 = bArr[i + iArr[i2 + iArr[i5]]] & 255;
        if (i6 <= i7) {
            i4 = i3;
            i3 = i4;
            i7 = i6;
            i6 = i7;
        }
        return i6 > i8 ? i7 > i8 ? i4 : i5 : i3;
    }

    private int ssMedian5(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int[] iArr = this.SA;
        byte[] bArr = this.T;
        int i15 = bArr[iArr[iArr[i3] + i2] + i] & 255;
        int i16 = bArr[iArr[iArr[i4] + i2] + i] & 255;
        int i17 = bArr[iArr[iArr[i5] + i2] + i] & 255;
        int i18 = bArr[iArr[iArr[i6] + i2] + i] & 255;
        int i19 = bArr[iArr[iArr[i7] + i2] + i] & 255;
        if (i16 > i17) {
            i8 = i5;
            i9 = i16;
            i16 = i17;
            i10 = i4;
        } else {
            i8 = i4;
            i9 = i17;
            i10 = i5;
        }
        if (i18 > i19) {
            i11 = i7;
            i12 = i18;
            i13 = i6;
        } else {
            i11 = i6;
            i12 = i19;
            i19 = i18;
            i13 = i7;
        }
        if (i16 > i19) {
            i11 = i8;
            i19 = i16;
            int i20 = i13;
            i13 = i10;
            i10 = i20;
        } else {
            int i21 = i12;
            i12 = i9;
            i9 = i21;
        }
        if (i15 > i12) {
            i14 = i3;
        } else {
            i14 = i10;
            i10 = i3;
            int i22 = i12;
            i12 = i15;
            i15 = i22;
        }
        if (i12 > i19) {
            i11 = i10;
            i14 = i13;
            i15 = i9;
        } else {
            i12 = i19;
        }
        return i15 > i12 ? i11 : i14;
    }

    private int ssPivot(int i, int i2, int i3, int i4) {
        int i5 = i4 - i3;
        int i6 = i3 + (i5 / 2);
        if (i5 <= 512) {
            if (i5 <= 32) {
                return ssMedian3(i, i2, i3, i6, i4 - 1);
            }
            int i7 = i5 >> 2;
            int i8 = i4 - 1;
            return ssMedian5(i, i2, i3, i3 + i7, i6, i8 - i7, i8);
        }
        int i9 = i5 >> 3;
        int i10 = i9 << 1;
        int i11 = i4 - 1;
        return ssMedian3(i, i2, ssMedian3(i, i2, i3, i3 + i9, i3 + i10), ssMedian3(i, i2, i6 - i9, i6, i6 + i9), ssMedian3(i, i2, i11 - i10, i11 - i9, i11));
    }

    private static int ssLog(int i) {
        return (65280 & i) != 0 ? LOG_2_TABLE[(i >> 8) & 255] + 8 : LOG_2_TABLE[i & 255];
    }

    private int ssSubstringPartition(int i, int i2, int i3, int i4) {
        int[] iArr = this.SA;
        int i5 = i2 - 1;
        while (true) {
            i5++;
            if (i5 < i3 && iArr[iArr[i5] + i] + i4 >= iArr[iArr[i5] + i + 1] + 1) {
                iArr[i5] = iArr[i5] ^ (-1);
            } else {
                do {
                    i3--;
                    if (i5 >= i3) {
                        break;
                    }
                } while (iArr[iArr[i3] + i] + i4 < iArr[iArr[i3] + i + 1] + 1);
                if (i3 <= i5) {
                    break;
                }
                int i6 = iArr[i3] ^ (-1);
                iArr[i3] = iArr[i5];
                iArr[i5] = i6;
            }
        }
        if (i2 < i5) {
            iArr[i2] = iArr[i2] ^ (-1);
        }
        return i5;
    }

    static class StackEntry {
        final int a;
        final int b;
        final int c;
        final int d;

        StackEntry(int i, int i2, int i3, int i4) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:68:0x0149  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:80:0x0178 -> B:65:0x0141). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void ssMultiKeyIntroSort(int r21, int r22, int r23, int r24) {
        /*
            Method dump skipped, instructions count: 697
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.compression.Bzip2DivSufSort.ssMultiKeyIntroSort(int, int, int, int):void");
    }

    private static void ssBlockSwap(int[] iArr, int i, int[] iArr2, int i2, int i3) {
        while (i3 > 0) {
            swapElements(iArr, i, iArr2, i2);
            i3--;
            i++;
            i2++;
        }
    }

    private void ssMergeForward(int i, int[] iArr, int i2, int i3, int i4, int i5, int i6) {
        int i7;
        int[] iArr2 = this.SA;
        int i8 = i4 - i3;
        int i9 = (i2 + i8) - 1;
        ssBlockSwap(iArr, i2, iArr2, i3, i8);
        int i10 = iArr2[i3];
        while (true) {
            int iSsCompare = ssCompare(iArr[i2] + i, iArr2[i4] + i, i6);
            if (iSsCompare < 0) {
                while (true) {
                    i7 = i3 + 1;
                    iArr2[i3] = iArr[i2];
                    if (i9 <= i2) {
                        iArr[i2] = i10;
                        return;
                    }
                    int i11 = i2 + 1;
                    iArr[i2] = iArr2[i7];
                    if (iArr[i11] >= 0) {
                        i2 = i11;
                        break;
                    } else {
                        i2 = i11;
                        i3 = i7;
                    }
                }
            } else if (iSsCompare > 0) {
                while (true) {
                    i7 = i3 + 1;
                    iArr2[i3] = iArr2[i4];
                    int i12 = i4 + 1;
                    iArr2[i4] = iArr2[i7];
                    if (i5 <= i12) {
                        while (i2 < i9) {
                            int i13 = i7 + 1;
                            iArr2[i7] = iArr[i2];
                            iArr[i2] = iArr2[i13];
                            i7 = i13;
                            i2++;
                        }
                        iArr2[i7] = iArr[i2];
                        iArr[i2] = i10;
                        return;
                    }
                    if (iArr2[i12] >= 0) {
                        i4 = i12;
                        break;
                    } else {
                        i4 = i12;
                        i3 = i7;
                    }
                }
            } else {
                iArr2[i4] = iArr2[i4] ^ (-1);
                while (true) {
                    int i14 = i3 + 1;
                    iArr2[i3] = iArr[i2];
                    if (i9 <= i2) {
                        iArr[i2] = i10;
                        return;
                    }
                    int i15 = i2 + 1;
                    iArr[i2] = iArr2[i14];
                    if (iArr[i15] >= 0) {
                        while (true) {
                            int i16 = i14 + 1;
                            iArr2[i14] = iArr2[i4];
                            int i17 = i4 + 1;
                            iArr2[i4] = iArr2[i16];
                            if (i5 <= i17) {
                                while (i15 < i9) {
                                    int i18 = i16 + 1;
                                    iArr2[i16] = iArr[i15];
                                    iArr[i15] = iArr2[i18];
                                    i15++;
                                    i16 = i18;
                                }
                                iArr2[i16] = iArr[i15];
                                iArr[i15] = i10;
                                return;
                            }
                            if (iArr2[i17] >= 0) {
                                i4 = i17;
                                i3 = i16;
                                i2 = i15;
                                break;
                            }
                            i4 = i17;
                            i14 = i16;
                        }
                    } else {
                        i2 = i15;
                        i3 = i14;
                    }
                }
            }
            i3 = i7;
        }
    }

    private void ssMergeBackward(int i, int[] iArr, int i2, int i3, int i4, int i5, int i6) {
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int[] iArr2 = this.SA;
        int i23 = i5 - i4;
        ssBlockSwap(iArr, i2, iArr2, i4, i23);
        int i24 = (i2 + i23) - 1;
        if (iArr[i24] < 0) {
            i7 = (iArr[i24] ^ (-1)) + i;
            i8 = 1;
        } else {
            i7 = iArr[i24] + i;
            i8 = 0;
        }
        int i25 = i4 - 1;
        if (iArr2[i25] < 0) {
            i8 |= 2;
            i9 = iArr2[i25] ^ (-1);
        } else {
            i9 = iArr2[i25];
        }
        int i26 = i9 + i;
        int i27 = i5 - 1;
        int i28 = iArr2[i27];
        while (true) {
            int iSsCompare = ssCompare(i7, i26, i6);
            if (iSsCompare > 0) {
                if ((i8 & 1) != 0) {
                    while (true) {
                        i11 = i27 - 1;
                        iArr2[i27] = iArr[i24];
                        i12 = i24 - 1;
                        iArr[i24] = iArr2[i11];
                        if (iArr[i12] >= 0) {
                            break;
                        }
                        i24 = i12;
                        i27 = i11;
                    }
                    i8 ^= 1;
                    i24 = i12;
                    i27 = i11;
                }
                int i29 = i27 - 1;
                iArr2[i27] = iArr[i24];
                if (i24 <= i2) {
                    iArr[i24] = i28;
                    return;
                }
                int i30 = i24 - 1;
                iArr[i24] = iArr2[i29];
                if (iArr[i30] < 0) {
                    i8 |= 1;
                    i10 = iArr[i30] ^ (-1);
                } else {
                    i10 = iArr[i30];
                }
                int i31 = i10 + i;
                i24 = i30;
                i27 = i29;
                i7 = i31;
            } else {
                if (iSsCompare < 0) {
                    if ((i8 & 2) != 0) {
                        while (true) {
                            i21 = i27 - 1;
                            iArr2[i27] = iArr2[i25];
                            i22 = i25 - 1;
                            iArr2[i25] = iArr2[i21];
                            if (iArr2[i22] >= 0) {
                                break;
                            }
                            i25 = i22;
                            i27 = i21;
                        }
                        i8 ^= 2;
                        i25 = i22;
                        i27 = i21;
                    }
                    int i32 = i27 - 1;
                    iArr2[i27] = iArr2[i25];
                    int i33 = i25 - 1;
                    iArr2[i25] = iArr2[i32];
                    if (i33 < i3) {
                        while (i2 < i24) {
                            int i34 = i32 - 1;
                            iArr2[i32] = iArr[i24];
                            iArr[i24] = iArr2[i34];
                            i32 = i34;
                            i24--;
                        }
                        iArr2[i32] = iArr[i24];
                        iArr[i24] = i28;
                        return;
                    }
                    if (iArr2[i33] < 0) {
                        i8 |= 2;
                        i20 = iArr2[i33] ^ (-1);
                    } else {
                        i20 = iArr2[i33];
                    }
                    i16 = i32;
                    i26 = i20 + i;
                    i25 = i33;
                } else {
                    if ((i8 & 1) != 0) {
                        while (true) {
                            i18 = i27 - 1;
                            iArr2[i27] = iArr[i24];
                            i19 = i24 - 1;
                            iArr[i24] = iArr2[i18];
                            if (iArr[i19] >= 0) {
                                break;
                            }
                            i24 = i19;
                            i27 = i18;
                        }
                        i8 ^= 1;
                        i24 = i19;
                        i27 = i18;
                    }
                    int i35 = i27 - 1;
                    iArr2[i27] = iArr[i24] ^ (-1);
                    if (i24 <= i2) {
                        iArr[i24] = i28;
                        return;
                    }
                    int i36 = i24 - 1;
                    iArr[i24] = iArr2[i35];
                    if ((i8 & 2) != 0) {
                        while (true) {
                            i13 = i35 - 1;
                            iArr2[i35] = iArr2[i25];
                            i17 = i25 - 1;
                            iArr2[i25] = iArr2[i13];
                            if (iArr2[i17] >= 0) {
                                break;
                            }
                            i25 = i17;
                            i35 = i13;
                        }
                        i8 ^= 2;
                        i25 = i17;
                    } else {
                        i13 = i35;
                    }
                    int i37 = i13 - 1;
                    iArr2[i13] = iArr2[i25];
                    int i38 = i25 - 1;
                    iArr2[i25] = iArr2[i37];
                    if (i38 < i3) {
                        while (i2 < i36) {
                            int i39 = i37 - 1;
                            iArr2[i37] = iArr[i36];
                            iArr[i36] = iArr2[i39];
                            i37 = i39;
                            i36--;
                        }
                        iArr2[i37] = iArr[i36];
                        iArr[i36] = i28;
                        return;
                    }
                    if (iArr[i36] < 0) {
                        i8 |= 1;
                        i14 = (iArr[i36] ^ (-1)) + i;
                    } else {
                        i14 = iArr[i36] + i;
                    }
                    if (iArr2[i38] < 0) {
                        i8 |= 2;
                        i15 = iArr2[i38] ^ (-1);
                    } else {
                        i15 = iArr2[i38];
                    }
                    i26 = i15 + i;
                    i16 = i37;
                    i7 = i14;
                    i25 = i38;
                    i24 = i36;
                }
                i27 = i16;
            }
        }
    }

    private void ssMergeCheckEqual(int i, int i2, int i3) {
        int[] iArr = this.SA;
        if (iArr[i3] < 0 || ssCompare(getIDX(iArr[i3 - 1]) + i, i + iArr[i3], i2) != 0) {
            return;
        }
        iArr[i3] = iArr[i3] ^ (-1);
    }

    private void ssMerge(int i, int i2, int i3, int i4, int[] iArr, int i5, int i6, int i7) {
        int i8;
        int i9;
        int i10;
        int i11;
        int[] iArr2 = this.SA;
        StackEntry[] stackEntryArr = new StackEntry[64];
        int i12 = i2;
        int i13 = i3;
        int i14 = i4;
        int i15 = 0;
        int i16 = 0;
        while (true) {
            int i17 = i14 - i13;
            if (i17 <= i6) {
                if (i12 >= i13 || i13 >= i14) {
                    i8 = i12;
                } else {
                    i8 = i12;
                    ssMergeBackward(i, iArr, i5, i12, i13, i14, i7);
                }
                if ((i15 & 1) != 0) {
                    ssMergeCheckEqual(i, i7, i8);
                }
                if ((i15 & 2) != 0) {
                    ssMergeCheckEqual(i, i7, i14);
                }
                if (i16 == 0) {
                    return;
                }
                i16--;
                StackEntry stackEntry = stackEntryArr[i16];
                i12 = stackEntry.a;
                i13 = stackEntry.b;
                i14 = stackEntry.c;
                i9 = stackEntry.d;
            } else {
                int i18 = i12;
                int i19 = i13 - i18;
                if (i19 <= i6) {
                    if (i18 < i13) {
                        ssMergeForward(i, iArr, i5, i18, i13, i14, i7);
                    }
                    if ((i15 & 1) != 0) {
                        ssMergeCheckEqual(i, i7, i18);
                    }
                    if ((i15 & 2) != 0) {
                        ssMergeCheckEqual(i, i7, i14);
                    }
                    if (i16 == 0) {
                        return;
                    }
                    i16--;
                    StackEntry stackEntry2 = stackEntryArr[i16];
                    i12 = stackEntry2.a;
                    i13 = stackEntry2.b;
                    i14 = stackEntry2.c;
                    i9 = stackEntry2.d;
                } else {
                    int iMin = Math.min(i19, i17);
                    int i20 = iMin >> 1;
                    int i21 = 0;
                    while (iMin > 0) {
                        if (ssCompare(getIDX(iArr2[i13 + i21 + i20]) + i, getIDX(iArr2[((i13 - i21) - i20) - 1]) + i, i7) < 0) {
                            i21 += i20 + 1;
                            i20 -= (iMin & 1) ^ 1;
                        }
                        iMin = i20;
                        i20 = iMin >> 1;
                    }
                    if (i21 > 0) {
                        int i22 = i13 - i21;
                        ssBlockSwap(iArr2, i22, iArr2, i13, i21);
                        int i23 = i21 + i13;
                        if (i23 < i14) {
                            if (iArr2[i23] < 0) {
                                i10 = i13;
                                while (iArr2[i10 - 1] < 0) {
                                    i10--;
                                }
                                iArr2[i23] = iArr2[i23] ^ (-1);
                            } else {
                                i10 = i13;
                            }
                            int i24 = i13;
                            while (iArr2[i24] < 0) {
                                i24++;
                            }
                            i12 = i24;
                            i11 = 1;
                        } else {
                            i10 = i13;
                            i12 = i10;
                            i11 = 0;
                        }
                        if (i10 - i18 <= i14 - i12) {
                            stackEntryArr[i16] = new StackEntry(i12, i23, i14, (i11 & 1) | (i15 & 2));
                            i15 &= 1;
                            i13 = i22;
                            i14 = i10;
                            i16++;
                            i12 = i18;
                        } else {
                            if (i10 == i13 && i13 == i12) {
                                i11 <<= 1;
                            }
                            stackEntryArr[i16] = new StackEntry(i18, i22, i10, (i15 & 1) | (i11 & 2));
                            i15 = (i15 & 2) | (1 & i11);
                            i13 = i23;
                            i16++;
                        }
                    } else {
                        if ((i15 & 1) != 0) {
                            ssMergeCheckEqual(i, i7, i18);
                        }
                        ssMergeCheckEqual(i, i7, i13);
                        if ((i15 & 2) != 0) {
                            ssMergeCheckEqual(i, i7, i14);
                        }
                        if (i16 == 0) {
                            return;
                        }
                        i16--;
                        StackEntry stackEntry3 = stackEntryArr[i16];
                        i12 = stackEntry3.a;
                        i13 = stackEntry3.b;
                        i14 = stackEntry3.c;
                        i9 = stackEntry3.d;
                    }
                }
            }
            i15 = i9;
        }
    }

    private void subStringSort(int i, int i2, int i3, int[] iArr, int i4, int i5, int i6, boolean z, int i7) {
        int i8;
        int i9;
        int[] iArr2;
        int[] iArr3 = this.SA;
        int i10 = z ? i2 + 1 : i2;
        int i11 = i10;
        int i12 = 0;
        while (true) {
            int i13 = i11 + 1024;
            if (i13 >= i3) {
                break;
            }
            ssMultiKeyIntroSort(i, i11, i13, i6);
            int i14 = i3 - i13;
            if (i14 <= i5) {
                iArr2 = iArr;
                i9 = i4;
                i8 = i5;
            } else {
                i8 = i14;
                i9 = i13;
                iArr2 = iArr3;
            }
            int i15 = i11;
            int i16 = i12;
            int i17 = 1024;
            while ((i16 & 1) != 0) {
                int i18 = i15 - i17;
                ssMerge(i, i18, i15, i15 + i17, iArr2, i9, i8, i6);
                i17 <<= 1;
                i16 >>>= 1;
                i15 = i18;
                i13 = i13;
            }
            i12++;
            i11 = i13;
        }
        ssMultiKeyIntroSort(i, i11, i3, i6);
        int i19 = i11;
        int i20 = 1024;
        while (i12 != 0) {
            if ((i12 & 1) != 0) {
                int i21 = i19 - i20;
                ssMerge(i, i21, i19, i3, iArr, i4, i5, i6);
                i19 = i21;
            }
            i20 <<= 1;
            i12 >>= 1;
        }
        if (z) {
            int i22 = iArr3[i10 - 1];
            int iSsCompareLast = 1;
            while (i10 < i3 && (iArr3[i10] < 0 || (iSsCompareLast = ssCompareLast(i, i + i22, i + iArr3[i10], i6, i7)) > 0)) {
                iArr3[i10 - 1] = iArr3[i10];
                i10++;
            }
            if (iSsCompareLast == 0) {
                iArr3[i10] = iArr3[i10] ^ (-1);
            }
            iArr3[i10 - 1] = i22;
        }
    }

    private int trGetC(int i, int i2, int i3, int i4) {
        int i5 = i2 + i4;
        return i5 < i3 ? this.SA[i5] : this.SA[i + (((i2 - i) + i4) % (i3 - i))];
    }

    private void trFixdown(int i, int i2, int i3, int i4, int i5, int i6) {
        int[] iArr = this.SA;
        int i7 = iArr[i4 + i5];
        int iTrGetC = trGetC(i, i2, i3, i7);
        while (true) {
            int i8 = (i5 * 2) + 1;
            if (i8 >= i6) {
                break;
            }
            int i9 = i8 + 1;
            int iTrGetC2 = trGetC(i, i2, i3, iArr[i4 + i8]);
            int iTrGetC3 = trGetC(i, i2, i3, iArr[i4 + i9]);
            if (iTrGetC2 < iTrGetC3) {
                i8 = i9;
                iTrGetC2 = iTrGetC3;
            }
            if (iTrGetC2 <= iTrGetC) {
                break;
            }
            iArr[i5 + i4] = iArr[i4 + i8];
            i5 = i8;
        }
        iArr[i4 + i5] = i7;
    }

    private void trHeapSort(int i, int i2, int i3, int i4, int i5) {
        int i6;
        int[] iArr = this.SA;
        int i7 = i5 % 2;
        if (i7 == 0) {
            int i8 = i5 - 1;
            int i9 = (i8 / 2) + i4;
            int i10 = i4 + i8;
            if (trGetC(i, i2, i3, iArr[i9]) < trGetC(i, i2, i3, iArr[i10])) {
                swapElements(iArr, i10, iArr, i9);
            }
            i6 = i8;
        } else {
            i6 = i5;
        }
        for (int i11 = (i6 / 2) - 1; i11 >= 0; i11--) {
            trFixdown(i, i2, i3, i4, i11, i6);
        }
        if (i7 == 0) {
            swapElements(iArr, i4, iArr, i4 + i6);
            trFixdown(i, i2, i3, i4, 0, i6);
        }
        for (int i12 = i6 - 1; i12 > 0; i12--) {
            int i13 = iArr[i4];
            int i14 = i4 + i12;
            iArr[i4] = iArr[i14];
            trFixdown(i, i2, i3, i4, 0, i12);
            iArr[i14] = i13;
        }
    }

    private void trInsertionSort(int i, int i2, int i3, int i4, int i5) {
        int iTrGetC;
        int[] iArr = this.SA;
        for (int i6 = i4 + 1; i6 < i5; i6++) {
            int i7 = iArr[i6];
            int i8 = i6 - 1;
            do {
                iTrGetC = trGetC(i, i2, i3, i7) - trGetC(i, i2, i3, iArr[i8]);
                if (iTrGetC >= 0) {
                    break;
                }
                do {
                    iArr[i8 + 1] = iArr[i8];
                    i8--;
                    if (i4 > i8) {
                        break;
                    }
                } while (iArr[i8] < 0);
            } while (i8 >= i4);
            if (iTrGetC == 0) {
                iArr[i8] = iArr[i8] ^ (-1);
            }
            iArr[i8 + 1] = i7;
        }
    }

    private static int trLog(int i) {
        return ((-65536) & i) != 0 ? ((-16777216) & i) != 0 ? LOG_2_TABLE[(i >> 24) & 255] + 24 : LOG_2_TABLE[(i >> 16) & 271] : (65280 & i) != 0 ? LOG_2_TABLE[(i >> 8) & 255] + 8 : LOG_2_TABLE[i & 255];
    }

    private int trMedian3(int i, int i2, int i3, int i4, int i5, int i6) {
        int[] iArr = this.SA;
        int iTrGetC = trGetC(i, i2, i3, iArr[i4]);
        int iTrGetC2 = trGetC(i, i2, i3, iArr[i5]);
        int iTrGetC3 = trGetC(i, i2, i3, iArr[i6]);
        if (iTrGetC <= iTrGetC2) {
            i5 = i4;
            i4 = i5;
            iTrGetC2 = iTrGetC;
            iTrGetC = iTrGetC2;
        }
        return iTrGetC > iTrGetC3 ? iTrGetC2 > iTrGetC3 ? i5 : i6 : i4;
    }

    private int trMedian5(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int[] iArr = this.SA;
        int iTrGetC = trGetC(i, i2, i3, iArr[i4]);
        int iTrGetC2 = trGetC(i, i2, i3, iArr[i5]);
        int iTrGetC3 = trGetC(i, i2, i3, iArr[i6]);
        int iTrGetC4 = trGetC(i, i2, i3, iArr[i7]);
        int iTrGetC5 = trGetC(i, i2, i3, iArr[i8]);
        if (iTrGetC2 > iTrGetC3) {
            i6 = i5;
            i5 = i6;
            iTrGetC3 = iTrGetC2;
            iTrGetC2 = iTrGetC3;
        }
        if (iTrGetC4 <= iTrGetC5) {
            iTrGetC4 = iTrGetC5;
            iTrGetC5 = iTrGetC4;
            i8 = i7;
            i7 = i8;
        }
        if (iTrGetC2 > iTrGetC5) {
            iTrGetC5 = iTrGetC2;
            int i9 = i7;
            i7 = i6;
            i6 = i9;
            int i10 = iTrGetC4;
            iTrGetC4 = iTrGetC3;
            iTrGetC3 = i10;
        } else {
            i5 = i8;
        }
        if (iTrGetC > iTrGetC3) {
            int i11 = i6;
            i6 = i4;
            i4 = i11;
            int i12 = iTrGetC3;
            iTrGetC3 = iTrGetC;
            iTrGetC = i12;
        }
        if (iTrGetC > iTrGetC5) {
            i6 = i7;
            iTrGetC5 = iTrGetC;
            iTrGetC3 = iTrGetC4;
        } else {
            i4 = i5;
        }
        return iTrGetC3 > iTrGetC5 ? i4 : i6;
    }

    private int trPivot(int i, int i2, int i3, int i4, int i5) {
        int i6 = i5 - i4;
        int i7 = i4 + (i6 / 2);
        if (i6 <= 512) {
            if (i6 <= 32) {
                return trMedian3(i, i2, i3, i4, i7, i5 - 1);
            }
            int i8 = i6 >> 2;
            int i9 = i5 - 1;
            return trMedian5(i, i2, i3, i4, i4 + i8, i7, i9 - i8, i9);
        }
        int i10 = i6 >> 3;
        int i11 = i10 << 1;
        int i12 = i5 - 1;
        return trMedian3(i, i2, i3, trMedian3(i, i2, i3, i4, i4 + i10, i4 + i11), trMedian3(i, i2, i3, i7 - i10, i7, i7 + i10), trMedian3(i, i2, i3, i12 - i11, i12 - i10, i12));
    }

    private void lsUpdateGroup(int i, int i2, int i3) {
        int[] iArr = this.SA;
        while (i2 < i3) {
            if (iArr[i2] >= 0) {
                int i4 = i2;
                do {
                    iArr[iArr[i4] + i] = i4;
                    i4++;
                    if (i4 >= i3) {
                        break;
                    }
                } while (iArr[i4] >= 0);
                iArr[i2] = i2 - i4;
                if (i3 <= i4) {
                    return;
                } else {
                    i2 = i4;
                }
            }
            int i5 = i2;
            do {
                iArr[i5] = iArr[i5] ^ (-1);
                i5++;
            } while (iArr[i5] < 0);
            do {
                iArr[iArr[i2] + i] = i5;
                i2++;
            } while (i2 <= i5);
            i2 = i5 + 1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:121:0x01bf A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0134 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0104  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:71:0x0128 -> B:56:0x00fc). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void lsIntroSort(int r21, int r22, int r23, int r24, int r25) {
        /*
            Method dump skipped, instructions count: 463
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.compression.Bzip2DivSufSort.lsIntroSort(int, int, int, int, int):void");
    }

    private void lsSort(int i, int i2, int i3) {
        int i4;
        int[] iArr = this.SA;
        int i5 = i3 + i;
        while (true) {
            int i6 = 0;
            if ((-i2) >= iArr[0]) {
                return;
            }
            int i7 = 0;
            int i8 = 0;
            do {
                int i9 = iArr[i8];
                if (i9 < 0) {
                    i8 -= i9;
                    i7 += i9;
                } else {
                    if (i7 != 0) {
                        iArr[i8 + i7] = i7;
                        i4 = 0;
                    } else {
                        i4 = i7;
                    }
                    int i10 = iArr[i9 + i] + 1;
                    lsIntroSort(i, i5, i + i2, i8, i10);
                    i7 = i4;
                    i8 = i10;
                }
            } while (i8 < i2);
            if (i7 != 0) {
                iArr[i8 + i7] = i7;
            }
            int i11 = i5 - i;
            if (i2 < i11) {
                do {
                    int i12 = iArr[i6];
                    if (i12 < 0) {
                        i6 -= i12;
                    } else {
                        int i13 = iArr[i12 + i] + 1;
                        while (i6 < i13) {
                            iArr[iArr[i6] + i] = i6;
                            i6++;
                        }
                        i6 = i13;
                    }
                } while (i6 < i2);
                return;
            }
            i5 += i11;
        }
    }

    static class PartitionResult {
        final int first;
        final int last;

        PartitionResult(int i, int i2) {
            this.first = i;
            this.last = i2;
        }
    }

    private PartitionResult trPartition(int i, int i2, int i3, int i4, int i5, int i6) {
        int i7;
        int i8;
        int iTrGetC;
        int iTrGetC2;
        int iTrGetC3;
        int[] iArr = this.SA;
        int i9 = i4;
        int iTrGetC4 = 0;
        while (i9 < i5) {
            iTrGetC4 = trGetC(i, i2, i3, iArr[i9]);
            if (iTrGetC4 != i6) {
                break;
            }
            i9++;
        }
        if (i9 >= i5 || iTrGetC4 >= i6) {
            i7 = i9;
        } else {
            i7 = i9;
            while (true) {
                i9++;
                if (i9 >= i5 || (iTrGetC4 = trGetC(i, i2, i3, iArr[i9])) > i6) {
                    break;
                }
                if (iTrGetC4 == i6) {
                    swapElements(iArr, i9, iArr, i7);
                    i7++;
                }
            }
        }
        int i10 = i5 - 1;
        while (i9 < i10) {
            iTrGetC4 = trGetC(i, i2, i3, iArr[i10]);
            if (iTrGetC4 != i6) {
                break;
            }
            i10--;
        }
        if (i9 >= i10 || iTrGetC4 <= i6) {
            i8 = i10;
        } else {
            i8 = i10;
            while (true) {
                i10--;
                if (i9 >= i10 || (iTrGetC3 = trGetC(i, i2, i3, iArr[i10])) < i6) {
                    break;
                }
                if (iTrGetC3 == i6) {
                    swapElements(iArr, i10, iArr, i8);
                    i8--;
                }
            }
        }
        while (i9 < i10) {
            swapElements(iArr, i9, iArr, i10);
            while (true) {
                i9++;
                if (i9 >= i10 || (iTrGetC2 = trGetC(i, i2, i3, iArr[i9])) > i6) {
                    break;
                }
                if (iTrGetC2 == i6) {
                    swapElements(iArr, i9, iArr, i7);
                    i7++;
                }
            }
            while (true) {
                i10--;
                if (i9 >= i10 || (iTrGetC = trGetC(i, i2, i3, iArr[i10])) < i6) {
                    break;
                }
                if (iTrGetC == i6) {
                    swapElements(iArr, i10, iArr, i8);
                    i8--;
                }
            }
        }
        if (i7 <= i8) {
            int i11 = i9 - 1;
            int i12 = i7 - i4;
            int i13 = i9 - i7;
            if (i12 > i13) {
                i12 = i13;
            }
            int i14 = i9 - i12;
            int i15 = i4;
            while (i12 > 0) {
                swapElements(iArr, i15, iArr, i14);
                i12--;
                i15++;
                i14++;
            }
            int i16 = i8 - i11;
            int i17 = (i5 - i8) - 1;
            if (i16 <= i17) {
                i17 = i16;
            }
            int i18 = i5 - i17;
            while (i17 > 0) {
                swapElements(iArr, i9, iArr, i18);
                i17--;
                i9++;
                i18++;
            }
            i4 += i13;
            i5 -= i16;
        }
        return new PartitionResult(i4, i5);
    }

    private void trCopy(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        int[] iArr = this.SA;
        int i8 = i5 - 1;
        int i9 = i4 - 1;
        while (i3 <= i9) {
            int i10 = iArr[i3] - i7;
            if (i10 < 0) {
                i10 += i2 - i;
            }
            int i11 = i + i10;
            if (iArr[i11] == i8) {
                i9++;
                iArr[i9] = i10;
                iArr[i11] = i9;
            }
            i3++;
        }
        int i12 = i6 - 1;
        int i13 = i9 + 1;
        while (i13 < i5) {
            int i14 = iArr[i12] - i7;
            if (i14 < 0) {
                i14 += i2 - i;
            }
            int i15 = i + i14;
            if (iArr[i15] == i8) {
                i5--;
                iArr[i5] = i14;
                iArr[i15] = i5;
            }
            i12--;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:90:0x020d, code lost:
    
        r8 = r23;
     */
    /* JADX WARN: Removed duplicated region for block: B:139:0x02e4  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:151:0x0309 -> B:136:0x02dc). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void trIntroSort(int r24, int r25, int r26, int r27, int r28, io.netty.handler.codec.compression.Bzip2DivSufSort.TRBudget r29, int r30) {
        /*
            Method dump skipped, instructions count: 1333
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.compression.Bzip2DivSufSort.trIntroSort(int, int, int, int, int, io.netty.handler.codec.compression.Bzip2DivSufSort$TRBudget, int):void");
    }

    static class TRBudget {
        int budget;
        int chance;

        TRBudget(int i, int i2) {
            this.budget = i;
            this.chance = i2;
        }

        boolean update(int i, int i2) {
            this.budget -= i2;
            int i3 = this.budget;
            if (i3 <= 0) {
                int i4 = this.chance - 1;
                this.chance = i4;
                if (i4 == 0) {
                    return false;
                }
                this.budget = i3 + i;
            }
            return true;
        }
    }

    private void trSort(int i, int i2, int i3) {
        int[] iArr = this.SA;
        if ((-i2) < iArr[0]) {
            TRBudget tRBudget = new TRBudget(i2, ((trLog(i2) * 2) / 3) + 1);
            int i4 = 0;
            do {
                int i5 = iArr[i4];
                if (i5 < 0) {
                    i4 -= i5;
                } else {
                    int i6 = iArr[i + i5] + 1;
                    if (1 < i6 - i4) {
                        trIntroSort(i, i + i3, i + i2, i4, i6, tRBudget, i2);
                        if (tRBudget.chance == 0) {
                            if (i4 > 0) {
                                iArr[0] = -i4;
                            }
                            lsSort(i, i2, i3);
                            return;
                        }
                    }
                    i4 = i6;
                }
            } while (i4 < i2);
        }
    }

    private int sortTypeBstar(int[] iArr, int[] iArr2) {
        boolean z;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int[] iArr3;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        byte[] bArr = this.T;
        int[] iArr4 = this.SA;
        int i15 = this.n;
        int[] iArr5 = new int[256];
        int i16 = 1;
        while (true) {
            if (i16 >= i15) {
                break;
            }
            int i17 = i16 - 1;
            if (bArr[i17] != bArr[i16]) {
                z = (bArr[i17] & 255) <= (bArr[i16] & 255);
            } else {
                i16++;
            }
        }
        int i18 = i15 - 1;
        int i19 = bArr[i18] & 255;
        int i20 = bArr[0] & 255;
        if (i19 < i20 || (bArr[i18] == bArr[0] && z)) {
            if (!z) {
                int iBUCKET_BSTAR = BUCKET_BSTAR(i19, i20);
                iArr2[iBUCKET_BSTAR] = iArr2[iBUCKET_BSTAR] + 1;
                int i21 = i15 - 1;
                iArr4[i21] = i18;
                i = i21;
            } else {
                int iBUCKET_B = BUCKET_B(i19, i20);
                iArr2[iBUCKET_B] = iArr2[iBUCKET_B] + 1;
                i = i15;
            }
            i2 = i18;
            while (true) {
                i2--;
                if (i2 >= 0 && (i3 = bArr[i2] & 255) <= (i4 = bArr[i2 + 1] & 255)) {
                    int iBUCKET_B2 = BUCKET_B(i3, i4);
                    iArr2[iBUCKET_B2] = iArr2[iBUCKET_B2] + 1;
                }
            }
        } else {
            i = i15;
            i2 = i18;
        }
        while (i2 >= 0) {
            do {
                int i22 = bArr[i2] & 255;
                iArr[i22] = iArr[i22] + 1;
                i2--;
                if (i2 < 0) {
                    break;
                }
            } while ((bArr[i2] & 255) >= (bArr[i2 + 1] & 255));
            if (i2 >= 0) {
                int iBUCKET_BSTAR2 = BUCKET_BSTAR(bArr[i2] & 255, bArr[i2 + 1] & 255);
                iArr2[iBUCKET_BSTAR2] = iArr2[iBUCKET_BSTAR2] + 1;
                i--;
                iArr4[i] = i2;
                while (true) {
                    i2--;
                    if (i2 < 0 || (i13 = bArr[i2] & 255) > (i14 = bArr[i2 + 1] & 255)) {
                        break;
                    }
                    int iBUCKET_B3 = BUCKET_B(i13, i14);
                    iArr2[iBUCKET_B3] = iArr2[iBUCKET_B3] + 1;
                }
            }
        }
        int i23 = i15 - i;
        if (i23 == 0) {
            for (int i24 = 0; i24 < i15; i24++) {
                iArr4[i24] = i24;
            }
            return 0;
        }
        int i25 = 0;
        int i26 = -1;
        int i27 = 0;
        while (i25 < 256) {
            int i28 = iArr[i25] + i26;
            iArr[i25] = i26 + i27;
            int i29 = i28 + iArr2[BUCKET_B(i25, i25)];
            int i30 = i25 + 1;
            int i31 = i27;
            for (int i32 = i30; i32 < 256; i32++) {
                i31 += iArr2[BUCKET_BSTAR(i25, i32)];
                iArr2[(i25 << 8) | i32] = i31;
                i29 += iArr2[BUCKET_B(i25, i32)];
            }
            i25 = i30;
            i26 = i29;
            i27 = i31;
        }
        int i33 = i15 - i23;
        for (int i34 = i23 - 2; i34 >= 0; i34--) {
            int i35 = iArr4[i33 + i34];
            int iBUCKET_BSTAR3 = BUCKET_BSTAR(bArr[i35] & 255, bArr[i35 + 1] & 255);
            int i36 = iArr2[iBUCKET_BSTAR3] - 1;
            iArr2[iBUCKET_BSTAR3] = i36;
            iArr4[i36] = i34;
        }
        int i37 = iArr4[(i33 + i23) - 1];
        int iBUCKET_BSTAR4 = BUCKET_BSTAR(bArr[i37] & 255, bArr[i37 + 1] & 255);
        int i38 = iArr2[iBUCKET_BSTAR4] - 1;
        iArr2[iBUCKET_BSTAR4] = i38;
        int i39 = i23 - 1;
        iArr4[i38] = i39;
        int i40 = i15 - (i23 * 2);
        if (i40 <= 256) {
            iArr3 = iArr5;
            i6 = 0;
            i5 = 256;
        } else {
            i5 = i40;
            i6 = i23;
            iArr3 = iArr4;
        }
        int i41 = i23;
        int i42 = 255;
        while (i41 > 0) {
            int i43 = i41;
            int i44 = 255;
            while (i42 < i44) {
                int i45 = iArr2[BUCKET_BSTAR(i42, i44)];
                if (1 < i43 - i45) {
                    i9 = i44;
                    i10 = i42;
                    i11 = i39;
                    i12 = i23;
                    subStringSort(i33, i45, i43, iArr3, i6, i5, 2, iArr4[i45] == i39, i15);
                } else {
                    i9 = i44;
                    i10 = i42;
                    i11 = i39;
                    i12 = i23;
                }
                i44 = i9 - 1;
                i23 = i12;
                i43 = i45;
                i42 = i10;
                i39 = i11;
            }
            i42--;
            i41 = i43;
        }
        int i46 = i39;
        int i47 = i23;
        int i48 = i46;
        while (i48 >= 0) {
            if (iArr4[i48] >= 0) {
                int i49 = i48;
                do {
                    iArr4[i47 + iArr4[i49]] = i49;
                    i49--;
                    if (i49 < 0) {
                        break;
                    }
                } while (iArr4[i49] >= 0);
                iArr4[i49 + 1] = i49 - i48;
                if (i49 <= 0) {
                    break;
                }
                i48 = i49;
            }
            int i50 = i48;
            do {
                int i51 = iArr4[i50] ^ (-1);
                iArr4[i50] = i51;
                iArr4[i47 + i51] = i48;
                i50--;
            } while (iArr4[i50] < 0);
            iArr4[i47 + iArr4[i50]] = i48;
            i48 = i50 - 1;
        }
        trSort(i47, i47, 1);
        if ((bArr[i18] & 255) < (bArr[0] & 255) || (bArr[i18] == bArr[0] && z)) {
            if (z) {
                i7 = i47;
            } else {
                i7 = i47 - 1;
                iArr4[iArr4[i47 + i7]] = i18;
            }
            i8 = i18;
            do {
                i8--;
                if (i8 >= 0) {
                }
            } while ((bArr[i8] & 255) <= (bArr[i8 + 1] & 255));
        } else {
            i7 = i47;
            i8 = i18;
        }
        while (i8 >= 0) {
            do {
                i8--;
                if (i8 < 0) {
                    break;
                }
            } while ((bArr[i8] & 255) >= (bArr[i8 + 1] & 255));
            if (i8 >= 0) {
                i7--;
                iArr4[iArr4[i47 + i7]] = i8;
                do {
                    i8--;
                    if (i8 >= 0) {
                    }
                } while ((bArr[i8] & 255) <= (bArr[i8 + 1] & 255));
            }
        }
        for (int i52 = 255; i52 >= 0; i52--) {
            int i53 = 255;
            while (i52 < i53) {
                int i54 = i18 - iArr2[BUCKET_B(i52, i53)];
                iArr2[BUCKET_B(i52, i53)] = i18 + 1;
                int i55 = iArr2[BUCKET_BSTAR(i52, i53)];
                i18 = i54;
                int i56 = i46;
                while (i55 <= i56) {
                    iArr4[i18] = iArr4[i56];
                    i18--;
                    i56--;
                }
                i53--;
                i46 = i56;
            }
            int i57 = i18 - iArr2[BUCKET_B(i52, i52)];
            iArr2[BUCKET_B(i52, i52)] = i18 + 1;
            if (i52 < 255) {
                iArr2[BUCKET_BSTAR(i52, i52 + 1)] = i57 + 1;
            }
            i18 = iArr[i52];
        }
        return i47;
    }

    private int constructBWT(int[] iArr, int[] iArr2) {
        byte[] bArr = this.T;
        int[] iArr3 = this.SA;
        int i = this.n;
        int i2 = 254;
        int i3 = 0;
        int i4 = 0;
        while (i2 >= 0) {
            int i5 = i2 + 1;
            int i6 = iArr2[BUCKET_BSTAR(i2, i5)];
            int i7 = 0;
            int i8 = -1;
            for (int i9 = iArr[i5]; i6 <= i9; i9--) {
                int i10 = iArr3[i9];
                if (i10 >= 0) {
                    int i11 = i10 - 1;
                    if (i11 < 0) {
                        i11 = i - 1;
                    }
                    int i12 = bArr[i11] & 255;
                    if (i12 <= i2) {
                        iArr3[i9] = i10 ^ (-1);
                        if (i11 > 0 && (bArr[i11 - 1] & 255) > i12) {
                            i11 ^= -1;
                        }
                        if (i8 == i12) {
                            i7--;
                            iArr3[i7] = i11;
                        } else {
                            if (i8 >= 0) {
                                iArr2[BUCKET_B(i8, i2)] = i7;
                            }
                            i7 = iArr2[BUCKET_B(i12, i2)] - 1;
                            iArr3[i7] = i11;
                            i8 = i12;
                        }
                    }
                } else {
                    iArr3[i9] = i10 ^ (-1);
                }
            }
            i2--;
            i3 = i7;
            i4 = i8;
        }
        int i13 = -1;
        for (int i14 = 0; i14 < i; i14++) {
            int i15 = iArr3[i14];
            if (i15 >= 0) {
                int i16 = i15 - 1;
                if (i16 < 0) {
                    i16 = i - 1;
                }
                int i17 = bArr[i16] & 255;
                if (i17 >= (bArr[i16 + 1] & 255)) {
                    if (i16 > 0 && (bArr[i16 - 1] & 255) < i17) {
                        i16 ^= -1;
                    }
                    if (i17 == i4) {
                        i3++;
                        iArr3[i3] = i16;
                    } else {
                        if (i4 != -1) {
                            iArr[i4] = i3;
                        }
                        i3 = iArr[i17] + 1;
                        iArr3[i3] = i16;
                        i4 = i17;
                    }
                }
            } else {
                i15 ^= -1;
            }
            if (i15 == 0) {
                iArr3[i14] = bArr[i - 1];
                i13 = i14;
            } else {
                iArr3[i14] = bArr[i15 - 1];
            }
        }
        return i13;
    }

    public final int bwt() {
        int[] iArr = this.SA;
        byte[] bArr = this.T;
        int i = this.n;
        int[] iArr2 = new int[256];
        int[] iArr3 = new int[65536];
        if (i == 0) {
            return 0;
        }
        if (i == 1) {
            iArr[0] = bArr[0];
            return 0;
        }
        if (sortTypeBstar(iArr2, iArr3) > 0) {
            return constructBWT(iArr2, iArr3);
        }
        return 0;
    }
}
