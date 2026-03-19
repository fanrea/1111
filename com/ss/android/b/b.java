package com.ss.android.b;

import com.alipay.sdk.m.u.i;
import com.bytedance.sdk.component.utils.mq;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class b {
    private static final char[] d = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String d(File file) {
        return d(file, 9, 8192L);
    }

    public static String d(File file, int i, long j) {
        if (file != null) {
            try {
                if (file.exists()) {
                    return hc(file, i, j);
                }
            } catch (Throwable th) {
                mq.d(th);
            }
        }
        return "";
    }

    public static int d(String str, File file) {
        return d(str, file, (hc) null);
    }

    public static int d(String str, File file, hc hcVar) {
        String strHc;
        if (str == null || str.length() == 0) {
            return 2;
        }
        try {
            if (hcVar != null) {
                if (hcVar.d() <= 0) {
                    try {
                        hcVar.hc();
                    } catch (Throwable unused) {
                    }
                    return 5;
                }
            } else if (file == null || !file.exists()) {
                return 5;
            }
            int i = -1;
            long j = -1;
            try {
                d dVarD = d(str);
                if (dVarD != null) {
                    if (dVarD.d > 1) {
                        return 3;
                    }
                    i = dVarD.b;
                    j = dVarD.c;
                }
                d dVarD2 = null;
                try {
                    if (hcVar != null) {
                        strHc = d(hcVar, i, j);
                    } else {
                        strHc = hc(file, i, j);
                    }
                } catch (Throwable th) {
                    mq.d(th);
                    strHc = null;
                }
                if (strHc != null && strHc.length() != 0) {
                    if (dVarD == null || (dVarD.d == 1 && dVarD.hc == 1)) {
                        if (strHc.equals(str)) {
                            return 0;
                        }
                    } else if (dVarD.u != null) {
                        try {
                            dVarD2 = d(strHc);
                        } catch (Throwable unused2) {
                        }
                        if (dVarD2 != null && dVarD.b == dVarD2.b && dVarD.c == dVarD2.c && dVarD.u.equals(dVarD2.u)) {
                            return 0;
                        }
                    }
                    return 1;
                }
                return 6;
            } catch (Throwable unused3) {
                return 4;
            }
        } catch (Throwable unused4) {
            return 99;
        }
    }

    private static String hc(File file, int i, long j) throws Exception {
        return d(new com.ss.android.b.d(file), i, j);
    }

    private static String d(hc hcVar, int i, long j) throws Exception {
        long j2;
        int i2 = i;
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        if (messageDigest == null) {
            return "";
        }
        try {
            long jD = hcVar.d();
            long j3 = 0;
            if (i2 <= 0 || j <= 0 || i2 * j > (8 * jD) / 10) {
                j2 = jD;
                i2 = 1;
            } else {
                j2 = j;
            }
            byte[] bArr = new byte[8192];
            d(hcVar, messageDigest, bArr, 0L, j2);
            if (i2 > 2) {
                int i3 = i2 - 1;
                long j4 = (jD - (i2 * j2)) / i3;
                int i4 = 1;
                while (i4 < i3) {
                    j3 += j2 + j4;
                    d(hcVar, messageDigest, bArr, j3, j2);
                    i4++;
                    i3 = i3;
                }
            }
            if (i2 > 1) {
                d(hcVar, messageDigest, bArr, jD - j2, j2);
            }
            String strD = d(messageDigest.digest());
            if (i2 == 1 && j2 == jD) {
                return strD;
            }
            String str = d(i2, j2) + i.b + strD;
            try {
                hcVar.hc();
            } catch (Throwable unused) {
            }
            return str;
        } finally {
            try {
                hcVar.hc();
            } catch (Throwable unused2) {
            }
        }
    }

    private static void d(hc hcVar, MessageDigest messageDigest, byte[] bArr, long j, long j2) throws IOException {
        hcVar.d(j, j2);
        long j3 = 0;
        while (j3 < j2) {
            int iD = hcVar.d(bArr, 0, (int) Math.min(j2 - j3, bArr.length));
            if (iD <= 0) {
                throw new IOException("updateSample unexpected readCount <= 0, readCount = " + iD + ", readTotalCount = " + j3 + ", sampleSize = " + j2);
            }
            messageDigest.update(bArr, 0, iD);
            j3 += iD;
        }
    }

    private static String d(byte[] bArr) {
        if (bArr == null) {
            throw new NullPointerException("bytes is null");
        }
        int length = bArr.length;
        int i = length * 2;
        char[] cArr = new char[i];
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = bArr[i3 + 0] & 255;
            int i5 = i2 + 1;
            char[] cArr2 = d;
            cArr[i2] = cArr2[i4 >> 4];
            i2 = i5 + 1;
            cArr[i5] = cArr2[i4 & 15];
        }
        return new String(cArr, 0, i);
    }

    private static String d(int i, long j) {
        return "ttmd5:1:1:" + d(i) + "g" + d(j);
    }

    private static d d(String str) throws Exception {
        if (!str.startsWith("ttmd5:")) {
            return null;
        }
        String[] strArrSplit = str.split(i.b);
        String[] strArrSplit2 = strArrSplit[0].split(":");
        d dVar = new d();
        dVar.d = Integer.parseInt(strArrSplit2[1]);
        if (dVar.d > 1) {
            return dVar;
        }
        dVar.hc = Integer.parseInt(strArrSplit2[2]);
        String[] strArrSplit3 = strArrSplit2[3].split("g");
        dVar.b = (int) hc(strArrSplit3[0]);
        dVar.c = hc(strArrSplit3[1]);
        dVar.u = strArrSplit[1];
        return dVar;
    }

    private static String d(long j) {
        return Long.toHexString((j << 4) + 31);
    }

    private static long hc(String str) throws RuntimeException {
        return (Long.parseLong(str, 16) - 31) >> 4;
    }

    private static class d {
        private int b;
        private long c;
        private int d;
        private int hc;
        private String u;

        private d() {
        }
    }
}
