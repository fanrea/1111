package com.baidu.ad.magic.flute.a.a;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class i {
    public static final int a = 0;
    public static final int b = -1;
    public static final int c = 0;
    public static final int d = -100;
    public Exception e;
    private int f;
    private int g;

    public i(int i, int i2, Exception exc) {
        this.f = i;
        this.g = i2;
        this.e = exc;
    }

    public static i a(int i) {
        return new i(-1, i, null);
    }

    public static i a(Exception exc) {
        return new i(-1, 0, exc);
    }

    public static i c() {
        return new i(0, 0, null);
    }

    public static i d() {
        return a(0);
    }

    public int a() {
        return this.f;
    }

    public int b() {
        return this.g;
    }
}
