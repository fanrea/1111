package com.alliance.ssp.ad.o;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: Base64.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class a {
    public static final char[] a = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();

    public static String a(byte[] bArr) {
        int length = bArr.length;
        StringBuffer stringBuffer = new StringBuffer((bArr.length * 3) / 2);
        int i = length - 3;
        int i2 = 0;
        int i3 = 0;
        while (i2 <= i) {
            int i4 = ((bArr[i2] & 255) << 16) | ((bArr[i2 + 1] & 255) << 8) | (bArr[i2 + 2] & 255);
            char[] cArr = a;
            stringBuffer.append(cArr[(i4 >> 18) & 63]);
            stringBuffer.append(cArr[(i4 >> 12) & 63]);
            stringBuffer.append(cArr[(i4 >> 6) & 63]);
            stringBuffer.append(cArr[i4 & 63]);
            i2 += 3;
            int i5 = i3 + 1;
            if (i3 >= 14) {
                stringBuffer.append("");
                i3 = 0;
            } else {
                i3 = i5;
            }
        }
        int i6 = 0 + length;
        if (i2 == i6 - 2) {
            int i7 = ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2] & 255) << 16);
            char[] cArr2 = a;
            stringBuffer.append(cArr2[(i7 >> 18) & 63]);
            stringBuffer.append(cArr2[(i7 >> 12) & 63]);
            stringBuffer.append(cArr2[(i7 >> 6) & 63]);
            stringBuffer.append("=");
        } else if (i2 == i6 - 1) {
            int i8 = (bArr[i2] & 255) << 16;
            char[] cArr3 = a;
            stringBuffer.append(cArr3[(i8 >> 18) & 63]);
            stringBuffer.append(cArr3[(i8 >> 12) & 63]);
            stringBuffer.append("==");
        }
        return stringBuffer.toString();
    }

    public static int a(char c) {
        int i;
        if (c >= 'A' && c <= 'Z') {
            return c - 'A';
        }
        if (c >= 'a' && c <= 'z') {
            i = c - 'a';
        } else {
            if (c < '0' || c > '9') {
                if (c == '+') {
                    return 62;
                }
                if (c == '/') {
                    return 63;
                }
                if (c == '=') {
                    return 0;
                }
                throw new RuntimeException("unexpected code: " + c);
            }
            i = (c - '0') + 26;
        }
        return i + 26;
    }

    public static byte[] a(String str) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            a(str, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (IOException unused) {
            }
            return byteArray;
        } catch (IOException unused2) {
            throw new RuntimeException();
        }
    }

    public static void a(String str, OutputStream outputStream) throws IOException {
        int length = str.length();
        int i = 0;
        while (true) {
            if (i < length && str.charAt(i) <= ' ') {
                i++;
            } else {
                if (i == length) {
                    return;
                }
                int i2 = i + 2;
                int i3 = i + 3;
                int iA = a(str.charAt(i3)) + (a(str.charAt(i)) << 18) + (a(str.charAt(i + 1)) << 12) + (a(str.charAt(i2)) << 6);
                outputStream.write((iA >> 16) & 255);
                if (str.charAt(i2) == '=') {
                    return;
                }
                outputStream.write((iA >> 8) & 255);
                if (str.charAt(i3) == '=') {
                    return;
                }
                outputStream.write(iA & 255);
                i += 4;
            }
        }
    }
}
