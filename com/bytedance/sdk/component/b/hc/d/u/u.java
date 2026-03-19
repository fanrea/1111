package com.bytedance.sdk.component.b.hc.d.u;

import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class u {
    static final com.bytedance.sdk.component.b.d.an d = com.bytedance.sdk.component.b.d.an.d("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
    private static final String[] c = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};
    static final String[] hc = new String[64];
    static final String[] b = new String[256];

    static {
        int i = 0;
        int i2 = 0;
        while (true) {
            String[] strArr = b;
            if (i2 >= strArr.length) {
                break;
            }
            strArr[i2] = com.bytedance.sdk.component.b.hc.d.b.d("%8s", Integer.toBinaryString(i2)).replace(' ', '0');
            i2++;
        }
        String[] strArr2 = hc;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        for (int i3 = 0; i3 <= 0; i3++) {
            int i4 = iArr[i3];
            String[] strArr3 = hc;
            strArr3[i4 | 8] = strArr3[i4] + "|PADDED";
        }
        String[] strArr4 = hc;
        strArr4[4] = "END_HEADERS";
        strArr4[32] = "PRIORITY";
        strArr4[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        for (int i5 = 0; i5 < 3; i5++) {
            int i6 = iArr2[i5];
            for (int i7 = 0; i7 <= 0; i7++) {
                int i8 = iArr[i7];
                String[] strArr5 = hc;
                int i9 = i8 | i6;
                strArr5[i9] = strArr5[i8] + '|' + strArr5[i6];
                strArr5[i9 | 8] = strArr5[i8] + '|' + strArr5[i6] + "|PADDED";
            }
        }
        while (true) {
            String[] strArr6 = hc;
            if (i >= strArr6.length) {
                return;
            }
            if (strArr6[i] == null) {
                strArr6[i] = b[i];
            }
            i++;
        }
    }

    private u() {
    }

    static IllegalArgumentException d(String str, Object... objArr) {
        throw new IllegalArgumentException(com.bytedance.sdk.component.b.hc.d.b.d(str, objArr));
    }

    static IOException hc(String str, Object... objArr) throws IOException {
        throw new IOException(com.bytedance.sdk.component.b.hc.d.b.d(str, objArr));
    }

    static String d(boolean z, int i, int i2, byte b2, byte b3) {
        String[] strArr = c;
        String strD = b2 < strArr.length ? strArr[b2] : com.bytedance.sdk.component.b.hc.d.b.d("0x%02x", Byte.valueOf(b2));
        String strD2 = d(b2, b3);
        Object[] objArr = new Object[5];
        objArr[0] = z ? "<<" : ">>";
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = strD;
        objArr[4] = strD2;
        return com.bytedance.sdk.component.b.hc.d.b.d("%s 0x%08x %5d %-13s %s", objArr);
    }

    static String d(byte b2, byte b3) {
        if (b3 == 0) {
            return "";
        }
        if (b2 != 2 && b2 != 3) {
            if (b2 == 4 || b2 == 6) {
                return b3 == 1 ? "ACK" : b[b3];
            }
            if (b2 != 7 && b2 != 8) {
                String[] strArr = hc;
                String str = b3 < strArr.length ? strArr[b3] : b[b3];
                if (b2 != 5 || (b3 & 4) == 0) {
                    return (b2 != 0 || (b3 & 32) == 0) ? str : str.replace("PRIORITY", "COMPRESSED");
                }
                return str.replace("HEADERS", "PUSH_PROMISE");
            }
        }
        return b[b3];
    }
}
