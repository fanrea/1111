package com.bytedance.pangle.h.d;

import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class an {
    private int[] d;
    private int[] hc;

    public static an d(hc hcVar) throws IOException {
        hcVar.hc(1835009);
        int iHc = hcVar.hc();
        int iHc2 = hcVar.hc();
        int iHc3 = hcVar.hc();
        hcVar.hc();
        int iHc4 = hcVar.hc();
        int iHc5 = hcVar.hc();
        an anVar = new an();
        anVar.d = hcVar.d(iHc2);
        if (iHc3 != 0) {
            hcVar.d(iHc3);
        }
        int i = (iHc5 == 0 ? iHc : iHc5) - iHc4;
        if (i % 4 == 0) {
            anVar.hc = hcVar.d(i / 4);
            if (iHc5 != 0) {
                int i2 = iHc - iHc5;
                if (i2 % 4 == 0) {
                    hcVar.d(i2 / 4);
                } else {
                    throw new IOException();
                }
            }
            return anVar;
        }
        throw new IOException();
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
