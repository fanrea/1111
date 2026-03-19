package com.qq.e.comm.plugin;

import android.text.TextUtils;
import java.io.IOException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class w extends te {
    private static ThreadLocal<byte[]> b = new ThreadLocal<>();

    protected static byte[] d() {
        byte[] bArr = b.get();
        if (bArr != null) {
            return bArr;
        }
        byte[] bArr2 = new byte[4];
        b.set(bArr2);
        return bArr2;
    }

    public int e() throws IOException {
        byte[] bArrD = d();
        read(bArrD, 0, 4);
        return ((bArrD[3] & 255) << 24) | (bArrD[0] & 255) | ((bArrD[1] & 255) << 8) | ((bArrD[2] & 255) << 16);
    }

    public int f() throws IOException {
        byte[] bArrD = d();
        read(bArrD, 0, 4);
        return ((bArrD[0] & 255) << 24) | (bArrD[3] & 255) | ((bArrD[2] & 255) << 8) | ((bArrD[1] & 255) << 16);
    }

    public short g() throws IOException {
        byte[] bArrD = d();
        read(bArrD, 0, 2);
        return (short) (((bArrD[0] & 255) << 8) | (bArrD[1] & 255));
    }

    public w(jv jvVar) {
        super(jvVar);
    }

    public boolean a(String str) throws IOException {
        if (TextUtils.isEmpty(str) || str.length() != 4) {
            return false;
        }
        int iE = e();
        for (int i = 0; i < 4; i++) {
            if (((iE >> (i * 8)) & 255) != str.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
