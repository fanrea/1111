package com.kwad.sdk.liteapi.utils;

import android.text.TextUtils;
import com.bytedance.common.utility.StringEncryptUtils;
import com.kwad.sdk.liteapi.LiteApiLogger;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class LiteMd5Util {
    static final char[] HEX_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String md5(String str) {
        return TextUtils.isEmpty(str) ? "" : md5ForByte(str.getBytes());
    }

    public static String md5ForByte(byte[] bArr) throws NoSuchAlgorithmException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            byte[] bArrDigest = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            int length = bArrDigest.length;
            for (int i = 0; i < length; i++) {
                int i2 = bArrDigest[i];
                if (i2 < 0) {
                    i2 += 256;
                }
                if (i2 < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(i2));
            }
            return sb.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public static String sha1(String str) throws NoSuchAlgorithmException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(StringEncryptUtils.SHA_1);
            messageDigest.update(str.getBytes());
            byte[] bArrDigest = messageDigest.digest();
            return toHexString(bArrDigest, 0, bArrDigest.length);
        } catch (Exception e) {
            LiteApiLogger.printStackTrace(e);
            return "";
        }
    }

    public static String toHexString(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            return null;
        }
        if (i < 0 || i + i2 > bArr.length) {
            throw new IndexOutOfBoundsException();
        }
        int i3 = i2 * 2;
        char[] cArr = new char[i3];
        int i4 = 0;
        for (int i5 = 0; i5 < i2; i5++) {
            int i6 = bArr[i5 + i] & 255;
            int i7 = i4 + 1;
            char[] cArr2 = HEX_CHARS;
            cArr[i4] = cArr2[i6 >> 4];
            i4 = i7 + 1;
            cArr[i7] = cArr2[i6 & 15];
        }
        return new String(cArr, 0, i3);
    }

    public static String toHexString(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bArr) {
            stringBuffer.append(String.format("%02x", Byte.valueOf(b)));
        }
        return stringBuffer.toString();
    }

    public static String getFileMD5Digest(File file) throws Throwable {
        FileInputStream fileInputStream;
        MessageDigest messageDigest;
        FileInputStream fileInputStream2 = null;
        if (file == null) {
            return null;
        }
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            fileInputStream = new FileInputStream(file);
        } catch (Exception e) {
            e = e;
            fileInputStream = null;
        } catch (Throwable th) {
            th = th;
            LiteCloseableUtil.closeQuietly(fileInputStream2);
            throw th;
        }
        try {
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int i = fileInputStream.read(bArr);
                    if (i != -1) {
                        messageDigest.update(bArr, 0, i);
                    } else {
                        String hexString = toHexString(messageDigest.digest());
                        LiteCloseableUtil.closeQuietly(fileInputStream);
                        return hexString;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
                LiteCloseableUtil.closeQuietly(fileInputStream2);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            LiteApiLogger.printStackTraceOnly(e);
            LiteCloseableUtil.closeQuietly(fileInputStream);
            return null;
        }
    }

    public static String getFileMD5Digest(String str) {
        return getFileMD5Digest(new File(str));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getPartOfFileMD5Digest(java.lang.String r8, long r9, long r11) throws java.lang.Throwable {
        /*
            java.io.File r0 = new java.io.File
            r0.<init>(r8)
            long r1 = r0.length()
            r3 = 0
            int r8 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            r1 = 0
            if (r8 <= 0) goto L75
            java.io.RandomAccessFile r8 = new java.io.RandomAccessFile     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L66
            java.lang.String r2 = "r"
            r8.<init>(r0, r2)     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L66
            int r2 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r2 < 0) goto L24
            long r5 = r0.length()     // Catch: java.lang.Exception -> L62 java.lang.Throwable -> L6f
            int r0 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
            if (r0 >= 0) goto L24
            goto L25
        L24:
            r9 = r3
        L25:
            r8.seek(r9)     // Catch: java.lang.Exception -> L62 java.lang.Throwable -> L6f
            r9 = 4096(0x1000, float:5.74E-42)
            byte[] r9 = new byte[r9]     // Catch: java.lang.Exception -> L62 java.lang.Throwable -> L6f
            java.lang.String r10 = "MD5"
            java.security.MessageDigest r10 = java.security.MessageDigest.getInstance(r10)     // Catch: java.lang.Exception -> L62 java.lang.Throwable -> L6f
            r0 = 0
            r2 = r0
        L34:
            long r3 = (long) r2     // Catch: java.lang.Exception -> L62 java.lang.Throwable -> L6f
            int r5 = (r3 > r11 ? 1 : (r3 == r11 ? 0 : -1))
            if (r5 >= 0) goto L56
            int r5 = r8.read(r9)     // Catch: java.lang.Exception -> L62 java.lang.Throwable -> L6f
            r6 = -1
            if (r5 == r6) goto L56
            if (r5 <= 0) goto L51
            int r6 = r2 + r5
            long r6 = (long) r6     // Catch: java.lang.Exception -> L62 java.lang.Throwable -> L6f
            int r6 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
            if (r6 <= 0) goto L51
            long r3 = r11 - r3
            int r3 = (int) r3     // Catch: java.lang.Exception -> L62 java.lang.Throwable -> L6f
            r10.update(r9, r0, r3)     // Catch: java.lang.Exception -> L62 java.lang.Throwable -> L6f
            int r2 = r2 + r3
            goto L34
        L51:
            r10.update(r9, r0, r5)     // Catch: java.lang.Exception -> L62 java.lang.Throwable -> L6f
            int r2 = r2 + r5
            goto L34
        L56:
            byte[] r9 = r10.digest()     // Catch: java.lang.Exception -> L62 java.lang.Throwable -> L6f
            java.lang.String r9 = toHexString(r9)     // Catch: java.lang.Exception -> L62 java.lang.Throwable -> L6f
            com.kwad.sdk.liteapi.utils.LiteCloseableUtil.closeQuietly(r8)
            return r9
        L62:
            r9 = move-exception
            goto L68
        L64:
            r9 = move-exception
            goto L71
        L66:
            r9 = move-exception
            r8 = r1
        L68:
            com.kwad.sdk.liteapi.LiteApiLogger.printStackTrace(r9)     // Catch: java.lang.Throwable -> L6f
            com.kwad.sdk.liteapi.utils.LiteCloseableUtil.closeQuietly(r8)
            goto L75
        L6f:
            r9 = move-exception
            r1 = r8
        L71:
            com.kwad.sdk.liteapi.utils.LiteCloseableUtil.closeQuietly(r1)
            throw r9
        L75:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.liteapi.utils.LiteMd5Util.getPartOfFileMD5Digest(java.lang.String, long, long):java.lang.String");
    }
}
