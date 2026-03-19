package com.bytedance.pangle.res.d;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class c {
    public static <T> T d(T t) {
        t.getClass();
        return t;
    }

    public static void d(InputStream inputStream, byte[] bArr) throws IOException {
        d(inputStream, bArr, 0, bArr.length);
    }

    public static void d(InputStream inputStream, byte[] bArr, int i, int i2) throws IOException {
        int iHc = hc(inputStream, bArr, i, i2);
        if (iHc != i2) {
            throw new EOFException("reached end of stream after reading " + iHc + " bytes; " + i2 + " bytes expected");
        }
    }

    public static int hc(InputStream inputStream, byte[] bArr, int i, int i2) throws IOException {
        d(inputStream);
        d(bArr);
        int i3 = 0;
        if (i2 < 0) {
            throw new IndexOutOfBoundsException(String.format("len (%s) cannot be negative", Integer.valueOf(i2)));
        }
        d(i, i + i2, bArr.length);
        while (i3 < i2) {
            int i4 = inputStream.read(bArr, i + i3, i2 - i3);
            if (i4 == -1) {
                break;
            }
            i3 += i4;
        }
        return i3;
    }

    public static void d(int i, int i2, int i3) {
        if (i < 0 || i2 < i || i2 > i3) {
            throw new IndexOutOfBoundsException(new StringBuilder().append(i).append(i2).append(i3).toString());
        }
    }
}
