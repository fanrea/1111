package com.baidu.mobads.container.nativecpu.a;

import android.text.TextUtils;
import android.util.Base64;
import com.alipay.sdk.m.n.d;
import com.baidu.mobads.container.util.bq;
import java.io.ByteArrayOutputStream;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class b {
    public static final String a = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAvz5XO+wDhxUaIDOtrp72fUeIfTYXUSkZXNbA0REQzFGXPFqeMvKEOacgixdfeb/1jWif6dE2pzX1kwMAaOCenIjP9MSw8ZRgR3bZmRq8IuiBPDLI68tFDE6jpA8WjTlcaSkBy06iPtPckAT3LQiPFQroz4Dsoxnrw1QFO82QyWoFfUhGZjj895BQSjfjJjZajOoEY6GBtcRmI30XlVUwMJT9JAqf8GjyvoOMDR3Tjp226UepBIF/NhJKMrW3M5a0SHWo6r+KiAuG6pSVCHPXdP6MaQ/6W2W62wxRqrf24hi407qyKOu4MiEAPbEP3UjdIV3AW1nADjUzg2nxSjRFKQIDAQAB";

    public static String a(String str, String str2) {
        byte[] bArrDoFinal;
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1PADDING");
            RSAPublicKey rSAPublicKey = (RSAPublicKey) a(str);
            cipher.init(1, rSAPublicKey);
            byte[] bytes = str2.getBytes("UTF-8");
            int iBitLength = (rSAPublicKey.getModulus().bitLength() / 8) - 11;
            int length = bytes.length;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int i = 0;
            int i2 = 0;
            while (true) {
                int i3 = length - i;
                if (i3 <= 0) {
                    break;
                }
                if (i3 > iBitLength) {
                    bArrDoFinal = cipher.doFinal(bytes, i, iBitLength);
                } else {
                    bArrDoFinal = cipher.doFinal(bytes, i, i3);
                }
                byteArrayOutputStream.write(bArrDoFinal, 0, bArrDoFinal.length);
                i2++;
                i = i2 * iBitLength;
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            String strEncodeToString = Base64.encodeToString(byteArray, 8);
            if (!TextUtils.isEmpty(strEncodeToString)) {
                strEncodeToString = strEncodeToString.replaceAll("\n|\r", "");
            }
            return strEncodeToString;
        } catch (Throwable th) {
            bq.a().a(th);
            return "";
        }
    }

    private static PublicKey a(String str) {
        try {
            return KeyFactory.getInstance(d.a).generatePublic(new X509EncodedKeySpec(Base64.decode(str, 2)));
        } catch (Throwable th) {
            bq.a().a(th);
            return null;
        }
    }
}
