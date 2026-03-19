package com.alipay.sdk.m.h;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class a extends com.alipay.sdk.m.g.a {
    public static final /* synthetic */ boolean d = true;

    public a(byte[] bArr) {
        super(bArr);
    }

    public static a a(String str, long j, b bVar, short s, e eVar) throws Exception {
        byte[] bArrA = com.alipay.sdk.m.g.c.a((byte) 1);
        boolean z = d;
        if (!z && bArrA.length != 1) {
            throw new AssertionError();
        }
        byte[] bArrA2 = com.alipay.sdk.m.g.c.a(str.charAt(0), str.charAt(1));
        if (!z && bArrA2.length != 2) {
            throw new AssertionError();
        }
        byte[] bArrA3 = com.alipay.sdk.m.g.c.a(j);
        if (!z && bArrA3.length != 8) {
            throw new AssertionError();
        }
        byte[] bArrB = com.alipay.sdk.m.g.c.b();
        if (!z && bArrB.length != 2) {
            throw new AssertionError();
        }
        bVar.a();
        byte[] bArrA4 = com.alipay.sdk.m.g.c.a(bVar.a);
        if (!z && bArrA4.length != 1) {
            throw new AssertionError();
        }
        byte[] bArrA5 = com.alipay.sdk.m.g.c.a(bVar.b);
        if (!z && bArrA5.length != 1) {
            throw new AssertionError();
        }
        byte[] bArr = (byte[]) bVar.c.clone();
        if (!z && bArr.length != (bVar.b & 255)) {
            throw new AssertionError();
        }
        byte[] bArrA6 = com.alipay.sdk.m.g.c.a(s);
        if (!z && bArrA6.length != 2) {
            throw new AssertionError();
        }
        byte[] bArrB2 = com.alipay.sdk.m.g.c.b();
        if (!z && bArrB2.length != 2) {
            throw new AssertionError();
        }
        eVar.a();
        byte[] bArrA7 = com.alipay.sdk.m.g.c.a(eVar.a);
        if (!z && bArrA7.length != 1) {
            throw new AssertionError();
        }
        byte[] bArr2 = (byte[]) eVar.b.clone();
        if (!z && bArr2.length != (eVar.a & 255)) {
            throw new AssertionError();
        }
        byte[] bArrC = com.alipay.sdk.m.g.c.c();
        if (z || bArrC.length == 4) {
            return new a(com.alipay.sdk.m.g.c.a(bArrA, bArrA2, bArrA3, bArrB, bArrA4, bArrA5, bArr, bArrA6, bArrB2, bArrA7, bArr2, bArrC));
        }
        throw new AssertionError();
    }

    public static a c() {
        try {
            return a(com.alipay.sdk.m.g.a.c, 0L, new c(""), (short) 0, new f());
        } catch (Exception unused) {
            return null;
        }
    }
}
