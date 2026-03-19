package com.qq.e.comm.plugin;

import android.content.Context;
import android.content.pm.Signature;
import android.text.TextUtils;
import yaq.pro;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class a0 {
    private static volatile String a;
    private static final char[] b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String a(Signature[] signatureArr) {
        return (String) pro.getobjresult(299, 1, signatureArr);
    }

    private static String a(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        for (int i = 0; i < bArr.length; i++) {
            byte b2 = bArr[i];
            int i2 = i * 2;
            char[] cArr2 = b;
            cArr[i2] = cArr2[(b2 >>> 4) & 15];
            cArr[i2 + 1] = cArr2[b2 & 15];
        }
        return new String(cArr);
    }

    public static String a(Context context) {
        if (!TextUtils.isEmpty(a)) {
            return a;
        }
        try {
            a = a(context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures);
            return a;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }
}
