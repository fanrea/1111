package com.baidu.ad.magic.flute.c.b.a;

import java.math.BigInteger;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class e {
    private static byte[] a;
    private static byte[] b;

    static byte[] a() {
        if (a != null) {
            return a;
        }
        a = new BigInteger(c.a).modPow(new BigInteger(c.b), new BigInteger(c.e)).toByteArray();
        return a;
    }

    static byte[] b() {
        if (b != null) {
            return b;
        }
        b = new BigInteger(c.c).modPow(new BigInteger(c.d), new BigInteger(c.e)).toByteArray();
        return b;
    }
}
