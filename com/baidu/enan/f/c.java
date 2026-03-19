package com.baidu.enan.f;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public final class c {
    private static String a;

    private static String a() {
        return "";
    }

    private static String a(String str) {
        try {
            String str2 = new String(com.baidu.enan.b.a.b(Base64.decode(str, 10), "30212102dicudiab".getBytes()), "UTF-8");
            return !TextUtils.isEmpty(str2) ? str2 : "";
        } catch (Throwable th) {
            a.a(th);
            return "";
        }
    }

    private static String b() {
        return "";
    }

    private static String b(Context context) {
        String strA;
        String strB = "";
        try {
            strA = a();
        } catch (Throwable th) {
            th = th;
            strA = "";
        }
        try {
            strB = b();
        } catch (Throwable th2) {
            th = th2;
            a.a(th);
            return a((strA + strB + UUID.randomUUID().toString()).getBytes(), true);
        }
        return a((strA + strB + UUID.randomUUID().toString()).getBytes(), true);
    }

    public static synchronized String a(Context context) {
        try {
            if (!TextUtils.isEmpty(a)) {
                return a;
            }
            com.baidu.enan.d.a aVarA = com.baidu.enan.d.a.a(context);
            String strC = aVarA.c();
            if (!TextUtils.isEmpty(strC)) {
                try {
                    String strA = a(strC);
                    if (!TextUtils.isEmpty(strA)) {
                        a = strA;
                        return strA;
                    }
                } catch (Throwable th) {
                    a.a(th);
                }
            }
            String strA2 = aVarA.a();
            if (!TextUtils.isEmpty(strA2)) {
                aVarA.c(new String(Base64.encode(com.baidu.enan.b.a.a(strA2.getBytes("UTF-8"), "30212102dicudiab".getBytes()), 10), "UTF-8"));
                a = strA2;
                return strA2;
            }
            String strB = b(context);
            String strA3 = a();
            if (TextUtils.isEmpty(strA3)) {
                strA3 = "0";
            }
            String str = strB + "|" + new StringBuffer(strA3).reverse().toString();
            String str2 = new String(Base64.encode(com.baidu.enan.b.a.a(str.getBytes("UTF-8"), "30212102dicudiab".getBytes()), 10), "UTF-8");
            String strA4 = aVarA.a();
            if (TextUtils.isEmpty(strA4)) {
                aVarA.a(str);
                aVarA.c(str2);
                a = str;
                return str;
            }
            a = strA4;
            return strA4;
        } catch (Throwable th2) {
            a.a(th2);
            return "";
        }
    }

    private static String a(byte[] bArr, boolean z) throws NoSuchAlgorithmException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(bArr);
            return a(messageDigest.digest(), "", z);
        } catch (NoSuchAlgorithmException e) {
            a.a(e);
            return null;
        }
    }

    private static String a(byte[] bArr, String str, boolean z) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (z) {
                hexString = hexString.toUpperCase();
            }
            if (hexString.length() == 1) {
                sb.append("0");
            }
            sb.append(hexString).append(str);
        }
        return sb.toString();
    }
}
