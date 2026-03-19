package com.android.gdt.qone.t;

import android.util.Base64;
import com.android.gdt.qone.uin.U;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public abstract class a {
    public static String a(String str, String str2) {
        return new String(a(Base64.decode(str, 2), str2.getBytes("UTF-8"), 2), "UTF-8").trim();
    }

    public static String b(String str, String str2) {
        return Base64.encodeToString(a(str.getBytes("UTF-8"), str2.getBytes("UTF-8"), 1), 2);
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, int i) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        byte[] bArrB = U.b(i, bArr2, bArr2, bArr);
        if (bArrB != null) {
            return bArrB;
        }
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr2);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(i, secretKeySpec, ivParameterSpec);
        return cipher.doFinal(bArr);
    }
}
