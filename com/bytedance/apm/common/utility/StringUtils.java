package com.bytedance.apm.common.utility;

import android.text.TextUtils;
import android.util.Base64;
import java.io.UnsupportedEncodingException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class StringUtils {
    public static final String EMPTY = "";
    private static final long G = 1073741824;

    /* renamed from: K, reason: collision with root package name */
    private static final long f750K = 1024;
    private static final long M = 1048576;
    private static final long T = 1099511627776L;
    private static final int XOR_MASK = 5;

    private StringUtils() {
    }

    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    public static boolean equal(String str, String str2) {
        return (isEmpty(str) && isEmpty(str2)) || (str != null && str.equals(str2));
    }

    public static String encryptWithXor(String str) throws UnsupportedEncodingException {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            byte[] bytes = str.getBytes("UTF-8");
            for (int i = 0; i < bytes.length; i++) {
                bytes[i] = (byte) (bytes[i] ^ 5);
            }
            return DigestUtils.toHexString(bytes, 0, bytes.length);
        } catch (Exception unused) {
            return str;
        }
    }

    public static String decryptWithXor(String str, Boolean... boolArr) {
        byte[] bArrHexStringToBytes;
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (boolArr != null && boolArr.length > 0 && boolArr[0].booleanValue()) {
                bArrHexStringToBytes = Base64.decode(str, 0);
            } else {
                bArrHexStringToBytes = DigestUtils.hexStringToBytes(str);
            }
            for (int i = 0; i < bArrHexStringToBytes.length; i++) {
                bArrHexStringToBytes[i] = (byte) (bArrHexStringToBytes[i] ^ 5);
            }
            return new String(bArrHexStringToBytes, 0, bArrHexStringToBytes.length, "UTF-8");
        } catch (Exception unused) {
            return str;
        }
    }
}
