package com.sigmob.sdk.archives.tar;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class f {
    private static final int a = 255;

    private f() {
    }

    public static int a(String name, byte[] buf, final int offset, final int length) {
        int i = 0;
        while (i < length && i < name.length()) {
            buf[offset + i] = (byte) name.charAt(i);
            i++;
        }
        while (i < length) {
            buf[offset + i] = 0;
            i++;
        }
        return offset + length;
    }

    public static long a(final byte[] buf) {
        long j = 0;
        for (byte b : buf) {
            j += b & 255;
        }
        return j;
    }

    public static long a(final byte[] buffer, final int offset, final int length) {
        boolean z;
        int i = offset + length;
        if (length < 2) {
            throw new IllegalArgumentException("Length " + length + " must be at least 2");
        }
        int i2 = offset;
        while (true) {
            if (i2 >= i) {
                z = true;
                break;
            }
            if (buffer[i2] != 0) {
                z = false;
                break;
            }
            i2++;
        }
        long j = 0;
        if (z) {
            return 0L;
        }
        int i3 = offset;
        while (i3 < i && buffer[i3] == 32) {
            i3++;
        }
        int i4 = i - 1;
        byte b = buffer[i4];
        if (b != 0 && b != 32) {
            throw new IllegalArgumentException(a(buffer, offset, length, i4, b));
        }
        int i5 = i - 1;
        byte b2 = buffer[i5 - 1];
        if (b2 == 0 || b2 == 32) {
            i5--;
        }
        while (i3 < i5) {
            byte b3 = buffer[i3];
            if (b3 < 48 || b3 > 55) {
                throw new IllegalArgumentException(a(buffer, offset, length, i3, b3));
            }
            j = (j << 3) + (b3 - 48);
            i3++;
        }
        return j;
    }

    private static String a(byte[] buffer, final int offset, final int length, int current, final byte currentByte) {
        return "Invalid byte " + ((int) currentByte) + " at offset " + (current - offset) + " in '" + new String(buffer, offset, length).replaceAll("\u0000", "{NUL}") + "' len=" + length;
    }

    public static void a(final long value, byte[] buffer, final int offset, final int length) {
        int i;
        int i2 = length - 1;
        if (value == 0) {
            i = i2 - 1;
            buffer[i2 + offset] = e.H;
        } else {
            long j = value;
            while (i2 >= 0 && j != 0) {
                buffer[offset + i2] = (byte) (((byte) (7 & j)) + e.H);
                j >>>= 3;
                i2--;
            }
            if (j != 0) {
                throw new IllegalArgumentException(value + "=" + Long.toOctalString(value) + " will not fit in octal number buffer of length " + length);
            }
            i = i2;
        }
        while (i >= 0) {
            buffer[offset + i] = e.H;
            i--;
        }
    }

    public static boolean a(final byte[] buffer, final int offset) {
        return buffer[offset] == 1;
    }

    public static int b(final long value, byte[] buf, final int offset, final int length) {
        int i = length - 2;
        a(value, buf, offset, i);
        buf[i + offset] = 32;
        buf[i + 1 + offset] = 0;
        return offset + length;
    }

    public static String b(byte[] buffer, final int offset, final int length) {
        StringBuffer stringBuffer = new StringBuffer(length);
        int i = length + offset;
        while (offset < i) {
            byte b = buffer[offset];
            if (b == 0) {
                break;
            }
            stringBuffer.append((char) (b & 255));
            offset++;
        }
        return stringBuffer.toString();
    }

    public static int c(final long value, byte[] buf, final int offset, final int length) {
        int i = length - 1;
        a(value, buf, offset, i);
        buf[i + offset] = 32;
        return offset + length;
    }

    public static int d(final long value, byte[] buf, final int offset, final int length) {
        int i = length - 2;
        a(value, buf, offset, i);
        buf[i + offset] = 0;
        buf[i + 1 + offset] = 32;
        return offset + length;
    }
}
