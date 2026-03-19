package com.fendasz.moku.planet.utils;

import com.fendasz.moku.planet.utils.thirdparty.codec.DecoderException;
import com.fendasz.moku.planet.utils.thirdparty.codec.binary.Hex;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class AesUtil {
    private static final String PASSWORD = "833ca1994c666f368baac7d76bfecaf6";

    public static String encrypt(String str, String str2) {
        try {
            return encrypt(str, getKeyByPassword(str2), PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String encryptWithPassword(String str, String str2, String str3) {
        try {
            return encrypt(str, getKeyByPassword(str2), str3);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String decrypt(String str, String str2) {
        try {
            return decrypt(str, getKeyByPassword(str2), PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String getKeyByPassword(String str) throws Exception {
        return byteToHexString(Md5Utils.getMD5String(str).getBytes());
    }

    public static String encrypt(String str, String str2, String str3) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(hexStrToByte(str2), "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(1, secretKeySpec, new IvParameterSpec(hexStrToByte(str3)));
        return byteToHexString(cipher.doFinal(str.getBytes()));
    }

    private static String decrypt(String str, String str2, String str3) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(hexStrToByte(str2), "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(2, secretKeySpec, new IvParameterSpec(hexStrToByte(str3)));
        return new String(cipher.doFinal(hexStrToByte(str)));
    }

    private static String byteToHexString(byte[] bArr) {
        return Hex.encodeHexString(bArr);
    }

    private static byte[] hexStrToByte(String str) throws DecoderException {
        return Hex.decodeHex(str);
    }
}
