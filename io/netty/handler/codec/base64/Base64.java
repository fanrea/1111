package io.netty.handler.codec.base64;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class Base64 {
    private static final byte EQUALS_SIGN = 61;
    private static final byte EQUALS_SIGN_ENC = -1;
    private static final int MAX_LINE_LENGTH = 76;
    private static final byte NEW_LINE = 10;
    private static final byte WHITE_SPACE_ENC = -5;

    private static byte[] alphabet(Base64Dialect base64Dialect) {
        if (base64Dialect == null) {
            throw new NullPointerException("dialect");
        }
        return base64Dialect.alphabet;
    }

    private static byte[] decodabet(Base64Dialect base64Dialect) {
        if (base64Dialect == null) {
            throw new NullPointerException("dialect");
        }
        return base64Dialect.decodabet;
    }

    private static boolean breakLines(Base64Dialect base64Dialect) {
        if (base64Dialect == null) {
            throw new NullPointerException("dialect");
        }
        return base64Dialect.breakLinesByDefault;
    }

    public static ByteBuf encode(ByteBuf byteBuf) {
        return encode(byteBuf, Base64Dialect.STANDARD);
    }

    public static ByteBuf encode(ByteBuf byteBuf, Base64Dialect base64Dialect) {
        return encode(byteBuf, breakLines(base64Dialect), base64Dialect);
    }

    public static ByteBuf encode(ByteBuf byteBuf, boolean z) {
        return encode(byteBuf, z, Base64Dialect.STANDARD);
    }

    public static ByteBuf encode(ByteBuf byteBuf, boolean z, Base64Dialect base64Dialect) {
        if (byteBuf == null) {
            throw new NullPointerException("src");
        }
        ByteBuf byteBufEncode = encode(byteBuf, byteBuf.readerIndex(), byteBuf.readableBytes(), z, base64Dialect);
        byteBuf.readerIndex(byteBuf.writerIndex());
        return byteBufEncode;
    }

    public static ByteBuf encode(ByteBuf byteBuf, int i, int i2) {
        return encode(byteBuf, i, i2, Base64Dialect.STANDARD);
    }

    public static ByteBuf encode(ByteBuf byteBuf, int i, int i2, Base64Dialect base64Dialect) {
        return encode(byteBuf, i, i2, breakLines(base64Dialect), base64Dialect);
    }

    public static ByteBuf encode(ByteBuf byteBuf, int i, int i2, boolean z) {
        return encode(byteBuf, i, i2, z, Base64Dialect.STANDARD);
    }

    public static ByteBuf encode(ByteBuf byteBuf, int i, int i2, boolean z, Base64Dialect base64Dialect) {
        return encode(byteBuf, i, i2, z, base64Dialect, byteBuf.alloc());
    }

    public static ByteBuf encode(ByteBuf byteBuf, int i, int i2, boolean z, Base64Dialect base64Dialect, ByteBufAllocator byteBufAllocator) {
        if (byteBuf == null) {
            throw new NullPointerException("src");
        }
        if (base64Dialect == null) {
            throw new NullPointerException("dialect");
        }
        int i3 = (i2 * 4) / 3;
        ByteBuf byteBufOrder = byteBufAllocator.buffer((i2 % 3 > 0 ? 4 : 0) + i3 + (z ? i3 / 76 : 0)).order(byteBuf.order());
        int i4 = i2 - 2;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i5 < i4) {
            encode3to4(byteBuf, i5 + i, 3, byteBufOrder, i6, base64Dialect);
            i7 += 4;
            i5 += 3;
            if (z && i7 == 76 && i5 < i4) {
                byteBufOrder.setByte(i6 + 4, 10);
                i6++;
                i7 = 0;
            }
            i6 += 4;
        }
        if (i5 < i2) {
            encode3to4(byteBuf, i5 + i, i2 - i5, byteBufOrder, i6, base64Dialect);
            i6 += 4;
        }
        return byteBufOrder.slice(0, i6);
    }

    private static void encode3to4(ByteBuf byteBuf, int i, int i2, ByteBuf byteBuf2, int i3, Base64Dialect base64Dialect) {
        byte[] bArrAlphabet = alphabet(base64Dialect);
        int i4 = (i2 > 0 ? (byteBuf.getByte(i) << 24) >>> 8 : 0) | (i2 > 1 ? (byteBuf.getByte(i + 1) << 24) >>> 16 : 0) | (i2 > 2 ? (byteBuf.getByte(i + 2) << 24) >>> 24 : 0);
        if (i2 == 1) {
            byteBuf2.setByte(i3, bArrAlphabet[i4 >>> 18]);
            byteBuf2.setByte(i3 + 1, bArrAlphabet[(i4 >>> 12) & 63]);
            byteBuf2.setByte(i3 + 2, 61);
            byteBuf2.setByte(i3 + 3, 61);
            return;
        }
        if (i2 == 2) {
            byteBuf2.setByte(i3, bArrAlphabet[i4 >>> 18]);
            byteBuf2.setByte(i3 + 1, bArrAlphabet[(i4 >>> 12) & 63]);
            byteBuf2.setByte(i3 + 2, bArrAlphabet[(i4 >>> 6) & 63]);
            byteBuf2.setByte(i3 + 3, 61);
            return;
        }
        if (i2 != 3) {
            return;
        }
        byteBuf2.setByte(i3, bArrAlphabet[i4 >>> 18]);
        byteBuf2.setByte(i3 + 1, bArrAlphabet[(i4 >>> 12) & 63]);
        byteBuf2.setByte(i3 + 2, bArrAlphabet[(i4 >>> 6) & 63]);
        byteBuf2.setByte(i3 + 3, bArrAlphabet[i4 & 63]);
    }

    public static ByteBuf decode(ByteBuf byteBuf) {
        return decode(byteBuf, Base64Dialect.STANDARD);
    }

    public static ByteBuf decode(ByteBuf byteBuf, Base64Dialect base64Dialect) {
        if (byteBuf == null) {
            throw new NullPointerException("src");
        }
        ByteBuf byteBufDecode = decode(byteBuf, byteBuf.readerIndex(), byteBuf.readableBytes(), base64Dialect);
        byteBuf.readerIndex(byteBuf.writerIndex());
        return byteBufDecode;
    }

    public static ByteBuf decode(ByteBuf byteBuf, int i, int i2) {
        return decode(byteBuf, i, i2, Base64Dialect.STANDARD);
    }

    public static ByteBuf decode(ByteBuf byteBuf, int i, int i2, Base64Dialect base64Dialect) {
        return decode(byteBuf, i, i2, base64Dialect, byteBuf.alloc());
    }

    public static ByteBuf decode(ByteBuf byteBuf, int i, int i2, Base64Dialect base64Dialect, ByteBufAllocator byteBufAllocator) {
        if (byteBuf == null) {
            throw new NullPointerException("src");
        }
        if (base64Dialect == null) {
            throw new NullPointerException("dialect");
        }
        byte[] bArrDecodabet = decodabet(base64Dialect);
        ByteBuf byteBufOrder = byteBufAllocator.buffer((i2 * 3) / 4).order(byteBuf.order());
        byte[] bArr = new byte[4];
        int i3 = 0;
        int iDecode4to3 = 0;
        for (int i4 = i; i4 < i + i2; i4++) {
            byte b = (byte) (byteBuf.getByte(i4) & 127);
            byte b2 = bArrDecodabet[b];
            if (b2 < -5) {
                throw new IllegalArgumentException("bad Base64 input character at " + i4 + ": " + ((int) byteBuf.getUnsignedByte(i4)) + " (decimal)");
            }
            if (b2 >= -1) {
                int i5 = i3 + 1;
                bArr[i3] = b;
                if (i5 > 3) {
                    iDecode4to3 += decode4to3(bArr, 0, byteBufOrder, iDecode4to3, base64Dialect);
                    if (b == 61) {
                        break;
                    }
                    i3 = 0;
                } else {
                    i3 = i5;
                }
            }
        }
        return byteBufOrder.slice(0, iDecode4to3);
    }

    private static int decode4to3(byte[] bArr, int i, ByteBuf byteBuf, int i2, Base64Dialect base64Dialect) {
        byte[] bArrDecodabet = decodabet(base64Dialect);
        int i3 = i + 2;
        if (bArr[i3] == 61) {
            byteBuf.setByte(i2, (byte) ((((bArrDecodabet[bArr[i + 1]] & EQUALS_SIGN_ENC) << 12) | ((bArrDecodabet[bArr[i]] & EQUALS_SIGN_ENC) << 18)) >>> 16));
            return 1;
        }
        int i4 = i + 3;
        if (bArr[i4] == 61) {
            int i5 = ((bArrDecodabet[bArr[i3]] & EQUALS_SIGN_ENC) << 6) | ((bArrDecodabet[bArr[i + 1]] & EQUALS_SIGN_ENC) << 12) | ((bArrDecodabet[bArr[i]] & EQUALS_SIGN_ENC) << 18);
            byteBuf.setByte(i2, (byte) (i5 >>> 16));
            byteBuf.setByte(i2 + 1, (byte) (i5 >>> 8));
            return 2;
        }
        try {
            int i6 = (bArrDecodabet[bArr[i4]] & EQUALS_SIGN_ENC) | ((bArrDecodabet[bArr[i + 1]] & EQUALS_SIGN_ENC) << 12) | ((bArrDecodabet[bArr[i]] & EQUALS_SIGN_ENC) << 18) | ((bArrDecodabet[bArr[i3]] & EQUALS_SIGN_ENC) << 6);
            byteBuf.setByte(i2, (byte) (i6 >> 16));
            byteBuf.setByte(i2 + 1, (byte) (i6 >> 8));
            byteBuf.setByte(i2 + 2, (byte) i6);
            return 3;
        } catch (IndexOutOfBoundsException unused) {
            throw new IllegalArgumentException("not encoded in Base64");
        }
    }

    private Base64() {
    }
}
