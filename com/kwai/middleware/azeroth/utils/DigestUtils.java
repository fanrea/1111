package com.kwai.middleware.azeroth.utils;

import com.bytedance.common.utility.StringEncryptUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class DigestUtils {
    static final char[] HEX_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String toHexString(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new NullPointerException("bytes is null");
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

    public static byte[] hexStringToBytes(String str) {
        if (str == null || str.length() % 2 == 1) {
            throw new IllegalArgumentException("hexBinary needs to be even-length: " + str);
        }
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        byte[] bArr = new byte[length / 2];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) ((Character.digit(charArray[i], 16) << 4) + Character.digit(charArray[i + 1], 16));
        }
        return bArr;
    }

    public static String md5Hex(File file) throws NoSuchAlgorithmException, IOException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            if (messageDigest == null) {
                return null;
            }
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bArr = new byte[8192];
            while (true) {
                int i = fileInputStream.read(bArr, 0, 8192);
                if (i > 0) {
                    messageDigest.update(bArr, 0, i);
                } else {
                    fileInputStream.close();
                    byte[] bArrDigest = messageDigest.digest();
                    return toHexString(bArrDigest, 0, bArrDigest.length);
                }
            }
        } catch (Exception unused) {
            return null;
        }
    }

    public static String md5Hex(String str) {
        if (str == null) {
            return "";
        }
        try {
            if (str.length() == 0) {
                return "";
            }
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            if (messageDigest == null) {
                return null;
            }
            messageDigest.update(str.getBytes("UTF-8"));
            byte[] bArrDigest = messageDigest.digest();
            if (bArrDigest != null && bArrDigest.length > 0) {
                return toHexString(bArrDigest, 0, bArrDigest.length);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String sha1(String str) throws NoSuchAlgorithmException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(StringEncryptUtils.SHA_1);
            messageDigest.update(str.getBytes());
            byte[] bArrDigest = messageDigest.digest();
            return toHexString(bArrDigest, 0, bArrDigest.length);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String sha256(byte[] bArr) throws NoSuchAlgorithmException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(StringEncryptUtils.SHA_256);
            messageDigest.update(bArr);
            byte[] bArrDigest = messageDigest.digest();
            return toHexString(bArrDigest, 0, bArrDigest.length);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String md5Hex(byte[] bArr) {
        MessageDigest messageDigest;
        if (bArr != null) {
            try {
                if (bArr.length == 0 || (messageDigest = MessageDigest.getInstance("MD5")) == null) {
                    return null;
                }
                messageDigest.update(bArr);
                byte[] bArrDigest = messageDigest.digest();
                if (bArrDigest != null && bArrDigest.length > 0) {
                    return toHexString(bArrDigest, 0, bArrDigest.length);
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }
}
