package okhttp3.internal.http2;

import java.io.IOException;
import okio.ByteString;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class c {
    static final ByteString BI = ByteString.encodeUtf8("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
    private static final String[] BJ = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};
    static final String[] BK = new String[64];
    static final String[] BL = new String[256];

    static {
        int i = 0;
        int i2 = 0;
        while (true) {
            String[] strArr = BL;
            if (i2 >= strArr.length) {
                break;
            }
            strArr[i2] = okhttp3.internal.c.format("%8s", Integer.toBinaryString(i2)).replace(' ', '0');
            i2++;
        }
        String[] strArr2 = BK;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        for (int i3 = 0; i3 <= 0; i3++) {
            int i4 = iArr[i3];
            BK[i4 | 8] = BK[i4] + "|PADDED";
        }
        String[] strArr3 = BK;
        strArr3[4] = "END_HEADERS";
        strArr3[32] = "PRIORITY";
        strArr3[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        for (int i5 = 0; i5 < 3; i5++) {
            int i6 = iArr2[i5];
            for (int i7 = 0; i7 <= 0; i7++) {
                int i8 = iArr[i7];
                int i9 = i8 | i6;
                BK[i9] = BK[i8] + '|' + BK[i6];
                BK[i9 | 8] = BK[i8] + '|' + BK[i6] + "|PADDED";
            }
        }
        while (true) {
            String[] strArr4 = BK;
            if (i >= strArr4.length) {
                return;
            }
            if (strArr4[i] == null) {
                strArr4[i] = BL[i];
            }
            i++;
        }
    }

    private c() {
    }

    static IllegalArgumentException b(String str, Object... objArr) {
        throw new IllegalArgumentException(okhttp3.internal.c.format(str, objArr));
    }

    static IOException c(String str, Object... objArr) throws IOException {
        throw new IOException(okhttp3.internal.c.format(str, objArr));
    }

    static String a(boolean z, int i, int i2, byte b, byte b2) {
        String[] strArr = BJ;
        String str = b < strArr.length ? strArr[b] : okhttp3.internal.c.format("0x%02x", Byte.valueOf(b));
        String strA = a(b, b2);
        Object[] objArr = new Object[5];
        objArr[0] = z ? "<<" : ">>";
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = str;
        objArr[4] = strA;
        return okhttp3.internal.c.format("%s 0x%08x %5d %-13s %s", objArr);
    }

    private static String a(byte b, byte b2) {
        if (b2 == 0) {
            return "";
        }
        if (b != 2 && b != 3) {
            if (b == 4 || b == 6) {
                return b2 == 1 ? "ACK" : BL[b2];
            }
            if (b != 7 && b != 8) {
                String[] strArr = BK;
                String str = b2 < strArr.length ? strArr[b2] : BL[b2];
                if (b != 5 || (b2 & 4) == 0) {
                    return (b != 0 || (b2 & 32) == 0) ? str : str.replace("PRIORITY", "COMPRESSED");
                }
                return str.replace("HEADERS", "PUSH_PROMISE");
            }
        }
        return BL[b2];
    }
}
