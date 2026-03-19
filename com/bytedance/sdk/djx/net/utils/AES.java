package com.bytedance.sdk.djx.net.utils;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class AES {
    private static final String sAlgorithm = "AES";
    private static final String sCharset = "utf-8";
    private static final String sTransformation = "AES/ECB/PKCS5Padding";

    public static byte[] encrypt(byte[] bArr, String str) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(), sAlgorithm);
            Cipher cipher = Cipher.getInstance(sTransformation);
            cipher.init(1, secretKeySpec);
            return cipher.doFinal(bArr);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static byte[] encrypt(String str, String str2) {
        try {
            return encrypt(str.getBytes(sCharset), str2);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static byte[] decrypt(String str, String str2) {
        try {
            return decrypt(str.getBytes(sCharset), str2);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static byte[] decrypt(byte[] bArr, String str) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(), sAlgorithm);
            Cipher cipher = Cipher.getInstance(sTransformation);
            cipher.init(2, secretKeySpec);
            return cipher.doFinal(bArr);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
