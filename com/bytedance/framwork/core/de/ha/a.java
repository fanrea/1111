package com.bytedance.framwork.core.de.ha;

import android.text.TextUtils;
import android.util.Base64;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: DecodeUtils.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class a {
    public static String a(byte[] bArr, String str) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        String str2 = "";
        try {
            byte[] bArrDecode = Base64.decode(bArr, 0);
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            try {
                SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(), "AES");
                Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
                cipher.init(2, secretKeySpec);
                String str3 = new String(cipher.doFinal(bArrDecode));
                try {
                    int iIndexOf = str3.indexOf(com.baidu.mobads.container.o.j.a);
                    return iIndexOf != -1 ? str3.substring(0, iIndexOf) : str3;
                } catch (Exception unused) {
                    str2 = str3;
                    return str2;
                }
            } catch (Exception unused2) {
            }
        } catch (Exception unused3) {
            return "";
        }
    }
}
