package com.alliance.ssp.ad.o0;

import android.util.Base64;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.aspectj.runtime.reflect.SignatureImpl;

/* compiled from: ADXUtil.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class a {
    public static String a(String str) throws IllegalStateException, NoSuchAlgorithmException, InvalidKeyException {
        String strSubstring;
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec("e7c43d1f0b2169f87f65582d8c46453d".getBytes(), "HmacSHA1");
            SecretKeySpec secretKeySpec2 = new SecretKeySpec("0eff60659338efa2b25b8668ce18c3fb".getBytes(), "HmacSHA1");
            byte[] bytes = "Fmcvv2OIv27cSSj4QBh".getBytes();
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.reset();
            mac.init(secretKeySpec);
            mac.update(bytes);
            byte[] bArrCopyOf = Arrays.copyOf(mac.doFinal(), 20);
            if (str.length() >= 8) {
                strSubstring = str.substring(0, 8);
            } else {
                String str2 = "";
                for (int i = 0; i < 8 - str.length(); i++) {
                    str2 = str2 + "0";
                }
                strSubstring = str2 + str;
            }
            byte[] bytes2 = strSubstring.getBytes();
            byte[] bArr = new byte[8];
            for (int i2 = 0; i2 < 8; i2++) {
                bArr[i2] = (byte) (bArrCopyOf[i2] ^ bytes2[i2]);
            }
            byte[] bArr2 = new byte[bytes.length + 8];
            System.arraycopy(bytes2, 0, bArr2, 0, 8);
            System.arraycopy(bytes, 0, bArr2, 8, bytes.length);
            mac.reset();
            mac.init(secretKeySpec2);
            mac.update(bArr2);
            byte[] bArrCopyOf2 = Arrays.copyOf(mac.doFinal(), 4);
            byte[] bArr3 = new byte[bytes.length + 12];
            System.arraycopy(bArr, 0, bArr3, 0, 8);
            System.arraycopy(bArrCopyOf2, 0, bArr3, 8, 4);
            System.arraycopy(bytes, 0, bArr3, 12, bytes.length);
            return new String(Base64.encode(bArr3, 0), "GBK").replace('+', SignatureImpl.SEP).replace('/', '_').replace("==", "").replace("=", "");
        } catch (Exception unused) {
            return null;
        }
    }
}
