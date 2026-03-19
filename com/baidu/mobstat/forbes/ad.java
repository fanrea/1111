package com.baidu.mobstat.forbes;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class ad {
    private static final byte[] a = {com.sigmob.sdk.archives.tar.e.H, 75, 97, 106, 68, com.sigmob.sdk.archives.tar.e.O, 65, 90, 99, 70, com.sigmob.sdk.archives.tar.e.J, 81, 110, 80, 114, com.sigmob.sdk.archives.tar.e.M, 102, 119, 105, 72, 82, 78, 121, com.sigmob.sdk.archives.tar.e.T, 109, 117, 112, 85, 84, 73, com.sigmob.sdk.archives.tar.e.S, com.sigmob.sdk.archives.tar.e.R, com.sigmob.sdk.archives.tar.e.N, 57, 66, 87, 98, 45, 104, 77, 67, 71, 74, 111, 95, 86, 56, 69, 115, 107, 122, com.sigmob.sdk.archives.tar.e.I, 89, 100, 118, com.sigmob.sdk.archives.tar.e.P, com.sigmob.sdk.archives.tar.e.f789K, com.sigmob.sdk.archives.tar.e.L, 108, 101, 116, 113, com.sigmob.sdk.archives.tar.e.Q, 79};
    private static final byte[] b = new byte[128];

    static {
        for (int i = 0; i < a.length; i++) {
            b[a[i]] = (byte) i;
        }
    }

    private static byte[] b(String str) {
        byte[] bArr;
        if (c(str) || str == null || str.length() < 4) {
            return null;
        }
        if (str.charAt(str.length() - 2) == '$') {
            bArr = new byte[(((str.length() / 4) - 1) * 3) + 1];
        } else if (str.charAt(str.length() - 1) == '$') {
            bArr = new byte[(((str.length() / 4) - 1) * 3) + 2];
        } else {
            bArr = new byte[(str.length() / 4) * 3];
        }
        int i = 0;
        int i2 = 0;
        while (i < str.length() - 4) {
            byte b2 = b[str.charAt(i)];
            byte b3 = b[str.charAt(i + 1)];
            byte b4 = b[str.charAt(i + 2)];
            byte b5 = b[str.charAt(i + 3)];
            bArr[i2] = (byte) ((b2 << 2) | (b3 >> 4));
            bArr[i2 + 1] = (byte) ((b3 << 4) | (b4 >> 2));
            bArr[i2 + 2] = (byte) ((b4 << 6) | b5);
            i += 4;
            i2 += 3;
        }
        if (str.charAt(str.length() - 2) == '$') {
            bArr[bArr.length - 1] = (byte) ((b[str.charAt(str.length() - 3)] >> 4) | (b[str.charAt(str.length() - 4)] << 2));
        } else if (str.charAt(str.length() - 1) == '$') {
            byte b6 = b[str.charAt(str.length() - 4)];
            byte b7 = b[str.charAt(str.length() - 3)];
            byte b8 = b[str.charAt(str.length() - 2)];
            bArr[bArr.length - 2] = (byte) ((b6 << 2) | (b7 >> 4));
            bArr[bArr.length - 1] = (byte) ((b8 >> 2) | (b7 << 4));
        } else {
            byte b9 = b[str.charAt(str.length() - 4)];
            byte b10 = b[str.charAt(str.length() - 3)];
            byte b11 = b[str.charAt(str.length() - 2)];
            byte b12 = b[str.charAt(str.length() - 1)];
            bArr[bArr.length - 3] = (byte) ((b9 << 2) | (b10 >> 4));
            bArr[bArr.length - 2] = (byte) ((b10 << 4) | (b11 >> 2));
            bArr[bArr.length - 1] = (byte) (b12 | (b11 << 6));
        }
        return bArr;
    }

    public static String a(String str) {
        if (str == null || str.length() < 4) {
            return null;
        }
        try {
            String str2 = new String(b(str));
            while (str2.endsWith(com.baidu.mobads.container.o.j.a)) {
                str2 = str2.substring(0, str2.length() - 1);
            }
            return str2;
        } catch (Exception e) {
            return "";
        }
    }

    private static boolean c(String str) {
        if (str == null) {
            return true;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!a((byte) str.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private static boolean a(byte b2) {
        if (b2 == 36) {
            return true;
        }
        return b2 >= 0 && b2 < 128 && b[b2] != -1;
    }
}
