package com.bytedance.framwork.core.de.ef;

/* compiled from: LocalLog.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class a {
    public long a;
    public String b;
    public String c;
    public String d;
    public String e;
    public long f;

    public a() {
    }

    public a(long j, String str) {
        this.a = j;
        this.e = str;
    }

    public a(String str, String str2, String str3, String str4, long j) {
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = str4;
        this.f = j;
    }

    public String toString() {
        return "LocalLog{id=" + this.a + ", aid=" + this.b + ", type='" + this.c + "', type2='" + this.d + "', data='" + this.e + "', createTime=" + this.f + '}';
    }
}
