package com.tencent.turingfd.sdk.ams.au;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class Mangosteen {
    public static final byte[] e = new byte[0];
    public final int a;
    public final int b;
    public final int c;
    public final byte[] d;

    public Mangosteen(int i, byte[] bArr, int i2, int i3) {
        this.a = i;
        this.d = bArr;
        this.b = i2;
        this.c = i3;
    }

    public static Mangosteen a(int i) {
        return new Mangosteen(i, e, 0, 0);
    }

    public static Mangosteen a(byte[] bArr) {
        return new Mangosteen(0, bArr, 0, 0);
    }
}
