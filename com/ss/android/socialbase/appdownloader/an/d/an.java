package com.ss.android.socialbase.appdownloader.an.d;

import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class an {
    private int[] d;
    private int[] hc;

    public static an d(c cVar) throws IOException {
        hc.d(cVar, 1835009);
        int iHc = cVar.hc();
        int iHc2 = cVar.hc();
        int iHc3 = cVar.hc();
        cVar.hc();
        int iHc4 = cVar.hc();
        int iHc5 = cVar.hc();
        an anVar = new an();
        anVar.d = cVar.hc(iHc2);
        if (iHc3 != 0) {
            cVar.hc(iHc3);
        }
        int i = (iHc5 == 0 ? iHc : iHc5) - iHc4;
        if (i % 4 != 0) {
            throw new IOException("String data size is not multiple of 4 (" + i + ").");
        }
        anVar.hc = cVar.hc(i / 4);
        if (iHc5 != 0) {
            int i2 = iHc - iHc5;
            if (i2 % 4 != 0) {
                throw new IOException("Style data size is not multiple of 4 (" + i2 + ").");
            }
            cVar.hc(i2 / 4);
        }
        return anVar;
    }

    public String d(int i) {
        int[] iArr;
        if (i < 0 || (iArr = this.d) == null || i >= iArr.length) {
            return null;
        }
        int i2 = iArr[i];
        int iD = d(this.hc, i2);
        StringBuilder sb = new StringBuilder(iD);
        while (iD != 0) {
            i2 += 2;
            sb.append((char) d(this.hc, i2));
            iD--;
        }
        return sb.toString();
    }

    private an() {
    }

    private static final int d(int[] iArr, int i) {
        int i2 = iArr[i / 4];
        return (i % 4) / 2 == 0 ? i2 & 65535 : i2 >>> 16;
    }
}
