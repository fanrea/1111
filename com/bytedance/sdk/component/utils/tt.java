package com.bytedance.sdk.component.utils;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Collections;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class tt {
    private static final byte[] an;
    private static final byte[] b;
    private static final byte[] c;
    private static final byte[] d;
    private static final int h;
    private static final byte[] hc;
    private static final byte[] u;

    static {
        byte[] bArr = {-1, -40, -1};
        d = bArr;
        byte[] bArr2 = {-119, 80, 78, 71, 13, 10, 26, 10};
        hc = bArr2;
        byte[] bArr3 = {0, 0, 1, 0};
        b = bArr3;
        byte[] bArrD = d("BM");
        c = bArrD;
        u = d("GIF87a");
        an = d("GIF89a");
        h = ((Integer) Collections.max(Arrays.asList(Integer.valueOf(bArr.length), Integer.valueOf(bArr2.length), Integer.valueOf(bArr3.length), Integer.valueOf(bArrD.length), 6))).intValue();
    }

    public static int d() {
        return h;
    }

    public static final String d(byte[] bArr) {
        return hc(bArr) ? "jpeg" : b(bArr) ? "png" : c(bArr) ? "gif" : u(bArr) ? "bmp" : an(bArr) ? "ico" : "other";
    }

    private static boolean hc(byte[] bArr) {
        int length = bArr.length;
        byte[] bArr2 = d;
        return length >= bArr2.length && d(bArr, bArr2);
    }

    private static boolean b(byte[] bArr) {
        int length = bArr.length;
        byte[] bArr2 = hc;
        return length >= bArr2.length && d(bArr, bArr2);
    }

    private static boolean c(byte[] bArr) {
        return (bArr.length >= 6 && d(bArr, u)) || d(bArr, an);
    }

    private static boolean u(byte[] bArr) {
        int length = bArr.length;
        byte[] bArr2 = c;
        return length >= bArr2.length && d(bArr, bArr2);
    }

    private static boolean an(byte[] bArr) {
        int length = bArr.length;
        byte[] bArr2 = b;
        return length >= bArr2.length && d(bArr, bArr2);
    }

    private static boolean d(byte[] bArr, byte[] bArr2) {
        return d(bArr, bArr2, 0);
    }

    private static boolean d(byte[] bArr, byte[] bArr2, int i) {
        if (bArr2.length + i > bArr.length) {
            return false;
        }
        for (int i2 = 0; i2 < bArr2.length; i2++) {
            if (bArr[i + i2] != bArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    private static byte[] d(String str) {
        try {
            return str.getBytes("ASCII");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("ASCII not found!", e);
        }
    }
}
