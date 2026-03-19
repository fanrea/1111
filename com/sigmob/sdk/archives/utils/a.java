package com.sigmob.sdk.archives.utils;

import java.io.UnsupportedEncodingException;
import org.aspectj.runtime.reflect.SignatureImpl;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class a {
    private a() {
    }

    public static String a(com.sigmob.sdk.archives.a entry) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(entry.c() ? 'd' : SignatureImpl.SEP);
        String string = Long.toString(entry.b());
        stringBuffer.append(' ');
        for (int i = 7; i > string.length(); i--) {
            stringBuffer.append(' ');
        }
        stringBuffer.append(string);
        stringBuffer.append(' ').append(entry.a());
        return stringBuffer.toString();
    }

    public static String a(final byte[] inputBytes) {
        try {
            return new String(inputBytes, "ASCII");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static String a(final byte[] inputBytes, int offset, int length) {
        try {
            return new String(inputBytes, offset, length, "ASCII");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean a(String expected, byte[] buffer) {
        return a(expected, buffer, 0, buffer.length);
    }

    public static boolean a(String expected, byte[] buffer, int offset, int length) throws UnsupportedEncodingException {
        try {
            byte[] bytes = expected.getBytes("ASCII");
            return a(bytes, 0, bytes.length, buffer, offset, length, false);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean a(final byte[] buffer1, final int offset1, final int length1, final byte[] buffer2, final int offset2, final int length2) {
        return a(buffer1, offset1, length1, buffer2, offset2, length2, false);
    }

    public static boolean a(final byte[] buffer1, final int offset1, final int length1, final byte[] buffer2, final int offset2, final int length2, boolean ignoreTrailingNulls) {
        int i = length1 < length2 ? length1 : length2;
        for (int i2 = 0; i2 < i; i2++) {
            if (buffer1[offset1 + i2] != buffer2[offset2 + i2]) {
                return false;
            }
        }
        if (length1 == length2) {
            return true;
        }
        if (!ignoreTrailingNulls) {
            return false;
        }
        if (length1 > length2) {
            while (length2 < length1) {
                if (buffer1[offset1 + length2] != 0) {
                    return false;
                }
                length2++;
            }
        } else {
            while (length1 < length2) {
                if (buffer2[offset2 + length1] != 0) {
                    return false;
                }
                length1++;
            }
        }
        return true;
    }

    public static boolean a(final byte[] buffer1, final byte[] buffer2) {
        return a(buffer1, 0, buffer1.length, buffer2, 0, buffer2.length, false);
    }

    public static boolean a(final byte[] buffer1, final byte[] buffer2, boolean ignoreTrailingNulls) {
        return a(buffer1, 0, buffer1.length, buffer2, 0, buffer2.length, ignoreTrailingNulls);
    }

    public static byte[] a(String inputString) {
        try {
            return inputString.getBytes("ASCII");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean b(final byte[] buffer1, final int offset1, final int length1, final byte[] buffer2, final int offset2, final int length2) {
        return a(buffer1, offset1, length1, buffer2, offset2, length2, true);
    }
}
