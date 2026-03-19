package com.bytedance.adsdk.d.d.hc;

import android.text.TextUtils;
import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d extends u {
    private static ThreadLocal<byte[]> hc = new ThreadLocal<>();

    protected static byte[] d() {
        byte[] bArr = hc.get();
        if (bArr != null) {
            return bArr;
        }
        byte[] bArr2 = new byte[4];
        hc.set(bArr2);
        return bArr2;
    }

    public d(an anVar) {
        super(anVar);
    }

    public int hc() throws IOException {
        byte[] bArrD = d();
        d(bArrD, 0, 4);
        return ((bArrD[0] & 255) << 24) | (bArrD[3] & 255) | ((bArrD[2] & 255) << 8) | ((bArrD[1] & 255) << 16);
    }

    public short a_() throws IOException {
        byte[] bArrD = d();
        d(bArrD, 0, 2);
        return (short) (((bArrD[0] & 255) << 8) | (bArrD[1] & 255));
    }

    public boolean d(String str) throws IOException {
        if (TextUtils.isEmpty(str) || str.length() != 4) {
            return false;
        }
        int iB_ = b_();
        for (int i = 0; i < 4; i++) {
            if (((iB_ >> (i * 8)) & 255) != str.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public int b_() throws IOException {
        byte[] bArrD = d();
        d(bArrD, 0, 4);
        return ((bArrD[3] & 255) << 24) | (bArrD[0] & 255) | ((bArrD[1] & 255) << 8) | ((bArrD[2] & 255) << 16);
    }
}
