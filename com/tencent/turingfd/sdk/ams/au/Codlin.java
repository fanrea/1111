package com.tencent.turingfd.sdk.ams.au;

import com.baidu.mobstat.forbes.Config;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class Codlin {
    public int a;
    public int b;
    public long c;
    public String d;
    public int e;
    public int f;

    public Codlin(int i, int i2, long j, String str, int i3, int i4) {
        this.a = i;
        this.b = i2;
        this.c = j;
        this.d = str;
        this.e = i3;
        this.f = i4;
    }

    public static Codlin a(int i) {
        return new Codlin(i, 100, -1L, "", -1, -2);
    }

    public String toString() {
        return this.a + Config.replace + this.b + Config.replace + this.c + Config.replace + this.e + Config.replace + this.d + Config.replace + this.f;
    }

    public static Codlin a(int i, int i2) {
        return new Codlin(i, 200, -1L, "", -1, i2);
    }
}
