package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: utfEncoding.kt */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public final class UtfEncodingKt {
    public static final byte[] stringsToBytes(String[] strArr) {
        int i;
        Intrinsics.checkNotNullParameter(strArr, "strings");
        int length = strArr.length;
        int i2 = 0;
        int length2 = 0;
        while (i2 < length) {
            String str = strArr[i2];
            i2++;
            length2 += str.length();
        }
        byte[] bArr = new byte[length2];
        int length3 = strArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length3) {
            String str2 = strArr[i3];
            i3++;
            int length4 = str2.length() - 1;
            if (length4 >= 0) {
                int i5 = 0;
                while (true) {
                    int i6 = i5 + 1;
                    i = i4 + 1;
                    bArr[i4] = (byte) str2.charAt(i5);
                    if (i5 == length4) {
                        break;
                    }
                    i5 = i6;
                    i4 = i;
                }
                i4 = i;
            }
        }
        return bArr;
    }
}
