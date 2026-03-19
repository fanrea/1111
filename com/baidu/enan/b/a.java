package com.baidu.enan.b;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class a {
    public static byte[] a(byte[] bArr, byte[] bArr2) {
        return c(bArr2, bArr);
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) {
        return d(bArr2, bArr);
    }

    public static byte[] c(byte[] bArr, byte[] bArr2) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            byte[] bArr3 = new byte[16];
            for (int i = 0; i < 16; i++) {
                bArr3[i] = 0;
            }
            cipher.init(1, secretKeySpec, new IvParameterSpec(bArr3));
            byte[] bArrDoFinal = cipher.doFinal(bArr2);
            byte[] bArrB = c.b(bArr2);
            byte[] bArr4 = new byte[bArrDoFinal.length + bArrB.length];
            System.arraycopy(bArrDoFinal, 0, bArr4, 0, bArrDoFinal.length);
            System.arraycopy(bArrB, 0, bArr4, bArrDoFinal.length, bArrB.length);
            return bArr4;
        } catch (Throwable th) {
            com.baidu.enan.f.a.a(th);
            return null;
        }
    }

    public static byte[] d(byte[] bArr, byte[] bArr2) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            byte[] bArr3 = new byte[16];
            for (int i = 0; i < 16; i++) {
                bArr3[i] = 0;
            }
            cipher.init(2, secretKeySpec, new IvParameterSpec(bArr3));
            byte[] bArr4 = new byte[bArr2.length - 16];
            System.arraycopy(bArr2, 0, bArr4, 0, bArr2.length - 16);
            return cipher.doFinal(bArr4);
        } catch (Throwable th) {
            com.baidu.enan.f.a.a(th);
            return null;
        }
    }
}
