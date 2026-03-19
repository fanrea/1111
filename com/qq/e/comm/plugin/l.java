package com.qq.e.comm.plugin;

import android.text.TextUtils;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import yaq.pro;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class l {
    private static final String a = String.format("AES/%s/PKCS7Padding", "ECB");
    private static final String b;
    public static final String c;

    private static String a() {
        return (String) pro.getobjresult(300, 1, new Object[0]);
    }

    public static String a(String str) {
        return (String) pro.getobjresult(301, 1, str);
    }

    private static byte[] a(byte[] bArr) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException {
        return (byte[]) pro.getobjresult(302, 1, bArr);
    }

    public static String b(String str) {
        return (String) pro.getobjresult(303, 1, str);
    }

    private static byte[] b(byte[] bArr) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException {
        return (byte[]) pro.getobjresult(304, 1, bArr);
    }

    static {
        String strC = r1.d().f().c("cgiAesKeyVer");
        b = strC;
        if (TextUtils.isEmpty(strC)) {
            strC = "1";
        }
        c = strC;
    }
}
