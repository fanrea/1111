package com.qq.e.comm.plugin;

import android.util.Base64;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class hv {
    private static byte[] a(byte[] bArr, String str) throws BadPaddingException, InvalidKeySpecException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, IOException {
        byte[] bArrDoFinal;
        PublicKey publicKeyGeneratePublic = KeyFactory.getInstance(com.alipay.sdk.m.n.d.a).generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(1, publicKeyGeneratePublic);
        int length = bArr.length;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = length - i;
            if (i3 > 0) {
                if (i3 > 245) {
                    bArrDoFinal = cipher.doFinal(bArr, i, 245);
                } else {
                    bArrDoFinal = cipher.doFinal(bArr, i, i3);
                }
                byteArrayOutputStream.write(bArrDoFinal, 0, bArrDoFinal.length);
                i2++;
                i = i2 * 245;
            } else {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return byteArray;
            }
        }
    }

    public static String a(String str) {
        return a(str, "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAw41hNBphwAvvOJ5Ruzq1\rEYxmKXMh2cRtxu9RsZKcELezpJhjYB1IfqhE9rBJFL2gxk7cb9GrzuaeukXAL5uA\r3tYEbZ8q3oRE2faRmlsCByktcfT68ngsTk2arqBewBwcbgcjAPt/onySpsf9wKUg\rEhrWoeR92BPNCaVEWpBDqKcIgGDr/W4lpU8hmY9DYrv0BM8qpFYYDnr+AcrgREb4\rvPq+B06GUwTLVh/NAA4Afb7R1dDpxuXT2CMfX/2vPgWW+GiqAl8b1Q2CjGWL6PU/\rmcjJUwSycdsoRr+hVjIOMImNpDd8mON6zPsEccJMC/+srcRTjZn78zNtDeMtYiOt\rDwIDAQAB");
    }

    public static String a(String str, String str2) {
        byte[] bArrA = new byte[0];
        try {
            bArrA = a(str.getBytes(), str2);
        } catch (Exception e) {
            e.getMessage();
        }
        return Base64.encodeToString(bArrA, 2);
    }
}
