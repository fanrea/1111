package com.netease.htprotect.necrash.nis.p003O8oO888;

import android.util.Base64;
import com.alipay.sdk.m.n.d;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.netease.htprotect.necrash.nis.O8〇oO8〇88.O8〇oO8〇88, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class O8oO888 {
    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static String m543O8oO888(int i) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < i; i2++) {
            sb.append("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".charAt((int) Math.round(Math.random() * 61)));
        }
        return sb.toString();
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static String m544O8oO888(String str, String str2) throws InvalidKeySpecException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        try {
            PublicKey publicKeyGeneratePublic = KeyFactory.getInstance(d.a).generatePublic(new X509EncodedKeySpec(Base64.decode(str2, 2)));
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(1, publicKeyGeneratePublic);
            return new String(Base64.encode(cipher.doFinal(str.getBytes()), 2));
        } catch (Exception e) {
            o8o0.m579O8(e.getMessage());
            return null;
        }
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static String m545O8oO888(String str, String str2, String str3) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(1, secretKeySpec, new IvParameterSpec(str3.getBytes()));
        return new String(Base64.encode(cipher.doFinal(str.getBytes()), 2));
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static PublicKey m546O8oO888(String str) throws Exception {
        return KeyFactory.getInstance(d.a).generatePublic(new X509EncodedKeySpec(Base64.decode(str, 2)));
    }

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    private static String m547Ooo(String str, String str2, String str3) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(2, secretKeySpec, new IvParameterSpec(str3.getBytes()));
        return new String(cipher.doFinal(Base64.decode(str, 2)));
    }
}
