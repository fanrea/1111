package com.baidu.ad.magic.flute.c.a.a;

import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;
import javax.crypto.NoSuchPaddingException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class e {
    final String a;
    final String b;
    final String c;
    final String d;

    private e(String str, String str2, String str3, String str4) {
        this.a = str + str2;
        this.b = str2.toUpperCase(Locale.ENGLISH);
        this.c = str3;
        this.d = str4;
    }

    public static e a(String str) throws NoSuchAlgorithmException {
        String[] strArrB = b(str);
        String str2 = strArrB[0];
        String str3 = strArrB[1];
        String str4 = strArrB[2];
        if (str3 != null && str3.length() == 0) {
            str3 = null;
        }
        if (str4 != null && str4.length() == 0) {
            str4 = null;
        }
        return new e(str2, "", str3, str4);
    }

    private static String[] b(String str) throws NoSuchAlgorithmException {
        if (str == null) {
            throw new NoSuchAlgorithmException("No transformation given");
        }
        String[] strArr = new String[3];
        StringTokenizer stringTokenizer = new StringTokenizer(str, "/");
        int i = 0;
        while (stringTokenizer.hasMoreTokens() && i < 3) {
            try {
                strArr[i] = stringTokenizer.nextToken().trim();
                i++;
            } catch (NoSuchElementException e) {
                throw new NoSuchAlgorithmException("Invalid transformation format:" + str);
            }
        }
        if (i == 0 || i == 2 || stringTokenizer.hasMoreTokens()) {
            throw new NoSuchAlgorithmException("Invalid transformation format:" + str);
        }
        if (strArr[0] == null || strArr[0].length() == 0) {
            throw new NoSuchAlgorithmException("Invalid transformation:algorithm not specified-" + str);
        }
        return strArr;
    }

    public void a(b bVar) throws NoSuchPaddingException, NoSuchAlgorithmException {
        if (this.c != null) {
            bVar.a(this.c);
        }
        if (this.d != null) {
            bVar.b(this.d);
        }
    }
}
