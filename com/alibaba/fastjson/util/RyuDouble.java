package com.alibaba.fastjson.util;

import aegon.chrome.net.NetError;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import java.lang.reflect.Array;
import java.math.BigInteger;
import okhttp3.internal.connection.RealConnection;
import org.aspectj.runtime.reflect.SignatureImpl;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final class RyuDouble {
    private static final int[][] POW5_SPLIT = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 326, 4);
    private static final int[][] POW5_INV_SPLIT = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 291, 4);

    static {
        BigInteger bigIntegerSubtract = BigInteger.ONE.shiftLeft(31).subtract(BigInteger.ONE);
        BigInteger bigIntegerSubtract2 = BigInteger.ONE.shiftLeft(31).subtract(BigInteger.ONE);
        int i = 0;
        while (i < 326) {
            BigInteger bigIntegerPow = BigInteger.valueOf(5L).pow(i);
            int iBitLength = bigIntegerPow.bitLength();
            int i2 = i == 0 ? 1 : (int) ((((i * 23219280) + 10000000) - 1) / 10000000);
            if (i2 != iBitLength) {
                throw new IllegalStateException(iBitLength + " != " + i2);
            }
            if (i < POW5_SPLIT.length) {
                for (int i3 = 0; i3 < 4; i3++) {
                    POW5_SPLIT[i][i3] = bigIntegerPow.shiftRight(iBitLength + NetError.ERR_SOCKS_CONNECTION_HOST_UNREACHABLE + ((3 - i3) * 31)).and(bigIntegerSubtract).intValue();
                }
            }
            if (i < POW5_INV_SPLIT.length) {
                BigInteger bigIntegerAdd = BigInteger.ONE.shiftLeft(iBitLength + 121).divide(bigIntegerPow).add(BigInteger.ONE);
                for (int i4 = 0; i4 < 4; i4++) {
                    if (i4 == 0) {
                        POW5_INV_SPLIT[i][i4] = bigIntegerAdd.shiftRight((3 - i4) * 31).intValue();
                    } else {
                        POW5_INV_SPLIT[i][i4] = bigIntegerAdd.shiftRight((3 - i4) * 31).and(bigIntegerSubtract2).intValue();
                    }
                }
            }
            i++;
        }
    }

    public static String toString(double d) {
        char[] cArr = new char[24];
        return new String(cArr, 0, toString(d, cArr, 0));
    }

    public static int toString(double d, char[] cArr, int i) {
        int i2;
        boolean z;
        boolean z2;
        int i3;
        long j;
        long j2;
        long j3;
        int i4;
        boolean z3;
        boolean z4;
        long j4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        boolean z5;
        int i10;
        int i11;
        int i12;
        int i13;
        if (!Double.isNaN(d)) {
            if (d == Double.POSITIVE_INFINITY) {
                int i14 = i + 1;
                cArr[i] = 'I';
                int i15 = i14 + 1;
                cArr[i14] = 'n';
                int i16 = i15 + 1;
                cArr[i15] = 'f';
                int i17 = i16 + 1;
                cArr[i16] = 'i';
                int i18 = i17 + 1;
                cArr[i17] = 'n';
                int i19 = i18 + 1;
                cArr[i18] = 'i';
                int i20 = i19 + 1;
                cArr[i19] = 't';
                i9 = i20 + 1;
                cArr[i20] = 'y';
            } else if (d == Double.NEGATIVE_INFINITY) {
                int i21 = i + 1;
                cArr[i] = SignatureImpl.SEP;
                int i22 = i21 + 1;
                cArr[i21] = 'I';
                int i23 = i22 + 1;
                cArr[i22] = 'n';
                int i24 = i23 + 1;
                cArr[i23] = 'f';
                int i25 = i24 + 1;
                cArr[i24] = 'i';
                int i26 = i25 + 1;
                cArr[i25] = 'n';
                int i27 = i26 + 1;
                cArr[i26] = 'i';
                int i28 = i27 + 1;
                cArr[i27] = 't';
                i13 = i28 + 1;
                cArr[i28] = 'y';
            } else {
                long jDoubleToLongBits = Double.doubleToLongBits(d);
                if (jDoubleToLongBits == 0) {
                    int i29 = i + 1;
                    cArr[i] = '0';
                    int i30 = i29 + 1;
                    cArr[i29] = '.';
                    i13 = i30 + 1;
                    cArr[i30] = '0';
                } else if (jDoubleToLongBits == Long.MIN_VALUE) {
                    int i31 = i + 1;
                    cArr[i] = SignatureImpl.SEP;
                    int i32 = i31 + 1;
                    cArr[i31] = '0';
                    int i33 = i32 + 1;
                    cArr[i32] = '.';
                    i9 = i33 + 1;
                    cArr[i33] = '0';
                } else {
                    int i34 = (int) ((jDoubleToLongBits >>> 52) & 2047);
                    long j5 = jDoubleToLongBits & 4503599627370495L;
                    if (i34 == 0) {
                        i2 = -1074;
                    } else {
                        i2 = (i34 - 1023) - 52;
                        j5 |= 4503599627370496L;
                    }
                    boolean z6 = jDoubleToLongBits < 0;
                    boolean z7 = (j5 & 1) == 0;
                    long j6 = 4 * j5;
                    long j7 = j6 + 2;
                    int i35 = (j5 != 4503599627370496L || i34 <= 1) ? 1 : 0;
                    long j8 = (j6 - 1) - i35;
                    int i36 = i2 - 2;
                    if (i36 >= 0) {
                        int iMax = Math.max(0, ((int) ((i36 * 3010299) / 10000000)) - 1);
                        int i37 = ((((-i36) + iMax) + (((iMax == 0 ? 1 : (int) ((((iMax * 23219280) + 10000000) - 1) / 10000000)) + 122) - 1)) - 93) - 21;
                        if (i37 < 0) {
                            throw new IllegalArgumentException("" + i37);
                        }
                        int[] iArr = POW5_INV_SPLIT[iMax];
                        long j9 = j6 >>> 31;
                        long j10 = j6 & 2147483647L;
                        int i38 = iArr[0];
                        z = z6;
                        int i39 = iArr[1];
                        int i40 = iArr[2];
                        z2 = z7;
                        int i41 = iArr[3];
                        long j11 = ((((((((((((j10 * i41) >>> 31) + (i40 * j10)) + (j9 * i41)) >>> 31) + (i39 * j10)) + (i40 * j9)) >>> 31) + (i38 * j10)) + (i39 * j9)) >>> 21) + ((i38 * j9) << 10)) >>> i37;
                        long j12 = j7 >>> 31;
                        long j13 = j7 & 2147483647L;
                        long j14 = ((((((((((((j13 * i41) >>> 31) + (i40 * j13)) + (j12 * i41)) >>> 31) + (i39 * j13)) + (i40 * j12)) >>> 31) + (i38 * j13)) + (i39 * j12)) >>> 21) + ((i38 * j12) << 10)) >>> i37;
                        long j15 = j8 >>> 31;
                        long j16 = j8 & 2147483647L;
                        long j17 = j14;
                        j3 = ((((((((((((j16 * i41) >>> 31) + (i40 * j16)) + (j15 * i41)) >>> 31) + (i39 * j16)) + (i40 * j15)) >>> 31) + (i38 * j16)) + (i39 * j15)) >>> 21) + ((i38 * j15) << 10)) >>> i37;
                        if (iMax <= 21) {
                            long j18 = j6 % 5;
                            if (j18 == 0) {
                                if (j18 != 0) {
                                    i12 = 0;
                                } else if (j6 % 25 != 0) {
                                    i12 = 1;
                                } else if (j6 % 125 != 0) {
                                    i12 = 2;
                                } else if (j6 % 625 != 0) {
                                    i12 = 3;
                                } else {
                                    long j19 = j6 / 625;
                                    i12 = 4;
                                    for (long j20 = 0; j19 > j20 && j19 % 5 == j20; j20 = 0) {
                                        j19 /= 5;
                                        i12++;
                                    }
                                }
                                z4 = i12 >= iMax;
                                z5 = false;
                                j = j11;
                                j2 = j17;
                                i3 = 2;
                                z3 = z5;
                                i4 = iMax;
                            } else {
                                if (z2) {
                                    if (j8 % 5 != 0) {
                                        i11 = 0;
                                    } else if (j8 % 25 != 0) {
                                        i11 = 1;
                                    } else if (j8 % 125 != 0) {
                                        i11 = 2;
                                    } else if (j8 % 625 != 0) {
                                        i11 = 3;
                                    } else {
                                        long j21 = j8 / 625;
                                        i11 = 4;
                                        for (long j22 = 0; j21 > j22 && j21 % 5 == j22; j22 = 0) {
                                            j21 /= 5;
                                            i11++;
                                        }
                                    }
                                    z5 = i11 >= iMax;
                                    z4 = false;
                                    j = j11;
                                    j2 = j17;
                                    i3 = 2;
                                    z3 = z5;
                                    i4 = iMax;
                                } else {
                                    if (j7 % 5 != 0) {
                                        i10 = 0;
                                    } else if (j7 % 25 != 0) {
                                        i10 = 1;
                                    } else if (j7 % 125 != 0) {
                                        i10 = 2;
                                    } else if (j7 % 625 != 0) {
                                        i10 = 3;
                                    } else {
                                        long j23 = j7 / 625;
                                        i10 = 4;
                                        for (long j24 = 0; j23 > j24 && j23 % 5 == j24; j24 = 0) {
                                            j23 /= 5;
                                            i10++;
                                        }
                                    }
                                    if (i10 >= iMax) {
                                        j17--;
                                    }
                                }
                                z4 = false;
                                j = j11;
                                j2 = j17;
                                i3 = 2;
                                z3 = z5;
                                i4 = iMax;
                            }
                        } else {
                            z4 = false;
                            j = j11;
                            j2 = j17;
                            i3 = 2;
                            z3 = z5;
                            i4 = iMax;
                        }
                    } else {
                        z = z6;
                        z2 = z7;
                        int i42 = -i36;
                        int iMax2 = Math.max(0, ((int) ((i42 * 6989700) / 10000000)) - 1);
                        int i43 = i42 - iMax2;
                        int i44 = ((iMax2 - ((i43 == 0 ? 1 : (int) ((((i43 * 23219280) + 10000000) - 1) / 10000000)) + NetError.ERR_SOCKS_CONNECTION_HOST_UNREACHABLE)) - 93) - 21;
                        if (i44 < 0) {
                            throw new IllegalArgumentException("" + i44);
                        }
                        int[] iArr2 = POW5_SPLIT[i43];
                        long j25 = j6 >>> 31;
                        long j26 = j6 & 2147483647L;
                        int i45 = iArr2[0];
                        int i46 = iArr2[1];
                        int i47 = i35;
                        i3 = 2;
                        int i48 = iArr2[2];
                        int i49 = iArr2[3];
                        long j27 = ((((((((((((j26 * i49) >>> 31) + (i48 * j26)) + (j25 * i49)) >>> 31) + (i46 * j26)) + (i48 * j25)) >>> 31) + (i45 * j26)) + (i46 * j25)) >>> 21) + ((i45 * j25) << 10)) >>> i44;
                        long j28 = j7 >>> 31;
                        long j29 = j7 & 2147483647L;
                        j = j27;
                        long j30 = ((((((((((((j29 * i49) >>> 31) + (i48 * j29)) + (j28 * i49)) >>> 31) + (i46 * j29)) + (i48 * j28)) >>> 31) + (i45 * j29)) + (i46 * j28)) >>> 21) + ((i45 * j28) << 10)) >>> i44;
                        long j31 = j8 >>> 31;
                        long j32 = j8 & 2147483647L;
                        j2 = j30;
                        j3 = ((((((((((((j32 * i49) >>> 31) + (i48 * j32)) + (j31 * i49)) >>> 31) + (i46 * j32)) + (i48 * j31)) >>> 31) + (i45 * j32)) + (i46 * j31)) >>> 21) + ((i45 * j31) << 10)) >>> i44;
                        i4 = iMax2 + i36;
                        boolean z8 = true;
                        if (iMax2 <= 1) {
                            if (z2) {
                                z4 = true;
                                z3 = i47 == 1;
                            } else {
                                j2--;
                                z4 = z8;
                                z3 = false;
                            }
                        } else if (iMax2 < 63) {
                            z8 = (j6 & ((1 << (iMax2 - 1)) - 1)) == 0;
                            z4 = z8;
                            z3 = false;
                        } else {
                            z3 = false;
                            z4 = false;
                        }
                    }
                    int i50 = j2 >= 1000000000000000000L ? 19 : j2 >= 100000000000000000L ? 18 : j2 >= 10000000000000000L ? 17 : j2 >= 1000000000000000L ? 16 : j2 >= 100000000000000L ? 15 : j2 >= 10000000000000L ? 14 : j2 >= 1000000000000L ? 13 : j2 >= 100000000000L ? 12 : j2 >= RealConnection.IDLE_CONNECTION_HEALTHY_NS ? 11 : j2 >= 1000000000 ? 10 : j2 >= 100000000 ? 9 : j2 >= 10000000 ? 8 : j2 >= 1000000 ? 7 : j2 >= 100000 ? 6 : j2 >= ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT ? 5 : j2 >= 1000 ? 4 : j2 >= 100 ? 3 : j2 >= 10 ? i3 : 1;
                    int i51 = (i4 + i50) - 1;
                    boolean z9 = i51 < -3 || i51 >= 7;
                    if (z3 || z4) {
                        boolean z10 = z4;
                        int i52 = 0;
                        int i53 = 0;
                        while (true) {
                            long j33 = j2 / 10;
                            long j34 = j3 / 10;
                            if (j33 <= j34 || (j2 < 100 && z9)) {
                                break;
                            }
                            z3 &= j3 % 10 == 0;
                            z10 &= i52 == 0;
                            i52 = (int) (j % 10);
                            j /= 10;
                            i53++;
                            j2 = j33;
                            j3 = j34;
                        }
                        if (z3 && z2) {
                            while (j3 % 10 == 0 && (j2 >= 100 || !z9)) {
                                z10 &= i52 == 0;
                                i52 = (int) (j % 10);
                                j2 /= 10;
                                j /= 10;
                                j3 /= 10;
                                i53++;
                            }
                        }
                        if (z10 && i52 == 5 && j % 2 == 0) {
                            i52 = 4;
                        }
                        j4 = j + (((j != j3 || (z3 && z2)) && i52 < 5) ? 0 : 1);
                        i5 = i53;
                    } else {
                        i5 = 0;
                        int i54 = 0;
                        while (true) {
                            long j35 = j2 / 10;
                            long j36 = j3 / 10;
                            if (j35 <= j36 || (j2 < 100 && z9)) {
                                break;
                            }
                            i54 = (int) (j % 10);
                            j /= 10;
                            i5++;
                            j2 = j35;
                            j3 = j36;
                        }
                        j4 = j + ((j == j3 || i54 >= 5) ? 1 : 0);
                    }
                    int i55 = i50 - i5;
                    if (z) {
                        i6 = i + 1;
                        cArr[i] = SignatureImpl.SEP;
                    } else {
                        i6 = i;
                    }
                    if (!z9) {
                        char c = '0';
                        if (i51 < 0) {
                            int i56 = i6 + 1;
                            cArr[i6] = '0';
                            int i57 = i56 + 1;
                            cArr[i56] = '.';
                            int i58 = -1;
                            while (i58 > i51) {
                                cArr[i57] = c;
                                i58--;
                                i57++;
                                c = '0';
                            }
                            i7 = i57;
                            for (int i59 = 0; i59 < i55; i59++) {
                                cArr[((i57 + i55) - i59) - 1] = (char) ((j4 % 10) + 48);
                                j4 /= 10;
                                i7++;
                            }
                        } else {
                            int i60 = i51 + 1;
                            if (i60 >= i55) {
                                for (int i61 = 0; i61 < i55; i61++) {
                                    cArr[((i6 + i55) - i61) - 1] = (char) ((j4 % 10) + 48);
                                    j4 /= 10;
                                }
                                int i62 = i6 + i55;
                                while (i55 < i60) {
                                    cArr[i62] = '0';
                                    i55++;
                                    i62++;
                                }
                                int i63 = i62 + 1;
                                cArr[i62] = '.';
                                i7 = i63 + 1;
                                cArr[i63] = '0';
                            } else {
                                int i64 = i6 + 1;
                                for (int i65 = 0; i65 < i55; i65++) {
                                    if ((i55 - i65) - 1 == i51) {
                                        cArr[((i64 + i55) - i65) - 1] = '.';
                                        i64--;
                                    }
                                    cArr[((i64 + i55) - i65) - 1] = (char) ((j4 % 10) + 48);
                                    j4 /= 10;
                                }
                                i7 = i6 + i55 + 1;
                            }
                        }
                        return i7 - i;
                    }
                    for (int i66 = 0; i66 < i55 - 1; i66++) {
                        int i67 = (int) (j4 % 10);
                        j4 /= 10;
                        cArr[(i6 + i55) - i66] = (char) (i67 + 48);
                    }
                    cArr[i6] = (char) ((j4 % 10) + 48);
                    cArr[i6 + 1] = '.';
                    int i68 = i6 + i55 + 1;
                    if (i55 == 1) {
                        cArr[i68] = '0';
                        i68++;
                    }
                    int i69 = i68 + 1;
                    cArr[i68] = 'E';
                    if (i51 < 0) {
                        cArr[i69] = SignatureImpl.SEP;
                        i51 = -i51;
                        i69++;
                    }
                    if (i51 >= 100) {
                        int i70 = i69 + 1;
                        i8 = 48;
                        cArr[i69] = (char) ((i51 / 100) + 48);
                        i51 %= 100;
                        i69 = i70 + 1;
                        cArr[i70] = (char) ((i51 / 10) + 48);
                    } else {
                        i8 = 48;
                        if (i51 >= 10) {
                            cArr[i69] = (char) ((i51 / 10) + 48);
                            i69++;
                        }
                    }
                    i9 = i69 + 1;
                    cArr[i69] = (char) ((i51 % 10) + i8);
                }
            }
            return i9 - i;
        }
        int i71 = i + 1;
        cArr[i] = 'N';
        int i72 = i71 + 1;
        cArr[i71] = 'a';
        i13 = i72 + 1;
        cArr[i72] = 'N';
        return i13 - i;
    }
}
