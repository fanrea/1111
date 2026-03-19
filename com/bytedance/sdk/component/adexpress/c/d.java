package com.bytedance.sdk.component.adexpress.c;

import com.bytedance.sdk.component.utils.mq;
import com.sigmob.sdk.archives.tar.e;
import java.util.Arrays;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d {
    private static final byte[] d = {-119, 80, 78, 71, 13, 10, 26, 10};
    private static final byte[] hc = {97, 99, 84, e.P};

    public static boolean d(byte[] bArr) {
        try {
        } catch (Throwable th) {
            mq.d(th);
        }
        if (!d(bArr, d)) {
            return false;
        }
        int i = 8;
        while (i >= 0) {
            if (i + 12 > bArr.length) {
                break;
            }
            int iD = d(bArr, i);
            int i2 = i + 4;
            byte[] bArr2 = new byte[4];
            System.arraycopy(bArr, i2, bArr2, 0, 4);
            int i3 = i2 + 4;
            if (Arrays.equals(bArr2, hc)) {
                return true;
            }
            i = i3 + iD + 4;
        }
        return false;
    }

    private static boolean d(byte[] bArr, byte[] bArr2) {
        if (bArr.length < bArr2.length) {
            return false;
        }
        for (int i = 0; i < bArr2.length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    private static int d(byte[] bArr, int i) {
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }
}
