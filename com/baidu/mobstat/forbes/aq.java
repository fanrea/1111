package com.baidu.mobstat.forbes;

import java.io.ByteArrayOutputStream;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class aq {
    public static String a(byte[] bArr) {
        try {
            return ak.b(a(false, am.a(), bArr));
        } catch (Exception e) {
            return "";
        }
    }

    public static byte[] a(boolean z, byte[] bArr, byte[] bArr2) throws NoSuchAlgorithmException {
        return a(1, (Key) a(z, bArr), ((r1.getModulus().bitLength() + 1) / 8) - 11, bArr2);
    }

    private static RSAKey a(boolean z, byte[] bArr) throws NoSuchAlgorithmException {
        KeyFactory keyFactory = KeyFactory.getInstance(com.alipay.sdk.m.n.d.a);
        if (z) {
            return (RSAPrivateKey) keyFactory.generatePrivate(new PKCS8EncodedKeySpec(bArr));
        }
        return (RSAPublicKey) keyFactory.generatePublic(new X509EncodedKeySpec(bArr));
    }

    private static byte[] a(int i, Key key, int i2, byte[] bArr) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(i, key);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i3 = 0;
        while (i3 < bArr.length) {
            int length = bArr.length - i3;
            if (length > i2) {
                length = i2;
            }
            byteArrayOutputStream.write(cipher.doFinal(bArr, i3, length));
            i3 += i2;
        }
        return byteArrayOutputStream.toByteArray();
    }
}
