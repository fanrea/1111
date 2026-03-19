package com.baidu.ad.magic.flute.a.a;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class m {
    public static final int e = 0;
    public static final int f = -1;
    public static final int g = -2;
    public static final int h = -100;
    public String a;
    public int b;
    public Exception c;
    public Object d;

    public m(int i, String str, Exception exc) {
        this.b = i;
        this.a = str;
        this.c = exc;
    }

    public static m a(int i) {
        return new m(i, null, null);
    }

    public static m a(int i, Exception exc) {
        return new m(i, null, exc);
    }

    public static m a(Exception exc) {
        return new m(-1, null, exc);
    }

    public static m a(String str) {
        return new m(0, str, null);
    }

    public static m b() {
        return a(-1);
    }

    public boolean a() {
        return this.b == 0;
    }
}
